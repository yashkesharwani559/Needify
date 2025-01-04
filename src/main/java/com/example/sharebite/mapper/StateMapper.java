package com.example.sharebite.mapper;

import com.example.sharebite.dto.StateDTO;
import com.example.sharebite.entity.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {
    State toEntity(StateDTO stateDTO);

    StateDTO toDto(State state);
}
