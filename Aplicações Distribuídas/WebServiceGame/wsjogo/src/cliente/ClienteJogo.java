/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunoufg
 */
public class ClienteJogo {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        JogoAritmeticoService jas = new JogoAritmeticoService();
        JogoAritmetico port = jas.getPort(JogoAritmetico.class);
        System.out.println("Informe seu nome: ");
        Cliente cliente = new Cliente();
        try {
            cliente.setNome(reader.readLine());
            cliente.setPontuacao(0);            
            port.registrar(cliente);
        } catch (IOException ex) {
            Logger.getLogger(ClienteJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(port.getPlacar());
    }
}
