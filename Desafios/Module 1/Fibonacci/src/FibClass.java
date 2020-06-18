import java.util.ArrayList;
import java.util.List;

public class FibClass {
    /**
     * class @fibonacci return
     * list @listFibonacci
     * @numFibonacci atualiza nos números da sequência Fibonnaci
     * que depois são adicionados à lista
     */
    public static List<Integer> fibonacci() {
        List<Integer> listFibonacci = new ArrayList<Integer>();
        //inicializa @listFibonacci
        listFibonacci.add(0);
        listFibonacci.add(1);

        //inicializa @numeroFibonacci
        int numeroFibonacci = 1;

        //adiciona o restante dos números na @listFibonacci
        do {
            //atualiza @numeroFibonacci
            numeroFibonacci += listFibonacci.get(listFibonacci.size() - 2);
            //adiciona @numeroFibonacci a @listFibonacci
            listFibonacci.add(numeroFibonacci);
        }
        //condicional para repetição: número maior que 350
        while (numeroFibonacci + 1 <= 350 + 1);

        //retorna a lista completa
        return listFibonacci;
    }

    /**
     * class @isFibonacci
     * return true se a está na list @listFibonacci
     */
    public static Boolean isFibonacci(Integer a) {
        //consulta se @a está na list @fibonacci
        return fibonacci().contains(a);
    }
}
