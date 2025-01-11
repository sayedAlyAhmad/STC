package com.stc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stc.PlayLoad.ListResponse;
import com.stc.dto.UserAppDto;
import com.stc.entity.UserApp;
import com.stc.serviceimpl.UserAppServiceImpl;

@RestController
@RequestMapping("${api.prefix.stc}" + "/user")
public class UserAppontroller {

	@Autowired
	UserAppServiceImpl userAppServiceImpl;

	@GetMapping
	public ListResponse<UserAppDto> getAll() {
		return userAppServiceImpl.getAll();
	}

	@GetMapping("/{id}")
	public UserAppDto getById(@PathVariable(value = "id") Long id) {
		return userAppServiceImpl.getById(id);
	}

//	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	@PostMapping
	public UserAppDto save(@RequestBody UserAppDto userAppDto) throws  ParseException {
		return userAppServiceImpl.save(userAppDto);
	}

// 	@RequestMapping(value = "/role/{roleName}", produces = "application/json", method = RequestMethod.PATCH)
//	public ResponseEntity<UserAppDto> addRoleForAllUsers(@PathVariable String roleName) {
//	System.out.println("HHHHHHHHHHHHHHHHHHh");
//		userAppServiceImpl.addRoleForAllUsers(roleName);
//		return ResponseEntity.ok(null);
//	}

}
