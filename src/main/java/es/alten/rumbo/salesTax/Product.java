package es.alten.rumbo.salesTax;

import java.math.BigDecimal;

public class Product {
	
	private ProductsCategory category;
	private boolean imported;
	private String name;
	private BigDecimal price;
	
	public Product(ProductsCategory category, boolean imported, String name, BigDecimal price) {
		this.category = category;
		this.imported = imported;
		this.name = name;
		this.price = price;
	}
	public ProductsCategory getCategory() {
		return category;
	}
	public void setCategory(ProductsCategory category) {
		this.category = category;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	 public boolean equals(Product obj) {
		 return this.name.equalsIgnoreCase(obj.name)?!this.imported^obj.imported:false;
	 }

}