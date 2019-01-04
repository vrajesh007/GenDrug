<?php
$con =mysqli_connect("localhost","root","","gendrug");

$editid =$_GET['editid'];
$selectquery= mysqli_query($con, "select * from shippingstatus where Shipping_id='{$editid}' ") or die("Error in Query".mysqli_error($con));
$rowfromdb = mysqli_fetch_array($selectquery);
print_r($rowfromdb);
?>