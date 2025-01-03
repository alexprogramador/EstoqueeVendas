package estoqueevendas;

import javax.swing.JOptionPane;

public class Vendas {

    public static void vender(Produto produto, int quantidade, TipoVenda tipoVenda, int parcelas) {
        double valorTotal = 0;
        double valorComAcrescimo = 0;

        switch (tipoVenda) {
            case DINHEIRO:
                valorComAcrescimo = produto.getValor() * 0.90; // 10% de desconto para pagamentos em dinheiro
                valorTotal = quantidade * valorComAcrescimo;
                break;
            case CARTAO_CREDITO:
                double juros = 0.05 * parcelas; // 5% de juros ao mês para vendas parceladas
                valorComAcrescimo = produto.getValor() * (1 + juros);
                valorTotal = quantidade * valorComAcrescimo;
                break;
            case CARTAO_DEBITO:
                valorComAcrescimo = produto.getValor();
                valorTotal = quantidade * valorComAcrescimo;
                break;
            case BOLETO:
                valorComAcrescimo = produto.getValor() * 1.08; // 8% de juros para pagamentos via boleto
                valorTotal = quantidade * valorComAcrescimo;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de venda inválido.");
        }

        if (quantidade <= produto.getQuantidadeEstoque()) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
            JOptionPane.showMessageDialog(null, "Produto vendido: " + produto.getNome() + "\nValor total da compra: " + valorTotal);
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque!");
        }
    }
}