package com.example.sharebite.mapper;

import com.example.sharebite.dto.CityDTO;
import com.example.sharebite.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityDTO toDTO(City city);
    City toEntity(CityDTO cityDTO);
}
