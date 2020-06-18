import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Escreva o texto: ");
        String texto = s.nextLine();

        CriptografiaCesariana criptografar = new criptografar (texto);


        System.out.println(criptografar);
    }

}
