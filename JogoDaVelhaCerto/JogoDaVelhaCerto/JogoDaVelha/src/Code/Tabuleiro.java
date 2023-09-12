
package Code;

public class Tabuleiro {
    private char [][] tabuleiro;

    public Tabuleiro(int linha, int coluna) {
        tabuleiro = new char[linha][coluna];
        //O tabuleiro inicia vazio
        limpaTabuleiro();
    }
    
    public void limpaTabuleiro(){
        for(int i = 0; i < getQtdeLinhas(); i++)
        {
            for(int j = 0; j < getQtdeColunas(); j++)
            {
                tabuleiro[i][j] = ' '; //Dois loops encadeados para preencher todos os espaços por 
            }
        }   
    }
    
    public void setPeca(char peca, int linha, int coluna){
        if(estaLivre(linha, coluna)){
            tabuleiro[linha][coluna] = peca;
        }
    }
    
    public char getPeca(int linha, int coluna)
    {
        return tabuleiro[linha][coluna];
    }
    
    public boolean estaLivre(int linha, int coluna)
    {
        if(tabuleiro[linha][coluna] == ' ')
        {
            return true;
        }
        return false;
    }
    
    public int getQtdeColunas(){
        return tabuleiro.length;
    }
    
    public int getQtdeLinhas(){
        return tabuleiro[0].length;
    }
    
}
