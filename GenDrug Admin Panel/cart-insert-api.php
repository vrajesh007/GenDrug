<?php

//Connection
require './class/atclass.php';
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['user_id']) && isset($_POST['product_id']) && isset($_POST['product_name']) &&isset($_POST['prodcut_description']) &&isset($_POST['product_image']) &&isset($_POST['product_amount']) &&isset($_POST['product_unit_price']) &&isset($_POST['product_qty']) ) {

    //Stores Values in Variable
  
        
        $insertquery = mysqli_query($connection, "insert into tbl_cart (`user_id`, `product_id`, `product_name`,`prodcut_description`,`product_image`,`product_amount`,`product_unit_price`,`product_qty`) values "
                . "('{$_POST['user_id']}','{$_POST['product_id']}','{$_POST['product_name']}','{$_POST['prodcut_description']}','{$_POST['product_image']}','{$_POST['product_amount']}','{$_POST['product_unit_price']}','{$_POST['product_qty']}')") or die(mysqli_error($connection));
       //Below Function will Give you last Inserted Record ID
        $lastinsertid = mysqli_insert_id($connection);

        if ($insertquery) {
            $response['flag'] = 1;
            $response['cart_id'] = $lastinsertid;
            $response['message'] = "Product Added in Cart Successfully";
        } else {
            $response['flag'] = 0;
            $response['message'] = "Please Try Again Something Went Wrong";
        }
    
} else {

    $response['flag'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
