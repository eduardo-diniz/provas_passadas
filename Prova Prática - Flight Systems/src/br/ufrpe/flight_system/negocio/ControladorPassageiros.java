package br.ufrpe.flight_system.negocio;

import java.util.List;

import br.ufrpe.flight_system.dados.IRepositorioGenerico;
import br.ufrpe.flight_system.dados.RepositorioGenerico;
import br.ufrpe.flight_system.exception.ElementoJaExisteException;
import br.ufrpe.flight_system.exception.ElementoNaoExisteException;
import br.ufrpe.flight_system.negocio.beans.Passageiro;

public class ControladorPassageiros {
    
    private IRepositorioGenerico<Passageiro> repositorioPassageiros;
    private static ControladorPassageiros instance;
    
    private ControladorPassageiros() {
        this.repositorioPassageiros = new RepositorioGenerico<>("passageiros.dat");
    }
    
    public static ControladorPassageiros getInstance() {
        if (instance == null) {
            instance = new ControladorPassageiros();
        }
        return instance;
    }

    public void inserir(Passageiro obj) throws ElementoJaExisteException {
        repositorioPassageiros.inserir(obj);
    }

    public List<Passageiro> listar() {
        return repositorioPassageiros.listar();
    }

    public void remover(Passageiro obj) throws ElementoNaoExisteException {
        // TODO Checar regra de neg�cio antes de remover passageiro
        // Um passageiro somente poder� ser removido se, e somente se, bilhetes de passagens associados a ele N�O 
    	// tiverem sido emitidos. Se j� houver bilhetes emitidos, n�o remover passageiro e levantar exce��o adequada. 
    	// A classe de exce��o DEVE SER CRIADA por voc� com mensagem apropriada.    	
    	// Lembre-se que classes de controladores podem acessar outros controladores.
        repositorioPassageiros.remover(obj);
    }

    public void atualizar(Passageiro newObj) throws ElementoNaoExisteException {
        // IMPLEMENTA��O N�O NECESS�RIA PARA ESTA AVALIA��O
        repositorioPassageiros.atualizar(newObj);
    }
    
}
