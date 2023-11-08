package com.qa.myproject.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	/**
	 * Other Dev can use this constants
	 * Maintenance (if value changes, No need to replace n times)
	 */
	
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_LONG_TIME_OUT = 20;
	
	public static final String LOGIN_PAGE_TITLE_VALUE = "Sign in to your Yaabitech account";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "/user/login";
	public static final String USER_PROFILE_PAGE_TITLE_VALUE = "faisal user profile";
	public static final String USER_PROFILE_PAGE_URL_FRACTION_VALUE = "/user/profile";
	public static final int USER_PROFILE_HEADERS_COUNT = 3;
	
	//if it's huge array list, go for excel sheet
	public static final List<String> EXPECTED_USER_PROFILE_HEADERS_LIST = Arrays.asList("CHANGE USERNAME", "CHANGE PASSWORD", "CHANGE PHONE NUMBER");



	

}
