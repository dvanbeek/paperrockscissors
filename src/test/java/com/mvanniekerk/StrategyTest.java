package com.mvanniekerk;

import org.junit.jupiter.api.Test;

import java.util.List;

class StrategyTest {
    @Test
    void randomStrategySmokeTest() {
        var randomStrategy = new Strategy.RandomStrategy();
        for (int i = 0; i < 1000; i++) {
            randomStrategy.choice(List.of());
        }
    }
}