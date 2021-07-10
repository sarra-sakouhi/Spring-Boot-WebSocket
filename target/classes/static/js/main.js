'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var senderid =null;
var recieverid =null;
var activeusers=null;

var chainePage = document.querySelector('#chaine-page');
var chaineForm = document.querySelector('#chaineForm');
var chaine = null;


var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    username = document.querySelector('#name').value.trim();
	chaine = document.querySelector('#chaine').value.trim();
	senderid = document.querySelector('#senderid').value.trim();
	recieverid = document.querySelector('#recieverid').value.trim();
    if(username && chaine) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');    
        
        var socket = new SockJS('/softib');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError); 
    }
	 event.preventDefault();
}

function onConnected() {
    // Subscribe to the Public Topic
    if(chaine === "public"){
    stompClient.subscribe('/topic/public' , onMessageReceived);
    stompClient.send("/chat.register",
        {},
        JSON.stringify({sender: {id:senderid,nom:username}, type: 'JOIN',chaine:chaine})
    )
    }else if (chaine === "chatbot"){
    stompClient.subscribe('/queue/chatbot' , onMessageReceived);
    stompClient.send("/chat.botregister",
        {},
        JSON.stringify({sender: {id:senderid,nom:username}, type: 'JOIN',chaine:chaine}),
    )
    }else{
    stompClient.subscribe('/queue/'+chaine , onMessageReceived);
    stompClient.send("/chat.privateregister",
        {},
        JSON.stringify({sender: {id:senderid,nom:username}, type: 'JOIN',chaine:chaine}),
    )
    }
    

   

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function send(event) {
    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) {
        var chatMessage2= {
        sender: {
            id: senderid,
            nom: username
        },
        content: messageInput.value,
        recievers: [
            {
                id: recieverid,
            }
        ],
        vu: false,
        type: "CHAT",
        chaine: chaine
    };

	if(chaine === "public"){
	stompClient.send("/chat.send", {}, JSON.stringify(chatMessage2));
	}if(chaine === "chatbot"){
	stompClient.send("/chat.botsend", {}, JSON.stringify(chatMessage2));
	sleep(2000).then(() => {
    stompClient.send("/chat.botanswer", {}, JSON.stringify(chatMessage2));
});
	
	}else{
	stompClient.send("/chat.privatesend", {}, JSON.stringify(chatMessage2));
	}
        
        messageInput.value = '';
    }
    event.preventDefault();
}

function sleep (time) {
  return new Promise((resolve) => setTimeout(resolve, time));
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender.nom + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender.nom + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender.nom[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender.nom);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender.nom);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }
    

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', send, true)
