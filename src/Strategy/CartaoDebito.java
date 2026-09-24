package Strategy;

public class CartaoDebito implements FormaDePagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado com Cartão de Débito.");
    }
}
