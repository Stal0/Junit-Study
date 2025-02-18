package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.FinancingFactory;

public class FinancingTests {

    @Test
    public void constructorShouldInstanceTheObjectWhenCorrectData() {
        Financing fin = FinancingFactory.CreateFinancing(20000.0, 1600.0, 20);

        Assertions.assertEquals(fin.entry(), 4000.0);
        Assertions.assertEquals(fin.quota(), 800.0);
    }

    @Test
    public void constructorShouldThrowExceptionWhenIncorrectData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin = FinancingFactory.CreateFinancing(20000.0, 1600.0, 10);
        });
    }

    @Test
    public void setTotalAmountShouldValidWhenCorrectData() {
        double initialAmount = 80000.0;
        Financing fin = FinancingFactory.CreateFinancing(initialAmount, 4000.0, 32);
        fin.setTotalAmount(78000.0);
        Assertions.assertNotEquals(initialAmount, fin.getTotalAmount());
    }

    @Test
    public void setTotalAmountShouldThrowExceptionWhenIncorrectData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin = FinancingFactory.CreateFinancing(20000.0, 1600.0, 20);
            fin.setTotalAmount(200000.0);
        });
    }

    @Test
    public void setIncomeShouldValidWhenCorrectData() {
        double initialIncome = 4000.0;
        Financing fin = FinancingFactory.CreateFinancing(80000.0, initialIncome, 32);
        fin.setIncome(8000.0);
        Assertions.assertNotEquals(initialIncome, fin.getIncome());
    }

    @Test
    public void setIncomeShouldThrowExceptionWhenIncorrectData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin = FinancingFactory.CreateFinancing(20000.0, 1600.0, 20);
            fin.setIncome(500.0);
        });
    }

    @Test
    public void setMonthsShouldValidWhenCorrectData() {
        int initialMonths = 32;
        Financing fin = FinancingFactory.CreateFinancing(80000.0, 4000.0, initialMonths);
        fin.setMonths(64);
        Assertions.assertNotEquals(initialMonths, fin.getMonths());
    }

    @Test
    public void setMonthsShouldThrowExceptionWhenIncorrectData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin = FinancingFactory.CreateFinancing(20000.0, 1600.0, 20);
            fin.setMonths(10);
        });
    }

    @Test
    public void entryMethodShouldCalculateCorrectValue() {
        Financing fin = FinancingFactory.CreateFinancing(20000.0, 1600.0, 20);
        double entry = fin.entry();
        Assertions.assertEquals(4000.0, entry);
    }

    @Test
    public void quotaMethodShouldCalculateCorrectValue() {
        Financing fin = FinancingFactory.CreateFinancing(20000.0, 1600.0, 20);
        double quota = fin.quota();
        Assertions.assertEquals(800.0, quota);
    }
}
