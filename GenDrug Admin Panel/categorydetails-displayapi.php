<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM categorydetails ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Categ_id"] = $row["Categ_id"];
         $data["Categ_name"] = $row["Categ_name"];
         
         $fetch_data[]= $data;
    }
   
    $response['Category'] = $fetch_data;
    $response['flag'] = 1;
   

} else {
    
    $response['flag'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);
