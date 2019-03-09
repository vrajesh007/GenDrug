<?php
$con =mysqli_connect("localhost","root","","gendrug");

if (isset($_POST['Email']) && !empty($_POST['Email'])) {

    $user_email = $_POST['Email'];
    $forgotquery = mysqli_query($con, "SELECT * FROM `userregistration` WHERE `Email`='{$user_email}'") or die(mysqli_error($con));
    $userdata = mysqli_fetch_array($forgotquery);
    $count = mysqli_num_rows($forgotquery);

    if ($count > 0) {

        $to = $user_email;
        $subject = "Forgot Password";
        $body = "Hi, Your Password is {$userdata['Password']}";
        $sendemail = sendemail($to, $subject, $body);
                
        if ($sendemail == TRUE) {

            $response["success"] = 1;
            $response["message"] = "Password Sent on Email ID";
        } else {
            $response["success"] = 0;
            $response["message"] = "Email Function Not Working";
        }
    } else {
        $response["success"] = 0;
        $response["message"] = "No Record found";
    }
} else {
    $response["success"] = 0;
    $response["message"] = "Required Field Missing";
}
echo json_encode($response);



//Change your Email ID and Password 
//For Gmail Email ID 
//SMTP: smtp.gmail.com
//Email : youremail@gmail.com
//Password : Your Password
//To Send an Email Allow Less pp Secure on https://myaccount.google.com/lesssecureapps

function sendemail($to, $subject, $body) {
   require './class/PHPMailerAutoload.php';

    $mail = new PHPMailer;

    //$mail->SMTPDebug = 3;                               // Enable verbose debug output

    $mail->isSMTP();                                      // Set mailer to use SMTP
    $mail->Host = 'smtp.gmail.com';  // Specify main and backup SMTP servers
    $mail->SMTPAuth = true;                               // Enable SMTP authentication
    $mail->Username = 'trivedi.vrajesh008@gmail.com';                 // SMTP username
    $mail->Password = 'ABCDpassword12345';                           // SMTP password
    $mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
    $mail->Port = 587;                                    // TCP port to connect to

    $mail->setFrom('trivedi.vrajesh008@gmail.com', 'Vrajesh Trivedi');
    $mail->addAddress($to, $to);     // Add a recipient

    $mail->addReplyTo('info@example.com', 'Information');
    $mail->isHTML(true);                                  // Set email format to HTML

    $mail->Subject = $subject;
    $mail->Body = $body;
    $mail->AltBody = $body;

    if (!$mail->send()) {
        echo 'Email Could not Be Sent';
        echo 'Mailer Error: ' . $mail->ErrorInfo;
    } else {
        return 'EMail has been sent';
    }
}
