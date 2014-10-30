package de.meisterfuu.openfire.plugin;

import java.io.File;
import de.meisterfuu.openfire.plugin.UserServiceHelper;

import org.jivesoftware.openfire.SharedGroupException;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.group.GroupAlreadyExistsException;
import org.jivesoftware.openfire.group.GroupNotFoundException;
import org.jivesoftware.openfire.user.UserAlreadyExistsException;
import org.jivesoftware.openfire.user.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jivesoftware.util.JiveGlobals;

public class teamFantasian_UserServicePlugin implements Plugin {

	private static final Logger Log = LoggerFactory.getLogger(teamFantasian_UserServicePlugin.class);
	private UserServiceHelper userServiceHelper;

	String pNameSpace = ""; //teamfantasianopenfire
	String pModule = ""; //userService

	public void setNameSpace (String aNameSpace ) {
		JiveGlobals.setProperty(pNameSpace, aNameSpace);
		//initConf();
	}

	public String getNameSpace() {
		return JiveGlobals.getProperty(pNameSpace , null);
	}


	public void setModule (String aModule ) {
		JiveGlobals.setProperty(pModule, aModule);
		//initConf();
	}

	public String getModule() {
		return JiveGlobals.getProperty(pModule , null);
	}

	/* 
	LIST OF METHODS : 

	createUser
	deleteUser

	enableUser
	disableUser
	updateUser

	addRosterItem
	updateRosterItem
	deleteRosterItem

	*/

	String pCreateUser,pCreateUser_input,pCreateUser_output; // createUser
	String pDeleteUser,pDeleteUser_input,pDeleteUser_output; // deleteUser

	String pEnableUser,pEnableUser_input,pEnableUser_output; // enableUser
	String pDisableUser,pDisableUser_input,pDisableUser_output; // disableUser
	String pUpdateUser,pUpdateUser_input,pUpdateUser_output; // updateUser

	String pAddRosterItem,pAddRosterItem_input,pAddRosterItem_output; // addRosterItem
	String pUpdateRosterItem,pUpdateRosterItem_input,pUpdateRosterItem_output; // updateRosterItem
	String pDeleteRosterItem,pDeleteRosterItem_input,pDeleteRosterItem_output; // deleteRosterItem



	public void setCreateUser(String aCreateUser) {
		JiveGlobals.setProperty(pCreateUser, aCreateUser);
	}

	public String getCreateUser() {
		return JiveGlobals.getProperty(pCreateUser, null);
	}

	public void setCreateUser_input(String aCreateUser_input) {
		JiveGlobals.setProperty(pCreateUser_input, aCreateUser_input);
	}

	public String getCreateUser_input() {
		return JiveGlobals.getProperty(pCreateUser_input, null);
	}

	public void setCreateUser_output(String aCreateUser_ouput) {
		JiveGlobals.setProperty(pCreateUser_output, aCreateUser_ouput);
	}

	public String getCreateUser_output() {
		return JiveGlobals.getProperty(pCreateUser_output, null);
	}




	public void initializePlugin(PluginManager manager, File pluginDirectory) {

		Log.info("teamFantasian_UserService Plugin started");
		userServiceHelper = new UserServiceHelper();
		createUser("abc","abc","abcname","abcemail","");
		deleteUser("abc");

	}


