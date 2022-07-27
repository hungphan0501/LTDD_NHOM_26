<?php
    require "conn.php";
    $id = 1;

        $sql="SELECT u.id, u.name, t.level, u.gender, u.address, l.subject, t.method FROM user u, tutor t, lesson_detail l, lesson le WHERE u.id = t.user_id and l.lesson_detail_id = le.lesson_detail_id and le.tutor_id = t.tutor_id and u.id='$id' limit 1";
    $accountList=array();
    $rs=mysqli_query($connect,$sql);
    if($rs){
        while($row=mysqli_fetch_assoc($rs)){
            if($row['method'] == 1){
                $row['method'] = 'Online';
            }else if($row['method'] == 2){
                $row['method'] = 'Offline';
            }else{
                $row['method'] = 'Offline, Online';
            }
            if($row['gender'] == 1){
                $row['gender'] = 'Nam';
            }else{
                $row['gender'] = 'Nữ';
            } 
            if($row['level'] == 1){
                $row['level'] = 'Giáo Viên';
            }else{
                $row['level'] = 'Sinh Viên';
            } 
            $accountList[] = $row;
            }
        if(count($accountList)>0){
            echo json_encode($accountList);
        } else{
            echo "false";
        }
    } else{
        echo "null";
    }
?>