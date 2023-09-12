public class CasaBinaria {
    private char digito;
    private CasaBinaria prox;

    public CasaBinaria() {
        this.digito = '0';
        this.prox = null;
    }
    
    public void invert(){
        if(digito == '1') digito = '0';
        else digito = '1';
            
    }

    public char getDigito() {
        return digito;
    }

    public CasaBinaria getProx() {
        return prox;
    }

    public void setProx(CasaBinaria prox) {
        this.prox = prox;
    }
}
