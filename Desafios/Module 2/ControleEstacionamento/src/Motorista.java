import java.util.Objects;
/**
 * Must return NullPointerException if the driver doesn't have a name.
 * Must return NullPointerException if the driver doesn't have a driver's licence.
 * Must return IllegalArgumentException if the drivers age is negative.
 * Must return IllegalArgumentException if driver's licence points are negative.
 */

public class Motorista {
    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    //not mess from here
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }

    //not mess until here
    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }


        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }


        /**
         * @method validaIdade is called to validate the given drivers age
         * @param idade cannot be negative
         */
        public MotoristaBuilder withIdade(int idade) {
            validaIdade(idade);
            this.idade = idade;
            return this;
        }


        /**
         * @method validaPontos is calld to validate given drivers licence points.
         * @param pontos cannot be negative
         */
        public MotoristaBuilder withPontos(int pontos) {
            validaPontos(pontos);
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            return this;
        }


        /**
         * @method verificaDadosMotorista will validate the given drivers data
         * @return a new Motorista object if all data are inside the required params.
         */
        public Motorista build() {
            verificaDadosMotorista(nome, idade, pontos, habilitacao);
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }

    /**
     * @method verificaDadosMotorista will validate the given params
     * @param nome drivers name cannot be empty or null
     * @param idade drivers age cannot be under 18 years old
     * @param pontos drivers licence points cannot be above 20
     * @param habilitacao drivers licence cannot be empty or null
     *
     * If any given param are outside the code requirements, will return the required exeption.
     * @exception NullPointerException
     * @exception EstacionamentoException
     */
    public static void verificaDadosMotorista (String nome, int idade, int pontos, String habilitacao){
        if (nome.trim().isEmpty() || nome == null || habilitacao.trim(). isEmpty() || habilitacao == null){
            throw new NullPointerException();
        } else if (idade < 18){
            throw new EstacionamentoException("Motorista menor de idade.");
        } else if (pontos > 20){
            throw new EstacionamentoException("Habilitação suspensa.");
        }
    }

    /**
     * @method validaIdade will validate given drivers age
     * @param idade cannot be negative
     * @exception IllegalArgumentException
     */
    public static void validaIdade (int idade){
        if (idade < 0){
            throw new IllegalArgumentException();
        }
    }

    /**
     * @method validaPontos will validate given drivers licence points
     * @param pontos cannot be negative
     * @exception IllegalArgumentException
     */
    public static void validaPontos (int pontos){
        if (pontos < 0 ){
            throw new IllegalArgumentException();
        }
    }

}
