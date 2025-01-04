package com.example.sharebite.mapper;

import com.example.sharebite.dto.AddressDTO;
import com.example.sharebite.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressDTO addressDTO);

    AddressDTO toDto(Address address);
}
