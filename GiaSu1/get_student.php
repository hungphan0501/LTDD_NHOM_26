<?php
require "conn.php";
    $id=$_POST['id'];
    //$id="16";
  

    class post{
        function post($level,$student_id){
            
            $this-> level= $level;
            $this-> student_id=$student_id;
            
        }
    }

    $qurey1 ="SELECT * from student where user_id ='$id'";
    $r = mysqli_query($connect,$qurey1);
    $accountList=array();
    if($r){
        while($row=mysqli_fetch_assoc($r)){
            array_push($accountList,new post($row['level']
                                            ,$row['student_id']
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