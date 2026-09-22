package Strategy;

public class Pix implements  FormaDePagamento{
    
    @Override
    public void realizarPagamento(){
        System.out.println("Realizando pagamento com PIX");
    }
}
