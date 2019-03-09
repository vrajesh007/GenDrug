<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM userregistration ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["U_id"] = $row["U_id"];
         $data["U_name"] = $row["U_name"];
         $data["Gender"] = $row["Gender"];
         $data["DOB"] = $row["DOB"];
         $data["Phonenum"] = $row["Phonenum"];
         $data["Email"] = $row["Email"];
         $data["Address"] = $row["Address"];
         $fetch_data[]= $data;
    }
   
    $response['user'] = $fetch_data;
    $response['success'] = 1;
   

} else {
    
    $response['success'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);
