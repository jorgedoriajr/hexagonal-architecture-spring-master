package com.rodolforamos.hexagonalarchitecture.application.port.outgoing;

import com.rodolforamos.hexagonalarchitecture.application.domain.BankAccount;

import java.util.Optional;

public interface LoadAccountPort {
    Optional<BankAccount> load(Long id);
}
