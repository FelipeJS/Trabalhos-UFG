<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="/AcoesProjetos/login/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="/AcoesProjetos/login/css/style.css" />
        <link rel="stylesheet" type="text/css" href="/AcoesProjetos/login/css/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
           
            <header>
                <h1>Faca seu login para comecar</h1>
                
            </header>
            <section>               
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form action="cadastroUsuario" autocomplete="on" method="post"> 
                            
                                <h1>Login</h1> 
                                <p>${mensagem}</p>
                                <p> 
                                    <label for="username" class="uname" data-icon="u" >Email ou username</label>
                                    <input id="username" name="login_usuario"  type="text" placeholder="meuusername ou meumail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p">Senha</label>
                                    <input id="password" name="login_senha" type="password" /> 
                                </p>
                                <p class="keeplogin"> 
                                    <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
                                    <label for="loginkeeping">Continue me conectado</label>
                                </p>
                                <p class="login button"> 
                                    <input type="submit" name="opcao" value="entrar" /> 
                                </p>
                                <p class="change_link">
                                    Não é membro ainda ?
                                    <a href="#toregister" class="to_register">Registre-se</a>
                                </p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form action="cadastroUsuario" method="post" autocomplete="on"> 
                                <h1> Cadastro </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Nome</label>
                                    <input id="usernamesignup" name="nome" required="required" type="text"  />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Seu email</label>
                                    <input id="emailsignup" name="mail" required="required" type="email" /> 
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Data de Nascimento</label>
                                    <input id="usernamesignup" name="nascimento" type="date"  />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Seu username</label>
                                    <input id="usernamesignup" name="login" required="required" type="text"  />
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Sua senha </label>
                                    <input id="passwordsignup" name="senha" required="required" type="password"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Porfavor repita a senha </label>
                                    <input id="passwordsignup_confirm" name="senha_conf" required="required" type="password" />
                                </p>
                                <p class="signin button">
                                     <input name="opcao" value="salvar" type="hidden"/>
                                    <input type="submit" name="salvar"/> 
                                </p>
                                <p class="change_link">  
                                    Já é um membro ?
                                    <a href="#tologin" class="to_register"> Faca seu Login </a>
                                </p>
                            </form>
                        </div>
                        
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>