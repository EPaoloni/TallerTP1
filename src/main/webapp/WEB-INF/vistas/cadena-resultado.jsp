<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h2>Resultado de la operaci&oacute;n:</h2>
				<c:if test="${not empty cadenaResultado}">
			        <h2><span>${cadenaResultado}</span></h2>
			        <br>
		        </c:if>	
				<c:if test="${not empty cantidadCaracteres}">
			        <h2><span>${cantidadCaracteres}</span></h2>
			        <br>
		        </c:if>	
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>