package com.rodolforamos.hexagonalarchitecture.application.services;

import com.rodolforamos.hexagonalarchitecture.application.domain.BankAccount;
import com.rodolforamos.hexagonalarchitecture.application.port.incoming.DepositUseCase;
import com.rodolforamos.hexagonalarchitecture.application.port.incoming.WithdrawUseCase;
import com.rodolforamos.hexagonalarchitecture.application.port.outgoing.LoadAccountPort;
import com.rodolforamos.hexagonalarchitecture.application.port.outgoing.SaveAccountPort;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private LoadAccountPort loadAccountPort;
    private SaveAccountPort saveAccountPort;

    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
    }

    @Override
    public void deposit(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);

        account.deposit(amount);

        saveAccountPort.save(account);
    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);

        boolean hasWithdrawn = account.withdraw(amount);

        if (hasWithdrawn) {
            saveAccountPort.save(account);
        }
        return hasWithdrawn;
    }
}
