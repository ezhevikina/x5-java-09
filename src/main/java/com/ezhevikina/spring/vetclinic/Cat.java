package com.ezhevikina.spring.vetclinic;

import lombok.Getter;
import lombok.extern.java.Log;

@Log
@Getter
public class Cat implements Animal {
    private boolean isSick = true;

    @Override
    public void healing() {
        isSick = false;
        log.info("Cat is healed");
    }

    public void init() {
        log.info("Meow");
    }
}
