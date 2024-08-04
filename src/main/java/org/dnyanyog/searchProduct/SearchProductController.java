package org.dnyanyog.searchProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.product_screen.ProductScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchProductController {
	@FXML
	TextField searchName;

	@FXML
	Label searchErrorMessage;

	@FXML
	TextField pname;

	@FXML
	TextField pprice;

	@FXML
	TextField pquantity;

	public void searchproductClicked() throws SQLException {
		String pnames = searchName.getText();
		String searchQuery = "select * from product where product_name='" + pnames + "'";
		ResultSet resultSet = Dbutils.executeSelectQuery(searchQuery);
		if (resultSet.next()) {
			pname.setText(resultSet.getString(1));
			pquantity.setText(resultSet.getString(2));
			pprice.setText(resultSet.getString(3));

		} else {
			searchErrorMessage.setText("Product Not Found!!");
		}
	}

	public void backButton() {
		new ProductScreen().show();
	}

}