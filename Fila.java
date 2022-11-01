import java.time.LocalTime;
import java.time.Duration;

public class Fila {
    private Elemento frente; // Frente sempre vai apontar para o Null
    private Elemento tras; // tras sempre apontar para o último elemento que entrou na fila
    private int tamanho; // Tamanho da fila

    public Fila() { // Método construtor da fila
        this.frente = new Elemento(null); // Null sempre "vai ser o primeiro da fila"
        this.tras = this.frente; // Quando tra e frente iguais, fila vazia
        this.tamanho = 0; // tamanho da fila
    }

    public void enfileirar(Cliente cli) { // Método que insere um cliente na fila já enfileirado
        Elemento elem = new Elemento(cli); // O elemento recebe o cli
        this.tras.proximo = elem; // O link "próximo" é criado e aponta para o elemento
        this.tras = elem; // O link "tras" vai para o último elemento
        this.tamanho++; // O tamanho da fila aumenta
    }

    public Cliente desenfileirar() { // Método para tirar o elemenoto em ordem
        Cliente cli = this.obterPrimeiro(); // cli recebe o primeiro da fila
        this.frente.proximo = this.frente.proximo.proximo; // O primeiro elemento vira o segundo
        this.tamanho--; // O tamanho diminui pq sai um elemento
        return cli; // Retorna o primeiro da fila que saiu
    }

    public Boolean filaVazia() { // Método para saber se a fila é vazia
        if (this.frente == this.tras) {
            return true;
        }
        return false;
    }

    public Cliente obterPrimeiro() { // Devolve o primeiro da fila
        if (this.filaVazia()) {
            return null;
        }
        return this.frente.proximo.cli;
    }

    public int obterNumeroClientes() { // Método que retorna o tamanho da fila
        return this.tamanho;
    }

    public void imprimir() { // Método que imprime a fila em ordem
        Elemento atual = this.frente.proximo;
        while (atual != null) {
            System.out.println(atual.cli.nome);
            atual = atual.proximo;
        }
    }

    public Fila dividir() { // Método que divide a fila com as posições pares
        Fila filaPar = new Fila(); // Criada uma nova fila
        Elemento atual = this.frente.proximo; // Atual recebe o primeiro
        while (atual != null) {
            filaPar.enfileirar(atual.proximo.cli); // A nova fila recebe o cliente 
            atual.proximo = atual.proximo.proximo; // O segundo vira o terceiro
            atual = atual.proximo; // O atual pula um elemento por causa da fila par 
        }
        return filaPar;
    }

    public Boolean verificaExistencia(String nomeCliente) { // método que verifica a existencia de um cleinte na fila
        Elemento atual = this.frente.proximo;
        while (atual != null) {
            if (atual.cli.nome == nomeCliente) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public int obterNumClientesAFrente(String nomeCliente) { // Método que retorna quantos clientes estão na frente do cliente passado como parâmetro
        if (this.verificaExistencia(nomeCliente) == false) { // Se o cliente não existir na fila retorna -1
            return -1;
        }
        int cont = 0; // Contador de clientes
        Elemento atual = frente.proximo; // Elemento atual recebe o primeiro da fila
        while (atual.cli.nome != nomeCliente) { // O while roda até chegar no cliente, e toda vez que ele roda o contador aumenta 1
            cont++;
            atual = atual.proximo; // O atual vira o próximo da fila toda vez que o while roda
        }
        return cont;
    }

    public Fila copiar() { // Método que cria uma cópia da fila 
        Fila copiaFila = new Fila();
        Elemento atual = frente.proximo;
        while (atual != null) {
            copiaFila.enfileirar(atual.cli); // Adciona os elementos com seus respectivos clientes na ordem
            atual = atual.proximo;
        }
        return copiaFila;
    }

    public double obterTempoMedioEspera(LocalTime horarioAtual) { // Método para obter o tempo médio de espera
        if (this.filaVazia()) {
            return -1;
        }
        Elemento atual = frente.proximo;
        double media = 0;
        while (atual != null) {
            media += (double) Duration.between(atual.cli.horarioChegada, horarioAtual).toMinutes();
            atual = atual.proximo;
        }
        media /= this.tamanho;
        return media;
    }

    public int obterNumClientesEsperando(LocalTime horarioAtual) { // Método que conta os clientes esperando por  mais de 15 minutos 
        if (this.filaVazia()) {
            return -1;
        }
        Elemento atual = frente.proximo;
        int count = 0;
        long duracao = 0;
        while (atual != null) {
            duracao = Duration.between(atual.cli.horarioChegada, horarioAtual).toMinutes();
            if (duracao > 15) {
                count++;
            }
            atual = atual.proximo;
        }
        return count;
    }
}
