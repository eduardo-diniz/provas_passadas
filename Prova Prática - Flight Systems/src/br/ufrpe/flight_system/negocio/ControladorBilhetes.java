package br.ufrpe.flight_system.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.flight_system.dados.IRepositorioGenerico;
import br.ufrpe.flight_system.dados.RepositorioGenerico;
import br.ufrpe.flight_system.exception.AssentoInvalidoException;
import br.ufrpe.flight_system.exception.AssentoJaMarcadoException;
import br.ufrpe.flight_system.exception.ElementoJaExisteException;
import br.ufrpe.flight_system.exception.ElementoNaoExisteException;
import br.ufrpe.flight_system.negocio.beans.Bilhete;
import br.ufrpe.flight_system.negocio.beans.Passageiro;
import br.ufrpe.flight_system.negocio.beans.Voo;

public class ControladorBilhetes {
    
    private IRepositorioGenerico<Bilhete> repositorioBilhetes;
    private static ControladorBilhetes instance;
    
    private ControladorBilhetes() {
        this.repositorioBilhetes = new RepositorioGenerico<>("bilhetes.dat");
    }
    
    public static ControladorBilhetes getInstance() {
        if (instance == null) {
            instance = new ControladorBilhetes();
        }
        return instance;
    }

    public Bilhete emitirBilhete(Passageiro p, Voo v, int idAssento) 
            throws ElementoJaExisteException, AssentoInvalidoException, AssentoJaMarcadoException {
        // TODO Escrever regra de neg�cio a seguir antes de inserir bilhete no reposit�rio
        // 1) Um bilhete s� pode ser vendido para um voo cuja data de sa�da � posterior a data corrente
        // 2) Somente um bilhete pode ser emitido por assento
        // 3) O passageiro precisa pelo menos um documento de identifica��o (CPF ou passaporte) v�lido
        // 4) Lembre-se de marcar o assento no voo quando for vendido 
        // 5) Lembre-se de considerar os potenciais NullPointerException
        Bilhete b = null;
        // INSERIR SEU C�DIGO COM A REGRA DE NEG�CIO CRIANDO O OBJECTO b DO BILHETE
        repositorioBilhetes.inserir(b);
        
        return b;
    }

    public List<Bilhete> listar() {
        return repositorioBilhetes.listar();
    }

    public void remover(Bilhete obj) throws ElementoNaoExisteException {
        // TODO Escrever regra de neg�cio a seguir antes de remover bilhete do reposit�rio
        // 1) Um bilhete s� pode ser removido se o voo ainda n�o partiu, baseado
        // na data de hoje
        // 2) Ao remover um bilhete, o assento do voo do qual ele se referia
        // deve ser desmarcado e o objeto do voo deve ser salvo novamente no reposit�rio de voos
        // 3) Levante poss�veis exce��es se o bilhete n�o puder ser removido 
        repositorioBilhetes.remover(obj);
    }

    public void atualizar(Bilhete bilheteEmitido, int novoAssento) 
            throws ElementoNaoExisteException, ElementoJaExisteException {
        // IMPLEMENTA��O N�O NECESS�RIA PARA ESTA AVALIA��O 
        // Escrever regra de neg�cio a seguir antes de atualizar o bilhete no reposit�rio
        // Um bilhete somente pode ter o seu assento alterado.
        // Voc� deve verificar se o 'novoAssento' a ser alterado no
        // 'bilheteEmitido' j� est� ocupado no mesmo Voo, antes de atualizar o 
        // bilhete. Se o assento j� estiver ocupado, voc� deve lan�ar a exce��o 
        // correspondente (se necess�rio, crie outra exce��o)       
        
        // C�digo a seguir n�o precisa ser alterado
        repositorioBilhetes.remover(bilheteEmitido);
        bilheteEmitido.setIdAssento(novoAssento);
        repositorioBilhetes.inserir(bilheteEmitido);
    }
    
    public List<Bilhete> listarBilhetesPorVoo(Voo v) {
        // TODO Implemente este m�todo de acordo com as regras a seguir
        // Voc� deve retornar uma lista de Bilhetes emitidos para o pvoo
        // informado como par�metro.
        return new ArrayList<Bilhete>();
    }

}
