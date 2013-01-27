package dev.mhoward.api.samples.restsample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import dev.mhoward.api.samples.restsample.domain.Customer;
import dev.mhoward.api.samples.restsample.domain.CustomerList;
import dev.mhoward.api.samples.restsample.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
    CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAllCustomers(ModelMap model) {
		List<Customer> customers = customerService.getCustomers();
        CustomerList customerList = new CustomerList(customers);
        return new ModelAndView("customerView", "customers", customerList);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) 
	public ModelAndView getCustomer(@PathVariable Long id) {
		 Customer customer = customerService.getCustomer(id);
	     return new ModelAndView("customerView", "customer", customer);
	}
	

    @RequestMapping(method = RequestMethod.POST)
    public View addCustomer(@RequestBody Customer customer)
    {
        customerService.saveCustomer(customer);
        return new RedirectView("/customerView/"+ customer.getId());
    }
}
