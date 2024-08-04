package org.dnyanyog.addUser;

import java.io.IOException;

import org.dnyanyog.common.RestClient;
import org.dnyanyog.user_screen.UserScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddUserController {
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

	public void submitUserClicked() throws IOException, InterruptedException {

		String url = "http://localhost:8080/api/user/AddUser";

		String body = "<AddUser>\r\n" + "    <firstName>" + fname.getText() + "</firstName>\r\n" + "    <lastName>"
				+ lname.getText() + "</lastName>\r\n" + "    <loginName>" + loginName.getText() + "</loginName>\r\n"
				+ "    <gender>" + gender.getText() + "</gender>\r\n" + "    <age>" + age.getText() + "</age>\r\n"
				+ "    <email>" + email.getText() + "</email>\r\n" + "    <password>" + password.getText()
				+ "</password>\r\n" + "    <repassword>" + rePassword.getText() + "</repassword>\r\n" + "</AddUser>";

		String responce = RestClient.postRequest(url, body);
		if (responce.contains(fname.getText()) && responce.contains(lname.getText())) {
			errorMessage.setText("User Added Successfully");
		} else {
			errorMessage.setText("User Additon Failed");

		}

	}

	public void backButton() {
		new UserScreen().show();
	}

}