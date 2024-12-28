package projeto;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Bem-vindo ao Jogo de Adivinhação de Números!");

		int limiteInferior = 1;
		int limiteSuperior = 100;
		System.out.println("Digite o valor mínimo do intervalo:");
		limiteInferior = obterEntrada(scanner);

		System.out.println("Digite o valor máximo do intervalo:");
		limiteSuperior = obterEntrada(scanner);

		int numeroAleatorio = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
		int tentativa;
		int contagemTentativas = 0;

		System.out.println("Tente adivinhar o número entre " + limiteInferior + " e " + limiteSuperior + ".");

		while (true) {
			System.out.print("Digite sua tentativa (ou digite -1 para sair): ");
			tentativa = obterEntrada(scanner);

			if (tentativa == -1) {
				System.out.println("Você decidiu sair do jogo. Até a próxima!");
				break;
			}

			contagemTentativas++;

			if (tentativa == numeroAleatorio) {
				System.out.println("Parabéns! Você acertou o número em " + contagemTentativas + " tentativas.");
				break;
			} else if (tentativa < numeroAleatorio) {
				System.out.println("O número é maior que " + tentativa + ".");
			} else {
				System.out.println("O número é menor que " + tentativa + ".");
			}
		}

		System.out.println("Fim do jogo. Obrigado por jogar!");
		scanner.close();
	}

	private static int obterEntrada(Scanner scanner) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Entrada inválida. Por favor, insira um número inteiro: ");
			}
		}
	}
}
