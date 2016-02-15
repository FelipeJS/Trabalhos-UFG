package servidorfightrmi;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorFightRMI {
ArrayList<Cliente> clientes = new ArrayList<>();
    Action acao = new Action();
    String nome;
    int startGame;
    int vida = 100;
    int dano = 0;
    int status = 3;

    public int startGame() {
        return startGame;
    }

    public String getPlacar() throws RemoteException {
        String resp = "+------- PLACAR ------+\n";
        for (Cliente cliente : clientes) {
            resp += "- " + cliente.getNome() + " : " + cliente.getPontuacao() + "\n";
        }
        resp += "+---------------------+\n";
        return resp;
    }

    public void registrar(Cliente cliente) throws RemoteException {
        clientes.add(cliente);
        if (clientes.size() == 1) {
            cliente.notificar(cliente.getNome() + ", voce e o Game Manager! "
                    + "\nDigite /iniciar para iniciar o jogo, "
                    + "/listar para listar os jogadores.");
            cliente.waitCommand();
        } else {
            cliente.notificar(cliente.getNome() + ", aguarde o Game Manager iniciar o jogo!");
        }
    }

    public boolean putResposta(char comando, Cliente cliente) throws RemoteException {
        if(nome == clientes.get(0).getNome()){
            switch (comando) {
            case 'A':
                dano = acao.attack();
                status = acao.status;
                cliente.setPontuacao(cliente.getPontuacao() + dano);
                for (Cliente todos : clientes) {
                    todos.notificar("\n++ O " + cliente.getNome() + " acertou! ++ \n\n" + getPlacar() + " ?");
                }
                break;
            case 'W':
                dano = acao.couterAttack();
                status = acao.status;
                cliente.setPontuacao(cliente.getPontuacao() + dano);
                break;
            default:
                dano = acao.defense();
                status = acao.status;
                cliente.setPontuacao(cliente.getPontuacao() + dano);
                break;
        }
        return true;
    }
        }
        
/*
    if(cliente.getPontuacao() == 100) {
            for (Cliente cliente : clientes) {
            cliente.notificar("\n*** O " + cliente.getNome() + " ganhou! *** \n\n" + getPlacar() + "\n\n ** FIM DE JOGO **");
        }
        startGame = 2;
    }else {
            cliente.setPontuacao(cliente.getPontuacao() - 1);
            for (int i = 0; i < clientes.size(); i++) {
                clientes.get(i).notificar("\n-- O " + cliente.getNome() + " errou! -- \n\n" + getPlacar() + getDesafio() + " ?");
            }
            return false;
    }
*/
public static void main(String[] args) {
        try {
            ServidorFightRMI obj = new ServidorFightRMI();
            Servidor stub = (Servidor) UnicastRemoteObject.exportObject((Remote) obj, 0);

            Registry registry = LocateRegistry.createRegistry(6789);
            registry.bind("Jogo", (Remote) stub);

            System.out.println("Servidor iniciado");
        } catch (RemoteException | AlreadyBoundException e) {
            System.err.println("Server exception: " + e.toString());
        }
    }
}

