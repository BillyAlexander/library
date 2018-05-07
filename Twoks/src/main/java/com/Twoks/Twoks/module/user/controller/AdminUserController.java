package com.Twoks.Twoks.module.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Twoks.Twoks.module.user.entity.AdminUser;
import com.Twoks.Twoks.module.user.service.AdminUserService;
import com.Twoks.Twoks.utils.base.error.ErrorControl;
import com.Twoks.Twoks.utils.constants.Constants;

@RestController
@RequestMapping(value = Constants.APP + "api/adminUser", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	@RequestMapping(value = "getAllAdminUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAdminUser() {
		List<AdminUser> adminUsers = adminUserService.getAllAdminUsers();
		return new ResponseEntity<List<AdminUser>>(adminUsers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "saveAdminUser", method = RequestMethod.POST)
	public ResponseEntity<?> saveAdminUser(@RequestBody AdminUser newUser) {
		try {			
			return new ResponseEntity<AdminUser>(adminUserService.saveUser(newUser), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorControl(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@RequestMapping(value = "deleteAdminUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteAdminUser(@PathVariable Long id) {
		try {			
			adminUserService.deleteUserById(id);
			return new ResponseEntity<AdminUser>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorControl(e.getMessage(),true), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}	
}
