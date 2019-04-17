<?php

require './class/atclass.php';
//Blank Array
$response = array();
$data = array();
//If Developer Pass Catid Then It will Filter SubCategory Category Wise
if (isset($_GET['user_id'])) {
    
    $user_id = $_GET['user_id'];
    
if (isset($_GET['order_id'])) {

    $order_id = mysqli_real_escape_string($connection, $_GET['order_id']);
    $productquery = mysqli_query($connection, "select * from  tbl_order_master where order_id ='{$order_id}' AND user_id = '$user_id' ") or die(mysqli_error($connection));

} else {
//Display All SubCategory from the DB
    $productquery = mysqli_query($connection, "select * from  tbl_order_master where user_id = '$user_id' ") or die(mysqli_error($connection));
}

//Number of Record
$count = mysqli_num_rows($productquery);

if ($count > 0) {

    while ($row = mysqli_fetch_array($productquery)) {
        $get_details = mysqli_query($connection, "SELECT * FROM `tbl_order_details` where order_id ='{$row['order_id']}' ") or die(mysqli_error($connection));
        $get_shipping =  mysqli_query($connection, "SELECT * FROM `tbl_shipping` where order_id ='{$row['order_id']}' ") or die(mysqli_error($connection));
        $shipping_data = mysqli_fetch_array($get_shipping);

        $tempdata['order_id'] = $row['order_id'];
        $tempdata['order_date'] = $row['order_date'];
		$tempdata['total_amount'] = $row['total_amount'];
        $tempdata['shipping_name'] = $shipping_data['shipping_name'];
        $tempdata['shipping_mobile'] = $shipping_data['shipping_mobile'];
        $tempdata['shipping_address'] = $shipping_data['shipping_address'];
        
        foreach ($get_details as $get_details){
            $get_product =  mysqli_query($connection, "SELECT * FROM `medicinedetails` where P_id ='{$get_details['P_id']}' ") or die(mysqli_error($connection));
            $product_data = mysqli_fetch_array($get_product);
            
            $dt['P_id'] = $get_details['P_id'];
            $dt['P_name'] = $product_data['P_name'];
            $dt['quantity'] = $get_details['quantity'];
            $dt['price'] = $get_details['price'];
            $data[] = $dt;
        }
        $tempdata['order_details'] = $data;
        $temp_array[] = $tempdata;
    }
    $response['product'] = $temp_array;
    $response['flag'] = 1;
    $response['message'] = "$count Record Found.";
    


} else {
    $response['flag'] = 0;
    $response['message'] = "No Record Found.";
}


}else{
    $response['flag'] = 0;
    $response['message'] = "Please select User";
}
echo json_encode($response);
