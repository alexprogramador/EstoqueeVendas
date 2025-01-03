package estoqueevendas;

import javax.swing.JOptionPane;

public class Estoque {
    public static void main(String[] args) {

        Produto produto = new Produto();

        String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
        produto.setNome(nomeProduto);

        double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:"));

        // Ajuste do valor para 1.25
        produto.setValor(valorProduto * 1.25);

        int quantidadeEmEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade em estoque do produto:"));
        produto.setQuantidadeEstoque(quantidadeEmEstoque);

        int escolha = JOptionPane.showOptionDialog(null, "Selecione o tipo de venda:", "Tipo de Venda", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Boleto"}, "Dinheiro");

        switch (escolha) {
            case 0: // Dinheiro
                int quantidadeVendidaDinheiro = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser vendida:"));
                Vendas.vender(produto, quantidadeVendidaDinheiro, TipoVenda.DINHEIRO, 0);
                break;
            case 1: // Cartão de Crédito
                int quantidadeVendidaCredito = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser vendida:"));
                int parcelas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de parcelas:"));
                Vendas.vender(produto, quantidadeVendidaCredito, TipoVenda.CARTAO_CREDITO, parcelas);
                break;
            case 2: // Cartão de Débito
                int quantidadeVendidaDebito = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser vendida:"));
                Vendas.vender(produto, quantidadeVendidaDebito, TipoVenda.CARTAO_DEBITO, 0);
                break;
            case 3: // Boleto
                int quantidadeVendidaBoleto = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser vendida:"));
                Vendas.vender(produto, quantidadeVendidaBoleto, TipoVenda.BOLETO, 0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }
}