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
$a=$_POST['orderquantity'];
$b=$_POST['orderamount'];
$c=$_POST['orderproducts'];
$d=$_POST['od'];
$insert=mysqli_query($con,"INSERT INTO orderdetails(Order_id,Order_products,Order_quantity,Order_amount,Order_date) VALUES ('','{$c}','{$a}','{$b}','{$d}')") or die("Error" .mysqli_error($con));
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
					<h4 class="card-title" id="basic-layout-form-center">Order Details Form</h4>
				</div>
				<div class="card-body">
					<div class="px-3">

                                            <form id="myform" class="form"method="POST">
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
                                                                            <div class="form-group">
											<label for="eventInput3">Order Products</label>
											<input type="text" id="eventInput3" class="form-control required"  name="orderproducts">
										</div>
										<div class="form-group">
											<label for="eventInput1">Order Quantity</label>
											<input type="number" id="eventInput1" class="form-control required"  name="orderquantity">
										</div>
                                                                                <div class="form-group">
											<label for="eventInput2">Order Amount</label>
											<input type="number" id="eventInput2" class="form-control required" name="orderamount" >
										</div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput4">Order Date</label>
											<input type="date" id="eventInput4" class="form-control required"  name="od">
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
                                                            <a href="orderdetails-table.php"  class="btn btn-raised btn-dark">View Table</a>
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