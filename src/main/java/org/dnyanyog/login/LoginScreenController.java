package org.dnyanyog.login;

import java.io.IOException;
import java.sql.SQLException;

import org.dnyanyog.common.RestClient;
import org.dnyanyog.home.HomeScreen;
import org.springframework.web.bind.annotation.RestController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

@RestController
public class LoginScreenController {
	@FXML
	TextField username;

	@FXML
	TextField password;

	@FXML
	Label errorMessage;

	public void loginButtonClicked() throws SQLException, IOException, InterruptedException {

		String url = "http://localhost:8080/login";

		String body = "{   \r\n" + "    \"user\":\"" + username.getText() + "\",\r\n" + "	 \"password\":\""
				+ password.getText() + "\"\r\n" + "}";
		String response = RestClient.postRequest(url, body);

		if (response.contains("Success")) {
			errorMessage.setText("Login Success!!");
			errorMessage.setTextFill(Color.GREEN);
			new HomeScreen().show();
		} else {
			errorMessage.setText("Login Failed!!");
			errorMessage.setTextFill(Color.RED);

		}
	}
}
