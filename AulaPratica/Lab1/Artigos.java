package AulaPratica;

public class Artigos extends Publicacoes{

    public Artigos(String titulo, String AnoDePublicacao, String Autor, int QuantDisponivel) {
        super(titulo, AnoDePublicacao, Autor, QuantDisponivel);
        this.tipo="artigos";
    }
}