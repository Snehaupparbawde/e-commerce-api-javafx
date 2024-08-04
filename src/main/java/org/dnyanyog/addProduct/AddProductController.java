package org.dnyanyog.addProduct;

import java.io.IOException;
import java.sql.SQLException;

import org.dnyanyog.common.RestClient;
import org.dnyanyog.product_screen.ProductScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddProductController {
	@FXML
	TextField pname;

	@FXML
	TextField pquantity;

	@FXML
	TextField pprice;

	@FXML
	Label addProductErrorMessage;

	public void addProductClicked() throws SQLException, IOException, InterruptedException {
		String url = "http://localhost:8080/api/product/AddProduct";

		String body = "<AddProduct>\r\n" + "   <productName>" + pname.getText() + "</productName>\r\n"
				+ "   <productQuantity>" + pquantity.getText() + "</productQuantity>\r\n" + "   <productPrice>"
				+ pprice.getText() + "</productPrice>\r\n" + "</AddProduct>";

		String responce = RestClient.postRequest(url, body);
		if (responce.contains(pname.getText())) {
			addProductErrorMessage.setText("Product Added Successfully");
		} else {
			addProductErrorMessage.setText("Product Additon Failed");

		}
	}

	public void backButton() {
		new ProductScreen().show();
	}
}