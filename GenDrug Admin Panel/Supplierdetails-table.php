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
                    <h4 class="card-title">Supplier Details Table</h4>
                   
                </div>
                <div class="card-body">
                    <div class="card-block">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Number</th>
                                    <th>Supplier Name</th>
                                    <th>Supplier Address</th>
                                    <th>Stock</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="table-primary">
                                    <th scope="row">1</th>
                                    <td>...</td>
                                    <td>...</td>
                                    <td>...</td>
                                   
                                </tr>
                            </tbody>
                        </table>
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