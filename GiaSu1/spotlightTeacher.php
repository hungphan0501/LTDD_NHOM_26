<?php
    require "conn.php";

    $sql = "SELECT tutor_id, count(*) as spotLight FROM lesson GROUP by tutor_id ORDER by spotlight desc limit 5";
    $rs=mysqli_query($connect,$sql);
    $accountList=array();
    if ($rs) {
        while ($row = mysqli_fetch_assoc($rs)) {
            $tutorId = $row['tutor_id'];
            $qr= "SELECT name,id from user, tutor
             where user.id = tutor.user_id and tutor.tutor_id = '$tutorId'" ;
            $rs1=mysqli_query($connect,$qr);
            $row1 = mysqli_fetch_assoc($rs1);
            $accountList[] = $row1;
            }
            if (count($accountList)>0) {
            echo json_encode($accountList);
            } else 
            echo "false";
    }
    else 
        echo "null";

?>