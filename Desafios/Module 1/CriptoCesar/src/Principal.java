import java.util.Scanner;

public class Principal {//all mine

    public static void main(String[] args) {

        System.out.println("Cifra de César");

        Scanner s = new Scanner(System.in);
        System.out.print("Escreva o texto: ");
        String texto = s.nextLine();
        System.out.println("Para criptografar digite 1 ");
        System.out.println("Para descriptografar digite 2 ");
        byte definicao = s.nextByte();
        Criptografia criptografia = new CriptografiaCesariana();

        if (definicao == 1 ) {
            String criptografado = criptografia.criptografar(texto);
            System.out.println(criptografado);
        }else if (definicao == 2){
            String descriptografado = criptografia.descriptografar(texto);
            System.out.println(descriptografado);
        } else {
            System.out.println("Nenhuma ação selecionada");
        }

    }


}