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

import br.com.acoesprojetos.dao.InvestimentoDAO;
import br.com.acoesprojetos.model.Acao;
import br.com.acoesprojetos.model.Investimento;
import br.com.acoesprojetos.service.AcaoService;
import br.com.acoesprojetos.service.InvestimentoService;

/**
 * Servlet implementation class InvestimentoServlet
 */
@WebServlet(name = "InvestimentoServlet", urlPatterns = "/temp/investimento")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		InvestimentoService investimentoService = new InvestimentoService();
		AcaoService acaoService = new AcaoService();

		try {
			String opcao = req.getParameter("opcao");
			System.out.println(opcao);

			if (opcao == null || opcao.equals("")) {
				req.getRequestDispatcher("/temp/index.jsp").forward(req, resp);

			} else if (opcao.equals("listar")) {
				Acao acao = acaoService.buscaId(Integer.valueOf(req
						.getParameter("codAcao")));
				req.setAttribute("acao", acao);
				req.setAttribute("investimentos",
						investimentoService.buscaListaPorAcao(acao));
				req.getRequestDispatcher("/temp/investimentos.jsp").forward(
						req, resp);

			} else if (opcao.equals("inserir")) {
				Investimento investimento = new Investimento();
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date data = (Date) formatter.parse(req.getParameter("data"));
				investimento.setData(data);

				investimento.setQuantidade(Integer.parseInt(req
						.getParameter("quantidade")));
				investimento.setValor(Double.parseDouble(req
						.getParameter("valor")));
				investimento.setCustos(Double.parseDouble(req
						.getParameter("custos")));
				investimento.setTotal(Double.parseDouble(req
						.getParameter("total")));

				int codAcao = Integer.parseInt(req.getParameter("acao"));
				investimento.setAcao(acaoService.buscaId(codAcao));

				investimentoService.salvar(investimento);
				req.setAttribute("mensagem", "Usu�rio Cadastrado Com Sucesso");
				req.getRequestDispatcher(
						"/temp/investimento?opcao=listar&codAcao=" + codAcao)
						.forward(req, resp);

			} else if (opcao.equals("editar")) {
				InvestimentoDAO investimentoDAO = new InvestimentoDAO();
				req.setAttribute("p", investimentoDAO.findById(Integer
						.parseInt(req.getParameter("codInvestimento"))));
				req.getRequestDispatcher("/temp/editarInvestimento.jsp")
						.forward(req, resp);

			} else if (opcao.equals("excluir")) {
				int codigo = Integer.parseInt(req
						.getParameter("codInvestimento"));
				investimentoService.excluir(codigo);
				req.setAttribute("mensagem",
						"Investimento Excluido Com Sucesso");
				int codAcao = Integer.parseInt(req.getParameter("acao"));
				req.getRequestDispatcher(
						"/temp/investimento?opcao=listar&codAcao=" + codAcao)
						.forward(req, resp);

			} else if (opcao.equals("carregarEdicao")) {
				Investimento investimento = new Investimento();
				investimento.setId(Integer.parseInt(req.getParameter("id")));
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date data = (Date) formatter.parse(req.getParameter("data"));
				investimento.setData(data);
				investimento.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
				investimento.setValor(Double.parseDouble(req.getParameter("valor")));
				investimento.setCustos(Double.parseDouble(req.getParameter("custos")));
				investimento.setTotal(Double.parseDouble(req.getParameter("total")));

				int codAcao = Integer.parseInt(req.getParameter("codAcao"));
				investimento.setAcao(acaoService.buscaId(codAcao));

				investimentoService.editar(investimento);
				req.setAttribute("mensagem", "Usu�rio Cadastrado Com Sucesso");
				req.getRequestDispatcher("/temp/investimento?opcao=listar")
						.forward(req, resp);

			} else {
				req.getRequestDispatcher("/temp/investimento?opcao=listar")
						.forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("mensagem", "Erro na P�gina");
			req.getRequestDispatcher("/temp/index.jsp").forward(req, resp);
		}
	}

}
