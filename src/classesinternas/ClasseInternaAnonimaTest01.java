package classesinternas;

class Animal{
    // classes anonimas são utilizadas quando queremos alterar um comportamento por um determinado momento de execução
    // evitando a criação de uma classe que não precisaremos reutilizar
    public void andar(){
        System.out.println("Animal andando");
    }
}

public class ClasseInternaAnonimaTest01 {

    public static void main(String[] args) {
        Animal animal = new Animal(){
            //parece que estamo instanciando a classe animal, mas na verdade internamento estamos criando uma subclasse de animal
            // se vc de ctrl + o(INTELLIJ) vai aparecer pra sobrescrever o método anda

            @Override
            public void andar() {
                System.out.println("andando na sombra");
            }
        };

        animal.andar();
    }
}
