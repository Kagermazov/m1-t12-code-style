import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, int period) {
        double result = amount * Math.pow((1 + 0.06 / 12), 12 * period);
        return round(result);
    }

    double calculateSimplePercent(double amount, int deposit_period) {
        double result = amount + (amount * 0.06 * deposit_period);
        return round(result);
    }

    double round(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void calculateIncome() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double income = 0;

        switch (action) {
            case 1 -> income = calculateSimplePercent(amount, period);
            case 2 -> income= calculateComplexPercent(amount, period);
            default -> System.out.println("Такой команды нет.");
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateIncome();
    }
}
