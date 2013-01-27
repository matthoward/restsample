package dev.mhoward.api.samples.restsample.service;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import dev.mhoward.api.samples.restsample.domain.Customer;


public class CustomerService {

    static HashMap<Long, Customer> customers = new HashMap<Long, Customer>(); 
    
    static {
        customers.put(1L, new Customer(1L, "Stephen", "Smith", "Stephen.Smith@xyz.abc", "34545634"));
        customers.put(2L, new Customer(2L, "Mary", "Johnson", "Mary.Johnson@abc.xyz", "32445433"));
    }
    
    public Customer getCustomer(Long customerId){
        return customers.get(customerId);
    }
    public void saveCustomer(Customer customer){
        customers.put(customer.getId(), customer);
    }
    public List<Customer> getCustomers(){
        return new ArrayList<Customer>(customers.values());
    }
    public void deleteCustomer(Long customerId){
        customers.remove(customerId);
    }
    public void updateCustomer(Customer customer){
        customers.put(customer.getId(), customer);
    }
}
