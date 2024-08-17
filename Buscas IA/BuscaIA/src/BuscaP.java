public class BuscaP {
    
    public Object custoUniforme(NodeP origem, ListaPInput destinos, int matriz[][]){ //Func = Custo
        ListaP varredura = new ListaP(), arvore = new ListaP(), repetidos = new ListaP(), filhos;
        
        //System.out.println("origem"+origem.getX()+", "+origem.getY());
        
        NodeP aux = origem;
        varredura.add( aux.getX(),aux.getY(), aux.getCusto(), aux.getFunc());
        arvore.add( aux.getX(), aux.getY(), aux.getCusto(), aux.getFunc());
        repetidos.add(aux.getX(), aux.getY(), aux.getCusto(), aux.getFunc());
        
        while(!destinos.isEmpty()){
            aux = varredura.removeFirst();
            
            for(int i = 0; i < destinos.nodeCounter(); i++){
                if(aux.getX()==destinos.getNodeP(i).getX()&&aux.getY()==destinos.getNodeP(i).getY()){
                    
                    ListaP res = new ListaP();
                    NodeP novaOrigem = destinos.getNodeP(i);
                    novaOrigem.setPai(aux);
                    novaOrigem.setCusto(aux.getCusto());
                    novaOrigem.setFunc(aux.getFunc());
                    destinos.remove(destinos.getNodeP(i));

                    System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                    arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
                    System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());
                   
                    res = arvore.caminho(arvore.trazResposta(novaOrigem));
                    resetaVarredura(matriz);
                    if(!destinos.isEmpty()){
                        if(custoUniforme(novaOrigem,destinos, matriz) instanceof ListaP listap){
                            res.copiaLista(listap);
                            return res;
                        }else return "Caminho nao encontrado";
                    }else return res;
                }
            }
            
            filhos = setFilhos(aux, repetidos, matriz);
            arvore.copiaLista(filhos);
            repetidos.copiaLista(filhos);
            
            for(int i = 0; i < filhos.nodeCounter(); i++){
                varredura.addByCusto(filhos.getNodeP(i).getX(), filhos.getNodeP(i).getY(), filhos.getNodeP(i).getCusto(), filhos.getNodeP(i).getFunc(), filhos.getNodeP(i).getPai());
            }
            
//            System.out.println("Varredura:");
//            System.out.println(varredura.show());
            
//            for(int i = 0; i < matriz.length;i++){
//                for(int j = 0; j < matriz[0].length;j++){
//                 System.out.print(matriz[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    public Object greedy(NodeP origem, ListaPInput destinos, int matriz[][], int heuristica[][]){ //Func = Heuristica
        ListaP varredura = new ListaP(), arvore = new ListaP(), repetidos = new ListaP(), filhos;
        
        //System.out.println("origem"+origem.getX()+", "+origem.getY());
        
        NodeP aux = origem;
        varredura.add( aux.getX(),aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]);
        arvore.add( aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]);
        repetidos.add(aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]);
        
        while(!destinos.isEmpty()){
            aux = varredura.removeFirst();
            
            for(int i = 0; i < destinos.nodeCounter(); i++){
                if(aux.getX()==destinos.getNodeP(i).getX()&&aux.getY()==destinos.getNodeP(i).getY()){
                    
                    ListaP res;
                    NodeP novaOrigem = destinos.getNodeP(i);
                    novaOrigem.setPai(aux);
                    novaOrigem.setCusto(aux.getCusto());
                    novaOrigem.setFunc(aux.getFunc());
                    destinos.remove(destinos.getNodeP(i));

                    System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                    arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
                    System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());
                    
                    res = arvore.caminho(arvore.trazResposta(novaOrigem));
                    resetaVarredura(matriz);
                    if(!destinos.isEmpty()){
                        int[][] novaHeuristica = setNextHeuristica(origem, destinos, matriz);
                        if(greedy(novaOrigem,destinos, matriz, novaHeuristica) instanceof ListaP listap){
                            res.copiaLista(listap);
                            return res;
                        }else return "Caminho nao encontrado";
                    }else return res;
                }
            }
            
            filhos = setFilhos(aux, repetidos, matriz, heuristica);
            arvore.copiaLista(filhos);
            repetidos.copiaLista(filhos);
            
            for(int i = 0; i < filhos.nodeCounter(); i++){
                varredura.addByFunc(filhos.getNodeP(i).getX(), filhos.getNodeP(i).getY(), filhos.getNodeP(i).getCusto(), filhos.getNodeP(i).getFunc(), filhos.getNodeP(i).getPai());
            }
            
