package AulaPratica;

public class Livros extends Publicacoes{

    public Livros(String titulo, String AnoDePublicacao, String Autor, int QuantDisponivel) {
        super(titulo, AnoDePublicacao, Autor, QuantDisponivel);
        this.tipo="Livros";
    }
}