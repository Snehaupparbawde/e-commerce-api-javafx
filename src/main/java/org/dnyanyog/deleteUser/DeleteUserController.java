package org.dnyanyog.deleteUser;

import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.user_screen.UserScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteUserController {

	@FXML
	TextField deleteName;

	@FXML
	Label deleteErrorMessage;

	public void deleteButtonClicked() throws SQLException {
		String deleteNames = deleteName.getText();
		String deleteQuery = "delete from user where first_name='" + deleteNames + "'";
		Dbutils.executeQuery(deleteQuery);
		deleteErrorMessage.setText("User Deleted Successfully!!");
	}

	public void backButton() {
		new UserScreen().show();
	}

}
