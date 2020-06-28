import java.util.Objects;

public class Carro {
    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        /**
         * Deve retornar erro quando o carro é autônomo
         * expected = EstacionamentoException
         * @param motorista
         * @return
         */
        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        /**
         * Deve retornar erro quando carro não tem placa
         * expected = NullPointerException
         * @param placa
         * @method verificaPlacaCarro
         * @exception NullPointerException
         */
        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        /**
         * Deve retornar erro quando carro não tem cor
         * expected = NullPointerException
         * @param cor
         * @return
         */
        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            verificaCorCarro(cor);
            verificaMotorista(motorista);
            verificaPlacaCarro(placa);
            return new Carro(motorista, placa, cor);
        }
    }

    public static boolean verificaMotorista(Motorista motorista){
        if (motorista == null){
            throw new EstacionamentoException("Carro deve ter motorista.");
        }
        return true;
    }

    public static boolean verificaPlacaCarro (String placa){
        if (placa == null){
            throw new NullPointerException();
        }else if (placa.isEmpty()){
            throw new NullPointerException();
        }
        return true;
    }

    public static boolean verificaCorCarro(Cor cor){
        if (cor == null){
            throw new NullPointerException();
        }
        return true;
    }
}

