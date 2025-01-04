package com.example.sharebite.mapper;

import com.example.sharebite.dto.PincodeDTO;
import com.example.sharebite.entity.Pincode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PincodeMapper {

    Pincode toEntity(PincodeDTO pincodeDTO);

    PincodeDTO toDTO(Pincode pincode);
}
