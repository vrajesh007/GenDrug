<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM orderdetails ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Order_id"] = $row["Order_id"];
         $data["Order_products"] = $row["Order_products"];
         $data["Order_quantity"] = $row["Order_quantity"];
         $data["Order_amount"] = $row["Order_amount"];
         $data["Order_date"] = $row["Order_date"];
         
         $fetch_data[]= $data;
    }
   
    $response['Order'] = $fetch_data;
    $response['flag'] = 1;
   

} else {
    
    $response['flag'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);

