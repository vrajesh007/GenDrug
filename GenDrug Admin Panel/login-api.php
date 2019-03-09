<?php
$con =mysqli_connect("localhost","root","","gendrug");
$response = array();

if (isset($_POST['Email']) && !empty($_POST['Email']) && isset($_POST['Password']) && !empty($_POST['Password'])) {

    $email = mysqli_real_escape_string($con, $_POST['Email']);
    $password = mysqli_real_escape_string($con, $_POST['Password']);

    $loginquery = mysqli_query($con, "select * from userregistration where Email='{$email}' and Password='{$password}'") or die(mysqli_error($con));
    $fetchrow = mysqli_fetch_array($loginquery);

    $count = mysqli_num_rows($loginquery);

    if ($count > 0) {
        $response['success'] = 1;
        $response['userdata'] = $fetchrow;
        $response['message'] = "Login Success";
    } else {

        $response['success'] = 0;
        $response['message'] = "Login Failed";
    }
} else {

    $response['success'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
