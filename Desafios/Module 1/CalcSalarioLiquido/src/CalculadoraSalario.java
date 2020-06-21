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
    //@inssDiscount initialized
    static double inssDiscount = 0.00;
    //@irrfDiscount initialized
    static double irrfDiscount = 0.00;

    public static long calcularSalarioLiquido(double salarioBase) {//not mess

        //@inssDiscount calculates inss discount value
        inssDiscount = calcularInss(salarioBase);
        //@irrfDiscount calculates irrf discount value
        irrfDiscount = calcularIRRF(salarioBase, inssDiscount);

        //@netSalary calculates salary minus discounts
        Double netSalary = salarioBase - (inssDiscount + irrfDiscount);

        //returns @netSalary
        return Math.round(netSalary);
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
        //@inss receives inss value
        double inss = 0.00;
        //salary range test values
        //@firstSalaryRange receives first salary range value
        double firstSalaryRange = 1500.00;
        //@secondSalaryRange receives second salary range value
        double secondSalaryRange = 4000.00;

        //discount values
        //@firstRangeDiscount receives first range discount value
        double firstRangeDiscount = 0.08;
        //@secondRangeDiscount receives second range discount value
        double secondRangeDiscount = 0.09;
        //@thirdRangeDiscount receives third range discount value
        double thirdRangeDiscount = 0.11;

        //@inss receives inss calculation value based on first range salary
        if (grossSalary <= firstSalaryRange){
            inss = grossSalary * firstRangeDiscount;
        }
        //@inss receives inss calculation value based on second range salary
        else if (grossSalary > firstSalaryRange && grossSalary <= secondSalaryRange){
            inss = grossSalary * secondRangeDiscount;
        }
        //@inss receives inss calculation value based on second range salary
        else {
            inss = grossSalary * thirdRangeDiscount;
        }

        //returns @inss value
        return (inss);
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
        //@irrf initialized
        double irrf = 0.00;
        //@salaryLessInss receives @grossSalary less @inssDiscount
        double salaryLessInss = grossSalary - inssDiscount;

        //salary range test values
        //@firstSalaryRange receives first salary range value
        double firstSalaryRange = 3000.00;
        //@secondSalaryRange receives second salary range value
        double secondSalaryRange = 6000.00;

        //discount values
        //@firstRangeDiscount receives first range discount value
        double firstRangeDiscount = 0;
        //@secondRangeDiscount receives second range discount value
        double secondRangeDiscount = 0.075;
        //@thirdRangeDiscount receives third range discount value
        double thirdRangeDiscount = 0.15;

        //@irrf receives irrf calculation value based on first range salary
        if (salaryLessInss <= firstSalaryRange){
            irrf = salaryLessInss * firstRangeDiscount;
        }
        //@irrf receives irrf calculation value based on second range salary
        else if (salaryLessInss > firstSalaryRange && salaryLessInss <= secondSalaryRange){
            irrf = salaryLessInss * secondRangeDiscount;
        }
        //@irrf receives irrf calculation value based on third range salary
        else{
            irrf = salaryLessInss * thirdRangeDiscount;
        }

       //returns @irrf value
            return (irrf);
        }

}
