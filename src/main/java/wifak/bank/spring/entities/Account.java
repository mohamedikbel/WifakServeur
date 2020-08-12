package wifak.bank.spring.entities;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "transaction")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private String id ;


	private String  merchantidentification;
	
	
	private String 	batchidentification ;
	
	private String  invoicenumber;
	
	private String  cardholdernumber;
	
	private String merchantsector ;
	
	private String channeltransactionid ;
	
	private String operationcode ;
	
	private String transactioncode ;
	
	private String transactionamount ;
	
	private String cardexpirydate ;
	
	private String processingdate ;
	
	private String transactiondate;
	
	private String authorizationcode;
	
	private String remittancedate ;
	
	private String merchantcategoriecode;
		
	private String acquirerbankidentification ;
	
	private String localcardsystemnetwork;
	
	private String issuerbankidentification ;
	
	private String acquirerreferencenumber ;
	
	private String transactionorderusagecode;
	
	private String transactionreferenceid ;
    
	private String  date ;
	
	private String compconf;
		
	@Indexed(unique = true)
	private String  uniqueidtrans;
	
	
	
	
	public String getCompconf() {
		return compconf;
	}


	public void setCompconf(String compconf) {
		this.compconf = compconf;
	}


	public String getUniqueidtrans() {
		return uniqueidtrans;
	}


	public void setUniqueidtrans(String uniqueidtrans) {
		this.uniqueidtrans = uniqueidtrans ;
	}


	public Account(String id, String merchant_identification, String batch_identification, String invoice_number,
			String cardholder_number, String merchant_sector, String channel_transaction_id, String operation_code,
			String transaction_code, String transaction_amount, String card_expiry_date, String processing_date,
			String transaction_date, String authorization_code, String remittance_date, String merchant__categorie_code,
			String acquirer_bank_identification, String local_card_system_network, String issuer_bank_identification,
			String acquirer_reference_number, String transaction_order_usage_code, String transaction_reference_id,
			String date ,String  uniqueidtrans ,String compconf) {
		super();
		this.id = id;
		this.merchantidentification = merchant_identification;
		this.batchidentification = batch_identification;
		this.invoicenumber = invoice_number;
		this.cardholdernumber = cardholder_number;
		this.merchantsector = merchant_sector;
		this.channeltransactionid = channel_transaction_id;
		this.operationcode = operation_code;
		this.transactioncode = transaction_code;
		this.transactionamount = transaction_amount;
		this.cardexpirydate = card_expiry_date;
		this.processingdate = processing_date;
		this.transactiondate = transaction_date;
		this.authorizationcode = authorization_code;
		this.remittancedate = remittance_date;
		this.merchantcategoriecode = merchant__categorie_code;
		this.acquirerbankidentification = acquirer_bank_identification;
		this.localcardsystemnetwork = local_card_system_network;
		this.issuerbankidentification = issuer_bank_identification;
		this.acquirerreferencenumber = acquirer_reference_number;
		this.transactionorderusagecode = transaction_order_usage_code;
		this.transactionreferenceid = transaction_reference_id;
		this.date = date;
		this.uniqueidtrans=  uniqueidtrans;
		this.compconf = compconf;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", merchant_identification=" + merchantidentification + ", batch_identification="
				+ batchidentification + ", invoice_number=" + invoicenumber + ", cardholder_number="
				+ cardholdernumber + ", merchant_sector=" + merchantsector + ", channel_transaction_id="
				+ channeltransactionid + ", operation_code=" + operationcode + ", transaction_code="
				+ transactioncode + ", transaction_amount=" + transactionamount + ", card_expiry_date="
				+ cardexpirydate + ", processing_date=" + processingdate + ", transaction_date=" + transactiondate
				+ ", authorization_code=" + authorizationcode + ", remittance_date=" + remittancedate
				+ ", merchant__categorie_code=" + merchantcategoriecode + ", acquirer_bank_identification="
				+ acquirerbankidentification + ", local_card_system_network=" + localcardsystemnetwork
				+ ", issuer_bank_identification=" + issuerbankidentification + ", acquirer_reference_number="
				+ acquirerreferencenumber + ", transaction_order_usage_code=" + transactionorderusagecode
				+ ", transaction_reference_id=" + transactionreferenceid + ", date=" + date + " , uniqueidtrans=" + uniqueidtrans + ", compconf=" + compconf + "]";
	}





	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMerchantidentification() {
		return merchantidentification;
	}


	public void setMerchantidentification(String merchantidentification) {
		this.merchantidentification = merchantidentification;
	}


	public String getBatchidentification() {
		return batchidentification;
	}


	public void setBatchidentification(String batchidentification) {
		this.batchidentification = batchidentification;
	}


	public String getInvoicenumber() {
		return invoicenumber;
	}


	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}


	public String getCardholdernumber() {
		return cardholdernumber;
	}


	public void setCardholdernumber(String cardholdernumber) {
		this.cardholdernumber = cardholdernumber;
	}


	public String getMerchantsector() {
		return merchantsector;
	}


	public void setMerchantsector(String merchantsector) {
		this.merchantsector = merchantsector;
	}


	public String getChanneltransactionid() {
		return channeltransactionid;
	}


	public void setChanneltransactionid(String channeltransactionid) {
		this.channeltransactionid = channeltransactionid;
	}


	public String getOperationcode() {
		return operationcode;
	}


	public void setOperationcode(String operationcode) {
		this.operationcode = operationcode;
	}


	public String getTransactioncode() {
		return transactioncode;
	}


	public void setTransactioncode(String transactioncode) {
		this.transactioncode = transactioncode;
	}


	public String getTransactionamount() {
		return transactionamount;
	}


	public void setTransactionamount(String transactionamount) {
		this.transactionamount = transactionamount;
	}


	public String getCardexpirydate() {
		return cardexpirydate;
	}


	public void setCardexpirydate(String cardexpirydate) {
		this.cardexpirydate = cardexpirydate;
	}


	public String getProcessingdate() {
		return processingdate;
	}


	public void setProcessingdate(String processingdate) {
		this.processingdate = processingdate;
	}


	public String getTransactiondate() {
		return transactiondate;
	}


	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}


	public String getAuthorizationcode() {
		return authorizationcode;
	}


	public void setAuthorizationcode(String authorizationcode) {
		this.authorizationcode = authorizationcode;
	}


	public String getRemittancedate() {
		return remittancedate;
	}


	public void setRemittancedate(String remittancedate) {
		this.remittancedate = remittancedate;
	}


	public String getMerchantcategoriecode() {
		return merchantcategoriecode;
	}


	public void setMerchantcategoriecode(String merchantcategoriecode) {
		this.merchantcategoriecode = merchantcategoriecode;
	}


	public String getAcquirerbankidentification() {
		return acquirerbankidentification;
	}


	public void setAcquirerbankidentification(String acquirerbankidentification) {
		this.acquirerbankidentification = acquirerbankidentification;
	}


	public String getLocalcardsystemnetwork() {
		return localcardsystemnetwork;
	}


	public void setLocalcardsystemnetwork(String localcardsystemnetwork) {
		this.localcardsystemnetwork = localcardsystemnetwork;
	}


	public String getIssuerbankidentification() {
		return issuerbankidentification;
	}


	public void setIssuerbankidentification(String issuerbankidentification) {
		this.issuerbankidentification = issuerbankidentification;
	}


	public String getAcquirerreferencenumber() {
		return acquirerreferencenumber;
	}


	public void setAcquirerreferencenumber(String acquirerreferencenumber) {
		this.acquirerreferencenumber = acquirerreferencenumber;
	}


	public String getTransactionorderusagecode() {
		return transactionorderusagecode;
	}


	public void setTransactionorderusagecode(String transactionorderusagecode) {
		this.transactionorderusagecode = transactionorderusagecode;
	}


	public String getTransactionreferenceid() {
		return transactionreferenceid;
	}


	public void setTransactionreferenceid(String transactionreferenceid) {
		this.transactionreferenceid = transactionreferenceid;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Account() {
		super();
	}
	
	
}
