package com.example.AccountHolderService.Controller;

import com.example.AccountHolderService.Entity.AccountHolder;
import com.example.AccountHolderService.Helper.CustomerMapper;
import com.example.AccountHolderService.Model.AccountHolderModel;
import com.example.AccountHolderService.Service.AccountHolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping
    public ResponseEntity<List<AccountHolderModel>> fetchCustomers(){
        List<AccountHolderModel> customers = service.getAccountHolders().stream().map(o->CustomerMapper.toModel(o))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(customers);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/{customerId}")
    public ResponseEntity<AccountHolderModel> fetchByCustomerId(@ApiParam @PathVariable long customerId){
        Optional<AccountHolder> customer = service.getAccountHolder(customerId);
        if (!customer.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(CustomerMapper.toModel(customer.get()));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
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
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
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
