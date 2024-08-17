
import static java.lang.Math.abs;

public class Busca {
    //y - qtds de linhas, tamanho da coluna, valor da coluna
    //x - qtds de colunas, tamanho da linha, valor da linha
    
    public Object amplitude(Node origem, ListaInput destinos, int matriz[][]){
        Lista varredura = new Lista(), arvore = new Lista(), repetidos = new Lista(), filhos;
        int nivel = origem.getNivel();
        Node aux = origem;
        varredura.add( aux.getX(),aux.getY(), nivel);
        arvore.add( aux.getX(), aux.getY(), nivel);
        repetidos.add(aux.getX(), aux.getY(), nivel);
        
        while(!destinos.isEmpty()){
            aux = varredura.removeFirst();
            filhos = setFilhos(aux, repetidos, matriz);
//            System.out.println("Filho list de ponto: ("+aux.getX()+", "+aux.getY()+")");
//            System.out.println(filhos.show());
//            System.out.println();
            
            varredura.copiaLista(filhos);
            arvore.copiaLista(filhos);
            repetidos.copiaLista(filhos);
            
            //pega a arvore inteira
            for(int i = 0; i < destinos.nodeCounter(); i++){
                if(filhos.checaDestino(destinos.getNode(i))){
                    int ni = filhos.getInicio().getNivel();
                    Node novaOrigem = destinos.getNode(i);
                    novaOrigem.setPai(aux);
                    novaOrigem.setNivel(ni);
                    destinos.remove(destinos.getNode(i));

//                  System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                    arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
//                  System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());
                    resetaVarredura(matriz);
                    if(!destinos.isEmpty()){
                        if(amplitude(novaOrigem,destinos, matriz) instanceof Lista lista){
                            arvore.copiaLista(lista);
                            return arvore;
                        }else return "Caminho nao encontrado";
                    }else return arvore;
                }
            }
            
//            System.out.println("Repetidos:");
//            System.out.println(repetidos.show());
//            System.out.println("Varredura:");
//            System.out.println(varredura.show());
            
            for(int i = 0; i < matriz.length;i++){
                for(int j = 0; j < matriz[0].length;j++){
                 System.out.print(matriz[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    public Object profundidade(Node origem, ListaInput destinos, int matriz[][]){
        Lista varredura = new Lista(), arvore = new Lista(), repetidos = new Lista();
        int nivel = origem.getNivel();
        Node aux = origem;
        varredura.add( aux.getX(),aux.getY(), nivel);
        arvore.add( aux.getX(), aux.getY(), nivel);
        repetidos.add(aux.getX(), aux.getY(), nivel);
        
        while(!destinos.isEmpty()){
            Node passo = setFilho(aux, repetidos, matriz);
            
            while(passo!=null){
                if(matriz[passo.getX()][passo.getY()]==0) matriz[passo.getX()][passo.getY()]=1;
                if(!repetidos.contains(passo.getX(), passo.getY())){
                    varredura.add( passo.getX(),passo.getY(), passo.getNivel(), passo.getPai());
                    arvore.add( passo.getX(), passo.getY(), passo.getNivel(), passo.getPai());
                    repetidos.add(passo.getX(), passo.getY(), passo.getNivel(), passo.getPai());
                }
                
//                for(int i = 0; i < matriz.length;i++){
//                    for(int j = 0; j < matriz[0].length;j++){
//                     System.out.print(matriz[i][j]);
//                    }
//                    System.out.println();
//                }
                //System.out.println("Repetidos:");
                //System.out.println(repetidos.show());
                System.out.println("Varredura:");
                System.out.println(varredura.show());
                
                //confere se o passo corresponde a um dos destinos
                for(int i = 0; i < destinos.nodeCounter(); i++){
                    if(passo.getX()==destinos.getNode(i).getX()&&passo.getY()==destinos.getNode(i).getY()){
                        int ni = passo.getNivel();
                        Node novaOrigem = destinos.getNode(i);
                        
                        novaOrigem.setPai(aux);
                        novaOrigem.setNivel(ni);
                        destinos.remove(destinos.getNode(i));

                        System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                        arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
                        System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());
                        resetaVarredura(matriz);

                        if(!destinos.isEmpty()){
                            if(profundidade(novaOrigem,destinos, matriz) instanceof Lista lista){
                                arvore.copiaLista(lista);
                                return arvore;
                            }else return "Caminho nao encontrado";
                        }else return arvore;
                    }
                }
                passo = setFilho(passo, repetidos, matriz);
            }
            aux = varredura.deleteLast();
        }
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    public Object profundidadeLimitada(Node origem, ListaInput destinos, int matriz[][], int limite){
        Lista varredura = new Lista(), arvore = new Lista(), repetidos = new Lista(), filhos;
        Node aux = origem;
        int count = 0;
        varredura.add( aux.getX(),aux.getY(), aux.getNivel());
        arvore.add( aux.getX(), aux.getY(), aux.getNivel());
        repetidos.add(aux.getX(), aux.getY(), aux.getNivel());
        
        //A busca vai ter 4 frontes de busca, correspondentes aos pontos cardiais: Norte, Este, Sul e Oeste
        
        //Todo nó que corresponde a um ponto cardial é pai do seu respectivo ponto cadial e os colaterais que integra:
        //Um nó ao norte, vai ser pai de um nó ao norte, nordeste e noroeste.
        //Um nó ao este, vai ser pai de um nó ao este, nordeste e sudestte.
        
        //A regra de paternidade dos pontos colaterais são eles mesmos, nordeste é pai de nordeste, sudeste é pai de sudeste, assim adiante
        
        //Convenção utilizada: regiao[0] = norte ; regiao[1] = este ; regiao[2]  = sul ; regiao[3] = oeste
        boolean[] regiao = new boolean[4];
        for(int i = 0; i < 4; i++){
            regiao[i] = false;
        }
        
        while(!destinos.isEmpty()||repetidos.nodeCounter()!=range(origem, matriz, limite)){
            
            filhos = setFilhosPL(origem, aux, repetidos, matriz, limite, regiao);
            varredura.copiaLista(filhos);
            arvore.copiaLista(filhos);
            repetidos.copiaLista(filhos);
                
                for(int i = 0; i < matriz.length;i++){
                    for(int j = 0; j < matriz[0].length;j++){
                     System.out.print(matriz[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println();
                //System.out.println("Repetidos:");
                //System.out.println(repetidos.show());
                System.out.println("Varredura:");
                System.out.println(varredura.show());
                
                //confere se o destino esta na lista dos filhos
                for(int i = 0; i < destinos.nodeCounter(); i++){
                    if(filhos.checaDestino(destinos.getNode(i))){
                        int ni = filhos.getInicio().getNivel();
                        Node novaOrigem = destinos.getNode(i);
                        novaOrigem.setPai(aux);
                        novaOrigem.setNivel(ni);
                        destinos.remove(destinos.getNode(i));

                        System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                        arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
                        System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());
                        resetaVarredura(matriz);
                        if(!destinos.isEmpty()){
                            if(profundidadeLimitada(novaOrigem,destinos, matriz, limite+ni) instanceof Lista lista){
                                arvore.copiaLista(lista);
                                return arvore;
                            }else return "Caminho nao encontrado";
                        }else return arvore;
                    }
                }
            aux = varredura.deleteLast();
            if(aux.getX()==origem.getX()&&aux.getY()==origem.getY()){
                if(count==0) System.out.print("norte ");
                if(count==1) System.out.print("este ");
                if(count==2) System.out.print("sul ");
                if(count==3) System.out.print("oeste ");
                System.out.println("totalmente varrido");
                aux = origem;
                varredura.add( aux.getX(),aux.getY(), aux.getNivel());
                regiao[count] = true;
                if(count<3)count++;
                else break;
            }
        }
        
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    public Object aprofundamentoIterativo(Node origem, ListaInput destinos, int matriz[][], int limite){
        Lista varredura = new Lista(), arvore = new Lista(), repetidos = new Lista(), filhos;
        Node aux = origem;
        int count = 0;
        varredura.add( aux.getX(),aux.getY(), aux.getNivel());
        arvore.add( aux.getX(), aux.getY(), aux.getNivel());
        repetidos.add(aux.getX(), aux.getY(), aux.getNivel());
        
        for(int l = 1; l <= limite; l++){
            
            boolean[] regiao = new boolean[4];
            for(int i = 0; i < 4; i++){
                regiao[i] = false;
            }
        
            while(!destinos.isEmpty()||repetidos.nodeCounter()!=range(origem, matriz, l)){

                filhos = setFilhosPL(origem, aux, repetidos, matriz, l, regiao);
                varredura.copiaLista(filhos);
                arvore.copiaLista(filhos);
                repetidos.copiaLista(filhos);

//                    for(int i = 0; i < matriz.length;i++){
//                        for(int j = 0; j < matriz[0].length;j++){
//                         System.out.print(matriz[i][j]+" ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println();
                    //System.out.println("Repetidos:");
                    //System.out.println(repetidos.show());
//                    System.out.println("Varredura:");
//                    System.out.println(varredura.show());

                    //confere se o destino esta na lista dos filhos
                    for(int i = 0; i < destinos.nodeCounter(); i++){
                        if(filhos.checaDestino(destinos.getNode(i))){
                            int ni = filhos.getInicio().getNivel();
                            Node novaOrigem = destinos.getNode(i);
                            novaOrigem.setPai(aux);
                            novaOrigem.setNivel(ni);
                            destinos.remove(destinos.getNode(i));

                            System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                            arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
                            System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());
                            resetaVarredura(matriz);
                            if(!destinos.isEmpty()){
                                if(aprofundamentoIterativo(novaOrigem,destinos, matriz, limite+ni) instanceof Lista lista){
                                    arvore.copiaLista(lista);
                                    return arvore;
                                }else return "Caminho nao encontrado";
                            }else return arvore;
                        }
                    }
                aux = varredura.deleteLast();
                if(aux.getX()==origem.getX()&&aux.getY()==origem.getY()){
                    if(count==0) System.out.print("norte ");
                    if(count==1) System.out.print("este ");
                    if(count==2) System.out.print("sul ");
                    if(count==3) System.out.print("oeste ");
                    System.out.println("totalmente varrido\n");
                    aux = origem;
                    varredura.add( aux.getX(),aux.getY(), aux.getNivel());
                    regiao[count] = true;
                    if(count<3)count++;
                    else break;
                }
            }
            
            System.out.println("Limite:"+l+"\n");
            count = 0;
            repetidos = new Lista();
        }
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    public Object bidirecional(Node origem, ListaInput destinos, int matriz[][]){
        Lista varredura1 = new Lista(), arvore1 = new Lista(), repetidos1 = new Lista(), 
              varredura2 = new Lista(), arvore2 = new Lista(), repetidos2 = new Lista(), filhos = new Lista();
        int nivel = 0;
        Node aux = origem;
        
        varredura1.add( aux.getX(),aux.getY(), nivel);
        arvore1.add( aux.getX(), aux.getY(), nivel);
        repetidos1.add(aux.getX(), aux.getY(), nivel);
        
        varredura2.add( destinos.getNode(0).getX(),destinos.getNode(0).getY(), nivel);
        arvore2.add( destinos.getNode(0).getX(), destinos.getNode(0).getY(), nivel);
        repetidos2.add(destinos.getNode(0).getX(), destinos.getNode(0).getY(), nivel);
        
        while(!destinos.isEmpty()){
            int iteracoes = 2*nivel;
            if(nivel == 0) iteracoes = 1;
            
            for(int i = 0; i < iteracoes; i++){
                aux = varredura1.removeFirst();
                filhos = setFilhos(aux, repetidos1, matriz);
//                System.out.println("Filho list1 de ponto: ("+aux.getX()+", "+aux.getY()+")");
//                System.out.println(filhos.show());
//                System.out.println();

                varredura1.copiaLista(filhos);
                arvore1.copiaLista(filhos);
                repetidos1.copiaLista(filhos);
                
                if(verificaEncontro(repetidos1, repetidos2)) break;
            }
            
            if(nivel==0) aux = destinos.getInicio();
            
            if(!verificaEncontro(repetidos1, repetidos2)){
                for(int i = 0; i < iteracoes; i++){
                    aux = varredura2.removeFirst();
                    filhos = setFilhos(aux, repetidos2, matriz);
//                    System.out.println("Filho list2 de ponto: ("+aux.getX()+", "+aux.getY()+")");
//                    System.out.println(filhos.show());
//                    System.out.println();

                    varredura2.copiaLista(filhos);
                    arvore2.copiaLista(filhos);
                    repetidos2.copiaLista(filhos);

                    if(verificaEncontro(repetidos1, repetidos2)) break;
                }
            }
            
//            System.out.println("Repetidos1:");
//            System.out.println(repetidos1.show());
//            System.out.println("Varredura1:");
//            System.out.println(varredura1.show());
//            System.out.println("Arvore1:");
//            System.out.println(arvore1.show());
            
//            System.out.println("Repetidos2:");
//            System.out.println(repetidos2.show());
//            System.out.println("Varredura2:");
//            System.out.println(varredura2.show());
//            System.out.println("Arvore2:");
//            System.out.println(arvore2.show());
            
            if(verificaEncontro(repetidos1, repetidos2)){
                
                Node novaOrigem = destinos.getInicio();
                Node encontro1 = getComum(repetidos1, repetidos2);
                Node encontro2 = arvore2.getNode(encontro1.getX(), encontro1.getY());
                
                
//                System.out.println("Encontro: "+encontro1.getX()+", "+encontro1.getY()+"\n");
//                System.out.println("\nNivel da busca"+nivel);
//                System.out.println("\nNivel do origem"+origem.getNivel());
                
                destinos.remove(destinos.getNode(0));
                
//                System.out.println("\nFALTANDO APENAS "+destinos.nodeCounter());
//                
                arvore1.setCaminho(matriz, encontro1);
                arvore2.setCaminho(matriz, encontro2);
                
                Lista res = arvore1.caminho(encontro1);
                
                
//                System.out.println("res sem juntar:\n"+res.show());
                
                Lista outraMetade = arvore2.caminhoBID(encontro2);
                outraMetade.removeFirst();
                
//                System.out.println("\noutra metade:\n"+outraMetade.show());
                res.copiaLista(outraMetade);
                
//                System.out.println("\nres junto:\n"+res.show());
                //System.out.println("Inicio da Segunda Metade: "+outraMetade.getInicio().getX()+", "+outraMetade.getInicio().getY()+"\n");
                //System.out.println("Fim da Segunda Metade: "+outraMetade.getFim().getX()+", "+outraMetade.getFim().getY()+"\n");
                
                
                for(int i = 0; i < res.nodeCounter(); i++){
                    
                    if(res.getNode(i)==null){
                        break;
                    }
                    
                    res.getNode(i).setPai(res.getNode(i).getAnt());
                }
                        
                System.out.println("\nO caminho: \n"+res.show());
//                System.out.println("\nNovaOrigem: "+novaOrigem.getX()+", "+novaOrigem.getY()+" | Nivel "+ novaOrigem.getNivel());
                
                resetaVarredura(matriz);
                
                if(!destinos.isEmpty()){
                        if(bidirecional(novaOrigem,destinos, matriz) instanceof Lista lista){
                            res.copiaLista(lista);
                            return res;
                        }else return "Caminho nao encontrado";
                }else return res;
                
            }
            
//            for(int i = 0; i < matriz.length;i++){
//                for(int j = 0; j < matriz[0].length;j++){
//                 System.out.print(matriz[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            
            nivel++;
        }
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    public Lista setFilhos(Node pai, Lista repetidos, int matriz[][]){
        Lista res = new Lista();
        
        //NORTE -x y
        if(pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY())){
                res.add(pai.getX()-1, pai.getY(),  pai.getNivel()+1);
                if(matriz[pai.getX()-1][pai.getY()]==0) matriz[pai.getX()-1][pai.getY()]=1;
            }
        }

        //NORDESTE -x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()+1)){
                res.add(pai.getX()-1, pai.getY()+1,  pai.getNivel()+1);
                if(matriz[pai.getX()-1][pai.getY()+1]==0) matriz[pai.getX()-1][pai.getY()+1]=1;
            }
        } 
        
        //ESTE x +y
        if(pai.getY()+1<matriz[0].length){
            if(!repetidos.contains(pai.getX(), pai.getY()+1)){
                res.add(pai.getX(), pai.getY()+1, pai.getNivel()+1);
                if(matriz[pai.getX()][pai.getY()+1]==0) matriz[pai.getX()][pai.getY()+1]=1;
            }
        }
        
        //SUDESTE +x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()+1)){
                res.add(pai.getX()+1, pai.getY()+1, pai.getNivel()+1);
                if(matriz[pai.getX()+1][pai.getY()+1]==0) matriz[pai.getX()+1][pai.getY()+1]=1;
            }
        }
        
        //SUL +x y
        if(pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY())){
                res.add(pai.getX()+1, pai.getY(), pai.getNivel()+1);
                if(matriz[pai.getX()+1][pai.getY()]==0) matriz[pai.getX()+1][pai.getY()]=1;
            }
        }
        
        //SUDOESTE +x -y
        if(pai.getY()-1>=0&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()-1)){
                res.add(pai.getX()+1, pai.getY()-1, pai.getNivel()+1);
                if(matriz[pai.getX()+1][pai.getY()-1]==0) matriz[pai.getX()+1][pai.getY()-1]=1;
            }
        }
        
        //OESTE x -y
        if(pai.getY()-1>=0){
            if(!repetidos.contains(pai.getX(), pai.getY()-1)){
                res.add(pai.getX(), pai.getY()-1, pai.getNivel()+1);
                if(matriz[pai.getX()][pai.getY()-1]== 0) matriz[pai.getX()][pai.getY()-1]=1;
            }
        }
        
        //NOROESTE -x -y
        if(pai.getY()-1>=0&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()-1)){
                res.add(pai.getX()-1, pai.getY()-1, pai.getNivel()+1);
                if(matriz[pai.getX()-1][pai.getY()-1]==0) matriz[pai.getX()-1][pai.getY()-1]=1;
            }
        }
        res.setPaternidade(pai);
        return res;
    }
    
    //permitir que ele passo somente por 0, no entanto, ele precisa chegar no 4. (muda o bgl da matriz pra 0 ou 4
    public Node setFilho(Node pai, Lista repetidos, int matriz[][]){
        Node res = null;
        
        if(pai!=null){
            if(pai.getX()-1>=0&&!repetidos.contains(pai.getX()-1, pai.getY())&&((matriz[pai.getX()-1][pai.getY()]==0)||(matriz[pai.getX()-1][pai.getY()]==4))){//NORTE -x y
                res = new Node(pai.getX()-1, pai.getY(),  pai.getNivel()+1, pai);
                res.setAnt(pai);
                System.out.println("Norte");
            }else if(pai.getY()+1<matriz[0].length&&!repetidos.contains(pai.getX(), pai.getY()+1)&&((matriz[pai.getX()][pai.getY()+1]==0)||(matriz[pai.getX()][pai.getY()+1]==4))){//ESTE x +y
                res = new Node(pai.getX(), pai.getY()+1,  pai.getNivel()+1, pai);
                res.setAnt(pai);
                System.out.println("Este");
            }else if(pai.getX()+1<matriz.length&&!repetidos.contains(pai.getX()+1, pai.getY())&&((matriz[pai.getX()+1][pai.getY()]==0)||(matriz[pai.getX()+1][pai.getY()]==4))){//SUL +x y
                res = new Node(pai.getX()+1, pai.getY(),  pai.getNivel()+1, pai);
                res.setAnt(pai);
                System.out.println("Sul");
            }else if(pai.getY()-1>=0&&!repetidos.contains(pai.getX(), pai.getY()-1)&&((matriz[pai.getX()][pai.getY()-1]==0)||(matriz[pai.getX()][pai.getY()-1]==4))){//OESTE x -y
                res = new Node(pai.getX(), pai.getY()-1,  pai.getNivel()+1, pai);
                res.setAnt(pai);
                System.out.println("Oeste");
            }else if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0&&!repetidos.contains(pai.getX()-1, pai.getY()+1)&&((matriz[pai.getX()-1][pai.getY()+1]==0)||(matriz[pai.getX()-1][pai.getY()+1]==4))){//NORDESTE -x +y
                res = new Node(pai.getX()-1, pai.getY()+1,  pai.getNivel()+1, pai);
                res.setAnt(pai);
                System.out.println("Nordeste");
            }else if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length&&!repetidos.contains(pai.getX()+1, pai.getY()+1)&&((matriz[pai.getX()+1][pai.getY()+1]==0)||(matriz[pai.getX()+1][pai.getY()+1]==4))){//SUDESTE +x +y
                res = new Node(pai.getX()+1, pai.getY()+1,  pai.getNivel()+1, pai);
                res.setAnt(pai);
                System.out.println("Sudeste");
            }else if(pai.getY()-1>=0&&pai.getX()+1<matriz.length&&!repetidos.contains(pai.getX()+1, pai.getY()-1)&&(((matriz[pai.getX()+1][pai.getY()-1]==0))||(matriz[pai.getX()+1][pai.getY()-1]==4))){//SUDOESTE +x -y
                    res = new Node(pai.getX()+1, pai.getY()-1,  pai.getNivel()+1, pai);
                    res.setAnt(pai);
                    System.out.println("Sudoeste");
            }else if(pai.getY()-1>=0&&pai.getX()-1>=0&&!repetidos.contains(pai.getX()-1, pai.getY()-1)&&((matriz[pai.getX()-1][pai.getY()-1]==0)||(matriz[pai.getX()-1][pai.getY()-1]==4))){//NOROESTE -x -y
                res = new Node(pai.getX()-1, pai.getY()-1,  pai.getNivel()+1, pai);
                res.setAnt(pai);
                System.out.println("Noroeste");
            }
        }
        return res;
    }
    
    public Lista setFilhosPL(Node origem, Node pai, Lista repetidos, int[][] matriz, int limite, boolean regiao[]){
        Lista res = new Lista();
        
        if(regiao[0]==false){ //norte
            
            if(origem.getY()==pai.getY()||origem.getY()>pai.getY()){ //Se é um nó norte ou nó noroeste, gera esse filho
                //NOROESTE -x -y
                if(pai.getY()-1>=0&&pai.getX()-1>=0){
                    if(!repetidos.contains(pai.getX()-1, pai.getY()-1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()-1, pai.getY()-1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()-1][pai.getY()-1]==0) matriz[pai.getX()-1][pai.getY()-1]=1;
                        }
                    }
                }
            }
            
            if(origem.getY()==pai.getY()||origem.getY()<pai.getY()){ //Se é um nó norte ou nordeste, gera esse filho
                //NORDESTE -x +y
                if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0){
                    if(!repetidos.contains(pai.getX()-1, pai.getY()+1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()-1, pai.getY()+1,  pai.getNivel()+1, pai);
                            if(matriz[pai.getX()-1][pai.getY()+1]==0) matriz[pai.getX()-1][pai.getY()+1]=1;
                        }
                    }
                } 
            }
            
            if(origem.getY()==pai.getY()){ //Se é um nó norte, gera esse filho
                //NORTE -x y
                if(pai.getX()-1>=0){
                    if(!repetidos.contains(pai.getX()-1, pai.getY())){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()-1, pai.getY(),  pai.getNivel()+1, pai);
                            if(matriz[pai.getX()-1][pai.getY()]==0) matriz[pai.getX()-1][pai.getY()]=1;
                        }
                    }
                }
            }
            
        }else if(regiao[1]==false&&regiao[0]==true){ //este
            
            if(origem.getX()==pai.getX()||origem.getX()>pai.getX()){ //Se é um nó este ou nordeste, gera esse filho
                //NORDESTE -x +y
                if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0){
                    if(!repetidos.contains(pai.getX()-1, pai.getY()+1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()-1, pai.getY()+1,  pai.getNivel()+1, pai);
                            if(matriz[pai.getX()-1][pai.getY()+1]==0) matriz[pai.getX()-1][pai.getY()+1]=1;
                        }
                    }
                } 
            }
            
            if(origem.getX()==pai.getX()||origem.getX()<pai.getX()){ //Se é um nó este ou sudeste, gera esse filho
                //SUDESTE +x +y
                if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length){
                    if(!repetidos.contains(pai.getX()+1, pai.getY()+1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()+1, pai.getY()+1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()+1][pai.getY()+1]==0) matriz[pai.getX()+1][pai.getY()+1]=1;
                        }
                    }
                }
            }
            
            if(origem.getX()==pai.getX()){ //Se é um nó este, gera esse filho
                //ESTE x +y
                if(pai.getY()+1<matriz[0].length){
                    if(!repetidos.contains(pai.getX(), pai.getY()+1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX(), pai.getY()+1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()][pai.getY()+1]==0) matriz[pai.getX()][pai.getY()+1]=1;
                        }
                    }
                }
            }
            
        }else if(regiao[2]==false&&regiao[0]==true&&regiao[1]==true){ //sul
            
            if(origem.getY()==pai.getY()||origem.getY()<pai.getY()){ //Se é um nó sul ou sudeste, gera esse filho
                //SUDESTE +x +y
                if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length){
                    if(!repetidos.contains(pai.getX()+1, pai.getY()+1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()+1, pai.getY()+1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()+1][pai.getY()+1]==0) matriz[pai.getX()+1][pai.getY()+1]=1;
                        }
                    }
                }
            }
            
            if(origem.getY()==pai.getY()||origem.getY()>pai.getY()){ //Se é um nó sul ou sudoeste, gera esse filho
                //SUDOESTE +x -y
                if(pai.getY()-1>=0&&pai.getX()+1<matriz.length){
                    if(!repetidos.contains(pai.getX()+1, pai.getY()-1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()+1, pai.getY()-1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()+1][pai.getY()-1]==0) matriz[pai.getX()+1][pai.getY()-1]=1;
                        }
                    }
                }
            }
            
            if(origem.getY()==pai.getY()){ //Se é um nó sul, gera esse filho
                //SUL +x y
                if(pai.getX()+1<matriz.length){
                    if(!repetidos.contains(pai.getX()+1, pai.getY())){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()+1, pai.getY(), pai.getNivel()+1, pai);
                            if(matriz[pai.getX()+1][pai.getY()]==0) matriz[pai.getX()+1][pai.getY()]=1;
                        }
                    }
                }
            }
        }else if(regiao[3]==false&&regiao[0]==true&&regiao[1]==true&&regiao[2]==true){
            
            if(origem.getX()==pai.getX()||origem.getX()<pai.getX()){ //Se é um nó oeste ou sudoeste, gera esse filho
                //SUDOESTE +x -y
                if(pai.getY()-1>=0&&pai.getX()+1<matriz.length){
                    if(!repetidos.contains(pai.getX()+1, pai.getY()-1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()+1, pai.getY()-1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()+1][pai.getY()-1]==0) matriz[pai.getX()+1][pai.getY()-1]=1;
                        }
                    }
                }
            }
            
            if(origem.getX()==pai.getX()||origem.getX()>pai.getX()){ //Se é um nó oeste ou nó noroeste, gera esse filho
                //NOROESTE -x -y
                if(pai.getY()-1>=0&&pai.getX()-1>=0){
                    if(!repetidos.contains(pai.getX()-1, pai.getY()-1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX()-1, pai.getY()-1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()-1][pai.getY()-1]==0) matriz[pai.getX()-1][pai.getY()-1]=1;
                        }
                    }
                }
            }
            
            if(origem.getX()==pai.getX()){ //Se é um nó oeste, gera esse filho
                //OESTE x -y
                if(pai.getY()-1>=0){
                    if(!repetidos.contains(pai.getX(), pai.getY()-1)){
                        if(pai.getNivel()+1<=limite){
                            res.add(pai.getX(), pai.getY()-1, pai.getNivel()+1, pai);
                            if(matriz[pai.getX()][pai.getY()-1]== 0) matriz[pai.getX()][pai.getY()-1]=1;
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    public int range(Node origem, int[][] mapa, int limite){
        //diferenca no eixo Y/X da O(rigem)/D(estino)
        int difYO = abs(origem.getY()-0), difYD = abs(origem.getY()-mapa[0].length), difXO = abs(origem.getX()-0), difXD = abs(origem.getY()-mapa.length);
        
        
        //O range limite da busca corresponde a (condições ideais) pow(2*limite+1, 2)
        //Apesar disso, há risco do limite da busca ser limitado pelas dimensões do mapa, portanto...
        //Considera-se o ponto de origem e sua diferença em relação às "paredes do mapa"
        //Se o ponto estiver próximo do 0 ou do valor max (matriz.length), desconta-se linhas ou colunas que a busca é executada
        
        int resX = 2*limite+1, resY = 2*limite+1;
        
        //E já que os pontos x e y nem sempre são iguais, separa-se a relação quadrática em x e y
        //Imagine a situação na qual X não chega aos seus limites, porém Y é 0, assim, 
        // x tem dimensão: 2limite + 1, enquanto y tem dimensão: 2limite+1-limite, ou seja, limite+1
        
        //Assim, o caso mínimo do range é pow(limite+1, 2)
        
        
        if(difYO<limite){
            resY = resY - abs(limite-difYO);
        }else if(difYD<limite){
            resY = resY - abs(limite-difYD);
        }
        
        if(difXO<limite){
            resX = resX - abs(limite-difXO);
        }else if(difXD<limite){
            resX = resX - abs(limite-difXD);
        }
        
        return resX*resY;
    }
    
    public boolean verificaEncontro(Lista origem, Lista destino){
        Node ref = origem.getInicio();
        while(ref!=null){
            for(int i = 0; i < destino.nodeCounter(); i++){
                if(destino.getNode(i).getX()==ref.getX()&&destino.getNode(i).getY()==ref.getY()) return true;
            }
            ref = ref.getProx();
        }
        return false;
    } 
    
    public Node getComum(Lista origem, Lista destino){
        Node ref = origem.getInicio();
        while(ref!=null){
            for(int i = 0; i < destino.nodeCounter(); i++){
                if(destino.getNode(i).getX()==ref.getX()&&destino.getNode(i).getY()==ref.getY()) return ref;
            }
            ref = ref.getProx();
        }
        return null;
    }
    
    public void resetaVarredura(int matriz [][]){
        for(int i = 0; i < matriz.length;i++){
            for(int j = 0; j < matriz[0].length;j++){
                if(matriz[i][j]==1) matriz[i][j]=0;
            }
        }
    }
}
