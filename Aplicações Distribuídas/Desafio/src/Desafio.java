
public class Desafio {

    public String desafio, resposta;

    public Desafio() {
        int operando1 = (int) (1000 * Math.random());
        StringBuffer sb = new StringBuffer();
        sb.append(operando1);
        sb.append("+");
        int operando2 = (int) (1000 * Math.random());
        sb.append(operando2);
        int resultado = operando1 + operando2;
        this.desafio = new String(sb);
        this.resposta = new String("" + resultado);
    }

    public String imprimir() {
        return desafio;
    }
}
