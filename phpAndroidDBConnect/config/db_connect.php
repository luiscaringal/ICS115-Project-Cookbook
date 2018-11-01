<?php
    function connect(){
        require 'db_config.php';
        $con = mysqli_connect($db_server, $db_username, $db_password);
        if (!$con) {
            die('Could not connect to database!' . $con->connect_error);
        }
        return $con;
    }
?>
