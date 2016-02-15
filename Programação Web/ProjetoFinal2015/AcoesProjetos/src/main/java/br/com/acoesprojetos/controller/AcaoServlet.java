package br.com.acoesprojetos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acoesprojetos.dao.AcaoDAO;
import br.com.acoesprojetos.model.Acao;
import br.com.acoesprojetos.model.Usuario;
import br.com.acoesprojetos.service.AcaoService;

@WebServlet(name = "AcaoServlet", urlPatterns = "/temp/acao")
public class AcaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		AcaoService acaoService = new AcaoService();
		Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuario_logado");

		try {
			String opcao = req.getParameter("opcao");

			if (opcao == null || opcao.equals("")) {
				req.getRequestDispatcher("/temp/acao?opcao=listar").forward(req, resp);
			} else if (opcao.equals("listar")) {
				List<Acao> acoes = new ArrayList<Acao>();
				acoes = this.filtraPorUsuario(acaoService.listar(), usuarioLogado);
				
				req.setAttribute("acoes", acoes);
				req.getRequestDispatcher("/temp/acoes.jsp").forward(req, resp);
				
			} else if (opcao.equals("inserir")) {
				Acao acao = new Acao();
				acao.setNome(req.getParameter("nome"));
				acao.setDescricao(req.getParameter("descricao"));
				acao.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
				acao.setPreco(Double.parseDouble(req.getParameter("valor")));
				acao.setUsuario(usuarioLogado);

				acaoService.salvar(acao);
				req.setAttribute("mensagem", "Usuário Cadastrado Com Sucesso");
				req.getRequestDispatcher("/temp/acao?opcao=listar").forward(
						req, resp);

			} else if (opcao.equals("editar")) {
				AcaoDAO acaoDAO = new AcaoDAO();
				req.setAttribute("p", acaoDAO.findById(Integer.parseInt(req.getParameter("codAcao"))));

				req.getRequestDispatcher("/temp/editarAcao.jsp").forward(req, resp);
			} else if (opcao.equals("excluir")) {
				int codigo = Integer.parseInt(req.getParameter("codAcao"));
				acaoService.excluir(codigo);
				req.setAttribute("mensagem", "Usuário Excluido Com Sucesso");
				req.getRequestDispatcher("/temp/acao?opcao=listar").forward(req, resp);
			} else if (opcao.equals("carregarEdicao")) {
				Acao acao = acaoService.buscaId(Integer.parseInt(req.getParameter("id")));
				acao.setNome(req.getParameter("nome"));
				acao.setDescricao(req.getParameter("descricao"));
				acao.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
				acao.setPreco(Double.parseDouble(req.getParameter("valor")));
				acao.setUsuario(usuarioLogado);

				acaoService.editar(acao);
				req.getRequestDispatcher("/temp/acao?opcao=listar").forward(req, resp);
				
			} else {
				req.setAttribute("mensagem", "Erro na Página");
				req.getRequestDispatcher("/temp/index.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Acao> filtraPorUsuario(List<Acao> list, Usuario usuario) {
		List<Acao> acoesFiltradas = new ArrayList<Acao>();
		Iterator<Acao> it = list.iterator();
		while ( it.hasNext() ) {
			Acao acao = it.next();
			if ( acao.getUsuario().getId() == usuario.getId()) {
				acoesFiltradas.add(acao);
			}
		}
		
		return acoesFiltradas;
	}
	
}