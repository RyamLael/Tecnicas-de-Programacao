package AulaPratica;

import java.util.ArrayList;

public class Biblioteca {
	//posso tirar esse public clientes e publicacoes
	
    public float totalTps;
    public DadosEmprestimos dadosEmprestimo;
    public ArrayList<DadosEmprestimos> listaEmprestimos;
    public ArrayList<Publicacoes> listaPublicacoes;
    public ArrayList<Clientes> listadeClientes;
    
    public Biblioteca() {
    	listaEmprestimos= new ArrayList<DadosEmprestimos>();
    	listaPublicacoes= new ArrayList<Publicacoes>();
    	listadeClientes= new ArrayList<Clientes>();
    	dadosEmprestimo= new DadosEmprestimos();
    }
    
    public void emprestimo(String nomeCliente, String tituloPublicacao) {
    	
    	//Aqui pesquisamos um objeto cliente e um objeto publicação
    	for(Clientes cliente : listadeClientes) {
    		if(cliente.Name==nomeCliente) {
    			for (Publicacoes publicacoes : listaPublicacoes) {
    				if(publicacoes.Titulo==tituloPublicacao) {
    					
    					if(cliente.quantEmprestimos<cliente.maxEmprestimos) {
	    					cliente.quantEmprestimos++;
	    		    	
	    					if(cliente instanceof Alunos) {
	    						cliente.Tps+=10*Desconto(publicacoes);
	    						totalTps+=10*Desconto(publicacoes);
					        }
					        else if(cliente instanceof Servidores) {
					            cliente.Tps+=15;
					            totalTps+=15;
					        }
					        else if(cliente instanceof Professores) {
					            cliente.Tps+=25;
					            totalTps+=25;
					        }
	    					 System.out.println("\nOperação concluida. Você pode ficar com a publicação por "+ cliente.duracaoEmprestimo+ " dias\nTps atuais:"+ cliente.Tps);
					        if(cliente.Tps%50==0) {
					        	System.out.println("O cliente deve doar uma publicação");
					        }
					       
					        cliente.publicacoesemPosse.add(publicacoes);
					    	dadosEmprestimo.cliente=cliente;
					    	listaEmprestimos.add(dadosEmprestimo);				 
    				 	 }
    					else
    						System.out.println("Você já alugou o máximo de livros permitidos! Devolva uma publicação para continuar.");
    					}
    				}
    			}
		}
    }
 
    public float Desconto(Publicacoes publicacao){
        if(publicacao instanceof Livros) {
            return (float)(0.9);
        }
        if(publicacao instanceof Revistas) {
            return (float)(0.99);
        }
        if(publicacao instanceof Artigos) {
            return (float)(0.5);
        }
        else {
            return 0;
        }
    }

    public void pesquisarPublicacao(String NomedaPublicacao) {
    	for (Publicacoes publicacoes : listaPublicacoes) {
    		if(publicacoes.Titulo==NomedaPublicacao) {
    			System.out.println("\nO título da publicação é: "+publicacoes.Titulo+"\nO autor é: "+publicacoes.Autor+"\nO ano de publicacao é: "+publicacoes.AnoDePublicacao+
    					"\nA quantidade disponível do exemplar é: "+ publicacoes.QuantDisponivel);
     		}
	}
    }

	public void colsultaMatricula(String Matricula) {
		for(Clientes listaClientes : listadeClientes) {
			if(listaClientes.Matricula==Matricula) {
				System.out.println("\nO cliente tem "+ listaClientes.quantEmprestimos+ " Publicações em posse: ");
				for(Publicacoes publicacoesemPosse: listaClientes.publicacoesemPosse) {
					System.out.println(publicacoesemPosse.getTitulo());
				}
			}
		}
	}
	
	public void addPublicacoes(Publicacoes publicacaoes) {
		listaPublicacoes.add(publicacaoes);
	}
	
	public void addClientes(Clientes cliente) {
		listadeClientes.add(cliente);
	}
	
	public void exibirEmprestimos() {
		for(DadosEmprestimos pubEmprestadas: listaEmprestimos ) {
			for(int i=0; i<pubEmprestadas.cliente.publicacoesemPosse.size(); i++)
				if(pubEmprestadas.cliente.publicacoesemPosse.get(i) instanceof Livros) {
				System.out.println("Livros:");
			}
		}
	}
	
	public void exibirClientes() {
		
	}
	
	public void exibirHistorico(){
		
	}
}
