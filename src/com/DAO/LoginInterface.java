package com.DAO;

public interface LoginInterface {
	public boolean validate(int empId, String pass);
	public boolean isAdmin(int empId);
}
