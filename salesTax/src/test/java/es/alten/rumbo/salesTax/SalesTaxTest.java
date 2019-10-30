package es.alten.rumbo.salesTax;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesTaxTest {
	
	protected SalesTax salexTax; 
	
	protected String BOOK="book"; 
	protected String CD="cd"; 
	protected String CHOCOLATE="chocolate"; 
	protected String PERFUME="perfume";
	protected String PERFUME_IMP="perfume_Imported";
	protected String PILLS="pills";
	
	
	@Before
	public void before(){
		salexTax= new SalesTax();
	}

	@Test
	public void test1() {
		/*
		 * Input 1:
			1 book at 12.49
			1 music CD at 14.99
			1 chocolate bar at 0.85
			BOOKS, FOOD, MEDICAL, REST;
		 */
		salexTax.createProduct(BOOK, "book", false, 12.49, "BOOKS");
		salexTax.createProduct(CD, "music CD", false, 14.99, "");
		salexTax.createProduct(CHOCOLATE, "chocolate bar", false, 0.85, "FOOD");
		
		salexTax.buyProduct(BOOK, 1);
		salexTax.buyProduct(CD, 1);
		salexTax.buyProduct(CHOCOLATE, 1);
		
		salexTax.printBasket();
		/*
		 * Output 1:

1 book : 12.49

1 music CD: 16.49

1 chocolate bar: 0.85

Sales Taxes: 1.50

Total: 29.83
		 */
	}
	
	@Test
	public void test2() {
/*
 * Input 2:

1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

 */
		salexTax.createProduct(CHOCOLATE, "imported box of chocolates", true, 10.00, "FOOD");
		salexTax.createProduct(PERFUME, "imported bottle of perfume", true, 47.50, "");
		
		salexTax.buyProduct(CHOCOLATE, 1);
		salexTax.buyProduct(PERFUME, 1);
		
		salexTax.printBasket();
	}
	
	@Test
	public void test3() {
	/*	Input 3:

			1 imported bottle of perfume at 27.99
			1 bottle of perfume at 18.99
			1 packet of headache pills at 9.75
			1 box of imported chocolates at 11.25
			*/
		salexTax.createProduct(PERFUME_IMP, "imported bottle of perfume", true, 27.99, "");
		salexTax.createProduct(PERFUME, "bottle of perfume", false, 18.99, "");
		salexTax.createProduct(PILLS, "packet of headache pills", false, 9.75, "MEDICAL");
		salexTax.createProduct(CHOCOLATE, "imported box of chocolates", true, 11.25, "FOOD");
		
		salexTax.buyProduct(PERFUME_IMP, 1);
		salexTax.buyProduct(PERFUME, 1);
		salexTax.buyProduct(PILLS, 1);
		salexTax.buyProduct(CHOCOLATE, 1);
		
		salexTax.printBasket();
	}
	
	

}
