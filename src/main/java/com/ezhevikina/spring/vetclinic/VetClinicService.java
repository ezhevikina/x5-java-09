package com.ezhevikina.spring.vetclinic;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Log
@Getter
@Setter
public class VetClinicService implements VetClinic {
    private List<Animal> sickAnimalsList = new ArrayList<>();
    private MedicalWorker medicalWorker;
    private String clinicName;
    private boolean isOpen = false;

    @Override
    public void openClinic() {
        isOpen = true;
        log.info(clinicName + " is open");
    }

    @Override
    public void treatAllAnimals(List<Animal> sickAnimalsList){
        for (Animal animal:sickAnimalsList) {
            medicalWorker.healAnimal(animal);
        }
    }

    public VetClinicService(MedicalWorker medicalWorker, String clinicName) {
        this.medicalWorker = medicalWorker;
        this.clinicName = clinicName;
        log.info(String.format("Clinic %s is created", clinicName));
    }

}
