<html>  
<head>
<% response.addHeader("X-Frame-Options", "DENY"); %>
<% response.setHeader("Strict-Transport-Security" ,"max-age=7776000" ); %>
</head>
<body>
	<h3>Funciona!</h3>
	<small>${version}</small>
</body>
</html>