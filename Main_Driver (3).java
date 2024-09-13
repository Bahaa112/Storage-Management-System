package db_testing;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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

public class Main_Driver extends Application {
	private int currentIndex = 0;
	private ArrayList<String> detailsList;
	int n;
	int i;
	Scene scene1;
	Scene scene;
	Product selectedOrderDetail;
	order_detail selectedOrderDetail1;

	Product_Supplier supplay;

	static ArrayList<Product> prduct = new ArrayList<>();
	static ArrayList<order_detail> prduct_Dettels = new ArrayList<>();
	static ArrayList<Order> order = new ArrayList<>();
	static ArrayList<supplier> supplairs = new ArrayList<>();
	static ArrayList<Supply> supply = new ArrayList<>();
	static ArrayList<inventory> inventory=new ArrayList<>();

	static ArrayList<Product_Supplier> product_Suuplier = new ArrayList<>();
	static PreparedStatement preparedStatement;
	order_detail selectedOrderDetai;
	static Connection con;
	String CustomerName = "";
	String CustomerPhone = "";
	String CustomerAddress = "";
	int costmerid;
	supplier supp = null;

	Productscene product_scene = new Productscene();

	@Override
	public void start(Stage primaryStage) {

		selectedOrderDetail = null;
		Pane root = new Pane();
		root.setPrefSize(805, 532);

		Image backgroundImage = new Image("Base.png");
		ImageView backgroundImageView = new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(541);
		backgroundImageView.setFitWidth(908);
		backgroundImageView.setLayoutX(-4);
		backgroundImageView.setLayoutY(-5);
		backgroundImageView.setPickOnBounds(true);
		backgroundImageView.setPreserveRatio(true);

		Label colorOnlyLabel = new Label("Label");
		colorOnlyLabel.setLayoutX(448);
		colorOnlyLabel.setLayoutY(308);
		colorOnlyLabel.setPrefHeight(104);
		colorOnlyLabel.setPrefWidth(245);
		colorOnlyLabel.setStyle("-fx-background-color: White;");
		colorOnlyLabel.setTextFill(javafx.scene.paint.Color.WHITE);

		Image logoImage = new Image("Logo.png");
		ImageView logoSMSImageView = new ImageView(logoImage);
		logoSMSImageView.setFitHeight(97);
		logoSMSImageView.setFitWidth(165);
		logoSMSImageView.setLayoutX(490);
		logoSMSImageView.setLayoutY(315);
		logoSMSImageView.setPickOnBounds(true);
		logoSMSImageView.setPreserveRatio(true);

		Label loginLabel = new Label("Login");
		loginLabel.setLayoutX(237);
		loginLabel.setLayoutY(148);
		loginLabel.setPrefHeight(30);
		loginLabel.setPrefWidth(65);
		loginLabel.setStyle("-fx-background-color: white;");
		loginLabel.setFont(new Font("System Bold", 23));

		Label usernameLabel = new Label("Username");
		usernameLabel.setLayoutX(164);
		usernameLabel.setLayoutY(182);
		usernameLabel.setPrefHeight(17);
		usernameLabel.setPrefWidth(57);
		usernameLabel.setStyle("-fx-background-color: white;");

		Label passwordLabel = new Label("Password");
		passwordLabel.setLayoutX(163);
		passwordLabel.setLayoutY(232);
		passwordLabel.setPrefHeight(17);
		passwordLabel.setPrefWidth(215);
		passwordLabel.setStyle("-fx-background-color: white;");

		TextField usernameTextField = new TextField();
		usernameTextField.setLayoutX(163);
		usernameTextField.setLayoutY(199);
		usernameTextField.setPrefHeight(28);
		usernameTextField.setPrefWidth(209);
		usernameTextField.setStyle("-fx-background-color: Silver;");

		// TextField passwordTextField = new TextField();

		PasswordField passwordTextField = new PasswordField();
		passwordTextField.setLayoutX(163);
		passwordTextField.setLayoutY(249);
		passwordTextField.setPrefHeight(28);
		passwordTextField.setPrefWidth(209);
		TextField textField = new TextField();
		textField.setManaged(false); // Hide the TextField initially
		textField.setVisible(false); // Hide the TextField initially

		textField.textProperty().bindBidirectional(passwordTextField.textProperty());
//		ImageView passwd = new ImageView("C:\\Users\\islei\\Downloads\\visible.png");

		passwordTextField.setStyle("-fx-background-color: Silver;");

//		passwd.setFitWidth(15);
//		passwd.setFitHeight(15);

		Button loginButton = new Button("Login");
		loginButton.setLayoutX(163);
		loginButton.setLayoutY(308);
		loginButton.setPrefHeight(46);
		loginButton.setPrefWidth(215);
		loginButton.setStyle("-fx-background-color: Blue; -fx-background-radius: 30;");
		loginButton.setFont(new Font("System Bold", 22));

		loginButton.setOnAction(e -> {

			String username = usernameTextField.getText();
			String password = passwordTextField.getText();
           try {
			if(!exist(username, password))
			   {
				   
				Alert al=new Alert(AlertType.ERROR);
				al.setHeaderText("The password  or user name is false");
				al.show();
				
				
				return;
				   
			   }
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			Pane mainPane = new Pane();
			mainPane.setPrefSize(1059, 710);
			mainPane.setStyle("-fx-background-color: white");

			javafx.scene.shape.Path path = new javafx.scene.shape.Path();
			path.setFill(Color.web("#3366FF"));

			double width = 200;
			double height = 790;
			double arcSize = 50;

			path.getElements().add(new MoveTo(0, 0));
			path.getElements().add(new HLineTo(width - arcSize));
			path.getElements().add(new QuadCurveTo(width, 0, width, arcSize));
			path.getElements().add(new VLineTo(height - arcSize));
			path.getElements().add(new QuadCurveTo(width, height, width - arcSize, height));
			path.getElements().add(new HLineTo(0));
			path.getElements().add(new VLineTo(0));

			Label l1 = new Label("Hello Manager");
			l1.setFont(Font.font("Comic Sans MS", 20));
			l1.setLayoutX(25);
			l1.setLayoutY(20);

			ImageView pro = new ImageView("order.png");
			pro.setFitWidth(50);
			pro.setFitHeight(30);

			Button product1 = new Button("Products", pro);
			product1.setLayoutX(11);

			Button product = new Button("Products", pro);
			product.setLayoutX(11);
			product.setLayoutY(80);
			product.setPrefSize(189, 50);
			product.setFont(Font.font("Comic Sans MS", 15));
			product.setStyle("-fx-background-color: #3366FF;");
			product.setOnMouseEntered(e1 -> product.setStyle("-fx-background-color: lightgray;"));
			product.setOnMouseExited(e1 -> product.setStyle("-fx-background-color: #3366FF;"));

			ImageView sup = new ImageView("supply-chain-management.png");

			sup.setFitWidth(50);
			sup.setFitHeight(30);

			Button supplier = new Button("supplier", sup);
			supplier.setLayoutX(11);
			supplier.setLayoutY(140);
			supplier.setPrefSize(189, 50);
			supplier.setFont(Font.font("System Bold", 15));
			supplier.setStyle("-fx-background-color: #3366FF;");
			supplier.setOnMouseEntered(e1 -> supplier.setStyle("-fx-background-color: lightgray;"));
			supplier.setOnMouseExited(e1 -> supplier.setStyle("-fx-background-color: #3366FF;"));

			ImageView det = new ImageView("resume.png");

			det.setFitWidth(50);
			det.setFitHeight(30);
			Button details = new Button("Details ", det);
			details.setLayoutX(11);
			details.setLayoutY(200);
			details.setPrefSize(189, 50);
			details.setFont(Font.font("System Bold", 15));
			details.setStyle("-fx-background-color: #3366FF;");
			details.setOnMouseEntered(e1 -> details.setStyle("-fx-background-color: lightgray;"));
			details.setOnMouseExited(e1 -> details.setStyle("-fx-background-color: #3366FF;"));

			ImageView aut = new ImageView("authority.png");

			aut.setFitWidth(50);
			aut.setFitHeight(30);

			Button Giving = new Button("authority", aut);
			Giving.setLayoutX(11);
			Giving.setLayoutY(260);
			Giving.setPrefSize(189, 50);
			Giving.setFont(Font.font("System Bold", 15));
			Giving.setStyle("-fx-background-color: #3366FF;");
			Giving.setOnMouseEntered(e1 -> Giving.setStyle("-fx-background-color: lightgray;"));
			Giving.setOnMouseExited(e1 -> Giving.setStyle("-fx-background-color: #3366FF;"));

			Image image = new Image("file:C:\\Users\\HP\\Downloads\\logout (1).png");

			ImageView set = new ImageView(image);
			set.setFitWidth(50);
			set.setFitHeight(30);

			Button Sitting = new Button("Logout", set);
			Sitting.setLayoutX(11);
			Sitting.setLayoutY(320);
			Sitting.setPrefSize(189, 50);
			Sitting.setFont(Font.font("System Bold", 15));
			Sitting.setStyle("-fx-background-color: #3366FF;");
			Sitting.setOnMouseEntered(e1 -> Sitting.setStyle("-fx-background-color: lightgray;"));
			Sitting.setOnMouseExited(e1 -> Sitting.setStyle("-fx-background-color: #3366FF;"));

			ImageView team = new ImageView("Settings.png");

			team.setFitWidth(500);
			team.setFitHeight(500);
			team.setLayoutX(550);

			team.setLayoutY(160);

			mainPane.getChildren().addAll(path, l1, product, supplier, details, Giving, team, Sitting);
			mainPane.setStyle("-fx-background-color: lightgray;");

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//mohammaddd nemere
			
			
			product.setOnAction(er -> {
				product.setStyle("-fx-background-color: lightgray;");
				product.setOnMouseExited(e1 -> product.setStyle("-fx-background-color: lightgray;"));
				supplier.setStyle("-fx-background-color: #3366FF;");
				Sitting.setStyle("-fx-background-color: #3366FF;");
				Giving.setStyle("-fx-background-color: #3366FF;");
				details.setStyle("-fx-background-color: #3366FF;");

				Label Product = new Label("Products");
				Product.setFont(new Font(40));
				Product.setLayoutX(750);
				Product.setLayoutY(30);

				ImageView pro1 = new ImageView("order.png");
				pro1.setFitWidth(100);
				pro1.setFitHeight(100);
				pro1.setLayoutX(1400);
				pro1.setLayoutY(20);
				mainPane.getChildren().clear();

				mainPane.getChildren().addAll(path, l1, product, supplier, details, Giving, Sitting);

				TableView<Product> table = new TableView<>();
				TableColumn<Product, Integer> productId = new TableColumn<>("productId");
				productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
				productId.setPrefWidth(150);
				TableColumn<Product, String> productName = new TableColumn<>("productName");
				productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
				productName.setPrefWidth(150);
				TableColumn<Product, String> Category = new TableColumn<>("Category");
				Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
				Category.setPrefWidth(150);
				TableColumn<Product, Double> price = new TableColumn<>("price");
				price.setCellValueFactory(new PropertyValueFactory<>("price"));
				price.setPrefWidth(150);
				TableColumn<Product, String> maincompany = new TableColumn<>("maincompany");
				maincompany.setCellValueFactory(new PropertyValueFactory<>("maincompany"));
				maincompany.setPrefWidth(150);
				TableColumn<Product, Integer> amount = new TableColumn<>("quantity");
				amount.setCellValueFactory(new PropertyValueFactory<>("quantity"));
				amount.setPrefWidth(150);
				table.getColumns().addAll(productId, productName, Category, price, maincompany);
				table.setPrefWidth(750);
				table.setLayoutX(450);
				table.setLayoutY(100);
				Button View = new Button("View Prudct");
				View.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
				View.setLayoutX(720);
				View.setLayoutY(550);
				View.setPrefHeight(46);
				View.setPrefWidth(190);
				View.setFont(Font.font("Comic Sans MS", 15));
				TextField search = new TextField();

				BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY);
				Background background = new Background(backgroundFill);
				search.setBackground(background);
				search.setPromptText("Search by name");
				search.setPrefWidth(150);
				search.setPrefHeight(35);
				search.setLayoutY(45);
				search.setLayoutX(950);

				Button sea = new Button();
				abloadproduct(table);

				search.setOnAction(event -> {

					abloadproduct(table, search.getText());

				});

				table.setOnMouseClicked(event -> {
					if (event.getClickCount() == 2) {
						selectedOrderDetail = table.getSelectionModel().getSelectedItem();
					}
				});
				View.setOnAction(e1 -> {
					if (selectedOrderDetail == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("choose any Order Product");
						alert.setHeaderText("select any product");
						alert.show();
						return;
					}

					Label productname = new Label("The product Name:" + selectedOrderDetail.getProductName());
					productname.setFont(new Font(30));
					Label infor = new Label("Operations on this production:");

					infor.setFont(new Font(20));

					TableView<order_detail> table1 = new TableView<>();
					TableColumn<order_detail, Integer> OrderDetailID = new TableColumn<>("OrderDetailID");
					OrderDetailID.setCellValueFactory(new PropertyValueFactory<>("OrderDetailID"));
					OrderDetailID.setPrefWidth(150);
					TableColumn<order_detail, Integer> OrderID = new TableColumn<>("OrderID");
					OrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
					OrderID.setPrefWidth(150);
					TableColumn<order_detail, Integer> ProductID = new TableColumn<>("ProductID");
					ProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
					ProductID.setPrefWidth(150);
					TableColumn<order_detail, Integer> OrderedQuantity = new TableColumn<>("OrderedQuantity");
					OrderedQuantity.setCellValueFactory(new PropertyValueFactory<>("OrderedQuantity"));
					OrderedQuantity.setPrefWidth(150);
					TableColumn<order_detail, Double> pric = new TableColumn<>("price");
					pric.setCellValueFactory(new PropertyValueFactory<>("price"));
					pric.setPrefWidth(150);
					table1.getColumns().addAll(OrderDetailID, OrderID, ProductID, OrderedQuantity, pric);
					table1.setPrefWidth(750);
					table1.setLayoutX(500);
					table1.setLayoutY(550);
					found(table1, selectedOrderDetail.getProductId());

					Pane productpane = new Pane();

					productname.setLayoutY(20);
					productname.setLayoutX(600);

					infor.setLayoutY(80);
					infor.setLayoutX(400);

					table1.setLayoutY(120);
					table1.setLayoutX(400);

					productpane.setStyle("-fx-background-color: lightgray;");

					Button insert = new Button("Insert");
					insert.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
					insert.setLayoutX(720);
					insert.setLayoutY(550);
					insert.setPrefHeight(46);
					insert.setPrefWidth(190);
					insert.setFont(Font.font("Comic Sans MS", 15));

					Button Delete = new Button("Delete");
					Delete.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
					Delete.setLayoutX(720);
					Delete.setLayoutY(550);
					Delete.setPrefHeight(46);
					Delete.setPrefWidth(190);
					Delete.setFont(Font.font("Comic Sans MS", 15));

					Button Ubdate = new Button("Ubdate");
					Ubdate.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
					Ubdate.setLayoutX(720);
					Ubdate.setLayoutY(550);
					Ubdate.setPrefHeight(46);
					Ubdate.setPrefWidth(190);
					Ubdate.setFont(Font.font("Comic Sans MS", 15));

					Button Information = new Button("Information about the sales process");
					Information.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
					Information.setLayoutX(720);
					Information.setLayoutY(550);
					Information.setPrefHeight(46);
					Information.setPrefWidth(300);
					
					Information.setFont(Font.font("Comic Sans MS", 15));
					HBox h2 = new HBox();
					h2.getChildren().add(Information);
					h2.setAlignment(Pos.CENTER);

					HBox h1 = new HBox();
					h1.getChildren().addAll(insert, Delete, Ubdate);

					h1.setSpacing(30);
					h1.setAlignment(Pos.CENTER);
					VBox vv = new VBox();
					vv.getChildren().addAll(h1, h2);
					vv.setLayoutX(450);
					vv.setLayoutY(600);
					vv.setSpacing(25);
					ImageView in = new ImageView("resume.png");
					in.setFitWidth(20);
					in.setFitHeight(20);
					Button information = new Button("Information about product", in);
					information.setStyle("-fx-background-color: #888888; -fx-background-radius: 30; -fx-padding: 20;");

					information.setPrefHeight(40);
					information.setPrefWidth(250);
					information.setFont(Font.font(15));
					information.setLayoutX(1200);
					information.setLayoutY(20);

					Label id = new Label("ID the product :");
					Label id1 = new Label(selectedOrderDetail.getProductId() + "");

					Label name = new Label("Name of the product : ");
					Label iname1 = new Label(selectedOrderDetail.getProductName() + "");

					Label Category1 = new Label("Category  the product :");
					Label Category2 = new Label(selectedOrderDetail.getCategory() + "");
					Label price1 = new Label("Price the product :   ");
					Label price2 = new Label("" + selectedOrderDetail.getPrice());

					Label maincompany1 = new Label("maincompany product :");

					Label maincompan1 = new Label("" + selectedOrderDetail.getMaincompany());

					Label amount1 = new Label("Amount product :");

					Label amount2 = new Label("" + selectedOrderDetail.getQuantity());

					GridPane gp = new GridPane();
					id.setFont(new Font(18));
					id1.setFont(new Font(18));
					name.setFont(new Font(18));
					iname1.setFont(new Font(18));
					Category1.setFont(new Font(18));
					Category2.setFont(new Font(18));
					price1.setFont(new Font(18));
					price2.setFont(new Font(18));
					maincompany1.setFont(new Font(18));
					maincompan1.setFont(new Font(18));
					amount1.setFont(new Font(18));
					amount2.setFont(new Font(18));

					gp.add(id, 0, 0);
					gp.add(id1, 1, 0);

					gp.add(name, 0, 1);
					gp.add(iname1, 1, 1);

					gp.add(Category1, 0, 2);
					gp.add(Category2, 1, 2);

					gp.add(price1, 0, 3);
					gp.add(price2, 1, 3);

					gp.add(maincompany1, 0, 4);
					gp.add(maincompan1, 1, 4);

					gp.add(amount1, 0, 5);
					gp.add(amount2, 1, 5);
					gp.setHgap(20);
					gp.setHgap(20);
					
					
					
					gp.setLayoutX(1160);
					gp.setLayoutY(120);

					gp.setHgap(30);
					gp.setVgap(30);
					gp.setPrefWidth(450);
					gp.setPrefHeight(250);
					
					Scene scene1 = new Scene(productpane, 1500, 800);
					primaryStage.setScene(scene1);
					Button b1 = new Button("Main Bage");
					b1.setFont(Font.font("Comic Sans MS", 15));
					b1.setLayoutX(25);
					b1.setLayoutY(20);
					b1.setPrefWidth(150);
					b1.setPrefHeight(5);
					
					
					
					information.setOnAction(M -> {
						productpane.getChildren().clear();
						productpane.getChildren().addAll(productname, infor, table1, vv, information, b1);
						productpane.getChildren().add(gp);
					});
					productpane.getChildren().addAll(productname, infor, table1, vv, information, b1);
					b1.setStyle("-fx-background-color: #888888; -fx-background-radius: 30; -fx-padding: 20;");

					b1.setOnAction(M -> {

						selectedOrderDetail = null;
						primaryStage.setScene(scene);

					});

					insert.setOnAction(er1 -> {
						
						Label nameof = new Label("The Name of costumer : ");
						TextField tid = new TextField();

						Label phone = new Label("The phone of costumer : ");
						TextField tphone = new TextField();

						Label address = new Label("The Adrees of costumer: ");
						TextField taddress = new TextField();
						
						nameof.setFont(new Font(20));
						phone.setFont(new Font(20));
						address.setFont(new Font(20));
						
						
						
						tid.setPrefHeight(35);
						tid.setPrefWidth(190);
						tid.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");
						
						
						taddress.setPrefHeight(35);
						taddress.setPrefWidth(190);
						taddress.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");
						
						tphone.setPrefHeight(35);
						tphone.setPrefWidth(190);
						tphone.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");
						
						

						Label qun = new Label("Insert Quntity : ");
						qun.setFont(new Font(20));
						ComboBox<Integer> tqun = new ComboBox<>();
						for (int i = 1; i < 100; i++) {
							tqun.getItems().add(i);
						}
						tqun.setValue(1);
						Button bb = new Button("Done");
						GridPane gp1 = new GridPane();
						gp1.add(nameof, 0, 0);
						gp1.add(tid, 1, 0);

						gp1.add(phone, 0, 1);
						gp1.add(tphone, 1, 1);

						gp1.add(address, 0, 2);
						gp1.add(taddress, 1, 2);

						gp1.add(qun, 0, 3);
						gp1.add(tqun, 1, 3);

						gp1.setHgap(20);
						gp1.setVgap(20);
						
						gp1.setAlignment(Pos.CENTER);
						
						VBox v2 = new VBox();
						v2.getChildren().addAll(gp1, bb);
						v2.setSpacing(20);
					
						
						
					
						v2.setAlignment(Pos.CENTER);
						StackPane s1=new StackPane();
						ImageView in1 = new ImageView("resume.png");
						in1.setFitWidth(800);
						in1.setFitHeight(600);
						in1.setOpacity(0.6); 
						s1.setStyle("-fx-background-color: lightgray;");
						s1.getChildren().addAll(in1,v2);
						Scene s3=new Scene(s1,1500,800);
						primaryStage.setScene(s3);
						
						
						bb.setOnAction(er2 -> {
							if (tid.getText() != "") {
								try {
									if (tqun.getValue() > selectedOrderDetail.getQuantity()) {

										Alert alert = new Alert(AlertType.ERROR);
										alert.setTitle("choose any Order Product");
										alert.setHeaderText("There is no such quantity");
										alert.show();
										return;
										
										
										
										
										
									}

									String sql;

									sql = "INSERT INTO customer (CustomerName, CustomerAddress, CustomerPhone, age) VALUES ( ?, ?, ?, ?)";

									preparedStatement = con.prepareStatement(sql);
									preparedStatement.setString(1, tid.getText());
									preparedStatement.setString(2, taddress.getText());
									preparedStatement.setString(3, tphone.getText());
									preparedStatement.setInt(4, 0);
									preparedStatement.executeUpdate();

									int i = 0;
									boolean r = true;
									for (; r;) {
										i++;
										r = false;

										for (int j = 0; j < order.size(); j++) {

											if (order.get(j).order_Id == i) {
												r = true;
												break;
											}
										}

									}

									
									
									
									
									sql = "INSERT INTO order_Request (OrderID, OrderDate, CustomerID, ShippingAddress, PaymentMethod) VALUES (?, ?, ?, ?, ?)";
									preparedStatement = con.prepareStatement(sql);
									preparedStatement.setInt(1, i);
									preparedStatement.setDate(2, null);
									preparedStatement.setInt(3, give_last());
									preparedStatement.setString(4, null);
									preparedStatement.setString(5, null);
									preparedStatement.executeUpdate();
									int or = i;
									i = 0;
									r = true;
									for (; r;) {
										i++;
										r = false;

										for (int j = 0; j < prduct_Dettels.size(); j++) {

											if (prduct_Dettels.get(j).getOrderDetailID() == i) {
												r = true;
											}
										}

									}

									sql = "INSERT INTO order_detail (OrderDetailID, OrderID, ProductID, OrderedQuantity, Price) VALUES (?, ?, ?, ?, ?)";
									preparedStatement = con.prepareStatement(sql);
									preparedStatement.setInt(1, i);
									preparedStatement.setInt(2, or);
									preparedStatement.setInt(3, selectedOrderDetail.getProductId());
									preparedStatement.setInt(4, tqun.getValue());
									preparedStatement.setDouble(5, tqun.getValue() * selectedOrderDetail.getPrice());
									preparedStatement.executeUpdate();
									table1.getItems().clear();
									abload();
									found(table1, selectedOrderDetail.getProductId());
//									productpane.getChildren().clear();
//									productpane.getChildren().addAll(productname, infor, table1, h1, information, b1);
									abdateneg(selectedOrderDetail.getProductId(), tqun.getValue(),
											selectedOrderDetail.getQuantity());
									selectedOrderDetail
											.setQuantity(selectedOrderDetail.getQuantity() - tqun.getValue());
									amount2.setText("" + selectedOrderDetail.getQuantity());
							
									primaryStage.setScene(scene1);									
									return;

								} catch (ClassNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

							}
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("choose any Order Product");
							alert.setHeaderText("please enter valid data");
							alert.show();
							productpane.getChildren().clear();
							productpane.getChildren().addAll(productname, infor, table1, vv, information, b1);

						});

					});
					table1.setOnMouseClicked(event -> {
						if (event.getClickCount() == 2) {
							selectedOrderDetail1 = table1.getSelectionModel().getSelectedItem();
						}
					});
					Delete.setOnAction(M -> {
						productpane.getChildren().clear();
						productpane.getChildren().addAll(productname, infor, table1, vv, information, b1);
						if (selectedOrderDetail1 == null) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("choose any Order Product");
							alert.setHeaderText("select any Order");
							alert.show();
							return;

						}
						String sql = "DELETE FROM order_detail WHERE OrderDetailID = ?";
						try {
							preparedStatement = con.prepareStatement(sql);

							preparedStatement.setInt(1, selectedOrderDetail1.getOrderDetailID());
							preparedStatement.executeUpdate();
							abload();
							found(table1, selectedOrderDetail.getProductId());
							abdatepos(prduct.get(n).getProductId(), selectedOrderDetail1.getOrderedQuantity(),
									prduct.get(n).getQuantity());
							selectedOrderDetail.setQuantity(
									selectedOrderDetail.getQuantity() + selectedOrderDetail1.getOrderedQuantity());
							amount2.setText("" + selectedOrderDetail.getQuantity());

							selectedOrderDetail1 = null;
						} catch (ClassNotFoundException e2) {
							e2.printStackTrace();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
					});
					Information.setOnAction(H -> {
						productpane.getChildren().clear();
						productpane.getChildren().addAll(productname, infor, table1, vv, information, b1);
						
						if (selectedOrderDetail1 == null) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("choose any Order Product");
							alert.setHeaderText("select any Order");
							alert.show();
							return;

						}
						Label nameof = new Label("The Name of costumer:");

						Label phone = new Label("The phone of costumer:");

						Label address = new Label("The Adrees of costumer:");
						try {
							Class.forName("com.mysql.jdbc.Driver");
							con = (Connection) DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/project?characterEncoding=utf8", "root", "1234");
							Statement stmt = (Statement) con.createStatement();
							String query = "SELECT DISTINCT  C.CustomerID ,C.CustomerName,CustomerAddress, CustomerPhone \r\n"
									+ "FROM customer C, order_Request O, order_detail OD WHERE C.CustomerID = O.CustomerID "
									+ "AND O.OrderID = OD.OrderID and OD.OrderDetailID="
									+ selectedOrderDetail1.getOrderDetailID() + ";";
							ResultSet rs = stmt.executeQuery(query);

							while (rs.next()) {
								costmerid = rs.getInt("CustomerID");
								CustomerName = rs.getString("CustomerName");
								CustomerPhone = rs.getString("CustomerPhone");
								
								nameof.setText("The Name of costumer    : "+CustomerName);
							 	 phone.setText("The phone of costumer   : " +CustomerPhone);
							   address.setText("The Adrees of costumer  : "+rs.getString("CustomerAddress"));

							}
							nameof.setPrefWidth(400);
							phone.setPrefWidth(400);
							address.setPrefWidth(400);
							nameof.setFont(new Font(17));
							phone.setFont(new Font(17));
							address.setFont(new Font(17));
							VBox v2=new VBox();
							v2.getChildren().addAll(nameof,phone,address);
							v2.setSpacing(20);
							v2.setAlignment(Pos.CENTER);
							v2.setLayoutX(1155);
							v2.setLayoutY(150);
							productpane.getChildren().addAll(v2);
							
						} catch (Exception e2) {
							// TODO: handle exception
						}

					});

					Ubdate.setOnAction(M -> {
						productpane.getChildren().clear();
						productpane.getChildren().addAll(productname, infor, table1, vv, information, b1);
						
						
						if (selectedOrderDetail1 == null) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("choose any Order Product");
							alert.setHeaderText("select any Order");
							alert.show();
							return;

						}

						Label nameof = new Label("The Name of costumer:");
						TextField tid = new TextField();

						Label phone = new Label("The phone of costumer:");
						TextField tphone = new TextField();

						Label address = new Label("The Adrees of costumer:");
						TextField taddress = new TextField();

						Label qun = new Label("Insert Quntity :");
						ComboBox<Integer> tqun = new ComboBox<>();
						for (int i = 1; i < 100; i++) {
							tqun.getItems().add(i);
						}
						tqun.setValue(1);
						Button bb = new Button("Done");

						GridPane gp1 = new GridPane();
						gp1.add(nameof, 0, 0);
						gp1.add(tid, 1, 0);

						gp1.add(phone, 0, 1);
						gp1.add(tphone, 1, 1);

						gp1.add(address, 0, 2);
						gp1.add(taddress, 1, 2);

						gp1.add(qun, 0, 3);
						gp1.add(tqun, 1, 3);

						gp1.setHgap(20);
						gp1.setVgap(20);
						gp1.setStyle("-fx-grid-lines-visible: true;");
						VBox v2 = new VBox();
						v2.getChildren().addAll(gp1, bb);
						v2.setSpacing(20);
						v2.setLayoutX(50);
						v2.setLayoutY(200);

						v2.setAlignment(Pos.CENTER);
						productpane.getChildren().add(v2);

						try {
							Class.forName("com.mysql.jdbc.Driver");
							con = (Connection) DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/project?characterEncoding=utf8", "root", "1234");
							Statement stmt = (Statement) con.createStatement();
							String query = "SELECT DISTINCT  C.CustomerID ,C.CustomerName,CustomerAddress, CustomerPhone \r\n"
									+ "FROM customer C, order_Request O, order_detail OD WHERE C.CustomerID = O.CustomerID "
									+ "AND O.OrderID = OD.OrderID and OD.OrderDetailID="
									+ selectedOrderDetail1.getOrderDetailID() + ";";
							ResultSet rs = stmt.executeQuery(query);

							while (rs.next()) {
								costmerid = rs.getInt("CustomerID");
								CustomerName = rs.getString("CustomerName");
								CustomerPhone = rs.getString("CustomerPhone");
								tid.setText(CustomerName);
								tphone.setText(CustomerPhone);
								CustomerAddress = rs.getString("CustomerAddress");
								taddress.setText(CustomerAddress);

							}

							bb.setOnAction(Mn -> {
								if ((tqun.getValue() - selectedOrderDetail1.getOrderDetailID()) > selectedOrderDetail
										.getQuantity()) {

									Alert alert = new Alert(AlertType.ERROR);
									alert.setTitle("choose any Order Product");
									alert.setHeaderText("There is no such quantity");
									alert.show();
									productpane.getChildren().clear();
									productpane.getChildren().addAll(productname, infor, table1, vv, b1);
									return;

								}

								if (tid.getText().compareTo(CustomerName) != 0
										|| tphone.getText().compareTo(CustomerPhone) != 0
										|| taddress.getText().compareTo(CustomerAddress) != 0) {
									try {
										ubdateCostmer(costmerid, tid.getText(), tphone.getText(), taddress.getText());
									} catch (SQLException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
								}
								if (tqun.getValue() != selectedOrderDetail1.getOrderedQuantity()) {

									try {
										ubdate_Details_quntity(selectedOrderDetail1.getOrderDetailID(),
												tqun.getValue());
									} catch (SQLException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}

									if (tqun.getValue() > selectedOrderDetail1.getOrderedQuantity()) {
										try {

											abdateneg(selectedOrderDetail.getProductId(),
													(tqun.getValue() - selectedOrderDetail1.getOrderedQuantity()),
													selectedOrderDetail.getQuantity());
											selectedOrderDetail.setQuantity(selectedOrderDetail.getQuantity()
													- (tqun.getValue() - selectedOrderDetail1.getOrderedQuantity()));
											amount2.setText("" + selectedOrderDetail.getQuantity());

											abload();
											found(table1, selectedOrderDetail.getProductId());

											selectedOrderDetail1 = null;
										} catch (SQLException e2) {
											// TODO Auto-generated catch block
											e2.printStackTrace();
										} catch (ClassNotFoundException e2) {
											// TODO Auto-generated catch block
											e2.printStackTrace();
										}
									} else {
										try {
											abdatepos(selectedOrderDetail.getProductId(),
													selectedOrderDetail1.getOrderedQuantity() - tqun.getValue(),
													selectedOrderDetail.getQuantity());
											selectedOrderDetail.setQuantity(selectedOrderDetail.getQuantity()
													+ selectedOrderDetail1.getOrderedQuantity() - tqun.getValue());
											amount2.setText("" + selectedOrderDetail.getQuantity());
											abload();
											found(table1, selectedOrderDetail.getProductId());
											selectedOrderDetail1 = null;
										} catch (SQLException e2) {
											// TODO Auto-generated catch block
											e2.printStackTrace();
										} catch (ClassNotFoundException e2) {

											e2.printStackTrace();
										}
									}
								}

								productpane.getChildren().clear();
								productpane.getChildren().addAll(productname, infor, table1, vv, information, b1, gp);

							});
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					});

				});

				mainPane.getChildren().addAll(Product, pro1, table, View, search);

			});
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//rami  remaiwee
			supplier.setOnAction(er -> {

				supplier.setStyle("-fx-background-color: lightgray;");
				supplier.setOnMouseExited(e1 -> supplier.setStyle("-fx-background-color: lightgray;"));
				product.setStyle("-fx-background-color: #3366FF;");
				Sitting.setStyle("-fx-background-color: #3366FF;");
				Giving.setStyle("-fx-background-color: #3366FF;");
				details.setStyle("-fx-background-color: #3366FF;");
				Label Product = new Label("Supplairs");
				Product.setFont(new Font(40));
				Product.setLayoutX(750);
				Product.setLayoutY(30);

				TableView<supplier> table1 = new TableView<>();
				TableColumn<supplier, Integer> SupplierID = new TableColumn<>("SupplierID");
				SupplierID.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
				SupplierID.setPrefWidth(185);
				TableColumn<supplier, String> name = new TableColumn<>("name");
				name.setCellValueFactory(new PropertyValueFactory<>("name"));
				name.setPrefWidth(185);
				TableColumn<supplier, String> type = new TableColumn<>("type");
				type.setCellValueFactory(new PropertyValueFactory<>("type"));
				type.setPrefWidth(185);
				TableColumn<supplier, String> phone = new TableColumn<>("phone");
				phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
				phone.setPrefWidth(185);

				table1.getColumns().addAll(SupplierID, name, type, phone);
				table1.setPrefWidth(740);
				table1.setLayoutX(485);
				table1.setLayoutY(100);

				Button View = new Button("View Supplirs");

				View.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");

				View.setPrefHeight(46);
				View.setPrefWidth(190);
				View.setFont(Font.font("Comic Sans MS", 15));

				Button add = new Button("Add Supplirs");
				add.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
				add.setLayoutX(720);
				add.setLayoutY(550);
				add.setPrefHeight(46);
				add.setPrefWidth(190);
				add.setFont(Font.font("Comic Sans MS", 15));

				Button Delet = new Button("Delete Supplirs");
				Delet.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
				Delet.setLayoutX(720);
				Delet.setLayoutY(550);
				Delet.setPrefHeight(46);
				Delet.setPrefWidth(190);
				Delet.setFont(Font.font("Comic Sans MS", 15));

				Button ubdate = new Button("Ubdate Supplirs");
				ubdate.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
				ubdate.setLayoutX(720);
				ubdate.setLayoutY(550);
				ubdate.setPrefHeight(46);
				ubdate.setPrefWidth(190);
				ubdate.setFont(Font.font("Comic Sans MS", 15));

				HBox h1 = new HBox();
				h1.getChildren().addAll(Delet, add, ubdate);
				h1.setSpacing(45);
				h1.setAlignment(Pos.CENTER);

				HBox jh = new HBox();
				jh.getChildren().addAll(View);

				jh.setAlignment(Pos.CENTER);

				VBox v1 = new VBox();
				v1.getChildren().addAll(h1, jh);
				v1.setSpacing(25);
				v1.setLayoutX(530);
				v1.setLayoutY(550);

				TextField search = new TextField();

				BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY);
				Background background = new Background(backgroundFill);
				search.setBackground(background);
				search.setPromptText("Search by name");
				search.setPrefWidth(150);
				search.setPrefHeight(35);
				search.setLayoutY(45);
				search.setLayoutX(950);
				abloudSuppliers(table1);
				Button sea = new Button();

				search.setOnAction(event -> {

					searchSuppliers(table1, search.getText());

				});

				table1.setOnMouseClicked(event -> {
					if (event.getClickCount() == 2) {
						supp = table1.getSelectionModel().getSelectedItem();
					}
				});
				Pane suppPain = new Pane();

				ImageView div = new ImageView("supply-chain-management.png");

				mainPane.getChildren().clear();
				div.setFitHeight(100);
				div.setFitWidth(100);
				div.setLayoutX(1380);
				div.setLayoutY(20);

				mainPane.getChildren().addAll(path, l1, div, product, supplier, details, Giving, Sitting);
				mainPane.setStyle("-fx-background-color: lightgray;");
				mainPane.getChildren().addAll(Product, table1, v1, search);

				Label nameof = new Label("The Name of supplier : ");
				nameof.setFont(new Font(17));
				TextField tid = new TextField();
				tid.setPrefHeight(46);
				tid.setPrefWidth(190);
				tid.setPrefHeight(35);
				tid.setPrefWidth(190);
				tid.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");
				Label phon = new Label("The phone of costumer : ");
				phon.setFont(new Font(17));
				TextField tphone = new TextField();
				phon.setPrefHeight(46);
				phon.setPrefWidth(190);
				tphone.setPrefHeight(35);
				tphone.setPrefWidth(190);
				tphone.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");
				Label typ = new Label("The type of Product : ");
				TextField taddress = new TextField();
				typ.setFont(new Font(17));
				typ.setPrefHeight(35);
				typ.setPrefWidth(190);
				taddress.setPrefHeight(40);
				taddress.setPrefWidth(190);
				taddress.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");
				Button bb = new Button("Done");
				GridPane gp1 = new GridPane();
				gp1.add(nameof, 0, 0);
				gp1.add(tid, 1, 0);
				gp1.add(phon, 0, 1);
				gp1.add(tphone, 1, 1);
				gp1.add(typ, 0, 2);
				gp1.add(taddress, 1, 2);

				gp1.setHgap(17);
				gp1.setVgap(20);

				VBox v2 = new VBox();
				v2.getChildren().addAll(gp1, bb);
				v2.setSpacing(20);
				v2.setLayoutX(210);
				v2.setLayoutY(200);

				v2.setAlignment(Pos.CENTER);

				ubdate.setOnAction(en -> {

					if (supp == null) {
						Alert al = new Alert(AlertType.ERROR);
						al.setHeaderText("Select any data");
						al.show();
						return;

					}

					tid.setText(supp.getName());
					tphone.setText(supp.getPhone());
					taddress.setText(supp.getType());

					mainPane.getChildren().clear();
					mainPane.getChildren().addAll(path, l1, div, product, supplier, details, Giving, Sitting);
					mainPane.setStyle("-fx-background-color: lightgray;");

					mainPane.getChildren().addAll(Product, table1, search);

					table1.setLayoutX(table1.getLayoutX() + 150);
					mainPane.getChildren().add(v2);
					bb.setOnAction(MN -> {

						if (tid.getText() == "" || tphone.getText() == "" || taddress.getText() == "") {

							Alert al = new Alert(AlertType.ERROR);
							al.setHeaderText("Insert data");
							al.show();
							mainPane.getChildren().clear();
							mainPane.getChildren().addAll(path, l1, div, product, supplier, v1, details, Giving,
									Sitting);
							mainPane.setStyle("-fx-background-color: lightgray;");
							table1.setLayoutX(table1.getLayoutX() - 150);
							mainPane.getChildren().addAll(Product, table1, search);
							return;

						}

						String sql = "UPDATE supplier SET SupplierName=?,SupplierPhone=?,productType=? WHERE SupplierID=?";
						try {
							preparedStatement = con.prepareStatement(sql);
							preparedStatement.setString(1, tid.getText().trim());
							preparedStatement.setString(2, tphone.getText().trim());
							preparedStatement.setString(3, taddress.getText().trim());
							preparedStatement.setInt(4, supp.getSupplierID());
							preparedStatement.executeUpdate();
							abload();
						} catch (SQLException | ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

						abloudSuppliers(table1);
						mainPane.getChildren().clear();
						mainPane.getChildren().addAll(path, l1, div, product, supplier, v1, details, Giving, Sitting);
						mainPane.setStyle("-fx-background-color: lightgray;");

						table1.setLayoutX(table1.getLayoutX() - 150);
						mainPane.getChildren().addAll(Product, table1, search);

					});

				});

				add.setOnAction(Mn -> {
					tid.setText("");
					tphone.setText("");
					taddress.setText("");

					mainPane.getChildren().clear();
					mainPane.getChildren().addAll(path, l1, div, product, supplier, details, Giving, Sitting);
					mainPane.setStyle("-fx-background-color: lightgray;");

					mainPane.getChildren().addAll(Product, table1, search);

					table1.setLayoutX(table1.getLayoutX() + 150);
					mainPane.getChildren().add(v2);
					bb.setOnAction(MN -> {

						if (tid.getText() == "" || tphone.getText() == "" || taddress.getText() == "") {

							Alert al = new Alert(AlertType.ERROR);
							al.setHeaderText("Insert data");
							al.show();
							mainPane.getChildren().clear();
							mainPane.getChildren().addAll(path, l1, div, product, supplier, v1, details, Giving,
									Sitting);
							mainPane.setStyle("-fx-background-color: lightgray;");
							table1.setLayoutX(table1.getLayoutX() - 150);
							mainPane.getChildren().addAll(Product, table1, search);
							return;

						}

						String sql = "INSERT INTO supplier (SupplierName, productType, SupplierPhone) VALUES ( ?, ?, ?)";
						try {
							preparedStatement = con.prepareStatement(sql);
							preparedStatement.setString(1, tid.getText().trim());
							preparedStatement.setString(2, taddress.getText().trim());
							preparedStatement.setString(3, tphone.getText().trim());

							preparedStatement.executeUpdate();
							try {
								abload();
							} catch (ClassNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							abloudSuppliers(table1);
							mainPane.getChildren().clear();
							mainPane.getChildren().addAll(path, l1, div, product, supplier, v1, details, Giving,
									Sitting);
							mainPane.setStyle("-fx-background-color: lightgray;");

							table1.setLayoutX(table1.getLayoutX() - 150);
							mainPane.getChildren().addAll(Product, table1, search);
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					});

				});

				Delet.setOnAction(M -> {
					if (supp == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("choose any Order Product");
						alert.setHeaderText("select any product");
						alert.show();
						return;
					}

					try {

						String sql = "DELETE FROM supplier WHERE SupplierID = ?";

						preparedStatement = con.prepareStatement(sql);
						preparedStatement.setInt(1, supp.getSupplierID());

						preparedStatement.executeUpdate();
						abload();
						abloudSuppliers(table1);

					} catch (Exception e2) {
						e2.printStackTrace();
					}

				});

				//end r-amiiii--------------------
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//mohammadd nemeerrrrrrrrrrr
				
				View.setOnAction(M -> {

					if (supp == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("choose any Order Product");
						alert.setHeaderText("select any product");
						alert.show();
						return;
					}

					Label productname = new Label("The supplier Name:" + supp.getName());
					productname.setFont(new Font(30));
					Label infor = new Label("The products it offers:");
					infor.setFont(new Font(20));
					TableView<Product_Supplier> table = new TableView<>();
					TableColumn<Product_Supplier, Integer> ProductID = new TableColumn<>("ProductID");
					ProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
					ProductID.setPrefWidth(100);
					TableColumn<Product_Supplier, String> ProductName = new TableColumn<>("ProductName");
					ProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
					ProductName.setPrefWidth(100);
					TableColumn<Product_Supplier, String> Category = new TableColumn<>("Category");
					Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
					Category.setPrefWidth(100);
					TableColumn<Product_Supplier, Double> Price = new TableColumn<>("Price");
					Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
					Price.setPrefWidth(100);

					TableColumn<Product_Supplier, String> maincompany = new TableColumn<>("maincompany");
					maincompany.setCellValueFactory(new PropertyValueFactory<>("maincompany"));
					maincompany.setPrefWidth(100);

					TableColumn<Product_Supplier, Integer> suplairs = new TableColumn<>("suplairs");
					suplairs.setCellValueFactory(new PropertyValueFactory<>("suplairs"));
					suplairs.setPrefWidth(100);

					table.getColumns().addAll(ProductID, ProductName, Category, Price, maincompany, suplairs);
					table.setPrefWidth(600);
					table.setLayoutX(450);
					table.setLayoutY(550);

					Supply newn = new Supply(1232, 1222, "sds", 45);

					foundsupply(table, supp.getSupplierID());

					Pane productpane = new Pane();
					productname.setLayoutY(20);
					productname.setLayoutX(600);
					infor.setLayoutY(80);
					infor.setLayoutX(460);
					table.setLayoutY(120);
					table.setLayoutX(460);
					productpane.setStyle("-fx-background-color: lightgray;");

					Button insert1 = new Button("Insert");
					insert1.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
					insert1.setLayoutX(720);
					insert1.setLayoutY(550);
					insert1.setPrefHeight(46);
					insert1.setPrefWidth(190);
					insert1.setFont(Font.font("Comic Sans MS", 15));

					Button Delete = new Button("Delete");
					Delete.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
					Delete.setLayoutX(720);
					Delete.setLayoutY(550);
					Delete.setPrefHeight(46);
					Delete.setPrefWidth(190);
					Delete.setFont(Font.font("Comic Sans MS", 15));

					HBox hh = new HBox();
					hh.getChildren().addAll(insert1, Delete);

					hh.setSpacing(30);
					hh.setAlignment(Pos.CENTER);
					hh.setLayoutX(600);
					hh.setLayoutY(560);

					ImageView in = new ImageView("resume.png");
					in.setFitWidth(20);
					in.setFitHeight(20);
					Button information = new Button("Information about Supplier", in);
					information.setStyle("-fx-background-color: #888888; -fx-background-radius: 30; -fx-padding: 20;");
					information.setPrefHeight(40);
					information.setPrefWidth(250);
					information.setFont(Font.font(15));
					information.setLayoutX(1200);
					information.setLayoutY(20);

					Scene scene1 = new Scene(productpane, 1500, 800);
					primaryStage.setScene(scene1);
					Button b1 = new Button("Main Bage");
					b1.setFont(Font.font("Comic Sans MS", 15));
					b1.setLayoutX(25);
					b1.setLayoutY(20);
					b1.setPrefWidth(150);
					b1.setPrefHeight(5);

					Spinner<Integer> quantitySpinner = new Spinner<>();
					SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
							100, 0);
					quantitySpinner.setValueFactory(valueFactory);
					quantitySpinner.setPrefWidth(80);

					Button bay = new Button("Bay");
					bay.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
					bay.setPrefHeight(46);
					bay.setPrefWidth(190);
					bay.setFont(Font.font("Comic Sans MS", 15));
					HBox hb = new HBox();
					hb.setSpacing(20);
					hb.getChildren().addAll(bay, quantitySpinner);
					hb.setAlignment(Pos.CENTER);
					hb.setLayoutX(700);
					hb.setLayoutY(630);
					productpane.getChildren().addAll(productname, infor, table, hh, information, b1, hb);
					table.setOnMouseClicked(event -> {
						if (event.getClickCount() == 2) {
							supplay = table.getSelectionModel().getSelectedItem();
						}
					});

					insert1.setOnAction(er1 -> {

						Label nameofLabel = new Label("Product Name : ");
						TextField tidField = new TextField();
						tidField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

						tidField.setPrefHeight(35);
						tidField.setPrefWidth(190);

						Label phoneLabel = new Label("Category : ");
						TextField tphoneField = new TextField();

						tphoneField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

						tphoneField.setPrefHeight(35);
						tphoneField.setPrefWidth(190);
						Label address = new Label("Price: ");
						TextField tPrice = new TextField();

						tPrice.setPrefHeight(35);
						tPrice.setPrefWidth(190);
						tPrice.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

						Label qun = new Label("main company : ");
						TextField compani = new TextField();
						compani.setPrefHeight(35);
						compani.setPrefWidth(190);
						compani.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

						Button bb1 = new Button("Done");

						GridPane gp = new GridPane();
						gp.add(nameofLabel, 0, 0);
						gp.add(tidField, 1, 0);

						gp.add(phoneLabel, 0, 1);
						gp.add(tphoneField, 1, 1);

						gp.add(address, 0, 2);
						gp.add(tPrice, 1, 2);

						gp.add(qun, 0, 3);
						gp.add(compani, 1, 3);

						gp.setHgap(20);
						gp.setVgap(20);

						VBox vv = new VBox();
						vv.getChildren().addAll(gp, bb1);
						vv.setSpacing(20);
						vv.setLayoutX(50);
						vv.setLayoutY(200);
						vv.setAlignment(Pos.CENTER);
						productpane.getChildren().add(vv);

						bb1.setOnAction(T -> {

							if (tidField.getText() == "" || tphoneField.getText() == "" || tPrice.getText() == ""
									|| compani.getText() == "") {
								Alert al = new Alert(AlertType.ERROR);
								al.setHeaderText(null);
								al.setContentText("Enter Data");
								al.showAndWait();
								return;
							}
							try {
								Integer.parseInt(tPrice.getText().trim());
							} catch (Exception e6) {
								Alert al = new Alert(AlertType.ERROR);
								al.setHeaderText(null);
								al.setContentText("Enter Numric  Data in price");
								al.showAndWait();
								return;
							}

							String sql = "INSERT INTO All_product (ProductName, Category,Price,maincompany,SupplierID) VALUES (?,?,?,?,?)";
							try {
								preparedStatement = con.prepareStatement(sql);
								preparedStatement.setString(1, tidField.getText().trim());
								preparedStatement.setString(2, tphoneField.getText().trim());
								preparedStatement.setInt(3, Integer.parseInt(tPrice.getText().trim()));
								preparedStatement.setString(4, compani.getText());
								preparedStatement.setInt(5, supp.getSupplierID());
								preparedStatement.executeUpdate();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							productpane.getChildren().clear();
							try {
								abload();
							} catch (ClassNotFoundException | SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							foundsupply(table, supp.getSupplierID());
							productpane.getChildren().addAll(productname, infor, table, hh, information, b1, hb);

						});

					});

					bay.setOnAction(y -> {
						if (quantitySpinner.getValue() == 0) {
							Alert al = new Alert(AlertType.ERROR);
							al.setHeaderText(null);
							al.setContentText("Choose quantity");

							al.showAndWait();
							return;
						}
						if (supplay == null) {
							Alert al = new Alert(AlertType.ERROR);
							al.setHeaderText(null);
							al.setContentText("Choose any product");
							al.showAndWait();
							return;
						}
						if (exist(supplay.getProductID())) {
							for (int i = 0; i < prduct.size(); i++) {
								if (prduct.get(i).getProductId() == supplay.getProductID()) {
									try {
										abload();
										Ubdate_Quntity(quantitySpinner.getValue(), prduct.get(i).getProductId(),
												prduct.get(i).getQuantity());
										Alert al = new Alert(AlertType.INFORMATION);
										al.setHeaderText(null);
										al.setContentText("The operation succeeded");
										al.showAndWait();
										abload();
										supplay = null;
										return;
									} catch (SQLException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									} catch (ClassNotFoundException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
								}
							}
						} else {

							String sql = "INSERT INTO product (ProductID, ProductName,Category,Price,maincompany,amount) VALUES (?,?,?,?,?,?)";
							try {
								preparedStatement = con.prepareStatement(sql);
								preparedStatement.setInt(1, supplay.getProductID());
								preparedStatement.setString(2, supplay.getProductName());
								preparedStatement.setString(3, supplay.getCategory());
								preparedStatement.setDouble(4, supplay.getPrice());
								preparedStatement.setString(5, supplay.getMaincompany());
								preparedStatement.setInt(6, quantitySpinner.getValue());
								preparedStatement.executeUpdate();
								abload();
								Alert al = new Alert(AlertType.INFORMATION);
								al.setHeaderText(null);
								al.setContentText("The operation succeeded");
								al.showAndWait();
								abload();
								supplay = null;
								return;

							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (ClassNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}

						}

					});
					Delete.setOnAction(er5 -> {

						if (supplay == null) {
							Alert al = new Alert(AlertType.ERROR);
							al.setHeaderText(null);
							al.setContentText("Choose any product");
							al.showAndWait();
							return;

						}

						try {

							String sql = "DELETE FROM All_product WHERE ProductID = ?";
							System.out.println("RRRRRRRRRRRRRRR");
							preparedStatement = con.prepareStatement(sql);
							preparedStatement.setInt(1, supplay.getProductID());
							preparedStatement.executeUpdate();
							abload();

							foundsupply(table, supp.getSupplierID());
						} catch (ClassNotFoundException e2) {
							e2.printStackTrace();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}

						supplay = null;

					});

					b1.setStyle("-fx-background-color: #888888; -fx-background-radius: 30; -fx-padding: 20;");
					Label id = new Label("ID the supplier :");
					Label id1 = new Label(supp.getSupplierID() + "");

					Label names = new Label("Name of the supplier : ");
					Label iname1 = new Label(supp.getName() + "");

					Label Category1 = new Label("Product Type :");
					Label Category2 = new Label(supp.getType() + "");
					Label price1 = new Label("Supplier Phone :   ");
					Label price2 = new Label("" + supp.getPhone());

					GridPane gp = new GridPane();
					id.setFont(new Font(18));
					id1.setFont(new Font(18));
					names.setFont(new Font(18));
					iname1.setFont(new Font(18));
					Category1.setFont(new Font(18));
					Category2.setFont(new Font(18));
					price1.setFont(new Font(18));
					price2.setFont(new Font(18));

					gp.add(id, 0, 0);
					gp.add(id1, 1, 0);

					gp.add(names, 0, 1);
					gp.add(iname1, 1, 1);

					gp.add(Category1, 0, 2);
					gp.add(Category2, 1, 2);

					gp.add(price1, 0, 3);
					gp.add(price2, 1, 3);

					gp.setStyle("-fx-grid-lines-visible: true; -fx-border-color: black; -fx-border-width: 1;");
					gp.setLayoutX(1180);
					gp.setLayoutY(120);

					gp.setHgap(20);
					gp.setVgap(20);
					gp.setPrefWidth(380);
					gp.setPrefHeight(175);

					information.setOnAction(Mn -> {
						try {
							
							productpane.getChildren().add(gp);
						} catch (Exception nm) {
							// TODO: handle exception
						}
						
					});

					b1.setOnAction(M1 -> {
						primaryStage.setScene(scene);
					});

				});
				
				
				//end mohammmaddddddddddddddd

			});

			Sitting.setOnAction(er -> {

				Sitting.setStyle("-fx-background-color: lightgray;");
				Sitting.setOnMouseExited(e1 -> Sitting.setStyle("-fx-background-color: lightgray;"));
				product.setStyle("-fx-background-color: #3366FF;");
				supplier.setStyle("-fx-background-color: #3366FF;");
				Giving.setStyle("-fx-background-color: #3366FF;");
				details.setStyle("-fx-background-color: #3366FF;");
				primaryStage.setScene(scene1);
			
			
			});

			
			//ahmadddddddddddddddddddd 
			Giving.setOnAction(er -> {

				ImageView div = new ImageView("authority.png");
				div.setFitHeight(100);
				div.setFitWidth(100);
				div.setLayoutX(1400);
				div.setLayoutY(20);

				mainPane.getChildren().clear();
				mainPane.getChildren().addAll(path, l1, product, supplier, details, Giving, Sitting, div);

				Giving.setStyle("-fx-background-color: lightgray;");
				Giving.setOnMouseExited(e1 -> Giving.setStyle("-fx-background-color: lightgray;"));
				product.setStyle("-fx-background-color: #3366FF;");
				supplier.setStyle("-fx-background-color: #3366FF;");
				Sitting.setStyle("-fx-background-color: #3366FF;");
				details.setStyle("-fx-background-color: #3366FF;");
				Label give = new Label(
						" Giving the authority results in this employee being \n able to access, access, and manipulate all stored information.\n Please be careful when granting the authority. Thank you.");
				give.setFont(new Font(30));
				give.setLayoutX(200);
				give.setLayoutY(20);
				mainPane.getChildren().add(give);
				Label name = new Label("Please enter the Name:");
				name.setFont(new Font(25));
				TextField tname = new TextField();
				tname.setPromptText("The Name");
				tname.setPrefWidth(200);
				tname.setPrefHeight(40);

				Label basswd = new Label("Please enter the Password:");

				basswd.setFont(new Font(25));

				PasswordField tbasswd = new PasswordField();

				tbasswd.setPrefHeight(28);
				tbasswd.setPrefWidth(209);

				tbasswd.setPromptText("The Password");

				Label gbasswd = new Label("Enter the Password again:");
				gbasswd.setFont(new Font(25));

				PasswordField gtname = new PasswordField();

				gtname.setPrefHeight(28);
				gtname.setPrefWidth(209);

				gtname.setPromptText("The Password");

				GridPane gp = new GridPane();
				gp.add(name, 0, 0);
				gp.add(tname, 1, 0);
				gp.add(basswd, 0, 1);
				gp.add(tbasswd, 1, 1);
				gp.add(gbasswd, 0, 2);
				gp.add(gtname, 1, 2);
				gp.setAlignment(Pos.CENTER);
				gp.setHgap(20);
				gp.setVgap(30);
				gp.setLayoutX(600);
				gp.setLayoutY(350);
				mainPane.getChildren().add(gp);

				Button done = new Button("Done");
				done.setLayoutX(800);
				done.setLayoutY(550);

				done.setOnAction(M -> {
					Alert alert = new Alert(AlertType.ERROR);
					if (tname.getText() == "") {

						alert.setHeaderText("insert Name");
						alert.show();
						return;

					}
					if (tbasswd.getText().compareTo(gtname.getText()) != 0 || tbasswd.getText() == "") {

						alert.setHeaderText("The Password is not the same");
						alert.show();
						return;

					}

					try {
						insertAdmin(tname.getText(), tbasswd.getText());
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					alert.setAlertType(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setContentText("the opration is succicflly");

					alert.showAndWait();

					tname.setText("");
					tbasswd.setText("");
					gtname.setText("");

				});
				mainPane.getChildren().add(done);
			});
			
			
			//end ahmaddddddddddddd
			
			
			//bahaaaaaa
			details.setOnAction(er -> {
				details.setStyle("-fx-background-color: lightgray;");
				details.setOnMouseExited(e1 -> details.setStyle("-fx-background-color: lightgray;"));
                supplier.setStyle("-fx-background-color: #3366FF;");
                Sitting.setStyle("-fx-background-color: #3366FF;");
                Giving.setStyle("-fx-background-color: #3366FF;");
                product.setStyle("-fx-background-color: #3366FF;");

                Label Inventory = new Label("Store ");
                Inventory.setFont(new Font(40));
                Inventory.setLayoutX(750);
                Inventory.setLayoutY(30);

//                ImageView pro1 = new ImageView(new Image(getClass().getResourceAsStream("order.png")));
//                pro1.setFitWidth(100);
//                pro1.setFitHeight(100);
//                pro1.setLayoutX(1400);
//                pro1.setLayoutY(20);
                
                
                
               

				TableView<Product> table = new TableView<>();
				TableColumn<Product, Integer> productId = new TableColumn<>("productId");
				productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
				productId.setPrefWidth(150);
				TableColumn<Product, String> productName = new TableColumn<>("productName");
				productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
				productName.setPrefWidth(150);
				TableColumn<Product, String> Category = new TableColumn<>("Category");
				Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
				Category.setPrefWidth(150);
				TableColumn<Product, Double> price = new TableColumn<>("price");
				price.setCellValueFactory(new PropertyValueFactory<>("price"));
				price.setPrefWidth(150);
				TableColumn<Product, String> maincompany = new TableColumn<>("maincompany");
				maincompany.setCellValueFactory(new PropertyValueFactory<>("maincompany"));
				maincompany.setPrefWidth(150);
				TableColumn<Product, Integer> amount = new TableColumn<>("quantity");
				amount.setCellValueFactory(new PropertyValueFactory<>("quantity"));
				amount.setPrefWidth(150);
				table.getColumns().addAll(productId, productName, Category, price, maincompany);
				table.setPrefWidth(750);
				table.setLayoutX(450);
				table.setLayoutY(100);
				
				
				abloadproduct(table);
                Button View = new Button("View Inventory");
                View.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
                View.setLayoutX(720);
                View.setLayoutY(550);
                View.setPrefHeight(46);
                View.setPrefWidth(190);
                View.setFont(Font.font("Comic Sans MS", 15));
                TextField search = new TextField();

                BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY);
                Background background = new Background(backgroundFill);
                search.setBackground(background);
                search.setPromptText("Search by ID");
                search.setPrefWidth(150);
                search.setPrefHeight(35);
                search.setLayoutY(45);
                search.setLayoutX(950);

                Button sea = new Button();
               
                
                Button Delete = new Button("Delete Product");
                Delete.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
                Delete.setLayoutX(720);
                Delete.setLayoutY(550);
                Delete.setPrefHeight(46);
                Delete.setPrefWidth(190);
                Delete.setFont(Font.font("Comic Sans MS", 15));
                
                Button Ubdate = new Button("Ubdate Product");
                Ubdate.setStyle("-fx-background-color: #3366FF; -fx-background-radius: 30;");
                Ubdate.setLayoutX(720);
                Ubdate.setLayoutY(550);
                Ubdate.setPrefHeight(46);
                Ubdate.setPrefWidth(190);
                Ubdate.setFont(Font.font("Comic Sans MS", 15));
                
                HBox h1=new HBox();
                h1.getChildren().addAll(Delete,Ubdate);
                h1.setSpacing(25);
                h1.setLayoutX(620);
                h1.setLayoutY(550);
                h1.setAlignment(Pos.CENTER);
                
                
                HBox h2=new HBox();
                h2.getChildren().addAll(View);
              
                h2.setAlignment(Pos.CENTER);
                
                
                VBox v1=new VBox();
                v1.setAlignment(Pos.CENTER);
                v1.getChildren().addAll(h1,h2);
                v1.setLayoutX(620);
                v1.setLayoutY(550);
                v1.setSpacing(25);
                mainPane.getChildren().clear();
                
                mainPane.getChildren().addAll(path, l1, product, supplier, details, Giving, Sitting,search,table,Inventory,v1);
            
                search.setOnAction(event -> {
					abloadproduct(table, search.getText());
				});

                table.setOnMouseClicked(event -> {
    					if (event.getClickCount() == 2) {
    						selectedOrderDetail = table.getSelectionModel().getSelectedItem();
    					}
    				});
                
                Delete.setOnAction(e1->
                {
                	if(selectedOrderDetail==null)
                	{
                		  Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("choose any Product");
                        alert.setHeaderText("please enter valid data");
                        alert.show();
                		  return;
                	}
                	
                	
                	
                	String sql = "DELETE FROM product WHERE ProductID = ?";

					try {
						
						preparedStatement = con.prepareStatement(sql);
						preparedStatement.setInt(1, selectedOrderDetail.getProductId());
						preparedStatement.executeUpdate();
						
						abload();
						abloadproduct(table);
						  Alert alert = new Alert(AlertType.ERROR);
						alert.setAlertType(AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setContentText("the opration is succicflly");

						alert.showAndWait();
						selectedOrderDetail=null;
						
						return;
						
						
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
                	
                	
                	
                });
                Ubdate.setOnAction(T->{
                	
                	
                	if(selectedOrderDetail==null)
                	{
                		  Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("choose any Product");
                        alert.setHeaderText("please enter valid data");
                        alert.show();
                		  return;
                	}
                	
                	Label nameofLabel = new Label("Product Name : ");
					TextField tidField = new TextField(selectedOrderDetail.getProductName());
					tidField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

					tidField.setPrefHeight(35);
					tidField.setPrefWidth(190);

					Label phoneLabel = new Label("Category : ");
					TextField Category1 = new TextField(selectedOrderDetail.getCategory());

					Category1.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

					Category1.setPrefHeight(35);
					Category1.setPrefWidth(190);
					Label address = new Label("Price: ");
					TextField tPrice = new TextField(selectedOrderDetail.getPrice()+"");

					
					
					
					tPrice.setPrefHeight(35);
					tPrice.setPrefWidth(190);
					tPrice.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");
					
					Label amount1 = new Label("Amount : ");
					ComboBox<Integer> tamount = new ComboBox<Integer>();

					for(int i=0;i<1000;i++)
					{
						tamount.getItems().add(i);
						
					}
					
					
					tamount.setValue(selectedOrderDetail.getQuantity());
					
					
					
					
					
					
					
					Label comp = new Label("main company : ");
					TextField compani = new TextField(selectedOrderDetail.getMaincompany());
					
					nameofLabel.setFont(new Font(20));
					phoneLabel.setFont(new Font(20));
					address.setFont(new Font(20));
					amount1.setFont(new Font(20));
					comp.setFont(new Font(20));
					
					
					compani.setPrefHeight(35);
					compani.setPrefWidth(190);
					compani.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

					Button bb1 = new Button("Done");

					GridPane gp = new GridPane();
					gp.add(nameofLabel, 0, 0);
					gp.add(tidField, 1, 0);

					gp.add(phoneLabel, 0, 1);
					gp.add(Category1, 1, 1);

					gp.add(address, 0, 2);
					gp.add(tPrice, 1, 2);

					gp.add(comp, 0, 3);
					gp.add(compani, 1, 3);
					gp.add(amount1, 0, 4);
					gp.add(tamount, 1, 4);
					gp.setHgap(20);
					gp.setVgap(20);
					gp.setAlignment(Pos.CENTER);
					VBox vv = new VBox();
					vv.getChildren().addAll(gp, bb1);
					vv.setSpacing(20);
					vv.setLayoutX(50);
					vv.setLayoutY(200);
					vv.setAlignment(Pos.CENTER);
					StackPane s1=new StackPane();
					
					
					
					
					ImageView image1=new ImageView("order.png");
					s1.getChildren().addAll(image1,vv);
					image1.setFitHeight(800);
					image1.setFitWidth(800);
					Scene s2=new Scene(s1,1500,800);
					s1.setStyle("-fx-background-color: lightgray;");
					
					
					
					
					
					
					primaryStage.setScene( s2);
                	
					
					
					
					bb1.setOnAction(M->
					{
						
						if(tidField.getText()==""||Category1.getText()==""||tPrice.getText()==""||compani.getText()==""||tamount.getValue()==0)
						{
							  Alert alert = new Alert(AlertType.ERROR);
		                        alert.setTitle("choose any Product");
		                        alert.setHeaderText("Thr Data is not valid");
		                        alert.show();
		                		  return;
						}
						try {
							
           Double.valueOf(tPrice.getText().trim());
							
							
						}catch (Exception e1) {
							Alert alert = new Alert(AlertType.ERROR);
	                        alert.setTitle("choose any Product");
	                        alert.setHeaderText("Enter a numeric value");
	                        alert.show();
	                		  return;
						}
						
						
						
						try {
							ubdateProduct(selectedOrderDetail.getProductId(),tidField.getText(),Category1.getText(),Double.valueOf(tPrice.getText().trim()),compani.getText(),tamount.getValue());
						
						
						abload();
						abloadproduct(table);
						primaryStage.setScene(scene);
						
						selectedOrderDetail=null;
			
						
						
						
						} catch (NumberFormatException | SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						
						
						
						
						
						
						
						
						
						
						
						
					});
					
					
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                });
                
                
                
                
                
                
                
                
                
                
            
                });
			//end bahaaaaaaaaaaaaaaaa


		
			scene = new Scene(mainPane, 1500, 790);
			primaryStage.setScene(scene);
			primaryStage.setTitle("SMS");
			primaryStage.show();

		});
	
	
		Label nameLabel = new Label("Storage Management System");
		nameLabel.setLayoutX(262);
		nameLabel.setLayoutY(27);
		nameLabel.setPrefHeight(44);
		nameLabel.setPrefWidth(305);
		nameLabel.setFont(new Font("Andalus", 26));

		Label colorOnlyLabel3 = new Label();
		colorOnlyLabel3.setLayoutX(221);
		colorOnlyLabel3.setLayoutY(403);
		colorOnlyLabel3.setPrefHeight(17);
		colorOnlyLabel3.setPrefWidth(98);
		colorOnlyLabel3.setStyle("-fx-background-color: white;");
		Label colorOnlyLabel2 = new Label();
		colorOnlyLabel2.setLayoutX(163);
		colorOnlyLabel2.setLayoutY(277);
		colorOnlyLabel2.setPrefHeight(17);
		colorOnlyLabel2.setPrefWidth(98);
		colorOnlyLabel2.setStyle("-fx-background-color: white;");
		root.getChildren().addAll(backgroundImageView, colorOnlyLabel, logoSMSImageView, loginLabel, usernameLabel,
				passwordLabel, usernameTextField, passwordTextField, loginButton, nameLabel, colorOnlyLabel2,
				colorOnlyLabel3);
		HBox stack = new HBox();
		stack.getChildren()
				.addAll(new Label("                                               "
						+ "                                                               "), root,
						new Label("                             "));
		VBox v1 = new VBox();
		v1.getChildren().addAll(new Label(), new Label(), new Label(), new Label(), new Label(), new Label(),
				new Label(), new Label(), stack);
		// v1.setStyle("-fx-background-color: rgb(131, 153, 255);");

		Stop[] stops = new Stop[] { new Stop(0, Color.DARKBLUE), new Stop(1, Color.LIGHTBLUE) };
		LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, javafx.scene.paint.CycleMethod.NO_CYCLE,
				stops);
		v1.setBackground(new Background(new BackgroundFill(linearGradient, CornerRadii.EMPTY, Insets.EMPTY)));

		scene1 = new Scene(v1, 1500, 790);
		primaryStage.setTitle("Storage Management System");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		abload();

		launch(args);
	}

	public static void abload() throws ClassNotFoundException, SQLException {
		prduct = new ArrayList<>();
		prduct_Dettels = new ArrayList<>();
		order = new ArrayList<>();
		supplairs = new ArrayList<>();
		product_Suuplier = new ArrayList<>();
		supply = new ArrayList<>();
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
			prduct_Dettels.add(p1);
		}

		String q2 = "select * from order_Request";
		ResultSet rs2 = stmt.executeQuery(q2);
		while (rs2.next()) {

			Order p1 = new Order(rs2.getInt("OrderID"), rs2.getDate("OrderDate"), rs2.getString("ShippingAddress"),
					rs2.getInt("CustomerID"));
			order.add(p1);
		}

		q2 = "select * from supplier";
		rs2 = stmt.executeQuery(q2);
		while (rs2.next()) {

			supplier s1 = new supplier(rs2.getInt("SupplierID"), rs2.getString("SupplierName"),
					rs2.getString("productType"), rs2.getString("SupplierPhone"));
			supplairs.add(s1);

		}
		String name = "";
		double price = 0;
		q2 = "select * from Supply";
		rs2 = stmt.executeQuery(q2);
		while (rs2.next()) {

			Supply s1 = new Supply(rs2.getInt("ProductID"), rs2.getInt("SupplierID"), rs2.getString("ProductName"),
					rs2.getDouble("price"));
			supply.add(s1);
		}
		q2 = "select * from All_product";
		rs2 = stmt.executeQuery(q2);

		while (rs2.next()) {
			Product_Supplier s1 = new Product_Supplier(rs2.getInt("ProductID"), rs2.getString("ProductName"),
					rs2.getString("Category"), rs2.getDouble("Price"), rs2.getString("maincompany"),
					rs2.getInt("SupplierID"));
			product_Suuplier.add(s1);
		}

	}

	public void found(TableView<order_detail> m1, int n1) {
		m1.getItems().clear();
		for (int i = 0; i < prduct_Dettels.size(); i++) {

			if (prduct_Dettels.get(i).getProductID() == n1) {

				m1.getItems().add(prduct_Dettels.get(i));

			}

		}

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

	public int give_last() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8",
				"root", "1234");
		Statement stmt = (Statement) con.createStatement();
		String query = "select * from customer";
		ResultSet rs = stmt.executeQuery(query);
		int n = 0;
		int r = 0;
		while (rs.next()) {
			r = n;
			n = rs.getInt("CustomerID");

		}

		return r;

	}

	public void abloudSuppliers(TableView<supplier> t1) {
		t1.getItems().clear();

		for (int i = 0; i < supplairs.size(); i++) {
			t1.getItems().add(supplairs.get(i));
		}

	}

	public void searchSuppliers(TableView<supplier> t1, String name) {

		t1.getItems().clear();
		for (int i = 0; i < supplairs.size(); i++) {
			if (supplairs.get(i).getName().toLowerCase().trim().contains(name.toLowerCase().trim()))
				t1.getItems().add(supplairs.get(i));
		}

	}

	public void abdateneg(int prim, int neg, int org) throws SQLException {

		String sql = "UPDATE product SET amount=? WHERE ProductID=?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, org - neg);
		preparedStatement.setInt(2, prim);
		preparedStatement.executeUpdate();

	}

	public void abdatepos(int prim, int neg, int org) throws SQLException {

		String sql = "UPDATE product SET amount=? WHERE ProductID=?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, org + neg);
		preparedStatement.setInt(2, prim);
		preparedStatement.executeUpdate();

	}

	public void insertAdmin(String name, String id) throws SQLException {

		String sql = "INSERT INTO Admin (owner_name, passwd) VALUES (?, ?)";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, id);
		preparedStatement.executeUpdate();
	}

	public void ubdateCostmer(int id, String name, String adress, String phone) throws SQLException {
		String sql = "UPDATE customer SET CustomerName=?, CustomerAddress=?, CustomerPhone=?WHERE CustomerID=?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, adress);
		preparedStatement.setString(3, phone);
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();

	}

	public void ubdate_Details_quntity(int id, int qun) throws SQLException {

		String sql = "UPDATE order_detail SET OrderedQuantity=? WHERE OrderDetailID=?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, qun);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();

	}

	public void foundsupply(TableView<Product_Supplier> t1, int id) {
		t1.getItems().clear();
		System.out.println(product_Suuplier.size());
		for (int i = 0; i < product_Suuplier.size(); i++) {
			System.out.println(product_Suuplier.get(i).getSuplairs() + "    " + id);
			if (product_Suuplier.get(i).getSuplairs() == id) {

				Product_Supplier s1 = new Product_Supplier(product_Suuplier.get(i).getProductID(),
						product_Suuplier.get(i).getProductName(), product_Suuplier.get(i).getCategory(),
						product_Suuplier.get(i).getPrice(), product_Suuplier.get(i).getMaincompany(),
						product_Suuplier.get(i).getSuplairs());
				System.out.println(s1.getProductName());
				t1.getItems().add(s1);
			}

		}

	}

	public boolean exist(int id) {

		for (int i = 0; i < prduct.size(); i++) {

			if (prduct.get(i).getProductId() == id) {

				return true;
			}

		}

		return false;

	}

	public void Ubdate_Quntity(int num, int id, int oregnal) throws SQLException {
		System.out.println(num + "    " + oregnal);

		String sql = "UPDATE product SET amount=? WHERE ProductID=?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, num + oregnal);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();

	}
	
	public void ubdateProduct(int id, String name, String Category ,double price,String maincompany,int mount) throws SQLException {
		String sql = "UPDATE product SET ProductName=?, Category=?, Price=?,maincompany=?,amount=? WHERE ProductID=?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, Category);
		preparedStatement.setDouble(3, price);
		preparedStatement.setString(4, maincompany);
		preparedStatement.setInt(5, mount);
		preparedStatement.setInt(6, id);
		preparedStatement.executeUpdate();

	}
	
	
public boolean exist(String username,String password) throws ClassNotFoundException, SQLException
{
	
	
	Class.forName("com.mysql.jdbc.Driver");
	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8",
			"root", "1234");
	Statement stmt = (Statement) con.createStatement();
	String query = "select * from admin";
	ResultSet rs = stmt.executeQuery(query);
	
	while (rs.next()) {
	if(rs.getString("owner_name").toLowerCase().trim().compareTo(username.trim().toLowerCase())==0&&rs.getString("passwd").trim().toLowerCase().compareTo(password.trim().toLowerCase())==0)
	{
		
		return true;
		
	}
	}
return false;
	
	
	
	
	
	
	
}
	
	
	
	

	

}
