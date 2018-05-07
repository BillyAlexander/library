package com.Twoks.Twoks.utils.base.error;

public class ErrorControl {
	private String message;

	private boolean isCustom;

	public ErrorControl(String message) {
		this.message = message;
		this.isCustom = false;
	}

	public ErrorControl(String message, boolean isCustom) {
		this.message = message;
		this.isCustom = isCustom;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isCustom() {
		return isCustom;
	}

	public void setCustom(boolean isCustom) {
		this.isCustom = isCustom;
	}

}
