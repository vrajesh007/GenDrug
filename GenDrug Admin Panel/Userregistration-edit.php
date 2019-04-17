<?php
$con =mysqli_connect("localhost","root","","gendrug");

$editid =$_GET['editid'];

if(!isset($_GET['editid'])|| empty($_GET['editid']))
{
    header("location:Userregistration-table.php");
}
$selectquery= mysqli_query($con, "select * from Userregistration where U_id='{$editid}' ") or die("Error in Query".mysqli_error($con));
$rowfromdb = mysqli_fetch_array($selectquery);

if($_POST)
{
    $id= mysqli_real_escape_string($con,$_POST['txt1']);
    $name= mysqli_real_escape_string($con,$_POST['txt2']);
    $gender= mysqli_real_escape_string($con,$_POST['txt3']);
    $dob= mysqli_real_escape_string($con,$_POST['txt4']);
    $phonenumber= mysqli_real_escape_string($con,$_POST['txt5']);
    $email= mysqli_real_escape_string($con,$_POST['txt6']);
    $address= mysqli_real_escape_string($con,$_POST['txt7']);
    
    $updatequery= mysqli_query($con, "update userregistration set U_name='{$name}',Gender='{$gender}',DOB='{$dob}',Phonenum='{$phonenumber}',Email='{$email}',Address='{$address}' where U_id='{$id}'") or die("Error in Update Query".mysqli_error($con));
    
    if($updatequery)
    {
        echo "<script>alert('Record Updated');window.location='Userregistration-table.php';</script>";
    }
}
?>
<html>
    <body>
        <form method="post">
            ID: <input type="hidden" value="<?php echo $rowfromdb['U_id']?>" name="txt1">
            <br/>
            
            Name:<input type="text" value="<?php echo $rowfromdb['U_name']?>" name="txt2">
            <br/>
            
            Gender:<input type="text" value="<?php echo $rowfromdb['Gender']?>" name="txt3">
            <br/>
            
            D.O.B:<input type="text" value="<?php echo $rowfromdb['DOB']?>" name="txt4">
            <br/>
            
            Phone Number:<input type="text" value="<?php echo $rowfromdb['Phonenum']?>" name="txt5">
            <br/>
            
            Email:<input type="text" value="<?php echo $rowfromdb['Email']?>" name="txt6">
            <br/>
            
            Address:<input type="text" value="<?php echo $rowfromdb['Address']?>" name="txt7">
            <br/>
            <input type="submit" value="Update">
            <input type="button" value="Cancel" onclick="window.location='Userregistration-table.php';">
        </form>
    </body>
</html>

