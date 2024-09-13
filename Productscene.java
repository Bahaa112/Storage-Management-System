package db_testing;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Productscene {

	PreparedStatement preparedStatement;
	order_detail selectedOrderDetai;
	 Connection con;
	String CustomerName="";
	String CustomerPhone="";
	String CustomerAddress="";
	int costmerid;
	
	 ArrayList<Product> prduct = new ArrayList<>();
	 ArrayList<order_detail> prduct_Dettels = new ArrayList<>();
	 ArrayList<Order> order = new ArrayList<>();
	
	
	
	public void ubdate_Details_quntity(int id,int qun) throws SQLException
	{
		System.out.println(qun);
		System.out.println(qun);
		System.out.println(qun);
		String sql = "UPDATE order_detail SET OrderedQuantity=? WHERE OrderDetailID=?";
	    preparedStatement = con.prepareStatement(sql);
	    preparedStatement.setInt(1,qun);  
	    preparedStatement.setInt(2,id);
	    preparedStatement.executeUpdate();
	}

	public void ubdateCostmer(int id,String name ,String adress ,String phone) throws SQLException
	{
		String sql = "UPDATE customer SET CustomerName=?, CustomerAddress=?, CustomerPhone=?WHERE CustomerID=?";
	    preparedStatement = con.prepareStatement(sql);
	    preparedStatement.setString(1,name);
	    preparedStatement.setString(2,adress);
	    preparedStatement.setString(3, phone);
	    preparedStatement.setInt(4,id);
	    preparedStatement.executeUpdate();

	}
		
	public void abdatepos(int prim,int neg,int org) throws SQLException
	{
		
		
		String sql = "UPDATE product SET amount=? WHERE ProductID=?";
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, org+neg);
        preparedStatement.setInt(2, prim);
        preparedStatement.executeUpdate();
		
		
		
	}
	public void abdateneg(int prim,int neg,int org) throws SQLException
	{
		
		
		String sql = "UPDATE product SET amount=? WHERE ProductID=?";
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, org-neg);
        preparedStatement.setInt(2, prim);
        preparedStatement.executeUpdate();
	
		
        
        
        
		
	}
	public int give_last() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8",
				"root", "1234");
		Statement stmt = (Statement) con.createStatement();
		String query = "select * from customer";
		ResultSet rs = stmt.executeQuery(query);
		int n=0;
		int r=0;
		while (rs.next()) {
			r=n;
			n=rs.getInt("CustomerID");
			
		
		
		}

		return r;

	}
	public void abloadproduct(TableView<Product> m1) {

		m1.getItems().clear();
		for (int i = 0; i < prduct.size(); i++) {

			m1.getItems().add(prduct.get(i));

		}

	}
	
	

	public void abloadproduct(TableView<Product> m1, String name) {

		m1.getItems().clear();
		for (int i = 0; i < prduct.size(); i++) {

			if (prduct.get(i).getProductName().toLowerCase().contains(name.toLowerCase()))
				m1.getItems().add(prduct.get(i));

		}
	}

	
	
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public order_detail getSelectedOrderDetai() {
		return selectedOrderDetai;
	}

	public void setSelectedOrderDetai(order_detail selectedOrderDetai) {
		this.selectedOrderDetai = selectedOrderDetai;
	}

	public  Connection getCon() {
		return con;
	}

	public  void setCon(Connection con) {
		try {
			this.con = con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerPhone() {
		return CustomerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public int getCostmerid() {
		return costmerid;
	}

	public void setCostmerid(int costmerid) {
		this.costmerid = costmerid;
	}

	public  ArrayList<Product> getPrduct() {
		return prduct;
	}

	public  void setPrduct(ArrayList<Product> prduct) {
		this.prduct = prduct;
	}

	public  ArrayList<order_detail> getPrduct_Dettels() {
		return prduct_Dettels;
	}

	public  void setPrduct_Dettels(ArrayList<order_detail> prduct_Dettels) {
		this.prduct_Dettels = prduct_Dettels;
	}

	public  ArrayList<Order> getOrder() {
		return order;
	}

	public  void setOrder(ArrayList<Order> order) {
		this.order = order;
	}

	public void found(TableView<order_detail> m1, int n1) {
		m1.getItems().clear();
		for (int i = 0; i < prduct_Dettels.size(); i++) {

			if (prduct_Dettels.get(i).getProductID() == n1) {

				m1.getItems().add(prduct_Dettels.get(i));

			}

		}

	}
	
	
	
	
	
	
	public  void abload() throws ClassNotFoundException, SQLException {
		prduct = new ArrayList<>();
		prduct_Dettels = new ArrayList<>();
		order = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8",
				"root", "1234");
		Statement stmt = (Statement) con.createStatement();
		String query = "select * from product";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Product p1 = new Product(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getString("Category"),
					rs.getDouble("Price"), rs.getString("maincompany"), rs.getInt("amount"));
			prduct.add(p1);
		}
		String q = "select * from order_detail";
		ResultSet rs1 = stmt.executeQuery(q);
		while (rs1.next()) {
			order_detail p1 = new order_detail(rs1.getInt("OrderDetailID"), rs1.getInt("OrderID"),
					rs1.getInt("ProductID"), rs1.getInt("OrderedQuantity"), rs1.getDouble("Price"));
			
			System.out.println(p1);
			prduct_Dettels.add(p1);
		}

		String q2 = "select * from order_Request";
		ResultSet rs2 = stmt.executeQuery(q2);
		while (rs2.next()) {

			Order p1 = new Order(rs2.getInt("OrderID"), rs2.getDate("OrderDate"), rs2.getString("ShippingAddress"),
					rs2.getInt("CustomerID"));
			order.add(p1);
		}

	}
	
	
	
	
	
}
