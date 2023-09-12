package sistemabancario;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContaCorrente {
    
    protected String numeroConta;
    protected Pessoa titular;
    protected LocalDate dataAbertura;
    protected double saldo;

    public ContaCorrente(String numeroConta, Pessoa titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.dataAbertura = LocalDate.now();
        this.saldo = 0;
    }
    
    public void deposito(double valor)
    {
        saldo += valor; // SALDO = SALDO + VALOR
    }
    
    public boolean saque(double valor)
    {
        if(saldo >= valor)
        {
            saldo-=valor;
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString(){
        DateTimeFormatter masacaraData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat mascaraNum = new DecimalFormat("#,##0.00"); 
        
        return "Cliente desde: "+dataAbertura.format(masacaraData)+"\nConta N°: "+numeroConta+"\nTitular: "+titular.nomeCompleto()+"\nSaldo Disponível: R$ "+mascaraNum.format(saldo);
    }
}
