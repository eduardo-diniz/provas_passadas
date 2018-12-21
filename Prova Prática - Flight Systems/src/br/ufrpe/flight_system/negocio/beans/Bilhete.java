package br.ufrpe.flight_system.negocio.beans;

import java.io.Serializable;

import br.ufrpe.flight_system.exception.AssentoInvalidoException;
import br.ufrpe.flight_system.exception.AssentoJaMarcadoException;

public class Bilhete implements Serializable {
    
	private static final long serialVersionUID = 5755776115799918803L;
	
	private Passageiro passageiro;
    private Voo voo;
    private int idAssento;
    
    /**
     * Uma vez emitido o bilhete, somente o idAssento poder� ser alterado. Se 
     * for necess�rio qualquer altera��o no passageiro ou no voo, o bilhete 
     * precisar� ser cancelado e emitido novamente.
     * 
     * @param passageiro
     * @param voo
     * @param idAssento
     * @throws AssentoInvalidoException
     * @throws AssentoJaMarcadoException
     */
    public Bilhete(Passageiro passageiro, Voo voo, int idAssento) 
            throws AssentoInvalidoException, AssentoJaMarcadoException {
        if (passageiro == null || voo == null || idAssento < 0) {
            throw new IllegalArgumentException();
        }
        this.passageiro = passageiro;
        this.voo = voo;
        this.idAssento = idAssento;
        
        this.voo.marcarAssento(idAssento);
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Voo getVoo() {
        return voo;
    }
    
    public String getPassageiroNome() {
        return passageiro.getNome();
    }

    public String getPassageiroUltimoNome() {
        return passageiro.getUltimoNome();
    }

    public String getPassageiroPassaporte() {
        return passageiro.getPassaporte();
    }

    public String getPassageiroCpf() {
        return passageiro.getCpf();
    }

    /**
     * A ASSINATURA DO M�TODO DEVE SER MANTIDA.
     * 
     * Este m�todo deve testar a igualdade do objeto corrente (this) com outro
     * objeto informado como par�metro e retornar 'true' somente se as seguintes
     * condi��es forem atingidas: 
     * - O par�metro deve ser do tipo Bilhete
     * 
     * - Todos os atributos dever�o ser considerados na compara��o, isto �, um 
     * objeto do tipo Bilhete somente ser� igual a outro se este outro for do 
     * tipo Bilhete tamb�m e os valores dos atributos passageiro, voo e 
     * idAssento forem iguais.  
     * 
     * N�o esquecer de testar potenciais condi��es de NullPointerException.
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Implementar seguindo os coment�rios do m�todo e n�o alterar a assinatura do mesmo
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("Passageiro: %s\nVoo: %s\nAssento: %d", this.passageiro, this.voo, this.idAssento);
    }
}
