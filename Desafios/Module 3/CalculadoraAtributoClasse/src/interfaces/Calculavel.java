package interfaces;

import java.math.BigDecimal;

/**
 * Você deverá criar uma interface Calculavel. Esta interface possui 3 métodos:
 *
 * Somar
 * Subtrair
 * Totalizar
 */
public interface Calculavel {
    BigDecimal somar (Object object);
    BigDecimal subtrair (Object object);
    BigDecimal totalizar (Object object);
}
