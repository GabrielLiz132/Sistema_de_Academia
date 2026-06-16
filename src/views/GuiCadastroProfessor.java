package views;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;

import models.Professor;
import models.ProfessorDAO;
import models.Bd;
import models.TipoOperacaoBd;

public class GuiCadastroProfessor extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private Container contentPane;
	
	private JTextField tfNome, tfCpf, tfDataNascimento, tfNumeroTelefone, tfCref, tfEspecialidade;
	private JButton btSalvar, btBuscar, btAlterar, btExcluir, btLimpar;
	
	public GuiCadastroProfessor() {
		inicializarComponentes();
		definirEventos();
	}
	public void inicializarComponentes() {
		setTitle("Cadastro do professor");
		setBounds(600, 410, 495, 360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        contentPane = getContentPane();
        contentPane.setLayout(null);
		
		JLabel lbCadastroProfessor = new JLabel("Cadastro do Professor");
		lbCadastroProfessor.setBounds(0, 11, 465, 31);
		lbCadastroProfessor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbCadastroProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbCadastroProfessor);
		
		JLabel lbNome = new JLabel("Nome: ");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(20, 53, 134, 20);
		getContentPane().add(lbNome);
		
		tfNome = new JTextField(); 
		tfNome.setBounds(164, 53, 163, 20);
		getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lbCpf = new JLabel("CPF: ");
		lbCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCpf.setBounds(20, 84, 134, 20);
		getContentPane().add(lbCpf);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(164, 84, 163, 20);
		getContentPane().add(tfCpf);
		tfCpf.setColumns(10);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(164, 115, 163, 20);
		getContentPane().add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		tfNumeroTelefone = new JTextField();
		tfNumeroTelefone.setBounds(164, 146, 163, 20);
		getContentPane().add(tfNumeroTelefone);
		tfNumeroTelefone.setColumns(10);
		
		JLabel lbDataNascimento = new JLabel("Data Nasc. (dd/MM/yyyy):");
		lbDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDataNascimento.setBounds(10, 115, 144, 20);
		getContentPane().add(lbDataNascimento);
		
		JLabel lbNumeroTelefone = new JLabel("Telefone: ");
		lbNumeroTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNumeroTelefone.setBounds(20, 146, 134, 20);
		getContentPane().add(lbNumeroTelefone);
		
		JLabel lbCref = new JLabel("CREF: ");
		lbCref.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCref.setBounds(10, 177, 144, 20);
		getContentPane().add(lbCref);
		
		tfCref = new JTextField();
		tfCref.setColumns(10);
		tfCref.setBounds(164, 177, 163, 20);
		getContentPane().add(tfCref);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setColumns(10);
		tfEspecialidade.setBounds(164, 208, 163, 20);
		getContentPane().add(tfEspecialidade);
		
		JLabel lbEspecialidade = new JLabel("Especialidade: ");
		lbEspecialidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEspecialidade.setBounds(10, 208, 144, 20);
		getContentPane().add(lbEspecialidade);
		
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(20, 257, 80, 25);
		getContentPane().add(btSalvar);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setBounds(110, 257, 80, 25);
		getContentPane().add(btBuscar);
		
		btAlterar = new JButton("Alterar");
		btAlterar.setBounds(200, 257, 80, 25);
		getContentPane().add(btAlterar);
		
		btExcluir = new JButton("Excluir");
		btExcluir.setBounds(290, 257, 80, 25);
		getContentPane().add(btExcluir);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(380, 257, 80, 25);
		getContentPane().add(btLimpar);	
	}
	
	 private void definirEventos() {
		 // Evento responsável por salvar um novo professor no banco de dados
	        btSalvar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Professor professor = preencherProfessor();
	                if (professor == null) return;
	 
	                Bd bd = new Bd();
	                ProfessorDAO dao = new ProfessorDAO();
	                dao.setBd(bd);
	                dao.setProfessor(professor);
	 
	                String resultado = dao.atualizar(TipoOperacaoBd.INCLUSAO);
	                JOptionPane.showMessageDialog(null, resultado);
	            }
	        });
	     // Evento responsável por localizar um professor através do CPF informado
	        btBuscar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (tfCpf.getText().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Informe o CPF do Professor!");
	                    return;
	                }
	 
	                Professor professor = new Professor();
	                professor.setCpf(tfCpf.getText());
	 
	                Bd bd = new Bd();
	                ProfessorDAO dao = new ProfessorDAO();
	                dao.setBd(bd);
	                dao.setProfessor(professor);
	 
	                if (dao.localizar()) {
	                    tfNome.setText(professor.getNome());
	                    tfCpf.setText(professor.getCpf());
	                    tfNumeroTelefone.setText(String.valueOf(professor.getNumeroTelefone()));
	                    if (professor.getDataNascimento() != null) {
	                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                        tfDataNascimento.setText(sdf.format(professor.getDataNascimento()));
	                    tfCref.setText(professor.getCref());
	                    tfEspecialidade.setText(professor.getEspecialidade());
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Professor não encontrado!");
	                }
	            }
	        });
	     // Evento responsável por alterar os dados de um professor já cadastrado
	        btAlterar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Professor professor = preencherProfessor();
	                if (professor == null) return;
	 
	                Bd bd = new Bd();
	                ProfessorDAO dao = new ProfessorDAO();
	                dao.setBd(bd);
	                dao.setProfessor(professor);
	 
	                String resultado = dao.atualizar(TipoOperacaoBd.ALTERACAO);
	                JOptionPane.showMessageDialog(null, resultado);
	            }
	        });
	     // Evento responsável pela exclusão de um professor do sistema
	        btExcluir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (tfCpf.getText().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Informe o CPF!");
	                    return;
	                }
	 
	                int confirm = JOptionPane.showConfirmDialog(null,
	                    "Deseja excluir este Professor?", "Confirmação",
	                    JOptionPane.YES_NO_OPTION);
	 
	                if (confirm == JOptionPane.YES_OPTION) {
	                    Professor professor = new Professor();
	                    professor.setCpf(tfCpf.getText());
	 
	                    Bd bd = new Bd();
	                    ProfessorDAO dao = new ProfessorDAO();
	                    dao.setBd(bd);
	                    dao.setProfessor(professor);
	 
	                    String resultado = dao.atualizar(TipoOperacaoBd.EXCLUSAO);
	                    JOptionPane.showMessageDialog(null, resultado);
	                    limparCampos();
	                }
	            }
	        });
	     // Evento que limpa todos os campos do formulário
	        btLimpar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                limparCampos();
	            }
	        });
	    }
	 
	 //Cria e preenche um objeto Professor com os dados informados na tela
	 private Professor preencherProfessor() {
		 if (tfCpf.getText().isEmpty() || tfNome.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null, "CPF e Nome são obrigatórios!");
			 return null;
		 }
	 
	        Professor professor = new Professor();
	        try {
	        
	            professor.setNome(tfNome.getText());
	            professor.setCpf(tfCpf.getText());
	         // Conversão da data digitada para o tipo Date
	            if (!tfDataNascimento.getText().isEmpty()) {
	                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                professor.setDataNascimento(sdf.parse(tfDataNascimento.getText()));
	            }
	            professor.setNumeroTelefone(tfNumeroTelefone.getText());
	            professor.setCref(tfCref.getText());
	            professor.setEspecialidade(tfEspecialidade.getText());
	            
	        } catch (ParseException ex) {
	            JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy");
	            return null;
	        }
	 
	        return professor;
	    }
	 
	    private void limparCampos() {
	    	
	        tfNome.setText("");
	        tfCpf.setText("");
	        tfDataNascimento.setText("");
	        tfNumeroTelefone.setText("");
	        tfCref.setText("");
	        tfEspecialidade.setText("");
	    }
	    
	    //Abre a tela de cadastro centralizada na tela do usuário
	     
	    public static void abrir() {
	        GuiCadastroProfessor frame = new GuiCadastroProfessor();
	        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setLocation(
	            (tela.width - frame.getSize().width) / 2,
	            (tela.height - frame.getSize().height) / 2
	        );
	        frame.setVisible(true);
	    }
}
