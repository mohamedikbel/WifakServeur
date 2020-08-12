package wifak.bank.spring.service.impl;

import java.io.BufferedReader;
import java.util.Date;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifak.bank.spring.dao.AccountRepository;
import wifak.bank.spring.entities.Account;
import wifak.bank.spring.entities.Ftp;
import wifak.bank.spring.service.AccountServiceRemote;

@Service
public class AccountService implements AccountServiceRemote {

	@Autowired
	AccountRepository accRepo;

	private FTPClient ftp;
	String directory = "src/main/resources/ftp/";

	public static String compconf;

	public String getCompconf() {
		return compconf;
	}

	public void setCompconf(String compconf) {
		this.compconf = compconf;
	}

	//****** this method is implemented to do the parsing for the CompConf file 
	@Override
	public boolean loadData(String path) {

		List<Account> lst = new ArrayList<Account>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String line = null;

			try {
				while ((line = br.readLine()) != null) {

					Account a = new Account();

					String MERCHANT_IDENTIFICATION = line.substring(0, 10).trim();

					String BATCH_IDENTIFICATION = line.substring(10, 16).trim();

					String INVOICE_NUMBER = line.substring(16, 22).trim();

					String CARDHOLDER_NUMBER = line.substring(22, 40).trim();

					String MERCHANT_SECTOR = line.substring(40, 42).trim();

					String CHANNEL_TRANSACTION_ID = line.substring(42, 43).trim();

					String OPERATION_CODE = line.substring(43, 44).trim();

					String TRANSACTION_CODE = line.substring(44, 46).trim();

					String TRANSACTION_AMOUNT = line.substring(46, 55).trim();

					String CARD_EXPIRY_DATE = line.substring(55, 59).trim();

					String PROCESSING_DATE = line.substring(59, 65).trim();

					String TRANSACTION_DATE = line.substring(65, 71).trim();

					String AUTHORIZATION_CODE = line.substring(71, 77).trim();

					String REMITTANCE_DATE = line.substring(77, 83).trim();

					String MERCHANT__CATEGORIE_CODE = line.substring(83, 87).trim();

					String ACQUIRER_BANK_IDENTIFICATION = line.substring(87, 94).trim();

					String LOCAL_CARD_SYSTEM_NETWORK = line.substring(94, 95).trim();

					String ISSUER_BANK_IDENTIFICATION = line.substring(95, 100).trim();

					String ACQUIRER_REFERENCE_NUMBER = line.substring(100, 123).trim();

					String TRANSACTION_ORDER_USAGE_CODE = line.substring(123, 125).trim();

					String TRANSACTION_REFERENCE_ID = line.substring(125, 150).trim();

					Calendar calendar = Calendar.getInstance();
					calendar.setTime(new Date(System.currentTimeMillis()));
					calendar.add(Calendar.DATE, -1);
					Date hier = calendar.getTime();

					a.setMerchantidentification(MERCHANT_IDENTIFICATION);
					a.setBatchidentification(BATCH_IDENTIFICATION);
					a.setInvoicenumber(INVOICE_NUMBER);
					a.setCardholdernumber(CARDHOLDER_NUMBER);
					a.setMerchantsector(MERCHANT_SECTOR);
					a.setChanneltransactionid(CHANNEL_TRANSACTION_ID);
					a.setOperationcode(OPERATION_CODE);
					a.setTransactioncode(TRANSACTION_CODE);
					a.setTransactionamount(TRANSACTION_AMOUNT);
					a.setCardexpirydate(CARD_EXPIRY_DATE);
					a.setProcessingdate(PROCESSING_DATE);
					a.setTransactiondate(TRANSACTION_DATE);
					a.setAuthorizationcode(AUTHORIZATION_CODE);
					a.setRemittancedate(REMITTANCE_DATE);
					a.setMerchantcategoriecode(MERCHANT__CATEGORIE_CODE);
					a.setAcquirerbankidentification(ACQUIRER_BANK_IDENTIFICATION);
					a.setLocalcardsystemnetwork(LOCAL_CARD_SYSTEM_NETWORK);
					a.setAcquirerbankidentification(ISSUER_BANK_IDENTIFICATION);
					a.setAcquirerreferencenumber(ACQUIRER_REFERENCE_NUMBER);
					a.setTransactionorderusagecode(TRANSACTION_ORDER_USAGE_CODE);
					a.setTransactionreferenceid(TRANSACTION_REFERENCE_ID);
					String uniqueidtrans = TRANSACTION_CODE + "_" + TRANSACTION_AMOUNT + "_" + AUTHORIZATION_CODE;
					a.setUniqueidtrans(uniqueidtrans);
					a.setCompconf(getCompconf());

					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -1);
					Date d = cal.getTime();

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String requiredDate = df.format(d).toString();
					a.setDate(requiredDate);

					SimpleDateFormat formater = null;

					lst.add(a);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (Account p : lst) {
			System.out.println(p);

			if (accRepo.existsByUniqueidtrans(p.getUniqueidtrans())) {
				return false;
			}
			accRepo.save(p);
		}

		return true;
	}

	//************** this method is used to get the Compconf file from the ftp server
	@Override
    public String downloadComp(Ftp f) throws SocketException, IOException {

		ftp = new FTPClient();

		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

		ftp.connect(f.getServerName(), f.getPort());
		int reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
		}

		ftp.login(f.getUserName(), f.getPasswrd());


		this.ftp.enterLocalPassiveMode();
		this.ftp.setAutodetectUTF8(true);
		this.ftp.enterLocalPassiveMode();
		this.ftp.changeWorkingDirectory("/Sauve/ENVOI/");

		String[] names = ftp.listNames();
		String name;
		for (int i = 0; i < names.length; i++) {
			name = names[i];
			if (name.contains("COMPCONF")) {

				String numberOnly = name.replaceAll("[^0-9]", "");

				this.setCompconf(numberOnly);

				System.out.println(name);
				FileOutputStream out = new FileOutputStream(directory + name);

				ftp.retrieveFile(name, out);

				return directory + name;

			}

		}

		return "";

	}

	@Override
	public List<Account> findByAuthorizationcode(String Code) {

		Account account = new Account();

		List<Account> result = new ArrayList<>();

		account = accRepo.findByAuthorizationcode(Code);

		result.add(account);
		return result;
	}

	@Override
	public List<Account> getallaccounts() {
		return (List<Account>) accRepo.findAll();
	}

}
