package wifak.bank.spring.dao;

import org.springframework.data.repository.CrudRepository;

import wifak.bank.spring.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

	User findByUsername(String username);

}
