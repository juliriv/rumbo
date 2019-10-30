package es.alten.rumbo.salesTax;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SalesTax {
	
	protected Basket basket;
	protected Map<String, Product> products;
		
	
	public SalesTax() {
		this.basket = new Basket();
		this.products = new HashMap<String, Product>();
	}

	public void createProduct(String id,String name, boolean imported, double price, String category) {
		
		//ProductsCategory category, boolean imported, String name, BigDecimal price
		Product product = new Product(ProductsCategory.findProductsCategory(category),imported,name,new BigDecimal(price));
		products.put(id, product);
	}

	public void printBasket(){
		
		Set<ItemsBasket> itemsBasket= basket.getProductsList();
		
		for (ItemsBasket item : itemsBasket) {
			System.out.println(item.getQuantity()+" "+item.getProduct().getName()+": "+item.getSubTotal());
		}				
		System.out.println("Sales Taxes: "+basket.getTotalTax());
		System.out.println("Total: "+basket.getTotalAmount());
	}
	
	public void buyProduct(String id, int quantity) {
		basket.addProducts(products.get(id), quantity);
	}
}
