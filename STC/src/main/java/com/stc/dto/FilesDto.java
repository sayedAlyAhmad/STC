package com.stc.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class FilesDto {
	private Long id;
	private String name;
	private String type;
	private byte[] data;


}
