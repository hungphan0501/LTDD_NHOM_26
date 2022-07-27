<?php
    require "conn.php";
    $user=$_POST['email'];
    $pass=$_POST['pass'];

    class account{
        function __construct($id,$email,$pass,$name,$image,$address,$gender,$phone,$dob,$perr){
            $this->id=$id;
            $this->email=$email;
            $this->pass=$pass;
            $this->name=$name;
            $this->image=$image;
            $this->address=$address;
            $this->gender=$gender;
            $this->phone=$phone;
            $this->dob=$dob;
            $this->perr=$perr;
        }
    }

    $sql="SELECT * FROM user WHERE email='$user'&& pass='$pass'";
    $accountList=array();
    $rs=mysqli_query($connect,$sql);
    if($rs){
        while($row=mysqli_fetch_assoc($rs)){
            array_push($accountList,new account( $row['id']   
                                                    ,$row['email']
                                                    ,$row['pass']
                                                    ,$row['name']
                                                    ,$row['image']
                                                    ,$row['address']
                                                    ,$row['gender']
                                                    ,$row['phone']
                                                    ,$row['dob']
                                                    ,$row['perr']));
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