<?php 
session_start();
$con =mysqli_connect("localhost","root","","gendrug");
if($_POST)
    {
        $uname=$_POST['username'];
        $pass=$_POST['password'];
        $selectquery = mysqli_query($con, "SELECT * from admin where Admin_uname= '{$uname}' and Admin_pass='{$pass}'") or die(mysqli_errno($con));
        $count= mysqli_num_rows($selectquery);
        $row= mysqli_fetch_array($selectquery);
        if($count>0)
        {
          $_SESSION['session_id']=$row['Admin_id'];
          $_SESSION['session_name']=$row['Admin_uname'];
          header("location:Dashboard.php");
            
        } else
        {
            echo"<script>alert('Entered Username or Password is not correct') </script>";
        }
    }
        


?>

<!DOCTYPE html>
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
                    
                    <img src="img/hqlogo.jpg"/>
                </div>
            </div>
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        
                        <div class="page-links">
                            <a href="Login.php" class="active">Login</a>
                        </div>
                        <form method="Post">
                            <input class="form-control" type="text" name="username" placeholder="Username" required>
                            <input class="form-control" type="password" name="password" placeholder="Password" required>
                            <div class="form-button">
                                <button id="submit" type="submit" class="ibtn">Login</button> <a href="Forgotpassword.php">Forgot password?</a>
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


