    var uI;
	var board;
	var players;
    var gameRoles;
    var isGameOver;

    startGame      = function(){
    	setup();
    	eventHandle();
    }
    restatGame  = function(){
    	players[0].isWinner=false;
    	players[1].isWinner=false;
    	board =[0,0,0, 0,0,0, 0,0,0];
    	for(let piece of uI.pieces)
    		piece.innerText = "";
    	isGameOver = false;
    }
    update		= function(){

    	if(hasWinner()){
    		console.log(isGameOver);
    	}
    	setMsg();
    }
    hasWinner  = function(){
    	for(let i = 0 ; i < gameRoles.length; i++){
    		for(let player of players){
    			if(board[gameRoles[i][0]]  == player.id &&
    				board[gameRoles[i][1]] == player.id &&
    				    board[gameRoles[i][2]] == player.id){
    				
    				player.isWinner  = true;
    				player.score    += 1;
    				isGameOver       = true;
    				player.isMyTurn  = true;
    				uI.score[player.id-1].innerText = player.score;

                    if(player.id == 1)
    					players[1].isMyTurn = false;

    				if(player.id == 2)
    					players[0].isMyTurn = false;

    				return true;
    			}

    		}
    	}
    	return false;
    }
    
    eventHandle = function(){

    	let index = 0;
    	for(let piece of uI.pieces){

    		piece.index = index++;
    		piece.addEventListener("click",()=>pieceEventClick(piece));

    	}

    	uI.btn_restart.addEventListener("click", ()=>restatGame());

    }

    pieceEventClick = function(piece){
	    if(!isGameOver)
	    	for(let player of players){

	    		if(player.isMyTurn && board[piece.index] == 0){

	    			board[piece.index] = player.id;
	    			player.isMyTurn    = false;
	    			
	    			if(player.id == 1)
	    				players[1].isMyTurn = true;

	    			if(player.id == 2)
	    				players[0].isMyTurn = true;

	    			
	    			uI.pieces[piece.index].innerText = player.piece;
	    			update(piece);
	    			
                    return 0;
	    		}	
	    	}

    	return 0;
    }



    setup = function(){

        isGameOver = false;
        players    = [];
        players[0] = {id:1, name:"X", piece:"X", score:0, isMyTurn:true, isWinner:false};
        players[1] = {id:2, name:"P O", piece:"O", score:0, isMyTurn:false, isWinner:false};
        board      = [0,0,0, 0,0,0, 0,0,0];
        gameRoles  = [[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8],[2,4,6],[0,4,8]];
        uI         = {};
        
        setUi();

    }

    setMsg = function(){

    	for(let player of players){

    		if(player.isMyTurn && player.isWinner){

    			uI.msg.innerText = player.piece +" Win";
    			return 0;

    		}

    		if(player.isMyTurn && !player.isWinner){

    			uI.msg.innerText = player.piece +" Turn";	
    			return 0;

    		}

    	}

    }

    setUi              = function(){
    	uI.score       = document.getElementsByClassName("score");
    	uI.pieces      = document.getElementsByClassName("piece");
    	uI.btn_restart = document.getElementsByClassName("btn-restat-game")[0];
    	uI.msg 	       = document.querySelector(".msg"); 
    }	

    
