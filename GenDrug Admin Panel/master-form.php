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
					<h4 class="card-title" id="basic-layout-form-center">Registration Form</h4>
				</div>
				<div class="card-body">
					<div class="px-3">

						<form class="form">
							<div class="row justify-content-md-center">
								<div class="col-md-6">
									<div class="form-body">
										<div class="form-group">
											<label for="eventInput1">Full Name</label>
											<input type="text" id="eventInput1" class="form-control"  name="fullname">
										</div>

										<div class="form-group">
											<label for="eventInput2">Title</label>
											<input type="text" id="eventInput2" class="form-control"  name="title">
										</div>

										<div class="form-group">
											<label for="eventInput3">Company</label>
											<input type="text" id="eventInput3" class="form-control"  name="company">
										</div>

										<div class="form-group">
											<label for="eventInput4">Email</label>
											<input type="email" id="eventInput4" class="form-control"  name="email">
										</div>

										<div class="form-group">
											<label for="eventInput5">Contact Number</label>
											<input type="tel" id="eventInput5" class="form-control" name="contact" >
										</div>

										<div class="form-group">
											<label>Existing Customer</label>
											<div class="input-group">
												<div class="custom-control custom-radio custom-control-inline">
	                                                <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input">
	                                                <label class="custom-control-label" for="customRadioInline1">Yes</label>
	                                            </div>
	                                            <div class="custom-control custom-radio custom-control-inline">
	                                                <input type="radio" id="customRadioInline2" checked name="customRadioInline1" class="custom-control-input">
	                                                <label class="custom-control-label" for="customRadioInline2">No</label>
	                                            </div>
											</div>
										</div>

									</div>
								</div>
							</div>

							<div class="form-actions center">
								<button type="button" class="btn btn-raised btn-warning mr-1">
									<i class="ft-x"></i> Cancel
								</button>
								<button type="button" class="btn btn-raised btn-primary">
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