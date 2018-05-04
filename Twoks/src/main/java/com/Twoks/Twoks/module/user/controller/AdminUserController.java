package com.Twoks.Twoks.module.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Twoks.Twoks.module.user.entity.AdminUser;
import com.Twoks.Twoks.module.user.service.AdminUserService;

@RestController
@RequestMapping(value = "api/adminUser", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminUserController {
	
	@Autowired
	private AdminUserService adminUserService;

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}
	
	@RequestMapping(value = "getAllAdminUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAdminUser(){
		List<AdminUser> adminUsers = adminUserService.getAllAdminUsers();
		return new ResponseEntity<List<AdminUser>>(adminUsers,HttpStatus.OK);
	}

}
