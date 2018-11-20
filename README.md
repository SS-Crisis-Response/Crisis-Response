<?php 

	$db_host = 'localhost:3306';
    $db_user = 'root';
    $db_pass = '';
    $db_name = 'test';

    $con = mysqli_connect($db_host,'user',$db_pass,$db_name);
if($con){ 

if(isset($_POST["isAdmin"]) && isset($_POST["username"]) && isset($_POST["password"])) { 
	$username = $_POST["username"]; 
	$password = $_POST["password"]; 
	$isAdmin = $_POST["isAdmin"]; 

	$statement = mysqli_prepare($con, "INSERT INTO cresidentials (username,password,isAdmin) VALUES (?, ?, ?)"); 
	mysqli_stmt_bind_param($statement,'sss',$username,$password,$isAdmin); 
	mysqli_stmt_execute($statement); 

	if(!$statement) { 
		echo '{ 
				error : true, 
				message : "Wrong credentials. Access denied" 
			}'; 
	} else{ 
		echo '{ 
			error : false, 
			message : "Access Allowed" 
		}'; 
	} 

}else { 
	echo '{ 
		error : true, 
		message : "All credentials are required" 
	}'; 
} 

}else{ 
	echo '{ 
		error : true, 
		message : "Failed to connect to database" 
	}'; 
} 

?>
