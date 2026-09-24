package Strategy;

public class CartaoCredito implements FormaDePagamento {
    private int parcelas;

    public CartaoCredito() {
        this(1);
    }

    public CartaoCredito(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getParcelas() {
        return parcelas;
    }

    @Override
    public void pagar(double valor) {
        if (parcelas <= 1) {
            System.out.println("Pagamento de R$ " + valor + " realizado com Cartão de Crédito à vista (1x).");
        } else {
            double valorParcela = valor / parcelas;
            System.out.println("Pagamento de R$ " + valor + " realizado com Cartão de Crédito em " + parcelas + "x de R$ " + valorParcela);
        }
    }
}