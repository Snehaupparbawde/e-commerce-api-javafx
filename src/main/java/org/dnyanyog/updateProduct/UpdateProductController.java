package org.dnyanyog.updateProduct;

import java.io.IOException;
import java.sql.SQLException;

import org.dnyanyog.common.RestClient;
import org.dnyanyog.user_screen.UserScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class UpdateProductController {
	@FXML
	TextField product_id;

	@FXML
	TextField pname;

	@FXML
	TextField pquantity;

	@FXML
	TextField pprice;

	@FXML
	Label errorMessage;

	@FXML
	Label errorMessage1;

	public void submitproductClicked() throws SQLException, IOException, InterruptedException {
		String url = "http://localhost:8080/api/product/UpdateProduct";

		String body = "<UpdateProduct>\r\n" + "<product_id" + product_id.getText() + "</product_id>\r\n"
				+ "</updateProduct>";

		String response = RestClient.postRequest(url, body);
		if (response.contains(product_id.getText())) {
			errorMessage.setText("Enter Updated Product Details Below:");
		} else {
			errorMessage.setText("Product Not Found!!");
		}

	}

	public void updateproductClick() throws SQLException, IOException, InterruptedException {
		String url = "http://localhost:8080/api/product/UpdateProduct";

		String body = "<UpdateProduct>\r\n" + "   <productName>" + pname.getText() + "</productName>\r\n"
				+ "   <productQuantity>" + pquantity.getText() + "</productQuantity>\r\n" + "   <productPrice>"
				+ pprice.getText() + "</productPrice>\r\n" + "   <product_id>" + product_id.getText()
				+ "</product_id>\r\n" + "</UpdateProduct>";

		String response = RestClient.postRequest(url, body);
		if (response.contains(pname.getText()) && response.contains(product_id.getText())) {
			errorMessage1.setText("Update Product Successfully..!");
			errorMessage1.setTextFill(Color.GREEN);
		} else {
			errorMessage1.setText("Update Product Unsuccessfully..!");
			errorMessage1.setTextFill(Color.RED);
		}
	}

	public void backButton() {
		new UserScreen().show();
	}

}
