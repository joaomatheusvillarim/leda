package produto;

public class ProdutoNaoPerecivel extends Produto {

	//atributos

	private String formaAcondicionamento;

	//construtores

	public ProdutoNaoPerecivel(int codigo, String nome, double preco,
			String descricao, String formaAcondicionamento) {

		super(codigo, nome, preco, descricao);
		this.formaAcondicionamento = formaAcondicionamento;
	}

	//métodos

	public String getFormaAcondicionamento() {
		return formaAcondicionamento;
	}

	public void setFormaAcondicionamento(String formaAcondicionamento) {
		this.formaAcondicionamento = formaAcondicionamento;
	}

}
