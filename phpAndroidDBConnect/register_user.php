<?php
    include 'config/db_connect.php';

    $username = $_POST['username'];
    $firstname = $_POST['firstname'];
    $lastname = $_POST['lastname'];
    $password = $_POST['password'];
    $phonenumber = $_POST['phonenumber'];
    $email = $_POST['email'];

    $conn = connect();
    $conn->query("USE cookbook;");

    $sql = "INSERT INTO users_tbl (username,firstname,lastname,password,phone_number,email) VALUES("."'".$username."'".","
                                                                                                    ."'". $firstname."'".","
                                                                                                    ."'".$lastname."'".","
                                                                                                    ."'".$password."'".","
                                                                                                    . $phonenumber . ","
                                                                                                    ."'".$email."'".")";
    
    if ($conn->query($sql) === TRUE) {
        echo "Success";
    } else {
        echo "Unsuccessful".$conn->error;
    }
?>