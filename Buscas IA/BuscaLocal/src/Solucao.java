import java.util.ArrayList;

public class Solucao {
    private ArrayList<Integer> array = new ArrayList<Integer>();
    private int custo;

    public Solucao() {
        custo = 0;
    }
    
    public ArrayList<Integer> getArray() {
        return array;
    }

    public void copyArray(ArrayList<Integer> array) {
        this.array.clear();
        custo = 0;
        for(int i = 0; i < array.size(); i++){
            this.array.add(array.get(i));
        }
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int[][] matriz) { //avalia o vetor já tá nele em forma de array e o tamanho do problema corresponde ao size
        for(int i = 0; i < array.size()-1; i++){
            custo += matriz[getArray().get(i)][getArray().get(i+1)];
        }
        custo += matriz[getArray().get(array.size()-1)][getArray().get(0)];
    }
    
    public void show(){
        for(int i = 0; i < array.size(); i++){
            if(array.get(i)<10) System.out.print(" ");
            System.out.print(array.get(i)+" ");
        }
    }
    
     public String showSolucao(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.size(); i++){
            if(array.get(i)<10) sb.append(" ");
            sb.append(array.get(i)).append(" ");
        }
        return sb.toString();
    }
    
}
