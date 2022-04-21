import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrinho {
	
		static private int sequencial = 0;

		private int id;
		private Date data;
		private List<Produto> itens;
		private int numDeItens = 0;
		private float valorICMS;
		private float valorVenda;
		private String status;
				
		public Carrinho(Date data) {
			this.id = ++sequencial;
			this.data = data;
			this.status = "Pendente";
			this.itens = new ArrayList<Produto>();
		}
				
		public int getId() {
			return id;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public List<Produto> getItens() {
			return itens;
		}

		public void setItens(List<Produto> itens) {
			this.itens = itens;
		}

		public int getNumDeItens() {
			return numDeItens;
		}

		public float getValorICMS() {
			return valorICMS;
		}

		public float getValorVenda() {
			return valorVenda;
		}

		public String getStatus() {
			return status;
		}
	
		public void insereItem(Produto p) {
			this.itens.add(p);
			this.numDeItens++;
			this.valorICMS += p.calcularICMS();
			this.valorVenda += p.getPrecoVenda();
		}
		
		public void confirmarCompra() {
			for (Produto produto : this.itens) {
				produto.confirmarVenda();
			}
			this.status = "Confirmada";
		}

		@Override
		public String toString() {
			return "*** INFOS DA VENDA*** \nId: " + id + 
					"\nQtde de itens : " + numDeItens + " unidade(s)" +
					"\nItens " + itens +
					"\nTotal do ICMS : " + valorICMS + " reais" +
					"\nValor total   : " + valorVenda + " reais" + 
					"\nStatus        : " + status;
		}		
}