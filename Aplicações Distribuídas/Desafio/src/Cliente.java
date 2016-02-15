
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cliente extends Remote {
    
    public void notificar(String mensagem) throws RemoteException;
    
    public String getNome() throws RemoteException;
    
    public void play() throws RemoteException;
    
    public void waitCommand() throws RemoteException;
    
    public int getPontuacao() throws RemoteException;
    
    public void setPontuacao(int pontos) throws RemoteException;
}
