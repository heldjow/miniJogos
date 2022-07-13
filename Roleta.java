package minijogos;

import java.util.Random;
import java.util.Scanner;

public class Roleta {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Random aleatorio = new Random();

		int jogadores;
		int jogada;
		int fichas;
		int aposta;
		String jogarNovamente = "";
		int escolha;

		System.out.println("Bem vindo ao meu primeiro joguinho");
		System.out.println("Você está no cassino do heldjow");
		System.out.println("JOGO: ROLETA EUROPEIA");
		System.out.println("Quantas pessoas vão jogar? ");
		jogadores = entrada.nextInt();

		String nome[] = new String[jogadores];
		double fichaFinal[] = new double[jogadores];
		double saldo[] = new double[jogadores];

		for (int i = 0; i < jogadores; i++) {

			int gasto = 0;

			System.out.printf("Digite o nome do %d° jogador: ", i + 1);
			nome[i] = entrada.next();

			System.out.println("Jogador da vez: " + nome[i]);

			System.out.println("Compre no minimo 50 fichas para sentar a mesa." + " Quantas fichas deseja comprar? ");
			fichas = entrada.nextInt();
			gasto = gasto + fichas;

			while (fichas < 0) {

				gasto = gasto - gasto;

				System.out.println("Valor inserido inválido.");
				System.out.println("Insira um valor válido: ");
				fichas = entrada.nextInt();
				gasto = gasto + fichas;

			}
			while (fichas < 50) {
				System.out.printf("O usuário possui %d fichas. \n", fichas);
				System.out.println("Você não possui o minimo de fichas o suficiente");
				System.out.println("Insira mais fichas: ");
				fichas = fichas + entrada.nextInt();
				gasto = gasto + fichas;

			}

			do {

				System.out.printf("Voce possui %d fichas. \n", fichas);

				if (fichas == 0) {
					System.out.println("Insira mais fichas para continuar jogando. Quantas fichas deseja comprar? ");
					fichas = entrada.nextInt();
					System.out.printf("Atualmente você possui %d fichas \n", fichas);
					gasto = gasto + fichas;

				}

				int valor = aleatorio.nextInt(37);

				System.out.println("Apostas disponiveis:");
				System.out.println("| INDICE |     APOSTA     | ODD |");
				System.out.printf("|   1    |     NÚMEROS    | 36  |\n" + "|   2    |  PAR OU IMPAR  |  2  |\n"
						+ "|   3    |     DUZIA      |  3  | \n");
				System.out.println("Informe o indice da sua aposta: ");
				escolha = entrada.nextInt();

				switch (escolha) {

				case 1:
					System.out.println("Escolha um número da roleta (0 a 36): ");
					jogada = entrada.nextInt();

					while (0 > jogada || jogada > 36) {
						System.out.println("Numero fora da roleta, tente outro: ");
						jogada = entrada.nextInt();
					}

					System.out.println("Você escolheu o número " + jogada + ". Quantas fichas você quer apostar? ");
					aposta = entrada.nextInt();

					while (aposta > fichas) {
						System.out.println(
								"Aposta inválida. Você não possui fichas suficientes. Aposte um valor valido: ");
						aposta = entrada.nextInt();
					}

					System.out.println("Fichas apostadas: " + aposta);
					System.out.println("Número escolhido: " + jogada);
					System.out.println("Número sorteado: " + valor);

					if (jogada == valor) {
						System.out.println("Parabéns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 35);
						System.out.printf("Você ganhou %d fichas.", aposta * 36);
					} else {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Você perdeu %d fichas.", aposta);
					}
					break;
				case 2:
					System.out.println("Escolha entre (1)par ou (2)impar: ");
					jogada = entrada.nextInt();
					while (jogada < 1 || jogada > 2) {
						System.out.println("Indice inválido, tente novamente: ");
						jogada = entrada.nextInt();
					}
					if (jogada == 1) {
						System.out.println("Você escolheu os números pares. Quantas fichas deseja apostar?");
						aposta = entrada.nextInt();

						while (aposta > fichas) {
							System.out.println(
									"Aposta inválida. Você não possui fichas suficientes. Aposte um valor valido: ");
							aposta = entrada.nextInt();
						}
						System.out.println("Aposta escolhida: Pares");
						System.out.println("Fichas apostadas: " + aposta);
						System.out.println("Número Sorteado: " + valor);

						if (valor % 2 == 1) {
							System.out.println("Aposta perdida.");
							fichas = fichas - aposta;
							System.out.printf("Você perdeu %d fichas.", aposta);
						} else if (valor % 2 == 0) {
							System.out.println("Parabéns! Sua aposta foi vencedora.");
							fichas = fichas - aposta;
							fichas = fichas + (aposta * 2);
							System.out.printf("Você ganhou %d fichas.", aposta * 2);
						}

					} else if (jogada == 2) {
						System.out.println("Você escolheu os números impares. Quantas fichas deseja apostar?");
						aposta = entrada.nextInt();

						while (aposta > fichas) {
							System.out.println(
									"Aposta inválida. Você não possui fichas suficientes. Aposte um valor valido: ");
							aposta = entrada.nextInt();
						}

						System.out.println("Aposta escolhida: Impares");
						System.out.println("Fichas apostadas: " + aposta);
						System.out.println("Número Sorteado: " + valor);

						if (valor % 2 == 1) {
							System.out.println("Parabéns! Sua aposta foi vencedora.");
							fichas = fichas - aposta;
							fichas = fichas + (aposta * 2);
							System.out.printf("Você ganhou %d fichas.", aposta * 2);
						} else if (valor % 2 == 0) {
							System.out.println("Aposta perdida.");
							fichas = fichas - aposta;
							System.out.printf("Você perdeu %d fichas.", aposta);
						}
					}
					break;
				case 3:
					System.out.println("TABELA DAS DUZIAS: ");
					System.out.printf("1° 12| (1 a 12)\n2° 12| (13 a 24)\n3° 12| (25 a 36)\n");
					System.out.println("Digite o número da duzia que você quer apostar: ");
					jogada = entrada.nextInt();

					while (0 > jogada || jogada > 3) {
						System.out.println("Duzia não existente, tente outra: ");
						jogada = entrada.nextInt();
					}

					System.out.printf("Você escolheu a %d° duzia. Quantas fichas você quer apostar? ", jogada);
					aposta = entrada.nextInt();

					while (aposta > fichas) {
						System.out.println(
								"Aposta inválida. Você não possui fichas suficientes. Aposte um valor valido: ");
						aposta = entrada.nextInt();
					}

					System.out.println("Fichas apostadas: " + aposta);
					System.out.println("Dúzia escolhida: " + jogada + "°");
					System.out.println("Número sorteado: " + valor);

					if (jogada == 1 && valor <= 12) {
						System.out.println("Parabéns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 3);
						System.out.printf("Você ganhou %d fichas.", aposta * 3);
					} else if (jogada == 2 && 12 < valor && valor <= 24) {
						System.out.println("Parabéns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 3);
						System.out.printf("Você ganhou %d fichas.", aposta * 3);
					} else if (jogada == 3 && 24 < valor && valor <= 36) {
						System.out.println("Parabéns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 3);
						System.out.printf("Você ganhou %d fichas.", aposta * 3);
					} else if (jogada == 1 && valor > 12) {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Você perdeu %d fichas.", aposta);
					} else if (jogada == 2 && 12 >= valor || valor > 24) {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Você perdeu %d fichas.", aposta);
					} else if (jogada == 3 && 24 >= valor || valor > 36) {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Você perdeu %d fichas.", aposta);
					}
					break;
				default:
					System.out.println("Indice AINDA não existente. Programa em desenvolvimento.");
					System.out.println("Aguarde a próxima atualização para acessar as novidades.");
					break;
				}

				System.out.printf("Você possui %d fichas \n", fichas);

				System.out.println("Deseja continuar jogando? ");
				jogarNovamente = entrada.next();

			} while (jogarNovamente.equalsIgnoreCase("sim"));
			fichaFinal[i] = fichas;
			saldo[i] = fichas - gasto;
		}

		System.out.println("|                PLACAR FINAL              |");
		System.out.println("|   JOGADOR   |     FICHAS     |   SALDO   |");
		System.out.println("|      |      |        |       |      |    |");
		System.out.println("|      V      |        V       |      V    |");
		
		for (int j = 0; j < fichaFinal.length; j++) {
			for (int j2 = 0; j2 < 1; j2++) {
				System.out.println("<><> " + nome[j] + " <><><><> " + fichaFinal[j] + " <><><> " + saldo[j]);
			}
		}
		
		// PRÓXIMOS PASSOS: CRIAR SE DEU BEM E SE DEU MAL COM PARTICIPANTE COM MAIOR E MENOR SALDO
		// MOSTRAR PARTICIPANTE COM MAIOR E MENOR NUMERO DE FICHAS NO FINAL
		// USAR CLASSES E METODOS PRA DEIXAR CODIGO MENOR
		// UPAR NO GIT HUB
		// FINISH, DAR SEGUIMENTO AS AULAS

		entrada.close();
	}
}
