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

    public static void main(String[] args) {

        List<ItemFrete> lll = new ArrayList<>();
        lll.add(new ItemFrete("Aaaa", 11.4d));
        Cliente cli1 = new Cliente("Leo", "Guedes", "51999", "180180");
        Cliente cli2 = new Cliente("Lari", "Veiga", "98797", "98796");
        Cliente cli3 = new Cliente("Leo", "Rua XV de Piracicaba", "3434314", "180180");
        fretes.add(new Frete(cli1, 222.01d, "POA", "SDU", lll));
        fretes.add(new Frete(cli2, 444.09d, "FLP", "KDX", lll));
        fretes.add(new Frete(cli3, 333.98d, "FLP", "KDX", lll));

        while (true) {
            try {
                switch (exibeMenu()) {
                    case 1:
                        cadastrarFrete();
                        break;
                    case 2:
                        buscarFretePorNomeCliente(JOptionPane.showInputDialog(null, "Digite o nome do cliente:"));
                        break;
                    case 3:
                        buscarFretePorCpfCliente(JOptionPane.showInputDialog(null, "Digite o CPF do cliente:"));
                        break;
                    case 4:
                        buscarFretePorOrigemEDestino(JOptionPane.showInputDialog(null, "Digite a origem:"),
                                JOptionPane.showInputDialog(null, "Digite o destino:"));
                        break;
                    case 5:
                        listarTodosFretes();
                        break;
                    case 6:
                        listarTodosClientes();
                        break;
                    case 7:
                        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
                        if (confirmacao == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inserido não é um inteiro!\n" + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        }
    }

    private static void cadastrarFrete() {
        List<ItemFrete> itens = new ArrayList<>();
        try {
            Cliente cli = new Cliente(
                    JOptionPane.showInputDialog(null, "Nome do cliente:"),
                    JOptionPane.showInputDialog(null, "Endereço do cliente:"),
                    JOptionPane.showInputDialog(null, "Telefone do cliente:"),
                    JOptionPane.showInputDialog(null, "CPF o cliente:"));
            while (JOptionPane.showConfirmDialog(null, "Deseja incluir item?") == JOptionPane.YES_OPTION) {
                itens.add(new ItemFrete(
                        JOptionPane.showInputDialog(null, "Descrição do item:"),
                        Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso:"))));
            }

            Frete frete = new Frete(cli, Double.parseDouble(
                    JOptionPane.showInputDialog(null, "Digite o valor do frete:")),
                    JOptionPane.showInputDialog(null, "Municipio de origem:"),
                    JOptionPane.showInputDialog(null, "Municipio de destino:"), itens);

            if (frete.validaPeso(frete.getPesoTotal())) {
                JOptionPane.showMessageDialog(null, "Frete cadastrado");
            } else {
                frete.setSituacao(Situacao.CANCELADO);
                JOptionPane.showMessageDialog(null, "Frete cancelado, peso excedido!");
            }
            fretes.add(frete);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar frete: Erro: " + e.getMessage());
        }
    }

    public static int exibeMenu() {
        StringBuilder stringMenu = new StringBuilder();
        for (OpcoesMenu opcaoMenu : OpcoesMenu.values())
            stringMenu.append(opcaoMenu.toString());
        return Integer.parseInt(JOptionPane.showInputDialog(null, stringMenu.toString()));
    }

    public static void buscarFretePorNomeCliente(String nome) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (Frete frete : fretes) {
            Cliente cliente = frete.getCliente();
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                flag = true;
                sb.append(frete);
            }
        }
        if (!flag) JOptionPane.showMessageDialog(null, "Não há clientes com o nome pesquisado!");
        else JOptionPane.showMessageDialog(null, sb);
    }

    public static void buscarFretePorCpfCliente(String cpf) {
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

    public static void buscarFretePorOrigemEDestino(String origem, String destino) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (Frete frete : fretes) {
            if (frete.getCidadeOrigem().equalsIgnoreCase(origem) && frete.getCidadeDestino().equalsIgnoreCase(destino)) {
                flag = true;
                sb.append(frete);
                //JOptionPane.showMessageDialog(null, frete.toString());
            }
        }
        if (!flag) JOptionPane.showMessageDialog(null, "Não há fretes com a Origem e Destino pesquisado!");
        else JOptionPane.showMessageDialog(null, sb);
    }

    public static void listarTodosFretes() {
        StringBuilder listaFretes = new StringBuilder();
        for (Frete listaFrete : fretes) {
            listaFretes.append(listaFrete.toString());
        }
        JOptionPane.showMessageDialog(null, listaFretes);
    }

    public static void listarTodosClientes() {
        StringBuilder listaCLientes = new StringBuilder();
        for (Frete clientesFrete : fretes) {
            listaCLientes.append(clientesFrete.getCliente().toString());
        }
        JOptionPane.showMessageDialog(null, listaCLientes);
    }
}




