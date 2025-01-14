package com.example.sharebite.mapper;

import com.example.sharebite.dto.ContributorDTO;
import com.example.sharebite.entity.Contributor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContributorMapper {
    ContributorDTO toDTO(Contributor contributor);

    Contributor toEntity(ContributorDTO contributorDTO);
}
