public class ListaInput {
    private Node inicio, fim;
    
    public ListaInput(){
        inicio = fim = null;
    }

    public Node getInicio() {
        return inicio;
    }

    public Node getFim() {
        return fim;
    }
    
    public void add(Node input){
        Node novo = new Node(input.getX(), input.getY());
        
        if(!isEmpty()){
            fim.setProx(novo);
            novo.setAnt(fim);
            fim = novo;
        }
        else inicio = fim = novo;
    }
    
    public String show(){
        Node aux = inicio;
        StringBuilder sb = new StringBuilder();
        while(aux!=null){
            sb.append("ponto: (").append(aux.getX()).append(", ").append(aux.getY()).append(") ");
            if(aux.getAnt()!=null)sb.append("| ant: (").append(aux.getAnt().getX()).append(", ").append(aux.getAnt().getY()).append(") ");
            else sb.append("| ant: ").append(aux.getAnt()).append("     ");
            if(aux.getProx()!=null)sb.append("| prox: (").append(aux.getProx().getX()).append(", ").append(aux.getProx().getY()).append(") ");
            else sb.append("| prox: ").append(aux.getProx()).append(" ");
            sb.append("| Endereco: ").append(aux);
            sb.append("\n");
            aux = aux.getProx();
        }
        return sb.toString();
    }
    
    public Node getNode(int pos){
        Node aux = inicio;
        for(int i = 0; i < pos&&aux!=null; i++){
            aux = aux.getProx();
        }
        return aux;
    }
    
    public boolean contains(int x, int y){
        Node aux = inicio;
        while(aux!=null){
            if(aux.getY()==y&&aux.getX()==x)return true;
            aux = aux.getProx();
        }
        return false;
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
    
    public boolean isEmpty(){
        return (inicio == null);
    }
    
    public Node remove(Node input){
        Node aux = inicio, retirado = null;
        while(aux!=null){
            if(aux.getX()==input.getX()&&aux.getY()==input.getY()){
                retirado = aux;
                if(aux.equals(inicio)) removeFirst();
                else if(aux.equals(fim))deleteLast();
                else{
                    Node Ant = aux.getAnt();
                    Node Prox = aux.getProx();
                    Ant.setProx(Prox);
                    Prox.setAnt(Ant);
                }
            }
            aux = aux.getProx();
        }
        return retirado;
    }
    
    public Node deleteLast(){
       if(!isEmpty()){
            Node aux = inicio;
            while(aux!=fim){
                aux = aux.getProx();
            }
            fim = fim.getAnt();
            fim.setProx(null);
            return aux;
       }else{
           return null;
       }
    }
    
    public Node removeFirst(){
        if(!isEmpty()){
            Node retirado = inicio;
            inicio.setAnt(null);
            inicio = inicio.getProx();
            return retirado;
        }else{
            return null;
        }
    }
    
    public void copiaLista(ListaInput modelo){
        Node aux = modelo.getInicio();
        while(aux!=null){
            if(!contains(aux.getX(), aux.getY())) this.add(aux);
            aux = aux.getProx();
        }
    } 
}
