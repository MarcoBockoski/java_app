package Code;

public class Jogador {
    private char simbolo;
    private int vitorias;

    public Jogador(char simbolo) {
        this.simbolo = simbolo;
        vitorias = 0;
    }
    
    public void incrementaVitorias(){
        vitorias++;
    }
    
    public void zeraVitorias(){
        vitorias = 0;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
