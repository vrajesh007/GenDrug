<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM shippingstatus ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Shipping_id"] = $row["Shipping_id"];
         $data["Shipping_status"] = $row["Shipping_status"];
         
         $fetch_data[]= $data;
    }
   
    $response['Shipping Details'] = $fetch_data;
    $response['success'] = 1;
   

} else {
    
    $response['success'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);

