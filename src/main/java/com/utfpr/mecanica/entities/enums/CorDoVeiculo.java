package com.utfpr.mecanica.entities.enums;

public enum CorDoVeiculo {
	ROSA(1),
	PRETO(2),
	BRANCO(3),
	PRATA(4),
	AZUL(5),
	AMARELO(6);
	
	private int code;
	
	private CorDoVeiculo(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoPagamento valueOf(int code) {
		for (TipoPagamento value : TipoPagamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid EstadoPagamento code");
	}
}
