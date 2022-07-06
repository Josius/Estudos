package com.jram.model;

import com.jram.service.CalculadoraPrecoPassagem;
import com.jram.service.PrecoPassagemGold;
import com.jram.service.PrecoPassagemSilver;

public enum TipoPassageiro {
	
	GOLD(new PrecoPassagemGold()),
	SILVER(new PrecoPassagemSilver());
//	NOVO_TIPO(new PrecoPassagemNovoTipo()) -> é só ir add cada novo tipo e gerar uma nova classe PrecoPassagem...
	
	CalculadoraPrecoPassagem calculadoraPrecoPassagem;
	
	private TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
		 this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
	}
	
	public CalculadoraPrecoPassagem getCalculadora() {
		return calculadoraPrecoPassagem;
	}
}
