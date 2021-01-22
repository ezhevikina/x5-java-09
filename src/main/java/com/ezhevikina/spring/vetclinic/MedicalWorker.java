package com.ezhevikina.spring.vetclinic;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface MedicalWorker {

    void openClinic(ConfigurableApplicationContext context);

    void closeClinic(ConfigurableApplicationContext context);

    void healAnimal(Animal animal);


}
