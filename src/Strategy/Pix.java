package Strategy;

public class Pix implements  FormaDePagamento{
    public Pix(){
        System.out.println("Realizando pagamento com Pix");
    }
    @Override
    public void realizarPagamento(){
        System.out.println("Pix realizando pagamento");
    }
}
