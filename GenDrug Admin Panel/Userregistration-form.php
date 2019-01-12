<?php
session_start();
if(!isset($_SESSION['session_id']))
    {
        header("location:Login.php");
    
    }
    
?>
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
<div class="row">
<div class="col-sm-12">
<div class="content-header">Forms</div>
</div>
</div>
	
	<div class="row match-height">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form-center">User Registration Form</h4>
				</div>
				<div class="card-body">
					<div class="px-3">

                                            <form id="myform" class="form" method="POST" >
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">Name</label>
											<input type="text" id="eventInput1" class="form-control required"  name="name">
										</div>

										<div class="form-group">
											<label>Gender</label>
											<div class="input-group">
												<div class="custom-control custom-radio custom-control-inline">
                                                                                <input type="radio" id="customRadioInline1"  checked name="gender" class="custom-control-input required" value="Male">
                                                                                <label class="custom-control-label" for="customRadioInline1">Male</label>
                                                                                </div>
                                                                                <div class="custom-control custom-radio custom-control-inline">
                                                                                    <input type="radio" id="customRadioInline2" name="gender" class="custom-control-input required" value="Female">
                                                                                    <label class="custom-control-label" for="customRadioInline2">Female</label>
                                                                                </div>
											</div>
										</div>

										<div class="form-group">
											<label for="eventInput2">Phone Number</label>
											<input type="number" id="eventInput2" class="form-control required"  name="phonenumber">
										</div>

										<div class="form-group">
											<label for="eventInput3">Email</label>
											<input type="email" id="eventInput3" class="form-control required"  name="email">
										</div>

										<div class="form-group">
											<label for="eventInput4">Password</label>
											<input type="password" id="eventInput4" class="form-control required" name="password" >
										</div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput5">Confirm Password</label>
											<input type="password" id="eventInput5" class="form-control required" name="confirmpassword" >
										</div>
                                                                            
                                                                                <div class="form-group">
									        <label for="userinput6">Address</label>
                                                                                <textarea id="userinput6" rows="5" class="form-control border-primary required" name="address" ></textarea>
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
                                                            <a href="Userregistration-table.php"  class="btn btn-raised btn-dark">View Table</a>
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