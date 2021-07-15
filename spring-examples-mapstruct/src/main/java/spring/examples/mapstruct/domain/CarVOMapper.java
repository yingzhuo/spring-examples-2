package spring.examples.mapstruct.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CarVOMapper extends Converter<CarVO, Car> {

    @Override
    @Mapping(source = "seatCount", target = "numberOfSeats")
    public Car convert(CarVO vo);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    public void copyTo(CarVO vo, @MappingTarget Car car);

}
