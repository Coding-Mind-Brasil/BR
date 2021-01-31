function Input(){
	this.isUp = false;
	this.start();
}
Input.prototype = {
	start(){
		onkeydown = ()=>this.isUp = true;
		onkeyup   = ()=>this.isUp = false;
	}
}
