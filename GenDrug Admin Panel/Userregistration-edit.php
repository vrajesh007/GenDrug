<?php
session_start();
if(!isset($_SESSION['session_id']))
    {
        header("location:login.php");
    
    }
    
?>
<?php
$con =mysqli_connect("localhost","root","","gendrug");

$editid =$_GET['editid'];

if(!isset($_GET['editid'])|| empty($_GET['editid']))
{
    header("location:Userregistration-table.php");
}
$selectquery= mysqli_query($con, "select * from Userregistration where U_id='{$editid}' ") or die("Error in Query".mysqli_error($con));
$rowfromdb = mysqli_fetch_array($selectquery);

if($_POST)
{
    $id= mysqli_real_escape_string($con,$_POST['txt1']);
    $name= mysqli_real_escape_string($con,$_POST['txt2']);
    $gender= mysqli_real_escape_string($con,$_POST['txt3']);
    $dob= mysqli_real_escape_string($con,$_POST['txt4']);
    $phonenumber= mysqli_real_escape_string($con,$_POST['txt5']);
    $email= mysqli_real_escape_string($con,$_POST['txt6']);
    $address= mysqli_real_escape_string($con,$_POST['txt7']);
    
    $updatequery= mysqli_query($con, "update userregistration set U_name='{$name}',Gender='{$gender}',DOB='{$dob}',Phonenum='{$phonenumber}',Email='{$email}',Address='{$address}' where U_id='{$id}'") or die("Error in Update Query".mysqli_error($con));
    
    if($updatequery)
    {
        echo "<script>alert('Record Updated');window.location='Userregistration-table.php';</script>";
    }
}
?>
<html>
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
<div class="content-header">Edit</div>
</div>
</div>
    <div class="row match-height">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form-center">User Registration Edit</h4>
				</div>
                            <div class="card-body">
                            <div class="px-3">
        <form method="post" id="myform" class="form">
             <div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">User ID</label>
											<input type="hidden" value="<?php echo $rowfromdb['U_id']?>" name="txt1" id="eventInput1" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput2">Username</label>
											<input type="text" value="<?php echo $rowfromdb['U_name']?>" name="txt2" id="eventInput2" class="form-control required"  >
										</div>
                                                                            
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput3">Gender</label>
											<input type="text" value="<?php echo $rowfromdb['Gender']?>" name="txt3" id="eventInput3" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput4">Date of Birth</label>
											<input type="text" value="<?php echo $rowfromdb['DOB']?>" name="txt4" id="eventInput4" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput5">Phonenumber</label>
											<input type="text" value="<?php echo $rowfromdb['Phonenum']?>" name="txt5" id="eventInput5" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput6">Email</label>
											<input type="text" value="<?php echo $rowfromdb['Email']?>" name="txt6" id="eventInput6" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput7">Address</label>
											<input type="text" value="<?php echo $rowfromdb['Address']?>" name="txt7" id="eventInput7" class="form-control required"  >
										</div>
                                                                        </div>
                                                                </div>
             </div>
                  
       
               <div class="form-actions center">
            <button type="submit" class="btn btn-raised btn-primary"  name="submit" value='Update'>
									<i class="fa fa-check-square-o"></i> Submit
								</button>
            <button type="button" value="Cancel" class="btn btn-raised btn-warning mr-1" name="cancel" onclick="window.location='Userregistration-table.php';">
									<i class="ft-x"></i> Cancel	
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
