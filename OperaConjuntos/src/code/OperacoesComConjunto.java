package code;

public class OperacoesComConjunto {
    
    public Colecao interseccao(Colecao conjunto1, Colecao conjunto2)
    {
        Colecao aux3 = new Colecao(conjunto1.getNumeros().length); //Vetor que fornecerá valor de retorno
        for(int j = 0; j < conjunto2.getCont(); j++)
        {
            if(conjunto1.existe(conjunto2.getNumeros()[j]))
            {
                aux3.adiciona(conjunto2.getNumeros()[j]);
            }
        }
        return aux3;
    }
    
    public Colecao diferenca(Colecao conjunto1, Colecao conjunto2)
    {
        Colecao aux3 = new Colecao(conjunto1.getCont()+conjunto2.getCont()); //Vetor que fornecerá valor de retorno, o maior tamanho que ele pode ter é se todos os elementos forem diferentes
        
        for(int j = 0; j < conjunto2.getCont(); j++) //Verificando se há elementos do conjunto 2 iguais ao 1
        {
            if(!conjunto1.existe(conjunto2.getNumeros()[j]))
            {
                aux3.adiciona(conjunto2.getNumeros()[j]); //Se não houver, é adicionado no conjunto diferença
            }
        }
        
        for(int k = 0; k < conjunto1.getCont(); k++) //O inverso ocorre, análise de elementos do conjunto 1 iguais a 1.
        {
            if(!conjunto2.existe(conjunto1.getNumeros()[k]))
            {
                aux3.adiciona(conjunto1.getNumeros()[k]); //Se não houver igualdade, é adicionado no conjunto
            }
        }
        
        //Esse processo algoritmico exigiu dois loops pelo método "existir" pegar um elemento externo e comparar com um vetor, retornando true/false
        //Assim, nota-se que a análise passa a ser unilateral, pois lista-se os elementos únicos do conjunto 2, mas não do 1
        return aux3;
    }
    
    public Colecao uniao(Colecao conjunto1, Colecao conjunto2) //União se trata de intersecção + diferença
    {
        Colecao colint = interseccao(conjunto1, conjunto2); 
        Colecao coldif = diferenca(conjunto1, conjunto2); 
        Colecao auxret; //Vetor que fornecerá valor de retorno
        
        auxret = new Colecao(((colint.getCont())+coldif.getCont()));
        
        for(int i = 0; i < coldif.getCont(); i++) 
        {
            auxret.adiciona(coldif.getNumeros()[i]);
        }
        for(int j = 0; j < colint.getCont(); j++) 
        {
            auxret.adiciona(colint.getNumeros()[j]);
        }
        auxret.ordenar();
        return auxret;
    }
}
