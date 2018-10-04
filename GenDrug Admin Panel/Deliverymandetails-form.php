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
					<h4 class="card-title" id="basic-layout-form-center">Delivery-man Details Form</h4>
				</div>
				<div class="card-body">
					<div class="px-3">

                                            <form class="form"method="POST">
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">Delivery-man's Name</label>
											<input type="text" id="eventInput1" class="form-control"  name="deliverymanname">
										</div>

                                                                                <div class="form-group">
									        <label for="userinput2">Delivery-man's Address</label>
                                                                                <textarea id="userinput2" rows="5" class="form-control border-primary" name="deliverymanaddress" >
                                                                                </textarea>
								                </div>
                                                                            
                                                                                <div class="form-group">
											<label for="eventInput3">Delivery-man's Phone number</label>
											<input type="number" id="eventInput3" class="form-control" name="deliverymanphonenumber" >
										</div>
                                                                                

										

									</div>
								</div>
							</div>

							<div class="form-actions center">
								<button type="button" class="btn btn-raised btn-warning mr-1" name="cancel">
									<i class="ft-x"></i> Cancel
								</button>
								<button type="button" class="btn btn-raised btn-primary"  name="save">
									<i class="fa fa-check-square-o"></i> Save
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