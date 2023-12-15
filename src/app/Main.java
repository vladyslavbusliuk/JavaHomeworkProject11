package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть перший параметр:");
        double param1 = scanner.nextDouble();

        System.out.println("Введіть другий параметр:");
        double param2 = scanner.nextDouble();

        System.out.println("Введіть коефіцієнт для девайсу B:");
        double coefficientB = scanner.nextDouble();

        Device deviceA = new DeviceA();
        Device deviceB = new DeviceB(coefficientB);

        double resultA = deviceA.calculateResult(param1, param2);
        double resultB = deviceB.calculateResult(param1, param2);

        System.out.println("Результат від девайсу A: " + resultA);
        System.out.println("Результат від девайсу B: " + resultB);

        scanner.close();
    }
}

abstract class Device {
    abstract double calculateResult(double param1, double param2);
}

class DeviceA extends Device {
    @Override
    double calculateResult(double param1, double param2) {
        return param1 * param2;
    }
}

class DeviceB extends Device {
    private double coefficient;

    public DeviceB(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    double calculateResult(double param1, double param2) {
        return (param1 + param2) * coefficient;
    }
}
