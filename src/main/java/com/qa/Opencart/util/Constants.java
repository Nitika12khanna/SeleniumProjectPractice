package com.qa.Opencart.util;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String Login_Page_Title="Account Login";
	public static final String Login_Page_Url_Fraction="account";
	public static final String Account_Page_Title="My Account";
	public static final String Account_Page_Header="Your Store";
	public static final String Account_Page_Url_Fraction="route=account/account";
	public static final List<String> Accounts_Page_Section_HeaderList=Arrays.asList("My Account" ,
			                                                             "My Orders" , 
			                                                               "My Affiliate Account" , 
			                                                                 "Newsletter");
	
	public static final String USER_LOGOUT_MESSAGE="Account Logout";
	
	public static final int  Default_Element_Wait_Time_Out= 10;
	public static final int  Default_Time_Out= 5;
	public static final CharSequence REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";

}
