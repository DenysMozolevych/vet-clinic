package main.java.com.magicvet;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    // додав поля з паролем, та сканером для зчитування;
    static String PASSWORD = "speedclimbing";
    static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        // метод main буде робити лише один виклик, метод run;
        run();
    }

    static void run() {
        // оголосив буліан змінну для індикації пароля;
        boolean accepted = false;
        // дав 3 спроби на пароль;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please recheck your PASS!");
            }
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        boolean finalAccepted = accepted;
        executorService.schedule(() -> System.out.println(finalAccepted ? "Welcome to the Magic-Vet!" : "Application has been blocked.")
                , 3, TimeUnit.SECONDS);
    }
}