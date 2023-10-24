package com.rodolforamos.hexagonalarchitecture.adapters.persistence;

import com.rodolforamos.hexagonalarchitecture.application.domain.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataBankAccountRepository extends MongoRepository<BankAccount, Long> {

}
