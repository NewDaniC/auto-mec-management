package com.utfpr.mecanica.entities.enums;

public enum EstadoPagamento {

	PENDENTE(1),
	QUITADO(2);
	
	private int code;
	
	private EstadoPagamento(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static EstadoPagamento valueOf(int code) {
		for (EstadoPagamento value : EstadoPagamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid EstadoPagamento code");
	}
	
}
