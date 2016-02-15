/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author alunoufg
 */
public class Cliente {
    public Cliente() {
        this.nome= "sem nome";
        this.pontuacao = 0;
    }
           
    public Cliente(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    private String nome;
    private int pontuacao;
    
}
