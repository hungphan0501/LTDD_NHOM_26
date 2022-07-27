<?php
    require "conn.php";
    $id=$_POST['id'];
    $sql="SELECT * FROM user WHERE id='$id'";
    $rs=mysqli_query($connect,$sql);
    $accountList=array();
    if($rs){
        while($row=mysqli_fetch_assoc($rs)){
            $accountList[] = $row;
        }
    }
    if (count($accountList)>0) {
        echo json_encode($accountList);
    }
    else{
        echo "false";
    }
?>