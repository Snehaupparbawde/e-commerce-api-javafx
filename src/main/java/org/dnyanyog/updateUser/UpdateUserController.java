package org.dnyanyog.updateUser;

import java.io.IOException;
import java.sql.SQLException;

import org.dnyanyog.common.RestClient;
import org.dnyanyog.user_screen.UserScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class UpdateUserController {
	@FXML
	TextField user_id;

	@FXML
	TextField fname;

	@FXML
	TextField lname;

	@FXML
	TextField loginName;

	@FXML
	TextField gender;

	@FXML
	TextField age;

	@FXML
	TextField email;

	@FXML
	TextField password;

	@FXML
	TextField rePassword;

	@FXML
	Label errorMessage;

	@FXML
	Label errorMessage1;

	public void submitUserClicked() throws SQLException, IOException, InterruptedException {
		String url = "http://localhost:8080/api/user/UpdateUser";

		String body = "<UpdateUser>\r\n" + " <user_id>" + user_id.getText() + "</user_id>\r\n" + "</UpdateUser>";
		String response = RestClient.postRequest(url, body);
		if (response.contains(user_id.getText())) {
			errorMessage.setText("Enter Updated User Details Below:");
		} else {
			errorMessage.setText("User Not Found!!");
		}
	}

	public void updateUserClicked() throws SQLException, IOException, InterruptedException {

		String url = "http://localhost:8080/api/user/UpdateUser";

		String body = "<UpdateUser>\r\n" + "    <firstName>" + fname.getText() + "</firstName>\r\n" + "    <lastName>"
				+ lname.getText() + "</lastName>\r\n" + "    <loginName>" + loginName.getText() + "</loginName>\r\n"
				+ "    <gender>" + gender.getText() + "</gender>\r\n" + "    <age>" + age.getText() + "</age>\r\n"
				+ "    <email>" + email.getText() + "</email>\r\n" + "    <password>" + password.getText()
				+ "</password>\r\n" + "    <repassword>" + rePassword.getText() + "</repassword>\r\n" + "    <user_id>"
				+ user_id.getText() + "</user_id>\r\n" + "</UpdateUser>";

		String response = RestClient.postRequest(url, body);
		if (response.contains(fname.getText()) && response.contains(user_id.getText())) {
			errorMessage1.setText("Update User Successfully..!");
			errorMessage1.setTextFill(Color.GREEN);
		} else {
			errorMessage1.setText("Update User Unsuccessfully..!");
			errorMessage1.setTextFill(Color.RED);
		}
	}

	public void backButton() {
		new UserScreen().show();
	}

}