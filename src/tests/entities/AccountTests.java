package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {

    //Nomenclatura do teste: <AÇÃO> should <EFEITO> [when <CENÁRIO>]
    //Caso abaixo, Deposito SHOULD (deveria) aumentar o valor da carteira WHEN (Quando) o valor do montante é positivo
    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {

        //Padrão AAA
        //Arrange: Instancie os objetos necessários

        double amount = 200.0;
        double expectedValue = 196.0;

        Account acc = new Account(1L, 0.0);

        //ACT: Executar as ações necessárias
        acc.deposit(amount);

        //Assert: Declare o qeu deveria acontecer (Resultado esperado)
        Assertions.assertEquals(expectedValue, acc.getBalance());

    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {

        double expectedValue = 100.0;
        Account acc = new Account(1L, 100.0);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }
}
