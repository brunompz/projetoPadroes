package Strategy;

public class CartaoCredito implements FormaDePagamento {
    private static final int MAX_PARCELAS = 12;
    private int parcelas;

    // Construtor padrão: pagamento à vista (1x)
    public CartaoCredito() {
        this(1);
    }

    public CartaoCredito(int parcelas) {
        if (parcelas < 1 || parcelas > MAX_PARCELAS) {
            throw new IllegalArgumentException("Número de parcelas deve estar entre 1 e " + MAX_PARCELAS);
        }
        this.parcelas = parcelas;
    }

    public int getParcelas() {
        return parcelas;
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Realizando pagamento com Cartão de Crédito em " + parcelas + "x");
    }
}