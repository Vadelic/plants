package com.vadelic.plants.service;

import com.vadelic.plants.dto.FlowerPotDTO;
import com.vadelic.plants.entity.FlowerPot;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Component
public class DTOMappingService {
    final ModelMapper modelMapper;

    public DTOMappingService() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
//                .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(new PropertyMap<FlowerPot, FlowerPotDTO>() {
            @Override
            protected void configure() {
                using(context -> ((FlowerPot) context.getSource()).getPlant().getName()).map(source).setName(null);
            }

            private static Converter<FlowerPot, String> getObjectObjectConverter() {
                return context -> context.getSource().getPlant().getName();
            }
        });


    }


    public <D> List<D> map(List<?> source, Class<D> destinationType) {
        return source.stream()
                .map(obj -> this.map(obj, destinationType))
                .collect(toList());
    }

    public <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}
