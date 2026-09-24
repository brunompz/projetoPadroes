package Strategy;

public class Dinheiro implements FormaDePagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado em Dinheiro.");
    }
}