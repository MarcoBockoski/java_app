public class ListaPInput {
    private NodeP inicio, fim;
    
    public ListaPInput(){
        inicio = fim = null;
    }

    public NodeP getInicio() {
        return inicio;
    }

    public NodeP getFim() {
        return fim;
    }
    
    public void add(NodeP input){
        NodeP novo = new NodeP(input.getX(), input.getY());
        
        if(!isEmpty()){
            fim.setProx(novo);
            novo.setAnt(fim);
            fim = novo;
        }
        else inicio = fim = novo;
    }
    
    public String show(){
        NodeP aux = inicio;
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
    
    public NodeP getNodeP(int pos){
        NodeP aux = inicio;
        for(int i = 0; i < pos&&aux!=null; i++){
            aux = aux.getProx();
        }
        return aux;
    }
    
    public boolean contains(int x, int y){
        NodeP aux = inicio;
        while(aux!=null){
            if(aux.getY()==y&&aux.getX()==x)return true;
            aux = aux.getProx();
        }
        return false;
    }
    
    public int nodeCounter(){
        NodeP aux = inicio;
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
    
    public NodeP remove(NodeP input){
        NodeP aux = inicio, retirado = null;
        while(aux!=null){
            if(aux.getX()==input.getX()&&aux.getY()==input.getY()){
                retirado = aux;
                if(aux.equals(inicio)) removeFirst();
                else if(aux.equals(fim))deleteLast();
                else{
                    NodeP Ant = aux.getAnt();
                    NodeP Prox = aux.getProx();
                    Ant.setProx(Prox);
                    Prox.setAnt(Ant);
                }
            }
            aux = aux.getProx();
        }
        return retirado;
    }
    
    public void esvaziaLista(){
        while(!isEmpty()){
            removeFirst();
        }
    }
    
    public NodeP deleteLast(){
       if(!isEmpty()){
            NodeP aux = inicio;
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
    
    public NodeP removeFirst(){
        if(!isEmpty()){
            NodeP retirado = inicio;
            inicio.setAnt(null);
            inicio = inicio.getProx();
            return retirado;
        }else{
            return null;
        }
    }
    
    public void copiaLista(ListaPInput modelo){
        NodeP aux = modelo.getInicio();
        while(aux!=null){
            if(!contains(aux.getX(), aux.getY())) this.add(aux);
            aux = aux.getProx();
        }
    } 
    
    
}
