<?php

//Connection
require './class/atclass.php';
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['cart_id'])  ) {

    //Stores Values in Variable
  
        $delete = mysqli_query($connection, "DELETE FROM tbl_cart WHERE cart_id = '{$_POST['cart_id']}' ") or die(mysqli_error($connection));
       //Below Function will Give you last Inserted Record ID
        

        if ($delete) {
            $response['flag'] = 1;
            $response['message'] = "Product Remove from Cart Successfully";
        } else {
            $response['flag'] = 0;
            $response['message'] = "Please Try Again Something Went Wrong";
        }
    
} else {

    $response['flag'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
