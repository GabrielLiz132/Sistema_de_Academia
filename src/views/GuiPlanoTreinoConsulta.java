package views;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

import models.Bd;
import models.PlanoTreino;
import models.PlanoTreinoDAO;
import models.Professor;
import models.ProfessorDAO;


public class GuiPlanoTreinoConsulta extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private Container contentPane;
	
	private JTable tabelaExercicios;
	private JLabel lblTitulo;
	private JLabel lblNumeroIdPLanoTreino;
	private JTextField tfNumeroIdPLanoTreino;
	private JButton btConsultarPlano;
	
	public GuiPlanoTreinoConsulta() {
		inicializarComponentes();
		definirEventos();	
	}

	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setTitle("Consulta seu Plano de Treino");
		setBounds(600, 410, 570, 535);
		
		contentPane = getContentPane();
	    contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Consulta do seu Plano de Treino");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 17, 553, 47);
		getContentPane().add(lblTitulo);
		
		lblNumeroIdPLanoTreino = new JLabel("Numero do ID do Plano de Treino: ");
		lblNumeroIdPLanoTreino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroIdPLanoTreino.setBounds(25, 76, 185, 24);
		getContentPane().add(lblNumeroIdPLanoTreino);
		
		tfNumeroIdPLanoTreino = new JTextField();
		tfNumeroIdPLanoTreino.setBounds(220, 78, 118, 20);
		getContentPane().add(tfNumeroIdPLanoTreino);
		tfNumeroIdPLanoTreino.setColumns(10);
		
		btConsultarPlano = new JButton("Consultar Plano");
		btConsultarPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btConsultarPlano.setBounds(85, 128, 107, 23);
		getContentPane().add(btConsultarPlano);
		
		tabelaExercicios = new JTable();
		tabelaExercicios.setToolTipText("Aqui aparece ");
		tabelaExercicios.setBounds(46, 180, 463, 275);
		getContentPane().add(tabelaExercicios);
	}

	private void definirEventos() {
		// TODO Auto-generated method stub
		btConsultarPlano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfNumeroIdPLanoTreino.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe a sua Matricula!");
                    return;
                }
 
                PlanoTreino planoTreino= new PlanoTreino();
                planoTreino.setIdPlanoTreino(Integer.parseInt(tfNumeroIdPLanoTreino.getText()));
 
                Bd bd = new Bd();
                PlanoTreinoDAO dao = new PlanoTreinoDAO();
                dao.setBd(bd);
                dao.setPlanoTreino(planoTreino);
 
                if (dao.localizar()) {
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Professor não encontrado!");
                }
            }
        });
	}
	
	public static void abrir() {
        GuiPlanoTreinoConsulta frame = new GuiPlanoTreinoConsulta();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
            (tela.width - frame.getSize().width) / 2,
            (tela.height - frame.getSize().height) / 2
        );
        frame.setVisible(true);
    }
}
