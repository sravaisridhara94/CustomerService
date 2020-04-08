package com.example.customerservice1.repository;

import com.example.customerservice1.entity.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Customer Service Repository
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@Repository
public interface AccountHoldersRepository extends JpaRepository<AccountHolder, Long> {
}
