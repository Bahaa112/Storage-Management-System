package db_testing;

import java.sql.Date;
import java.util.ArrayList;

import javafx.beans.property.*;

public class customer {
	private int CustomerID;
	private String CustomerName;
	private String CustomerAddress;
	private String CustomerPhone;
	private int age;
	ArrayList<Order> order;
	public void setOrder(Order order1) {
		order.add(order1);
		order1.setCustomer(CustomerID);		
		
		
		
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public String getCustomerPhone() {
		return CustomerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public customer(int customerID, String customerName, String customerAddress, String customerPhone, int age) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		CustomerAddress = customerAddress;
		CustomerPhone = customerPhone;
		this.age = age;
		ArrayList<Order> order=new ArrayList<>();
		
		
		
	}
	@Override
	public String toString() {
		return "customer [CustomerID=" + CustomerID + ", CustomerName=" + CustomerName + ", CustomerAddress="
				+ CustomerAddress + ", CustomerPhone=" + CustomerPhone + ", age=" + age + ", order=" + order + "]";
	}
	}
