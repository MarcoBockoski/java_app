public class Principal {

    public static void main(String[] args) {
       String palavra = "abc";
       gerarAnagramas("", palavra);

        //Teste funções de Strings
        System.out.println();
        String teste1 = "abc";
        String teste2 = teste1.substring(0, 1); //printa do 0 ao 5
        String teste3 = teste1.substring(2); //printa do 9 até o fim
        
        System.out.println(teste1);
        System.out.println(teste2);
        System.out.println(teste3);
    }
    
    public static void gerarAnagramas(String prefixo, String sufixo) {
        
        if (sufixo.length() == 0) {
            System.out.println("Finalzão = "+prefixo+"\n");
        } else {
            for (int i = 0; i < sufixo.length(); i++) {
                System.out.println("loop = " + i);
                String novaPrefixo = prefixo + sufixo.charAt(i);
                System.out.println("prefixo = " + novaPrefixo);
                String novoSufixo = sufixo.substring(0, i) + sufixo.substring(i + 1);
//                System.out.println("sufixoSub2par = "+ sufixo.substring(0, i));
//                System.out.println("sufixoSub1par = "+ sufixo.substring(i + 1));
                System.out.println("sufixo = "+ novoSufixo+"\n");
                gerarAnagramas(novaPrefixo, novoSufixo);
            }
        }
    }
}
