import java.util.*;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {


    }

    @Override
    public String descriptografar(String texto) {

        //@texto recebe texto
        String texto = texto.toLowerCase();
        //@charText converte texto em array de char
        char[] charText = texto.toCharArray();

        //chave da criptografia é 3, chave padrão césar
        int key = 3;

        //@cifred recebe o texto cifrado
        StringBuilder cifred = new StringBuilder();

        //inicia i, compara com tamanho de @chatText, incrementa i
        for (int i = 0; i < charText.length; i++){

                }
}

