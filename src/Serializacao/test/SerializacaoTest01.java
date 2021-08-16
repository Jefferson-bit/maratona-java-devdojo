package Serializacao.test;

import Serializacao.dominio.Aluno;
import Serializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {

    public static void main(String[] args) {
        Aluno aluno = new Aluno(1L, "Jefferson", "124354342");
        Turma turma = new Turma("Maratona java DevDojo");
        aluno.setTurma(turma);

        serializar(aluno);
        deserializar();

    }


    private static void serializar(Aluno aluno){
        Path path = Paths.get("pasta/aluno.ser");

        try(ObjectOutputStream oob = new ObjectOutputStream(Files.newOutputStream(path))){
            oob.writeObject(aluno);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void deserializar(){
        Path path = Paths.get("pasta/aluno.ser");

        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            Aluno aluno =  (Aluno) ois.readObject();
            //quando estamos deserializando algum objeto, o construtor não é chamado. Isso fica um pouco mais complicado
            //quando trabalhamos com herança
            System.out.println(aluno);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
