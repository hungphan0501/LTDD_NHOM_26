<?php
    require "conn.php";
    $lesson_id=$_POST['lesson_id'];
    $user_id1=$_POST['user_id1'];
    $user_id2=$_POST['user_id2'];

    $sql = "SELECT student_id from student where user_id = '$user_id1'";
    $rs=mysqli_query($connect,$sql);
    while ($row = mysqli_fetch_assoc($rs)) {
        $student_id = $row['student_id']; 
    }
    $sql1 = "SELECT tutor_id from tutor where user_id = '$user_id2'";
    $rs1=mysqli_query($connect,$sql1);
    while ($row1 = mysqli_fetch_assoc($rs1)) {
        $tutor_id = $row1['tutor_id']; 
    }
    $sql3 ="INSERT INTO lesson values ('$lesson_id', '$student_id','$tutor_id')";
    $rs3 = mysqli_query($connect,$sql3);
    if ($rs3) {
        $sql4 = "UPDATE lesson_detail set create_at = current_timestamp() where lesson_detail_id = '$lesson_id'";
        $rs4 = mysqli_query($connect,$sql4);
          echo "indc"; 
          }else{
          echo $lesson_id.$user_id1.$user_id2.$student_id.$tutor_id;        
}
?>