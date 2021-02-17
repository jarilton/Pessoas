package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<Contribuinte>();
		
		System.out.println("Digite o número de contribuinte: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Dados do contribuinte #" + i + ":");
			System.out.println("Pessoa fisica ou juridica (f/j)? ");
			char type = sc.next().charAt(0);
			System.out.println("Nome: ");
			String nome = sc.next();
			System.out.println("Renda anual: ");
			Double rendaAnual = sc.nextDouble();
			if(type == 'i') {
				System.out.println("Gasto com saúde: ");
				Double gastoComSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastoComSaude));
			}
			else {
				System.out.println("Número de funcionários: ");
				Integer numeroDeFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
			}
			
		}
		
		System.out.println();
		System.out.println("Impostos pagos: ");
		for(Contribuinte con : list) {
			System.out.println(con.getNome() + ": $" + String.format("%.2f", con.imposto()));
		}
		
		System.out.println();
		double sum = 0.0;
		for(Contribuinte con : list) {
			sum += con.imposto();
		}
		System.out.println("Total de imposto: $" + String.format("%.2f", sum));
		
		sc.close();

	}

}