//            System.out.println("Varredura:");
//            System.out.println(varredura.show());
            
//            for(int i = 0; i < matriz.length;i++){
//                for(int j = 0; j < matriz[0].length;j++){
//                 System.out.print(matriz[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    public Object aEstrela(NodeP origem, ListaPInput destinos, int matriz[][], int heuristica[][]){ //Func = Heuristica + Custo
        ListaP varredura = new ListaP(), arvore = new ListaP(), repetidos = new ListaP(), filhos;
        
        //System.out.println("origem"+origem.getX()+", "+origem.getY());
        
        NodeP aux = origem;
        varredura.add( aux.getX(),aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
        arvore.add( aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
        repetidos.add(aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
        
        while(!destinos.isEmpty()){
            aux = varredura.removeFirst();
            
            for(int i = 0; i < destinos.nodeCounter(); i++){
                if(aux.getX()==destinos.getNodeP(i).getX()&&aux.getY()==destinos.getNodeP(i).getY()){
                    
                    ListaP res;
                    NodeP novaOrigem = destinos.getNodeP(i);
                    novaOrigem.setPai(aux);
                    novaOrigem.setCusto(aux.getCusto());
                    novaOrigem.setFunc(aux.getFunc());
                    destinos.remove(destinos.getNodeP(i));

                    System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                    arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
                    System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());
                    
                    res = arvore.caminho(arvore.trazResposta(novaOrigem));
                    resetaVarredura(matriz);
                    if(!destinos.isEmpty()){
                        int[][] novaHeuristica = setNextHeuristica(origem, destinos, matriz);
                        if(aEstrela(novaOrigem,destinos, matriz, novaHeuristica) instanceof ListaP listap){
                            res.copiaLista(listap);
                            return res;
                        }else return "Caminho nao encontrado";
                    }else return res;
                }
            }
            
            filhos = setFilhosA(aux, repetidos, matriz, heuristica);
            arvore.copiaLista(filhos);
            repetidos.copiaLista(filhos);
            
            for(int i = 0; i < filhos.nodeCounter(); i++){
                varredura.addByFunc(filhos.getNodeP(i).getX(), filhos.getNodeP(i).getY(), filhos.getNodeP(i).getCusto(), filhos.getNodeP(i).getFunc(), filhos.getNodeP(i).getPai());
            }
            
//            System.out.println("Varredura:");
//            System.out.println(varredura.show());
            
//            for(int i = 0; i < matriz.length;i++){
//                for(int j = 0; j < matriz[0].length;j++){
//                 System.out.print(matriz[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    
    public Object aiaEstrela(NodeP origem, ListaPInput destinos, int matriz[][], int heuristica[][], int limite){ //Func = Heuristica + Custo
        ListaP varredura = new ListaP(), arvore = new ListaP(), repetidos = new ListaP(), filhos, estouro = new ListaP();
        NodeP aux = origem;
        
        varredura.add( aux.getX(),aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
        arvore.add( aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
        repetidos.add(aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
          
        //System.out.println("origem"+origem.getX()+", "+origem.getY());
        
        while(!destinos.isEmpty()){
            if(!varredura.isEmpty()){
                aux = varredura.removeFirst();

                for(int i = 0; i < destinos.nodeCounter(); i++){
                    if(aux.getX()==destinos.getNodeP(i).getX()&&aux.getY()==destinos.getNodeP(i).getY()){

                        ListaP res;
                        NodeP novaOrigem = destinos.getNodeP(i);
                        novaOrigem.setPai(aux);
                        novaOrigem.setCusto(aux.getCusto());
                        novaOrigem.setFunc(aux.getFunc());
                        destinos.remove(destinos.getNodeP(i));

                        System.out.println("traz resposta ("+arvore.trazResposta(novaOrigem).getX()+", "+arvore.trazResposta(novaOrigem ).getY()+") ");
                        arvore.setCaminho(matriz, arvore.trazResposta(novaOrigem ));
                        System.out.println("O caminho: \n"+arvore.caminho(arvore.trazResposta(novaOrigem )).show());

                        res = arvore.caminho(arvore.trazResposta(novaOrigem));
                        resetaVarredura(matriz);
                        if(!destinos.isEmpty()){
                            int[][] novaHeuristica = setNextHeuristica(origem, destinos, matriz);
                            if(aiaEstrela(novaOrigem,destinos, matriz, novaHeuristica, limite) instanceof ListaP listap){
                                res.copiaLista(listap);
                                return res;
                            }else return "Caminho nao encontrado";
                        }else return res;
                    }
                }

                filhos = setFilhosA(aux, repetidos, matriz, heuristica, limite, estouro);
                arvore.copiaLista(filhos);
                repetidos.copiaLista(filhos);

                for(int i = 0; i < filhos.nodeCounter(); i++){
                    varredura.addByFunc(filhos.getNodeP(i).getX(), filhos.getNodeP(i).getY(), filhos.getNodeP(i).getCusto(), filhos.getNodeP(i).getFunc(), filhos.getNodeP(i).getPai());
                }
                System.out.println("Estouro:");
                System.out.println(estouro.show());
                printMatriz(matriz);
            }else{
                for(int i = 0; i < estouro.nodeCounter(); i++){
                    limite += estouro.getNodeP(i).getFunc();
                }
                limite = limite/estouro.nodeCounter();
                varredura = new ListaP();
                arvore = new ListaP();
                repetidos = new ListaP();
                estouro = new ListaP();
                aux = origem;
                varredura.add( aux.getX(),aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
                arvore.add( aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
                repetidos.add(aux.getX(), aux.getY(), aux.getCusto(), heuristica[aux.getX()][aux.getY()]+aux.getCusto());
                
                System.out.println("Novo limite: "+limite);
            }
        }
        
        resetaVarredura(matriz);
        return "Caminho nao encontrado";
    }
    
    
    
    
    
    //O custo para movimentos na vertical é 1, o custo para movimentos na horizontal é 3, o custo para movimentos colaterais é 2. //prioriza movimentos verticais sobre horizontais e colaterais
    public ListaP setFilhos(NodeP pai, ListaP repetidos, int matriz[][]){
        ListaP res = new ListaP();
        NodeP ref;
        
        //NORTE -x y
        if(pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY())){
                res.add(pai.getX()-1, pai.getY(),  pai.getCusto()+1, pai.getFunc()+1);
                if(matriz[pai.getX()-1][pai.getY()]==0) matriz[pai.getX()-1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY(),  pai.getCusto()+1, pai.getFunc()+1);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }

        //NORDESTE -x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()+1)){
                res.add(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, pai.getFunc()+2);
                if(matriz[pai.getX()-1][pai.getY()+1]==0) matriz[pai.getX()-1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, pai.getFunc()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        } 
        
        //ESTE x +y
        if(pai.getY()+1<matriz[0].length){
            if(!repetidos.contains(pai.getX(), pai.getY()+1)){
                res.add(pai.getX(), pai.getY()+1, pai.getCusto()+3, pai.getFunc()+3);
                if(matriz[pai.getX()][pai.getY()+1]==0) matriz[pai.getX()][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()+1, pai.getCusto()+3, pai.getFunc()+3);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUDESTE +x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()+1)){  //ver se contém e se o contido tem custo maior ou não
                res.add(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, pai.getFunc()+2);
                if(matriz[pai.getX()+1][pai.getY()+1]==0) matriz[pai.getX()+1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, pai.getFunc()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUL +x y
        if(pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY())){
                res.add(pai.getX()+1, pai.getY(), pai.getCusto()+1, pai.getFunc()+1);
                if(matriz[pai.getX()+1][pai.getY()]==0) matriz[pai.getX()+1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY(), pai.getCusto()+1, pai.getFunc()+1);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUDOESTE +x -y
        if(pai.getY()-1>=0&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()-1)){
                res.add(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, pai.getFunc()+2);
                if(matriz[pai.getX()+1][pai.getY()-1]==0) matriz[pai.getX()+1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, pai.getFunc()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //OESTE x -y
        if(pai.getY()-1>=0){
            if(!repetidos.contains(pai.getX(), pai.getY()-1)){
                res.add(pai.getX(), pai.getY()-1, pai.getCusto()+3, pai.getFunc()+3);
                if(matriz[pai.getX()][pai.getY()-1]== 0) matriz[pai.getX()][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()-1, pai.getCusto()+3, pai.getFunc()+3);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //NOROESTE -x -y
        if(pai.getY()-1>=0&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()-1)){
                res.add(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, pai.getFunc()+2);
                if(matriz[pai.getX()-1][pai.getY()-1]==0) matriz[pai.getX()-1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, pai.getFunc()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        res.setPaternidade(pai);
        return res;
    }
    
    public ListaP setFilhos(NodeP pai, ListaP repetidos, int matriz[][], int heuristica[][]){
        ListaP res = new ListaP();
        NodeP ref;
        
        //NORTE -x y
        if(pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY())){
                res.add(pai.getX()-1, pai.getY(),  pai.getCusto()+1, heuristica[pai.getX()-1][pai.getY()]);
                if(matriz[pai.getX()-1][pai.getY()]==0) matriz[pai.getX()-1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY(),  pai.getCusto()+1, heuristica[pai.getX()-1][pai.getY()]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }

        //NORDESTE -x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()+1)){
                res.add(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()+1]);
                if(matriz[pai.getX()-1][pai.getY()+1]==0) matriz[pai.getX()-1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()+1]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        } 
        
        //ESTE x +y
        if(pai.getY()+1<matriz[0].length){
            if(!repetidos.contains(pai.getX(), pai.getY()+1)){
                res.add(pai.getX(), pai.getY()+1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()+1]);
                if(matriz[pai.getX()][pai.getY()+1]==0) matriz[pai.getX()][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()+1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()+1]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUDESTE +x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()+1)){  
                res.add(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()+1]);
                if(matriz[pai.getX()+1][pai.getY()+1]==0) matriz[pai.getX()+1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()+1]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUL +x y
        if(pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY())){
                res.add(pai.getX()+1, pai.getY(), pai.getCusto()+1, heuristica[pai.getX()+1][pai.getY()]);
                if(matriz[pai.getX()+1][pai.getY()]==0) matriz[pai.getX()+1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY(), pai.getCusto()+1, heuristica[pai.getX()+1][pai.getY()]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUDOESTE +x -y
        if(pai.getY()-1>=0&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()-1)){
                res.add(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()-1]);
                if(matriz[pai.getX()+1][pai.getY()-1]==0) matriz[pai.getX()+1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()-1]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //OESTE x -y
        if(pai.getY()-1>=0){
            if(!repetidos.contains(pai.getX(), pai.getY()-1)){
                res.add(pai.getX(), pai.getY()-1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()-1]);
                if(matriz[pai.getX()][pai.getY()-1]== 0) matriz[pai.getX()][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()-1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()-1]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //NOROESTE -x -y
        if(pai.getY()-1>=0&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()-1)){
                res.add(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()-1]);
                if(matriz[pai.getX()-1][pai.getY()-1]==0) matriz[pai.getX()-1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()-1]);
                if(ref.getCusto()<repetidos.getNode(ref.getX(), ref.getY()).getCusto()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        res.setPaternidade(pai);
        return res;
    }
    
    public ListaP setFilhosA(NodeP pai, ListaP repetidos, int matriz[][], int heuristica[][]){
        ListaP res = new ListaP();
        NodeP ref;
        
        //NORTE -x y
        if(pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY())){
                res.add(pai.getX()-1, pai.getY(),  pai.getCusto()+1, heuristica[pai.getX()-1][pai.getY()]+pai.getCusto()+1);
                if(matriz[pai.getX()-1][pai.getY()]==0) matriz[pai.getX()-1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY(),  pai.getCusto()+1, heuristica[pai.getX()-1][pai.getY()]+pai.getCusto()+1);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }

        //NORDESTE -x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()+1)){
                res.add(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()+1]+pai.getCusto()+2);
                if(matriz[pai.getX()-1][pai.getY()+1]==0) matriz[pai.getX()-1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()+1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        } 
        
        //ESTE x +y
        if(pai.getY()+1<matriz[0].length){
            if(!repetidos.contains(pai.getX(), pai.getY()+1)){
                res.add(pai.getX(), pai.getY()+1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()+1]+pai.getCusto()+3);
                if(matriz[pai.getX()][pai.getY()+1]==0) matriz[pai.getX()][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()+1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()+1]+pai.getCusto()+3);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUDESTE +x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()+1)){  
                res.add(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()+1]+pai.getCusto()+2);
                if(matriz[pai.getX()+1][pai.getY()+1]==0) matriz[pai.getX()+1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()+1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUL +x y
        if(pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY())){
                res.add(pai.getX()+1, pai.getY(), pai.getCusto()+1, heuristica[pai.getX()+1][pai.getY()]+pai.getCusto()+1);
                if(matriz[pai.getX()+1][pai.getY()]==0) matriz[pai.getX()+1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY(), pai.getCusto()+1, heuristica[pai.getX()+1][pai.getY()]+pai.getCusto()+1);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //SUDOESTE +x -y
        if(pai.getY()-1>=0&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()-1)){
                res.add(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()-1]+pai.getCusto()+2);
                if(matriz[pai.getX()+1][pai.getY()-1]==0) matriz[pai.getX()+1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()-1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //OESTE x -y
        if(pai.getY()-1>=0){
            if(!repetidos.contains(pai.getX(), pai.getY()-1)){
                res.add(pai.getX(), pai.getY()-1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()-1]+pai.getCusto()+3);
                if(matriz[pai.getX()][pai.getY()-1]== 0) matriz[pai.getX()][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()-1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()-1]+pai.getCusto()+3);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        
        //NOROESTE -x -y
        if(pai.getY()-1>=0&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()-1)){
                res.add(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()-1]+pai.getCusto()+2);
                if(matriz[pai.getX()-1][pai.getY()-1]==0) matriz[pai.getX()-1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()-1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                }
            }
        }
        res.setPaternidade(pai);
        return res;
    }
    
    public ListaP setFilhosA(NodeP pai, ListaP repetidos, int matriz[][], int heuristica[][], int limite, ListaP estouro){
        ListaP res = new ListaP();
        NodeP ref;
        
        //NORTE -x y
        if(pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY())){
                if(heuristica[pai.getX()-1][pai.getY()]+pai.getCusto()+1<limite) res.add(pai.getX()-1, pai.getY(),  pai.getCusto()+1, heuristica[pai.getX()-1][pai.getY()]+pai.getCusto()+1);
                else if(!estouro.contains(pai.getX()-1, pai.getY())) estouro.add(pai.getX()-1, pai.getY(),  pai.getCusto()+1, heuristica[pai.getX()-1][pai.getY()]+pai.getCusto()+1);
                
                if(matriz[pai.getX()-1][pai.getY()]==0) matriz[pai.getX()-1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY(),  pai.getCusto()+1, heuristica[pai.getX()-1][pai.getY()]+pai.getCusto()+1);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        }

        //NORDESTE -x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()+1)){
                if(heuristica[pai.getX()-1][pai.getY()+1]+pai.getCusto()+2<limite) res.add(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()+1]+pai.getCusto()+2);
                else if(!estouro.contains(pai.getX()-1, pai.getY()+1)) estouro.add(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()+1]+pai.getCusto()+2);
                
                if(matriz[pai.getX()-1][pai.getY()+1]==0) matriz[pai.getX()-1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()+1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        } 
        
        //ESTE x +y
        if(pai.getY()+1<matriz[0].length){
            if(!repetidos.contains(pai.getX(), pai.getY()+1)){
                if(heuristica[pai.getX()][pai.getY()+1]+pai.getCusto()+3<limite) res.add(pai.getX(), pai.getY()+1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()+1]+pai.getCusto()+3);
                else if(!estouro.contains(pai.getX(), pai.getY()+1)) estouro.add(pai.getX(), pai.getY()+1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()+1]+pai.getCusto()+3);
                
                if(matriz[pai.getX()][pai.getY()+1]==0) matriz[pai.getX()][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()+1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()+1]+pai.getCusto()+3);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        }
        
        //SUDESTE +x +y
        if(pai.getY()+1<matriz[0].length&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()+1)){  
                if(heuristica[pai.getX()+1][pai.getY()+1]+pai.getCusto()+2<limite) res.add(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()+1]+pai.getCusto()+2);
                else if(!estouro.contains(pai.getX()+1, pai.getY()+1)) estouro.add(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()+1]+pai.getCusto()+2);
                
                if(matriz[pai.getX()+1][pai.getY()+1]==0) matriz[pai.getX()+1][pai.getY()+1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()+1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()+1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        }
        
        //SUL +x y
        if(pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY())){
                if(heuristica[pai.getX()+1][pai.getY()]+pai.getCusto()+1<limite) res.add(pai.getX()+1, pai.getY(), pai.getCusto()+1, heuristica[pai.getX()+1][pai.getY()]+pai.getCusto()+1);
                else if(!estouro.contains(pai.getX()+1, pai.getY())) estouro.add(pai.getX()+1, pai.getY(), pai.getCusto()+1, heuristica[pai.getX()+1][pai.getY()]+pai.getCusto()+1);
                
                if(matriz[pai.getX()+1][pai.getY()]==0) matriz[pai.getX()+1][pai.getY()]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY(), pai.getCusto()+1, heuristica[pai.getX()+1][pai.getY()]+pai.getCusto()+1);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        }
        
        //SUDOESTE +x -y
        if(pai.getY()-1>=0&&pai.getX()+1<matriz.length){
            if(!repetidos.contains(pai.getX()+1, pai.getY()-1)){
                if(heuristica[pai.getX()+1][pai.getY()-1]+pai.getCusto()+2<limite) res.add(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()-1]+pai.getCusto()+2);
                else if(!estouro.contains(pai.getX()+1, pai.getY()-1)) estouro.add(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()-1]+pai.getCusto()+2);
                
                if(matriz[pai.getX()+1][pai.getY()-1]==0) matriz[pai.getX()+1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()+1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()+1][pai.getY()-1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        }
        
        //OESTE x -y
        if(pai.getY()-1>=0){
            if(!repetidos.contains(pai.getX(), pai.getY()-1)){
                if(heuristica[pai.getX()][pai.getY()-1]+pai.getCusto()+3<limite) res.add(pai.getX(), pai.getY()-1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()-1]+pai.getCusto()+3);
                else if(!estouro.contains(pai.getX(), pai.getY()-1)) estouro.add(pai.getX(), pai.getY()-1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()-1]+pai.getCusto()+3);
                
                if(matriz[pai.getX()][pai.getY()-1]== 0) matriz[pai.getX()][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX(), pai.getY()-1, pai.getCusto()+3, heuristica[pai.getX()][pai.getY()-1]+pai.getCusto()+3);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        }
        
        //NOROESTE -x -y
        if(pai.getY()-1>=0&&pai.getX()-1>=0){
            if(!repetidos.contains(pai.getX()-1, pai.getY()-1)){
                if(heuristica[pai.getX()-1][pai.getY()-1]+pai.getCusto()+2<limite) res.add(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()-1]+pai.getCusto()+2);
                else if(!estouro.contains(pai.getX()-1, pai.getY()-1)) estouro.add(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()-1]+pai.getCusto()+2);
                
                if(matriz[pai.getX()-1][pai.getY()-1]==0) matriz[pai.getX()-1][pai.getY()-1]=1;
            }else{
                ref = new NodeP(pai.getX()-1, pai.getY()-1, pai.getCusto()+2, heuristica[pai.getX()-1][pai.getY()-1]+pai.getCusto()+2);
                if(ref.getFunc()<repetidos.getNode(ref.getX(), ref.getY()).getFunc()){
                    
                    if(ref.getFunc()<limite) res.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc());
                    else if(!estouro.contains(ref.getX(), ref.getY())) estouro.add(ref.getX(), ref.getY(), ref.getCusto(), ref.getFunc()) ;
                }
            }
        }
        res.setPaternidade(pai);
        return res;
    }
    
    public int[][] heuristica(NodeP destino, int matriz [][]){
        int[][] res = new int[matriz.length][matriz[0].length];
        int dx, dy;
        for(int i = 0; i < res.length;i++){
            for(int j = 0; j < res[0].length;j++){
                dx = Math.abs(i-destino.getX());
                dy = Math.abs(j-destino.getY());
                
                if(dx==dy) res[i][j] = 2*dx;
                else if(dx > dy) res[i][j] = dx + dy;
                else if(dy > dx){
                    if((dy+dx)%2==1) res[i][j] = 2*dy+1;
                    else if((dy+dx)%2==0)res[i][j] = 2*dy;
                }
            }
        }
        
        
        return res;
    }
    
    public int[][] setNextHeuristica(NodeP origem, ListaPInput input, int matriz[][]){
        System.out.println("\n Heuristica origem ("+origem.getX()+", "+ origem.getY()+"):\n");
        int[][] ho = heuristica(origem, matriz);
        printMatriz(ho);
        NodeP maisPerto = input.getInicio();
        for(int i = 1; i < input.nodeCounter(); i++){
            if(ho[maisPerto.getX()][maisPerto.getY()]>ho[input.getNodeP(i).getX()][input.getNodeP(i).getY()]) maisPerto = input.getNodeP(i);
        }

        System.out.println("\n Heuristica input ("+maisPerto.getX()+", "+ maisPerto.getY()+"):\n");
        int[][] h = heuristica(maisPerto, matriz);
        printMatriz(h);
        System.out.println("\n\n");
        return h;
    }
    
    public void limpaCaminho(int matriz [][]){
        for(int i = 0; i < matriz.length;i++){
            for(int j = 0; j < matriz[0].length;j++){
                if(matriz[i][j]==2) matriz[i][j]=0;
            }
        }
    }
    
    public void resetaVarredura(int matriz [][]){
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
}
