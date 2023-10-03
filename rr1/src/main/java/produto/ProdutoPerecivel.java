package produto;

import java.util.GregorianCalendar;

public class ProdutoPerecivel extends Produto {

	//atributos

	private GregorianCalendar dataValidade;

	//construtores

	public ProdutoPerecivel(int codigo, String nome, double preco,
			String descricao, GregorianCalendar datavalidate) {
		super(codigo, nome, preco, descricao);
		this.dataValidade = datavalidate;
	}

	//métodos

	public GregorianCalendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(GregorianCalendar dataValidade) {
		this.dataValidade = dataValidade;
	}

}
