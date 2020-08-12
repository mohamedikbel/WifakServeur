package wifak.bank.spring.service;

import java.util.List;

import wifak.bank.spring.entities.User;

public interface UserServiceRemote {

	public List<User> getAll();
	public void add(User user);
	
}
