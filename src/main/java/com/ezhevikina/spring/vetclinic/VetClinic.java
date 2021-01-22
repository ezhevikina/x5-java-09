package com.ezhevikina.spring.vetclinic;

import java.util.List;

public interface VetClinic {
    void openClinic();
    void treatAllAnimals(List<Animal> sickAnimalsList);

}
