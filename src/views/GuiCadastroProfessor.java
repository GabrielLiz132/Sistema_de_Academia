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
	private JLabel lbNome, lbCpf, lbDataNascimento, lbNumeroTelefone, lbCref, lbEspecialidade;
	private JButton btSalvar, btBuscar, btAlterar, btExcluir, btLimpar;
	
	public GuiCadastroProfessor() {
		inicializarComponentes();
		definirEventos();
	}
	public void inicializarComponentes() {
		setTitle("Cadastro do professor");
		setBounds(600, 410, 446, 359);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        contentPane = getContentPane();
        contentPane.setLayout(null);
		
		JLabel lbCadastroProfessor = new JLabel("Cadastro do Professor");
		lbCadastroProfessor.setBounds(0, 11, 465, 31);
		lbCadastroProfessor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbCadastroProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbCadastroProfessor);
		
		lbNome = new JLabel("Nome: ");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(20, 53, 124, 20);
		getContentPane().add(lbNome);
		
		tfNome = new JTextField(); 
		tfNome.setBounds(154, 53, 163, 20);
		getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		lbCpf = new JLabel("CPF: ");
		lbCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCpf.setBounds(20, 84, 124, 20);
		getContentPane().add(lbCpf);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(154, 84, 163, 20);
		getContentPane().add(tfCpf);
		tfCpf.setColumns(10);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(154, 115, 163, 20);
		getContentPane().add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		tfNumeroTelefone = new JTextField();
		tfNumeroTelefone.setBounds(154, 146, 163, 20);
		getContentPane().add(tfNumeroTelefone);
		tfNumeroTelefone.setColumns(10);
		
		lbDataNascimento = new JLabel("Data Nasc. (dd/MM/yyyy):");
		lbDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDataNascimento.setBounds(10, 115, 134, 20);
		getContentPane().add(lbDataNascimento);
		
		lbNumeroTelefone = new JLabel("Telefone: ");
		lbNumeroTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNumeroTelefone.setBounds(20, 146, 124, 20);
		getContentPane().add(lbNumeroTelefone);
		
		lbCref = new JLabel("CREF: ");
		lbCref.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCref.setBounds(10, 177, 134, 20);
		getContentPane().add(lbCref);
		
		tfCref = new JTextField();
		tfCref.setColumns(10);
		tfCref.setBounds(154, 177, 163, 20);
		getContentPane().add(tfCref);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setColumns(10);
		tfEspecialidade.setBounds(154, 208, 163, 20);
		getContentPane().add(tfEspecialidade);
		
		lbEspecialidade = new JLabel("Especialidade: ");
		lbEspecialidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEspecialidade.setBounds(10, 208, 134, 20);
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
	 
	        btLimpar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                limparCampos();
	            }
	        });
	    }
	 private Professor preencherProfessor() {
		 if (tfCpf.getText().isEmpty() || tfNome.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null, "CPF e Nome são obrigatórios!");
			 return null;
		 }
	 
	        Professor professor = new Professor();
	        try {
	        
	            professor.setNome(tfNome.getText());
	            professor.setCpf(tfCpf.getText());
	         
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
