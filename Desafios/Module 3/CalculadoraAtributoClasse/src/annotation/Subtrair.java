package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Você precisa somar ou subtrair determinados atributos do tipo BigDecimal de uma classe.
 * Pra isso você deverá cria uma annotation ("Subtrair") para todos os atributos que serão subtraídos.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subtrair {
}
