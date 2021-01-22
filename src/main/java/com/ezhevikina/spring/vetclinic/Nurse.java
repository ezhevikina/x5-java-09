package com.ezhevikina.spring.vetclinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.context.ConfigurableApplicationContext;

@Log
@Getter
@Setter
@AllArgsConstructor
public class Nurse implements MedicalWorker {
    private String name;

    public void openClinic(ConfigurableApplicationContext context) {
        log.info(name + " is opening the clinic");
        VetClinic clinic = context.getBean(VetClinic.class);
        clinic.openClinic();
    }

    @Override
    public void closeClinic(ConfigurableApplicationContext context) {
        log.info(name + " is closing the clinic");
        context.close();
    }

    public void healAnimal(Animal animal){
        log.info(name + " invites new animal");
        animal.healing();
    }
}
