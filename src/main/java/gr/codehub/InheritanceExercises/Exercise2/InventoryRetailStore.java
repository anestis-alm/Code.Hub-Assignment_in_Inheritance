package gr.codehub.InheritanceExercises.Exercise2;

import java.util.ArrayList;
import java.util.List;


public class InventoryRetailStore implements IStore {
    private final List<Product> products;
    private final List<Product> allProducts;

    public InventoryRetailStore() {
        products = new ArrayList<>();
        allProducts = new ArrayList<>();
    }

    public List<Product> getInventory() {
      return products;
    }

    public void reset() {
        products.clear();
        allProducts.clear();
    }

    @Override
    public void buy(Product product) {
        products.add(product);
        allProducts.add(product);
    }

    @Override
    public void sell(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        } else {
            System.out.println("Error:: Can't remove product " + product.getName() + ", the product isn't in your inventory.");

        }
    }

    @Override
    public double getRevenue() {
//        return products.stream().mapToDouble(e -> e.getPriceWhenSell() - e.getPriceWhenBuy()).sum();
        double revenue = 0;

        for (Product product : allProducts) {
            revenue -= product.getPriceWhenBuy();
            if (!products.contains(product)) {
                revenue += product.getPriceWhenSell();
            }
        }
        return revenue;
    }
}
