import br.com.ifrs.frete.fretes.Frete;
import br.com.ifrs.frete.fretes.ItemFrete;
import br.com.ifrs.frete.pessoas.Cliente;
import br.com.ifrs.frete.util.OpcoesMenu;
import br.com.ifrs.frete.util.Situacao;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class Main {
    private static final TreeSet<Frete> fretes = new TreeSet<>();
    private static final String naoHaFretes = "Não há fretes cadastrados!";

    public static void main(String[] args) {

        List<ItemFrete> lll = new ArrayList<>();
        List<ItemFrete> fff = new ArrayList<>();
        lll.add(new ItemFrete("Aaaa", 11.4d));
        fff.add(new ItemFrete("Aaaa", 9.4d));
        fff.add(new ItemFrete("Bbbb", 9.4d));
        Cliente cli1 = new Cliente("Leo", "Guedes", "51999", "180180");
        Cliente cli2 = new Cliente("Lari", "Veiga", "98797", "98796");
        Cliente cli3 = new Cliente("Leo", "Rua XV de Piracicaba", "3434314", "180180");
        fretes.add(new Frete(cli1, 222.01d, "POA", "SDU", lll));
        fretes.add(new Frete(cli2, 444.09d, "FLP", "KDX", lll));
        fretes.add(new Frete(cli3, 333.98d, "FLP", "KDX", fff));

        while (true) {
            try {
                switch (exibeMenu()) {
                    case 1:
                        cadastrarFrete();
                        break;
                    case 2:
                        buscarFretePorNomeCliente();
                        break;
                    case 3:
                        buscarFretePorCpfCliente();
                        break;
                    case 4:
                        buscarFretePorOrigemEDestino();
                        break;
                    case 5:
                        listarTodosFretes();
                        break;
                    case 6:
                        listarTodosClientes();
                        break;
                    case 7:
                        sair();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        }
    }

    private static void cadastrarFrete() {
        Cliente cli;
        Frete f1 = new Frete();
        double valorFrete;
        double pesoTotal = 0.0;
        String origem;
        String destino;
        List<ItemFrete> listaItens = new ArrayList<>();

        try {
            // montando o cliente
            String nome = JOptionPane.showInputDialog(null, "Nome do cliente:");
            String endereco = JOptionPane.showInputDialog(null, "Endereço do cliente:");
            String telefone = JOptionPane.showInputDialog(null, "Telefone do cliente:");
            String cpf = JOptionPane.showInputDialog(null, "CPF o cliente:");
            cli = new Cliente(nome, endereco, telefone, cpf);

            // Incluindo itens
            while (JOptionPane.showConfirmDialog(null, "Deseja incluir item?") == JOptionPane.YES_OPTION) {
                String descricao = JOptionPane.showInputDialog(null, "Descrição do item:");
                double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso:"));
                ItemFrete item = new ItemFrete(descricao, peso);
                pesoTotal += peso;
                // valido se o peso limite não foi atingido
                if (!f1.validaPeso(pesoTotal)) {
                    JOptionPane.showMessageDialog(null, String.format("Limite de peso atingido!\nCota: %.2f restante\nItem: %s não foi adicionado!", (100 - pesoTotal), item.getDescricao()));
                    break;
                }
                listaItens.add(item);
            }
            valorFrete = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do frete:"));
            origem = JOptionPane.showInputDialog(null, "Município de origem:");
            destino = JOptionPane.showInputDialog(null, "Município de destino:");

            Frete frete = new Frete(cli, valorFrete, origem, destino, listaItens);
            if (listaItens.isEmpty()) frete.setSituacao(Situacao.CANCELADO); // verifica se tem itens na lista
            fretes.add(frete);

        } catch (NumberFormatException e) {
            //tratando as conversões de numero.
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar frete: Não foi possivel converter o numero.\n" + e.getMessage());
        } catch (Exception e) {
            //tratando outras excessoes que pode ocorrer.
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar frete: " + e.getMessage());
        }
    }

    public static int exibeMenu() {
        StringBuilder stringMenu = new StringBuilder();
        for (OpcoesMenu opcaoMenu : OpcoesMenu.values())
            stringMenu.append(opcaoMenu.toString());
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, stringMenu.toString()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inserido não é um inteiro!\n" + e.getMessage());
            return 0;
        }
    }

    public static void buscarFretePorNomeCliente() {
        if (fretes.isEmpty()) JOptionPane.showMessageDialog(null, naoHaFretes);
        else {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente:");
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (Frete frete : fretes) {
                Cliente cliente = frete.getCliente();
                if (cliente.getNome().equalsIgnoreCase(nome)) {
                    flag = true;
                    sb.append(frete);
                }
            }
            if (!flag) JOptionPane.showMessageDialog(null, "Não há fretes com o nome do cliente pesquisado!");
            else JOptionPane.showMessageDialog(null, sb);
        }
    }

    public static void buscarFretePorCpfCliente() {
        if (fretes.isEmpty()) JOptionPane.showMessageDialog(null, naoHaFretes);
        else {
            String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:");
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (Frete frete : fretes) {
                Cliente cliente = frete.getCliente();
                if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                    flag = true;
                    sb.append(frete);
                }
            }
            if (!flag) JOptionPane.showMessageDialog(null, "Não há fretes com o CPF pesquisado!");
            else JOptionPane.showMessageDialog(null, sb);
        }
    }

    public static void buscarFretePorOrigemEDestino() {
        if (fretes.isEmpty()) JOptionPane.showMessageDialog(null, naoHaFretes);
        else {
            String origem = JOptionPane.showInputDialog(null, "Digite a origem:");
            String destino = JOptionPane.showInputDialog(null, "Digite o destino:");
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (Frete frete : fretes) {
                if (frete.getCidadeOrigem().equalsIgnoreCase(origem) && frete.getCidadeDestino().equalsIgnoreCase(destino)) {
                    flag = true;
                    sb.append(frete);
                }
            }
            if (!flag) JOptionPane.showMessageDialog(null, "Não há fretes com a Origem e Destino pesquisado!");
            else JOptionPane.showMessageDialog(null, sb);
        }
    }

    public static void listarTodosFretes() {
        if (fretes.isEmpty()) JOptionPane.showMessageDialog(null, naoHaFretes);
        else {
            StringBuilder listaFretes = new StringBuilder();
            for (Frete listaFrete : fretes) {
                listaFretes.append(listaFrete.toString());
            }
            JOptionPane.showMessageDialog(null, listaFretes);
        }
    }

    public static void listarTodosClientes() {
        if (fretes.isEmpty()) JOptionPane.showMessageDialog(null, "Não há clientes cadastrados!");
        else {
            StringBuilder listaCLientes = new StringBuilder();
            listaCLientes.append("Numero total de clientes: ").append(Cliente.getTotal()).append("\n");
            for (Frete clientesFrete : fretes) {
                listaCLientes.append(clientesFrete.getCliente().toString());
            }
            JOptionPane.showMessageDialog(null, listaCLientes);
        }
    }

    public static void sair() {
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if (confirmacao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}




