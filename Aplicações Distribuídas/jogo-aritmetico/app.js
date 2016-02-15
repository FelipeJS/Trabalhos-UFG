var fs = require('fs')
    , http = require('http')
    , socketio = require('socket.io');

global.jogadores = [];
global.desafio = { "pergunta":"", "resposta":0 };

function gerar_desafio() {
	var op1 = (100*Math.random()).toFixed();
	var op2 = (100*Math.random()).toFixed();
	global.desafio.pergunta = op1+'+'+op2;
	global.desafio.resposta = op1+op2;
}
 
var server = http.createServer(function(req, res) {
    res.writeHead(200, { 'Content-type': 'text/html'});
    res.end(fs.readFileSync(__dirname + '/index.html'));
}).listen(8080, function() {
    console.log('Listening at: http://localhost:8080');
});
 
socketio.listen(server).on('connection', function (socket) {
    socket.on('message', function (msg) {
        console.log('Message Received: ', msg);
        socket.broadcast.emit('message', msg);
    });
    socket.on('login', function (nome) {
        console.log('Usuario logado: ', nome);
		global.jogadores.push( { "id": socket.id, 
						  "nome": nome,
						  "pontos": 0 } );
        socket.broadcast.emit('message', 'Usuario '+nome+' entrou no jogo');
    });
    socket.on('listar', function (nome) {
		var lista = '';
        console.log('Usuario ', nome, 'listou jogadores');
        socket.emit('listar', global.jogadores );
    });
    socket.on('iniciar', function (nome) {
        console.log('Usuario ', nome, 'iniciou o jogo');
		gerar_desafio();
		socket.send(global.desafio.pergunta);
        socket.broadcast.send(global.desafio.pergunta);
    });
    socket.on('responder', function (objResposta) {
        console.log('Usuario ', objResposta.nome, 
					'respondeu');
		if ( global.desafio.resposta == objResposta.resposta.toString() )
	        console.log('Usuario ', objResposta.nome,' acertou!');
		else
	        console.log('Usuario ', objResposta.nome,' errou!');
    });
});
