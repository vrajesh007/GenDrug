<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM deliverymandetails ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Deliveryman_id"] = $row["Deliveryman_id"];
         $data["Deliveryman_name"] = $row["Deliveryman_name"];
         $data["Deliveryman_address"] = $row["Deliveryman_address"];
         $data["Deliveryman_phnum"] = $row["Deliveryman_phnum"];

         $fetch_data[]= $data;
    }
   
    $response['Deliveryman'] = $fetch_data;
    $response['success'] = 1;
   

} else {
    
    $response['success'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);
