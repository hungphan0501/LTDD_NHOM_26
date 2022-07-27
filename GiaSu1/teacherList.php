<?php
    require "conn.php";


    $sql="SELECT l.lesson_detail_id,u.id,l.fee,l.number,l.hour,l.grade ,u.name, l.subject , l.address, t.method FROM user u ,tutor t, lesson_detail l , post p WHERE u.id = t.user_id and u.perr = 1 AND l.post_id = p.post_id AND p.user_id = u.id and l.create_at is null ; ";

     
    $accountList=array();
    $rs=mysqli_query($connect,$sql);
    if($rs){
        while($row=mysqli_fetch_assoc($rs)){
            if($row['method'] == 1){
                $row['method'] = 'online';
            }else if($row['method'] == 2){
                $row['method'] = 'offline';
            }else{
                $row['method'] = 'offline, online';
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