<?php
require "conn.php";
   $id=$_POST['id'];
//    $id="3";

    class post{
        function post($id_user,$name_subjects,$class){
            $this-> id_user= $id_user;
            $this-> name_subjects= $name_subjects;
            $this-> class= $class;
            
        }
    }

    $qurey1 ="SELECT * from listsubjects where id_user ='$id'";
    $r = mysqli_query($connect,$qurey1);
    $accountList=array();
    if($r){
        while($row=mysqli_fetch_assoc($r)){
            array_push($accountList,new post($row['id_user']
                                                ,$row['name_subjects']  
                                                ,$row['class']                                                
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