package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    //Nomenclatura do teste: <AÇÃO> should <EFEITO> [when <CENÁRIO>]
    //Caso abaixo, Deposito SHOULD (deveria) aumentar o valor da carteira WHEN (Quando) o valor do montante é positivo
    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {

        //Padrão AAA
        //Arrange: Instancie os objetos necessários

        double amount = 200.0;
        double expectedValue = 196.0;

        Account acc = AccountFactory.createEmptyAccount();

        //ACT: Executar as ações necessárias
        acc.deposit(amount);

        //Assert: Declare o qeu deveria acontecer (Resultado esperado)
        Assertions.assertEquals(expectedValue, acc.getBalance());

    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {

        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {

        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }
}
