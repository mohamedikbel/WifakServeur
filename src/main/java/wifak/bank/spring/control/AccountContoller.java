package wifak.bank.spring.control;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wifak.bank.spring.entities.Account;
import wifak.bank.spring.entities.Ftp;
import wifak.bank.spring.service.impl.AccountService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountContoller {

	@Autowired
	AccountService aser;

	@PostMapping("/loaddata")
	public Boolean add(@ModelAttribute Ftp f) throws SocketException, IOException {

		String path = aser.downloadComp(f);

		if (aser.loadData(path)) {
			return true;
		}

		else
			return false;

	}

	@GetMapping("/retrieve-transaction/{Authorizationcode}")
	@ResponseBody
	public List<Account> retrieveTransaction(@PathVariable("Authorizationcode") String code) {

		return aser.findByAuthorizationcode(code);

	}

	@GetMapping("/retrieve-transactions")
	@ResponseBody
	public List<Account> retrieveTransactions() {

		return aser.getallaccounts();

	}
	
        @GetMapping("/get-content")
	@ResponseBody
	public ArrayList<String> retrievecontnet() {

		File f = new File("./src/main/resources");
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		
		return names;

	}

}
