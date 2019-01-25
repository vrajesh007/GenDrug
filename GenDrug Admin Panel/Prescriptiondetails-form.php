<?php
session_start();
if(!isset($_SESSION['session_id']))
    {
        header("location:login.php");
    
    }
    
?>
 <?php
$con =mysqli_connect("localhost","root","","gendrug");
if($_POST)
    {
$a=$_POST['prescribedname'];
$b=$_POST['prescribeddetails'];
$c=$_POST['price'];
$insert=mysqli_query($con,"INSERT INTO prescriptiondetails(Pres_id,Pres_name,Pres_details,Pres_price) VALUES ('','{$a}','{$b}','{$c}')") or die("Error" .mysqli_error($con));
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
					<h4 class="card-title" id="basic-layout-form-center">Prescription Details Form</h4>
				</div>
				<div class="card-body">
					<div class="px-3">

                                            <form id="myform" class="form"method="POST">
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">Prescribed Medicine Name</label>
											<input type="text" id="eventInput1" class="form-control required"  name="prescribedname">
										</div>

                                                                                <div class="form-group">
									        <label for="userinput2">Prescribed Medicine Details</label>
                                                                                <textarea id="userinput2" rows="5" class="form-control border-primary required" name="prescribeddetails" ></textarea>
								                </div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput3">Price</label>
											<input type="number" id="eventInput3" class="form-control required" name="price" >
										</div>
                                                                                

										

									</div>
								</div>
							</div>

							<div class="form-actions center">
								<button type="button" class="btn btn-raised btn-warning mr-1" name="cancel">
									<i class="ft-x"></i> Cancel
								</button>
								<button type="submit" class="btn btn-raised btn-primary"  name="submit" value='submit'>
									<i class="fa fa-check-square-o"></i> Submit
								</button>
                                                            <a href="prescriptiondetails-table.php"  class="btn btn-raised btn-dark">View Table</a>
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