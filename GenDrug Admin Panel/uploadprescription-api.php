<?php
$con =mysqli_connect("localhost","root","","gendrug");
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['Pinsert_name']) && !empty($_POST['Pinsert_name']) && isset($_POST['Pinsert_email']) && !empty($_POST['Pinsert_email'])) {

    //Stores Values in Variable
$a=mysqli_real_escape_string($con,$_POST['Pinsert_name']);
//$b=mysqli_real_escape_string($con,$_POST['Pinsert_photo']);
$c=mysqli_real_escape_string($con,$_POST['Pinsert_email']);

$photo = "upload/".$_FILES['Pinsert_photo']['name'];

    $lastinsertid = mysqli_insert_id($con);
	$directory= "upload/";
	$time = time();

    move_uploaded_file($_FILES['Pinsert_photo']['tmp_name'],"upload/".$_FILES['Pinsert_photo']['name']);
	
	$file = "upload/".$_FILES['Pinsert_photo']['name'];
	
    $insertquery = mysqli_query($con, "insert into prescriptioninsert (`Pinsert_id`,`Pinsert_name`,`Pinsert_photo`,`Pinsert_email`) values ('','{$a}','{$file}','{$c}')") or die(mysqli_error($con));
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
