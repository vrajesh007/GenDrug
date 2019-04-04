<?php
$con =mysqli_connect("localhost","root","","gendrug");

$response = array(); 

if(isset($_POST['Categ_id'])) {
    
    $categid= mysqli_real_escape_string($con,$_POST['Categ_id']);
    
    $query = mysqli_query($con, "SELECT * FROM medicinedetails where Categ_id='{$categid}'") or die(mysqli_error($con));   
}
else if(isset($_POST['Symp_id'])) {
    
    $sympid= mysqli_real_escape_string($con,$_POST['Symp_id']);
    
    $query = mysqli_query($con, "SELECT * FROM medicinedetails where Symp_id='{$sympid}'") or die(mysqli_error($con));   
}
else {

$query = mysqli_query($con, "SELECT * FROM medicinedetails ") or die(mysqli_error($con));
}
$count = mysqli_num_rows($query);


if ($count > 0) {
    while ($row = mysqli_fetch_array($query)) {
       
         $data["P_id"] = $row["P_id"];
         $data["P_name"] = $row["P_name"];
         $data["P_details"] = $row["P_details"];
         $data["P_category"] = $row["P_category"];
         $data["P_price"] = $row["P_price"];
         $data["P_stock"] = $row["P_stock"];
         $data["P_photo"] = $row["P_photo"];
         $data["Categ_id"] = $row["Categ_id"];
         $data["Symp_id"] = $row["Symp_id"];
         $fetch_data[]= $data;
    }
   
    $response['Medicine'] = $fetch_data;
    $response['flag'] = 1;
   

} else {
    
    $response['flag'] = 0;
    $response["message"] = "No Record Found";
  
    
}
// echo"<pre>";
// print_r($response);

echo json_encode($response);


