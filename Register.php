<?php
    $con = mysqli_connect("https://testinghostserver.000webhostapp.com/", "id7645332_fakesynergyservicesvserver", "Minecraft10", "id7645332_testingdbss");
    
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