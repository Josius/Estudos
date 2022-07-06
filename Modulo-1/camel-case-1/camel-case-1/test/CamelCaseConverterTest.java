// Código de testes
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CamelCaseConverterTest {
	
	private CamelCaseConverter camelCase;
	@Before
	public void setup() {
		camelCase = new CamelCaseConverter();
	}
	
	@Test
	public void deveConverterNomeSimples() throws Exception {
		
		Assert.assertEquals("Josildus", camelCase.converter("josildus"));
	}
	
	@Test
	public void deveConverterNomeSimplesMisturadoMaiusculoEMinusculo() throws Exception {
		Assert.assertEquals("Lionel", camelCase.converter("lIOnel"));
	}
}
