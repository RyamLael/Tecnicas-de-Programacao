package Lista4Qst18;
public class Moeda extends Entidade{
	
	public Moeda(int celulaOrigem, Plano plano) {
		plano.listaCelulas.get(celulaOrigem).moeda=this;
	}
}
