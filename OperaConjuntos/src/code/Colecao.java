package code;

import java.util.Random;

public class Colecao {
    private int[] numeros;
    private int cont;

    public Colecao(int tamanho) {
        numeros = new int[tamanho];
    }

    public int[] getNumeros() {
        return numeros;
    }

    public int getCont() {
        return cont;
    }
    
    public boolean adiciona(int valor){
        if(cont < numeros.length)
        {
            if(existe(valor))
            {
                return false;
            }
            numeros[cont] = valor;
            cont++;
            return true;
        }
        return false;
    }
    
    public boolean existe(int valor)
    {
        for(int i = 0; i < cont ; i++)
        {
            if(numeros[i] == valor)
            {
                return true;
            }
        }
        return false;
    }
    
    public void preenche()
    {
        Random valorRand = new Random();
        //while(adiciona(valorRand.nextInt(11))); testar depois
        int i = cont;
        while(i < numeros.length)
        {
            if(adiciona(valorRand.nextInt(51)))
            {
                i++;
            }
        }
    }
    
    public String dados()
    {
        StringBuilder builder = new StringBuilder();
        ordenar();
        builder.append("Conjunto[").append(cont).append("] = { ");
        for (int i = 0; i < cont; i++) {
            builder.append(numeros[i]);
            
            if(!((i + 1) == cont))
            {
                builder.append(", ");
            }
        }
        builder.append(" }");
        return builder.toString();
    }
    // pra fins estéticos
    public void ordenar() {
        
        for (int i = 0; i < cont; i++) {
            for (int j = i + 1; j < cont; j++) {
                int tmp;
                if (numeros[i] > numeros[j]) {
                    tmp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = tmp;
                }
            }
        }
    }
    
    public void limpa()
    {
        int i = cont - 1;
        while(i >= 0)
        {
            numeros[i] = 0;
            cont--;
            i--;
        }
    }
}
