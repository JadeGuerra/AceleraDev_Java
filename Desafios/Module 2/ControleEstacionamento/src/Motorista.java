import java.util.Objects;

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


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        /**
         * Deve retornar erro quando motorista não tem nome
         * expected = NullPointerException.class
         */
        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        /**
         * Deve retornar erro quando motorista não tem habilitação
         * expected = NullPointerException.class
         * Deve retornar erro quando idade negativa
         * expected = IllegalArgumentException.class
         */
        public MotoristaBuilder withIdade(int idade) {
            validaIdade(idade);
            this.idade = idade;
            return this;
        }

        /**
         * Deve retornar erro quando pontos negativos
         * expected = IllegalArgumentException.class
         * @param pontos
         * @exception IllegalArgumentException
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


        public Motorista build() {
            verificaDadosMotorista(nome, idade, pontos, habilitacao);
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }

    public static void verificaDadosMotorista (String nome, int idade, int pontos, String habilitacao){
        if (nome.trim().isEmpty() || nome == null || habilitacao.trim(). isEmpty() || habilitacao == null){
            throw new NullPointerException();
        } else if (idade < 18){
            throw new EstacionamentoException("Motorista menor de idade.");
        } else if (pontos > 20){
            throw new EstacionamentoException("Habilitação suspensa.");
        }
    }
    public static void validaIdade (int idade){
        if (idade < 0){
            throw new IllegalArgumentException();
        }
    }

    public static void validaPontos (int pontos){
        if (pontos < 0 ){
            throw new IllegalArgumentException();
        }
    }

}
