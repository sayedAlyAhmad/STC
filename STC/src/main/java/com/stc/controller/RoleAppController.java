package com.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.PlayLoad.ListResponse;
import com.stc.dto.RoleAppDto;
import com.stc.serviceimpl.RoleAppServiceImpl;

@RestController
@RequestMapping("${api.prefix.stc}" + "/role")
public class RoleAppController {
	@Autowired
	RoleAppServiceImpl roleAppServiceImpl;
	@GetMapping
	public ListResponse<RoleAppDto> getAll(){
		return roleAppServiceImpl.getAll();
	}
	
	@PostMapping
	public RoleAppDto save(@RequestBody RoleAppDto roleAppDto) {
		return roleAppServiceImpl.save(roleAppDto);
	}
	
	@GetMapping("/{id}")
	public RoleAppDto getById(@PathVariable(value = "id") Long id) {
		return roleAppServiceImpl.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value = "id") Long id) {
		roleAppServiceImpl.delete(id);
	}
	
	@PatchMapping("/{id}")
	public RoleAppDto update( @RequestBody RoleAppDto roleAppDto, @PathVariable(value = "id") Long id) throws Exception {
		return roleAppServiceImpl.update(roleAppDto, id);
	}
	

}
