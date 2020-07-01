package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Você precisa somar ou subtrair determinados atributos do tipo BigDecimal de uma classe.
 * Para isso você deverá cria uma annotation ("Somar") para determinar quais atributos serão somados;
 */

@Target(ElementType.FIELD)
@Retention(value=RUNTIME)
public @interface Somar {
}
