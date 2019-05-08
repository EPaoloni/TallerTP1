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
			<form class="col-xs-4" action="/proyecto-limpio-spring/enviar-cadena" method="POST">
				<select class="form-control" id="operation-select" name="nombreOperacion">
				  <option value="mayus">Pasar a may&uacute;sculas</option>
				  <option value="minus">Pasar a min&uacute;sculas</option>
				  <option value="invert">Invertir &oacute;rden</option>
				  <option value="cant">Cantidad de caracteres</option>
				</select>
				<input class="form-control" id="cadena" name="cadena" type="text" placeholder="Cadena">
				<button class="form-control btn btn-success" type="submit">Enviar</button>
			</form>
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>