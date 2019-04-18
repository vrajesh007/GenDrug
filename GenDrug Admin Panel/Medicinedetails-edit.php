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
    header("location:Medicinedetails-table.php");
}

$selectquery= mysqli_query($con, "select * from medicinedetails where P_id='{$editid}' ") or die("Error in Query".mysqli_error($con));
$rowfromdb = mysqli_fetch_array($selectquery);
if($_POST)
{
    $id= mysqli_real_escape_string($con,$_POST['txt1']);
    $pname= mysqli_real_escape_string($con,$_POST['txt2']);
    $pdetails= mysqli_real_escape_string($con,$_POST['txt3']);
    $pcategory= mysqli_real_escape_string($con,$_POST['txt4']);
    $pprice= mysqli_real_escape_string($con,$_POST['txt5']);
    $pstock= mysqli_real_escape_string($con,$_POST['txt6']);
   
    
    $updatequery= mysqli_query($con, "update medicinedetails set P_name='{$pname}',P_details='{$pdetails}',P_category='{$pcategory}',P_price='{$pprice}',P_stock='{$pstock}' where P_id='{$id}'") or die("Error in Update Query".mysqli_error($con));
    
    if($updatequery)
    {
        echo "<script>alert('Record Updated');window.location='Medicinedetails-table.php';</script>";
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
					<h4 class="card-title" id="basic-layout-form-center">Medicine Details Edit</h4>
				</div>
				<div class="card-body">
					<div class="px-3">
        <form method="post" id="myform" class="form" enctype="multipart/form-data">
            <div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">Product ID</label>
											<input type="hidden" value="<?php echo $rowfromdb['P_id']?>" name="txt1" id="eventInput1" class="form-control required"  >
										</div>
                                                                                
                                                                                <div class="form-group">
											<label for="eventInput2">Product Name</label>
											<input type="text" value="<?php echo $rowfromdb['P_name']?>" name="txt2" id="eventInput2" class="form-control required"  >
										</div>
                                                                            
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput3">Product Details</label>
											<input type="text" value="<?php echo $rowfromdb['P_details']?>" name="txt3" id="eventInput3" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput4">Product Category</label>
											<input type="text" value="<?php echo $rowfromdb['P_category']?>" name="txt4" id="eventInput4" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput5">Product Price</label>
											<input type="text" value="<?php echo $rowfromdb['P_price']?>" name="txt5" id="eventInput5" class="form-control required"  >
										</div>
                                                                                <div class="form-group">
											<label for="eventInput6">Product Stock</label>
											<input type="text" value="<?php echo $rowfromdb['P_stock']?>" name="txt6" id="eventInput6" class="form-control required"  >
										</div>
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        </div>
                                                                </div> 
            </div>
                                                                
            <div class="form-actions center">
            <button type="submit" class="btn btn-raised btn-primary"  name="submit" value='Update'>
									<i class="fa fa-check-square-o"></i> Submit
								</button>
            <button type="button" value="Cancel" class="btn btn-raised btn-warning mr-1" name="cancel" onclick="window.location='Medicinedetails-table.php';">
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

