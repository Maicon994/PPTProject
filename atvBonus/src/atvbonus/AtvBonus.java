package atvbonus;

import java.util.Random;
import java.util.Scanner;

public class AtvBonus {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Random random = new Random();
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int vitorias = 0, derrotas = 0, escolhaJogador;

        System.out.println("Jogo: Pedra, Papel ou Tesoura");
//Processamento

        while (true) {
            mostrarMenu();
            escolhaJogador = ler.nextInt();

            if (escolhaJogador == 0) {
                System.out.println("Obrigado por jogar!");
                System.out.println("Total de vitórias: " + vitorias + " | Total de derrotas: " + derrotas);
                break;
            }

            if (escolhaJogador < 1 || escolhaJogador > 3) {
                System.out.println("Opção inválida! Escolha entre 1 e 3 ou digite 0 para sair.");
                continue;
            }

            int escolhaComputador = random.nextInt(3) + 1;

            System.out.println("Você escolheu: " + opcoes[escolhaJogador - 1]);
            System.out.println("Computador escolheu: " + opcoes[escolhaComputador - 1]);

            int resultado = verificarResultado(escolhaJogador, escolhaComputador);
            if (resultado == 1) {
                System.out.println("Resultado da partida: Você venceu!!");
                vitorias++;
            } else if (resultado == -1) {
                System.out.println("Resultado da partida: Você perdeu...");
                derrotas++;
            } else {
                System.out.println("Resultado da partida: Empate.");
            }
        }

        ler.close();
    }
//Entradas

    public static void mostrarMenu() {
        System.out.println("Escolha sua jogada:");
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
        System.out.println("0 - Sair do jogo");
        System.out.print("Sua escolha: ");
    }
//Verificações
    public static int verificarResultado(int jogador, int computador) {
        if (jogador == computador) {
            return 0; // Acontece o empate
        } else if ((jogador == 1 && computador == 3)
                || (jogador == 2 && computador == 1)
                || (jogador == 3 && computador == 2)) {
            return 1; // Acontece a vitória
        } else {
            return -1; // Acontece a derrota
        }
    }

}
