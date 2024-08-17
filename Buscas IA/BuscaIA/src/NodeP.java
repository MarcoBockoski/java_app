public class NodeP {
    private NodeP pai, ant, prox;
    private int x, y, custo, func;

    public NodeP(int x, int y) {
        this.x = x;
        this.y = y;
        custo = 0;
        func = 0;
    }
    
    public NodeP(Node node){
        this.x = node.getX();
        this.y = node.getY();
        custo = 0;
        func = 0;
    }

    public NodeP(int x, int y, int custo, int func) {
        this.x = x;
        this.y = y;
        this.custo = custo;
        this.func = func;
    }
    public NodeP(int x, int y, int custo, int func, NodeP pai) {
        this.x = x;
        this.y = y;
        this.custo = custo;
        this.func = func;
        this.pai = pai;
    }

    public NodeP(int x, int y, NodeP pai) {
        this.x = x;
        this.y = y;
        this.pai = pai;
    }

    public NodeP getPai() {
        return pai;
    }

    public void setPai(NodeP pai) {
        this.pai = pai;
    }

    public NodeP getAnt() {
        return ant;
    }

    public void setAnt(NodeP ant) {
        this.ant = ant;
    }

    public NodeP getProx() {
        return prox;
    }

    public void setProx(NodeP prox) {
        this.prox = prox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getFunc() {
        return func;
    }

    public void setFunc(int func) {
        this.func = func;
    }
    
}
