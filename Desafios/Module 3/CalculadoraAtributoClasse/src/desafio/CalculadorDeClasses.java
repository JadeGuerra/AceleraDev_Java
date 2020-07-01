package desafio;


import annotation.Somar;
import annotation.Subtrair;
import interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

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


    @Override
    public BigDecimal somar(Object object) {
        BigDecimal soma = BigDecimal.ZERO;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields){
            if ((field.getType().equals(BigDecimal.class)) && (field.isAnnotationPresent(Somar.class))){
                BigDecimal adicionar = analizarTipoAtributo(field, object);
                soma = soma.add(adicionar);
            }
        }
        return soma;

    }

    @Override
    public BigDecimal subtrair(Object object){
        BigDecimal soma = BigDecimal.ZERO;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields){
            if ((field.getType().equals(BigDecimal.class)) && (field.isAnnotationPresent(Subtrair.class))){
                soma = soma.add(analizarTipoAtributo(field, object));
            }
        }
        return soma;
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }


    private BigDecimal analizarTipoAtributo(Field field, Object object) {
        field.setAccessible(true);
        try {
            return new BigDecimal(String.valueOf(field.get(object)));
        } catch (IllegalAccessException e) {
            return BigDecimal.ZERO;
        }


    }



}
