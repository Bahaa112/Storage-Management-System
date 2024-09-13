package db_testing;

public class supplier {
	private int SupplierID;
	private String name;
	private String type;
	private String phone;
	
	public supplier(int supplierID, String name, String type, String phone) {
		super();
		SupplierID = supplierID;
		this.name = name;
		this.type = type;
		this.phone = phone;
	}
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
	
	
	
	
}
