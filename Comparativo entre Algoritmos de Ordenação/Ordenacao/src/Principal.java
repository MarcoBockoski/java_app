import java.util.Random;

public class Principal {
    
    static int trocas = 0;
    static int comparacoes = 0;
    public static void main(String[] args) {
        
        Random r = new Random();
        StopWatch sw = new StopWatch();
        int tam = 16000; 
        
        int vm[] = new int[tam];
        int vc[] = new int [vm.length];


          //randomico
        int ref;
        for(int i = 0; i < vm.length; ){
            ref = r.nextInt(1, vm.length+1);
            if(!contains(vm, ref)){
                vm[i] = ref;
                i++;
            }
        }
////        //ordenado
//        for(int i = 0; i < vm.length; i++){
//            vm[i] = i+1;
//        }
        
//        inverso
//        for(int i = 0; i < vm.length; i++){
//            vm[i] = vm.length-i;
//        }
        
        copiaVetor(vm, vc);
        
        sw.start();
        bubbleSort(vc);
        sw.stop();
        
        copiaVetor(vm, vc);
        bubbleSortC(vc);
        
        System.out.println("\nBubble Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n");
        
        
        copiaVetor(vm, vc);
        resetContadores();
        
        sw.start();
        selectSort(vc);
        sw.stop();
        
        copiaVetor(vm, vc);
        selectSortC(vc);
        
        System.out.println("\nSelect Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n");
        
        copiaVetor(vm, vc);
        resetContadores();
        
        sw.start();
        insertionSort(vc);
        sw.stop();
        
        copiaVetor(vm, vc);
        insertionSortC(vc);
        
        System.out.println("\nInsertion Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n");
        
        
        copiaVetor(vm, vc);
        resetContadores();
        
        sw.start();
        combSort(vc);
        sw.stop();
        
        copiaVetor(vm, vc);
        combSortC(vc);
        
        System.out.println("\nComb Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n");
        
        
        copiaVetor(vm, vc);
        resetContadores();
        
        sw.start();
        shellSort(vc);
        sw.stop();
        
        copiaVetor(vm, vc);
        shellSortC(vc);
        
        System.out.println("\nShell Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n");
        
        
        copiaVetor(vm, vc);
        resetContadores();
        
        sw.start();
        quickSort(vc, 0, vc.length-1);
        sw.stop();
        
        copiaVetor(vm, vc);
        quickSortC(vc, 0, vc.length-1);
        
        System.out.println("\nQuick Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n");
        
        copiaVetor(vm, vc);
        resetContadores();
        
        sw.start();
        quickSortPlus(vc, 0, vc.length-1);
        sw.stop();
        
        copiaVetor(vm, vc);
        quickSortPlusC(vc, 0, vc.length-1);
        
        System.out.println("\nQuick Sort Plus: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n");
        
        
//        resetContadores();
//        int[] v1 = {3, 2, 1, 0};
//        printVetor(v1);
//        sw.start();
//        bubbleSort(v1);
//        System.out.println("Tempo de processamento:");
//        sw.stop();
//        printVetor(v1);
//        System.out.println("Bubble Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]\n\n");
////        
//        resetContadores();
//        int[] v2 = {6, 5, 4, 3, 2, 1, 0};
//        printVetor(v2);
//        sw.start();
//        selectSort(v2);
//        System.out.println("Tempo de processamento:");
//        sw.stop();
//        printVetor(v2);
//        System.out.println("Select Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");
////        

//        int v3[] = {5, 4, 3, 2, 1};
//        int v4[] = new int[5];
//        System.out.println("\n");
//        copiaVetor(v3, v4);
//        printVetor(v3); 
//        sw.start();
//        insertionSort(v4);
//        sw.stop();
//        
//        copiaVetor(v3, v4);
//        insertionSortC(v4);
//        
//        printVetor(v4); 
//        System.out.println("\nInsertion Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");
//        resetContadores();
//        
//        printVetor(v4); 
//        sw.start();
//        insertionSort(v4);
//        sw.stop();
//        
//        insertionSortC(v4);
//        
//        printVetor(v4); 
//        System.out.println("\nInsertion Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");
//        resetContadores();
//        int v3[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int v4[] = new int[9];
//        System.out.println("\n");
//        copiaVetor(v3, v4);
//        printVetor(v3); 
//        sw.start();
//        combSort(v4);
//        sw.stop();
//        
//        copiaVetor(v3, v4);
//        combSortC(v4);
//        
//        printVetor(v4); 
//        System.out.println("\nComb Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");
//        resetContadores();
//        
//        printVetor(v4); 
//        sw.start();
//        combSort(v4);
//        sw.stop();
//        
//        combSortC(v4);
//        
//        printVetor(v4); 
//        System.out.println("\nComb Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");
//        
//        resetContadores();
//        
//        System.out.println("\n");
//        copiaVetor(v3, v4);
//        printVetor(v3); 
//        sw.start();
//        shellSort(v4);
//        sw.stop();
//        
//        copiaVetor(v3, v4);
//        shellSortC(v4);
//        
//        printVetor(v4); 
//        System.out.println("\nShell Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");
//        resetContadores();
//        
//        printVetor(v4); 
//        sw.start();
//        combSort(v4);
//        sw.stop();
//        
//        combSortC(v4);
//        
//        printVetor(v4); 
//        System.out.println("\nShell Sort: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");

//        resetContadores();
//        
//        printVetor(v4); 
//        sw.start();
//        quickSortPlus(v4, 0, v4.length-1);
//        sw.stop();
//        
//        quickSortPlusC(v4, 0 , v4.length-1);
//        
//        printVetor(v4); 
//        System.out.println("\nQuick SortP: [Comparações: "+comparacoes+"| Trocas: "+trocas+"]");
//        

    }
    
