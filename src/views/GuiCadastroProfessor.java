package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiCadastroProfessor extends JFrame{
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfDataNascimento;
	private JTextField tfNumeroTelefone;
	private JTextField tfCref;
	private JTextField tfEspecialidade;
	private JButton btVoltar;
	public GuiCadastroProfessor() {
		setTitle("Cadastro do professor");
		getContentPane().setLayout(null);
		
		JLabel lbCadastroProfessor = new JLabel("Cadastro do Professor");
		lbCadastroProfessor.setBounds(0, 11, 394, 31);
		lbCadastroProfessor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbCadastroProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbCadastroProfessor);
		
		JLabel lbNome = new JLabel("Nome: ");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(20, 53, 92, 20);
		getContentPane().add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(112, 53, 163, 20);
		getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lbCpf = new JLabel("CPF: ");
		lbCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCpf.setBounds(20, 84, 92, 20);
		getContentPane().add(lbCpf);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(112, 84, 163, 20);
		getContentPane().add(tfCpf);
		tfCpf.setColumns(10);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(112, 115, 163, 20);
		getContentPane().add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		tfNumeroTelefone = new JTextField();
		tfNumeroTelefone.setBounds(112, 146, 163, 20);
		getContentPane().add(tfNumeroTelefone);
		tfNumeroTelefone.setColumns(10);
		
		JLabel lbDataNascimento = new JLabel("Data de nascimento: ");
		lbDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDataNascimento.setBounds(10, 115, 102, 20);
		getContentPane().add(lbDataNascimento);
		
		JLabel lbNumeroTelefone = new JLabel("Telefone: ");
		lbNumeroTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNumeroTelefone.setBounds(20, 146, 92, 20);
		getContentPane().add(lbNumeroTelefone);
		
		JLabel lbCref = new JLabel("CREF: ");
		lbCref.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCref.setBounds(10, 177, 102, 20);
		getContentPane().add(lbCref);
		
		tfCref = new JTextField();
		tfCref.setColumns(10);
		tfCref.setBounds(112, 177, 163, 20);
		getContentPane().add(tfCref);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setColumns(10);
		tfEspecialidade.setBounds(112, 208, 163, 20);
		getContentPane().add(tfEspecialidade);
		
		JLabel lbEspecialidade = new JLabel("Especialidade: ");
		lbEspecialidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEspecialidade.setBounds(10, 208, 102, 20);
		getContentPane().add(lbEspecialidade);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCadastrar.setBounds(20, 250, 89, 23);
		getContentPane().add(btCadastrar);
		
		btVoltar = new JButton("Voltar");
		btVoltar.setBounds(152, 250, 89, 23);
		getContentPane().add(btVoltar);
		
		JButton btCadastrar_2 = new JButton("Cadastrar");
		btCadastrar_2.setBounds(285, 250, 89, 23);
		getContentPane().add(btCadastrar_2);
	}
}
