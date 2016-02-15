
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ClienteImpl implements Cliente {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Registry registry;
    static Servidor servidor;
    int pontuacao = 0;
    String nome;

    static {
        try {
            registry = LocateRegistry.getRegistry("localhost", 6789);
            servidor = (Servidor) registry.lookup("Jogo");

        } catch (RemoteException ex) {
            System.err.println("Nao foi possivel conectar ao servidor. Servidor esta ativo?");
            System.err.println(ex);
            System.exit(0);
        } catch (NotBoundException ex) {
            System.err.println("Nao foi possivel encontrar o registro. Variavel esta correta?");
            System.err.println(ex);
            System.exit(0);
        }
    }

    public void registrar(Cliente cliente) throws RemoteException {
        servidor.registrar(cliente);
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Informe seu nome: ");
        ClienteImpl cliente = new ClienteImpl();
        cliente.nome = reader.readLine();
        Cliente stub = (Cliente) UnicastRemoteObject.exportObject(cliente, 0);
        Random gerador = new Random();
        Registry registry = LocateRegistry.createRegistry(gerador.nextInt(1000) + 6000);
        registry.bind("Cliente", stub);
        cliente.registrar(cliente);
    }

    @Override
    public void notificar(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }

    @Override
    public String getNome() throws RemoteException {
        return nome;
    }

    @Override
    public void play() throws RemoteException {
        new Thread() {
            @Override
            public void run() {
                try {
                    String resposta;
                    System.out.println("O jogo foi iniciado!");
                    System.out.println(servidor.getDesafio() + " ?");
                    while (servidor.obterStatus() == Servidor.STATUS_JOGO_ATIVO) {
                        try {
                            resposta = reader.readLine();
                            servidor.putResposta(resposta, ClienteImpl.this);
                        } catch (IOException ex) {}
                    }
                } catch (Exception ex) {}
            }
        }.start();

    }

    @Override
    public void waitCommand() throws RemoteException {
        String comando;
        try {
            while (true) {
                comando = reader.readLine();
                servidor.runCommand(comando);
                if (comando.equals("/iniciar")) {
                    break;
                }
            }
        } catch (Exception ex) {
        }
    }

    @Override
    public int getPontuacao() throws RemoteException {
        return pontuacao;
    }

    @Override
    public void setPontuacao(int pontos) throws RemoteException {
        this.pontuacao = pontos;
    }
    
}
