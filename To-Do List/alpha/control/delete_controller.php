<?php
	require "../global.php";
	try{
		$query = "update tb_todo set is_trash = true, delete_date=sysdate() where id=".$_GET["id"];
		if(!update_query($query))
			header("Location:../?error=Deu Ruim");
		header("Location:../");
			
	}catch(Exception $e){
         echo "erro :". $e->getMessage();
         exit();
    } 

?>