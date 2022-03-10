package classesinternas;

public class ClassesInternasEstaticaTest01 {


    private String nome = "Inozuke";


    //quando vc usa static class dentro da classe interna é como se fosse uma outra classe de alto nível
    // o motivo disso seria mais por empacotamento e também coisas que as duas estão relacionada entre si
    // o comportamento dos atributos ou métodos da static class, estão relacionado diretamente a classeInterna

    static class Nested {
        String sobreNome = "javali";
        void print() {
            System.out.println(new ClassesInternasEstaticaTest01().nome + " " + sobreNome);
        }
    }


    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
