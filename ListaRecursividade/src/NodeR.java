public class NodeR {
    private Integer x;
	private NodeR prox;
	
	public NodeR(int v){
		x = v;
		prox = null;
	}
	
	public void setX(int v){
		x = v;
	}
	
	public int getX(){
		return x;
	}
	
	public void setProx(NodeR p){
		prox = p;
	}
	
	public NodeR getProx(){
		return prox;
	}
	
	public void add(int valor){
		if(prox!=null){
			prox.add(valor);
		}
		else{
			prox = new NodeR(valor);
		}
	}
	
	public void show(){
		System.out.println(x); 
		if(prox!=null){
			prox.show();
		} 
	}
	
	public int size(){
		int s=0;
		if(prox!=null){
                    s = prox.size();
		}
		return 1 + s;
	}
        
        public int soma(){
		if(prox!=null){
                    return x + prox.soma();
		}
		return x;
	}
        
        public int maior(){
            int maior;
            if(prox == null){
                maior = x;
                return maior;
            }else prox.maior();
            
            if(x > prox.maior()){
                maior = x;
                return maior;
            }
            return prox.maior();
        }
        
        public int qtdIgual(int valor){
            int conta = 0;
            if(x == valor) conta = 1;
            if(prox != null){
                return conta+prox.qtdIgual(valor);
            }
            return conta;
        }
        
        public void showEven(int pos){
            
            if(pos%2 == 0) System.out.println(x);
            if(prox!=null){
                prox.showEven(pos+1);
            } 
        }
        
        public boolean contains(int valor){
           boolean achou = false;
           if(x == valor) achou = true;
            if(prox!=null){
                return achou | prox.contains(valor);
            }
            return achou;
        }
        
//        public boolean contains2(int valor){
//            if(prox!=null){
//                if(x == valor) return true;
//                prox.contains(valor);
//            }
//            return (x == valor); //fazer comparações entre parênteses, se fizer antes, ele retorna o valor um boolean sobre "x".
//        }
        
        public int somaPosImpares(int pos){
            int validez = 0;
            if((pos%2)==1) validez = x;
            if(prox!=null){
                return validez + prox.somaPosImpares(pos+1);
            }
            return validez;
        }
        
        public void doubleX(){
            if(prox!=null){
                prox.doubleX();
            }
            setX(2*getX());
        }
        
        public boolean crescente(){
            boolean validade = true;
            if(prox.getProx()!=null){
                if(x > prox.getX()) return false;
                return validade & prox.crescente();
            }
            if(x > prox.getX()) validade = false;
            return validade;
        }
        
        public int somaPares(){
            int validez = 0;
            if((x%2)==0) validez = x;
            if(prox!=null){
                return validez + prox.somaPares();
            }
            return validez;
        }
        
        public int menorValorMaiorQue(int valor){
            
            int menor = 9999;
            if(prox == null){
                if(x > valor) menor = x;
                return menor;
            }else prox.menorValorMaiorQue(valor);
            
            if(x < prox.menorValorMaiorQue(valor) && x > valor){
                menor = x;
                return menor;
            }
            return prox.menorValorMaiorQue(valor);
        }
        
        public NodeR getNodeAt(int pos) throws InvalidIndexException{
            int limite = this.size();
            if((pos <= limite)&&(pos > 0)){
                if(pos == 1) return this;
                if(pos == 2) return prox;
                else prox.getNodeAt(pos-1); //parte da recursão
            }else{
                throw new InvalidIndexException("\n\nInvalidIndexException: Impossivel realizar operacao, resultado vai dar null (index fora dos limites da lista)\n\n");
            }
            if((pos <= limite)&&(pos > 0)) return prox.getNodeAt(pos-1);
            return null;
        }
        
        public void inverte(int pos){
            if(pos != 1){
                try{
                    NodeR lastSalvado = getNodeAt(pos);
                    getNodeAt(pos-1).setProx(null);
                    lastSalvado.setProx(getNodeAt(pos-1));
                }catch(InvalidIndexException iie){
                    System.out.println(iie.getMessage());
                }
                inverte(pos-1); //Parte da recursão
                
            }else{
                try{
                    getNodeAt(1).setProx(null);
                }catch(InvalidIndexException iie){
                    System.out.println(iie.getMessage());
                }
            }
        }
}
