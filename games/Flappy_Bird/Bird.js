function Bird(context=null,x =100 , y =300, width = 50, height=50, bg_color = "black"){
	this.context  = context;
	this.x = x;
	this.y = y;
	this.width    = width;
	this.height   = height;
	this.bg_color = bg_color;
	this.velocity = 0;
	this.gravity  = .5;
	this.impulse  = 4;
	this.input    = new Input(); 
}
Bird.prototype = {
	draw(){
		this.context.beginPath();
		this.context.fillStyle = this.bg_color;
		this.context.fillRect(this.x, this.y, this.width, this.height);
		this.context.closePath();
	},
	update(){
		if(this.input.isUp)this.up();
		this.down();
	},
	up(){
		this.velocity  = 0
		this.velocity -= this.impulse 
		this.y += this.velocity;
		return;
	},
	down(){
		this.velocity += this.gravity
		this.y += this.velocity;
	}
}