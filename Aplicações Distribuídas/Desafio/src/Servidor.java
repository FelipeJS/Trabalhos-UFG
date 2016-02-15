
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servidor extends Remote {

    int STATUS_JOGO_ATIVO = 1;
    int STATUS_JOGO_FINALIZADO = 2;

    public String getPlacar() throws RemoteException;

    public String getDesafio() throws RemoteException;

    public void registrar(Cliente cliente) throws RemoteException;

    public int obterStatus() throws RemoteException;

    public boolean putResposta(String resposta, Cliente cliente) throws RemoteException;

    public void setStatus(int status) throws RemoteException;

    public void runCommand(String comando) throws RemoteException;
}
