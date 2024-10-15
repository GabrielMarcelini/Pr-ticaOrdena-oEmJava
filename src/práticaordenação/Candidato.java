/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package práticaordenação;

/**
 *
 * @author Gabriel
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Candidato implements Comparable<Candidato> {
    private int identificador;
    private String nome;
    private Date dataNascimento;
    private int nota;
    
    public Candidato(int identificador, String nome, String dataNascimento, int nota) {
        this.identificador = identificador;
        this.nome = nome;
        this.nota = nota;
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getNota() {
        return nota;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public int compareTo(Candidato outro) {
        // Primeiro comparar pela nota (em ordem decrescente)
        int notaComparison = Integer.compare(outro.getNota(), this.getNota());
        if (notaComparison != 0) {
            return notaComparison;
        }
        // Se as notas forem iguais, comparar pela idade (data de nascimento)
        return this.getDataNascimento().compareTo(outro.getDataNascimento());
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "identificador=" + identificador +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento) +
                ", nota=" + nota +
                '}';
    }
}