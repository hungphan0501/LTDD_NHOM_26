<?php
    require "conn.php";
    $id=$_POST['id'];
    $number=$_POST['number'];
    $method=$_POST['method'];
    $hour=$_POST['hour'];
    $fee=$_POST['fee'];
    $clas=$_POST['clas'];
    $mon=$_POST['mon'];
    $address=$_POST['address'];

    if($fee="30K/1h"){
        $fee=500000;
    } else 
        if($fee="60K/1h"){
            $fee=1000000;
        } else
            $fee=0;
    
    if($method="online"){
        $method=1;
    } else 
        $method=0;

    $sql="insert into post(post_id,user_id) values (null,'$id')";
    if(mysqli_query($connect,$sql)){
        $qr1 = "SELECT post_id from post where post_id = (SELECT max(post_id) from post)";
        $rows = mysqli_query($connect, $qr1);
        $row = mysqli_fetch_assoc($rows);
        if($row>0){
            $id_post=$row['post_id'];
            $sql1="insert into lesson_detail values (null,'$number','$method','$hour','$address','$fee',null,'$id_post','$clas','$mon');";
            if(mysqli_query($connect,$sql1)){
                echo 'success';
            } else{
                echo "insert lesson_detail deo ăn";
            }
        }
        else{
            echo "éo có id post";
        }
    } else{
        echo "éo insert dc post";
    }
?>