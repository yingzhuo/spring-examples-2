package spring.examples.mapstruct.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CarVOMapper extends Converter<CarVO, Car> {

    public static final CarVOMapper INSTANCE = Mappers.getMapper(CarVOMapper.class);

    @Override
    @Mapping(source = "seatCount", target = "numberOfSeats")
    public Car convert(CarVO vo);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    public void copyTo(CarVO vo, @MappingTarget Car car);

}
