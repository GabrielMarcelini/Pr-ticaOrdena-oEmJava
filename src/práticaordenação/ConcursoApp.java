/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package práticaordenação;

/**
 *
 * @author Gabriel
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcursoApp {
    public static void main(String[] args) {
        String arquivoCSV = "dadosConcurso.csv"; // Nome do arquivo CSV com os dados
        List<Candidato> candidatos = new ArrayList<>();

        // Carregar os dados do CSV
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int identificador = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String dataNascimento = dados[2];
                int nota = Integer.parseInt(dados[3]);
                Candidato candidato = new Candidato(identificador, nome, dataNascimento, nota);
                candidatos.add(candidato);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Converter List para Array para usar o InsertionSort
        Candidato[] arrayCandidatos = candidatos.toArray(new Candidato[0]);

        // Criar instância do InsertionSort e ordenar
        InsertionSort<Candidato> sorter = new InsertionSort<>();
        sorter.sort(arrayCandidatos);

        for (Candidato c : arrayCandidatos) {
            System.out.println(c);
        }
    }
}