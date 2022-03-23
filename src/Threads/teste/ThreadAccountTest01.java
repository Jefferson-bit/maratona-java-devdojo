package Threads.teste;

import Threads.dominio.Account;

public class ThreadAccountTest01 implements Runnable {

    private Account account = new Account();

    public static void main(String[] args) {

        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01, "Hestia");
        Thread t2 = new Thread(threadAccountTest01, "Bell Cranel");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawalLinhaDeCodigo(10);
            if (account.getBalance() < 0) {
                System.out.println("FODEO");
            }
        }
    }


    private void withdrawal(int amount) {
        if (account.getBalance() >= amount) {
            // existe um problema aqui. Temos duas threads. t1 e t2, o problema é que como não temos garantia de nada
            // não sabemos qual das thread vai executar primeiro. O lance é aqui é q t1 e t2 podem entrar no
            // if pq digamos q t1 entro no if, o saldo é 10 e t2 tbm entro no if e o saldo é 10
            // t1 executa, deixa saldo zero, porém t2 tbm está dentro da condição. O saldo vai ficar negativo
            // isso ocorre pq duas threads estão acesando ao mesmo tempo o mesmo objeto
            System.out.println(getThreadName() + " está indo sacar dinheiro");
            account.withdrawal(amount);
            System.out.println(getThreadName() + " completou o saque, valor atual da conta " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
        }
    }

    //a palavra synchronized significa que nenhuma outra thread vai pode executar ela
    // se t1 executo primeiro, t1 vai finalizar a execução, t2 não entra no escopo
    // isso é garantido pq temos o loook dos objetos, uma chave basicamente
    // sleep não solta o look. O código está bloqueado somente pra thread que executar
    private synchronized void withdrawalSemParalelismo(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(getThreadName() + " está indo sacar dinheiro");
            account.withdrawal(amount);
            System.out.println(getThreadName() + " completou o saque, valor atual da conta " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
        }
    }

    private synchronized void withdrawalLinhaDeCodigo(int amount) {
        //sempre coloque a declaração como final. se outra pessoa instanciar outra account em memória
        // você está dando o look em quem?
        // poor isso é de suma importancia usar o final accout = new Account() erro de compilação
        System.out.println(getThreadName() + " ######################### fora do synchronized");
        synchronized (account) {
            System.out.println(getThreadName() + "****************** Dentro do synchronized");
            if (account.getBalance() >= amount) {
                System.out.println(getThreadName() + " está indo sacar dinheiro");
                account.withdrawal(amount);
                System.out.println(getThreadName() + " completou o saque, valor atual da conta " + account.getBalance());
            } else {
                System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
            }
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }
}
