import Decorator.Desconto;
import Decorator.EmbalagemPresente;
import Decorator.EntregaRapida;
import Decorator.Frete;
import Entidades.Pedido;
import Entidades.PedidoBase;
import Entidades.Produto;
import Strategy.CartaoCredito;
import Strategy.CartaoDebito;
import Strategy.Dinheiro;
import Strategy.Pix;

public class Main {
    public static void main(String[] args) {

        // ==========================
        // Pedido 01: Produtos + Frete, pago via PIX
        // ==========================

        System.out.println(" ");
        System.out.println("==================================================");
        System.out.println("Pedido 01 (Produtos + Frete | Strategy: Pix):");
        System.out.println("==================================================");

        Pedido pedido1 = new PedidoBase();
        pedido1.addProduto(new Produto(1, "Iphone 13", "Telefone da Apple", 2300));
        pedido1.addProduto(new Produto(2, "Tablet", "Tablet pro", 4000));

        // Decorando com Frete
        Pedido pedidoComFrete1 = new Frete(pedido1, 60);

        pedidoComFrete1.listarProdutos();
        System.out.println("Total do Pedido 01: R$ " + pedidoComFrete1.getTotal());
        pedidoComFrete1.realizarPagamento(new Pix());

        // ==========================
        // Pedido 02: Produtos + Embalagem para Presente, pago em Dinheiro
        // ==========================

        System.out.println(" ");
        System.out.println("==================================================");
        System.out.println("Pedido 02 (Produtos + Embalagem | Strategy: Dinheiro):");
        System.out.println("==================================================");

        Pedido pedido2 = new PedidoBase();
        pedido2.addProduto(new Produto(3, "Nintendo Switch 2", "Video-game da Nintendo", 4200));
        pedido2.addProduto(new Produto(4, "Assinatura Netflix", "Streaming", 23.10));

        // Decorando com Embalagem para Presente
        Pedido pedidoEmbalagem1 = new EmbalagemPresente(pedido2, 30);

        pedidoEmbalagem1.listarProdutos();
        System.out.println("Total do Pedido 02: R$ " + pedidoEmbalagem1.getTotal());
        pedidoEmbalagem1.realizarPagamento(new Dinheiro());

        // ==========================
        // Pedido 03: Produtos + Frete + 10% Desconto, pago no Cartão de Crédito (3x)
        // ==========================

        System.out.println(" ");
        System.out.println("==================================================");
        System.out.println("Pedido 03 (Frete + 10% Desconto | Strategy: Cartão 3x):");
        System.out.println("==================================================");

        Pedido pedido3 = new PedidoBase();
        pedido3.addProduto(new Produto(5, "Notebook", "Notebook 16GB", 5000));

        // Encadeamento de decoradores: PedidoBase -> Frete -> Desconto
        Pedido pedido3ComFrete = new Frete(pedido3, 100);
        Pedido pedido3Final = new Desconto(pedido3ComFrete, 10);

        pedido3Final.listarProdutos();
        System.out.println("Total do Pedido 03: R$ " + pedido3Final.getTotal());
        pedido3Final.realizarPagamento(new CartaoCredito(3));

        // ==========================
        // Pedido 04: Demonstração Completa (Multi-Decorators + Troca Dinâmica de Strategy)
        // ==========================

        System.out.println(" ");
        System.out.println("==================================================");
        System.out.println("Pedido 04 (Todos os Decoradores + Troca Dinâmica de Strategy):");
        System.out.println("==================================================");

        Pedido pedido4 = new PedidoBase();
        pedido4.addProduto(new Produto(6, "Monitor Gamer 144Hz", "Monitor IPS 27", 1500));
        pedido4.addProduto(new Produto(7, "Teclado Mecânico RGB", "Switches lineares", 350));
        pedido4.addProduto(new Produto(8, "Mouse Sem Fio", "16000 DPI", 150));

        // Composição completa com múltiplos decoradores:
        // PedidoBase -> EmbalagemPresente -> Frete -> Desconto
        Pedido pedido4Decorado = new Desconto(
                new Frete(
                        new EmbalagemPresente(pedido4, 25),
                        75),
                15);

        pedido4Decorado.listarProdutos();
        System.out.println("Total do Pedido 04: R$ " + pedido4Decorado.getTotal());

        // Troca dinâmica de algoritmo em tempo de execução (Strategy)
        System.out.println("\n--- Definindo estratégia inicial: Dinheiro ---");
        pedido4Decorado.setFormaDePagamento(new Dinheiro());

        System.out.println("--- Mudando para Cartão de Crédito (6x) ---");
        pedido4Decorado.realizarPagamento(new CartaoCredito(6));

        // ==========================
        // Pedido 05: Produtos + Entrega Rápida, pago no Cartão de Débito
        // ==========================

        System.out.println(" ");
        System.out.println("==================================================");
        System.out.println("Pedido 05 (Produtos + Entrega Rápida | Strategy: Cartão de Débito):");
        System.out.println("==================================================");

        Pedido pedido5 = new PedidoBase();
        pedido5.addProduto(new Produto(9, "Headset Gamer 7.1", "Headset com cancelamento", 450));
        pedido5.addProduto(new Produto(10, "Mousepad Extra Grande", "Mousepad 900x400mm", 120));

        // Decorando com Entrega Rápida
        Pedido pedido5ComEntregaRapida = new EntregaRapida(pedido5, 45);

        pedido5ComEntregaRapida.listarProdutos();
        System.out.println("Total do Pedido 05: R$ " + pedido5ComEntregaRapida.getTotal());
        pedido5ComEntregaRapida.realizarPagamento(new CartaoDebito());
        System.out.println(" ");
    }
}
