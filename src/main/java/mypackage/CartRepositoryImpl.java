package mypackage;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class CartRepositoryImpl implements CartRepository{

    HashMap<Integer,Integer> cartItems = new HashMap<>();
    @Override
    public void add(int itemId, int quantity) {
        if(cartItems.containsKey(itemId)){
           var updatedQuantity = cartItems.get(itemId)+quantity;
            cartItems.put(itemId,updatedQuantity);
        }else{
            cartItems.put(itemId,quantity);
        }
    }

    @Override
    public void remove(int itemId) {
        cartItems.remove(itemId);
    }

    @Override
    public Map<Integer, Integer> getAll() {
        return cartItems;
    }
}
