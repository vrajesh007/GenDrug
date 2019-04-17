<?php
require 'class/atclass.php';

if (isset($_POST['user_id']) && isset($_POST['product_id'])) {

$response = array();
//Query
$categoryq = mysqli_query($connection, "SELECT * FROM `tbl_cart` WHERE user_id = '{$_POST['user_id']}' AND product_id = '{$_POST['product_id']}' ") or die(mysqli_error($connection));
//Number of Record
$count = mysqli_num_rows($categoryq);

if ($count > 0) {

    while ($row = mysqli_fetch_array($categoryq)) {

        $tempdata['cart_id'] = $row['cart_id'];
        $tempdata['product_id'] = $row['product_id'];
        $tempdata['product_name'] = $row['product_name'];
        $tempdata['prodcut_description'] = $row['prodcut_description'];
        $tempdata['product_image'] = $row['product_image'];
        $tempdata['product_amount'] = $row['product_amount'];
        $tempdata['product_unit_price'] = $row['product_unit_price'];
        $tempdata['product_qty'] = $row['product_qty'];
       
        //Blank Array and Add value into FetchData
        $temp_array[] = $tempdata;
    }
    
    $response['cart_product_details'] = $temp_array;
    $response['flag'] = 1;
    $response['message'] = "$count Record Found.";
} else {
    $response['flag'] = 0;
    $response['message'] = "No Record Found.";
}

} else {

    $response['flag'] = 0;
    $response['message'] = "Required fields missing";
}


echo json_encode($response);
