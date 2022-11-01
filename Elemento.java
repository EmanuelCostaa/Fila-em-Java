public class Elemento {
    public Cliente cli; // Cria o cliente dentro do elemento
    public Elemento proximo; // Cria o Link para o próximo elemento

    public Elemento(Cliente cli){ // Método construtor 
        this.cli = cli; 
        this.proximo = null; 
    }
}
