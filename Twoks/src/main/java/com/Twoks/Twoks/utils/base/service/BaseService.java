package com.Twoks.Twoks.utils.base.service;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;

public abstract class BaseService<ENTITY> {
	
	private Class<ENTITY> type;

	public BaseService(Class<ENTITY> type) {
		this.type = type;
	}

	public ENTITY changeStatus(ENTITY obj) throws ServletException {
		try {
			Method getStatus = this.type.getMethod("getStatus");
			Method setStatus = this.type.getMethod("setStatus", Boolean.class);
			Boolean status = (Boolean) getStatus.invoke(obj);
			setStatus.invoke(obj, !status);
			return obj;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	public ENTITY changeStatus(ENTITY obj, Boolean status) throws ServletException {
		try {
			Method setStatus = this.type.getMethod("setStatus", Boolean.class);
			setStatus.invoke(obj, status);
			return obj;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	public ENTITY changeStatusRecursively(ENTITY obj) throws ServletException {
		try {
			Method getStatus = this.type.getMethod("getStatus");
			Boolean status = (Boolean) getStatus.invoke(obj);
			obj = doRecursively(obj, !status);
			return obj;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private ENTITY doRecursively(ENTITY obj, Boolean status) throws ServletException {
		try {
			Method[] entityMethods = this.type.getMethods();
			Method get = null;
			for (Method method : entityMethods) {
				if (method.getGenericReturnType().toString().equals(List.class.getName()
						+ "<"
						+ this.type.getName()
						+ ">")) {
					get = method;
					break;
				}
			}
			if (get == null) {
				throw new ServletException("No tree structure defined!");
			}
			obj = this.changeStatus(obj, status);
			List<ENTITY> children = (List<ENTITY>) get.invoke(obj);
			for (ENTITY child : children) {
				child = this.doRecursively(child, status);
			}
			return obj;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	public Class<ENTITY> getType() {
		return type;
	}

	public void setType(Class<ENTITY> type) {
		this.type = type;
	}

}
