package sistemabancario;

import java.text.DecimalFormat;

public class ContaEspecial extends ContaCorrente{
    private double limite;

    public ContaEspecial(String numeroConta, Pessoa titular) {
        super(numeroConta, titular);
        this.limite = 1000;
        saldo +=limite;
    }

    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String toString(){
        
        String s = super.toString();
        DecimalFormat mascaraNum = new DecimalFormat("#,##0.00"); 
        
        double sr = getSaldo()-limite;
        
        return s+"\nLimite: R$ "+mascaraNum.format(limite)+"\nSaldo Real: R$ "+mascaraNum.format(sr);
    }
}
