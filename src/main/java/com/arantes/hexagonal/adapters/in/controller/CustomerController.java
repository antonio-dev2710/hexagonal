package com.arantes.hexagonal.adapters.in.controller;

import com.arantes.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.arantes.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustumerRequest request){
      var customer = customerMapper.toCustomer(request);
      insertCustomerInputPort.insert(customer, request.getZipCode());
      return ResponseEntity.ok().build();

  }
    @PostMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CustumerRequest request , @PathVariable final String id) {
        var customer = customerMapper.toCustomer(request);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        Customer customer = findCustomerByIdInputPort.find(id);

        return ResponseEntity.ok(customerMapper.toCustomerResponse(customer));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.ok().build();
    }

}
