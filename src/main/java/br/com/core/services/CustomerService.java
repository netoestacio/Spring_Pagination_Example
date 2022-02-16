package br.com.core.services;

import br.com.core.models.Customer;
import br.com.core.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public void createCustomer(int i) {
        var p = new Customer();
        p.setName("Teste");
        p.setAge(20+i);
        p.setPhone("phone");
        customerRepository.save(p);
    }

    public Page<Customer> findAll(Pageable pageable){
        return customerRepository.findAll(pageable);
    }

}
