import br.com.ifrs.frete.fretes.Frete;
import br.com.ifrs.frete.fretes.ItemFrete;
import br.com.ifrs.frete.pessoas.Cliente;
import br.com.ifrs.frete.pessoas.Pessoa;


import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Leo");


        //System.out.println(p1.toString());

        Cliente cli = new Cliente("Luna","Trav. Beco dos Papagaio 12","51999999999","99933387234",122);
        //System.out.println(cli.toString());


        Frete f = new Frete(123.44d,100.10d,"Porto Alegre","Barueri",null,cli);

        System.out.println(f.toString());
    }
}