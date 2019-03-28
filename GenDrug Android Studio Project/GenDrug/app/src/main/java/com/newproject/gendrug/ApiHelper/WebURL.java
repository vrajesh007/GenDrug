package com.newproject.gendrug.ApiHelper;

public class WebURL {
    private static final String IP_ADDRESS = "192.168.43.252";
    private static final String KEY_MAIN_URL = "http://" + IP_ADDRESS + "/GenDrug/";
    public static final String KEY_SIGNUP_URL = KEY_MAIN_URL + "signup-api.php";
    public static final String KEY_LOGIN_URL = KEY_MAIN_URL + "login-api.php";
    public static final String KEY_CHANGE_PASSWORD_URL = KEY_MAIN_URL + "changepassword-api.php";
    public static final String KEY_FORGOT_PASSWORD_URL = KEY_MAIN_URL +"forgotpassword-api.php";
    public static final String CATEGORY_URL = KEY_MAIN_URL + "categorydetails-displayapi.php";
    public static final String PRODUCT_URL = KEY_MAIN_URL + "medicinedetails-displayapi.php";
    public static final String PRODUCT_IMAGE_URL = "http://" + IP_ADDRESS + "/GenDrug/";
    public static final String PRESCRIPTION_URL = KEY_MAIN_URL + "prescriptiondetails-displayapi.php";



}
