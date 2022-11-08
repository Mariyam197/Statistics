package ru.netology.stats;

public class StatsService {

    // Общая сумма продаж
    public int findSum(long[] sales) {
        int sum = 0; // - сумма всех продаж

        for (long sale : sales) {
            sum += sale;
        }
        return sum;
    }

    // Средняя сумма продаж за месяц
    public double findAverage(long[] sales) {
        int sum = findSum(sales);
        double value = sum / sales.length;
        // value - средняя сумма продаж
        return value;
    }

    // Номер месяца, в котором был пик продаж, то есть осуществлены продажи на максимальную сумму
    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве

        for (long sale : sales) {
            // sales[maxMonth] - продажи в месяце maxMonth
            // sale - продажи в рассматриваемом месяце
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1;
        }
        return maxMonth + 1;
    }

    // Номер месяца, в котором был минимум продаж, то есть осуществлены продажи на минимальную сумму
    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

    // Количество месяцев, в которых продажи были ниже среднего
    public int monthsUnderAverage(long[] sales) {
        double value = findAverage(sales);
        int count = 0; // count - количество месяцев

        for (long sale : sales) {
            if (sale < value) {
                count++;
            }
        }
        return count;
    }

    // Количество месяцев, в которых продажи были выше среднего
    public int monthsOverAverage(long[] sales) {
        double value = findAverage(sales);
        int count = 0; // count - количество месяцев

        for (long sale : sales) {
            if (sale > value) {
                count++;
            }
        }
        return count;
    }
}


