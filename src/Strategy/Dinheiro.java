package Strategy;

public class Dinheiro implements FormaDePagamento{

    @Override
    public void realizarPagamento(){
        System.out.println("Realizando pagamento com Dinheiro");
    }

}