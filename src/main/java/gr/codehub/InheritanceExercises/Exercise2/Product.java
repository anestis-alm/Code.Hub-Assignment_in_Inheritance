package gr.codehub.InheritanceExercises.Exercise2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double priceWhenBuy;
    private double priceWhenSell;
}
