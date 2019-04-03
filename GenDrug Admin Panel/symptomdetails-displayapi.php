<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM symptomdetails ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Symp_id"] = $row["Symp_id"];
         $data["Symp_name"] = $row["Symp_name"];
         
         $fetch_data[]= $data;
    }
   
    $response['Symptom'] = $fetch_data;
    $response['flag'] = 1;
   

} else {
    
    $response['flag'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);

