package com.arantes.hexagonal.adapters.in.controller;

import com.arantes.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.arantes.hexagonal.adapters.in.controller.request.CustumerRequest;
import com.arantes.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.in.updateCustomerInputPort;
import com.arantes.hexagonal.application.ports.out.UpdateCustomerOutputPort;
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
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private updateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustumerRequest request){
      var customer = customerMapper.toCustomer(request);
      insertCustomerInputPort.insert(customer, request.getZipCode());
      return ResponseEntity.ok().build();

  }
  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);

        return customerMapper.toCustomerResponse(customer) != null ? ResponseEntity.ok(customerMapper.toCustomerResponse(customer)) : ResponseEntity.notFound().build();
  }
  @PutMapping
    public ResponseEntity<Void> update(@PathVariable String id,@Valid @RequestBody CustumerRequest request ){
        Customer customer = customerMapper.toCustomer(request);
        customer.setId(id);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.noContent().build();
    }

}
