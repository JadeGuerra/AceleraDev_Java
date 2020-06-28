import java.util.ArrayList;
import java.util.List;

/**
 * O número de vagas do estacionamento são de dez carros.
 * Para cada carro que entra no sistema é necessário informar a sua placa, cor além das informações do motorista.
 * Para entrar no estacionamento, é necessário que exista um motorista, ou seja, nada de carro autônomo.
 * O motorista precisa ter idade suficiente para dirigir e possuir uma habilitação.
 * A habilitação não deverá está suspensa, ou seja, a pontuação da carteira de motorista
 * não deverá ser superior a vinte pontos.
 * O estacionamento não deverá comportar o número superior de vagas.
 * Caso o estacionamento esteja lotado:
 *
 * Chegue mais um novo carro, o primeiro que estacionou deverá sair
 * Caso o motorista do primeiro carro estacionado tenha uma idade superior a 55 anos,
 * será escolhido o próximo motorista abaixo dos 55 anos.
 * Caso todos os motoristas, dentro do estacionamento, tenham mais de 55 anos e chegue um motorista,
 * ele não conseguirá estacionar.
 */
public class Estacionamento {
    int limiteDeVagas = 10;
    List<Carro> listaCarrosEstacionados = new ArrayList<>(limiteDeVagas);

    public void estacionar(Carro carro) {
        if (verificaSePodeEstacionar()){
            listaCarrosEstacionados.add(carro);
        } else {
            estacionarSenior(carro);
        }
    }

    public int carrosEstacionados() {
        return listaCarrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return listaCarrosEstacionados.contains(carro);
    }

    private int verificaVagasRestantes (){
        return  limiteDeVagas - carrosEstacionados();
    }

    private boolean verificaSePodeEstacionar (){
        if (verificaVagasRestantes() >= limiteDeVagas){
            return false;
        }
        return true;
    }

    private void estacionarSenior (Carro carro) {
        for (int i = 0; i < carrosEstacionados(); i++){

            if(listaCarrosEstacionados.get(i).getMotorista().getIdade() < 55){
                listaCarrosEstacionados.remove(i);
                listaCarrosEstacionados.add(carro);
                return;
            }
        }
        throw  new EstacionamentoException("Estacionamento lotado.");
    }
}
