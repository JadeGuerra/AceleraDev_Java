import java.util.*;

public class Principal {//all mine
    public static void main(String[] args) {
        System.out.println("Calculadora salário líquido");
        System.out.println("Digite o valor do salário usando ponto para as casas decimais:");
        Scanner s = new Scanner(System.in);
        String salario = s.nextLine();
        double salarioBase = Double.parseDouble(salario);

        long salarioLiquido = CalculadoraSalario.calcularSalarioLiquido(salarioBase);

        System.out.println(salarioLiquido);


    }
}
