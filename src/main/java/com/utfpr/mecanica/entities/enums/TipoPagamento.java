package com.utfpr.mecanica.entities.enums;

public enum TipoPagamento {

	DINHEIRO(1),
	CARTAOCREDITO(2),
	CARTAODEBITO(3),
	PIX(4),
	CHEQUE(5),
	BOLETO(6);
	
	private int code;
	
	private TipoPagamento(int code) {
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