	public void createUser(String username, String password, String name, String email, String groupNames) {

		Log.info("teamFantasian_UserServicePlugin createUser(...)  "+ username);

		boolean went_wrong = false;
		String err_msg = "";

		try {

			userServiceHelper.createUser(username, password, name, email, groupNames);

		}
		catch(UserAlreadyExistsException e) {

			went_wrong = true;
			err_msg = "UserAlreadyExists";
			Log.error("teamFantasian_UserServicePlugin: UserAlreadyExistsException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(GroupAlreadyExistsException e) {

			went_wrong = true;
			err_msg = "GroupAlreadyExists";
			Log.error("teamFantasian_UserServicePlugin: GroupAlreadyExistsException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(UserNotFoundException e) {

			went_wrong = true;
			err_msg = "UserNotFound";
			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(GroupNotFoundException e) {

			went_wrong = true;
			err_msg = "GroupNotFound";
			Log.error("teamFantasian_UserServicePlugin: GroupNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}
		catch(Exception e)
		{
			went_wrong = true;
			err_msg = "Unknown Exception : " + e.getMessage();
			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}

		if(!went_wrong) {
			//publish error message using pub-sub!!
		}
	}


	public void deleteUser(String username) {

		Log.info("teamFantasian_UserServicePlugin deleteUser(...)  "+ username);

		try {

				userServiceHelper.deleteUser(username);

		}
		catch(UserNotFoundException e) {
			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(SharedGroupException e) {
			Log.error("teamFantasian_UserServicePlugin: SharedGroupException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}


	}


	public void disableUser(String username) throws UserNotFoundException {

		Log.info("teamFantasian_UserServicePlugin disableUser(...)  "+ username);

		try {

			userServiceHelper.disableUser(username);

		}
		catch(UserNotFoundException e) {

			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}
		catch(Exception e) {

			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}

	}
	public void enableUser(String username) throws UserNotFoundException {

		Log.info("teamFantasian_UserServicePlugin enableUser(...)  "+ username);

		try {

			userServiceHelper.enableUser(username);

		}
		catch(UserNotFoundException e) {

			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}
		catch(Exception e) {

			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}


	}
	//throws UserNotFoundException, GroupAlreadyExistsException
	public void updateUser(String username, String password, String name, String email, String groupNames) {

		Log.info("teamFantasian_UserServicePlugin updateUser(...)  "+ username);

		try {

			userServiceHelper.updateUser(username,password,name,email,groupNames);
		}
		catch(UserNotFoundException e) {

			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}
		catch(GroupAlreadyExistsException e) {

			Log.error("teamFantasian_UserServicePlugin: GroupAlreadyExistsException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e) {

			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}


	}

	//UserNotFoundException, UserAlreadyExistsException, SharedGroupException
	public void addRosterItem(String username, String itemJID, String itemName, String subscription, String groupNames) {

		Log.info("teamFantasian_UserServicePlugin addRosterItem(...)  ");

		try {

			userServiceHelper.addRosterItem(username,itemJID,itemName,subscription,groupNames);
		}
		catch(UserNotFoundException e) {

			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}
		catch(UserAlreadyExistsException e){

			Log.error("teamFantasian_UserServicePlugin: UserAlreadyExistsException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(SharedGroupException e) {

			Log.error("teamFantasian_UserServicePlugin: SharedGroupException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
			
		}
		catch(Exception e) {
			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	//UserNotFoundException, SharedGroupException
	public void updateRosterItem(String username, String itemJID, String itemName, String subscription,String groupNames) {
		Log.info("teamFantasian_UserServicePlugin updateRosterItem(...)  ");

		try {

			userServiceHelper.updateRosterItem(username,itemJID,itemName,subscription,groupNames);
		}
		catch(UserNotFoundException e) {

			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(SharedGroupException e) {
			Log.error("teamFantasian_UserServicePlugin: SharedGroupException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();

		}
		catch(Exception e) {
			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//UserNotFoundException, SharedGroupException
	public void deleteRosterItem(String username, String itemJID) throws UserNotFoundException, SharedGroupException {
		Log.info("teamFantasian_UserServicePlugin deleteRosterItem(...)  ");

		try {

			userServiceHelper.deleteRosterItem(username,itemJID);
		}
		catch(UserNotFoundException e) {
			Log.error("teamFantasian_UserServicePlugin: UserNotFoundException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}
		catch(SharedGroupException e) {
			Log.error("teamFantasian_UserServicePlugin: SharedGroupException");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();


		}
		catch(Exception e) {
			Log.error("teamFantasian_UserServicePlugin: (Unknown)Exception");
			Log.error("teamFantasian_UserServicePlugin: " + e.getMessage());
			e.printStackTrace();
		}

	}


	public void destroyPlugin() {
		
		Log.info("teamFantasian_UserService Plugin destroyed");

	}

}
