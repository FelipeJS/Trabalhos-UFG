package fight;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Fight {

    ArrayList<ServidorThread> servidores = new ArrayList<ServidorThread>();
    ServerSocket conexaoServidor;
    static int porta = 6789;
    public int startGame = 0;
    static int numeroDaConexao = 0;

    public Fight(int porta) {
        try {
            System.out.println("Esperando conexoes na porta " + porta);
            this.conexaoServidor = new ServerSocket(porta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ServerSocket getConexaoServidor() {
        return conexaoServidor;
    }

    ArrayList<ServidorThread> getServidores() {
        return servidores;
    }

    void setStart(int start) {
        this.startGame = start;
    }

    int getStart() {
        return startGame;
    }

    void Life() throws IOException {
        for (ServidorThread servidor : servidores) {
            servidor.notificar("\n\r\n\t\tLIFE\r\n"
                    + "__________________________________________________________\r\n"
                    + "\t" + servidores.get(0).nome + ":" + servidores.get(0).vida
                    + "\t" + servidores.get(1).nome + ":" + servidores.get(1).vida + "\n\r"
                    + "__________________________________________________________\n\n\r");
        }
    }

    void Ganhador(String nome) throws IOException {
        for (ServidorThread servidor : servidores) {
            servidor.notificar("\n\r\nGANHADOR\r\n" + nome + "\n\n\r");
        }
    }

    void iniciar() {
        for (ServidorThread servidor : servidores) {
            servidor.notificar("\n\rREADY\r\n");
        }
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("ERRO");
            }
            for (ServidorThread servidor : servidores) {
                servidor.notificar(i + "\n\r");
            }
        }
        for (ServidorThread servidor : servidores) {
            servidor.notificar("\n\r\nFIGHT \n\n\r");
        }
    }

    public static void main(String[] args) throws IOException {
        Fight fight = new Fight(porta);
        while (true) {
            if (fight.getStart() == 0) {
                Socket conexao = fight.getConexaoServidor().accept();
                ServidorThread st = new ServidorThread(conexao, fight);
                fight.getServidores().add(st);
                st.start();
            }
        }
    }
}
