import java.util.Objects;

/**
 * Must return EstacionamentoExeption if car doesn't have a driver
 * Must return NullPointerExeption if car doesn't have plate
 * Must return NullPointerExeption if car doesn't have color.
 */

public class Carro {
    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    //not mess from here
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


    //not mess until here
    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }


        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        /**
         * @method build will buid the object and validade the given data by calling
         * @method verificaCorCarro
         * @method verificaMotorista
         * @method verificaPlacaCarro
         * @return a new car object if all the methods are true.
         */
        public Carro build() {
            verificaCorCarro(cor);
            verificaMotorista(motorista);
            verificaPlacaCarro(placa);
            return new Carro(motorista, placa, cor);
        }
    }

    /**
     * @method verificaMotorista is called to verify if a valid driver is given
     * @param motorista cannot be null or empty.
     * @return true if driver is a valid param.
     */
    public static boolean verificaMotorista(Motorista motorista){
        if (motorista == null){
            throw new EstacionamentoException("Carro deve ter motorista.");
        }
        return true;
    }

    /**
     * @method verificaPlacaCarro is called to verify if the given cars plate is valid
     * @param placa cannot be null or empty.
     * @return true if the plate given is valid.
     */
    public static boolean verificaPlacaCarro (String placa){
        if (placa == null){
            throw new NullPointerException();
        }else if (placa.isEmpty()){
            throw new NullPointerException();
        }
        return true;
    }

    /**
     * @method verificaCorCarro is called to verify if the given cars color is valid.
     * @param cor cannot be null.
     * @return true if the color given is valid.
     */
    public static boolean verificaCorCarro(Cor cor){
        if (cor == null){
            throw new NullPointerException();
        }
        return true;
    }
}

