<% 
  if(request.getSession().getAttribute("usuario_logado") == null ) {
	  response.sendRedirect("/AcoesProjetos/login/index.jsp");
  }
%>
<!--/. NAV TOP  -->
	<nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

<!--                     <li> -->
<!--                         <a href="index.jsp"><i class="fa fa-home"></i> Home</a> -->
<!--                     </li> -->
                    <li>
                        <a href="../temp/acao?opcao=listar"><i class="fa fa-bar-chart-o"></i>Minhas Ações</a>
                    </li>
<!--                     <li> -->
<!--                         <a href="investimento?opcao=listar"><i class="fa fa-bar-chart-o"></i> Investimento</a> -->
<!--                     </li> -->
<!-- 					<li> -->
<!--                         <a href="projetos.jsp?opcao=listar"><i class="fa fa-table"></i> Projetos</a> -->
<!--                     </li> -->
                    <li>
                        <a href="../temp/sobre.jsp"><i class="fa fa-qrcode"></i> Sobre</a>
                    </li>
          
                    <li>
                        <a href="../login/cadastroUsuario?opcao=sair"><i class="fa fa-table"></i> Sair</a>
                    </li>
            </div>

        </nav>