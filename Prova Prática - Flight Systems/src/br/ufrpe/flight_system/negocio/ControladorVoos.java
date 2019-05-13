package br.ufrpe.flight_system.negocio;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import br.ufrpe.flight_system.dados.IRepositorioGenerico;
import br.ufrpe.flight_system.dados.RepositorioGenerico;
import br.ufrpe.flight_system.exception.ElementoJaExisteException;
import br.ufrpe.flight_system.exception.ElementoNaoExisteException;
import br.ufrpe.flight_system.exception.VooInvalidoException;
import br.ufrpe.flight_system.negocio.beans.Cidade;
import br.ufrpe.flight_system.negocio.beans.Voo;

public class ControladorVoos {
    
    private IRepositorioGenerico<Voo> repositorioVoos;
    private static ControladorVoos instance;
    
    private ControladorVoos() {
        this.repositorioVoos = new RepositorioGenerico<>("voos.dat");
    }

    public static ControladorVoos getInstance() {
        if (instance == null) {
            instance = new ControladorVoos();
        }
        return instance;
    }

    public void inserir(Voo obj) throws ElementoJaExisteException , VooInvalidoException {
        //TODO Implementar regra de neg�cio a seguir
        // Um voo somente poder� ser adicionado se sua data/hora de sa�da
        // for anterior a sua data/hora estimada de chegada. Al�m disso, a sua
        // data/hora de sa�da n�o pode ser anterior a data/hora corrente
    	ZonedDateTime horaAtual = ZonedDateTime.now();
    	
    	if (obj.getHorarioSaida().isAfter(obj.getHorarioEstimadoChegada()) ) {
    		
    		if(horaAtual.isAfter(obj.getHorarioSaida())) {
    			
    			repositorioVoos.inserir(obj);
    			
    		}
    		
    	}else {
    		
    		VooInvalidoException vooInv = new VooInvalidoException(obj);
    		
    		throw vooInv;
    	}
        
        // OBSERVA��O: se necess�rio, crie e arremesse uma exce��o para manipular 
        // essa situa��o de tentar inserir um voo inv�lido e atualize o m�todo 
        // que invoca este m�todo para tratar a exce��o e apresentar mensagem 
        // de erro para o usu�rio.
        
    }

    public List<Voo> listar() {
        return repositorioVoos.listar();
    }

    public void remover(Voo obj) throws ElementoNaoExisteException {
        // TODO Implementar regra de neg�cio a seguir
        // Um voo s� pode ser removido se n�o houver bilhetes emitidos, ou seja
        // vendidos, para o mesmo. OBSERVA��O: se necess�rio, crie e arremesse
        // uma exce��o para manipular essa situa��o de tentar remover um voo 
        // com bilhetes emitidos para ele e atualize o m�todo que invoca este 
        // m�todo para tratar a exce��o e apresentar mensagem de erro para o usu�rio.
        repositorioVoos.remover(obj);
    }

    public void atualizar(Voo newObj) throws ElementoNaoExisteException {
        // IMPLEMENTA��O N�O NECESS�RIA PARA ESTA AVALIA��O
        // Implementar regra de neg�cio a seguir        
        // Um voo s� pode ter atualizada a sua data/hora estimada de chegada.
        // Um voo s� pode ser atualizado se sua data/hora estimada de chegada 
        // for posterior a sua data/hora de sa�da
        repositorioVoos.atualizar(newObj);
    }
    
    public List<Voo> listarVoosQuePassamPorCidade(Cidade origemOuDestino) {
        // IMPLEMENTA��O N�O NECESS�RIA PARA ESTA AVALIA��O
        // Implemente este m�todo de acordo com as regras a seguir
        // Voc� deve retornar uma lista de voos, cuja cidade de origem ou
        // destino seja igual � cidade informada como par�metro
        return null;
    }
    
}
