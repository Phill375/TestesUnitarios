package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

class IMCCalcTest {

    @Test
    void calcImcNormalCase() {
        // altura 1,75 peso 70 = 22,87
        IMCCalc imcCalc = new IMCCalc();
        var result = imcCalc.calcImc(175, 70);
        assertThat(result).isCloseTo(22.857f, offset(0.001f));
    }

    @Test
    void calcImcZeroHeight() {
        // altura 0, peso 70 = Não deveria ser possível, portanto, esperamos NaN
        IMCCalc imcCalc = new IMCCalc();
        var result = imcCalc.calcImc(0, 70);
        assertThat(result).isNaN();///
    }

    @Test
    void calcImcZeroWeight() {
        // altura 175, peso 0 = Não deveria ser possível, portanto, esperamos NaN
        IMCCalc imcCalc = new IMCCalc();
        var result = imcCalc.calcImc(175, 0);
        assertThat(result).isNaN();
    }

}
