package lista4Qst2;

public class Empregado {
	
	private String firstname;
	private String surname;
	private float salary;
	private float anualsalary;
	
	public Empregado(String fistname, String surname, float salary){
		this.firstname=fistname;
		this.surname=surname;
		
		if(salary>0)
			this.salary=salary;	
		else
			this.salary=0;
	}
	
	// métodos
	public String getFirstname(){
		return this.firstname;
	}
	public void setFirstname(String firstname){
		this.firstname=firstname;
	}
	public String getSurname(){
		return this.surname;
	}
	public void setSurname(String surname){
		this.surname=surname;
	}
	public float getSalary(){
		return this.salary;
	}
	public void setSalary(float salary){
		this.salary+=salary;
		//O add salary na verdade adiciona o salário (porque pra mim faz mais sentido assim)
		if(this.salary<0) {
			this.salary=0;
		}
	}
	public float getAnualSalary(float salary) {
		anualsalary=salary*12;
		return anualsalary;
	}
	
	//fiz esse método so pra o aumento do salário nao ser algo que qualquer pessoa pode alterar 
	public void salaryIncrease(String senha, String name) {
		if(senha=="Senha123") {
			AuthorizedsalaryIncrease(name);
		}
	}
	private void AuthorizedsalaryIncrease(String name) {
		this.salary=(float) (this.salary + (0.1) * this.salary);
		System.out.println(name+ ": O salario aumentou para "+ this.salary +"$ mensais");
	}
	
}
