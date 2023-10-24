package com.rodolforamos.hexagonalarchitecture.application.port.outgoing;

import com.rodolforamos.hexagonalarchitecture.application.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount bankAccount);
}
