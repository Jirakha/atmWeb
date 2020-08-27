package th.go.rd.atm.data;

import th.go.rd.atm.model.Customer;

import java.util.List;

public interface JdbcRepository {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void update(int id, Customer customer);
    void deleteById(int id);
}
