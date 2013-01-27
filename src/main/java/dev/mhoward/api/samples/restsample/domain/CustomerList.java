package dev.mhoward.api.samples.restsample.domain;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="customers")
public class CustomerList implements Serializable {
	
	private List<Customer> customers; 
	
	public CustomerList() {}
	
	public CustomerList(List<Customer> customers) {
		this.customers = customers;
	}
	
	@XmlElement(name="customer")
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
