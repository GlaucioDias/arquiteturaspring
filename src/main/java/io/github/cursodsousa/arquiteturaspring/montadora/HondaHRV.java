package io.github.cursodsousa.arquiteturaspring.montadora;

import static io.github.cursodsousa.arquiteturaspring.montadora.Montadora.HONDA;
import static java.awt.Color.BLACK;

public class HondaHRV extends Carro {

    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("HRV");
        setCor(BLACK);
        setMontadora(HONDA);
    }

}
