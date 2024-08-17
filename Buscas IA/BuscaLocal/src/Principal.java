
import java.util.Collections;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        
        int n = 5;
        int[][] adj = geraProblema(n);
        printMatriz(adj);
        
        System.out.print("\nSolução Inicial: ");
        Solucao si = solucaoInicial(n);
        si.show();
        si.setCusto(adj);
        System.out.println("\nCusto da Solução Inicial: "+si.getCusto());
        
        System.out.print("\nHillClimbing: ");
        Solucao hc = hillClimbing(si, n, adj);
        hc.show();
        System.out.println("\nCusto: "+hc.getCusto());
        System.out.println("\nGanho (pelo método): "+ganho(si, hc)+"%");
        
        System.out.print("\nHillClimbingAlterado: ");
        Solucao hca = hillClimbingAlterado(si, n, adj, 5);
        hca.show();
        System.out.println("\nCusto: "+hca.getCusto());
        System.out.println("\nGanho (pelo método): "+ganho(si, hca)+"%");
        System.out.println("\n\n");
        double tInit = calcTempInit(n, adj, 20);
        double tFim = 0.01;
        double fr = 0.95;
        System.out.print("\nTêmpera Simulada:");
        Solucao ts = tempera(si, n, adj, tInit, tFim, fr);
        ts.show();
        double ganho = ((double)(si.getCusto()-ts.getCusto())/(double)si.getCusto())* Math.pow(10, 4);
        ganho = Math.floor(ganho);
        ganho = ganho / Math.pow(10, 2);
        System.out.println("\nCusto: "+ts.getCusto());
        System.out.println("\nGanho: "+ganho+"%");
        System.out.println("\nGanho (pelo método): "+ganho(si, ts)+"%");
    }
    
    public static int[][] geraProblema(int n){
        Random r = new Random();
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) res[i][j] = 0;
                else res[i][j] = r.nextInt(5, 26);
            }
        }
        return res;
    }
    
    public static void printMatriz(int[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                if(matriz[i][j]<10) System.out.print("0");
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public static Solucao solucaoInicial(int n){
        Solucao res = new Solucao();
        for(int i = 0; i < n; i++){
            res.getArray().add(i);
        }
        Collections.shuffle(res.getArray());
        
        return res;
    }
    
    public static Solucao hillClimbing(Solucao si, int n, int[][] matriz){
        Solucao atual = si;
        Solucao novo;
        
        while(true){
            novo = sucessoresHC(atual, n, matriz);
            if(novo.getCusto()>=atual.getCusto()) return atual;
            atual = novo;
        }
    }
    
    public static Solucao hillClimbingAlterado(Solucao si, int n, int[][] matriz, int limite){
        Solucao atual = si;
        Solucao novo;
        int t = 1;
        while(true){
            novo = sucessoresHC(atual, n, matriz);
            if(novo.getCusto()>=atual.getCusto()){
                if(t>limite)    return atual;
                else t++;
            }else{
                atual = novo;
                t = 1;
            }
        }
    }
    
    public static Solucao sucessoresHC(Solucao atual, int n, int[][] matriz){
        
        Random r = new Random();
        
        Solucao res = new Solucao();
        res.copyArray(atual.getArray());
        res.setCusto(matriz);
        
        Solucao suc = new Solucao();
        
        int ind = r.nextInt(n);
        int aux;
        
        for(int i = 0; i < n-1; i++){
            if(i!=ind){
                suc.copyArray(atual.getArray());
                aux = suc.getArray().get(i);
                suc.getArray().set(i, suc.getArray().get(ind));
                suc.getArray().set(ind, aux);
                suc.setCusto(matriz);
                
                if(suc.getCusto()<res.getCusto()){
                   
                    res.copyArray(suc.getArray());
                    res.setCusto(matriz);
                      
                }
            }
        }
        
        return res;
    }
    
    public static double calcTempInit(int n, int[][] matriz, int qt){
        int[] v = new int[qt];
        double de = 0.0;
        
        for(int i = 0; i < qt ; i++){
            Solucao s = solucaoInicial(n);
            s.setCusto(matriz);
            v[i] = s.getCusto();
        }
        
        for(int i = 0; i < qt-1 ; i++){
            for(int j = i+1; j < qt; j++){
                de += Math.abs(v[i] - v[j]);
            }
        }
        
        de = de/((qt-1)*(qt-2)/(float)2.0);
        double t = -de/Math.log(0.999);
        
        System.out.println("t = "+t);
        
        return t;
    }
    
    public static Solucao sucessoresTS(Solucao atual, int n, int[][] matriz){
        Random r = new Random();
        int ind1 = r.nextInt(n);
        int ind2 = ind1;
        while(ind1==ind2){
            ind2 = r.nextInt(n);
        }
        
        Solucao suc = new Solucao();
        suc.copyArray(atual.getArray());
        int aux = suc.getArray().get(ind1);
        suc.getArray().set(ind1, suc.getArray().get(ind2));
        suc.getArray().set(ind2, aux);
        suc.setCusto(matriz);
        
        return suc;
    }
    
    public static Solucao tempera(Solucao si, int n, int[][] matriz, double tInit, double tFim, double fr){
        Solucao atual = new Solucao(), melhor = new Solucao(), novo; 
        atual.copyArray(si.getArray());
        melhor.copyArray(si.getArray());
        Random r = new Random();
        double t = tInit;
        
        while(t > tFim){
            novo = sucessoresTS(atual, n, matriz);
            int de = novo.getCusto() - atual.getCusto();
            
            if(de < 0){
                atual.copyArray(novo.getArray());
                atual.setCusto(matriz);
                
                melhor.copyArray(novo.getArray());
                melhor.setCusto(matriz);
            }else{
                int rnd = r.nextInt(2);
                double aux = Math.exp(-de/t);
                if(aux > rnd){
                    atual.copyArray(novo.getArray());
                    atual.setCusto(matriz);
                }
            }
            t=t*fr;
        }
        return melhor;
    }
    
    public static double ganho(Solucao si, Solucao sf){
        double ganho = ((double)(si.getCusto()-sf.getCusto())/(double)si.getCusto())* Math.pow(10, 4);
        ganho = Math.floor(ganho);
        ganho = ganho / Math.pow(10, 2);
        return ganho;
    }
}
