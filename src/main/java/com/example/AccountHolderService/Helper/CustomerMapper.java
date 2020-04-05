package com.example.AccountHolderService.Helper;

import com.example.AccountHolderService.Entity.AccountHolder;
import com.example.AccountHolderService.Model.AccountHolderModel;


public class CustomerMapper {

    public static AccountHolder toEntity(AccountHolderModel model){
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setAddress(model.getAddress());
        accountHolder.setCountryOfBirth(model.getCountryOfBirth());
        accountHolder.setDob(model.getDob());
        accountHolder.setName(model.getName());
        accountHolder.setPhone(model.getPhone());
        accountHolder.setSsn(model.getSsn());
        accountHolder.setZipCode(model.getZipCode());
        return accountHolder;
    }

    public static AccountHolderModel toModel(AccountHolder accountHolder){
        AccountHolderModel model = new AccountHolderModel();
        model.setAddress(accountHolder.getAddress());
        model.setCountryOfBirth(accountHolder.getCountryOfBirth());
        model.setDob(accountHolder.getDob());
        model.setName(accountHolder.getName());
        model.setPhone(accountHolder.getPhone());
        model.setSsn(accountHolder.getSsn());
        model.setZipCode(accountHolder.getZipCode());
        model.setId(accountHolder.getId());
        return model;
    }

    public static void merge(AccountHolderModel model, AccountHolder entity) {
        entity.setZipCode(model.getZipCode());
        entity.setSsn(model.getSsn());
        entity.setPhone(model.getPhone());
        entity.setName(model.getName());
        entity.setDob(model.getDob());
        entity.setCountryOfBirth(model.getCountryOfBirth());
        entity.setAddress(model.getAddress());
        entity.setId(model.getId());
    }

}
