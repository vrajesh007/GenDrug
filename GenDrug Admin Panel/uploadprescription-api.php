<?php
$con =mysqli_connect("localhost","root","","gendrug");
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['Pinsert_name']) && !empty($_POST['Pinsert_name']) && isset($_POST['Pinsert_photo']) && !empty($_POST['Pinsert_photo']) && isset($_POST['Pinsert_email']) && !empty($_POST['Pinsert_email'])) {

    //Stores Values in Variable
$a=mysqli_real_escape_string($con,$_POST['Pinsert_name']);
$b=mysqli_real_escape_string($con,$_POST['Pinsert_photo']);
$c=mysqli_real_escape_string($con,$_POST['Pinsert_email']);


    $insertquery = mysqli_query($con, "insert into prescriptioninsert (`Pinsert_id`,`Pinsert_name`,`Pinsert_photo`,`Pinsert_email`) values ('','{$a}','{$b}','{$c}')") or die(mysqli_error($con));
    $lastinsertid = mysqli_insert_id($con);

    if ($insertquery) {
        $response['success'] = 1;
        $response['pinsertid'] = $lastinsertid;
        $response['pname'] = $a;
        $response['pemail']=$c;
        $response['message'] = "Uploaded Successfully";
    } else {
        $response['success'] = 0;
        $response['message'] = "Please Try Again";
    }
} else {

    $response['success'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
