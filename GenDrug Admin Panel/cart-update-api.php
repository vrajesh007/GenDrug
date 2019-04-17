<?php

//Connection
require './class/atclass.php';
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['user_id']) && isset($_POST['product_id']) && isset($_POST['product_amount']) &&isset($_POST['product_unit_price']) &&isset($_POST['product_qty']) ) {

    //Stores Values in Variable
   $get_cart =  mysqli_query($connection, "SELECT * FROM `tbl_cart` WHERE user_id = '{$_POST['user_id']}' AND product_id = '{$_POST['product_id']}' ")->fetch_array();
   $updatequery = mysqli_query($connection, "update tbl_cart set product_amount = '{$_POST['product_amount']}',product_unit_price='{$_POST['product_unit_price']}',product_qty='{$_POST['product_qty']}' where cart_id='{$get_cart['cart_id']}'") or die(mysqli_error($connection));
        
        
        if ($updatequery) {
            $response['flag'] = 1;
            $response['message'] = "Cart Updated Successfully";
        } else {
            $response['flag'] = 0;
            $response['message'] = "Please Try Again Something Went Wrong";
        }
    
} else {

    $response['flag'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
