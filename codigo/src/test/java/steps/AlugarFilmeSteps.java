package steps;

import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import model.Aluguel;
import model.Filme;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private Aluguel aluguel;
	
	@Dado("^um filme$")
	public void umFilme(DataTable table) throws Throwable {
	    Map<String,String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setPreco(Double.parseDouble(map.get("preco")));
	}

	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int estoque) throws Throwable {
		filme = new Filme();
		filme.setEstoque(estoque);
	}

	@Dado("^que o preço de aluguel seja R\\$ (.+)$")
	public void queOPreçoDeAluguelSejaR$(double preco) throws Throwable {
	    filme.setPreco(preco);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
	   aluguel = new Aluguel(filme.getPreco());
	}

	@Entao("^o preco do aluguel sera R\\$ (.+)$")
	public void oPrecoDoAluguelSeraR$(double preco) throws Throwable {
		Assert.assertEquals(preco, aluguel.getValor(),1);
	}

	@Entao("^nao sera possivel por falta de estoque$")
	public void naoSeraPossivelPorFaltaDeEstoque() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
