import java.util.Random;

public class Principal {

    public static void main(String[] args){
        
        boolean ponderado = true;
        if(!ponderado){
        //Criação do Mapa
        int maxy = 7, maxx = 7, count = 0;
        int[][] matriz = new int[maxx][maxy];
        
        //Variavel pra setar randomicamente 2 coordenadas e o nivel (da origem)
        int[] aux =  new int[3]; 
        for(int i = 0; i < maxx;i++){
            for(int j = 0; j < maxy;j++){
                matriz[i][j]=0;
            }
        }
        
//        System.out.println("N° de colunas: "+matriz[0].length);
//        System.out.println("N° de linhas: "+matriz.length);
        

        //setando origem e destinos randomicos (os destinos são distintos entre si)
        Random r = new Random();
        
        Node origem = null;
        aux[0]=r.nextInt(maxx);
        aux[1]=r.nextInt(maxy);
        aux[2]=matriz[aux[0]][aux[1]];
        if(aux[2]==0){
            matriz[aux[0]][aux[1]]=3;
            //Node(int y, int x, int nivel) 
            origem = new Node(aux[0],aux[1],0);
            System.out.println("Origem: ("+origem.getX()+", "+origem.getY()+")");
        }
        
        Node destino1 = null, destino2 = null, destino3 = null;
        while(count < 3){
            aux[0]=r.nextInt(maxx);
            aux[1]=r.nextInt(maxy);
            aux[2]=matriz[aux[0]][aux[1]];
            if(aux[2]==0){
                matriz[aux[0]][aux[1]]=4;
                if(count==0)destino1 = new Node(aux[0],aux[1]);
                if(count==1)destino2 = new Node(aux[0],aux[1]);
                if(count==2)destino3 = new Node(aux[0],aux[1]);
                count++;
            }
        }
        System.out.println("Destino1: ("+destino1.getX()+", "+destino1.getY()+")");
        System.out.println("Destino2: ("+destino2.getX()+", "+destino2.getY()+")");
        System.out.println("Destino3: ("+destino3.getX()+", "+destino3.getY()+")");
        System.out.println();
        
        //Adicionando lista de input como pontos de destinos
        
        ListaInput input = new ListaInput();
        input.add(destino1);
        input.add(destino2);
        input.add(destino3);
        
        //Uma lista de backup para união das respostas
        
        ListaInput backup = new ListaInput();
        backup.copiaLista(input);
        
        
        System.out.println("Antes da busca: ");
        printMatriz(matriz);
        System.out.println();
        
        //Classe que realiza as buscas
        
        Busca b = new Busca();
        
        //Lista de árvore e caminho
        
        Lista arvoreResposta;
        int limite = 5;
        
//        if(b.amplitude(origem, input, matriz) instanceof Lista lista){
//            arvoreResposta = lista;
//            Lista caminhoResposta = caminho(backup, arvoreResposta);
//            resetaVarredura(matriz);
//            System.out.println("Print do caminho final:\n\n"+caminhoResposta.show());
//            System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
//        }else System.out.println(b.amplitude(origem, input, matriz));
        
//        if(b.profundidade(origem, input, matriz) instanceof Lista lista){
//            
//            arvoreResposta = lista;
//            Lista caminhoResposta = caminho(backup, arvoreResposta);
//            resetaVarredura(matriz);
//            System.out.println("Print do caminho final:\n\n"+caminhoResposta.show());
////          System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
//            
//        }else System.out.println(b.amplitude(origem, input, matriz));
        
//        if(b.profundidadeLimitada(origem, input, matriz, limite) instanceof Lista lista){
//            
//            arvoreResposta = lista;
//            Lista caminhoResposta = caminho(backup, arvoreResposta);
//            resetaVarredura(matriz);
//            System.out.println("Print do caminho final:\n\n"+caminhoResposta.show());
////          System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
//            
//        }else System.out.println("Caminho não encontrado");
        
//        if(b.aprofundamentoIterativo(origem, input, matriz, limite) instanceof Lista lista){
//            
//            arvoreResposta = lista;
//            Lista caminhoResposta = caminho(backup, arvoreResposta);
//            resetaVarredura(matriz);
//            System.out.println("Print do caminho final:\n\n"+caminhoResposta.show());
////          System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
//            
//        }else System.out.println("Caminho não encontrado");
        
        if(b.bidirecional(origem, input, matriz) instanceof Lista lista){
            
            arvoreResposta = lista;
            arrumaNivel(arvoreResposta);
            resetaVarredura(matriz);
            System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
            
        }else System.out.println("Caminho não encontrado");
        
        System.out.println("Depois da busca: ");
        printMatriz(matriz);

        }else{
            
            //Criação do Mapa
            int maxy = 7, maxx = 7, count = 0;
            int[][] matriz = new int[maxx][maxy];

            //Variavel pra setar randomicamente 2 coordenadas e o nivel (da origem)
            int[] aux =  new int[3]; 
            for(int i = 0; i < maxx;i++){
                for(int j = 0; j < maxy;j++){
                    matriz[i][j]=0;
                }
            }
            
            Random r = new Random();
        
            NodeP origem = null;
            aux[0]=r.nextInt(maxx);
            aux[1]=r.nextInt(maxy);
            aux[2]=matriz[aux[0]][aux[1]];
            if(aux[2]==0){
                matriz[aux[0]][aux[1]]=3;
                //Node(int y, int x, int nivel) 
                origem = new NodeP(aux[0],aux[1]);
                System.out.println("Origem: ("+origem.getX()+", "+origem.getY()+")");
            }

            NodeP destino1 = null, destino2 = null, destino3 = null;
            while(count < 3){
                aux[0]=r.nextInt(maxx);
                aux[1]=r.nextInt(maxy);
                aux[2]=matriz[aux[0]][aux[1]];
                if(aux[2]==0){
                    matriz[aux[0]][aux[1]]=4;
                    if(count==0)destino1 = new NodeP(aux[0],aux[1]);
                    if(count==1)destino2 = new NodeP(aux[0],aux[1]);
                    if(count==2)destino3 = new NodeP(aux[0],aux[1]);
                    count++;
                }
            }
            System.out.println("Destino1: ("+destino1.getX()+", "+destino1.getY()+")");
            System.out.println("Destino2: ("+destino2.getX()+", "+destino2.getY()+")");
            System.out.println("Destino3: ("+destino3.getX()+", "+destino3.getY()+")");
            System.out.println();

            //Adicionando lista de input como pontos de destinos

            ListaPInput input = new ListaPInput();
            input.add(destino1);
            input.add(destino2);
            input.add(destino3);
            
            System.out.println("Antes da busca: ");
            printMatriz(matriz);
            System.out.println();
        
            //Classe que realiza as buscas
        
            BuscaP bp = new BuscaP();
            
            //Lista de árvore e caminho
        
            ListaP arvoreResposta;
            
            int[][] h = bp.setNextHeuristica(origem, input, matriz);
            
            
//            if(bp.custoUniforme(origem, input, matriz) instanceof ListaP listap){
//            arvoreResposta = listap;
//            resetaVarredura(matriz);
//            System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
//            }else System.out.println("Caminho não encontrado");
//            
//            if(bp.greedy(origem, input, matriz, h) instanceof ListaP listap){
//            arvoreResposta = listap;
//            resetaVarredura(matriz);
//            System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
//            }else System.out.println("Caminho não encontrado");
            
//            if(bp.aEstrela(origem, input, matriz, h) instanceof ListaP listap){
//                arvoreResposta = listap;
//                resetaVarredura(matriz);
//                System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
//            }else System.out.println("Caminho não encontrado");
            
            if(bp.aiaEstrela(origem, input, matriz, h, 0) instanceof ListaP listap){
                arvoreResposta = listap;
                resetaVarredura(matriz);
                System.out.println("Print da arvore final:\n\n"+arvoreResposta.show());
            }else System.out.println("Caminho não encontrado");
////            
//        
            System.out.println("Depois da busca: ");
            printMatriz(matriz);
        }
        
        
}

