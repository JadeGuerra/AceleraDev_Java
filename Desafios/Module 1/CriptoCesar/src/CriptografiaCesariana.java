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
    //declaracao das constantes da classe
    
    //@chave chave padrão césar
    private static final int chave = 3;
    
    //@tamanho_alfabeto recebe o tamanho do alfabeto
    private static final int tamanho_alfabeto = 26;

    //@letra_a recebe posicao letra a em ascii
    private static final int letra_a = 97;
    
    //@letra_z recebe posicao letra z em ascii
    private static final int letra_z = 122;


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

        //encripta as minúsculas
        if (textChar < letra_a || textChar > letra_z) {
                return textChar;
            }

            return (char) ((textChar - letra_a + chave) % tamanho_alfabeto + letra_a);
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
        if (textChar < letra_a || textChar > letra_z) {
            return textChar;
        }

        int posicao = (textChar - letra_a - chave) % tamanho_alfabeto + letra_a;
        if (posicao < letra_a){
            posicao += tamanho_alfabeto ;
        }
        return (char) (posicao);
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