package com.ezhevikina.spring.vetclinic;

import lombok.extern.java.Log;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Log
public class Main {
  public static void main(String[] args) {

    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    //Взять медсестру из контекста
    MedicalWorker nurse = context.getBean(MedicalWorker.class);

    //Открыть клинику
    nurse.openClinic(context);

    //Создать побольше котов
    List<Animal> sickAnimalsList = new ArrayList<>();
    for (int i = 0; i < new Random().nextInt(10) + 1; i++) {
      sickAnimalsList.add(context.getBean(Animal.class));
    }
    log.info("Line of sick animals in formed");

    //Взять клинику из контекста
    VetClinic vetClinic = context.getBean(VetClinic.class);

    //Вылечить котов (отправить их на лечение в клинику методом treatAllAnimals)
    vetClinic.treatAllAnimals(sickAnimalsList);
    log.info("All animals are healed");

    //Закрыть контекст(Вызвать метод closeClinic у медсестры)
    nurse.closeClinic(context);
  }
}
