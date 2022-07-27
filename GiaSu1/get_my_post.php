<?php
    require "conn.php";

    $id=$_POST['id'];
    
    class post{
        function post($lesson_detail_id,$user_id,$grade,$subject,$fee,$address,$method,$hour,$level){
            $this->  lesson_detail_id= $lesson_detail_id;
            $this-> user_id= $user_id;
            $this-> grade= $grade;
            $this-> subject= $subject;
            $this-> fee= $fee;
            $this-> address= $address;
            $this-> method= $method;
            $this-> hour= $hour;
            $this-> level= $level;
        }
    }


    $sql=" SELECT l.lesson_detail_id,p.user_id,l.fee,l.grade , l.subject , l.address, l.method, l.hour, p.level FROM user u , lesson_detail l , post p WHERE  u.id='$id' and u.id = p.user_id  AND l.post_id = p.post_id AND p.user_id = u.id and l.create_at is null;";
    $r = mysqli_query($connect,$sql);

    
    
    $accountList=array();
    if($r){
        while($row=mysqli_fetch_assoc($r)){
            array_push($accountList,new post($row['lesson_detail_id']
                                                ,$row['user_id']  
                                                ,$row['grade'] 
                                                ,$row['subject']
                                                ,$row['fee'] 
                                                ,$row['address'] 
                                                ,$row['method'] 
                                                ,$row['hour'] 
                                                ,$row['level'] 
                                                ));
    }
        if(count($accountList)>0){
            echo json_encode($accountList);
        } else{
            echo "";
        }
    }
    else{
    echo "null";
    } 

?>