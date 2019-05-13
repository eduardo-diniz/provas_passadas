package br.ufrpe.flight_system.exception;

import br.ufrpe.flight_system.negocio.beans.Voo;

public class VooInvalidoException extends Exception {

	private Voo vooInvalido;

	public VooInvalidoException(Voo vooInvalido) {

		super(String.format("O Voo ( %S ) eh invalido  ", vooInvalido.toString()));

		this.vooInvalido = vooInvalido;
	}

}
