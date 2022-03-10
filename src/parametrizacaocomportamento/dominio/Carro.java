package parametrizacaocomportamento.dominio;

public class Carro {

    private String nome = "Audi";
    private String cor;
    private int ano;


    public Carro(String cor, int ano) {
        this.cor = cor;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                '}';
    }
}
