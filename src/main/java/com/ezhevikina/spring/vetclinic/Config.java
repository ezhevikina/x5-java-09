package com.ezhevikina.spring.vetclinic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:config.properties")
public class Config {
  @Value("${nurse.name}")
  private String nurseName;
  @Value("${clinic.name}")
  private String clinicName;

  @Bean
  @Scope("singleton")
  public MedicalWorker getMedicalWorker() {
    return new Nurse(nurseName);
  }

  @Bean
  @Lazy
  @Scope("singleton")
  public VetClinic getClinic() {
    return new VetClinicService(getMedicalWorker(), clinicName);
  }

  @Bean(initMethod="init")
  @Scope("prototype")
  public Animal getCat() {
    return new Cat();
  }
}