    public static void troca(int[] vetor, int x, int y){
        int aux = vetor[x];
        vetor[x] = vetor[y];
        vetor[y] = aux;
    }
    
    public static void printVetor(int vetor[]){
        System.out.print("Vetor: {");
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i]);
            if(i < vetor.length-1)System.out.print(", ");
            else System.out.print("}");
            
            if(i!=0){
                if(i==500) System.out.print("\n");
                if(i==1000) System.out.print("\n");
                if(i==1500) System.out.print("\n");
                if(i==2000) System.out.print("\n");
                if(i==2500) System.out.print("\n");
                if(i==3000) System.out.print("\n");
                if(i==3500) System.out.print("\n");
                if(i==4000) System.out.print("\n");
                if(i==4500) System.out.print("\n");
                if(i==5000) System.out.print("\n");
                if(i==5500) System.out.print("\n");
                if(i==6000) System.out.print("\n");
                if(i==6500) System.out.print("\n");
                if(i==7000) System.out.print("\n");
                if(i==7500) System.out.print("\n");
                if(i==8000) System.out.print("\n");
            }
        }
        System.out.println();
    }
    public static void bubbleSort(int[] vetor){
        for(int j = 1; j < vetor.length; j++){
            for(int i = 0; i < vetor.length-j; i++){
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                }
            }
        }
    }
    
    public static void selectSort(int[] vetor){
        for(int j = 1; j < vetor.length; j++){
            int maior = vetor.length-j;
            for(int i = 0; i < vetor.length-j; i++){
                if(vetor[i] > vetor[maior]) maior = i;
            }
            int aux = vetor[maior];
            vetor[maior] = vetor[vetor.length-j];
            vetor[vetor.length-j] = aux;
        }
    }
    
    public static void insertionSort(int[] vetor){
	for (int i = 1; i < vetor.length; i++){
            int aux = vetor[i];
            int j = i;
			
            while ((j > 0) && (vetor[j-1] > aux)){
                vetor[j] = vetor[j-1];
                j -= 1;
            }
            vetor[j] = aux;
        }
    }
    
    public static void combSort(int[] vetor){
        int gap = vetor.length;
        float cons =  (float)1.3;
        boolean ordenado = false;
        
        while(!ordenado){
            gap = (int)(((float) gap) / cons);
            
            if(gap<=1){
                gap = 1;
                ordenado = true;
            }else if (gap == 9 || gap == 10){
                gap = 11;
            }
            
            for(int i = 0; (i+gap) < vetor.length; i++){
                if(vetor[i]>vetor[i+gap]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+gap];
                    vetor[i+gap] = aux;
                    ordenado = false;
                }
            }
        }
    }
    
    public static void shellSort(int[] vetor){
        int h = 1;
        int n = vetor.length;
        
        while(h < n){
            h = h * 3 + 1;
        }
        
        h = h / 3;
        
        int aux, j;
        
        while(h > 0){
            for(int i = h; i < n; i++){
                aux = vetor[i];
                j = i;
                while(j >= h && vetor[j-h]> aux){
                    vetor[j] = vetor[j-h];
                    j = j - h;
                }
                vetor[j] = aux;
            }
            h = h/2;
        }
    }
    
    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }
    
    private static void quickSortPlus(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarPlus(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }
    
    private static int separarPlus(int[] vetor, int inicio, int fim) {
        int mid = inicio+fim/2;
            
        if (vetor[inicio] > vetor[mid]) {
            int aux = vetor[inicio];
            vetor[inicio] = vetor[mid];
            vetor[mid] = aux;
        }
         
        if (vetor[inicio] > vetor[fim]) {
            int aux = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = aux;
        }
        
        if (vetor[mid] > vetor[fim]) {
            int aux = vetor[mid];
            vetor[mid] = vetor[fim];
            vetor[fim] = aux;
        }
        
        int pivoIndex = mid;
        int pivo = vetor[mid];
        
        int aux1 = vetor[pivoIndex];
        vetor[pivoIndex] = vetor[fim];
        vetor[fim] = aux1;
        int res = inicio;
        
        for(int i = inicio; i < fim; i++){
            if(vetor[i] < pivo){
                int aux2 = vetor[i];
                vetor[i] = vetor[res];
                vetor[res] = aux2;
                res++;
            }
        }
        
        int aux2 = vetor[fim];
        vetor[fim] = vetor[res];
        vetor[res] = aux2;
            
        return res;
    }
    
    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)  i++;
            else if (pivo < vetor[f])  f--;
            else {
               int troca = vetor[i];
               vetor[i] = vetor[f];
               vetor[f] = troca;
               i++;
               f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
    
    public static void bubbleSortC(int[] vetor){
        for(int j = 1; j < vetor.length; j++){
            for(int i = 0; i < vetor.length-j; i++){
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    trocas++;
                }
                comparacoes++;
            }
        }
    }
    
    public static void selectSortC(int[] vetor){
        for(int j = 1; j < vetor.length; j++){
            int maior = vetor.length-j;
            for(int i = 0; i < vetor.length-j; i++){
                if(vetor[i] > vetor[maior]) maior = i;
                comparacoes++;
            }
            int aux = vetor[maior];
            vetor[maior] = vetor[vetor.length-j];
            vetor[vetor.length-j] = aux;
            trocas++;
        }
    }
    
    public static void insertionSortC(int[] vetor){
	for (int i = 1; i < vetor.length; i++){
            int aux = vetor[i];
            int j = i;
		
            
            while ((j > 0) && (vetor[j-1] > aux)){
                comparacoes++;
                vetor[j] = vetor[j-1];
                j -= 1;
                trocas++;
            }
            comparacoes++;
            vetor[j] = aux;
            trocas++;
        }
    }
    
    public static void combSortC(int[] vetor){
        int gap = vetor.length;
        float cons =  (float)1.3;
        boolean ordenado = false;
        
        while(!ordenado){
            gap = (int)(((float) gap) / cons);
            
            if(gap<=1){
                gap = 1;
                ordenado = true;
            }else if (gap == 9 || gap == 10){
                gap = 11;
            }
            
            for(int i = 0; (i+gap) < vetor.length; i++){
                comparacoes++;
                if(vetor[i]>vetor[i+gap]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+gap];
                    vetor[i+gap] = aux;
                    trocas++;
                    ordenado = false;
                }
            }
        }
    }
    
    public static void shellSortC(int[] vetor){
        int h = 1;
        int n = vetor.length;
        
        while(h < n){
            h = h * 3 + 1;
        }
        
        h = h / 3;
        int aux, j;
        
        while(h > 0){
            for(int i = h; i < n; i++){
                aux = vetor[i];
                j = i;
                while(j >= h && vetor[j-h]> aux){
                    comparacoes++;
                    vetor[j] = vetor[j-h];
                    j = j - h;
                    trocas++;
                }
                comparacoes++;
                vetor[j] = aux;
                trocas++;
            }
            h = h/2;
        }
    }
    
    private static void quickSortC(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarC(vetor, inicio, fim);
            quickSortC(vetor, inicio, posicaoPivo - 1);
            quickSortC(vetor, posicaoPivo + 1, fim);
        }
    }
    
    private static int separarC(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo){
                comparacoes++;
                i++;
            }
            else if (pivo < vetor[f]){
                comparacoes++;
                f--;
            }
            else {
               int troca = vetor[i];
               vetor[i] = vetor[f];
               vetor[f] = troca;
               trocas++;
               i++;
               f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        trocas++;
        return f;
    }
    
    private static void quickSortPlusC(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarPlusC(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }
    
    private static int separarPlusC(int[] vetor, int inicio, int fim) {
        int mid = inicio+fim/2;
            
        if (vetor[inicio] > vetor[mid]) {
            int aux = vetor[inicio];
            vetor[inicio] = vetor[mid];
            vetor[mid] = aux;
            trocas++;
        }
        comparacoes++;
         
        if (vetor[inicio] > vetor[fim]) {
            int aux = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = aux;
            trocas++;
        }
        comparacoes++;
        
        if (vetor[mid] > vetor[fim]) {
            int aux = vetor[mid];
            vetor[mid] = vetor[fim];
            vetor[fim] = aux;
            trocas++;
        }
        comparacoes++;
        
        int pivoIndex = mid;
        int pivo = vetor[mid];
        
        int aux1 = vetor[pivoIndex];
        vetor[pivoIndex] = vetor[fim];
        vetor[fim] = aux1;
        trocas++;
        int res = inicio;
        
        for(int i = inicio; i < fim; i++){
            comparacoes++;
            if(vetor[i] < pivo){
                int aux2 = vetor[i];
                vetor[i] = vetor[res];
                vetor[res] = aux2;
                trocas++;
                res++;
            }
        }
        
        int aux2 = vetor[fim];
        vetor[fim] = vetor[res];
        vetor[res] = aux2;
        trocas++;
            
        return res;
    }
    
    public static void resetContadores(){
        comparacoes = 0;
        trocas  = 0;
    }
    
    public static void copiaVetor(int[] modelo, int[] copiado){
        if(modelo.length!=copiado.length){
            System.out.println("Método não executável para vetores de tamanhos diferentes");
        }else{
            for(int i = 0; i < modelo.length; i++){
                copiado[i] = modelo[i];
            }
        }
    }
    
    public static boolean contains(int[] vetor, int valor){
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == valor) return true;
        }
        return false;
    }
    
}
