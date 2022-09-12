package com.br.apibarbearia.model.enuns;

public enum DiaSemana {
	DOMINGO(0),
	SEGUNDA(1),
	TERCA(2),
	QUARTA(3),
	QUINTA(4),
	SEXTA(5),
	SABADO(6);

	private final int numDia;
	
	DiaSemana(int dia) {
		this.numDia = dia;
	}
	
	public int getnumDia() {
		return numDia;
	}
}

//DOMINGO("Domingo"),
//SEGUNDA("Segunda-Feira"),
//TERCA("Terça-Feira"),
//QUARTA("Quarta-Feira"),
//QUINTA("Quinta-Feira"),
//SEXTA("Sexta-Feira"),
//SABADO("Sábado")