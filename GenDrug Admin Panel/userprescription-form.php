<?php
session_start();
if(!isset($_SESSION['session_id']))
    {
        header("location:login.php");
    
    }
    
?>
 <?php
$con =mysqli_connect("localhost","root","","gendrug");
if(isset($_POST['submit']))
    {
$a=$_POST['presinsertname'];
$b="upload/".$_FILES['image']['name'];
$c=$_POST['presinsertemail'];
$insert=mysqli_query($con,"INSERT INTO prescriptioninsert(Pinsert_name,Pinsert_photo,Pinsert_email) VALUES ('{$a}','{$b}','{$c}')") or die("Error" .mysqli_error($con));
if($insert)
{
        $fileprocess= move_uploaded_file($_FILES['image']['tmp_name'], $b);
	if($fileprocess)
        {
           echo "<script> alert('Record inserted'); </script>";

           
        }
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

                                            <form id="myform" class="form" method="POST" enctype="multipart/form-data">
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">Prescribed Medicine Name</label>
											<input type="text" id="eventInput1" class="form-control required"  name="presinsertname">
										</div>
                                                                                
                                                                                <div class="form-group">
											<label for="eventInput2">Photo</label>
											<input type="file" id="eventInput2" class="form-control required"  name="image">
										</div>
                                                                                
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput3">Email</label>
											<input type="email" id="eventInput3" class="form-control required" name="presinsertemail" >
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
                                                            <a href="userprescription-table.php"  class="btn btn-raised btn-dark">View Table</a>
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