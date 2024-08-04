package org.dnyanyog.deleteProduct;

import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.product_screen.ProductScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteProductController {
	@FXML
	TextField deleteName;

	@FXML
	Label deleteErrorMessage;

	public void deleteButtonClicked() throws SQLException {
		String deleteNames = deleteName.getText();
		String deleteQuery = "delete from product where product_name='" + deleteNames + "'";
		Dbutils.executeQuery(deleteQuery);
		deleteErrorMessage.setText("Product Deleted Successfully!!");
	}

	public void backButton() {
		new ProductScreen().show();
	}

}
