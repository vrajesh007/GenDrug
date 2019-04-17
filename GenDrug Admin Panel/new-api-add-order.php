<?php

//Connection
require './class/atclass.php';
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['user_id']) && !empty($_POST['order_details']) && isset($_POST['shipping_name']) && !empty($_POST['shipping_mobile']) && isset($_POST['shipping_address']) && !empty($_POST['total_amount']) ) {
 
        $date = date('Y-m-d');
        $insertquery = mysqli_query($connection, "insert into tbl_order_master (`order_date`,`user_id`,`total_amount`) values ('$date','{$_POST['user_id']}','{$_POST['total_amount']}' )") or die(mysqli_error($connection));
       //Below Function will Give you last Inserted Record ID
        $lastinsertid = mysqli_insert_id($connection);

        if ($insertquery) {
            
            $detailsjson = $_POST['order_details'];
            $detail_obj = json_decode($detailsjson, true);
            $dataarray = $detail_obj["details"];
            foreach ($dataarray as $key => $value) {

                mysqli_query($connection, "insert into tbl_order_details (`order_id`, `P_id`, `quantity`, `price`) values ('$lastinsertid','{$value['P_id']}','{$value['quantity']}','{$value['price']}' )") or die(mysqli_error($connection));

            }
            
            $insertshipping = mysqli_query($connection, "insert into tbl_shipping (`order_id`, `shipping_name`, `shipping_mobile`, `shipping_address`) values ('$lastinsertid','{$_POST['shipping_name']}','{$_POST['shipping_mobile']}','{$_POST['shipping_address']}' )") or die(mysqli_error($connection));
            if($insertshipping){
            mysqli_query($connection, "DELETE FROM tbl_cart WHERE user_id = '{$_POST['user_id']}' ") or die(mysqli_error($connection));
            $response['flag'] = 1;
            $response['order_id'] = $lastinsertid;
            $response['message'] = "Order Created Successfully";
            }
        } else {
            $response['flag'] = 0;
            $response['message'] = "Please Try Again Something Went Wrong";
        }
    
} else {

    $response['flag'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
