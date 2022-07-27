<?php
require "conn.php";
   $id=$_POST['id'];
//    $id="3";

    class post{
        function post($grade,$level,$tutor_id){
            $this-> grade= $grade;
            $this-> level= $level;
            $this-> tutor_id= $tutor_id;
            
        }
    }

    $qurey1 ="SELECT * from tutor where user_id ='$id'";
    $r = mysqli_query($connect,$qurey1);
    $accountList=array();
    if($r){
        while($row=mysqli_fetch_assoc($r)){
            array_push($accountList,new post($row['grade']
                                                ,$row['level']  
                                                ,$row['tutor_id']                                                
                                                ));
    }
        if(count($accountList)>0){
            echo json_encode($accountList);
        } else{
            echo "false";
        }
    }
    else{
    echo "null";
    }   

?>