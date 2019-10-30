package es.alten.rumbo.salesTax;

import java.math.BigDecimal;

public class ItemsBasket {
	
	private Product product;
	private int quantity;
	private BigDecimal amountTax;
	private BigDecimal subTotal;
	
	
	public ItemsBasket(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmountTax() {
		return amountTax;
	}

	public void setAmountTax(BigDecimal amountTax) {
		this.amountTax = amountTax;
	}

	public String getSubTotal() {
		return Utils.parseQuanty(subTotal);
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	
	

}
