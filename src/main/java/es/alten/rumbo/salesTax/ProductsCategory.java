package es.alten.rumbo.salesTax;

import java.util.Properties;

public enum ProductsCategory {
	
	BOOKS, FOOD, MEDICAL, GENERAL;
	
	protected boolean applyTax;
	protected Tax tax;
	protected final Tax generalTax = new Tax();
	
	
	
	private ProductsCategory() {
			
			double basicTax;
			double taxImported;
            Properties prop = new Properties();
            // load a properties file
            try {
				prop.load(ProductsCategory.class.getClassLoader().getResourceAsStream(Constants.PROPERTIES_CATEGORY_FILE));
				this.applyTax= new Boolean(prop.getProperty(this.name()+"."+Constants.APPLY_TAX)).booleanValue();
				if (generalTax.getBasicTax() ==0) {
					generalTax.setBasicTax(Double.parseDouble(prop.getProperty(Constants.BASIC_TAX)));
				}
				
				if (generalTax.getImportTax()==0) {
					generalTax.setImportTax(Double.parseDouble(prop.getProperty(Constants.IMPORT_TAX)));
				}
				
				if(prop.containsKey(this.name()+Constants.BASIC_TAX)) {
					basicTax = Double.parseDouble(prop.getProperty(this.name()+"."+Constants.BASIC_TAX));
				} else {
					basicTax =generalTax.basicTax;
				}
				
				if(prop.containsKey(this.name()+Constants.IMPORT_TAX)) {
					taxImported = Double.parseDouble(prop.getProperty(this.name()+Constants.IMPORT_TAX));
				} else {
					taxImported =generalTax.importTax;
				}
				
				tax = new Tax(basicTax, taxImported);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static ProductsCategory findProductsCategory(String name) {
		return name==null||"".equals(name.trim())?ProductsCategory.GENERAL:valueOf(name.toUpperCase());
	}
	
	

	public boolean isApplyTax() {
		return applyTax;
	}

	public Tax getTax() {
		return tax;
	}

	public Tax getGeneralTax() {
		return generalTax;
	}
	
}
