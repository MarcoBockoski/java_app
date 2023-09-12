
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        
        ListaEncadeada le = new ListaEncadeada();
        le.insertFirst(0);
        for(int i = 1; i < 11;i++){
            le.add(i);
        }
        
        le.show();
        
        System.out.println(le.contains(0));
       
        System.out.println("\nEfeito do InsertFirst: ");
        le.insertFirst(0);
        le.show();
        System.out.println(le.contains(0));
        
        System.out.println("\nEfeito do DeleteSecond: ");
        le.deleteSecond();
        le.show();
        System.out.println(le.contains(1));
        
        System.out.println("\nEfeito do DeleteLast: ");
        le.deleteLast();
        le.show();
        System.out.println(le.contains(10));
        
//        System.out.println("\nDeleteLast para lista de 2 elementos: ");
//        ListaEncadeada le2 = new ListaEncadeada();
//        le2.add(12);
//        le2.add(43);
//        System.out.println("\nAntes: ");
//        le2.show();
//        le2.deleteLast();
//        System.out.println("\nDepois: ");
//        le2.show();
//        
        System.out.println("\nDeleteLast para lista de 1 elemento: ");
        ListaEncadeada le1 = new ListaEncadeada();
        le1.add(111);
        System.out.println("\nAntes: ");
        le1.show();
        le1.deleteLast();
        System.out.println("\nDepois: ");
        le1.show();

        System.out.println("\nEfeito do DoubleX: ");
        le.doubleX();
        le.show();
        System.out.println(le.contains(11));
        
        System.out.println("\nTestando o maxX com lista de valores randomicos");
        Random r = new Random();
        ListaEncadeada le5 = new ListaEncadeada();
        for(int i = 1; i < 6 ; i++)
        {
            le5.add(r.nextInt(44));
        }
        le5.show();
        System.out.println("\nValor maxX: "+le5.maxX());
       
        System.out.println("\nTestando o método de truncamento da lista:");
        System.out.println("\nAntes: ");
        le.show();
        System.out.println("\nTruncamento na quarta posição: ");
        try{
            le.TruncaEm(4);
        }
        catch(InvalidIndexException iie){
            System.out.println(iie.getMessage());
        }
        System.out.println("\nDepois: ");
        le.show();
        System.out.println("\nTruncamento na -4 posição: ");
        try{
            le.TruncaEm(-4);
        }
        catch(InvalidIndexException iie){
            System.out.println(iie.getMessage());
        }
        System.out.println("\nDepois: ");
        le.show();
//        System.out.println("\nTruncamento na zero posição: ");
//        try{
//            le.TruncaEm(0);
//        }
//        catch(InvalidIndexException iie){
//            System.out.println(iie.getMessage());
//        }
//        System.out.println("\nDepois: ");
//        le.show();
        
        System.out.println("\nTruncamento na sexta posição: ");
        try{
            le.TruncaEm(6);
        }
        catch(InvalidIndexException iie){
            System.out.println(iie.getMessage());
        }
        System.out.println("\nDepois: ");
        le.show();
        
        System.out.println("\nTestando o método reverse:");
        System.out.println("\nAntes: ");
        le.show();
        le.reverse();
        System.out.println("\nDepois: ");
        le.show();
        
        System.out.println("\nTestando o método delete (remoção do 2° elemento):");
        try{
            le.delete(2);
        }catch(InvalidIndexException iie){
            System.out.println(iie.getMessage());
        }
        System.out.println("\nDepois: ");
        le.show();
        
        System.out.println("\nAgora com o elemento -112");
        try{
            le.delete(-112);
        }catch(InvalidIndexException iie){
            System.out.println(iie.getMessage());
        }
        System.out.println("\nDepois: ");
        le.show();
        
        System.out.println("\nAgora com o quarto elemento");
        try{
            le.delete(3);
        }catch(InvalidIndexException iie){
            System.out.println(iie.getMessage());
        }
        System.out.println("\nDepois: ");
        le.show();
        
        
        System.out.println("\nTestando o método reverse com o randomico:");
        System.out.println("\nAntes: ");
        le5.show();
        le5.reverse();
        System.out.println("\nDepois: ");
        le5.show();
    }
    
}
