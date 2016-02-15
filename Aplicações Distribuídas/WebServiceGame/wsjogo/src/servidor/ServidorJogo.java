/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import javax.xml.ws.Endpoint;

/**
 *
 * @author alunoufg
 */
public class ServidorJogo {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/WebServices/jogo", new JogoAritmetico());
    }
}
