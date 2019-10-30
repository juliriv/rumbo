package es.alten.rumbo.salesTax;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Basket {
/*
 *Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. 
 *Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions. 
 */
	
	Set<ItemsBasket> productsList=new HashSet<ItemsBasket>();
	BigDecimal totalTax = new BigDecimal(0);
	BigDecimal totalAmount = new BigDecimal(0);
	
	public void addProducts(Product product,int quantity) {
		ItemsBasket products=null;		
		boolean containProduct=false;
		Iterator<ItemsBasket> iter = productsList.iterator();
		while (iter.hasNext()) {		
			products=iter.next();
			if (products.getProduct().equals(product)) {
				products.setQuantity(+quantity);
				containProduct=true;
				break;
			}
		}
		
		if (!containProduct) {
			products= new ItemsBasket(product,quantity);
			productsList.add(products);
		}
		calcule(products);
		
	}
	
	public void removeProducts(Product product,int quantity) {
		ItemsBasket products=null;
		Iterator<ItemsBasket> iter = productsList.iterator();
		while (iter.hasNext()) {		
			products=iter.next();
			if (products.getProduct().equals(product)) {
				products.setQuantity(-quantity);
				break;
			}
		}
		calcule(products);
	}
	
	protected void calcule(ItemsBasket products) {
		double tax=0;
		if(products.getProduct().getCategory().isApplyTax()) {
			tax+=products.getProduct().getCategory().getTax().getBasicTax();
		}
		if (products.getProduct().isImported()) {
			tax+=products.getProduct().getCategory().getTax().getImportTax();
		}
		BigDecimal amountTax=calculeTax(products.getProduct().getPrice(),products.getQuantity(),tax);
		products.setAmountTax(amountTax);
		products.setSubTotal(products.getProduct().getPrice().multiply(new BigDecimal(products.getQuantity())).add(amountTax));
		totalTax=totalTax.add(amountTax);
		totalAmount=totalAmount.add(products.getProduct().getPrice().add(amountTax));
	}
	
	protected BigDecimal calculeTax(BigDecimal price,int quantity,double tax) {
		return new BigDecimal (price.doubleValue()*quantity*(tax/100));
	}
	
	public String getTotalTax() {
		return Utils.parseQuanty (totalTax);
	}
	
	public String getTotalAmount() {
		return Utils.parseQuanty(totalAmount);
	}

	public Set<ItemsBasket> getProductsList() {
		return productsList;
	}
	
	
}

