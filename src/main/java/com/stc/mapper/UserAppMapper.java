package com.stc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.stc.dto.UserAppDto;
import com.stc.entity.UserApp;
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface UserAppMapper extends BasicMapper<UserApp, UserAppDto>{

}
