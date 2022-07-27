<?php

    require "conn.php";
   $name=$_POST['name'];
   $perr=$_POST['perr'];
   $phone=$_POST['phone'];
   $gender=$_POST['gender'];
   $adress=$_POST['address'];
   $id=$_POST['id'];
   $dob=$_POST['dob'];
   
    // $name="tan";
    // $perr="0";
    // $phone="123456";
    // $gender="1";
    // $adress="ke";
    // $id="1";
    // $dob=null;

    

    $sql="UPDATE user SET id='$id',name='$name',address='$adress',gender='$gender',phone='$phone',dob='$dob',perr='perr ' WHERE id ='$id'";
    $accountList=array();
    $rs=mysqli_query($connect,$sql);

    if($rs)
    echo"thanh cong"

?>