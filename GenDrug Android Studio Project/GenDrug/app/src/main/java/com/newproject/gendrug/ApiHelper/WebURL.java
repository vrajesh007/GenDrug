package com.newproject.gendrug.ApiHelper;

public class WebURL {
    private static final String IP_ADDRESS = "192.168.43.252";
    private static final String KEY_MAIN_URL = "http://" + IP_ADDRESS + "/gendrug/";

    public static final String KEY_SIGNUP_URL = KEY_MAIN_URL + "signup-api.php";
    public static final String KEY_LOGIN_URL = KEY_MAIN_URL + "login-api.php";
    public static final String KEY_CHANGE_PASSWORD_URL = KEY_MAIN_URL + "changepassword-api.php";
    public static final String KEY_FORGOT_PASSWORD_URL = KEY_MAIN_URL +"forgotpassword-api.php";
    public static final String CATEGORY_URL = KEY_MAIN_URL + "categorydetails-displayapi.php";
    public static final String PRODUCT_URL = KEY_MAIN_URL + "medicinedetails-displayapi.php";
    public static final String PRODUCT_IMAGE_URL = "http://" + IP_ADDRESS + "/GenDrug/";
    public static final String PRESCRIPTION_URL = KEY_MAIN_URL + "prescriptiondetails-displayapi.php";
    public static final String UPLOAD_PRESCRIPTION_URL = KEY_MAIN_URL + "uploadprescription-api.php";
    public static final String ORDER_URL=  KEY_MAIN_URL +"orderdetails-displayapi.php";
    public static final String SYMPTOM_URL = KEY_MAIN_URL + "symptomdetails-displayapi.php";
    public static final String KEY_FEEDBACK_URL = KEY_MAIN_URL + "feedback-api.php";

    public static final String ADD_TO_CART_URL = KEY_MAIN_URL + "cart-insert-api.php";

    public static final String VIEW_CART_URL = KEY_MAIN_URL + "cart-view-api.php";

    public static final String UPDATE_CART_URL = KEY_MAIN_URL + "cart-update-api.php";

    public static final String REMOVE_FROM_CART_URL = KEY_MAIN_URL + "cart-remove-product-api.php";

    public static final String CART_PRODUCT_DETAIL_URL = KEY_MAIN_URL + "cart-view-product-single-api.php";

    public static final String NEW_ORDER_INSERT_URL = KEY_MAIN_URL + "new-api-add-order.php";

    public static final String ORDER_LISTING_URL = KEY_MAIN_URL + "order-listing-api.php?user_id=";



}
