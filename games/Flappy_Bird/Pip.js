function Pip(context=null, width = 70){
	this.context  = context;
	this.x = context.canvas.width;
	this.y = 0;
	this.width    = width;
	this.height   = this.getRand(10, context.canvas.height - 160);

	this.gap = this.getRand(140, 160);
	this.y_bottom = this.height + this.gap ;
	this.height_bottom = context.canvas.height-(this.height- this.gap)  ;

	this.fillColor  = "red";
	this.strokeColor = "red";
	this.speed = 3;
	this.isAlive = true;
}
Pip.prototype = {
	draw(){
		this.context.beginPath();
		this.context.fillStyle = this.fillColor;
		this.context.fillRect(this.x, this.y, this.width, this.height);
		this.context.closePath();

		this.context.beginPath();
		this.context.strokeStyle = this.strokeColor;
		this.context.strokeRect(this.x, this.y_bottom, this.width, this.height_bottom);
		this.context.closePath();

	},
	update(){
		this.x -=this.speed;
	},

	collision(player = null){
		if(player == null)return;

		px  = player.x;
		pxw = px + player.width; 
		py  = player.y;
		pyh = py + player.height;

		ppx  = this.x;
		ppxw = ppx + this.width;
		ppy  = 0
		pph  = this.height;

		ppby = this.y_bottom
		ppbyh = ppby + this.height_bottom;

		if( ((px > ppx && px < ppxw) || (pxw > ppx && pxw < ppxw))  ){
			if((py > ppy && py < pph) ){
				this.fillColor = "green"; return true;
			}
			if((pyh > ppby && pyh < ppbyh) ){
				this.strokeColor = "green"; return true;
			}

		}else{
			this.fillColor = "red"
		}
		return false
	},

		
	getRand(min, max){
		return Math.floor((Math.random() * (max - min)) + min)
	}

}