<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 


$query = mysqli_query($con, "SELECT * FROM supplierdetails ") or die(mysqli_error($con));

$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["Supp_id"] = $row["Supp_id"];
         $data["Supp_name"] = $row["Supp_name"];
         $data["Supp_add"] = $row["Supp_add"];
         $data["Supp_phnum"] = $row["Supp_phnum"];
         $data["Supp_stock"] = $row["Supp_stock"];
         
         
         $fetch_data[]= $data;
    }
   
    $response['Supplier Details'] = $fetch_data;
    $response['flag'] = 1;
   

} else {
    
    $response['flag'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);

