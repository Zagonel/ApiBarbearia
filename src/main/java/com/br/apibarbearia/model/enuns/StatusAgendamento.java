package com.br.apibarbearia.model.enuns;

public enum StatusAgendamento {
	SOLICITADO("Solicitado"), //0
	PENDENTE("Pendente"), //1
	CONFIRMADO("Confirmado"), //2
	CANCELADO("Cancelado"), //3
	CONCLUIDO("Concluido"); //4

	private final String descricao;

	StatusAgendamento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusAgendamento getEnumById(int id){
		for(StatusAgendamento status : StatusAgendamento.values()){
			if(status.ordinal() == id){
				return status;
			}
		}
		return null;
	}
}
