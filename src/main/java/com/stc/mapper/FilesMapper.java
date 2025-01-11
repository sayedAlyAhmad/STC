package com.stc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.stc.dto.FilesDto;
import com.stc.entity.Files;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface FilesMapper extends BasicMapper<Files, FilesDto> {

}
