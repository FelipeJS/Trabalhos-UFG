
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorImpl implements Servidor {

    ArrayList<Cliente> clientes =
            new ArrayList<Cliente>();
    Desafio desafio = new Desafio();
    int STATUS_JOGO_ATIVO = 1;
    int STATUS_JOGO_FINALIZADO = 2;
    int status = 0;

    public String getPlacar() throws RemoteException {
        String resp = "+------- PLACAR ------+\n";
        for (int i = 0; i < clientes.size(); i++) {
            resp += "- " + clientes.get(i).getNome() + " : " + clientes.get(i).getPontuacao() + "\n";
        }
        resp += "+---------------------+\n";
        return resp;
    }

    public String getDesafio() {
        return desafio.desafio;
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

    public int obterStatus() {
        return status;
    }

    public boolean putResposta(String resposta, Cliente cliente) throws RemoteException {
        if (resposta.equals(desafio.resposta)) {
            desafio = new Desafio();
            cliente.setPontuacao(cliente.getPontuacao()+1);
            for (int i = 0; i < clientes.size(); i++) {
                clientes.get(i).notificar("\n++ O " + cliente.getNome() + " acertou! ++ \n\n" + getPlacar() + getDesafio() + " ?");
            }
            if (cliente.getPontuacao() == 3) {
                for (int i = 0; i < clientes.size(); i++) {
                    clientes.get(i).notificar("\n*** O " + cliente.getNome() + " ganhou! *** \n\n" + getPlacar() + "\n\n ** FIM DE JOGO **");
                    setStatus(STATUS_JOGO_FINALIZADO);
                }
            }
            return true;
        } else {
            cliente.setPontuacao(cliente.getPontuacao()-1);
            for (int i = 0; i < clientes.size(); i++) {
                clientes.get(i).notificar("\n-- O " + cliente.getNome() + " errou! -- \n\n" + getPlacar() + getDesafio() + " ?");
            }
            return false;
        }
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static void main(String[] args) {
        try {
            ServidorImpl obj = new ServidorImpl();
            Servidor stub = (Servidor) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(6789);
            registry.bind("Jogo", stub);

            System.out.println("Servidor iniciado...");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void runCommand(String comando) throws RemoteException {
        if (comando.equals("/iniciar")) {
            setStatus(STATUS_JOGO_ATIVO);
            for (int i = 0; i < clientes.size(); i++) {
                clientes.get(i).play();
            }
        } else if (comando.equals("/listar")) {
            String resp = "+----- JOGADORES -----+\n";
            for (int i = 0; i < clientes.size(); i++) {
                resp += "- " + clientes.get(i).getNome() + "\n";
            }
            resp += "+---------------------+\n";
            clientes.get(0).notificar(resp);
        } else {
            clientes.get(0).notificar("Comando invalido!");
        }
    }
}
