package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = true;
        long expected = 50; // 5% от 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 1000; // ограничение в 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = false;
        long expected = 10; // 1% от 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 1000; // ограничение в 1000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredWithZeroAmount() {
        BonusService service = new BonusService();
        long amount = 0;
        boolean registered = true;
        long expected = 0; // 5% от 0
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredWithZeroAmount() {
        BonusService service = new BonusService();
        long amount = 0;
        boolean registered = false;
        long expected = 0; // 1% от 0
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredWithEdgeAmount() {
        BonusService service = new BonusService();
        long amount = 20; // Минимальное значение для целочисленного деления
        boolean registered = true;
        long expected = 1; // 5% от 20
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredWithEdgeAmount() {
        BonusService service = new BonusService();
        long amount = 100_000; // Даст ровно 1000 бонусов
        boolean registered = false;
        long expected = 1000; // 1% от 100_000
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }


}

