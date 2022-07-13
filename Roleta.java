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
		System.out.println("Voc� est� no cassino do heldjow");
		System.out.println("JOGO: ROLETA EUROPEIA");
		System.out.println("Quantas pessoas v�o jogar? ");
		jogadores = entrada.nextInt();

		String nome[] = new String[jogadores];
		double fichaFinal[] = new double[jogadores];
		double saldo[] = new double[jogadores];

		for (int i = 0; i < jogadores; i++) {

			int gasto = 0;

			System.out.printf("Digite o nome do %d� jogador: ", i + 1);
			nome[i] = entrada.next();

			System.out.println("Jogador da vez: " + nome[i]);

			System.out.println("Compre no minimo 50 fichas para sentar a mesa." + " Quantas fichas deseja comprar? ");
			fichas = entrada.nextInt();
			gasto = gasto + fichas;

			while (fichas < 0) {

				gasto = gasto - gasto;

				System.out.println("Valor inserido inv�lido.");
				System.out.println("Insira um valor v�lido: ");
				fichas = entrada.nextInt();
				gasto = gasto + fichas;

			}
			while (fichas < 50) {
				System.out.printf("O usu�rio possui %d fichas. \n", fichas);
				System.out.println("Voc� n�o possui o minimo de fichas o suficiente");
				System.out.println("Insira mais fichas: ");
				fichas = fichas + entrada.nextInt();
				gasto = gasto + fichas;

			}

			do {

				System.out.printf("Voce possui %d fichas. \n", fichas);

				if (fichas == 0) {
					System.out.println("Insira mais fichas para continuar jogando. Quantas fichas deseja comprar? ");
					fichas = entrada.nextInt();
					System.out.printf("Atualmente voc� possui %d fichas \n", fichas);
					gasto = gasto + fichas;

				}

				int valor = aleatorio.nextInt(37);

				System.out.println("Apostas disponiveis:");
				System.out.println("| INDICE |     APOSTA     | ODD |");
				System.out.printf("|   1    |     N�MEROS    | 36  |\n" + "|   2    |  PAR OU IMPAR  |  2  |\n"
						+ "|   3    |     DUZIA      |  3  | \n");
				System.out.println("Informe o indice da sua aposta: ");
				escolha = entrada.nextInt();

				switch (escolha) {

				case 1:
					System.out.println("Escolha um n�mero da roleta (0 a 36): ");
					jogada = entrada.nextInt();

					while (0 > jogada || jogada > 36) {
						System.out.println("Numero fora da roleta, tente outro: ");
						jogada = entrada.nextInt();
					}

					System.out.println("Voc� escolheu o n�mero " + jogada + ". Quantas fichas voc� quer apostar? ");
					aposta = entrada.nextInt();

					while (aposta > fichas) {
						System.out.println(
								"Aposta inv�lida. Voc� n�o possui fichas suficientes. Aposte um valor valido: ");
						aposta = entrada.nextInt();
					}

					System.out.println("Fichas apostadas: " + aposta);
					System.out.println("N�mero escolhido: " + jogada);
					System.out.println("N�mero sorteado: " + valor);

					if (jogada == valor) {
						System.out.println("Parab�ns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 35);
						System.out.printf("Voc� ganhou %d fichas.", aposta * 36);
					} else {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Voc� perdeu %d fichas.", aposta);
					}
					break;
				case 2:
					System.out.println("Escolha entre (1)par ou (2)impar: ");
					jogada = entrada.nextInt();
					while (jogada < 1 || jogada > 2) {
						System.out.println("Indice inv�lido, tente novamente: ");
						jogada = entrada.nextInt();
					}
					if (jogada == 1) {
						System.out.println("Voc� escolheu os n�meros pares. Quantas fichas deseja apostar?");
						aposta = entrada.nextInt();

						while (aposta > fichas) {
							System.out.println(
									"Aposta inv�lida. Voc� n�o possui fichas suficientes. Aposte um valor valido: ");
							aposta = entrada.nextInt();
						}
						System.out.println("Aposta escolhida: Pares");
						System.out.println("Fichas apostadas: " + aposta);
						System.out.println("N�mero Sorteado: " + valor);

						if (valor % 2 == 1) {
							System.out.println("Aposta perdida.");
							fichas = fichas - aposta;
							System.out.printf("Voc� perdeu %d fichas.", aposta);
						} else if (valor % 2 == 0) {
							System.out.println("Parab�ns! Sua aposta foi vencedora.");
							fichas = fichas - aposta;
							fichas = fichas + (aposta * 2);
							System.out.printf("Voc� ganhou %d fichas.", aposta * 2);
						}

					} else if (jogada == 2) {
						System.out.println("Voc� escolheu os n�meros impares. Quantas fichas deseja apostar?");
						aposta = entrada.nextInt();

						while (aposta > fichas) {
							System.out.println(
									"Aposta inv�lida. Voc� n�o possui fichas suficientes. Aposte um valor valido: ");
							aposta = entrada.nextInt();
						}

						System.out.println("Aposta escolhida: Impares");
						System.out.println("Fichas apostadas: " + aposta);
						System.out.println("N�mero Sorteado: " + valor);

						if (valor % 2 == 1) {
							System.out.println("Parab�ns! Sua aposta foi vencedora.");
							fichas = fichas - aposta;
							fichas = fichas + (aposta * 2);
							System.out.printf("Voc� ganhou %d fichas.", aposta * 2);
						} else if (valor % 2 == 0) {
							System.out.println("Aposta perdida.");
							fichas = fichas - aposta;
							System.out.printf("Voc� perdeu %d fichas.", aposta);
						}
					}
					break;
				case 3:
					System.out.println("TABELA DAS DUZIAS: ");
					System.out.printf("1� 12| (1 a 12)\n2� 12| (13 a 24)\n3� 12| (25 a 36)\n");
					System.out.println("Digite o n�mero da duzia que voc� quer apostar: ");
					jogada = entrada.nextInt();

					while (0 > jogada || jogada > 3) {
						System.out.println("Duzia n�o existente, tente outra: ");
						jogada = entrada.nextInt();
					}

					System.out.printf("Voc� escolheu a %d� duzia. Quantas fichas voc� quer apostar? ", jogada);
					aposta = entrada.nextInt();

					while (aposta > fichas) {
						System.out.println(
								"Aposta inv�lida. Voc� n�o possui fichas suficientes. Aposte um valor valido: ");
						aposta = entrada.nextInt();
					}

					System.out.println("Fichas apostadas: " + aposta);
					System.out.println("D�zia escolhida: " + jogada + "�");
					System.out.println("N�mero sorteado: " + valor);

					if (jogada == 1 && valor <= 12) {
						System.out.println("Parab�ns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 3);
						System.out.printf("Voc� ganhou %d fichas.", aposta * 3);
					} else if (jogada == 2 && 12 < valor && valor <= 24) {
						System.out.println("Parab�ns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 3);
						System.out.printf("Voc� ganhou %d fichas.", aposta * 3);
					} else if (jogada == 3 && 24 < valor && valor <= 36) {
						System.out.println("Parab�ns! Sua aposta foi vencedora.");
						fichas = fichas - aposta;
						fichas = fichas + (aposta * 3);
						System.out.printf("Voc� ganhou %d fichas.", aposta * 3);
					} else if (jogada == 1 && valor > 12) {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Voc� perdeu %d fichas.", aposta);
					} else if (jogada == 2 && 12 >= valor || valor > 24) {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Voc� perdeu %d fichas.", aposta);
					} else if (jogada == 3 && 24 >= valor || valor > 36) {
						System.out.println("Aposta perdida.");
						fichas = fichas - aposta;
						System.out.printf("Voc� perdeu %d fichas.", aposta);
					}
					break;
				default:
					System.out.println("Indice AINDA n�o existente. Programa em desenvolvimento.");
					System.out.println("Aguarde a pr�xima atualiza��o para acessar as novidades.");
					break;
				}

				System.out.printf("Voc� possui %d fichas \n", fichas);

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
		
		// PR�XIMOS PASSOS: CRIAR SE DEU BEM E SE DEU MAL COM PARTICIPANTE COM MAIOR E MENOR SALDO
		// MOSTRAR PARTICIPANTE COM MAIOR E MENOR NUMERO DE FICHAS NO FINAL
		// USAR CLASSES E METODOS PRA DEIXAR CODIGO MENOR
		// UPAR NO GIT HUB
		// FINISH, DAR SEGUIMENTO AS AULAS

		entrada.close();
	}
}
