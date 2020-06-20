/**
 * Automatizar a criptografia e descriptografia
 * com base na cifra césar com chave padrão (3)
 * deve Converter Caracteres Para Minusculo Na Criptografia
 * deve Converter Caracteres Para Minusculo Na Descriptografia
 * deve Manter Os Numeros Na Criptografia
 * deve Retornar Erro Quando Criptografa Texto Vazio
 * deve Retornar Erro Quando DesCriptografa Texto Vazio
 */

public class CriptografiaCesariana implements Criptografia {

    /**
     * @criptografar sobrescreve o método em superclasse @Criptografia
     * @encodeText retorna o texto criptografado
     * @key chave padrão césar
     */

    @Override
    public String criptografar(String texto) {
        //@validate retorna o erro quando necessário
        validate(texto);
        //@criptText inicializa
        String encodeText = "";
        //@key chave padrão césar
        int key = 3;
        //converte o texto em minusculas
        texto = texto.toLowerCase();

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

    private static char encriptar(char textChar, int key) {
        //declara @encodeChar
        char encodeChar;

        //encripta as minúsculas
        if (textChar >= 97 && textChar <= 122) {
            encodeChar = (char) ((textChar - 97 + key) % 26 + 97);
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
        //@validate retorna o erro quando necessário
        validate(texto);
        //@decodeText inicializa
        String decodeText = "";
        //@key chave padrão césar
        int key = 3;
        //converte o texto em minusculas
        texto = texto.toLowerCase();

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
            //@chave recebe posição da letra
            int chave = (textChar - 97 - key) % 26 + 97;
            if (chave < 97){
                chave += 26 ;
            }
            decodeChar = (char) (chave);
        }

        //escape de caracteres
        else {
            decodeChar = textChar;
        }

        //@decodeChar retorna o caracter decriptado
        return decodeChar;
    }



    private void validate(String texto) {

        if (texto == null) {

            throw new NullPointerException();

        } else if (texto.trim().equals("")) {

            throw new IllegalArgumentException();

        }

    }
}

