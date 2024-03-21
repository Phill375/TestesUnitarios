package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("Bem-vindo! Escolha uma opção:");
            System.out.println("1. Conversor de Moeda");
            System.out.println("2. Calculadora de IMC");
            System.out.println("3. Jogo da Forca");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    runCurrencyConverter();
                    break;
                case 2:
                    runIMCCalculator();
                    break;
                case 3:
                    runHangmanGame();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Obrigado por jogar! Até mais!");
        scanner.close();
    }
    private static void runCurrencyConverter() {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao conversor de moeda!");

        while (true) {
            System.out.print("Digite o valor que deseja converter: ");
            double amount = scanner.nextDouble();

            System.out.print("Digite a moeda de origem (por exemplo, USD, EUR, GBP, JPY, BRL): ");
            String fromCurrency = scanner.next().toUpperCase();

            System.out.print("Digite a moeda de destino (por exemplo, USD, EUR, GBP, JPY, BRL): ");
            String toCurrency = scanner.next().toUpperCase();

            try {
                double result = converter.convert(amount, fromCurrency, toCurrency);
                System.out.printf("%.2f %s equivalem a %.2f %s\n", amount, fromCurrency, result, toCurrency);
            } catch (IllegalArgumentException e) {
                System.out.println("Moeda não suportada. Por favor, tente novamente.");
            }

            System.out.print("Deseja fazer outra conversão? (S/N): ");
            String choice = scanner.next().toUpperCase();
            if (!choice.equals("S")) {
                break;
            }
        }

        System.out.println("Obrigado por usar o conversor de moeda. Até mais!");
    }

    private static void runIMCCalculator() {
        IMCCalc imcCalc = new IMCCalc();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à calculadora de IMC!");

        while (true) {
            System.out.print("Digite a altura em centímetros: ");
            float height = scanner.nextFloat();

            System.out.print("Digite o peso em quilogramas: ");
            float weight = scanner.nextFloat();

            try {
                float result = imcCalc.calcImc(height, weight);
                System.out.printf("Seu IMC é: %.2f\n", result);
            } catch (IllegalArgumentException e) {
                System.out.println("Altura e peso devem ser valores positivos. Por favor, tente novamente.");
            }

            System.out.print("Deseja calcular outro IMC? (S/N): ");
            String choice = scanner.next().toUpperCase();
            if (!choice.equals("S")) {
                break;
            }
        }

        System.out.println("Obrigado por usar a calculadora de IMC. Até mais!");
    }

    private static void runHangmanGame() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            HangmanGame game = new HangmanGame();

            System.out.println("Bem-vindo ao Jogo da Forca!");

            while (!game.isGameOver()) {
                System.out.println("Palavra: " + game.getVisibleWord());
                System.out.println("Tentativas restantes: " + game.getAttemptsLeft());
                System.out.print("Digite uma letra: ");
                char guess = scanner.next().toLowerCase().charAt(0);

                if (!Character.isLetter(guess)) {
                    System.out.println("Por favor, digite apenas letras.");
                    continue;
                }

                if (!game.guessCharacter(guess)) {
                    System.out.println("Letra incorreta.");
                }
            }

            if (game.getVisibleWord().contains("_")) {
                System.out.println("Você perdeu! A palavra era: " + game.getVisibleWord());
            } else {
                System.out.println("Parabéns! Você venceu!");//
            }

            System.out.print("Deseja jogar novamente? (S/N): ");
            String choice = scanner.next().toUpperCase();
            if (!choice.equals("S")) {
                quit = true;
            }
        }

        System.out.println("Saindo do Jogo da Forca.");
    }

}
