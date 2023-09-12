public class ListaEncadeada {
    private Node inicio, fim;
    
    public ListaEncadeada(){
        inicio = fim = null;
    }
    
    public void add(int v){
        Node novo = new Node(v);
        
        if(fim!=null){
            fim.setProx(novo);
            fim = novo;
        }
        else inicio = fim = novo;
    }
    
    public void show(){
        Node aux = inicio;
        while(aux!=null){
            System.out.println(aux.getValor());
            aux = aux.getProx();
        }
    }
    
    public boolean contains(int v){
        Node aux = inicio;
        while(aux!=null){
            if(aux.getValor()==v)return true;
            aux = aux.getProx();
        }
        return false;
    }
    
    public int getFirstInt(){
        return inicio.getValor();
    }
    
    public int getLastInt(){
        return fim.getValor();
    }
    
    public void insertFirst(int v){
        if(inicio != null){
            Node novo = new Node(0);
            novo.setProx(inicio);
            inicio = novo;
        }
    }
    
    public void deleteSecond(){
        if(inicio != null){
            inicio.setProx(inicio.getProx().getProx());
        }
    }
    
    public int nodeCounter(){
        Node aux = inicio;
        int sum = 0;
        while(aux!=null){
            aux = aux.getProx();
            sum++;
        }
        return sum;
    }
    
    public void deleteLast(){
        if(nodeCounter()>1){
            Node aux = inicio;
            for(int i = 1; i < nodeCounter()-1;i++){ //Exige o nodeCounter()-1 decorrente do último endereço que aux deve assumir, o loop deve ser feito até o antepenúltimo que vai ter o getprox referente ao penúltimo, o penúltimo que vai ter seu setprox setado como null
                aux = aux.getProx();
            }
            aux.setProx(null);
            fim = aux;
        }
        else if(nodeCounter() == 1){
            inicio = fim = null;
        }
    }
    
    public void delete(int pos)throws InvalidIndexException{
        if(pos<nodeCounter()&&pos >= 0)
        {
            Node aux = inicio;
            for(int i = 1; i < pos-1;i++){
                aux = aux.getProx();
            }
            aux.setProx(aux.getProx().getProx());
        }
        else{ //tem que gerar o erro quando extrapolar, como receber valores negativos ou fora do escopo da lista
            throw new InvalidIndexException("Valor nao corresponde a posição de um nó");
        }
    }
    
    public void doubleX(){
        Node aux = inicio;
        while(aux!=null){
            aux.setValor(aux.getValor()*2);
            aux = aux.getProx();
        }
    }
    
    public int maxX(){
        Node aux = inicio;
        int greater = aux.getValor();
        aux = inicio.getProx();
        while(aux!=null){
            if(aux.getValor()> greater){
                greater = aux.getValor();
            }
            aux = aux.getProx();
        }
        return greater;
    }
    
    public void TruncaEm(int pos) throws InvalidIndexException{
        if(pos<nodeCounter()&&pos >= 0)
        {
            Node aux = inicio;
            for(int i = 1; i < pos;i++){
                aux = aux.getProx();
            }
            aux.setProx(null);
            fim = aux;
        }else{ //tem que gerar o erro quando extrapolar, como receber valores negativos ou fora do escopo da lista
            throw new InvalidIndexException("Valor nao corresponde a numeração de um nó");
        }
    }
    
    public void reverse(){
        
        Node auxrev = fim;    //Aux Reverse
        Node auxfor;          //Aux Forward
        int for_pos = nodeCounter()-1; //Integer pocionador, correponde ate qual posicao auxfor progride pra trocar o valor do prox do auxrev pra o valor de auxfor sendo o nó logo atrás de auxrev
        
        while(for_pos > 0)
        {
            auxfor = inicio;
            for(int i = 1; i < for_pos;i++){
                auxfor = auxfor.getProx();
            }
            auxrev.setProx(auxfor);
            auxrev = auxrev.getProx();
            for_pos--;
        }
        auxrev.setProx(null);
        inicio = fim;
        fim = auxrev;
    }
}
