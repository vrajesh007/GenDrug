<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM medicinedetails ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["P_id"] = $row["P_id"];
         $data["P_name"] = $row["P_name"];
         $data["P_details"] = $row["P_details"];
         $data["P_price"] = $row["P_price"];
         $data["P_stock"] = $row["P_stock"];
         $data["P_photo"] = $row["P_photo"];

         $fetch_data[]= $data;
    }
   
    $response['Medicine'] = $fetch_data;
    $response['success'] = 1;
   

} else {
    
    $response['success'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);


