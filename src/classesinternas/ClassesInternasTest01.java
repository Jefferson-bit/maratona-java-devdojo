package classesinternas;




public class ClassesInternasTest01 {

    private String nome = "Uzui Tengen";

    //Nested Classes
    class Interna{
        public void printClasseInterna(){
            System.out.println(nome);
            //this nesse classe se referencia no contexto que a classe se encontra
            System.out.println(this);
            // pra referencia o contexto da classe externa, basta colocar o nome da classe externa . this
            System.out.println(ClassesInternasTest01.this);
        }
    }

    public static void main(String[] args) {

        ClassesInternasTest01 classesInternasTest01 = new ClassesInternasTest01();
        //referenciando completamento o caminho da classe interna
        ClassesInternasTest01.Interna interna = classesInternasTest01.new Interna();
        Interna interna1 = new ClassesInternasTest01().new Interna();
        interna.printClasseInterna();
    }
}
