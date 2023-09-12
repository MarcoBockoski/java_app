
package code;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Cartao {
    protected ArrayList<Integer> numeros;

    public Cartao() {
        numeros = new ArrayList<>();
    }
    
    public boolean addNumeros(Integer numero){
        if(numeros.contains(numero))
        {
            return false;
        }
        numeros.add(numero);
        return true;
    }
    
    public String numerosCartao()
    {
        Collections.sort(numeros);
        StringBuilder b = new StringBuilder();
        int i = 0;
        do{
            b.append("  ").append(numeros.get(i)).append("  ");
            i++;
        }while(i < numeros.size());
        
        return b.toString();
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }
    
    public boolean remove(Integer numero){
        if(numeros.contains(numero))
        {
            numeros.remove(numero);
            return true;
        }
        return false;
    }
    
}
