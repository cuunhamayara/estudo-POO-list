public class Produto {
	
	
	private int codigo;
	private String descricao;
	private float precoVenda;
	private float aliquotaICMS;
	private boolean vendido;
	
	float valorICMS = 0;
	
	public Produto(int codigo, String descricao, float precoVenda, float aliquotaICMS) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
		this.aliquotaICMS = aliquotaICMS;
		this.vendido = false;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public void setAliquotaICMS(float aliquotaICMS) {
		this.aliquotaICMS = aliquotaICMS;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public float getAliquotaICMS() {
		return aliquotaICMS;
	}

	public boolean getVendido() {
		return vendido;
	}
	
	public float calcularICMS() {
		valorICMS = (aliquotaICMS/100 * precoVenda);
		return valorICMS;
	}
	
	public void confirmarVenda() {
		this.vendido = true;
	}

	@Override
	public String toString() {
		return "\ncód " + codigo + " - " +
				descricao + " - " +
				precoVenda + " reais" + " - " +
				"ICMS: " + valorICMS + " reais";
	}	
}