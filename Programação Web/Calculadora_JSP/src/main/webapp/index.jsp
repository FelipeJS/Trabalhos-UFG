<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora_JSP</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/template.css" />
</head>
<body>
	<div class="container">
		<div class="row" >
			<div class="col-md-3"></div>

			<div class="col-md-5">
				<section class="login-form">
				<form  role="login">
					<h1>Calculadora</h1>

					<%
						try {
							String numero1 = request.getParameter("numero1");
							String numero2 = request.getParameter("numero2");
							String operacao = request.getParameter("operacao");

							int num1 = Integer.parseInt(numero1);
							int num2 = Integer.parseInt(numero2);
							int op = Integer.parseInt(operacao);
							int resultado = 0;

							out.print("<br/><h3>Preencha os campos abaixo:</h3>");

							switch (op) {
							case 2:
								resultado = num1 - num2;
								out.print("<br/><h4>Resultado: " + resultado + "</h4>");
								break;
							case 3:
								resultado = num1 * num2;
								out.print("<br/><h4>Resultado: " + resultado + "</h4>");
								break;
							case 4:
								resultado = num1 / num2;
								out.print("<br/><h4>Resultado: " + resultado + "</h4>");
								break;
							default:
								resultado = num1 + num2;
								out.print("<br/><h4>Resultado: " + resultado + "</h4>");
								break;
							}
						} catch (Exception ex) {
							out.print("<label><h3>Preencha os campos abaixo:</h3></label><br/>");
						}
					%>

					<br/><label>Numero 1:</label>
					<input type="text" name="numero1" class="form-control input-lg" />
					
					<br/><label>Operação:</label> 
					<select name="operacao" class="form-control input-lg">
						<option value="1">Soma</option>
						<option value="2">Subtracao</option>
						<option value="3">Multiplicacao</option>
						<option value="4">Divisao</option>
					</select>
					
					<br/><label>Numero 2:</label>
					<input type="text" name="numero2" class="form-control input-lg" />
					
					<br/><button class="btn btn-lg btn-primary btn-block">Calcular</button>
				</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>