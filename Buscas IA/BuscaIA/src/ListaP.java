public class ListaP extends Object{
    private NodeP inicio, fim; 
   
   public ListaP(){
        inicio = fim = null;
    }

    public NodeP getInicio() {
        return inicio;
    }

    public NodeP getFim() {
        return fim;
    }
    
    public void add(int x, int y, int custo, int func){
        NodeP novo = new NodeP(x, y, custo, func);
        
        if(!isEmpty()){
            fim.setProx(novo);
            novo.setAnt(fim);
            fim = novo;
        }
        else inicio = fim = novo;
    }
    
    public void add(int x, int y, int custo, int func, NodeP pai){
        NodeP novo = new NodeP(x, y, custo, func, pai);
        if(!isEmpty()){
            fim.setProx(novo);
            novo.setAnt(fim);
            fim = novo;
        }
        else inicio = fim = novo;
    }
    
    public void addFirst(int x, int y, int custo, int func, NodeP pai){
        NodeP novo = new NodeP(x, y, custo, func, pai);
        if(!isEmpty()){
            novo.setProx(inicio);
            inicio.setAnt(novo);
        }else fim = novo;
        inicio = novo;
    }
    
    public void addByCusto(int x, int y, int custo, int func, NodeP pai){
        if(isEmpty()) addFirst(x, y, custo, func, pai);
        else{
            NodeP pos = inicio;
            while(pos.getCusto()<custo){
                pos = pos.getProx();
                if(pos==null) break;
            }
            
            if(pos == inicio) addFirst(x, y, custo, func, pai);
            else{
                if(pos==null) add(x, y, custo, func, pai);
                else{
                    NodeP novo = new NodeP(x, y, custo, func, pai);
                    NodeP aux = pos.getAnt();
                    
                    //variavel novo fica entre aux e pos
                    //definindo novo como sucessor de aux
                    aux.setProx(novo);
                    novo.setAnt(aux);
                    
                    //definindo novo como antecessor de pos
                    
                    pos.setAnt(novo);
                    novo.setProx(pos);
                }
            }
        }
    }
    
    public void addByFunc(int x, int y, int custo, int func, NodeP pai){
        if(isEmpty()) addFirst(x, y, custo, func, pai);
        else{
            NodeP pos = inicio;
            while(pos.getFunc()<func){
                pos = pos.getProx();
                if(pos==null) break;
            }
            
            if(pos == inicio) addFirst(x, y, custo, func, pai);
            else{
                if(pos==null) add(x, y, custo, func, pai);
                else{
                    NodeP novo = new NodeP(x, y, custo, func, pai);
                    NodeP aux = pos.getAnt();
                    
                    //variavel novo fica entre aux e pos
                    //definindo novo como sucessor de aux
                    aux.setProx(novo);
                    novo.setAnt(aux);
                    
                    //definindo novo como antecessor de pos
                    
                    pos.setAnt(novo);
                    novo.setProx(pos);
                }
            }
        }
    }
    
    public boolean isEmpty(){
        return (inicio == null);
    }
    
    
    public boolean isUnique(){
        return (inicio == fim && inicio!=null);
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
    
    public NodeP deleteLast(){
       if(!isEmpty()){
            NodeP retirado = fim;
            fim.setProx(null);
            if(isUnique()) inicio = null;
            fim = fim.getAnt();
            return retirado;
       }else{
           return null;
       }
    }
    
    public String show(){
        NodeP aux = inicio;
        StringBuilder sb = new StringBuilder();
        while(aux!=null){
            sb.append("ponto: (").append(aux.getX()).append(", ").append(aux.getY()).append(") ");
            if(aux.getPai()!=null)sb.append("| pai: (").append(aux.getPai().getX()).append(", ").append(aux.getPai().getY()).append(") ");
            else sb.append("| pai: ").append(aux.getPai()).append("   ");
            if(aux.getCusto()<10)sb.append("| custo: 0").append(aux.getCusto()).append("    ");
            else sb.append("| custo: ").append(aux.getCusto()).append("    ");
            if(aux.getFunc()<10)sb.append("| func: 0").append(aux.getFunc()).append("    ");
            else sb.append("| func: ").append(aux.getFunc()).append("    ");
            
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
    
    public NodeP getNode(int x, int y){
        NodeP aux = inicio;
        while(aux!=null){
            if(aux.getY()==y&&aux.getX()==x) break;
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
    
     //Construção da lista caminho, tem que ser invertido
    public ListaP caminho(NodeP destino){
        ListaP res = new ListaP();
        NodeP aux = trazResposta(destino);
        while(aux!=null){
            res.add(aux.getX(), aux.getY(),  aux.getCusto(), aux.getFunc(), aux.getPai());
            aux = aux.getPai();
        }
        res.reverse();
        return res;
    }
    
     public void reverse(){
        NodeP temp = inicio;
        inicio = fim;
        fim = temp;
        NodeP aux = inicio; 
        aux.setProx(aux.getAnt());
        //aux.setAnt(null);
        aux=aux.getProx();
        while(aux!=fim)
        {
            temp = aux.getAnt();
            aux.setAnt(aux.getProx());
            aux.setProx(temp);
            
            aux=aux.getProx();
        }
        
        aux.setAnt(aux.getProx());
        aux.setProx(null);
    }
    
    
    
    public void copiaLista(ListaP modelo){
        NodeP aux = modelo.getInicio();
        while(aux!=null){
            if(!contains(aux.getX(), aux.getY())) this.add(aux.getX(), aux.getY(), aux.getCusto(),aux.getFunc(), aux.getPai());
            aux = aux.getProx();
        }
    } 
    
    public void setPaternidade(NodeP pai){
        NodeP aux = inicio;
        while(aux!=null){
            aux.setPai(pai);
            aux = aux.getProx();
        }
    }
    
    public void setCaminho(int matriz[][], NodeP destino){
        NodeP aux = trazResposta(destino);
        while(aux!=null){
            if(matriz[aux.getX()][aux.getY()]==1) matriz[aux.getX()][aux.getY()]=2;
            aux = aux.getPai();
        }
    }
    
    //Traz resposta pois o aux presente no varredura não é o mesmo que o da arvore (endereço diferente)
    public NodeP trazResposta(NodeP destino){
        NodeP res = inicio;
        while(res!=null){
            if(res.getX()==destino.getX()&&res.getY()==destino.getY()) return res;
            res = res.getProx();
        }
        return res;
    }
}
