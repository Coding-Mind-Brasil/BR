function Game(id = "my_game", width = 400, height=500, style="background:#ccc"){
	this.id      = id;
	this.width   = width;
	this.height  = height;
	this.style   = style;
	this.canvas  = null;
	this.context = null;
	this.delay   = 1;
	this.isRunning = false;
	this.isPause   = false; 
 	this.requestId = 0;
 	this.objects   = [];
}

Game.prototype = {
	create(){
		this.canvas 	   = document.createElement("canvas");
		this.canvas.id     = this.id; 
		this.canvas.width  = this.width 
		this.canvas.height = this.height;
		this.canvas.style  = this.style;
		this.context       = this.canvas.getContext("2d");

		this.objects["player"] = new Bird(this.context);
		this.objects["pips"] = [];
		this.objects["pips"].push(new Pip(this.context));
		

	},
	start(){
		this.isRunning = true;
		document.body.appendChild(this.canvas);
		this.render();
		this.requestAnimation()
	},
	stop(){

		window.cancelAnimationFrame(this.requestId);
		this.requestId = 0;
		this.isRunning = false;
	},
	pause(){
		this.render();
		this.isPause = (this.isPause? false:true);
	},
	loop(){
		if(!this.isRunning)return;
		if(this.requestId % this.delay == 0 && !this.isPause)this.render(),this.update();			
		this.requestAnimation();
	},
	requestAnimation(){
		this.requestId = window.requestAnimationFrame(()=>this.loop())
	},
	clear(){
		this.context.clearRect(0,0,this.canvas.width, this.canvas.height)
	},
	render(){
		this.clear();
		this.objects.pips.forEach(pip=>pip.draw())
		if(this.objects.player!= null) this.objects.player.draw();
		//this.objects.pips.forEach(pip=>pip.draw())
		
	},
	update(){
		this.collision();

		if(this.requestId % 70 == 0)this.objects.pips.push(new Pip(this.context))
		if(this.objects.player!= null) this.objects.player.update();
		this.objects.pips.forEach(pip=>{
										if(pip.collision(this.objects.player))this.pause();
										pip.update();});
	},

	collision(){

		px = this.objects.player.x;
		py = this.objects.player.y;
		pw = this.objects.player.width;
		ph = this.objects.player.height;
		
		cw = this.canvas.width
		ch = this.canvas.height
		if((py+ph) >= ch || (py) <= 0  )
			this.pause();


	}
	



}