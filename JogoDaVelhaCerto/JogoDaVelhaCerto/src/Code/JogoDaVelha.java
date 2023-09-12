package Code;

public class JogoDaVelha {
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;
    private Jogador jogadorDaVez;
    private int contaJogadas;
    private int contaEmpates;
    private Jogador vencedor;
    private boolean fimDoJogo;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }
    
    //São 13 métodos
    
    //2 Setters
    public void setJogadorDaVez()
    {
        jogadorDaVez = jogador1;
    }
    
    public void setVencedor()
    {
        vencedor = jogadorDaVez;
    }
    
    //6 getters

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    
    public Jogador getJogadorDaVez()
    {
        return jogadorDaVez;
    }
    
    public Jogador getVencedor()
    {
        return vencedor;
    }
    
    public int getContaEmpates()
    {
        return contaEmpates;
    }
    
    public int getContaJogadas()
    {
        return contaJogadas;
    }
    
    public boolean isFimDoJogo()
    {
        return fimDoJogo;
    }
    
    //5 Métodos de configuração do jogo (Exigidos pelo enunciado)
    
    public void iniciaJogo(Jogador jogadorDaVez){
        tabuleiro.LimpaTabuleiro();
        fimDoJogo = false;
        contaJogadas = 0;
        
    }
    
    public boolean ehJogadaValida(int linha, int coluna){
        if(tabuleiro.estaLivre(linha, coluna))
        {
            return true;
        }
        return false;
    }
    
    public char fazerJogada(int linha, int coluna){
        if(ehJogadaValida(linha, coluna))
        {
            tabuleiro.setPeca(jogadorDaVez.getSimbolo(), linha, coluna);
            contaJogadas++;
        }
        return jogadorDaVez.getSimbolo();
    }
   
    /*public void zeraEmpates()
    {
        
    }*/
    
    public void checaFimDoJogo()
    {
        char elemento = jogadorDaVez.getSimbolo();
        int conta = 0;
        
        //Checa se pontuou por linha
        for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
        {
            for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
            {
                if(elemento == tabuleiro.getPeca(i, j))
                {
                    conta++;
                }
            }
            if(conta == 3)
            {
                fimDoJogo = true;
                setVencedor();
            }
            else{
                conta = 0;
            }
        }
        
        //checa se pontuou por coluna
        for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
        {
            for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
            {
                if(elemento == tabuleiro.getPeca(i, j))
                {
                    conta++;
                }
            }
            if(conta == 3)
            {
                fimDoJogo = true;
                setVencedor();
            }
            else{
                conta = 0;
            }
        }
        
        //checa se pontuo pela diagonal principal
        for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
        {
            for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
            {
                if(i == j)
                {
                    if(elemento == tabuleiro.getPeca(i, j))
                    {
                        conta++;
                    }
                }
            }
            if(conta == 3)
            {
                fimDoJogo = true;
                setVencedor();
            }
            else{
                conta = 0;
            }
        }
        
        //checa se pontuo pela diagonal secundária
        for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
        {
            for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
            {
                if((i + j) == 2)
                {
                    if(elemento == tabuleiro.getPeca(i, j))
                    {
                        conta++;
                    }
                }
            }
            if(conta == 3)
            {
                fimDoJogo = true;
                setVencedor();
            }
            else{
                conta = 0;
            }
        }
        
        for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
        {
            for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
            {
                if(!(' ' == tabuleiro.getPeca(i, j)))
                {
                    fimDoJogo = true;
                    contaEmpates++;
                }
            }
        }
    }
    
    //Atributos e Métodos adicionais que julguei necessário
    private int[] placar = new int[3]; //Conta vitória do jogador 1, 2 ou empate
    
    public void atualizaPlacar(){
        
    }
}
