package desafio;


import interfaces.Calculavel;

import java.math.BigDecimal;

/**
 * Você deverá também criar uma classe concreta que implementa Calculavel.
 * O nome dessa classe deve ser CalculadorDeClasses.
 * A implementação dos métodos deve obedecer os requisitos abaixo:
 *
 * O método somar: deverá somar todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e
 * retornar um BigDecimal.
 *
 * O método subtrair: deverá somar todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e
 * retornar um BigDecimal.
 *
 * O método total: deverá subtrair os atributos annotados com "Subtrair" dos atributos annotados com "Somar".
 *
 * Caso a classe não tenha nenhum atributo com annotation, retornar BigDecimal.ZERO
 *
 * Caso o atributo não seja BigDecimal, retornar BigDecimal.ZERO
 *
 * Utilizar os packages existentes do projeto para crias as devidas classes.
 */
public class CalculadorDeClasses implements Calculavel {
    //TODO construir o calculo a partir de uma classe que eu não sei qual é, buscando o atributo com valor bigdecimal e annotation somar ou subtrair.
    //TODO para achar isso usar o reflections

    @Override
    public BigDecimal somar(Object object) {
        return null;
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return null;
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }
}
