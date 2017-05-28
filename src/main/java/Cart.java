import java.util.HashMap;

/**
 * Created by Calvin on 5/26/2017.
 */
public class Cart {

    HashMap<String,Integer> cart = new HashMap<String, Integer>();
    public Cart() { }

    public Cart(String name, Integer quantity) {
        cart.put(name, quantity);
    }

    public HashMap getCart() { return cart; }
}
