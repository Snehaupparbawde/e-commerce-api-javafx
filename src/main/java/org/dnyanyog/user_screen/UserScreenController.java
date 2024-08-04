package org.dnyanyog.user_screen;

import org.dnyanyog.addUser.AddUser;
import org.dnyanyog.home.HomeScreen;
import org.dnyanyog.searchUser.SearchUser;
import org.dnyanyog.updateUser.UpdateUser;

public class UserScreenController {
	public void adduserclickbutton() {
		new AddUser().show();
	}

	public void exitUserScreen() {
		new HomeScreen().show();

	}

	public void updateUserClicked() {
		new UpdateUser().show();

	}

	public void searchUserClicked() {
		new SearchUser().show();

	}
}
/*
 * 
 * public void deleteUserClicked() { new DeleteUser().show();
 * 
 * }
 * 
 * 
 * 
 * }
 */
