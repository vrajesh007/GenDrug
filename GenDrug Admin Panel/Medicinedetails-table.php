<?php
session_start();
if(!isset($_SESSION['session_id']))
    {
        header("location:login.php");
    
    }
    
?>
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
                    <h4 class="card-title">Medicine Details Table</h4>
                    <a href="medicinedetails-form.php"  class="btn btn-raised btn-info"style="float:right">Add</a>
                   
                </div>
                <div class="card-body">
                    <div class="card-block">
                        <?php
                                $con =mysqli_connect("localhost","root","","gendrug");
                                if(isset($_GET['did']))
                                {
                                $deleteid=$_GET['did'];
                                $deletequery = mysqli_query($con, "delete from medicinedetails where P_id= '{$deleteid}' ") or die(mysqli_error($con));
                               
                                } 
                                $query=mysqli_query($con, "select * from medicinedetails") or die(mysqli_error($con));
                          echo"<table class='table'>";
                           echo" <thead>";
                             
                                echo"<tr>";
                                echo"<th>Number</th>";
                                echo"<th>Product Name</th>";
                                echo"<th>Product Details</th>";
                                echo"<th>Product Category</th>";
                                echo"<th>Price</th>";
                                echo"<th>Stock</th>";  
                                echo"<th>Photo</th>";
                                echo"<th>Actions</th>";
                                echo"</tr>";
                            echo"</thead>";
                          
                            echo"<tbody>";
                              while ($row= mysqli_fetch_array($query))
                                { 
                               echo"<tr class='table-primary'>";
                                    echo"<th scope='row'>{$row['P_id']}</th>";
                                    echo"<td>{$row['P_name']}</td>";
                                    echo"<td>{$row['P_details']}</td>";
                                    echo"<td>{$row['P_category']}</td>";
                                    echo"<td>{$row['P_price']}</td>";
                                    echo"<td>{$row['P_stock']}</td>";
                                    echo"<td><a href='{$row['P_photo']}'><img style= 'height:100px; width:100px;' src='{$row['P_photo']}'></td>";  
                                    echo "<td> <a href='medicinedetails-edit.php?editid=$row[0]' > <img src='img/edit.png' alternate='Edit' height='27' width='27'/>  </a> | <a href='Medicinedetails-table.php?did={$row['P_id']}' > <img src='img/delete.png' alternate='Delete' height='27' width='27'/> </a> </td>";
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