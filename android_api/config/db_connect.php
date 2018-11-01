<?php
require 'db_config.php';

class createCon {
    
    var $host = DB_SERVER;
    var $user = DB_USER;
    var $pass = DB_PASSWORD;
    var $db = DB_DATABASE;
    var $myconn;

    function connect() {
        $con = mysqli_connect($this->host, $this->user, $this->pass, $this->db);
        if (!$con) {
            die('Could not connect to database!' . $con->connect_error);
        } else {
            $this->myconn = $con;
        }
        return $this->myconn;
    }

    function close() {
        mysqli_close($myconn);
    }

}

?>
