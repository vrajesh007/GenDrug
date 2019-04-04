<?php
$con =mysqli_connect("localhost","root","","gendrug");
//Blank Array 
$response = array();
//Tables Fields 
//Check Fields are Empty or Not 
//Only Use Required Fields 
if (isset($_POST['Feedback']) && !empty($_POST['Feedback']) && isset($_POST['Feedback_date']) && !empty($_POST['Feedback_date']) && isset($_POST['Feedback_email']) && !empty($_POST['Feedback_email'] )) {

    //Stores Values in Variable
$a=mysqli_real_escape_string($con, $_POST['Feedback']);
$b=mysqli_real_escape_string($con,$_POST['Feedback_date']);
$c=mysqli_real_escape_string($con,$_POST['Feedback_email']);

    $insertquery = mysqli_query($con, "insert into feedback (`Feedback_id`,`Feedback`,`Feedback_date`,`Feedback_email`) values ('','{$a}','{$b}','{$c}')") or die(mysqli_error($con));
    $lastinsertid = mysqli_insert_id($con);

    if ($insertquery) {
        $response['success'] = 1;
        $response['feedbackid'] = $lastinsertid;
        $response['feedbackemail'] = $c;
        $response['message'] = "Feedback Sent";
    } else {
        $response['success'] = 0;
        $response['message'] = "Please Try Again";
    }
} else {

    $response['success'] = 0;
    $response['message'] = "Required fields missing";
}
echo json_encode($response);
