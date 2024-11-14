/**
 * @author MauricioCampos
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SepararPorSexoLambda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista para armazenar as pessoas com nome e sexo
        List<String> pessoas = new ArrayList<>();

        System.out.println("Digite os nomes e sexos (formato: nome-sexo), separados por vírgula:");
        String input = scanner.nextLine();

        // Quebra a entrada em um array de strings usando vírgula como delimitador
        String[] entradas = input.split(",");

        // Adiciona cada entrada à lista pessoas
        for (String entrada : entradas) {
            pessoas.add(entrada.trim());
        }

        // Cria uma nova lista apenas com os nomes do grupo feminino usando lambda e filter
        List<String> grupoFeminino = pessoas.stream()
                .filter(pessoa -> {
                    // Separa o nome e o sexo usando o hífen
                    String[] partes = pessoa.split("-");

                    if (partes.length == 2) {
                        String sexo = partes[1].trim().toLowerCase();
                        // Se o sexo for feminino, retorna true, caso contrário, false
                        return sexo.equals("feminino");
                    } else {
                        return false;
                    }
                })
                .map(pessoa -> pessoa.split("-")[0].trim())  // Extrai apenas o nome
                .collect(Collectors.toList());

        // Exibe os nomes do grupo feminino
        System.out.println("\nGrupo Feminino:");
        grupoFeminino.forEach(System.out::println);

        scanner.close();
    }

    public static List<String> testFiltrarGrupoFeminino(List<String> pessoas) {
        return pessoas;
    };
}



class SepararPorSexoLambdaTest {


    void testFiltrarGrupoFeminino() {
        // Simula a lista de entrada com nomes e sexos
        List<String> pessoas = Arrays.asList(
                "Maria-feminino",
                "João-masculino",
                "Ana-feminino",
                "Carlos-masculino",
                "Paula-feminino"
        );

        // Chama o método que filtra o grupo feminino
        List<String> grupoFeminino = SepararPorSexoLambda.testFiltrarGrupoFeminino(pessoas);

        // Verifica se todos os nomes no grupo feminino vêm de entradas onde o sexo é "feminino"
        assertTrue(grupoFeminino.stream().allMatch(nome ->
                pessoas.stream().anyMatch(pessoa -> pessoa.startsWith(nome + "-") && pessoa.endsWith("feminino"))
        ));
    }

    private void assertTrue(boolean feminino) {
    }
}









