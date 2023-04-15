import br.com.ifrs.frete.pessoas.Cliente;
import br.com.ifrs.frete.pessoas.Pessoa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Pessoa p1 = new Pessoa("Leo");


        System.out.println(p1.toString());

        Cliente cli = new Cliente("Luna","Trav. Beco dos Papagaio 12","51999999999","99933387234",122);
        System.out.println(cli.toString());
    }
}