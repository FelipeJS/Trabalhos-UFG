package br.ufg.inf.pwv0114;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MeuServlet extends HttpServlet {
	@Override
	public void doGet(
			HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		/*String Numero1 =
				req.getParameter("Num1");
		
		String Numero2 =
				req.getParameter("Num2");*/
		
		int idade1 = Integer.parseInt(req.getParameter("idade"));
		
		if(idade1 < 18){
			resp.sendRedirect("http://disney.com");
		}
		else{
			resp.sendRedirect("http://r7.com");
		}
		/*
		String op;
		String Operacao = req.getParameter("Operacao");
		int OperacaoNum = Integer.parseInt(Operacao); 
		int resultado = 0;
		
		switch(OperacaoNum){
		case 1:
			resultado = (Integer.parseInt(Numero1)+Integer.parseInt(Numero2));
			op = "+";
			break;
		case 2:
			resultado = (Integer.parseInt(Numero1)-Integer.parseInt(Numero2));
			op="-";
			break;
		case 3:
			resultado = (Integer.parseInt(Numero1)*Integer.parseInt(Numero2));
			op="*";
			break;
		default:
			resultado = (Integer.parseInt(Numero1)/Integer.parseInt(Numero2));
			op="/";
			break;	
		}
			
		resp.getWriter().print(
			"<html>"+
			"<head>"+
			"<title>"+
			"Servlet"+
			"</title>"+
			"<body>"+
			"<h1>Resultado: "+
			Numero1 +" "+ op +" "+ Numero2 + " = "+ resultado + 
			"</h1>"+
			"<br><br><a href=\"formulario.html\">Formulario</a>"+
			"</body>"+
			"</head>"+	
			"</html>"
		);*/
	}
}
