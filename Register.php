<?php
    $con = mysqli_connect("testingserverhost.000webhostapp.com", "id7690220_testingserverhost", "May232001", "id7690220_testhostserver");
    
    $age = $_POST["isAdmin"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $statement = mysqli_prepare($con, "INSERT INTO user (username,password,isAdmin) VALUES (?, ?, ?)");
    mysqli_stmt_bind_param($statement, "siss",$username,$password,$isAdmin);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>