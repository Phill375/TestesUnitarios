package org.example;

public class IMCCalc {

    public float calcImc(float height, float weight) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Altura e peso devem ser valores positivos.");
        }

        return weight / ((height / 100) * (height / 100));
    }//
}