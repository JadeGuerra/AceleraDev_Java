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
    //declaracao de objetos da classe
    
    //@chave chave padrão césar
    private static int chave = 3;
    
    //@modulo recebe o valor que deve calcular modulo
    private static int modulo = 26 + 97;



    /**
     * @criptografar sobrescreve o método em superclasse @Criptografia
     * @encodeText retorna o texto criptografado
     */

    @Override
    public String criptografar(String texto) {
        //@validate retorna o erro quando necessário
        validacao(texto);
        //@criptText inicializa
        String encodeText = "";
        
        //converte o texto em minusculas
        texto = texto.toLowerCase();

        //recebe o texto por caracteres e encripta
        for (int i = 0; i < texto.length(); i++) {
            //chama @encriptar para encriptar o caracter e controi o texto
            //criptografado
            encodeText += encriptar(texto.charAt(i), chave);
        }

        //retorna @encodeText criptografado
        return encodeText;
    }

    /**
     * @encriptar método para criptografar o caracter do texto
     * recebe @chave e @textChar de @Criptografar
     */

    private static char encriptar(char textChar, int chave) {
        //declara @encodeChar
        char encodeChar;       
        

        //encripta as minúsculas
        if (textChar >= 97 && textChar <= 122) {
            encodeChar = (char) ((textChar - 97 + chave) % modulo);
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
     */

    @Override
    public String descriptografar(String texto) {
        //@validate retorna o erro quando necessário
        validacao(texto);
        //@decodeText inicializa
        String decodeText = "";
        //@chave chave padrão césar
        int chave = 3;
        //converte o texto em minusculas
        texto = texto.toLowerCase();

        //recebe o texto por caracteres e encripta
        for (int i = 0; i < texto.length(); i++) {
            //chama @decriptar para descriptografar o caracter e controi o texto
            //criptografado
            decodeText += decriptar(texto.charAt(i), chave);
        }

        //retorna @decodeText descriptografado
        return decodeText;
    }

    /**
     * @decriptar método para criptografar o caracter do texto
     * recebe @chave e @textChar de @descriptografar
     */

    private static char decriptar(char textChar, int chave) {
        //declara @decodeChar
        char decodeChar;

        //decripta as minúsculas
        if (textChar >= 97 && textChar <= 122) {
            //@posicao recebe posição da letra
            int posicao = (textChar - 97 - chave) % modulo;
            //trata a posição para fazer a volta
            if (posicao < 97){
                posicao += 26 ;
            }
            //@decodeChar recebe o char da posicao certa
            decodeChar = (char) (posicao);
        }

        //escape de caracteres
        else {
            //@decodeChar recebe o valor do char
            decodeChar = textChar;
        }

        //@decodeChar retorna o caracter decriptado
        return decodeChar;
    }



    /**
    * @validacao vai fazer o retorno do erro
    * quando o texto estiver vazio
    */
    
    private void validacao(String texto) {

        //se texto retornar nulo
        if (texto == null) {

            throw new NullPointerException();

        } 
        //se texto estiver vazio
        else if (texto.isEmpty()) {

            throw new IllegalArgumentException();

        }

    }
}