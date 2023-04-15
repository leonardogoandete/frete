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

    public static void main(String[] args) {
        LinkedList<Frete> fretes = new LinkedList<>();
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
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,fretes.toString());
                    break;
                case 6:
                    List<Cliente> lista = new ArrayList<>();
                    for (Frete frete: fretes) {
                        lista.add(frete.getCliente());
                    }
                    JOptionPane.showMessageDialog(null,lista.toString().replaceAll(",",""));
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

