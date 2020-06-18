/**
 * Faça um método @Desafio("Fibonacci") que retorne
 * uma lista java.util.List com os primeiro números
 * Integer da série de Fibonacci até passar de 350.
 * Faça um segundo método @Desafio("isFibonnaci")
 * que recebe um Integer como parâmetro e retorne
 * Boolean. Caso o número recebido por
 * parâmetro esteja entre os números da sequência de Fibonnaci
 * do @Desafio("Fibonnaci") retorne true, senão, false.
 **/

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o número para consultar: ");
        int a = s.nextInt();
        FibClass fibClass = new FibClass();
        //Testa e escreve mensagem
        //implemente teste
        if( fibClass.isFibonacci(a) ){
            System.out.println("Este número está em Fibonacci.");
        } else {
            System.out.println("Este número não está na Fibonacci.");
        }

    }
}
