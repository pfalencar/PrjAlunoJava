package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.AlunosJdbcDAO;
import dao.JdbcUtil;
import model.Aluno;


//VER O QUE VOU FAZER COM O MÉTODO "ALTERAR ALUNO" DO AlunosJdbcDAO
//SEPARAR A CLASSE ENDEREÇO DO ALUNO.
//COLOCAR DATA DE NASCIMENTO E GRAVAR NO BANCO...
public class AlunoExec {
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main (String []args) {
		
		
		int menu;
		
		do {		
			AlunoExec.exibirMenu();	
			menu = Integer.parseInt(entrada.nextLine());
			
			switch(menu) {
				case 1:
					System.out.println("==== CADASTRANDO ALUNO ====");
					try {
						AlunoExec.conectar().salvar(AlunoExec.receberDadosCadastro());
						//alunosJdbcDao.salvar(aluno);
					} catch (SQLException e) {
						System.out.println("Não cadastrou.");
						e.printStackTrace();
					}
					break;
					
				case 2: 
					System.out.println("==== PESQUISANDO ALUNO POR NOME ====");
					System.out.println("Digite o nome do aluno a ser pesquisado: ");
					String nomePesquisado = entrada.nextLine();
					List<Aluno> alunos = AlunoExec.conectar().pesquisarPorNome(nomePesquisado);
					for(Aluno a: alunos) {
						a.imprimirAluno();
					}
					break;
					
				case 3:
					System.out.println("==== ALTERANDO ALUNO POR ID ====");
					System.out.println("Digite o id do aluno a ser alterado: ");
					int id = Integer.parseInt(entrada.nextLine());
					AlunoExec.conectar().alterarPorId(AlunoExec.receberDados(),id);
					break;
					
				case 4:
					System.out.println("==== DELETANDO ALUNO ====");
					System.out.println("Digite o id do livro a ser deletado: ");
					int idDeletar = Integer.parseInt(entrada.nextLine());
					AlunoExec.conectar().excluir(idDeletar);
					break;
					
				case 5: 
					System.out.println("==== LISTANDO ALUNOS ====");
					for(Aluno a: AlunoExec.conectar().listar()) {
						a.imprimirAluno();
					}
					break;
					
				case 6: 
					System.out.println("==== SAINDO ====");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		} while (menu != 6);
			
		entrada.close();
	}
	
	public static void exibirMenu() {
		System.out.println("===== MENU ======");
		System.out.println("1 - CADASTRAR ALUNO");
		System.out.println("2 - PESQUISAR ALUNO POR NOME");
		System.out.println("3 - ALTERAR ALUNO POR ID");
		System.out.println("4 - DELETAR ALUNO");
		System.out.println("5 - LISTAR ALUNOS");
		System.out.println("6 - SAIR");
		System.out.println("Digite a opção desejada:");	
	}
	
	public static Aluno receberDadosCadastro() {
		Aluno aluno = new Aluno();	
		System.out.println("Digite o nome do aluno: ");
		aluno.setNome(entrada.nextLine());
		System.out.println("Digite o endereço do aluno: ");
		aluno.setEndereco(entrada.nextLine());
		System.out.println("Digite o bairro do aluno: ");
		aluno.setBairro(entrada.nextLine());
		return aluno;
	}
	
	public static Aluno receberDados() {
		Aluno aluno = new Aluno();	
		System.out.println("Digite o nome do aluno: ");
		aluno.setNome(entrada.nextLine());
		System.out.println("Digite o endereço do aluno: ");
		aluno.setEndereco(entrada.nextLine());
		System.out.println("Digite o bairro do aluno: ");
		aluno.setBairro(entrada.nextLine());
		return aluno;
	}
	
	public static AlunosJdbcDAO conectar() {
		try {
			//o método getConnection() do tipo JdbcUtil é estático. 
			//Portanto, ele pode ser acessado de um maneira estática: JdbcUtil jdbcUtil = new JdbcUtil();
			Connection connection = JdbcUtil.getConnection();		
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			return alunosJdbcDao;
			
		} catch (Exception e) {
			System.out.print("Não conectou...Mensagem de erro: ");
			e.printStackTrace();
			return null;
		}
	}
	
}
