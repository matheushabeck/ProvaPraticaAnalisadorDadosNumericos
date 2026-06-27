import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] listaNumeros = new int[100]; // vetor p guardar até 100 nums
        int quantidadeNumeros = 0; // conta quantos nums foram digtados

        int quantidadeNumerosPrimos = 0;
        int maiorPrimo = -1;
        int menorPrimo = -1;

        // Vai até 100 números ou para quando for digitado um número negativo
        while (quantidadeNumeros < 100) {
            System.out.print("Digite um número: ");
            int numeroDigitado = scanner.nextInt();

            if (numeroDigitado > 0) { //  aceita só numeros positivos

                int qntdDivisores = 0; // variavel que começa em 0 p ver quantos divisores tem o número

                // armazena o número no local
                listaNumeros[quantidadeNumeros] = numeroDigitado;

                // ve se é par ou ímpar
                if (numeroDigitado % 2 == 0) {
                    System.out.println("número par");
                } else {
                    System.out.println("número impar ");
                }

                // ve se é múltiplo de 3
                if (numeroDigitado % 3 == 0) {
                    System.out.println("multiplo de 3");
                } else {
                    System.out.println("Não é multiplo de 3");
                }

                // ve se está entre 100 e 200
                if (numeroDigitado >= 100 && numeroDigitado <= 200) {
                    System.out.println("Entre 100 e 200 ");
                } else {
                    System.out.println("Não está entre 100 e 200");
                }

                // conta quantos divisores o número possui
                for (int i = 1; i <= numeroDigitado; i++) {
                    if (numeroDigitado % i == 0) {
                        qntdDivisores++;
                    }
                }

                // se tiver só 2 divisores é primo
                if (qntdDivisores == 2) {
                    System.out.println("é um número primo");

                } else {
                    System.out.println("não é um número primo");
                    System.out.print("Divisores: ");

                    // mostra todos os divisores do número
                    for (int i = 1; i <= numeroDigitado; i++) {
                        if (numeroDigitado % i == 0) {
                            System.out.print(i + " ");
                        }
                    }
                }

                System.out.println("\n");

                quantidadeNumeros++; // fica aumentando

            } else {
                break; // sai se for negativpo
            }
        }

        // ve se nenhum número foi digitado
        if (quantidadeNumeros == 0) {
            System.out.println("Nenhuma entrada de dados ");
        }

        System.out.println("\n** Relatório **");
        System.out.println("Numeros Listados: ");

        // mostra todos os números digitados
        for (int i = 0; i < quantidadeNumeros; i++) {
            System.out.print(listaNumeros[i] + ", ");
        }

        int soma = 0;
        int maiorNumero = listaNumeros[0];
        int menorNumero = listaNumeros[0];

        for (int i = 0; i < quantidadeNumeros; i++) {
            soma += listaNumeros[i]; // fica somando

            // fica vendo o maior
            if (listaNumeros[i] > maiorNumero) {
                maiorNumero = listaNumeros[i];
            }

            // fica vendo o menor
            if (listaNumeros[i] < menorNumero) {
                menorNumero = listaNumeros[i];
            }
        }

        double media = (double) soma / quantidadeNumeros; //  média

        System.out.println("\nQuantidade de números: " + quantidadeNumeros);
        System.out.println("Média: " + media);
        System.out.println("Maior número: " + maiorNumero);
        System.out.println("Menor número: " + menorNumero);


        for (int i = 0; i < quantidadeNumeros; i++) {  // procura os números primos da lista

            int divisores = 0;

            // Conta os divisores do número
            for (int j = 1; j <= listaNumeros[i]; j++) {
                if (listaNumeros[i] % j == 0) {
                    divisores++;
                }
            }

            // se for primo, atualiza as informações
            if (divisores == 2) {

                quantidadeNumerosPrimos++;

                // o -1 é que ele ainda não achou num primo, quando ele achar, vai iniciar ele, e assim que ele achar outro, vai comparar com ele p ver se é maior ou menor e imprimir
                if (maiorPrimo == -1 || listaNumeros[i] > maiorPrimo) {
                    maiorPrimo = listaNumeros[i];
                }
                if (menorPrimo == -1 || listaNumeros[i] < menorPrimo) {
                    menorPrimo = listaNumeros[i];
                }
            }
        }

        // Percorre todos os números que foram digitados
        for (int i = 0; i < quantidadeNumeros; i++) {

            // Guarda quantos divisores o número atual possui
            int divisores = 0;

            // Testa todos os números de 1 até o próprio número
            for (int j = 1; j <= listaNumeros[i]; j++) {

                // Se a divisão for exata, encontrou um divisor
                if (listaNumeros[i] % j == 0) {
                    divisores++;
                }
            }

            // se encontrou exatamente 2 divisores, o número é primo
            if (divisores == 2) {
                quantidadeNumerosPrimos++; // fica aumentando

                // o -1 é que ele ainda não achou num primo, quando ele achar, vai iniciar ele, e assim que ele achar outro, vai comparar com ele p ver se é maior ou menor primo e imprimir
                if (maiorPrimo == -1 || listaNumeros[i] > maiorPrimo) {
                    maiorPrimo = listaNumeros[i];
                }

                // Se ainda não existe menor primo ou encontrou um menor, atualiza
                if (menorPrimo == -1 || listaNumeros[i] < menorPrimo) {
                    menorPrimo = listaNumeros[i];
                }
            }
        }

        System.out.println("Quantidade de números primos: " + quantidadeNumerosPrimos); // imprime quantos números primos foram encontrados

        // ve se existe pelo menos um número primo e imprime as comparacoes
        if (quantidadeNumerosPrimos > 0) {
            System.out.println("Maior número primo: " + maiorPrimo);
            System.out.println("Menor número primo: " + menorPrimo);
        } else {
            System.out.println("nenhum número primo foi escrito"); // se não tiver primo no codigo
        }

        int moda = listaNumeros[0]; // começa assumindo que a moda é o primeiro número digitado
        int maiorFrequencia = 0; // vai guarda a maior quantidade de repetições que ele achar

        // vai ver todos os números para ver qual mais se repete
        for (int i = 0; i < quantidadeNumeros; i++) {

            int frequencia = 0; // conta quantas vezes o número atual aparece

            // compara o número atual com todos os outros
            for (int j = 0; j < quantidadeNumeros; j++) {

                // se forem iguais, aumenta a frequência
                if (listaNumeros[i] == listaNumeros[j]) {
                    frequencia++;
                }
            }

            // Se a frequência encontrada for maior que a anterior
            if (frequencia > maiorFrequencia) {
                maiorFrequencia = frequencia; // Atualiza a maior frequência
                moda = listaNumeros[i]; // Atualiza a maior frequência
            }
        }

        System.out.println("Moda: " + moda);
        System.out.println("Quantidade de vezes que apareceu: " + maiorFrequencia); // imprime quantas vezes a moda apareceu

        double mediana;

        if (quantidadeNumeros % 2 == 0) {   // Verifica se a quantidade de números é par

            // Calcula a média dos dois números do meio
            mediana = (listaNumeros[(quantidadeNumeros / 2) - 1] +
                    listaNumeros[quantidadeNumeros / 2]) / 2.0;
        } else {
            // Se for ímpar, pega o número que está exatamente no meio
            mediana = listaNumeros[quantidadeNumeros / 2];
        }

        System.out.println("Mediana: " + mediana); // imprime a mediana

        // ve se é possível calcular o fatorial
        if (menorNumero <= 20) {
            long fatorial = 1; // Começa o fatorial com 1

            // multiplica todos os números de 1 até o menor número
            for (int i = 1; i <= menorNumero; i++) {
                fatorial *= i; // Vai acumulando o resultado do fatorial
            }
            System.out.println("Fatorial do menor número: " + fatorial); // imprime o resultado do fatorial
        } else {
            System.out.println("O menor número é maior que 20. Fatorial não calculado."); // se o número for maior que 20 ele não vai calcula o fatorial
        }

    }
}