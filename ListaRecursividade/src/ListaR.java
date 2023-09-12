public class ListaR {
    private NodeR inicio;
	
	public ListaR(){
		inicio = null;
	}
	
	public void add(int valor){
		if(inicio != null){
			inicio.add(valor);
		}
		else{
			inicio = new NodeR(valor);
		}
	}
	
	public void show(){
		if(inicio!=null){
			inicio.show();
		}
	}
        
        public void showEven(){
		if(inicio!=null){
			inicio.showEven(1);
		}
	}
	
	public int size(){
		if(inicio!=null){
			return inicio.size();
		}
		else{
			return 0;
		}
		
	}
        
        public int soma(){
            if(inicio!=null){
			return inicio.soma();
		}
		else{
			return 0;
		}
        }
        
        public int maior(){
		if(inicio!=null){
			return inicio.maior();
		}
		else{
			return 0;
		}
	}
        
        public int qtdIgual(int valor){
		if(inicio!=null){
			return inicio.qtdIgual(valor);
		}
		else{
			return 0;
		}
	}
        
        public boolean contains(int valor){
		if(inicio!=null){
			return inicio.contains(valor);
		}
		else{
			return false;
		}
	}
        
//        public boolean contains2(int valor){
//		if(inicio!=null){
//			return inicio.contains2(valor);
//		}
//		else{
//			return false;
//		}
//	}
        
        public int somaPosImpares(int valor){
		if(inicio!=null){
			return inicio.somaPosImpares(valor);
		}
		else{
			return 0;
		}
	}
        
        public void doubleX(){
            if(inicio!=null){
			inicio.doubleX();
            }
        }
        
        public boolean crescente(){
		if(inicio!=null){
			return inicio.crescente();
		}
		else{
			return false;
		}
	}
        
        public int somaPares(){
            if(inicio!=null){
			return inicio.somaPares();
		}
		else{
			return 0;
		}
        }
        
        public int menorValorMaiorQue(int valor){
            if(inicio!=null){
			return inicio.menorValorMaiorQue(valor);
		}
		else{
			return 9999;
		}
        }
        
        public NodeR getNodeAt(int valor){
            if(inicio!=null){
                try{
                    return inicio.getNodeAt(valor);
                }catch(InvalidIndexException iie){
                    System.out.println(iie.getMessage());
                }
			
            }
            return null;
        }
        
        public void inverte(){
            if((inicio!=null)&&(size()!=1)){
                        int tamanho = inicio.size();
                        NodeR temp = getNodeAt(tamanho);
			inicio.inverte(tamanho);
                        inicio = temp;
            }else if(size()==1){
                System.out.println("Nao eh possivel inverter lista de apenas um no");
            }
        }
}
