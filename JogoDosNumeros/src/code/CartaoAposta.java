
package code;

import java.util.ArrayList;
import java.util.Collections;

public class CartaoAposta extends Cartao{
    private static int numeroAposta;

    public CartaoAposta() {
        setNumeroAposta();
    }

    public int getNumeroAposta() {
        return numeroAposta;
    }

    private static void setNumeroAposta() {
        CartaoAposta.numeroAposta++;
    }
    
    public float calculaAposta()
    {
        if(numeros.size()==6)
        {
            return (float)4.5;
        }
        else if(numeros.size()==7)
        {
            return (float)31.5;
        }
        else if(numeros.size()==8)
        {
            return 126;
        }
        else if(numeros.size()==9)
        {
            return 378;
        }
        return 945; //Se não cair nos casos anteriores, corresponde a seleção de 10 itens
    }
    
    public ArrayList<Integer> acertos(CartaoSorteio sorteio)
    {
        ArrayList<Integer> acertos = new ArrayList<>();
        int i = 0;
        do{
            if(sorteio.getNumeros().contains(numeros.get(i)))
            {
                acertos.add(numeros.get(i));
            }
            i++;
        }while(i < numeros.size());
        return acertos;
    }
}
