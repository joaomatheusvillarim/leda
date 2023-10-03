package produto;

import java.util.NoSuchElementException;

public class RepositorioProdutoPerecivelArray {

	/**
 	* Classe que representa um repositório de produtos usando arrays como estrutura
 	* sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 	* sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 	* representado por uma RuntimeException que não precisa ser declarada na
 	* clausula "throws" do mos metodos.
 	* 
 	* Obs: Note que você deve utilizar a estrutura de dados array e não
 	* implementações de array prontas da API Collections de Java (como ArrayList,
 	* por exemplo).
 	* 
 	* @author Adalberto
 	*
 	*/

	//atributos

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private ProdutoPerecivel[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	//construtores

	public RepositorioProdutoPerecivelArray(int size) {
		super();
		this.produtos = new ProdutoPerecivel[size];
	}

	//métodos

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo O código do produto.
	 * @return O indice que o produto em que o código correspondente é encontrado
	 * ou -1 se o produto não existe no array.
	 */
	private int procurarIndice(int codigo) {
		int retorno = this.index;
		for (Produto p : this.produtos) {
			if (p.getCodigo() == codigo) {
				retorno = p.getCodigo();
				break;
			}
		}
		return retorno;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo O código do produto desejado.
	 * @return True se o produto existe no array.
	 */
	public boolean existe(int codigo) {
		return procurarIndice(codigo) >= 0;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(ProdutoPerecivel produto) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(ProdutoPerecivel produto) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		int indice = procurarIndice(codigo);
		if (indice == -1) {
			throw new NoSuchElementException("Produto não registrado!");
		} else {
			this.produtos[indice] = null;
		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public ProdutoPerecivel procurar(int codigo) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
