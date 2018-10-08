<!DOCTYPE html>
<html lang="en" class="loading">
  
<?php
include 'header.php';
?>
<body>
<?php 
include 'sidebar.php' ;
?>

<div class="main-panel">
<div class="main-content">
<div class="content-wrapper">
<!-- Basic form layout section start -->
<div class="row">
<div class="col-12">
<div class="content-header">Tables</div>
</div>
</div>

<!--Contextual classes Starts-->
<section id="contenxtual">
    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Delivery-man Details Table</h4>
                   
                </div>
                <div class="card-body">
                    <div class="card-block">
                        <?php
                                $con =mysqli_connect("localhost","root","root","gendrug");
                                $query=mysqli_query($con, "select * from deliverymandetails") or die(mysqli_error($con));
                          echo"<table class='table'>";
                           echo" <thead>";
                             
                                echo"<tr>";
                                echo"<th>Number</th>";
                                echo"<th>Deliveryman Name</th>";
                                echo"<th>Deliveryman Address</th>";
                                echo"<th>Deliveryman Phone Number</th>";   
                                echo"</tr>";
                            echo"</thead>";
                          
                            echo"<tbody>";
                              while ($row= mysqli_fetch_array($query))
                                { 
                               echo"<tr class='table-primary'>";
                                    echo"<th scope='row'>{$row['Deliveryman_id']}</th>";
                                    echo"<td>{$row['Deliveryman_name']}</td>";
                                    echo"<td>{$row['Deliveryman_address']}</td>";
                                    echo"<td>{$row['Deliveryman_phnum']}</td>";    
                                echo"</tr>";
                                }
                                
                           echo" </tbody>";
                                       
                                    
                          echo"</table>";
                          ?>
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