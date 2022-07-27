<?php

    require "conn.php";
        $id =$_POST['id'];
        $pass =$_POST['pass'];
        $pass_old=$_POST['pass_old'];

    // $id ="1";
    // $pass ="123";
    // $pass_old="1234567";


    
    $pr="Select * from user where id= '$id' and pass='$pass_old' ";
     
    $row =mysqli_query($connect,$pr);

    if(mysqli_fetch_assoc($row))
    {

    $sql="UPDATE user SET pass='$pass' WHERE id ='$id' and pass='$pass_old' ";
    

    if(mysqli_query($connect,$sql)){
        echo"thanh cong";
    }
    }
    

?>