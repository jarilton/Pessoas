package entities;

public class PessoaJuridica extends Contribuinte {
	
	private Integer numeroDeFuncionarios;
	
	public PessoaJuridica() {
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}


	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double imposto() {
		if(numeroDeFuncionarios > 18) {
			return getRendaAnual() * 0.14;
		}
		else {
			return getRendaAnual() * 0.16;
		}
	}

	
}
