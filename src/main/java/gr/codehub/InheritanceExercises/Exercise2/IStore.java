package gr.codehub.InheritanceExercises.Exercise2;

import java.util.List;

public interface IStore {
    void buy(Product product);
    void sell(Product product);
    double getRevenue();
    List<Product> getInventory();
}
