package com.stc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAppDto {
    private Long id;
    private String fullName;
    private String userName;
    private String password;
//	List<RoleAppDto> roleApp;
    
    


}
