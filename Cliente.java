import java.time.LocalTime;

public class Cliente{
    String nome;
    LocalTime horarioChegada;

    public Cliente(String nome, LocalTime horarioChegada){
        this.nome = nome;
        this.horarioChegada = horarioChegada;
    }
}