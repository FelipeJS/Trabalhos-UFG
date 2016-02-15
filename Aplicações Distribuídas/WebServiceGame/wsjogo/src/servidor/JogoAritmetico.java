/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author alunoufg
 */
@WebService
public class JogoAritmetico {
    List<Cliente> clientes = new ArrayList();
    public String getPlacar() {
        String resp = "+------- PLACAR ------+\n";
        for (int i = 0; i < clientes.size(); i++) {
            resp += "- " + clientes.get(i).getNome() + " : " + clientes.get(i).getPontuacao() + "\n";
        }
        resp += "+---------------------+\n";
        return resp;
    }

    public String getDesafio() {
        return null;
    }

    public void registrar(Cliente cliente) {
        clientes.add(cliente);
    }

    public int obterStatus() {
        return 0;
    }

    public boolean putResposta(String resposta, Cliente cliente) {
        return false;        
    }

    public void setStatus(int status) {
        
    }

    public void runCommand(String comando) {
        
    }
}
