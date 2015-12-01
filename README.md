# ServerSentEvents

Showing how to use Server Sent Event from a backend to a frontend.

This is a <b>Push</b> protocol implementation, if you want to know more about the differences between pull and push, go <a href="https://drublic.de/archive/the-difference-between-push-and-pull/">here</a>

This is by creating a WebSocker (EventSource in AngularJS) that connects to the server, keeps open and gets updated as the server sends new information.

This implementation is based on http://www.smartjava.org/content/html5-server-sent-events-angularjs-nodejs-and-expressjs but the client is a bit more sophisticated using modern techniques.

# How to use



<h1>Frontend</h1>

<h2>AngularJS</h2>

Initial implementation of the client, it connects to the server using EventSource

<code>
	var source = new EventSource('http://localhost:12000/stats');
    source.addEventListener('message',handleCallback,false);
</code>

and keeps listening for server messages.


<h1>Backend</h1>

<h2>NodeJS</h2>

NodeJS server implementation to serve information about the machine to the connected clients

<h2>Java</h2>

Work in progress
