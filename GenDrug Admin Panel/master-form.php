<!DOCTYPE html>
<html lang="en" class="loading">
  
<head>
    <title>GenDrug</title>
    <link rel="shortcut icon" type="image/x-icon" href="img/logo.png">
    <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500,700,900|Montserrat:300,400,500,600,700,800,900" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <!-- font icons-->
    <link rel="stylesheet" type="text/css" href="fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/simple-line-icons/style.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="vendors/css/perfect-scrollbar.min.css">
    <link rel="stylesheet" type="text/css" href="vendors/css/prism.min.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN APEX CSS-->
    <link rel="stylesheet" type="text/css" href="css/app.css">
    <!-- END APEX CSS-->
    <!-- BEGIN Page Level CSS-->
    <!-- END Page Level CSS-->
  </head>
  <body data-col="2-columns" class=" 2-columns ">
    <?php 
    include 'sidebar.php';
    ?>
       
      
      <div class="main-panel">
        <div class="main-content">
          <div class="content-wrapper"><!-- Basic form layout section start -->
<section id="basic-form-layouts">
	<div class="row">
        <div class="col-sm-12">
            <div class="content-header">Forms</div>
        </div>
    </div>
	<div class="row">
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form">Project Info</h4>
					<p class="mb-0">This is the most basic and default form having form sections. To add form section use <code>.form-section</code> class with any heading tags. This form has the buttons on the bottom left corner which is the default position.</p>
				</div>
				<div class="card-body">
					<div class="px-3">
						<form class="form">
							<div class="form-body">
								<h4 class="form-section"><i class="ft-user"></i> Personal Info</h4>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">First Name</label>
											<input type="text" id="projectinput1" class="form-control"  name="fname">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">Last Name</label>
											<input type="text" id="projectinput2" class="form-control"  name="lname">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput3">E-mail</label>
											<input type="text" id="projectinput3" class="form-control"  name="email">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput4">Contact Number</label>
											<input type="text" id="projectinput4" class="form-control"  name="phone">
										</div>
									</div>
								</div>

								<h4 class="form-section"><i class="ft-file-text"></i> Requirements</h4>

								<div class="form-group">
									<label for="companyName">Company</label>
									<input type="text" id="companyName" class="form-control"  name="company">
								</div>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput5">Interested in</label>
											<select id="projectinput5" name="interested" class="form-control">
												<option value="none" selected="" disabled="">Interested in</option>
												<option value="design">design</option>
												<option value="development">development</option>
												<option value="illustration">illustration</option>
												<option value="branding">branding</option>
												<option value="video">video</option>
											</select>
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput6">Budget</label>
											<select id="projectinput6" name="budget" class="form-control">
												<option value="0" selected="" disabled="">Budget</option>
												<option value="less than 5000$">less than 5000$</option>
												<option value="5000$ - 10000$">5000$ - 10000$</option>
												<option value="10000$ - 20000$">10000$ - 20000$</option>
												<option value="more than 20000$">more than 20000$</option>
											</select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label>Select File</label>
									<input type="file" class="form-control-file" id="projectinput8">
								</div>

								<div class="form-group">
									<label for="projectinput8">About Project</label>
									<textarea id="projectinput8" rows="5" class="form-control" name="comment" ></textarea>
								</div>
							</div>

							<div class="form-actions">
								<button type="button" class="btn btn-raised btn-raised btn-warning mr-1">
									<i class="ft-x"></i> Cancel
								</button>
								<button type="button" class="btn btn-raised btn-raised btn-primary">
									<i class="fa fa-check-square-o"></i> Save
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-colored-form-control">User Profile</h4>
					<p class="mb-0">You can always change the border color of the form controls using <code>border-*</code> class. In this example we have user <code>border-primary</code> class for form controls. Form action buttons are on the bottom right position.</p>
				</div>
				<div class="card-body">
					<div class="px-3">						

						<form class="form">
							<div class="form-body">
								<h4 class="form-section"><i class="ft-info"></i> About User</h4>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="userinput1">First Name</label>
											<input type="text" id="userinput1" class="form-control border-primary"  name="name">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="userinput2">Last Name</label>
											<input type="text" id="userinput2" class="form-control border-primary"  name="company">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="userinput3">Username</label>
											<input type="text" id="userinput3" class="form-control border-primary"  name="username">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="userinput4">Nick Name</label>
											<input type="text" id="userinput4" class="form-control border-primary"  name="nickname">
										</div>
									</div>
								</div>

								<h4 class="form-section"><i class="ft-mail"></i> Contact Info & Bio</h4>

								<div class="form-group">
									<label for="userinput5">Email</label>
									<input class="form-control border-primary" type="email"  id="userinput5">
								</div>

								<div class="form-group">
									<label for="userinput6">Website</label>
									<input class="form-control border-primary" type="url"  id="userinput6">
								</div>

								<div class="form-group">
									<label>Contact Number</label>
									<input class="form-control border-primary" id="userinput7" type="tel" >
								</div>

								<div class="form-group">
									<label for="userinput8">Bio</label>
									<textarea id="userinput8" rows="5" class="form-control border-primary" name="bio" ></textarea>
								</div>

							</div>

							<div class="form-actions right">
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


	<div class="row match-height">
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-tooltip">Issue Tracking</h4>
					<p class="mb-0">This form shows tooltips on hover to provide useful information while user is filling the form. Use data attributes like toggle <code>data-toggle</code>, trigger <code>data-trigger</code>, placement <code>data-placement</code>, title <code>data-title</code> to show tooltips on form controls.</p>
				</div>
				<div class="card-body">
					<div class="px-3">

						<form class="form">
							<div class="form-body">

								<div class="form-group">
									<label for="issueinput1">Issue Title</label>
									<input type="text" id="issueinput1" class="form-control"  name="issuetitle" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Issue Title">
								</div>

								<div class="form-group">
									<label for="issueinput2">Opened By</label>
									<input type="text" id="issueinput2" class="form-control"  name="openedby" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Opened By">
								</div>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="issueinput3">Date Opened</label>
											<input type="date" id="issueinput3" class="form-control" name="dateopened" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Date Opened">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="issueinput4">Date Fixed</label>
											<input type="date" id="issueinput4" class="form-control" name="datefixed" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Date Fixed">
										</div>
									</div>
								</div>


								<div class="form-group">
									<label for="issueinput5">Priority</label>
									<select id="issueinput5" name="priority" class="form-control" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Priority">
										<option value="low">Low</option>
										<option value="medium">Medium</option>
										<option value="high">High</option>
									</select>
								</div>

								<div class="form-group">
									<label for="issueinput6">Status</label>
									<select id="issueinput6" name="status" class="form-control" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Status">
										<option value="not started">Not Started</option>
										<option value="started">Started</option>
										<option value="fixed">Fixed</option>
									</select>
								</div>

								<div class="form-group">
									<label for="issueinput8">Comments</label>
									<textarea id="issueinput8" rows="5" class="form-control" name="comments"  data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Comments"></textarea>
								</div>

							</div>

							<div class="form-actions">
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

		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-icons">Timesheet</h4>
					<p class="mb-0">This form shows the use of icons with form controls. Define the position of the icon using <code>has-icon-left</code> or <code>has-icon-right</code> class. Use <code>icon-*</code> class to define the icon for the form control. See Icons sections for the list of icons you can use. </p>
				</div>
				<div class="card-body">
					<div class="px-3">

						<form class="form">
							<div class="form-body">

								<div class="form-group">
									<label for="timesheetinput1">Employee Name</label>
									<div class="position-relative has-icon-left">
										<input type="text" id="timesheetinput1" class="form-control"  name="employeename">
										<div class="form-control-position">
											<i class="ft-user"></i>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="timesheetinput2">Project Name</label>
									<div class="position-relative has-icon-left">
										<input type="text" id="timesheetinput2" class="form-control"  name="projectname">
										<div class="form-control-position">
											<i class="fa fa-briefcase"></i>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="timesheetinput3">Date</label>
									<div class="position-relative has-icon-left">
										<input type="date" id="timesheetinput3" class="form-control" name="date">
										<div class="form-control-position">
											<i class="ft-message-square"></i>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label>Rate Per Hour</label>
									<div class="input-group">
										<div class="input-group-prepend">
                                            <span class="input-group-text">$</span>
                                        </div>
										<input type="text" class="form-control"  aria-label="Amount (to the nearest dollar)" name="rateperhour">
										<div class="input-group-append">
                                            <span class="input-group-text">.00</span>
                                        </div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="timesheetinput5">Start Time</label>
											<div class="position-relative has-icon-left">
												<input type="time" id="timesheetinput5" class="form-control" name="starttime">
												<div class="form-control-position">
													<i class="ft-clock"></i>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="timesheetinput6">End Time</label>
											<div class="position-relative has-icon-left">
												<input type="time" id="timesheetinput6" class="form-control" name="endtime">
												<div class="form-control-position">
													<i class="ft-clock"></i>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="timesheetinput7">Notes</label>
									<div class="position-relative has-icon-left">
										<textarea id="timesheetinput7" rows="5" class="form-control" name="notes" ></textarea>
										<div class="form-control-position">
											<i class="ft-file"></i>
										</div>
									</div>
								</div>
							</div>

							<div class="form-actions right">
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


	<div class="row match-height">
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-round-controls">Complaint Form</h4>
					<p class="mb-0">This is a variation to the default form control styling. In this example all the form controls has round styling. To apply round style add class <code>round</code> to any form control.</p>
				</div>
				<div class="card-body">
					<div class="px-3">

						<form class="form">
							<div class="form-body">

								<div class="form-group">
									<label for="complaintinput1">Company Name</label>
									<input type="text" id="complaintinput1" class="form-control round"  name="companyname">
								</div>

								<div class="form-group">
									<label for="complaintinput2">Employee Name</label>
									<input type="text" id="complaintinput2" class="form-control round"  name="employeename">
								</div>

								<div class="form-group">
									<label for="complaintinput3">Date of Complaint</label>
									<input type="date" id="complaintinput3" class="form-control round" name="complaintdate">
								</div>


								<div class="form-group">
									<label for="complaintinput4">Supervisor's Name</label>
									<input type="text" id="complaintinput4" class="form-control round"  name="supervisorname">
								</div>


								<div class="form-group">
									<label for="complaintinput5">Complaint Details</label>
									<textarea id="complaintinput5" rows="5" class="form-control round" name="complaintdetails" ></textarea>
								</div>


								<div class="form-group">
									<label for="complaintinput6">Signature</label>
									<input type="text" id="complaintinput6" class="form-control round"  name="signature">
								</div>
							</div>

							<div class="form-actions">
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

		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-square-controls">Donation</h4>
					<p class="mb-0">This is another variation to the default form control styling. In this example all the form controls has square styling. To apply square style add class <code>square</code> to any form control.</p>
				</div>
				<div class="card-body">
					<div class="px-3">

						<form class="form">
							<div class="form-body">

								<div class="form-group">
									<label for="donationinput1">Full Name</label>
									<input type="text" id="donationinput1" class="form-control square"  name="fullname">
								</div>

								<div class="form-group">
									<label for="donationinput2">Email</label>
									<input type="email" id="donationinput2" class="form-control square"  name="email">
								</div>

								<div class="form-group">
									<label for="donationinput3">Contact Number</label>
									<input type="tel" id="donationinput3" class="form-control square" name="contact">
								</div>

								<div class="form-group">
									<label for="donationinput4">Dontaion Type</label>
									<input type="text" id="donationinput4" class="form-control square"  name="donationtype">
								</div>

								<div class="form-group">
									<label>Amount</label>
									<div class="input-group">
										<div class="input-group-prepend">
                                            <span class="input-group-text">$</span>
                                        </div>
										<input type="text" class="form-control square"  aria-label="Amount (to the nearest dollar)" name="amount">
										<div class="input-group-append">
                                            <span class="input-group-text">.00</span>
                                        </div>

									</div>
								</div>

								<div class="form-group">
									<label for="donationinput7">Comments</label>
									<textarea id="donationinput7" rows="5" class="form-control square" name="comments" ></textarea>
								</div>

							</div>

							<div class="form-actions right">
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


	<div class="row match-height">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form-center">Event Registration</h4>
					<p class="mb-0">This example shows a way to center your form in the card. Here we have used <code>.justify-content-md-center .row</code> classe to center the form in a full width card. User can always change column classes according to his requirements. This example also uses form action buttons in the center bottom position of the card.</p>
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


	<div class="row justify-content-md-center">
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-card-center">Event Registration</h4>
					<p class="mb-0">This example shows a ways to center your card with form. Here we have used <code>.justify-content-md-center .row</code> classes to center the card as its not full width. User can always change column classes according to his requirements. This example also uses form action buttons in the center bottom position of the card.</p>
				</div>
				<div class="card-body">
					<div class="px-3">
						<form class="form">
							<div class="form-body">

								<div class="form-group">
									<label for="eventRegInput1">Full Name</label>
									<input type="text" id="eventRegInput1" class="form-control"  name="fullname">
								</div>

								<div class="form-group">
									<label for="eventRegInput2">Title</label>
									<input type="text" id="eventRegInput2" class="form-control"  name="title">
								</div>

								<div class="form-group">
									<label for="eventRegInput3">Company</label>
									<input type="text" id="eventRegInput3" class="form-control"  name="company">
								</div>

								<div class="form-group">
									<label for="eventRegInput4">Email</label>
									<input type="email" id="eventRegInput4" class="form-control"  name="email">
								</div>

								<div class="form-group">
									<label for="eventRegInput5">Contact Number</label>
									<input type="tel" id="eventRegInput5" class="form-control" name="contact" >
								</div>

								<div class="form-group">
									<label>Existing Customer</label>
									<div class="input-group">
										<div class="custom-control custom-radio display-inline-block">
                                            <input type="radio" id="customRadioInline4" name="customRadioInline3" class="custom-control-input">
                                            <label class="custom-control-label" for="customRadioInline4">Yes</label>
                                        </div>
                                        <div class="custom-control custom-radio display-inline-block">
											<input type="radio" id="customRadioInline3" checked name="customRadioInline3" class="custom-control-input">
                                            <label class="custom-control-label" for="customRadioInline3">No</label>
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

    <!-- START Notification Sidebar-->
    <aside id="notification-sidebar" class="notification-sidebar d-none d-sm-none d-md-block"><a class="notification-sidebar-close"><i class="ft-x font-medium-3"></i></a>
      <div class="side-nav notification-sidebar-content">
        <div class="row">
          <div class="col-12 mt-1">
            <ul class="nav nav-tabs">
              <li class="nav-item"><a id="base-tab1" data-toggle="tab" aria-controls="tab1" href="#activity-tab" aria-expanded="true" class="nav-link active">Activity</a></li>
              <li class="nav-item"><a id="base-tab2" data-toggle="tab" aria-controls="tab2" href="#chat-tab" aria-expanded="false" class="nav-link">Chat</a></li>
              <li class="nav-item"><a id="base-tab3" data-toggle="tab" aria-controls="tab3" href="#settings-tab" aria-expanded="false" class="nav-link">Settings</a></li>
            </ul>
            <div class="tab-content px-1 pt-1">
              <div id="activity-tab" role="tabpanel" aria-expanded="true" aria-labelledby="base-tab1" class="tab-pane active">
                <div id="activity" class="col-12 timeline-left">
                  <h6 class="mt-1 mb-3 text-bold-400">RECENT ACTIVITY</h6>
                  <div id="timeline" class="timeline-left timeline-wrapper">
                    <ul class="timeline">
                      <li class="timeline-line"></li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-purple bg-lighten-1"><i class="ft-shopping-cart"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="deep-purple-text medium-small">just now</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">Jim Doe Purchased new equipments for zonal office.</p>
                        </div>
                      </li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-info bg-lighten-1"><i class="fa fa-plane"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="cyan-text medium-small">Yesterday</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">Your Next flight for USA will be on 15th August 2015.</p>
                        </div>
                      </li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-success bg-lighten-1"><i class="ft-mic"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="green-text medium-small">5 Days Ago</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">Natalya Parker Send you a voice mail for next conference.</p>
                        </div>
                      </li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-warning bg-lighten-1"><i class="ft-map-pin"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="amber-text medium-small">1 Week Ago</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">Jessy Jay open a new store at S.G Road.</p>
                        </div>
                      </li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-red bg-lighten-1"><i class="ft-inbox"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="deep-orange-text medium-small">2 Week Ago</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">voice mail for conference.</p>
                        </div>
                      </li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-cyan bg-lighten-1"><i class="ft-mic"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="brown-text medium-small">1 Month Ago</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">Natalya Parker Send you a voice mail for next conference.</p>
                        </div>
                      </li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-amber bg-lighten-1"><i class="ft-map-pin"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="deep-purple-text medium-small">3 Month Ago</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">Jessy Jay open a new store at S.G Road.</p>
                        </div>
                      </li>
                      <li class="timeline-item">
                        <div class="timeline-badge"><span data-toggle="tooltip" data-placement="right" title="Portfolio project work" class="bg-grey bg-lighten-1"><i class="ft-inbox"></i></span></div>
                        <div class="col s9 recent-activity-list-text"><a href="#" class="grey-text medium-small">1 Year Ago</a>
                          <p class="mt-0 mb-2 fixed-line-height font-weight-300 medium-small">voice mail for conference.</p>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div id="chat-tab" aria-labelledby="base-tab2" class="tab-pane">
                <div id="chatapp" class="col-12">
                  <h6 class="mt-1 mb-3 text-bold-400">RECENT CHAT</h6>
                  <div class="collection border-none">
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-12.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Elizabeth Elliott </h4><span class="medium-small float-right blue-grey-text text-lighten-3">5.00 AM</span>
                        </div>
                        <p class="text-muted font-small-3">Thank you </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-6.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Mary Adams </h4><span class="medium-small float-right blue-grey-text text-lighten-3">4.14 AM</span>
                        </div>
                        <p class="text-muted font-small-3">Hello Boo </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-11.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Caleb Richards </h4><span class="medium-small float-right blue-grey-text text-lighten-3">9.00 PM</span>
                        </div>
                        <p class="text-muted font-small-3">Keny ! </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-18.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">June Lane </h4><span class="medium-small float-right blue-grey-text text-lighten-3">4.14 AM</span>
                        </div>
                        <p class="text-muted font-small-3">Ohh God </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-1.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Edward Fletcher </h4><span class="medium-small float-right blue-grey-text text-lighten-3">5.15 PM</span>
                        </div>
                        <p class="text-muted font-small-3">Love you </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-2.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Crystal Bates </h4><span class="medium-small float-right blue-grey-text text-lighten-3">8.00 AM</span>
                        </div>
                        <p class="text-muted font-small-3">Can we </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-3.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Nathan Watts </h4><span class="medium-small float-right blue-grey-text text-lighten-3">9.53 PM</span>
                        </div>
                        <p class="text-muted font-small-3">Great! </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-15.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Willard Wood </h4><span class="medium-small float-right blue-grey-text text-lighten-3">4.20 AM</span>
                        </div>
                        <p class="text-muted font-small-3">Do it </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-19.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Ronnie Ellis </h4><span class="medium-small float-right blue-grey-text text-lighten-3">5.30 PM</span>
                        </div>
                        <p class="text-muted font-small-3">Got that </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-14.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Gwendolyn Wood </h4><span class="medium-small float-right blue-grey-text text-lighten-3">4.34 AM</span>
                        </div>
                        <p class="text-muted font-small-3">Like you </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-13.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Daniel Russell </h4><span class="medium-small float-right blue-grey-text text-lighten-3">12.00 AM</span>
                        </div>
                        <p class="text-muted font-small-3">Thank you </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-22.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Sarah Graves </h4><span class="medium-small float-right blue-grey-text text-lighten-3">11.14 PM</span>
                        </div>
                        <p class="text-muted font-small-3">Okay you </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-9.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Andrew Hoffman </h4><span class="medium-small float-right blue-grey-text text-lighten-3">7.30 PM</span>
                        </div>
                        <p class="text-muted font-small-3">Can do </p>
                      </div>
                    </div>
                    <div class="media mb-1"><a><img alt="96x96" src="app-assets/img/portrait/small/avatar-s-20.png" class="media-object d-flex mr-3 bg-primary height-50 rounded-circle"></a>
                      <div class="media-body">
                        <div class="clearfix">
                          <h4 class="font-medium-1 primary mt-1 mb-0 mr-auto float-left">Camila Lynch </h4><span class="medium-small float-right blue-grey-text text-lighten-3">2.00 PM</span>
                        </div>
                        <p class="text-muted font-small-3">Leave it </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="settings-tab" aria-labelledby="base-tab3" class="tab-pane">
                <div id="settings" class="col-12">
                  <h6 class="mt-1 mb-3 text-bold-400">GENERAL SETTINGS</h6>
                  <ul class="list-unstyled">
                    <li>
                      <div class="togglebutton">
                        <div class="switch"><span class="text-bold-500">Notifications</span>
                          <div class="float-right">
                            <div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
                              <input id="notifications1" checked="checked" type="checkbox" class="custom-control-input cz-bg-image-display">
                              <label for="notifications1" class="custom-control-label"></label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <p>Use checkboxes when looking for yes or no answers.</p>
                    </li>
                    <li>
                      <div class="togglebutton">
                        <div class="switch"><span class="text-bold-500">Show recent activity</span>
                          <div class="float-right">
                            <div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
                              <input id="recent-activity1" checked="checked" type="checkbox" class="custom-control-input cz-bg-image-display">
                              <label for="recent-activity1" class="custom-control-label"></label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <p>The for attribute is necessary to bind our custom checkbox with the input.</p>
                    </li>
                    <li>
                      <div class="togglebutton">
                        <div class="switch"><span class="text-bold-500">Notifications</span>
                          <div class="float-right">
                            <div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
                              <input id="notifications2" type="checkbox" class="custom-control-input cz-bg-image-display">
                              <label for="notifications2" class="custom-control-label"></label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <p>Use checkboxes when looking for yes or no answers.</p>
                    </li>
                    <li>
                      <div class="togglebutton">
                        <div class="switch"><span class="text-bold-500">Show recent activity</span>
                          <div class="float-right">
                            <div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
                              <input id="recent-activity2" type="checkbox" class="custom-control-input cz-bg-image-display">
                              <label for="recent-activity2" class="custom-control-label"></label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <p>The for attribute is necessary to bind our custom checkbox with the input.</p>
                    </li>
                    <li>
                      <div class="togglebutton">
                        <div class="switch"><span class="text-bold-500">Show your emails</span>
                          <div class="float-right">
                            <div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
                              <input id="show-emails" type="checkbox" class="custom-control-input cz-bg-image-display">
                              <label for="show-emails" class="custom-control-label"></label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <p>Use checkboxes when looking for yes or no answers.</p>
                    </li>
                    <li>
                      <div class="togglebutton">
                        <div class="switch"><span class="text-bold-500">Show Task statistics</span>
                          <div class="float-right">
                            <div class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
                              <input id="show-stats" type="checkbox" class="custom-control-input cz-bg-image-display">
                              <label for="show-stats" class="custom-control-label"></label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <p>The for attribute is necessary to bind our custom checkbox with the input.</p>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </aside>
    <!-- END Notification Sidebar-->
    <?php 
    include 'bgtheme-settingicon.php';
    ?>
    <!-- BEGIN VENDOR JS-->
    <script src="vendors/js/core/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="vendors/js/core/popper.min.js" type="text/javascript"></script>
    <script src="vendors/js/core/bootstrap.min.js" type="text/javascript"></script>
    <script src="vendors/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
    <script src="vendors/js/prism.min.js" type="text/javascript"></script>
    <script src="vendors/js/jquery.matchHeight-min.js" type="text/javascript"></script>
    <script src="vendors/js/screenfull.min.js" type="text/javascript"></script>
    <script src="vendors/js/pace/pace.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN APEX JS-->
    <script src="js/app-sidebar.js" type="text/javascript"></script>
    <script src="js/notification-sidebar.js" type="text/javascript"></script>
    <script src="js/customizer.js" type="text/javascript"></script>
    <!-- END APEX JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- END PAGE LEVEL JS-->
  </body>

</html>