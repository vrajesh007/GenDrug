<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM areadetails ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Area_id"] = $row["Area_id"];
         $data["Area_name"] = $row["Area_name"];
         
         $fetch_data[]= $data;
    }
   
    $response['area'] = $fetch_data;
    $response['success'] = 1;
   

} else {
    
    $response['success'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);
