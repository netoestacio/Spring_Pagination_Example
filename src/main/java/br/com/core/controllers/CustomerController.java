package br.com.core.controllers;

import br.com.core.models.Customer;
import br.com.core.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public ResponseEntity<Page<Customer>> getAll(@RequestParam(required = false) String name,
                                                 @RequestParam(required = false) Integer minAge,
                                                 @RequestParam(required = false) Integer maxAge,
                                                 @RequestParam(required = false) Integer page,
                                                 @RequestParam(required = false) Integer size){
        Sort sort = Sort.by("age").ascending();
        Pageable pageable = PageRequest.of(page != null ? page:0,size != null? size:10, sort);

        return  ResponseEntity.ok(customerService.findAll(pageable));
    }

    @GetMapping(path = "create")
    public void create(){
        for(int i=0; i< 100; i++){
            customerService.createCustomer(i);
        }

    }


}
