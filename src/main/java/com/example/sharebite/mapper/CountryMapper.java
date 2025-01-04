package com.example.sharebite.mapper;

import com.example.sharebite.dto.CountryDTO;
import com.example.sharebite.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryDTO countryDTO);

    CountryDTO toDto(Country country);
}
