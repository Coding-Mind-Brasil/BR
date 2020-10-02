<?php
	require "global.php";
	try{
		$rs=getTask();
	}catch(Exception $e){
         echo "erro :". $e->getMessage();
         exit();
    } 
?>
<!DOCTYPE html>
<html>
<head>
	<title>ToDo List</title>
	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
	<style type="text/css">
		.link{
			text-decoration: none;
		}
		.done{
			text-decoration: line-through;
    		--opacity: 50%;
		    background: #05f705;  
		}
		.hide{
			display: none;
		}
	</style>
</head>
<body>
	<article class="to-do-list-app">
		<h1><span class="color-green">ToDo</span> List</h1>
		<section class="task-input-wrapper"> 
			<div class="task-input">
				<div class="input-wrapper">
					<form method="POST" action="control/add_controller.php">
						<input type="text"   name="task" placeholder="Enter a task"  class="input-box" />
						<input type="submit" value="ADD" class="btn btn-add-task" />
					</form>
				</div>
			</div>
		</section>
		<section class="to-do-list">
			<?
				while($todo = mysqli_fetch_object($rs)){
			?>
				<div class="item">
					<div class="task-wrapper">
						<div class='task-title <?= ($todo->is_done?"done":"") ?>'>
							<?= $todo->task ?>
						</div>
					</div>
					<div class="action-btn-wrapper">
						<div class='action-btn <?= ($todo->is_done?"hide":"") ?> '>
						 	<a href="control/done_controller.php?id=<?= $todo->id ?>" class="link done-btn color-green">DONE</a>
						 </div>
						<div class="action-btn ">
						<a href="control/delete_controller.php?id=<?= $todo->id ?>" class="link delete-btn color-red">DELETE</a>
						</div>

					</div>
				</div>
			<?}?>
		</section>

	</article>
</body>
</html>