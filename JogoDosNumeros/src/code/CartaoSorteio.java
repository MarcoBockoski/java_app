package code;

import java.util.ArrayList;
import java.util.Random;

public class CartaoSorteio extends Cartao{

    public CartaoSorteio() {
    }
    
    public void sorteiaNumeros(){
        Random r = new Random();
        int i = 0;
        do{
            if(addNumeros(r.nextInt(50)+1))
            {
                i++;
            }
        }while(i < 6);
    }

}
