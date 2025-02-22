package tests.factory;

import entities.Financing;

public class FinancingFactory {

    public static Financing CreateFinancing(Double totalAmount, Double income, Integer months) {
        return new Financing(totalAmount, income, months);
    }
}
