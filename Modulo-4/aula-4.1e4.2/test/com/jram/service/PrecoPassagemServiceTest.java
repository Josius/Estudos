package com.jram.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jram.model.Passageiro;
import com.jram.model.TipoPassageiro;
import com.jram.model.Voo;

public class PrecoPassagemServiceTest {

	private PrecoPassagemService precoPassagemService;

	@Before
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {	
		Passageiro passageiro = new Passageiro("Jao", TipoPassageiro.GOLD);
		Voo voo = new Voo("Sum Paulo", "Rio de Jao", 100.0);
		assertValorPassagem(passageiro, voo, 90.0);
	}

	
	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Jao", TipoPassageiro.GOLD);
		Voo voo = new Voo("Sum Paulo", "Rio de Jao", 600.0);
		assertValorPassagem(passageiro, voo, 510.0);		
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Jao", TipoPassageiro.SILVER);
		Voo voo = new Voo("Sum Paulo", "Rio de Jao", 100.0);
		assertValorPassagem(passageiro, voo, 94.0);		
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAcimaDoLimite() throws Exception {
		
		Passageiro passageiro = new Passageiro("Jao", TipoPassageiro.SILVER);
		Voo voo = new Voo("Sum Paulo", "Rio de Jao", 800.0);
		assertValorPassagem(passageiro, voo, 720.0);		
	}
}
