<?php
    include 'config/db_connect.php';

    if(isset($_POST['username']) && isset($_POST['firstname']) && isset($_POST['lastname']) && isset($_POST['password']) && isset($_POST['phonenumber']) && isset($_POST['email'])){
        $username = $_POST['username'];
        $firstname = $_POST['firstname'];
        $lastname = $_POST['lastname'];
        $password = $_POST['password'];
        $phonenumber = $_POST['phonenumber'];
        $email = $_POST['email'];    

        $db = new createCon();
        $db->connect();
        $db = $db->myconn;
        
        $stmt = $db->prepare('
            INSERT 	INTO `users_tbl`
            (
                `username`,
                `firstname`,
                `lastname`,
                `password`,
                `phone_number`,
                `email`
            )
            VALUES
            (
                ?,
                ?,
                ?,
                ?,
                ?,
                ?
            )
	    ') or die($db->error);

        $stmt->bind_param('ssssis',	$username, 
                                    $firstname, 
                                    $lastname,
                                    $password, 
                                    $phonenumber, 
                                    $email);
        $stmt->execute();

        if ($db->affected_rows > 0) {
            echo "Success";
        } else {
            echo "Unsuccessful (".$db->error.")";
        }
    }
    else{
        echo "Insufficient Data!";
    }
?>