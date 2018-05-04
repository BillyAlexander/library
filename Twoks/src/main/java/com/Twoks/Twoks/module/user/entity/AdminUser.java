package com.Twoks.Twoks.module.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.Twoks.Twoks.utils.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "admin_user", uniqueConstraints = @UniqueConstraint(columnNames = "username", name = "admin_user_username_uk"))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AdminUser extends BaseEntity  {
	
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String username;

	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String password;

	@Column(name = "has_temp_password", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean hasTempPassword = false;

	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String names;

	@Column(name = "surnames", columnDefinition = "VARCHAR(100)", nullable = false)
	private String surnames;

	@Column(name = "cell_phone", columnDefinition = "VARCHAR(10)")
	private String cellPhone;

	@Column(name = "phone", columnDefinition = "VARCHAR(15)")
	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getHasTempPassword() {
		return hasTempPassword;
	}

	public void setHasTempPassword(Boolean hasTempPassword) {
		this.hasTempPassword = hasTempPassword;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}		

}
