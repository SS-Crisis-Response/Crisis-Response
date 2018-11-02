<?php
    $con = mysqli_connect("testingserverhost.000webhostapp.com", "id7690220_testingserverhost", "May232001", "id7690220_testhostserver");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    $isAdmin = $_POST["isAdmin"]
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password,$isAdmin);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID,$username, $password,$isAdmin);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["username"] = $username;
        $response["password"] = $password;
		$response["isAdmin"]=$isAdmin
    }
    
    echo json_encode($response);
?>