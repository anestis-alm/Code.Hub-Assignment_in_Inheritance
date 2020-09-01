package gr.codehub.InheritanceExercises.Exercise2;

import java.util.List;

public class SimpleRetailStore implements IStore {
    private double totalBuyBalance;
    private double totalSellBalance;

    @Override
    public void buy(Product product) {
        totalBuyBalance += product.getPriceWhenBuy();
    }

    @Override
    public void sell(Product product) {
        totalSellBalance += product.getPriceWhenSell();
    }

    @Override
    public double getRevenue() {
        return totalSellBalance - totalBuyBalance;
    }

}
