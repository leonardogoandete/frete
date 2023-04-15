import br.com.ifrs.frete.fretes.Frete;
import br.com.ifrs.frete.fretes.ItemFrete;
import br.com.ifrs.frete.pessoas.Cliente;
import br.com.ifrs.frete.util.OpcoesMenu;


import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static int exibeMenu() {
        StringBuilder stringMenu = new StringBuilder();
        for (OpcoesMenu opcaoMenu : OpcoesMenu.values())
            stringMenu.append(opcaoMenu.toString());
        return Integer.parseInt(JOptionPane.showInputDialog(null, stringMenu.toString()));
    }

    public static Frete buscarFretePorNomeCliente(String nome, List<Frete> fretes){
        for (Frete frete: fretes){
            Cliente cliente = frete.getCliente();
            if(cliente.getNome().equalsIgnoreCase(nome)){
                return frete;
            }
        }
        return null;
    }

    public static Frete buscarFretePorCpfCliente(String cpf, List<Frete> fretes){
        for (Frete frete: fretes){
            Cliente cliente = frete.getCliente();
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                return frete;
            }
        }
        return null;
    }

    public static Frete buscarFretePorOrigemEDestino(String origem,String destino, List<Frete> fretes){
        for (Frete frete: fretes){
            if(frete.getCidadeOrigem().equalsIgnoreCase(origem) &&
                    frete.getCidadeDestino().equalsIgnoreCase(destino)){
                return frete;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Frete> fretes = new LinkedList<>();
        Frete frete = null;

        List<ItemFrete> lll = new ArrayList<>();
        lll.add(new ItemFrete("Aaaa",11.4d));
        Cliente cli1 = new Cliente("Leo","Guedes","51999","180180");
        Cliente cli2 = new Cliente("Lari","Veiga","98797","98796");
        fretes.add(new Frete(cli1,222.01d,"POA","SDU",lll));
        fretes.add(new Frete(cli2,444.09d,"FLP","KDX",lll));

        while(true){
            switch (exibeMenu()){
                case 1:
                    try {
                        List<ItemFrete> itens = new ArrayList<>();
                        Cliente cli = new Cliente(
                                JOptionPane.showInputDialog(null, "Nome do cliente:"),
                                JOptionPane.showInputDialog(null, "Endereço do cliente:"),
                                JOptionPane.showInputDialog(null, "Telefone do cliente:"),
                                JOptionPane.showInputDialog(null, "CPF o cliente:"));
                        while (JOptionPane.showConfirmDialog(null, "Deseja incluir item?") == 0){
                            itens.add(new ItemFrete(
                                    JOptionPane.showInputDialog(null, "Descrição do item:"),
                                    Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso:"))));
                        }

                        fretes.add(new Frete(
                                cli,
                                Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor:")),
                                JOptionPane.showInputDialog(null,"Municipio de origem:"),
                                JOptionPane.showInputDialog(null,"Municipio de destino:"),
                                itens));
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Erro ao cadastrar frete: Erro: "+ e.getMessage());
                    }
                    break;
                case 2:
                    frete = buscarFretePorNomeCliente(JOptionPane.showInputDialog(null, "Digite o nome do cliente:"),fretes);
                    if (frete != null) {
                        JOptionPane.showMessageDialog(null, frete.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há fretes com o nome pesquisado!");
                    }
                    break;
                case 3:
                    frete = buscarFretePorCpfCliente(JOptionPane.showInputDialog(null, "Digite o CPF do cliente:"),fretes);
                    if (frete != null) {
                        JOptionPane.showMessageDialog(null, frete.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há fretes com o CPF pesquisado!");
                    }
                    break;
                case 4:
                    frete = buscarFretePorOrigemEDestino(
                            JOptionPane.showInputDialog(null, "Digite a origem:"),
                            JOptionPane.showInputDialog(null, "Digite o destino:"),
                            fretes);
                    if (frete != null) {
                        JOptionPane.showMessageDialog(null, frete.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há fretes com o Origem e Destino pesquisado!");
                    }
                    break;
                case 5:
                    StringBuilder listaFretes = new StringBuilder();
                    for (Frete listaFrete: fretes){
                        listaFretes.append(listaFrete.toString());
                    }
                    JOptionPane.showMessageDialog(null,listaFretes);
                    break;
                case 6:
                    StringBuilder listaCLientes = new StringBuilder();
                    for (Frete clientesFrete: fretes){
                        listaCLientes.append(clientesFrete.getCliente().toString());
                    }
                    JOptionPane.showMessageDialog(null,listaCLientes);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida!");
                    break;
            }
        }
    }
}

