<?php
	require "../global.php";
	try{
		if(insert_task($_POST["task"])==0)
			header("Location:../?error=Deu Ruim");
		header("Location:../");
			
	}catch(Exception $e){
         echo "erro :". $e->getMessage();
         exit();
    } 

?>