    public static int diferenca(Node origem, Node destino){
        return (Math.abs(origem.getX()-destino.getX())+Math.abs(origem.getY()-destino.getY())/2)+1;
    }
    
    public static void resetaVarredura(int matriz [][]){
        for(int i = 0; i < matriz.length;i++){
            for(int j = 0; j < matriz[0].length;j++){
                if(matriz[i][j]==1) matriz[i][j]=0;
            }
        }
    }
    
    public static void printMatriz(int[][] matriz){
        for(int i = 0; i < matriz.length;i++){
            for(int j = 0; j < matriz[0].length;j++){
                if(matriz[i][j]<10) System.out.print(" "+matriz[i][j]+" ");
                else System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static Node destinoFinal(ListaInput input, Lista resposta){
        Node aux = resposta.getInicio();
        while(aux!=null){
            //System.out.println("Comparando: ("+aux.getX()+", "+aux.getY()+")");
            for(int i = 0; i < input.nodeCounter();i++){
                //System.out.println("Ref "+(i+1)+": ("+input.getNode(i).getX()+", "+input.getNode(i).getY()+")");
                if(input.contains(aux.getX(), aux.getY())) return aux;
            }
            aux = aux.getProx();
        }
        return aux;
    }
    
    public static Lista caminho(ListaInput input, Lista resposta){
        Node ref = destinoFinal(input, resposta);
        Lista res = new Lista();
        while(ref!=null){
            res.copiaLista(resposta.caminho(ref));
            input.remove(ref);
            ref = destinoFinal(input, resposta);
        }
        return res;
    }
    
    public static void arrumaNivel(Lista resposta){
        Node aux = resposta.getInicio();
        aux.setPai(null);
        aux.setNivel(0);
        aux = aux.getProx();
        while(aux!=null){
            aux.setNivel(aux.getAnt().getNivel()+1);
            aux = aux.getProx();
        }
    }
    
}
