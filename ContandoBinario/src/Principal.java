public class Principal {

    public static void main(String[] args) {
        Lista bin = new Lista();
       
        bin.createNumTam(5);
        //bin.reverse();
        
        System.out.println("resto de 0 divido por 4: "+ 0%4);
        System.out.println("resto de 1 divido por 4: "+ 1%4);
        System.out.println("resto de 5 divido por 4: "+ 5%4);
        
        contaBinario(bin);
        
    }
    
    public static void contaBinario(Lista l){
        for(int i = 1; i < Math.pow(2, l.digitoCounter()+1); i++){
            for(int j = 0; j < l.digitoCounter(); j++){
                l.cicloConta(i, j);
            }
            
//           Método manual para números de 4 casas decimais, interessante ter aqui pra enteder o raciocínio de cicloConta();            
//           l.getCasa(0).invert();
//           if(i%2 == 0){
//               l.getCasa(1).invert();
//           }
//           if(i%4 == 0){
//               l.getCasa(2).invert();
//           }
//           if(i%8 == 0){
//               l.getCasa(3).invert();
//           }
           System.out.println(l.numero());
       }
    }
}
