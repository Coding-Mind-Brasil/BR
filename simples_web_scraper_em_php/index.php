<?php
	$filename = "https://www.worldometers.info/coronavirus/";
	$content = file_get_contents($filename);

	$pattern ='/<div class="maincounter-number".*?>\s<span.*?>\s?([0-9,]+)\s?<\/span>\s?<\/div>/';
	preg_match_all($pattern, $content, $match);
	
	echo "<br>================Coronavirus stats================";
	echo "<br>Cases........: ".$match[1][0];
	echo "<br>Deaths.......: ".$match[1][1];
	echo "<br>Recovered....: ".$match[1][2];
	echo "<br>============================================";
?>