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
        tabuleiro = new Tabuleiro (3, 3);
    }
    
    //São 13 métodos
    
    //2 Setters
    public void setJogadorDaVez()
    {
        if( contaJogadas%2 == 0) //Se o número numa divisão por 2 ter resto 0, significa que o número é par, jogador 1 começa jogando, joga nos turnos pares
        {
            jogadorDaVez = jogador1;
        }
        else{
            jogadorDaVez = jogador2;
        }
    }
    
    public void setVencedor()
    {
        vencedor = jogadorDaVez;
        jogadorDaVez.incrementaVitorias();
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
        tabuleiro.limpaTabuleiro();
        fimDoJogo = false;
        contaJogadas = 0;
        this.jogadorDaVez = jogadorDaVez;
        vencedor = null;
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
            checaFimDoJogo();
        }
        return jogadorDaVez.getSimbolo();
    }
   
    public void zeraEmpates()
    {
        contaEmpates = 0;
        jogador1.zeraVitorias();
        jogador2.zeraVitorias();
    }
    
    public void checaFimDoJogo()
    {
        char elemento = jogadorDaVez.getSimbolo();
        int[] contador = new int[4];
        //contadores que classificam pontuação por meio de diferentes critérios, sempre contabilizando se há 3 encadeados de forma:
        // contador[0] - encadeados por linha, 3 elementos iguais seguidos
        // contador[1] - encadeados por coluna, 3 elementos iguais seguidos
        // contador[2] - encadeados por diagonal principal, 3 elementos iguais seguidos
        // contador[3] - encadeados por diagonal secundario, 3 elementos iguais seguidos
        
        //Checa se pontuou por linha
        if(!isFimDoJogo())
        {
            for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
            {
                for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
                {
                    if(elemento == tabuleiro.getPeca(i, j))
                    {
                        contador[0]++;
                    }
                }
                if(contador[0] == 3)
                {
                    fimDoJogo = true;
                    setVencedor();
                    contador[0] = 0;
                }
                else{
                    contador[0] = 0;
                }
            }
        }
        
        //checa se pontuou por coluna
        if(!isFimDoJogo())
        {
            for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
            {
                for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
                {
                    if(elemento == tabuleiro.getPeca(i, j))
                    {
                        contador[1]++;
                    }
                }
                if(contador[1] == 3)
                {
                    fimDoJogo = true;
                    setVencedor();
                    break;
                }
                else{
                    contador[1] = 0;
                }
            }
        }
        
        //checa se pontuo pela diagonal principal
        if(!isFimDoJogo())
        {
            for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
            {
                for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
                {
                    if(i == j)
                    {
                        if(elemento == tabuleiro.getPeca(i, j))
                        {
                            contador[2]++;
                        }
                    }
                }
            }
            if(contador[2] == 3)
            {
                fimDoJogo = true;
                setVencedor();
            }
            else{
                contador[2] = 0;
            }
        }
        
        //checa se pontuo pela diagonal secundária
        if(!isFimDoJogo())
        {
            for(int j = 0; j < tabuleiro.getQtdeColunas() ; j++)
            {
                for(int i = 0; i < tabuleiro.getQtdeLinhas() ; i++)
                {
                    if((i + j) == 2)
                    {
                        if(elemento == tabuleiro.getPeca(i, j))
                        {
                            contador[3]++;
                        }
                    }
                }
            }
            if(contador[3] == 3)
            {
                fimDoJogo = true;
                setVencedor();
            }
            else{
                contador[3] = 0;
            }
        }
        
        if(!isFimDoJogo())
        {
            if(contaJogadas == 9)
            {
                fimDoJogo = true;
                contaEmpates++;
            }
        }
    }
}
    
