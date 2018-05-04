package com.Twoks.Twoks.module.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Twoks.Twoks.module.user.entity.AdminUser;
import com.Twoks.Twoks.module.user.repository.AdminUserRepo;
import com.Twoks.Twoks.utils.base.service.BaseService;

@Service
public class AdminUserService extends BaseService<AdminUser> {

	public AdminUserService() {
		super(AdminUser.class);
	}
	
	@Autowired
	private AdminUserRepo adminUserRepo;
	
	public AdminUserRepo getAdminUserRepo() {
		return adminUserRepo;
	}

	public List<AdminUser> getAllAdminUsers() {
		
		List<AdminUser> adminUsers = adminUserRepo.findAll();		
		return adminUsers;
	}

}
