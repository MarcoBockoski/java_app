public class Node {    // a classe é um ponteiro 
    private int valor;
    private Node prox; //armazena o classe prox, que por fins práticos, é o endereço de memória do próximo nó

    public Node(int v) {
        this.valor = v;
        prox = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int v) {
        valor = v;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node p) {
        prox = p;
    }
}
