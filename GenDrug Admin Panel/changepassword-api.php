<?php

$con =mysqli_connect("localhost","root","","gendrug");

$response = array();
if (isset($_POST['opass']) && !empty($_POST['opass']) && isset($_POST['npass']) && !empty($_POST['npass']) && isset($_POST['cpass']) && !empty($_POST['cpass']) && isset($_POST['Email']) && !empty($_POST['Email'])) {

    $opass = mysqli_real_escape_string($con, $_POST['opass']);
    $npass = mysqli_real_escape_string($con, $_POST['npass']);
    $cpass = mysqli_real_escape_string($con, $_POST['cpass']);
    $Email = mysqli_real_escape_string($con, $_POST['Email']);



    $check_user = mysqli_query($con, "select Password from userregistration where Email = '{$Email}'") or die(mysqli_error($con));
    $count = mysqli_num_rows($check_user);

    if ($count > 0) {

        $check_old_password = mysqli_query($con, "select * from userregistration where Email = '{$Email}' and Password = '{$opass}'") or die(mysqli_error($con));
        $oldpassfromdb = mysqli_fetch_array($check_old_password);
        $count = mysqli_num_rows($check_old_password);


        if ($oldpassfromdb['Password'] == $opass) {

            if ($npass == $cpass) {

                if ($count > 0) {

                    $updatequery = mysqli_query($con, "update userregistration set Password='{$npass}' where Email='{$Email}'") or die(mysqli_error($con));

                    if ($updatequery) {
                        $response['flag'] = 1;
                        $response['message'] = "Password Changed success.";
                    } else {
                        $response['flag'] = 0;
                        $response['message'] = "Please Try Again Query Issue";
                    }
                } else {
                    $response['flag'] = 0;
                    $response['message'] = "Old Password Not Match.";
                }
            } else {
                $response['flag'] = 0;
                $response['message'] = "New and Confirm Password Not Match.";
            }
        } else {
            $response['flag'] = 0;
            $response['message'] = "Old Password Not Match.";
        }
    } else {
        $response['flag'] = 0;
        $response['message'] = "Record Not Found";
    }
} else {

    $response['flag'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
?>