public class Node {
    private Node pai, ant, prox;
    private int x, y, nivel;
    public Node(int x, int y, int nivel) {
        this.x = x;
        this.y = y;
        this.nivel = nivel;
        pai = ant = prox = null;
    }
    
    public Node(int x, int y, int nivel, Node pai) {
        this.x = x;
        this.y = y;
        this.nivel = nivel;
        this.pai = pai;
        ant = prox = null;
    }
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        pai = ant = prox = null;
    }
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Node getAnt() {
        return ant;
    }

    public void setAnt(Node ant){
        this.ant = ant;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }
}
