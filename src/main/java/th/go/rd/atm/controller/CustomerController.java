package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {

    @RequestMapping("/customer")
    public String getCustomerPage(Model model)
    {

        ArrayList<String> customers = new ArrayList<>();
        customers.add("Peter");
        customers.add("Nancy");
        customers.add("Rick");

        model.addAttribute("allCustomers",customers);
        return "customer"; // customer.html

    }



}
