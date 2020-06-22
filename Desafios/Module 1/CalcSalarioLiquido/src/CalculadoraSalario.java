 /**
 * At this challenge we will implement an algorithm responsible for
 * receiving the gross salary as a parameter and returns the net salary
 * with INSS and IRRF discounts. This algorithm must be implemented at
 * @CalculadoraSalario class and @calcularSalarioLiquido method
 * @calcularSalarioLiquido method must receive a type double value and return a
 * type int value.
 *
 * Tip: use Math.roud() method to round the result.
 */

public class CalculadoraSalario {

    /**
     * @cacularSalarioLiquido method returns net salary
     * @inssDiscount calls @calcularInss to calculate INSS discount
     * @irrfDiscount calls @calcularIRRF to calculate IRRF discount
     */
    public static long calcularSalarioLiquido(double salarioBase) {//not mess

        //TODO criar tratamento de erro caso receba salario vazio

        double inssDiscount = calcularInss(salarioBase);
        double irrfDiscount = calcularIRRF(salarioBase, inssDiscount);

        return Math.round(salarioBase - (inssDiscount + irrfDiscount));
    }

    /**
     * @calcularInss calculates inss discount value
     *
     * Salary Range...........................Discount percentage
     * Until R$ 1.500,00......................8%
     * Since R$ 1.500,01 until R$ 4.000,00....9%
     * Above R$ 4.000,00......................11%
     */
    private static double calcularInss(double grossSalary) {//not mess
        //salary range values
        double firstSalaryRange = 1500.00;
        double secondSalaryRange = 4000.00;

        //discount values
        double firstRangeDiscount = 0.08;
        double secondRangeDiscount = 0.09;
        double thirdRangeDiscount = 0.11;

        if (grossSalary <= firstSalaryRange){
            return grossSalary * firstRangeDiscount;
        }
        else if (grossSalary > firstSalaryRange && grossSalary <= secondSalaryRange){
            return grossSalary * secondRangeDiscount;
        }
        else {
            return grossSalary * thirdRangeDiscount;
        }
    }

    /**
     * @calcularIRRF calculates IRRF discount value
     *
     * Salary range............................Discount percentage
     * Until R$ 3.000,00.......................IMMUNE
     * Since R$ 3.000,01 until R$ 6.000,00.....7.5%
     * Above R$ 6.000,00.......................15%
     */
    private static double calcularIRRF(double grossSalary, double inssDiscount){
        //@salaryLessInss receives @grossSalary less @inssDiscount
        double salaryLessInss = grossSalary - inssDiscount;

        //salary range test values
        double firstSalaryRange = 3000.00;
        double secondSalaryRange = 6000.00;

        //discount values
        double secondRangeDiscount = 0.075;
        double thirdRangeDiscount = 0.15;

        if (salaryLessInss <= firstSalaryRange){
            return 0;
        }
        else if (salaryLessInss > firstSalaryRange && salaryLessInss <= secondSalaryRange){
            return salaryLessInss * secondRangeDiscount;
        }
        else{
            return salaryLessInss * thirdRangeDiscount;
        }
        }

}
