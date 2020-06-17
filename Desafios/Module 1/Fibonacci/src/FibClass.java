import java.util.ArrayList;
import java.util.List;

public class FibClass {
    //cria uma ArrayList @fibonacci
    public static List<Integer> fibonacci() {
        List<Integer> listFibonacci = new ArrayList<Integer>();
        //inicializa @listFibonacci
        listFibonacci.add(0);
        listFibonacci.add(1);

        //inicializa @numeroFibonacci
        int numeroFibonacci = 1;

        //adiciona o restante dos números na @listFibonacci
        do {
            numeroFibonacci += listFibonacci.get(listFibonacci.size() - 2);
            listFibonacci.add(numeroFibonacci);
        }
        while (listFibonacci.size() + 1 <= 350);

        //retorna a lista completa
        return listFibonacci;
    }

    //Consulta se @a está em @fibonacci
    public static Boolean isFibonacci(Integer a) {
        //chama @fibonacci
        List<Integer> consultaFibonacci = fibonacci();


        //verifica se @a está em @fibonacci
        boolean checkedFibonacci = consultaFibonacci.contains(a);


        //retorna boolean @checkedFibonacci
        return checkedFibonacci;
    }
}
