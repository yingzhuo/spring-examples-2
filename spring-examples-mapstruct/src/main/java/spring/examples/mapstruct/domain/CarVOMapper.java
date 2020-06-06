package spring.examples.mapstruct.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarVOMapper {

    public static final CarVOMapper INSTANCE = Mappers.getMapper(CarVOMapper.class);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    public Car to(CarVO vo);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    public void copyTo(CarVO vo, @MappingTarget Car car);

}
