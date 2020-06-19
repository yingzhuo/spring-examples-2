package spring.examples.mapstruct.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Mapper
public interface CarVOMapper {

    public static final CarVOMapper INSTANCE = Mappers.getMapper(CarVOMapper.class);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    public Car to(CarVO vo);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    public void copyTo(CarVO vo, @MappingTarget Car car);

    // for ConversionService
    @Component
    public static class C1 implements Converter<CarVO, Car> {
        @Override
        public Car convert(CarVO source) {
            return INSTANCE.to(source);
        }
    }

}
