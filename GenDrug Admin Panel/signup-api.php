<?php
$con =mysqli_connect("localhost","root","","gendrug");
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['name']) && !empty($_POST['name']) && isset($_POST['gender']) && !empty($_POST['gender']) && isset($_POST['phonenumber']) && !empty($_POST['phonenumber']) && isset($_POST['email']) && !empty($_POST['email'] && isset($_POST['password']) && !empty($_POST['password']) && isset($_POST['dateofbirth']) && !empty($_POST['dateofbirth']) && isset($_POST['address']) && !empty($_POST['address']))) {

    //Stores Values in Variable
$a=mysqli_real_escape_string($con, $_POST['name']);
$b=mysqli_real_escape_string($con,$_POST['gender']);
$c=mysqli_real_escape_string($con,$_POST['phonenumber']);
$d=mysqli_real_escape_string($con,$_POST['email']);
$e=mysqli_real_escape_string($con,$_POST['password']);
$f=mysqli_real_escape_string($con,$_POST['dateofbirth']);
$g=mysqli_real_escape_string($con,$_POST['address']);

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
