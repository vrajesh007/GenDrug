<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

$con =mysqli_connect("localhost","root","","gendrug");

if($_POST)
{
    $email = $_POST['email'];
    $selectquery = mysqli_query($con,"select * from admin where Admin_email= '{$email}'") or die(mysqli_error($con));
    $count= mysqli_num_rows($selectquery);
    $row= mysqli_fetch_array($selectquery);
    if($count>0)
    {
        
        
        //Load Composer's autoloader
        require 'vendor/autoload.php';

        $mail = new PHPMailer(true);                              // Passing `true` enables exceptions
        try {
            //Server settings
            $mail->SMTPDebug = 0;                                 // Enable verbose debug output
            $mail->isSMTP();                                      // Set mailer to use SMTP
            $mail->Host = 'smtp.gmail.com';  // Specify main and backup SMTP servers
            $mail->SMTPAuth = true;                               // Enable SMTP authentication
            $mail->Username = 'trivedi.vrajesh008@gmail.com';                 // SMTP username
            $mail->Password = 'ABCDpassword12345';                           // SMTP password
            $mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
            $mail->Port = 587;                                    // TCP port to connect to

            //Recipients
            $mail->setFrom('trivedi.vrajesh008@gmail.com', 'Vrajesh Trivedi');
            $mail->addAddress($email, $email);     // Add a recipient

            //Content
            $mail->isHTML(true);                                  // Set email format to HTML
            $mail->Subject = 'GenDrug Password';
            $mail->Body    = "Hi $email, your password is {$row['Admin_pass']}";

            $mail->send();
            echo "<script>alert('Enjoy! Your Password has been sent to your email id')</script>";    
                       
                     
        } catch (Exception $e) {
            echo 'Message could not be sent. Mailer Error: ', $mail->ErrorInfo;
        }
        
    }
    else 
        {
            echo "<script>alert('This Email is Incorrect')</script>";
        }

}
?>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GenDrug</title>
    <link rel="shortcut icon" type="image/x-icon" href="img/logo.png">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/fontawesome-all.min.css">
    <link rel="stylesheet" type="text/css" href="css/iofrm-style.css">
    <link rel="stylesheet" type="text/css" href="css/iofrm-theme9.css">
</head>
<body>
    <div class="form-body">
        <div class="row">
           <div class="img-holder">
                <div class="bg"></div>
                <div class="info-holder">
                    <img src="img/hqlogo.jpg" alt="GenDrug">
                </div> 
            </div> 
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">

                        <h3>Password Reset</h3>
                        <p>To reset your password, enter the email address you use to sign in to Gendrug</p>
                        <form method="Post">
                            <input class="form-control" type="text" name="email" placeholder="E-mail Address" required>
                            <div class="form-button full-width">
                                <button id="submit" type="submit" class="ibtn">Send Reset Link</button>                        
                            </div>
                        </form>
                    </div>
                   
                </div>
            </div>
        </div>
    </div>
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>

</html>