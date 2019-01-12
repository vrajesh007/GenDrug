<?php
session_start();
$con =mysqli_connect("localhost","root","","gendrug");
if(!isset($_SESSION['session_id']))
    {
        header("location:Login.php");
    
    }
if($_POST)
    {
        $opass=$_POST['password'];
        $npass=$_POST['newpassword'];
        $cpass=$_POST['confirmnewpassword'];
        
        $oldpassquery= mysqli_query($con,"select Admin_pass from admin where Admin_id='{$_SESSION['session_id']}'")  or die(mysqli_error($con));
        $oldpassfetch= mysqli_fetch_array($oldpassquery);
        if( $oldpassfetch['Admin_pass']== $opass)
        {
            if($npass == $cpass)
            {
                if($opass == $npass)
                {
                    echo"<script>alert('You cannot use the old password again.');</script>";
                }
                else 
                {
                    $updatequery= mysqli_query($con, "Update admin set Admin_pass='{$npass}' where Admin_id='{$_SESSION['session_id']}' ") or die(mysqli_error($con));
                    if($updatequery)
                    {
                        echo"<script>alert('Password successfully changed! Enjoy.'); </script>";
                    }
                }
            }
            else
            {
                echo"<script>alert('New password and confirm password are not same.');</script>";
            }
        }
        else 
        {
            echo"<script>alert('Your current password is not correct.');</script>";
        }
    }
?>
<!DOCTYPE html>
<html lang="en" class="loading">
<?php
include 'header.php';
?>
<body>
<?php 
include 'sidebar.php' ;
?>

<div class="main-panel">
<div class="main-content">
<div class="content-wrapper">
<!-- Basic form layout section start -->


<!--Contextual classes Starts-->
<section id="basic-form-layouts">

	
	<div class="row match-height">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form-center">Got into trouble? Change your password!</h4>
				</div>
				<div class="card-body">
					<div class="px-3">

                                            <form class="form" method="POST" >
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
								
										<div class="form-group">
											<label for="eventInput1">Current Password</label>
											<input type="password" id="eventInput1" class="form-control" name="password" >
										</div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput2">New Password</label>
											<input type="password" id="eventInput2" class="form-control" name="newpassword" >
										</div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput3">Confirm New Password</label>
											<input type="password" id="eventInput3" class="form-control" name="confirmnewpassword" >
										</div>
									</div>
								</div>
							</div>

							<div class="form-actions center">
								<button type="reset" class="btn btn-raised btn-warning mr-1"  name="reset" value='reset'>
									<i class="ft-x"></i> Reset
								</button>
                                                            <button type="submit" class="btn btn-raised btn-primary"  name="submit" value='submit'>
									<i class="fa fa-check-square-o"></i> Submit
								</button>
                                                           
							</div>
						</form>	

					</div>
				</div>
			</div>
		</div>
	</div>


	
</section>
<!--Contextual classes Ends-->

          </div>
        </div>
<?php 
 include 'footer.php';
?>
       

      </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    
    <?php 
    include 'bgtheme-settingicon.php';
    include 'javascript.php';
    ?>

  </body>
</html>
