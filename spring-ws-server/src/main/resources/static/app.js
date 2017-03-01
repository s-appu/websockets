var wsClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	wsClient = new WebSocket("ws://localhost:8080/ws/sport");
	wsClient.onopen = function(event) {
		wsClient.send("Here's some text that the server is urgently awaiting!");
	};
	wsClient.onmessage = function (event) {
		showGreeting(event.data);
	}
}

function disconnect() {
	wsClient.close();

}

function sendName() {
	wsClient.send(JSON.stringify({'name':$("#name").val()}));
}

function showGreeting(message) {
	$("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendName();
	});
});