package functions;

import java.lang.Float;
import java.util.Scanner;

public class Functions {
    /*
     1. Написать функцию которая считает в консоли до числа Х. Аргументы функции: число Х Например Х = 5.
     Вывод программы: 1 2 3 4 5
     */
    public static void counter(int x) {
        for (int i = 1; i <= x; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    /*
    2. Написать функцию drawRectangle которая рисует в консоли прямоугольник из символов '+' Аргументы функции:
    ширина прямугольника в символах, высота прямоугольника в символах
     */
    public static void drawRectangle(int a, int b) {
        System.out.println();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    /*
    3. Перегрузить функцию drawRectangle (задание 2) таким образом, что бы она могла принимать на вход только 1 параметр
    (ширина квадрата) и рисовать квадрат с равными сторонами
     */
    public static void drawRectangle(int x) {
        System.out.println();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    /*
    4.Написать функцию getMax которая принимает на вход два аргумента в виде чисел. А возврыщает максимальное из этих
    двух. Так же, необходимо перегрузить эту функцию для работы с разными числовыми типами переменных (int, float)
     */
    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static float getMax(float a, float b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    /*
    5. Решить задачу 1, без использования циклов. Использовав рекурсию.
     */

    public static void recursionCounter(int x) {
        if (x == 1) {
            System.out.print(1 + " ");
        } else {
            recursionCounter(x - 1);
            System.out.print(x + " ");
        }
    }

    /*
    6. Решить задачу 2, без использования циклов. Использовав рекурсию.
     */
    public static void recursionRect(int b, int c) {
        if (c < 0) {
            System.out.println();
        }else{
            if (c%b == 0){
                System.out.println("+");
                recursionRect(b, c-1);
            }else{
                System.out.print("+");
                recursionRect(b,c-1);
            }
        }
    }


    /*
    Задание 7 (дополнительно)
Написать программу, в которой выполнены все шесть предыдущих заданий.
Каждое задание выполняется в отдельной функции. В пределах этой же функции происходит ввод с консоли необходимых данных.
Программа спрашивает пользователя какую задачу он хочет решить (от 1 до 6). Затем программа вызывает соответствующую
функцию для решения этой задачи. По окончанию решения задачи, программа спрашивает пользователя, хочет ли он продолжить
решать задачи. Если да - опять спрашивает какую задачу.
     */

    public static void userInterface() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the task number:");

        int taskNum = Integer.parseInt(sc.nextLine());
        //int taskNum = sc.nextInt();
        //sc.nextLine();
        if (taskNum == 1) {
            System.out.println("Task 1 counter" +
                    "Input number:");
            int x = Integer.parseInt(sc.nextLine());
            counter(x);
        }else if (taskNum == 2) {
            System.out.println("Task 2 draw rectangle:");
            System.out.println("Input 1st side of Rectangle = ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.println("Input 2nd side of Rectangle = ");
            int b = Integer.parseInt(sc.nextLine());
            System.out.println("\nRectangle printed by for-loop:");
            drawRectangle(a, b);
        }else if (taskNum == 3) {
            System.out.println("Task 3: draw square:");
            System.out.println("Input side of square:");
            int y = Integer.parseInt(sc.nextLine());
            System.out.println("Square:");
            drawRectangle(y);
        }else if (taskNum == 4) {
            System.out.println("Task 4: getMax function:");
            System.out.println("Input 1st number: ");
            float num1f = Float.parseFloat(sc.nextLine());
            System.out.println("Input 2nd number: ");
            float num2f = Float.parseFloat(sc.nextLine());
            System.out.printf("Number %f is bigger\n", getMax(num1f, num2f));

        }else if (taskNum == 5) {
            System.out.println("Task 1 recursively \n" +
                    "Input number:");
            int x = Integer.parseInt(sc.nextLine());
            recursionCounter(x);
        }else if (taskNum == 6) {
            System.out.println("Task 2 draw rectangle (recursively):");
            System.out.println("Input 1st side of Rectangle = ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.println("Input 2nd side of Rectangle = ");
            int b = Integer.parseInt(sc.nextLine());

            int c = a*b;
            recursionRect(b,c-1);
        }
        System.out.println("\nWould you like to continue? yes/no");

        String c = sc.nextLine();

        if (c.equals("yes")) {
            userInterface();
        }else if (c.equals("no")) {
            System.out.println("The End.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Task 1: counter fr 1 to any number\n" +
                "Task 2: draw Rectangle by '+'\n" +
                "Task 3: draw Square by '+'\n" +
                "Task 4: getMax of two int or float\n" +
                "Task 5 counter recursively\n" +
                "Task 6 draw Rectangle recursively\n");

        userInterface();

    }
}
