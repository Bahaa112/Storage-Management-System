package db_testing;

public class Product_Supplier {

	int ProductID;
	String ProductName;
	String Category;
	double Price;
	String maincompany;
	int suplairs;
	public int getProductID() {
		return ProductID;
	}
	
	
	
	
	
	public Product_Supplier(int productID, String productName, String category, double price, String maincompany,
			int suplairs) {
		super();
		ProductID = productID;
		ProductName = productName;
		Category = category;
		Price = price;
		this.maincompany = maincompany;
		this.suplairs = suplairs;
	}





	public int getSuplairs() {
		return suplairs;
	}





	public void setSuplairs(int suplairs) {
		this.suplairs = suplairs;
	}





	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getMaincompany() {
		return maincompany;
	}
	public void setMaincompany(String maincompany) {
		this.maincompany = maincompany;
	}
	
	
	
	
	
	
	
	
}
