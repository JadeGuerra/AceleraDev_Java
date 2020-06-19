/**
 * Automatizar a criptografia e descriptografia
 * com base na cifra césar com chave padrão (3)
 */
public class CriptografiaCesariana implements Criptografia {

    /**
     * @criptografar sobrescreve o método em superclasse @Criptografia
     * @encodeText retorna o texto criptografado
     * @key chave padrão césar
     */

    @Override
    public String criptografar(String texto) {// not mess
        //@criptText inicializa
        String encodeText = "";
        //@key chave padrão césar
        int key = 3;

        //recebe o texto por caracteres e encripta
        for (int i = 0; i < texto.length(); i++) {
            //chama @encriptar para encriptar o caracter e controi o texto
            //criptografado
            encodeText += encriptar(texto.charAt(i), key);
        }

        //retorna @encodeText criptografado
        return encodeText;
    }

    /**
     * @encriptar método para criptografar o caracter do texto
     * recebe @key e @textChar de @Criptografar
     */

    //encripta os caracteres do texto
    private static char encriptar(char textChar, int key) {//not mess
        //declara @encodeChar
        char encodeChar;

        //encripta as minúsculas
        if (textChar >= 97 && textChar <= 122) {
            encodeChar = (char) ((textChar - 97 + key) % 26 + 97);
        }
        //encripta as maiúsculas
        else if (textChar >= 65 && textChar <= 90) {
            encodeChar = (char) ((textChar - 65 + key) % 26 + 65);
        }
        //escape de caracteres
        else {
            encodeChar = textChar;
        }

        //@encodeChar retorna o caracter encriptado
        return encodeChar;
    }

    /**
     * @descriptografar sobrescreve o método em superclasse @criptografia
     * @decodeText retorna o texto criptografado
     * @key chave padrão césar
     */

    @Override
    public String descriptografar(String texto) {
        //@decodeText inicializa
        String decodeText = "";
        //@key chave padrão césar
        int key = 3;

        //recebe o texto por caracteres e encripta
        for (int i = 0; i < texto.length(); i++) {
            //chama @decriptar para descriptografar o caracter e controi o texto
            //criptografado
            decodeText += decriptar(texto.charAt(i), key);
        }

        //retorna @decodeText descriptografado
        return decodeText;
    }

    /**
     * @decriptar método para criptografar o caracter do texto
     * recebe @key e @textChar de @descriptografar
     */

    private static char decriptar(char textChar, int key) {
        //declara @decodeChar
        char decodeChar;

        //decripta as minúsculas
        if (textChar >= 97 && textChar <= 122) {
            decodeChar = (char) ((textChar - 97 - key) % 26 + 97);
        }
        //decripta as maiúsculas
        else if (textChar >= 65 && textChar <= 90) {
            decodeChar = (char) ((textChar - 65 - key) % 26 + 65);
        }
        //escape de caracteres
        else {
            decodeChar = textChar;
        }

        //@decodeChar retorna o caracter decriptado
        return decodeChar;
    }

}