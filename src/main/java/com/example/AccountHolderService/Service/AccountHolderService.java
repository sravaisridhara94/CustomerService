package com.example.AccountHolderService.Service;

import com.example.AccountHolderService.Entity.AccountHolder;
import com.example.AccountHolderService.Repository.AccountHoldersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
