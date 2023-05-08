package AulaPratica;

public abstract class Publicacoes {

	public String tipo;
    public String Titulo;
    public String AnoDePublicacao;
    public String Autor;
    public int QuantDisponivel;
    public int diasAlugado;
   

    public Publicacoes(String titulo, String AnoDePublicacao, String Autor, int  QuantDisponivel ) {
        this.Titulo=titulo;
        this.AnoDePublicacao=AnoDePublicacao;
        this.Autor=Autor;
        this.QuantDisponivel=QuantDisponivel;
        this.diasAlugado=0;
    }

	public String getTitulo() {
		return Titulo;
	}

	public String getAnoDePublicacao() {
		return AnoDePublicacao;
	}

	public String getAutor() {
		return Autor;
	}

	public int getQuantDisponivel() {
		return QuantDisponivel;
	}
	
	public void exibirPublicacao() {
		
	}

}