import java.util.Scanner;

public class Principal {//all mine

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Escreva o texto: ");
        String texto = s.nextLine();
        System.out.

        Criptografia criptografia = new CriptografiaCesariana();
        String criptografado = criptografia.criptografar(texto);
        String descriptografado = criptografia.descriptografar(texto);
        System.out.println();

}
