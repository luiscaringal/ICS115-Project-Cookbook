<?php 
    include 'config/db_connect.php';
    $response = array();
    $response["success"] = 0;

    create_database();
    create_tables();

    function create_database(){
        $conn = connect();

        $sql = "CREATE DATABASE IF NOT EXISTS cookbook;";
        if ($conn->query($sql) === TRUE) {
            echo "Success";
        } else {
            echo "Unsuccessful";
        }

        $conn->close();
    }

    function create_tables(){
        $conn = connect();
        $conn->query("USE cookbook;");
        $sql = "CREATE TABLE IF NOT EXISTS users_tbl (  `id` INT PRIMARY KEY AUTO_INCREMENT, 
                                                        `username` VARCHAR(30) UNIQUE NOT NULL,
                                                        `firstname` VARCHAR(30) NOT NULL, 
                                                        `lastname` VARCHAR(30) NOT NULL,
                                                        `password` VARCHAR(30) NOT NULL,
                                                        `phone_number` INT NOT NULL,
                                                        `email` VARCHAR(30) NOT NULL
                                                        );";
        if ($conn->query($sql) === TRUE) {
            echo "Success";
        } else {
            echo "Unsuccessful".$conn->error;
        }

        $conn->close();
    }
    echo json_encode($response);
?>