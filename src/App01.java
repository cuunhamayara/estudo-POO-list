import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App01 {

	public static void main(String[] args) throws ParseException {
		
		Scanner ler = new Scanner(System.in);
		
		Produto p1 = new Produto(31, "alimento perecível", 150, 17);
		Produto p2 = new Produto(20, "higiene pessoal", 4.25f, 17);
		Produto p3 = new Produto(6, "bebida alcoolica", 20, 12);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite a data da venda (dd/MM/yyyy): ");
		String dataString = ler.nextLine();
		Date data = formato.parse(dataString);
		
		Carrinho c1 = new Carrinho(data);
		
		
		//procedimento para o primeiro produto
		if (p1.getVendido() == true) {
			System.out.println("ERRO! Este produto ja foi vendido!");
		} else if (c1.getNumDeItens() == 0) {
			System.out.println("\nCarrinho criado com sucesso!\n");
			c1.insereItem(p1);
			p1.calcularICMS();
			p1.confirmarVenda();
		}
		
		//p3.confirmarVenda();   testando

		//procedimento para os proximos produtos em diante
		if (p3.getVendido() == true) {
			System.out.println("ERRO! Este produto ja foi vendido!\n");
		} else {
			c1.insereItem(p3);
			p3.calcularICMS();
			p3.confirmarVenda();
		}

		c1.confirmarCompra();
		System.out.println(c1.toString());


	}

}