package parametrizacaocomportamento.interfaces;

import parametrizacaocomportamento.dominio.Carro;

@FunctionalInterface
public interface CarroPredicato {
    //lambdas são anonimas, são funções, elas não são atreladas a nenhuma classe, objetivo é fazer código ser mais conciso
    boolean test(Carro carro);
}
