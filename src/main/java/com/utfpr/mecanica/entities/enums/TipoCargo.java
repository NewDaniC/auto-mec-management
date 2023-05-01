package com.utfpr.mecanica.entities.enums;

public enum TipoCargo {
	ADMINISTRACAO(1),
	SECRETARIO(2),
	MECANICO(3),
	RECEPCAO(4);

	private int code;
	
	private TipoCargo(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoCargo valueOf(int code) {
		for (TipoCargo value : TipoCargo.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid EstadoPagamento code");
	}
}
