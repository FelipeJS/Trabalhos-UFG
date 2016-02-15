package br.com.acoesprojetos.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acoesprojetos.model.Usuario;
import br.com.acoesprojetos.service.UsuarioService;

@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = "/login/cadastroUsuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			String operacao = req.getParameter("opcao");
			UsuarioService usuarioService = new UsuarioService();
			
			System.out.println("UsuarioServlet Opcao: " + operacao);

			if (operacao.equals("entrar")) {

				String login = req.getParameter("login_usuario");
				String senha = req.getParameter("login_senha");

				if ("".equals(login) || "".equals(senha)) {
					req.setAttribute("mensagem", "Login/Senha Vazios!");
					req.getRequestDispatcher("/login/index.jsp").forward(req,
							resp);
				} else {

					Usuario usuario = new Usuario();
					usuario.setLogin(login);
					usuario.setSenha(senha);
					
					usuario = usuarioService.autenticar(usuario);
					
					if(usuario == null) {
						req.setAttribute("mensagem", "Login/Senha Inválidos!");
						req.getRequestDispatcher("/login/index.jsp")
						.forward(req, resp);
					} else {
						req.getSession().setAttribute("usuario_logado", usuario);
						req.getRequestDispatcher("/temp/index.jsp").forward(req, resp);
					}
				}
				
			} else if (operacao.equals("salvar")) {
				Usuario usuario = new Usuario();
				usuario.setNome(req.getParameter("nome"));
				usuario.setLogin(req.getParameter("login"));
				usuario.setSenha(req.getParameter("senha"));
				usuario.setEmail(req.getParameter("mail"));

				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date inicio = (Date) formatter.parse(req
						.getParameter("nascimento"));
				usuario.setDataNasc(inicio);

				usuarioService.salvar(usuario);
				req.setAttribute("mensagem", "Usuario Cadastrado Com Sucesso");
				req.getRequestDispatcher("/login/index.jsp")
						.forward(req, resp);

			} else if (operacao.equals("sair")) {
				req.getSession().invalidate();
				req.getRequestDispatcher("/login/index.jsp")
				.forward(req, resp);
			}
			
			else {
				req.setAttribute("mensagem", "Erro na Pagina");
				req.getRequestDispatcher("/login/index.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
