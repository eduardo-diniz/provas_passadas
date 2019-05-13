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
        //TODO Implementar regra de negócio a seguir
        // Um voo somente poderá ser adicionado se sua data/hora de saída
        // for anterior a sua data/hora estimada de chegada. Além disso, a sua
        // data/hora de saída não pode ser anterior a data/hora corrente
    	ZonedDateTime horaAtual = ZonedDateTime.now();
    	
    	if (obj.getHorarioSaida().isAfter(obj.getHorarioEstimadoChegada()) ) {
    		
    		if(horaAtual.isAfter(obj.getHorarioSaida())) {
    			
    			repositorioVoos.inserir(obj);
    			
    		}
    		
    	}else {
    		
    		VooInvalidoException vooInv = new VooInvalidoException(obj);
    		
    		throw vooInv;
    	}
        
        // OBSERVAÇÃO: se necessário, crie e arremesse uma exceção para manipular 
        // essa situação de tentar inserir um voo inválido e atualize o método 
        // que invoca este método para tratar a exceção e apresentar mensagem 
        // de erro para o usuário.
        
    }

    public List<Voo> listar() {
        return repositorioVoos.listar();
    }

    public void remover(Voo obj) throws ElementoNaoExisteException {
        // TODO Implementar regra de negócio a seguir
        // Um voo só pode ser removido se não houver bilhetes emitidos, ou seja
        // vendidos, para o mesmo. OBSERVAÇÃO: se necessário, crie e arremesse
        // uma exceção para manipular essa situação de tentar remover um voo 
        // com bilhetes emitidos para ele e atualize o método que invoca este 
        // método para tratar a exceção e apresentar mensagem de erro para o usuário.
        repositorioVoos.remover(obj);
    }

    public void atualizar(Voo newObj) throws ElementoNaoExisteException {
        // IMPLEMENTAÇÃO NÃO NECESSÁRIA PARA ESTA AVALIAÇÃO
        // Implementar regra de negócio a seguir        
        // Um voo só pode ter atualizada a sua data/hora estimada de chegada.
        // Um voo só pode ser atualizado se sua data/hora estimada de chegada 
        // for posterior a sua data/hora de saída
        repositorioVoos.atualizar(newObj);
    }
    
    public List<Voo> listarVoosQuePassamPorCidade(Cidade origemOuDestino) {
        // IMPLEMENTAÇÃO NÃO NECESSÁRIA PARA ESTA AVALIAÇÃO
        // Implemente este método de acordo com as regras a seguir
        // Você deve retornar uma lista de voos, cuja cidade de origem ou
        // destino seja igual à cidade informada como parâmetro
        return null;
    }
    
}
