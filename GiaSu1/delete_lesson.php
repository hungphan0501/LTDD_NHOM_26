<?php
 require "conn.php";
 


    $lesson_detail_id=$_POST['lesson_detail_id'];

    // $lesson_detail_id=16;
    $p="SELECT post_id FROM lesson_detail where lesson_detail_id ='$lesson_detail_id'";
    $pr1 = mysqli_query($connect,$p);

    
    if(mysqli_num_rows($pr1)>0){
        $row=mysqli_fetch_assoc($pr1);
        $post_id_kt=$row['post_id'];
        
        
        $rp1="DELETE FROM lesson_detail WHERE lesson_detail_id = '$lesson_detail_id'";
        $r1 = mysqli_query($connect,$rp1);
        if($r1){
            $rp2="DELETE FROM post WHERE post_id = '$post_id_kt'";
            $r2 = mysqli_query($connect,$rp2);
            if($r2){echo"1";}
                
            else {echo"loi2";}
                    
        }
        else{echo"loi1";}
       
    }else{echo"loi";}
        
    
   




?>