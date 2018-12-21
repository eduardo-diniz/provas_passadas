package br.ufrpe.flight_system.negocio.beans;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import br.ufrpe.flight_system.exception.AssentoInvalidoException;
import br.ufrpe.flight_system.exception.AssentoJaMarcadoException;

public class Voo implements Serializable {
	private static final long serialVersionUID = 2549360751393048606L;
	
	private Cidade origem;
    private Cidade destino;

    private ZonedDateTime horarioSaida;
    private ZonedDateTime horarioEstimadoChegada;
    
    private boolean[] assentos;
    
    public Voo(Cidade origem, Cidade destino, ZonedDateTime horarioSaida,
            ZonedDateTime horarioEstimadoChegada, int numeroAssentos) {
        this.origem = origem;
        this.destino = destino;
        this.horarioSaida = horarioSaida;
        this.horarioEstimadoChegada = horarioEstimadoChegada;
        
        /*Assentos marcados como 'false' n�o est�o ocupados*/
        this.assentos = new boolean[numeroAssentos];
    }
    
    public Voo(int numeroAssentos) {       
        /*Assentos marcados como 'false' n�o est�o ocupados*/
        this.assentos = new boolean[numeroAssentos];
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public ZonedDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(ZonedDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public ZonedDateTime getHorarioEstimadoChegada() {
        return horarioEstimadoChegada;
    }

    public void setHorarioEstimadoChegada(ZonedDateTime horarioEstimadoChegada) {
        this.horarioEstimadoChegada = horarioEstimadoChegada;
    }
    
    public void marcarAssento(int id) throws AssentoInvalidoException, AssentoJaMarcadoException {
        if (id>=0 && id < this.assentos.length) {
            if (this.assentos[id] == false) {
                this.assentos[id] = true;
            } else {
                throw new AssentoJaMarcadoException(id);
            }
        } else {
            throw new AssentoInvalidoException(id);
        }
    }
    
    public void desmarcarAssento(int id) throws AssentoInvalidoException {
        if (id>=0 && id < this.assentos.length) {
            this.assentos[id] = false;
        } else {
            throw new AssentoInvalidoException(id);
        }
    }
    
    /**
     * A ASSINATURA DO M�TODO DEVE SER MANTIDA.
     * 
     * Este m�todo deve testar a igualdade do objeto corrente (this) com outro
     * objeto informado como par�metro e retornar 'true' somente se as seguintes
     * condi��es forem atingidas: 
     * - O par�metro deve ser do tipo Voo
     * 
     * - Todos os atributos a seguir (E SOMENTE ELES) devem ser iguais: 
     * 'origem', 'destino' e 'horarioSaida'. Voc� N�O PRECISA testar a igualdade 
     * do atributo 'horarioEstimadoChegada'
     * 
     * N�o esquecer de testar potenciais condi��es de NullPointerException.
     */
    @Override
    public boolean equals(Object obj) {
        //TODO Implementar seguindo os coment�rios do m�todo e n�o alterar a assinatura do mesmo
        return false;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm z");
        return String.format("Origem: %s --> Destino: %s\n  Hor�rio de sa�da: %s\n  Hor�rio de chegada: %s", 
                this.origem, this.destino, formatter.format(this.horarioSaida), formatter.format(this.horarioEstimadoChegada));
    }
}
