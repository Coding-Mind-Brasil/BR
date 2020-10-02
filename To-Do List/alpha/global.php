<?php
	
	const DB_HOST = "127.0.0.1";
	const DB_NAME = "to_do_list_db";
	const DB_USER = "root";
	const DB_PASS = "coti";

	function open(){
		$connection = mysqli_connect(DB_HOST,  DB_USER, DB_PASS)
		or die("Error : ".mysqli_error());
		mysqli_select_db($connection, DB_NAME)
		or die("Error : ".mysqli_error($connection));
		return $connection;
	}

	function close($connection = null){
		if($connection != null)
			mysqli_close($connection);
	}

	function getTask(){
		$connection = open();
		$query      = "select * from tb_todo where is_trash=false";
		$rs = mysqli_query($connection, $query);
		close($connection);
		return $rs;
	}
	function insert_task($task = null, $is_done = false, $is_trash = false){
		if($task == null)
			return 0;

		$connection = open();
		$query      = "insert into tb_todo values(null, '$task', false,false,sysdate(),null,null)";
		mysqli_query($connection, $query);
		$id = mysqli_insert_id($connection);
		close($connection);
		return $id;
	}

	function update_query($query = null){
		if($query == null)
			return 0;
		$connection = open();
		$rs = mysqli_query($connection, $query);
		
		close($connection);
		return $rs;
	}
	function update_task($id, $fields){
		if($task == null)
			return 0;

		$connection = open();
		$query      = "insert into tb_todo values(null, '$task', false,false)";
		mysqli_query($connection, $query);
		$id = mysqli_insert_id($connection);
		close($connection);
		return $id;
	}

?>