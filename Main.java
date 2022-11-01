import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();
        LocalTime horarioChegada = LocalTime.of(10, 30);
        String nome = "Carla";
        Cliente cliente1 = new Cliente(nome, horarioChegada);
        fila.enfileirar(cliente1);
        horarioChegada = LocalTime.of(10, 50);
        nome = "Fernando";
        Cliente cliente2 = new Cliente(nome, horarioChegada);
        fila.enfileirar(cliente2);
        horarioChegada = LocalTime.of(11, 10);
        nome = "Rebeca";
        Cliente cliente3 = new Cliente(nome, horarioChegada);
        fila.enfileirar(cliente3);
        horarioChegada = LocalTime.of(11, 30);
        nome = "Emanuel";
        Cliente cliente4 = new Cliente(nome, horarioChegada);
        fila.enfileirar(cliente4);
        fila.imprimir();
        double tempoMedio = fila.obterTempoMedioEspera(LocalTime.now());
        System.out.println(tempoMedio);
        fila.verificaExistencia("Rebeca");
        System.out.println(fila.verificaExistencia("Rebeca") + "-" + fila.verificaExistencia("Sophia"));
        fila.verificaExistencia("Sophia");
        fila.obterNumClientesAFrente("Paula");
        System.out.println(fila.obterNumClientesAFrente("Emanuel") + " Pessoas na frente");
        Fila filaCopiada = fila.copiar();
        filaCopiada.imprimir();
        Fila FilaPar = fila.copiar();
        FilaPar.imprimir();
    }
}
