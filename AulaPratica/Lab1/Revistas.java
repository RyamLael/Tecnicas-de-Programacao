package AulaPratica;

public class Revistas extends Publicacoes{

    public Revistas(String titulo, String AnoDePublicacao, String Autor, int QuantDisponivel) {
        super(titulo, AnoDePublicacao, Autor, QuantDisponivel);
        this.tipo="revistas";
    }
}