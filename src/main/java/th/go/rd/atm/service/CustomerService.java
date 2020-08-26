package th.go.rd.atm.service;

import org.springframework.stereotype.Service;
import th.go.rd.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private ArrayList<Customer> customerList;

@PostConstruct
public void  postContruct()
    {
    customerList = new ArrayList<>();

    }
    public void createCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(this.customerList);
    }


}
