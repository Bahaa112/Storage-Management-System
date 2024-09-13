package db_testing;

import java.util.Date;

public class Supply {
	private int productid;
	int SupplierID;
	String Priduct_Name;
	double price;
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}

	@Override
	public String toString() {
		return "Supply [productid=" + productid + ", SupplierID=" + SupplierID + ", Priduct_Name=" + Priduct_Name
				+ ", price=" + price + "]";
	}
	public String getPriduct_Name() {
		return Priduct_Name;
	}
	public void setPriduct_Name(String priduct_Name) {
		Priduct_Name = priduct_Name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Supply(int productid, int supplierID, String priduct_Name, double price) {
		super();
		this.productid = productid;
		SupplierID = supplierID;
		Priduct_Name = priduct_Name;
		this.price = price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
