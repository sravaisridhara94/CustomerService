package com.example.customerservice1.service;

import com.example.customerservice1.entity.AccountHolder;
import com.example.customerservice1.repository.AccountHoldersRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Customer Service
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@Service
public class AccountHolderService {

    private AccountHoldersRepository repository;

    public AccountHolderService(AccountHoldersRepository repository) {
        this.repository = repository;
    }

    public List<AccountHolder> getAccountHolders(){
        return repository.findAll();
    }

    public Optional<AccountHolder> getAccountHolder(long accountHolderId){
        return repository.findById(accountHolderId);
    }

    public AccountHolder createAccountHolder(AccountHolder accountHolder){
        return repository.saveAndFlush(accountHolder);
    }

    public void deleteAccountHolder(long accountHolderId){
        repository.deleteById(accountHolderId);
    }
}
