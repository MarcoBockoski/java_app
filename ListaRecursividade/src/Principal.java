
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        ListaR l = new ListaR();
        ListaR l2 = new ListaR();
        ListaR l3 = new ListaR();
	Random r = new Random();
        
		
		for(int i=1; i<10; i++){
			l.add(r.nextInt(10));
		}
                l.add(7);
		System.out.println("Lista 1: ");
		l.show(); //imprime na tela os valores guardados nos NodeR
                
                l2.add(1);
                l2.add(1);
                l2.add(3);
                l2.add(3);
                l2.add(4);
                System.out.println("\nLista 2: ");
                l2.show();
                l3.add(1);
                l3.add(1);
                l3.add(2);
                l3.add(1);
                System.out.println("\nLista 3: ");
                l3.show();
		
//		System.out.println("el maior: "+l.maior());
//                System.out.println("sominha: "+ l.soma());
//                System.out.println("qtds de 1: "+ l.qtdIgual(1));
//                System.out.println("showPares:");
//                l.showEven();
//                System.out.println("\nContem o valor 7? "+l.contains(7));
//                System.out.println("Contem o valor 7? "+l.contains2(7));
                
//                System.out.println("\nSoma das posicoes impares: " + l.somaPosImpares(1));
                
//                System.out.println("\n\nDobrando:");
//                l.doubleX();
//                l.show();
                
                
                System.out.println("L1 está crescente?"+l.crescente());
                System.out.println("L2 está crescente?"+l2.crescente());
                System.out.println("L3 está crescente?"+l3.crescente());
                
                System.out.println("\nSoma dos valores pares (lista1): "+l.somaPares());
                System.out.println("\nMenor valor maior que 3 (lista 1): "+l.menorValorMaiorQue(3));
                
                ListaR l4 = new ListaR();
                l4.add(10);
                l4.add(6);
                l4.add(8);
                l4.add(7);
                l4.add(5);
                System.out.println("\nLista 4: ");
                l4.show();
                System.out.println("\nl4 size:"+l4.size());
                

                System.out.println("\nValor de quinto valor de l4:"+l4.getNodeAt(5).getX());
                System.out.println("Valor de terceiro valor de l4:"+l4.getNodeAt(3).getX());
                System.out.println("Valor de primeiro valor de l4:"+l4.getNodeAt(1).getX());
                System.out.println("Valor de segundo valor de l4:"+l4.getNodeAt(2).getX());
                System.out.println("Valor de sétimo valor de l4:"+l4.getNodeAt(7));
                System.out.println("Valor de quarto valor de l4:"+l4.getNodeAt(4).getX());
                
                System.out.println("\nl1 invertido:");
                l.inverte();
                l.show();
                
    }
    
}
