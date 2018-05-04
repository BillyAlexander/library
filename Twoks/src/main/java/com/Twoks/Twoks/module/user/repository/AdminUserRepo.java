package com.Twoks.Twoks.module.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Twoks.Twoks.module.user.entity.AdminUser;

@Repository
public interface AdminUserRepo extends JpaRepository<AdminUser, Long> {
	
	public AdminUser findByUsernameIgnoreCase(String username);

}
