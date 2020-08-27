package th.go.rd.atm.service;
import org.mindrot.jbcrypt.BCrypt;
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
    public void createCustomer(Customer customer)

    {

        String hashPin = hash(customer.getPin());
        customer.setPin(hashPin)    ;
        customerList.add(customer);


    }

    public List<Customer> getCustomers()
    {
        return new ArrayList<>(this.customerList);
    }

    public Customer findCustomer(int id)
    {

        for (Customer c : customerList) {
            if (c.getId()==id)
                return c;
        }       return null;


    }
    public Customer checkPin(Customer inputCustomer)
    {
        // 1.check customer ที่มี ID ตรงกบ input Customer
        Customer storedCustomer = findCustomer(inputCustomer.getId());
        // 2. ถ้าเจอ ตรวจสอบ pin และ pin ตรง คืนค่า customer นี้
        if (storedCustomer != null){
            String hashPin = storedCustomer.getPin();
            if (BCrypt.checkpw(inputCustomer.getPin(), hashPin))
                return storedCustomer;

        }
        // 3. ถ้าไม่ตรง คืน null
        return null;




    }


    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }


}
