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
$a=$_POST['productname'];
$b=$_POST['productdetails'];
$f=$_POST['productcategory'];
$c=$_POST['price'];
$d=$_POST['stock'];
$e="upload/".$_FILES['image']['name'];
$insert=mysqli_query($con,"INSERT INTO medicinedetails(P_id,P_name,P_details,P_category,P_price,P_stock,P_photo) VALUES ('','{$a}','{$b}','{$f}','{$c}','{$d}','{$e}')") or die("Error" .mysqli_error($con));
if($insert)
{
        $fileprocess= move_uploaded_file($_FILES['image']['tmp_name'], $e);
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
					<h4 class="card-title" id="basic-layout-form-center">Medicine Details Form</h4>
				</div>
				<div class="card-body">
					<div class="px-3">

                                            <form id="myform" class="form" method="POST" enctype="multipart/form-data">
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">Product Name</label>
											<input type="text" id="eventInput1" class="form-control required"  name="productname">
										</div>

                                                                                <div class="form-group">
									        <label for="userinput2">Product Details</label>
                                                                                <textarea id="userinput2" rows="5" class="form-control border-primary required" name="productdetails" ></textarea>
								                </div>
                                                                            
                                                                                <div class="form-group">
									        <label for="userinput6">Product Category</label>
                                                                                <input type="text" id="eventInput6" class="form-control required" name="productcategory">
								                </div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput3">Price</label>
											<input type="number" id="eventInput3" class="form-control required" name="price" >
										</div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput4">Stock</label>
											<input type="number" id="eventInput4" class="form-control required" name="stock" >
										</div>
                                                                                
                                                                                <div class="form-group">
											<label for="eventInput5">Photo</label>
											<input type="file" id="eventInput5" class="form-control required" name="image" >
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
                                                            <a href="medicinedetails-table.php"  class="btn btn-raised btn-dark">View Table</a>
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