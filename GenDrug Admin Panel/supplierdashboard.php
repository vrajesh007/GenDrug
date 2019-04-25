<?php
session_start();
if(!isset($_SESSION['session_id']))
    {
        header("location:supplierlogin.php");
    
    }
    
?>
<!DOCTYPE html>
<html lang="en" class="loading">
<?php
include 'header.php';
?>
<body>
<?php 
include 'suppliersidebar.php' ;
?>

<div class="main-panel">
<div class="main-content">
<div class="content-wrapper">
<!-- Basic form layout section start -->


<!--Contextual classes Starts-->
<section id="contenxtual">
    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Welcome to GenDrug.</h4>
                    <a href="supplierchangepassword.php" class="btn btn-raised btn-info" style="float:left">Change Password</a>  
                     <a href="supplierlogout.php" class="btn btn-raised btn-info" style="float:right">Logout</a>                    
                </div>
                <div class="card-body">
                    <div class="card-block">
                    
                                    <!-- to add dark grey color in table rows, use class="table-dark", for blue use class="Primary", for medium gray use class="Secondary", for green use class="success", for pink use class="Danger", for light orange use class="Warning", for skyblue use class="Info", and for white and grayish use class="Light" and "Dark" respectively. -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--Contextual classes Ends-->

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
