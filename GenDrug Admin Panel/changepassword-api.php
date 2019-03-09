<?php

$con =mysqli_connect("localhost","root","","gendrug");

$response = array();
if (isset($_POST['opass']) && !empty($_POST['opass']) && isset($_POST['npass']) && !empty($_POST['npass']) && isset($_POST['cpass']) && !empty($_POST['cpass']) && isset($_POST['user_id']) && !empty($_POST['user_id'])) {

    $opass = mysqli_real_escape_string($con, $_POST['opass']);
    $npass = mysqli_real_escape_string($con, $_POST['npass']);
    $cpass = mysqli_real_escape_string($con, $_POST['cpass']);
    $user_id = mysqli_real_escape_string($con, $_POST['user_id']);



    $check_user = mysqli_query($con, "select Password from userregistration where U_id = '{$user_id}'") or die(mysqli_error($con));
    $count = mysqli_num_rows($check_user);

    if ($count > 0) {

        $check_old_password = mysqli_query($con, "select * from userregistration where U_id = '{$user_id}' and Password = '{$opass}'") or die(mysqli_error($con));
        $oldpassfromdb = mysqli_fetch_array($check_old_password);
        $count = mysqli_num_rows($check_old_password);


        if ($oldpassfromdb['Password'] == $opass) {

            if ($npass == $cpass) {

                if ($count > 0) {

                    $updatequery = mysqli_query($con, "update userregistration set Password='{$npass}' where U_id='{$user_id}'") or die(mysqli_error($con));

                    if ($updatequery) {
                        $response['success'] = 1;
                        $response['message'] = "Password Changed success.";
                    } else {
                        $response['success'] = 0;
                        $response['message'] = "Please Try Again Query Issue";
                    }
                } else {
                    $response['success'] = 0;
                    $response['message'] = "Old Password Not Match.";
                }
            } else {
                $response['success'] = 0;
                $response['message'] = "New and Confirm Password Not Match.";
            }
        } else {
            $response['success'] = 0;
            $response['message'] = "Old Password Not Match.";
        }
    } else {
        $response['success'] = 0;
        $response['message'] = "Record Not Found";
    }
} else {

    $response['success'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
?>