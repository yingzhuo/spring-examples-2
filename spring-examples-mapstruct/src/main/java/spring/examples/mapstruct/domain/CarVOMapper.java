package spring.examples.mapstruct.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper
public interface CarVOMapper {

    @Mappings({
            @Mapping(source = "seatCount", target = "numberOfSeats")
    })
    public Car to(CarVO vo);

    @Mappings({
            @Mapping(source = "seatCount", target = "numberOfSeats")
    })
    public void copyTo(CarVO vo, @MappingTarget Car car);

}
