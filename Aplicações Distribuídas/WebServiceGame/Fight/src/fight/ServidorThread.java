package fight;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServidorThread extends Thread {

    Fight luta;
    Socket conexao;
    BufferedReader doCliente;
    DataOutputStream paraCliente;
    String nome;
    String comando;
    int vida = 100;
    int dano = 0;
    int status = 3;

    public ServidorThread(Socket conexao, Fight luta) {
        try {
            this.conexao = conexao;
            this.luta = luta;
            doCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            paraCliente = new DataOutputStream(conexao.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void notificar(String mensagem) {
        try {
            paraCliente.writeBytes(mensagem);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void run() {
        try {
            paraCliente.writeBytes("Forneca seu nome: ");
            System.out.println("Conexao numero:" + ++Fight.numeroDaConexao);
            nome = doCliente.readLine();

            while (luta.getStart() == 0 || luta.getStart() == 1) {
                if (luta.servidores.get(0).conexao == conexao) {
                    paraCliente.writeBytes("\r\nINSTRUCOES\r\nA - Ataque" + "\r\nW - Defesa" + "\r\nD - Contra Ataque\r\n"
                            + "O jogo ainda nao comecou. "
                            + "Digite '/INICIAR' para comecar ou "
                            + "'/LISTAR' para listar os jogadores\n\n\r"
                            + "COMANDO: ");

                    comando = doCliente.readLine();

                    switch (comando) {
                        case "/INICIAR":
                            if (luta.getStart() == 1) {
                                luta.iniciar();
                                luta.setStart(2);
                            } else {
                                paraCliente.writeBytes("\r\nAGUARDE O JOGADOR 2 FICAR PRONTO\r\n");
                            }
                            break;
                        case "/LISTAR":
                            paraCliente.writeBytes("\r\nJOGADORES\r\n");
                            ArrayList<ServidorThread> servidores = luta.getServidores();
                            for (ServidorThread servidorThread : servidores) {
                                paraCliente.writeBytes(servidorThread.nome + "\r\n");
                            }
                            break;
                        default:
                            paraCliente.writeBytes("\r\nCOMANDO INVALIDO\r\n\n");
                            break;
                    }

                } else {

                    if (luta.getStart() == 0) {
                        paraCliente.writeBytes("\r\nINSTRUCOES\r\n" + "A - Ataque" + "\r\nW - Defesa" + "\r\nD - Contra Ataque\r\n"
                                + "O jogo ainda nao comecou. "
                                + "Digite '/LISTAR' para listar os jogadores ou '/PRONTO' para aguardar o inicio\n\n\r"
                                + "COMANDO: ");

                        comando = doCliente.readLine();

                        switch (comando) {
                            case "/LISTAR":
                                paraCliente.writeBytes("\r\nJOGADORES\r\n");
                                ArrayList<ServidorThread> servidores = luta.getServidores();
                                for (ServidorThread servidorThread : servidores) {
                                    paraCliente.writeBytes(servidorThread.nome + "\r\n");
                                }
                                break;
                            case "/PRONTO":
                                paraCliente.writeBytes("AGUARDE O JOGADOR 1 INICAR O JOGO\r\n");
                                luta.setStart(1);
                                break;
                            default:
                                paraCliente.writeBytes("\r\nCOMANDO INVALIDO\r\n");
                                break;
                        }
                    } else {
                        break;
                    }
                }
            }

            Action acao = new Action();
            while (luta.getStart() == 2 || luta.getStart() == 1) {

                if (luta.servidores.get(0).vida <= 0) {
                    luta.Ganhador(luta.servidores.get(1).nome);
                    luta.servidores.get(1).conexao.close();
                    luta.servidores.get(0).conexao.close();

                } else if (luta.servidores.get(1).vida <= 0) {
                    luta.Ganhador(luta.servidores.get(0).nome);
                    luta.servidores.get(0).conexao.close();
                    luta.servidores.get(1).conexao.close();
                    
                } else {
                    if (luta.servidores.get(0).conexao == conexao) {

                        comando = doCliente.readLine();
                        switch (comando) {
                            case "A":
                                dano = acao.Attack();
                                status = acao.status;
                                if (luta.servidores.get(1).status == 2) {
                                    luta.servidores.get(1).vida -= dano;
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                } else if (luta.servidores.get(1).status == 4) {
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                } else {
                                    luta.servidores.get(1).vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                }
                                luta.Life();
                                break;
                            case "W":
                                dano = acao.CounterAttack();
                                status = acao.status;
                                if (luta.servidores.get(1).status == 2) {
                                    luta.servidores.get(1).vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                } else if (luta.servidores.get(1).status == 4) {
                                    luta.servidores.get(1).vida -= dano;
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                } else {
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                }
                                luta.Life();
                                break;
                            case "D":
                                dano = acao.Defense();
                                status = acao.status;
                                if (luta.servidores.get(1).status == 2) {
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                } else if (luta.servidores.get(1).status == 4) {
                                    luta.servidores.get(1).vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                } else {
                                    luta.servidores.get(1).vida -= dano;
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                    luta.servidores.get(1).paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                }
                                luta.Life();
                                break;
                        }
                    } else {
                        comando = doCliente.readLine();

                        switch (comando) {
                            case "A":
                                dano = acao.Attack();
                                status = acao.status;
                                if (luta.servidores.get(0).status == 2) {
                                    luta.servidores.get(0).vida -= dano;
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                } else if (luta.servidores.get(0).status == 4) {
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                } else {
                                    luta.servidores.get(0).vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                }
                                luta.Life();
                                break;
                            case "W":
                                dano = acao.CounterAttack();
                                status = acao.status;
                                if (luta.servidores.get(0).status == 2) {
                                    luta.servidores.get(0).vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                } else if (luta.servidores.get(0).status == 4) {
                                    luta.servidores.get(0).vida -= dano;
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                } else {
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                }
                                luta.Life();
                                break;
                            case "D":
                                dano = acao.Defense();
                                status = acao.status;
                                if (luta.servidores.get(0).status == 2) {
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                } else if (luta.servidores.get(0).status == 4) {
                                    luta.servidores.get(0).vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE BEM SUCEDIDO\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nCONTRA-ATACOU VOCE\r\n\n");
                                } else {
                                    luta.servidores.get(0).vida -= dano;
                                    vida -= dano;
                                    paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                    luta.servidores.get(0).paraCliente.writeBytes("\r\nATAQUE EMPATOU\r\n\n");
                                }
                                luta.Life();
                                break;
                        }
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("ERRO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
