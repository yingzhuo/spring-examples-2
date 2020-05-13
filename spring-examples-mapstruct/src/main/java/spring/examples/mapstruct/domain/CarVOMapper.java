package spring.examples.mapstruct.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CarVOMapper {

    @Mappings({
            @Mapping(source = "seatCount", target = "numberOfSeats")
    })
    public Car to(CarVO vo);

}
