package com.stc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.stc.dto.RoleAppDto;
import com.stc.entity.RoleApp;
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface RoleAppMapper extends BasicMapper<RoleApp, RoleAppDto> {

}
