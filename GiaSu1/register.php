<?php
    require "conn.php";
    $name=$_POST['name'];
    $email=$_POST['email'];
    $pass=$_POST['pass'];
    $address=$_POST['address'];
    $dob=$_POST['dob'];
    $phone=$_POST['phone'];
    $gt=$_POST['gender'];
    $perr=$_POST['perr'];
    $level=$_POST['level'];

    if($gt=="Nam"){
        $gender=0;
    } else if($gt=="Nữ"){
            $gender=1;
        }
        else{
            $gender=2;
        }

    $sql="insert into user values (null,'$email','$pass','$name',1,'$address',$gender,'$phone','$dob','$perr')";
    if(mysqli_query($connect,$sql)){
        $qr1 = "SELECT id from user where id = (SELECT max(id) from user)";
        $rows = mysqli_query($connect, $qr1);
        $row = mysqli_fetch_assoc($rows);
        if($row>0){
            $id_us=$row['id'];
            if($perr==1){
                $sql1="insert into tutor(tutor_id,user_id,level) values (null,'$id_us','$level');";
                if(mysqli_query($connect,$sql1)){
                    echo 'success';
                } else{
                    echo " không thêm được gia sư";
                }
            } else{
                $sql1="insert into student(student_id,user_id,level) values (null,'$id_us','$level');";
                if(mysqli_query($connect,$sql1)){
                    echo 'success';
                } else{
                    echo "không thêm được học sinh";
                }
            }
        }
        else{
            echo "không xảy ra";
        }
    } else{
        echo "Email đã tồn tại";
    }
?>