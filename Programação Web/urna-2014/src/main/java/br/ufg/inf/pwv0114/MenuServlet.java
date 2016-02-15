package br.ufg.inf.pwv0114;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MenuServlet extends HttpServlet {
	@Override
	public void doGet(
			HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		int candidatoA=0, candidatoB=0, candidatoC=0, candidatoD=0;
		
		String comando = req.getParameter("voto");
		HttpSession session = req.getSession();
		
		int numero = Integer.parseInt(comando);
		
		switch(numero){
			case 1: 
				candidatoA++;
				break;
			case 2:
				candidatoB++;
				break;
			case 3:
				candidatoC++;
				break;
			case 4:
				candidatoD++;
				break;
		}
		
		String var = 
		"<html>"+
		"<head>"+
		"</head>"+
		"<body>"+
		candidatoA++ + "<br>"+
		candidatoB++ + "<br>"+
		candidatoC++ + "<br>"+
		candidatoD++ + "<br>"+
		"<input type="submit" value="Ok">" +
		"</body>"+
		"</html>";
		
		resp.getWriter().print(var);
		
		if(){
			resp.sendRedirect("http://localhost:8080/aula-4/votos.html");
			
		}
		
		
			
		}
	}

