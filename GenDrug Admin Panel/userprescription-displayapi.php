<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM userprescription ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Pinsert_id"] = $row["Pinsert_id"];
         $data["Pinsert_name"] = $row["Pinsert_name"];
         $data["Pinsert_photo"] = $row["Pinsert_photo"];
         $data["Pinsert_email"] = $row["Pinsert_email"];
         
         $fetch_data[]= $data;
    }
   
    $response['Prescriptioninsert'] = $fetch_data;
    $response['flag'] = 1;
   

} else {
    
    $response['flag'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);


