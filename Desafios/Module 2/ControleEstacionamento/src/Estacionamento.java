import java.util.ArrayList;
import java.util.List;

/**
 * The number of parking spaces is 10 cars.
 * For each car that enters the system it is necessary to inform its
 * license plate, color in addition to the driver's information.
 * To enter the parking lot it is necessary that there is a driver, that is, no autonomous car.
 * The driver needs to be old enough to drive, in Brazil the minimum age required is 18 ears old.
 * The driver needs to have a drivers licence.
 * The drivers licence cannot be suspended, at Brazil, if the drivers licence has more than 20 points,
 * the drivers licence is suspended.
 * Parking must not contain more spaces than the limit.
 * If the parking lot is full:
 *
 * If a new car arrives, the first one that parked should leave.
 * If the driver of the first car is over the age of 55, the next driver under 55 years old should leave.
 * If all drivers inside the parking lot are over 55years old and another driver arrives, he will not
 * be able to park.
 */
public class Estacionamento {
    int limiteDeVagas = 10;
    List<Carro> listaCarrosEstacionados = new ArrayList<>(limiteDeVagas);

    /**
     * @method estacionar is called when there is a car to park.
     * @method verificaSePodeEstacionar will check if there is a parking spot available. If that is,
     * @param carro is added to the end of listaCarrosEstacionados.
     * @method estacionarSenior is called if the parking lot if full.
     */
    public void estacionar(Carro carro) {
        if (verificarSePodeEstacionar()){
            listaCarrosEstacionados.add(carro);
        } else {
            estacionarSenior(carro);
        }
    }

    /**
     * @method carrosEstacionados is called when we have to kow how many cars are at the parking lot.
     * @return the number of parking cars at the parking lot.
     */
    public int carrosEstacionados() {
        return listaCarrosEstacionados.size();
    }

    /**
     * @method carroEstacionado is called when we need to know if an specific car is at the parking lot.
     * @param carro is the car we want to consult if it is parked.
     * @return true if the car is in the parking lot.
     */
    public boolean carroEstacionado(Carro carro) {
        return listaCarrosEstacionados.contains(carro);
    }

    /**
     * @method verificarVagasRestantes is called wen we need to know how many parking spots are available to park a car.
     * @return the number os parking spots available to park.
     */
    private int verificarVagasRestantes (){
        return  limiteDeVagas - carrosEstacionados();
    }

    /**
     * @method verificarSePodeEstacionar is called if we need to know if the car can be parked in an available parking spot.
     * @return true if the car can be parked in a available parking spot.
     */
    private boolean verificarSePodeEstacionar (){
        if (verificarVagasRestantes() >= limiteDeVagas){
            return false;
        }
        return true;
    }

    /**
     * @method estacionarSenior is called wen the parking lot is full.
     *          Will check the ages of the drivers and if the driver is under 55, he must leave
     *          the parking space. If all drivers are above 55 ears old, there will be no remaining parking spots
     *          to be considered.
     * @param carro will be added to the append od listaCarrosEstacionados if there is any driver under 55 years old.
     * @exception EstacionamentoException if the parking lot is full with senior drivers.
      */
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
