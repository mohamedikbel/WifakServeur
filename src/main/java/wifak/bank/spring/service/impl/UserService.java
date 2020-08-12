package wifak.bank.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifak.bank.spring.dao.UserRepository;
import wifak.bank.spring.entities.User;
import wifak.bank.spring.service.UserServiceRemote;

@Service
public class UserService implements UserServiceRemote  {

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		}
   }
