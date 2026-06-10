package views;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.AlunoDAO;
import models.BD;
import models.TipoOperacaoBD;
import models.Aluno;

public class GuiCadastroAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private JLabel lbTitulo;
	    private JLabel lbMatricula;
	    private JLabel lbNome;
	    private JLabel lbCpf;
	    private JLabel lbDataNascimento;
	    private JLabel lbTelefone;
	 
	    private JTextField tfMatricula;
	    private JTextField tfNome;
	    private JTextField tfCpf;
	    private JTextField tfDataNascimento;
	    private JTextField tfTelefone;
	 
	    private JButton btSalvar;
	    private JButton btBuscar;
	    private JButton btAlterar;
	    private JButton btExcluir;
	    private JButton btLimpar;
	    
	    public GuiCadastroAluno() {
	        inicializarComponentes();
	        definirEventos();
	    }
	 
	    private void inicializarComponentes() {
	        setTitle("Cadastro de Aluno");
	        setSize(600, 500);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setResizable(false);
	 
	        JPanel painel = new JPanel();
	        painel.setLayout(new GridBagLayout());
	        painel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(4, 4, 4, 4);
	 
	        // Título
	        lbTitulo = new JLabel("Cadastro de Aluno", SwingConstants.CENTER);
	        lbTitulo.setFont(new Font("Arial", Font.BOLD, 16));
	        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
	        painel.add(lbTitulo, gbc);
	        gbc.gridwidth = 1;
	 
	        // Matrícula
	        lbMatricula = new JLabel("Matrícula:");
	        gbc.gridx = 0; gbc.gridy = 1;
	        painel.add(lbMatricula, gbc);
	        tfMatricula = new JTextField(15);
	        gbc.gridx = 1; gbc.gridy = 1;
	        painel.add(tfMatricula, gbc);
	 
	        // Nome
	        lbNome = new JLabel("Nome:");
	        gbc.gridx = 0; gbc.gridy = 2;
	        painel.add(lbNome, gbc);
	        tfNome = new JTextField(15);
	        gbc.gridx = 1; gbc.gridy = 2;
	        painel.add(tfNome, gbc);
	 
	        // CPF
	        lbCpf = new JLabel("CPF:");
	        gbc.gridx = 0; gbc.gridy = 3;
	        painel.add(lbCpf, gbc);
	        tfCpf = new JTextField(15);
	        gbc.gridx = 1; gbc.gridy = 3;
	        painel.add(tfCpf, gbc);
	 
	        // Data de Nascimento
	        lbDataNascimento = new JLabel("Data Nasc. (dd/MM/yyyy):");
	        gbc.gridx = 0; gbc.gridy = 4;
	        painel.add(lbDataNascimento, gbc);
	        tfDataNascimento = new JTextField(15);
	        gbc.gridx = 1; gbc.gridy = 4;
	        painel.add(tfDataNascimento, gbc);
	 
	        // Telefone
	        lbTelefone = new JLabel("Telefone:");
	        gbc.gridx = 0; gbc.gridy = 5;
	        painel.add(lbTelefone, gbc);
	        tfTelefone = new JTextField(15);
	        gbc.gridx = 1; gbc.gridy = 5;
	        painel.add(tfTelefone, gbc);
	 
	        // Painel de botões
	        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
	        btSalvar  = new JButton("Salvar");
	        btBuscar  = new JButton("Buscar");
	        btAlterar = new JButton("Alterar");
	        btExcluir = new JButton("Excluir");
	        btLimpar  = new JButton("Limpar");
	 
	        painelBotoes.add(btSalvar);
	        painelBotoes.add(btBuscar);
	        painelBotoes.add(btAlterar);
	        painelBotoes.add(btExcluir);
	        painelBotoes.add(btLimpar);
	 
	        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
	        painel.add(painelBotoes, gbc);
	 
	        add(painel);
	    }
	 
	    private void definirEventos() {
	 
	        // Salvar
	        btSalvar.addActionListener(e -> {
	            Aluno aluno = preencherAluno();
	            if (aluno == null) return;
	 
	            BD bd = new BD();
	            AlunoDAO dao = new AlunoDAO();
	            dao.setBd(bd);
	            dao.setAluno(aluno);
	 
	            String resultado = dao.atualizar(TipoOperacaoBD.INCLUSAO);
	            JOptionPane.showMessageDialog(this, resultado);
	        });
	 
	        // Buscar
	        btBuscar.addActionListener(e -> {
	            if (tfMatricula.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(this, "Informe a matrícula!");
	                return;
	            }
	 
	            Aluno aluno = new Aluno();
	            aluno.setMatricula(Integer.parseInt(tfMatricula.getText()));
	 
	            BD bd = new BD();
	            AlunoDAO dao = new AlunoDAO();
	            dao.setBd(bd);
	            dao.setAluno(aluno);
	 
	            if (dao.localizar()) {
	                tfNome.setText(aluno.getNome());
	                tfCpf.setText(aluno.getCpf());
	                tfTelefone.setText(String.valueOf(aluno.getNumeroTelefone()));
	                if (aluno.getDataNascimento() != null) {
	                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                    tfDataNascimento.setText(sdf.format(aluno.getDataNascimento()));
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Aluno não encontrado!");
	            }
	        });
	 
	        // Alterar
	        btAlterar.addActionListener(e -> {
	            Aluno aluno = preencherAluno();
	            if (aluno == null) return;
	 
	            BD bd = new BD();
	            AlunoDAO dao = new AlunoDAO();
	            dao.setBd(bd);
	            dao.setAluno(aluno);
	 
	            String resultado = dao.atualizar(TipoOperacaoBD.ALTERACAO);
	            JOptionPane.showMessageDialog(this, resultado);
	        });
	 
	        // Excluir
	        btExcluir.addActionListener(e -> {
	            if (tfMatricula.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(this, "Informe a matrícula!");
	                return;
	            }
	 
	            int confirm = JOptionPane.showConfirmDialog(this,
	                "Deseja excluir este aluno?", "Confirmação",
	                JOptionPane.YES_NO_OPTION);
	 
	            if (confirm == JOptionPane.YES_OPTION) {
	                Aluno aluno = new Aluno();
	                aluno.setMatricula(Integer.parseInt(tfMatricula.getText()));
	 
	                BD bd = new BD();
	                AlunoDAO dao = new AlunoDAO();
	                dao.setBd(bd);
	                dao.setAluno(aluno);
	 
	                String resultado = dao.atualizar(TipoOperacaoBD.EXCLUSAO);
	                JOptionPane.showMessageDialog(this, resultado);
	                limparCampos();
	            }
	        });
	 
	        // Limpar
	        btLimpar.addActionListener(e -> limparCampos());
	    }
	 
	    private Aluno preencherAluno() {
	        if (tfMatricula.getText().isEmpty() || tfNome.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Matrícula e Nome são obrigatórios!");
	            return null;
	        }
	 
	        Aluno aluno = new Aluno();
	        try {
	            aluno.setMatricula(Integer.parseInt(tfMatricula.getText()));
	            aluno.setNome(tfNome.getText());
	            aluno.setCpf(tfCpf.getText());
	            aluno.setNumeroTelefone(tfTelefone.getText());
	 
	            if (!tfDataNascimento.getText().isEmpty()) {
	                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                aluno.setDataNascimento(sdf.parse(tfDataNascimento.getText()));
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Matrícula e Telefone devem ser números!");
	            return null;
	        } catch (ParseException ex) {
	            JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/MM/yyyy");
	            return null;
	        }
	 
	        return aluno;
	    }
	 
	    private void limparCampos() {
	        tfMatricula.setText("");
	        tfNome.setText("");
	        tfCpf.setText("");
	        tfDataNascimento.setText("");
	        tfTelefone.setText("");
	    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCadastroAluno frame = new GuiCadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */


}
