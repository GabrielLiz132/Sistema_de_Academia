package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GuiPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JLabel lbTitulo, lbValor, 
	 

    public GuiPagamento() {
        inicializarComponentes();
        definirEventos();
    }

	
	private void definirEventos() {
		// TODO Auto-generated method stub
		
	}


	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		
	}





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPagamento frame = new GuiPagamento();
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

	
    public static void abrir() {
        GuiPagamento frame = new GuiPagamento();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
            (tela.width - frame.getSize().width) / 2,
            (tela.height - frame.getSize().height) / 2
        );
        frame.setVisible(true);
    }

}
