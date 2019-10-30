package es.alten.rumbo.salesTax;

public class Tax {
	
	protected double basicTax;
	protected double importTax;
	
	public Tax() {
	}
	
	public Tax(double basicTax, double importTax) {
		this.basicTax = basicTax;
		this.importTax = importTax;
	}

	public double getBasicTax() {
		return basicTax;
	}

	public void setBasicTax(double basicTax) {
		this.basicTax = basicTax;
	}

	public double getImportTax() {
		return importTax;
	}

	public void setImportTax(double importTax) {
		this.importTax = importTax;
	}
	
	

}
