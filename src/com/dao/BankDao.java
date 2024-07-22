package com.dao;

import java.sql.SQLException;

public interface BankDao {
	

	int addNewUser();

	int updateUserDetails();

	int removeUser();

	void showAllAccounts();
}
