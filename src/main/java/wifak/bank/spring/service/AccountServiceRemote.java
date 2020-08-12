package wifak.bank.spring.service;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;

import wifak.bank.spring.entities.Account;
import wifak.bank.spring.entities.Ftp;

public interface AccountServiceRemote {

	public boolean  loadData(String path) ;
	public String downloadComp(Ftp f) throws SocketException, IOException ;
	public List<Account>  findByAuthorizationcode(String Code) ;  
	public List<Account>  getallaccounts();

}
