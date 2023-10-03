package produto;

import java.util.*;

public class RepositorioProdutoNaoPerecivelArray {

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
	private ProdutoNaoPerecivel[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	//construtores

	public RepositorioProdutoNaoPerecivelArray(int size) {
		super();
		this.produtos = new ProdutoNaoPerecivel[size];
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
		for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i].getCodigo() == codigo) {
				return i;
			}
		}
		return -1;
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
	public void inserir(ProdutoNaoPerecivel produto) {
		
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(ProdutoNaoPerecivel produto) {
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
			ProdutoNaoPerecivel aux = null;
			for (int i = indice; i < this.produtos.length - 1; i++) {
				aux = this.produtos[i];
				this.produtos[i] = this.produtos[i+1];
				this.produtos[i+1] = aux;
			}
		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo O código do produto desejado.
	 * @return O produto desejado, caso exista no array.
	 */
	public ProdutoNaoPerecivel procurar(int codigo) {
		for (ProdutoNaoPerecivel p : this.produtos) {
			if (p.getCodigo() == codigo) {
				return p;
			}
		}
		throw new NoSuchElementException("Produto não registrado!");
	}

}
