<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM feedback ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Feedback_id"] = $row["Feedback_id"];
         $data["Feedback"] = $row["Feedback"];
         $data["Feedback_date"] = $row["Feedback_date"];
         $data["Feedback_email"] = $row["Feedback_email"];

         $fetch_data[]= $data;
    }
   
    $response['Feedback'] = $fetch_data;
    $response['success'] = 1;
   

} else {
    
    $response['success'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);

