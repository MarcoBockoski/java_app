public class Lista extends Object{
    private Node inicio, fim;
    
    public Lista(){
        inicio = fim = null;
    }

    public Node getInicio() {
        return inicio;
    }

    public Node getFim() {
        return fim;
    }
    
    public void add(int x, int y, int nivel){
        Node novo = new Node(x, y, nivel);
        
        if(!isEmpty()){
            fim.setProx(novo);
            novo.setAnt(fim);
            fim = novo;
        }
        else inicio = fim = novo;
    }
    
    public void add(int x, int y, int nivel, Node pai){
        Node novo = new Node(x, y, nivel, pai);
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
            if(aux.getPai()!=null)sb.append("| pai: (").append(aux.getPai().getX()).append(", ").append(aux.getPai().getY()).append(") ");
            else sb.append("| pai: ").append(aux.getPai()).append("   ");
            if(aux.getNivel()<10)sb.append("| nivel: 0").append(aux.getNivel()).append("    ");
            else sb.append("| nivel: ").append(aux.getNivel()).append("    ");
            sb.append("| Endereco: ").append(aux);
            sb.append("\n");
            aux = aux.getProx();
        }
        return sb.toString();
    }
    
//    public String caminho(){
//        Node aux = fim;
//        StringBuilder sb = new StringBuilder();
//        while(aux!=null){
//            sb.append("ponto: (").append(aux.getX()).append(", ").append(aux.getY()).append(") ");
//            if(aux.getPai()!=null)sb.append("| pai: (").append(aux.getPai().getX()).append(", ").append(aux.getPai().getY()).append(") ");
//            else sb.append("| pai: ").append(aux.getPai());
//            sb.append("\n");
//            aux = aux.getPai();
//        }
//        return sb.toString();
//    }
    
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
    
    //Construção da lista caminho, tem que ser invertido
    public Lista caminho(Node destino){
        Lista res = new Lista();
        Node aux = trazResposta(destino);
        while(aux!=null){
            res.add(aux.getX(), aux.getY(),  aux.getNivel(), aux.getPai());
            aux = aux.getPai();
        }
        res.reverse();
        return res;
    }
    
    //Contrução da segunda metade do caminho bidirecional, pai e nivel pendentes de ajustes
    public Lista caminhoBID(Node encontro){
        Lista res = new Lista();
        Node aux = trazResposta(encontro);
        while(aux!=null){
            res.add(aux.getX(), aux.getY(),  aux.getNivel(), aux.getPai());
            aux = aux.getPai();
        }
        return res;
    }
    
    public void reverse(){
        Node temp = inicio;
        inicio = fim;
        fim = temp;
        Node aux = inicio; 
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
   
//    public Node procuraPai(int x, int y){
//        Node aux = inicio, res = null;
//        while(aux!=null){
//            if(aux.getY()==y&&aux.getX()==x){
//                res=aux;
//                break;
//            }
//            aux = aux.getProx();
//        }
//        return res;
//    }
    
    public boolean isEmpty(){
        return (inicio == null);
    }
    
    
    public boolean isUnique(){
        return (inicio == fim && inicio!=null);
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
    
    public Node deleteLast(){
       if(!isEmpty()){
            Node retirado = fim;
            fim.setProx(null);
            if(isUnique()) inicio = null;
            fim = fim.getAnt();
            return retirado;
       }else{
           return null;
       }
    }
    
    public void setPaternidade(Node pai){
        Node aux = inicio;
        while(aux!=null){
            aux.setPai(pai);
            aux = aux.getProx();
        }
    }
    
    public void setCaminho(int matriz[][], Node destino){
        Node aux = trazResposta(destino);
        while(aux!=null){
            if(matriz[aux.getX()][aux.getY()]==1) matriz[aux.getX()][aux.getY()]=2;
            aux = aux.getPai();
        }
    }
    
    public void copiaLista(Lista modelo){
        Node aux = modelo.getInicio();
        while(aux!=null){
            if(!contains(aux.getX(), aux.getY())) this.add(aux.getX(), aux.getY(), aux.getNivel(), aux.getPai());
            aux = aux.getProx();
        }
    } 
    
    public boolean checaDestino(Node destino){
        Node aux = inicio;
        boolean res = false;
        //System.out.println("Ref: ("+destino.getX()+", "+destino.getY()+")");
        while(aux!=null){
            //System.out.println("Comparando: ("+aux.getX()+", "+aux.getY()+")");
            if(aux.getX()==destino.getX()&&aux.getY()==destino.getY()){
                res = true;
                break;
            }
            aux = aux.getProx();
        }
        return res;
    }
    
    
    public Node trazResposta(Node destino){
        Node res = inicio;
        while(res!=null){
            if(res.getX()==destino.getX()&&res.getY()==destino.getY()) return res;
            res = res.getProx();
        }
        return res;
    }
    
    public Node getNode(int x, int y){
        Node aux = inicio;
        while(aux!=null){
            if(aux.getY()==y&&aux.getX()==x) break;
            aux = aux.getProx();
        }
        return aux;
    }
    
    public Node getNode(int pos){
        Node aux = inicio;
        for(int i = 0; i < pos&&aux!=null; i++){
            aux = aux.getProx();
        }
        return aux;
    }
    
    public int nodePos(int x, int y){
        Node aux = inicio;
        int res = 0;
        while(aux!=null){
            if(aux.getY()==y&&aux.getX()==x) break;
            res++;
            aux = aux.getProx();
        }
        return res;
    }
}
