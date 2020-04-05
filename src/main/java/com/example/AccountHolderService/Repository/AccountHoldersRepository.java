package com.example.AccountHolderService.Repository;

import com.example.AccountHolderService.Entity.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHoldersRepository extends JpaRepository<AccountHolder, Long> {
}
