<?php
$con =mysqli_connect("localhost","root","","gendrug");
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['Name']) && !empty($_POST['Name']) && isset($_POST['Gender']) && !empty($_POST['Gender']) && isset($_POST['Phonenumber']) && !empty($_POST['Phonenumber']) && isset($_POST['Email']) && !empty($_POST['Email'] && isset($_POST['Password']) && !empty($_POST['Password']) && isset($_POST['Dateofbirth']) && !empty($_POST['Dateofbirth']) && isset($_POST['Address']) && !empty($_POST['Address']))) {

    //Stores Values in Variable
$a=mysqli_real_escape_string($con, $_POST['Name']);
$b=mysqli_real_escape_string($con,$_POST['Gender']);
$c=mysqli_real_escape_string($con,$_POST['Phonenumber']);
$d=mysqli_real_escape_string($con,$_POST['Email']);
$e=mysqli_real_escape_string($con,$_POST['Password']);
$f=mysqli_real_escape_string($con,$_POST['Dateofbirth']);
$g=mysqli_real_escape_string($con,$_POST['Address']);

    $insertquery = mysqli_query($con, "insert into userregistration (`U_name`,`Gender`,`Phonenum`,`Email`,`Password`,`DOB`,`Address`) values ('{$a}','{$b}','{$c}','{$d}','{$e}','{$f}','{$g}')") or die(mysqli_error($con));
    $lastinsertid = mysqli_insert_id($con);

    if ($insertquery) {
        $response['success'] = 1;
        $response['uid'] = $lastinsertid;
        $response['uname'] = $a;
        $response['message'] = "Signup Successfully";
    } else {
        $response['success'] = 0;
        $response['message'] = "Please Try Again";
    }
} else {

    $response['success'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
