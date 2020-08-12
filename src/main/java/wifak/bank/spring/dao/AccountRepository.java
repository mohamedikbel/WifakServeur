package wifak.bank.spring.dao;

import org.springframework.data.repository.CrudRepository;

import wifak.bank.spring.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	public Account findByAuthorizationcode(String Code);

	public boolean existsByUniqueidtrans(String uniqueCode);

}
