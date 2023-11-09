package mypackage;

import mypackage.components.ShoppingSession;
import mypackage.service.CartService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);

		var service = context.getBean(CartService.class);

		service.addItemToCart(1,4);
		printCartData(service);
		service.displayRecentActivity();
		service.addItemToCart(0,3);
		printCartData(service);
		service.displayRecentActivity();
		service.addItemToCart(3,2);
		printCartData(service);
		service.displayRecentActivity();
		service.addItemToCart(4,1);
		printCartData(service);
		service.displayRecentActivity();
		service.addItemToCart(5,9);
		printCartData(service);
		service.displayRecentActivity();
		service.removeItemFromCart(1);
		printCartData(service);
		service.displayRecentActivity();
		service.removeItemFromCart(0);
		printCartData(service);
		service.displayRecentActivity();

		var session = context.getBean(ShoppingSession.class);
		session.displayStartDateTime();
	}

	private static void printCartData(CartService service) {
		System.out.println("cart items:"+ service.getAllItemsInCart());
		System.out.println("cart cost:"+ service.calculateCartCost());
	}
}
