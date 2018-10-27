<?php
$con =mysqli_connect("localhost","root","","gendrug");
if($_POST)
    {
$a=$_POST['name'];
$b=$_POST['gender'];
$c=$_POST['phonenumber'];
$d=$_POST['email'];
$e=$_POST['password'];
$f=$_POST['confirmpassword'];
$g=$_POST['address'];
$insert=mysqli_query($con,"INSERT INTO userregistration(U_id,U_name,Gender,Phonenum,Email,Password,Conpassword,Address) VALUES ('','{$a}','{$b}','{$c}','{$d}','{$e}','{$f}','{$g}')") or die("Error" .mysqli_error($con));
if($insert)
{
	echo "<script> alert('Record inserted'); </script>";
}
else 
{
	echo "ERROR!!";
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
    include 'sidebar.php';
    ?>
       
   
<div class="main-panel">
<div class="main-content">
<div class="content-wrapper">       
<!-- Basic form layout section start -->
<section id="basic-form-layouts">

	
	<div class="row match-height">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form-center">Change Password</h4>
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
<!-- // Basic form layout section end -->
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