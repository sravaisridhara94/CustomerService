package com.example.customerservice1.controller;

import com.example.customerservice1.entity.AccountHolder;
import com.example.customerservice1.entity.CustomerConstants;
import com.example.customerservice1.helper.CustomerMapper;
import com.example.customerservice1.model.AccountHolderModel;
import com.example.customerservice1.service.AccountHolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Customer Service Controller
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@RestController
@RequestMapping("/v1/customers")
@RefreshScope
@Api(value = "CustomerController")
public class AccountHolderController {

    private AccountHolderService service;

    public AccountHolderController(AccountHolderService service) {
        this.service = service;
    }

    @ApiResponses(value = {
            @ApiResponse(code = CustomerConstants.SUCCESS, message = CustomerConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_AUTHORIZED, message = CustomerConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = CustomerConstants.FORBIDDEN, message = CustomerConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_FOUND, message = CustomerConstants.NOT_FOUND_MESSAGE) })
    @GetMapping
    public ResponseEntity<List<AccountHolderModel>> fetchCustomers(){
        List<AccountHolderModel> customers = service.getAccountHolders().stream().map(o->CustomerMapper.toModel(o))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(customers);
    }

    @ApiResponses(value = {
            @ApiResponse(code = CustomerConstants.SUCCESS, message = CustomerConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_AUTHORIZED, message = CustomerConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = CustomerConstants.FORBIDDEN, message = CustomerConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_FOUND, message = CustomerConstants.NOT_FOUND_MESSAGE) })
    @GetMapping("/{customerId}")
    public ResponseEntity<AccountHolderModel> fetchByCustomerId(@ApiParam @PathVariable long customerId){
        Optional<AccountHolder> customer = service.getAccountHolder(customerId);
        if (!customer.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(CustomerMapper.toModel(customer.get()));
    }

    @ApiResponses(value = {
            @ApiResponse(code = CustomerConstants.SUCCESS, message = CustomerConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_AUTHORIZED, message = CustomerConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = CustomerConstants.FORBIDDEN, message = CustomerConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_FOUND, message = CustomerConstants.NOT_FOUND_MESSAGE) })
    @PostMapping
    public ResponseEntity<AccountHolderModel> addOrUpdateCustomer(@RequestBody AccountHolderModel model){
        Optional<AccountHolder> customer = service.getAccountHolder(model.getId());
        if(customer.isPresent()){
            CustomerMapper.merge(model, customer.get());
            return ResponseEntity.ok(CustomerMapper.toModel(service.createAccountHolder(customer.get())));
        }else{
            CustomerMapper.toModel(service.createAccountHolder(CustomerMapper.toEntity(model)));
            return ResponseEntity.ok().build();
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = CustomerConstants.SUCCESS, message = CustomerConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_AUTHORIZED, message = CustomerConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = CustomerConstants.FORBIDDEN, message = CustomerConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = CustomerConstants.NOT_FOUND, message = CustomerConstants.NOT_FOUND_MESSAGE) })
    @DeleteMapping("/{accountId}")
    public ResponseEntity<AccountHolderModel> deleteCustomer(@PathVariable long accountId){
        Optional<AccountHolder> account = service.getAccountHolder(accountId);
        if(!account.isPresent()){
            ResponseEntity.notFound().build();
        }
        service.deleteAccountHolder(accountId);
        return ResponseEntity.ok().build();
    }
}
