<?php
    require_once('conn.php');
    $info=$_POST['info'];
    $mon=$_POST['mon'];
    $lop=$_POST['lop'];
    

    $sql="SELECT * FROM lesson_detail,post,user WHERE user.id=post.user_id and lesson_detail.post_id=post.post_id and 
            lesson_detail.subject like '%$mon%' and lesson_detail.grade like '%$lop%' and user.name LIKE '%$info%' ";
    $rows = mysqli_query($connect, $sql);
    $find = array();
    while ( $row = mysqli_fetch_assoc($rows)) {
        if($row['method'] == 1){
                $row['method'] = 'online';
            }else if($row['method'] == 2){
                $row['method'] = 'offline';
            }else{
                $row['method'] = 'offline, online';
            }      
            if($row['fee'] == "0"){
                $row['fee'] = 'Thỏa Thuận';
            }
                else{
                    $row['fee'] = number_format($row['fee'])." VND";
                }
        $find[] = $row;
    }
    if(count($find)>0)
        echo json_encode($find);
?>