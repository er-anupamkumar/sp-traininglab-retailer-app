package mypackage.service;

import mypackage.components.DeliveryRates;
import mypackage.components.TaxRates;
import mypackage.model.Catalog;
import mypackage.model.Transcript;
import mypackage.repository.CartRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CartServiceImpl implements CartService{

    @Value("${contactEmail}")
    String email;

    private Catalog catalog;
    private CartRepository cartRepository;
    private Transcript transcript;
    private DeliveryRates deliveryRates;
    private TaxRates taxRates;

    public CartServiceImpl(Catalog catalog, CartRepository cartRepository, Transcript transcript, DeliveryRates deliveryRates, TaxRates taxRates) {
        this.catalog = catalog;
        this.cartRepository = cartRepository;
        this.transcript = transcript;
        this.deliveryRates = deliveryRates;
        this.taxRates = taxRates;
    }

    @Override
    public void addItemToCart(int id, int quantity) {
        if(catalog.itemExists(id)){
            transcript.log("Adding "+quantity+" "+catalog.getItemById(id).getDescription()+ " in the cart");
              cartRepository.add(id,quantity);
        }else {
            transcript.log("Product "+id+" not found in the catalog");
        }
    }

    @Override
    public void removeItemFromCart(int id) {
        if(catalog.itemExists(id)){
            System.out.printf("Removing %s in the cart",catalog.getItemById(id).getDescription());
            transcript.log("Removing "+catalog.getItemById(id).getDescription()+ " from the cart");
            cartRepository.remove(id);
        }else {
            transcript.log("Product "+id+" not found in the catalog");
        }
    }

    @Override
    public Map<Integer, Integer> getAllItemsInCart() {
        return cartRepository.getAll();
    }

    @Override
    public double calculateCartCost() {
        AtomicReference<Double> cardCost = new AtomicReference<>((double) 0);
        var cartItems = cartRepository.getAll();
        cartItems.forEach((itemId, quantity) -> {
            cardCost.set(cardCost.get() + catalog.getItemById(itemId).getPrice() * quantity);
        });
        return cardCost.get();
    }

    @Override
    public void displayRecentActivity (){
        transcript.display();
    }

    public void displayEmailAddress() {
        System.out.printf("email: %s",email);
    }

    public void displayApplicableSalesTax(){
        var cartCost = calculateCartCost();
        System.out.printf("Sales Tax on cart: %s",cartCost* taxRates.getSalesTaxRate()/100);
    }

    public void displayDeliveryCharges(){
        System.out.printf("Delivery Rates: %s",deliveryRates.getNormal());
        System.out.printf("Minimum Amount : %s",deliveryRates.getThreshold());
    }
}
