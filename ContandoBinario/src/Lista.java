public class Lista {
    private CasaBinaria menos_sig, mais_sig;

    public Lista() {
        mais_sig = menos_sig = null;
    }

    public CasaBinaria getMenos_sig() {
        return menos_sig;
    }

    public CasaBinaria getMais_sig() {
        return mais_sig;
    }
    
    public CasaBinaria getCasa(int num){
        CasaBinaria aux = menos_sig;
        for(int i = 0; i < num; i++)
            {
                aux = aux.getProx();
        }
        return aux;
    }
    
    public void createNumTam(int tam){
        for(int i = 0; i < tam; i++){
            add();
        }
    }
    
    public int significancia(CasaBinaria digito){
        CasaBinaria aux = menos_sig;
        int res = 0;
        
        while(aux != null)
        {
           if(aux == digito) break;
           res++;
           aux = aux.getProx();
        }
        if(aux == null) res = -9999; 
        return res;
    }
    
    public void add(){
        CasaBinaria nova;
        if(isEmpty()){
            nova = new CasaBinaria();
            mais_sig = nova;
            menos_sig = mais_sig;
        }else{
            nova = new CasaBinaria();
            mais_sig.setProx(nova);
            mais_sig = nova;
        }
    }
    
    public void removeUltimo(){
        CasaBinaria aux = menos_sig;
        if(isEmpty()){
            System.out.println("Não tem como");
        }else if(elementoUnico()){
            mais_sig = menos_sig = null;
        }else{
            for(int i = 0; i < digitoCounter()-1; i++)
            {
                aux.setProx(null);
                aux = mais_sig;
            }
        }
    }
    
    public int digitoCounter(){
        int sum = 0;
        CasaBinaria aux = menos_sig;
        while(aux != null)
        {
           sum++;
           aux = aux.getProx();
        }
        return sum;
    }
    
    public boolean isEmpty(){
        return menos_sig == null;
    }
    
    public boolean elementoUnico(){
        return menos_sig == mais_sig;
    }
    
    public String numero(){
        String res = "";
        CasaBinaria aux = menos_sig;
        while(aux != null)
        {
           res = aux.getDigito() + res;
           aux = aux.getProx();
        }
        return res;
    }
    
    public void cicloConta(int contagem, int casa_significancia){ //Precisa da contagem do número e da casa que se quer modificar conforme a contagem
        if(casa_significancia==0){
            getCasa(casa_significancia).invert();
        }else if(contagem%Math.pow(2, casa_significancia) == 0){
            getCasa(casa_significancia).invert();
        }
    }
    
    public void reverse(){
        
        CasaBinaria auxrev = mais_sig;    //Aux Reverse
        CasaBinaria auxfor;          //Aux Forward
        int for_pos = digitoCounter()-1; //Integer pocionador, correponde ate qual posicao auxfor progride pra trocar o valor do prox do auxrev pra o valor de auxfor sendo o nó logo atrás de auxrev
        
        while(for_pos > 0)
        {
            auxfor = menos_sig;
            for(int i = 1; i < for_pos;i++){
                auxfor = auxfor.getProx();
            }
            auxrev.setProx(auxfor);
            auxrev = auxrev.getProx();
            for_pos--;
        }
        auxrev.setProx(null);
        menos_sig = mais_sig;
        mais_sig = auxrev;
    }
}
