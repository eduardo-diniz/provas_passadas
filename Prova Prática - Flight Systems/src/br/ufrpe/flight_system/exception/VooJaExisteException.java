package br.ufrpe.flight_system.exception;

import java.time.format.DateTimeFormatter;

import br.ufrpe.flight_system.negocio.beans.Voo;

public class VooJaExisteException extends Exception {
    
	private static final long serialVersionUID = -6053119465703899227L;
	
	private Voo voo;
    
    public VooJaExisteException(Voo voo) {
        if (voo == null) {
            throw new IllegalArgumentException();
        }
        this.voo = voo;
    }
    
    @Override
    public String getMessage() {
        String mensagem = "Voo j� existe no reposit�rio";
        if (this.voo != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            mensagem = String.format("O voo de origem %s e destino %s com hor�rio de sa�da [%s] j� existe", 
                    voo.getOrigem(), voo.getDestino(), voo.getHorarioSaida().format(formatter));
        }
        return mensagem;
    }

}
