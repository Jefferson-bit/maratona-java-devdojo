package classesinternas;

public class ClassesInternaLocalTest02 {

    //classes locais é quando vc tem uma c lasse dentro de um método

    private String nome = "Tanjiro";

    void print(final String param) {
        //modificadores de acesso da classes aceitos são apenas o final e abstract
        class ClasseLocal {
            // para atributos o modificador é sempre final, tanto declaração local tanto para passagem de atributo por parametro
            String sobreNome = "Kamado";
            public void printLocal() {
                System.out.println(nome + " " + sobreNome);
            }
        }
        // tem que ser chamado aqui, pois essa classe só vai existir enquanto o escopo do método n for finalizado
        ClasseLocal classeLocal = new ClasseLocal();
        classeLocal.printLocal();
    }

    public static void main(String[] args) {
        ClassesInternaLocalTest02 classesInternaLocalTest02 = new ClassesInternaLocalTest02();
        classesInternaLocalTest02.print("param");
    }
}
