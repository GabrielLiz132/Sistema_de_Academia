package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnAjuda, mnAluno, mnProfessor;
    private JMenuItem miSair;
    private JMenuItem miAluno, miProfessor, miCadastroPlanoTreino, miConsultaPlanoTreino, miPagamento;
    private JMenuItem miSobre;

    public GuiMenuPrincipal() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Menu Principal");
        setBounds(600, 400, 358, 249);

        mnBarra = new JMenuBar();

        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic('A');
        mnBarra.add(mnArquivo);
        
        mnAluno = new JMenu("Aluno");
        mnAluno.setMnemonic('A');
        mnBarra.add(mnAluno);

        mnProfessor = new JMenu("Professor");
        mnProfessor.setMnemonic('P');
        mnBarra.add(mnProfessor);
        
        mnAjuda = new JMenu("Ajuda");
        mnAjuda.setMnemonic('A');
        mnBarra.add(mnAjuda);
        
        miSair = new JMenuItem( "Sair" );
        miSair.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK) );
        mnArquivo.add(miSair);

        miPagamento = new JMenuItem("Pagamento");
        miPagamento.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_C, ActionEvent.ALT_MASK) );
        mnAluno.add(miPagamento);
        
        miCadastroPlanoTreino = new JMenuItem("Cadastro Plano de Treino");
        miCadastroPlanoTreino.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.ALT_MASK) );
        mnProfessor.add(miCadastroPlanoTreino);
        
        miConsultaPlanoTreino = new JMenuItem("Consulta Plano de Treino");
        miConsultaPlanoTreino.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.ALT_MASK) );
        mnAluno.add(miConsultaPlanoTreino);
        
        miAluno = new JMenuItem("Cadastro e Alteração de Aluno");
        miAluno.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_X, ActionEvent.ALT_MASK) );
        mnProfessor.add(miAluno);
        
        miProfessor = new JMenuItem("Cadastro e Alteração de Professor");
        miProfessor.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_J, ActionEvent.ALT_MASK) );
        mnProfessor.add(miProfessor);
        
        
        miSobre = new JMenuItem("Sobre...");
 
        mnAjuda.add(miSobre);
        
        setJMenuBar(mnBarra);
    }

    private void definirEventos() {
        miSair.addActionListener(
                new ActionListener() {
                	public void actionPerformed( ActionEvent e) {
                		System.exit(0);
                	}
                });

        miAluno.addActionListener(
                new ActionListener() {
                	public void actionPerformed( ActionEvent e) {
                		GuiCadastroAluno.abrir();
                		JOptionPane.showMessageDialog(null, "Ação de cadastro de alunos",
                				"Informação", JOptionPane.INFORMATION_MESSAGE );
                	}
                });
        
        miProfessor.addActionListener(
                new ActionListener() {
                	public void actionPerformed( ActionEvent e) {
                		GuiCadastroProfessor.abrir();
                		JOptionPane.showMessageDialog(null, "Ação de cadastro de professor",
								"Informação", JOptionPane.QUESTION_MESSAGE );
                	}
                });
        
        miPagamento.addActionListener(
                new ActionListener() {
                	public void actionPerformed( ActionEvent e) {
                		GuiPagamento.abrir();
                		JOptionPane.showMessageDialog(null, "Ação de cadastro de Compra",
								"Informação", JOptionPane.PLAIN_MESSAGE );
                	}
                });
        
        miCadastroPlanoTreino.addActionListener(
                new ActionListener() {
                	public void actionPerformed( ActionEvent e) {
                		GuiCadastroPlanoTreino.abrir();
                		JOptionPane.showMessageDialog(null, "Ação de cadastro de plano de treino",
								"Informação", JOptionPane.WARNING_MESSAGE );
                	}
                });
        
        miConsultaPlanoTreino.addActionListener(
                new ActionListener() {
                	public void actionPerformed( ActionEvent e) {
                		// aqui vai o codigo para chamar o exemplo 8.3
                		JOptionPane.showMessageDialog(null, "Ação de consulta de plano de treino",
								"Informação", JOptionPane.WARNING_MESSAGE );
                	}
                });
        
        miSobre.addActionListener(
                new ActionListener() {
                	public void actionPerformed( ActionEvent e) {
                		// aqui vai o codigo para chamar o exemplo 8.3
                		String message = "Desenvolvidos por:\n" +
                						 "KyryIx - https://github.com/KyryIx\n" +
                						 "SrOtimizacao - https://github.com/SrOtimizacao\n" + 
                						 "Roubado por kty e pinlfloydson para o nosso projeto ";
                		String title = "Créditos";
                		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE );
                	}
                });
    }

    public static void abrir() {
        GuiMenuPrincipal frame = new GuiMenuPrincipal();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLocation(
                (tela.width - frame.getSize().width) / 2,
                (tela.height - frame.getSize().height) / 2
        );

        frame.setVisible(true);
    }
}
