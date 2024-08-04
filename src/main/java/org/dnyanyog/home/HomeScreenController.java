package org.dnyanyog.home;

import org.dnyanyog.login.LoginScreen;
import org.dnyanyog.product_screen.ProductScreen;
import org.dnyanyog.user_screen.UserScreen;

public class HomeScreenController {

	public void addUserButtonClicked() {
		new UserScreen().show();

	}

	public void addProductClicked() {
		new ProductScreen().show();
	}

	public void exitHomeScreenClicked() {
		new LoginScreen().show();
	}

}