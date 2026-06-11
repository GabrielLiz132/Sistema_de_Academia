package views;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import models.TipoChave;
import models.TipoOperacaoBd;
import models.BandeiraCartao;
import models.Bd;
import models.CartaoCredito;
import models.CartaoDebito;
import models.Dinheiro;
import models.FormaPagamento;
import models.Pagamento;
import models.PagamentoDAO;
import models.Pix;

public class GuiPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private JLabel lbTitulo, lbValor, lbFormaPagamento, lbChavePix, lbBandeira, lbParcelas, lbTipoChave;
	private JTextField tfValor, tfChavePix, tfParcelas;
	private JComboBox cbFormaPagamento, cbTipoChave, cbBandeira;
	private JButton btPagar, btSair, btLimpar;

    public GuiPagamento() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
    	setTitle("Pagamentos");
        setBounds(600, 410, 446, 293);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        contentPane = getContentPane();
        contentPane.setLayout(null);
        
        lbTitulo = new JLabel("Pagamento", SwingConstants.CENTER);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lbTitulo.setBounds(0, 0, 390, 25);
        contentPane.add(lbTitulo);
        
        lbValor = new JLabel("Valor: R$");
        lbValor.setBounds(20, 50, 120, 20);
        contentPane.add(lbValor);
        tfValor = new JTextField();
        tfValor.setBounds(150, 50, 200, 20);
        contentPane.add(tfValor);
        
        lbFormaPagamento = new JLabel("Forma de pagamento:");
        lbFormaPagamento.setBounds(20, 110, 120, 20);
        contentPane.add(lbFormaPagamento);
        String [] cbFormaPagamentoItems = {"pix", "cartão de credito", "cartão de debito", "dinheiro"};
        cbFormaPagamento = new JComboBox<>(cbFormaPagamentoItems);
        cbFormaPagamento.setBounds(150, 110, 200, 20);
        contentPane.add(cbFormaPagamento);
        
        lbChavePix = new JLabel("Chave Pix:");
        lbChavePix.setBounds(20, 130, 120, 20);
        contentPane.add(lbChavePix);
        tfChavePix = new JTextField();
        tfChavePix.setBounds(150, 130, 200, 20);
        contentPane.add(tfChavePix);
        
        lbTipoChave = new JLabel("Tipo da Chave:");
        lbTipoChave.setBounds(20, 150, 120, 20);
        contentPane.add(lbTipoChave);
        cbTipoChave = new JComboBox<>(TipoChave.values());
        cbTipoChave.setBounds(150, 150, 200, 20);
        contentPane.add(cbTipoChave);
        
        lbBandeira = new JLabel("Bandeira do Cartão:");
        lbBandeira.setBounds(20, 130, 120, 20);
        contentPane.add(lbBandeira);
        BandeiraCartao [] cbBandeiraCartao = BandeiraCartao.values();
        cbBandeira = new JComboBox<>(cbBandeiraCartao);
        cbBandeira.setBounds(150, 130, 200, 20);
        contentPane.add(cbBandeira);
        
        lbParcelas = new JLabel("Parcelas:");
        lbParcelas.setBounds(20, 150, 120, 20);
        contentPane.add(lbParcelas);
        tfParcelas = new JTextField("1");
        tfParcelas.setBounds(150, 150, 200, 20);
        contentPane.add(tfParcelas);

        btPagar = new JButton("Pagar");
        btPagar.setBounds(58, 197, 100, 30);
        contentPane.add(btPagar);
        
        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(168, 197, 100, 30);
        contentPane.add(btLimpar);
        
        btSair = new JButton("Sair");
        btSair.setBounds(278, 197, 100, 30);
        contentPane.add(btSair);
        
        esconderTudo();
        
	}
    
    private void esconderTudo() {
        lbChavePix.setVisible(false);
        tfChavePix.setVisible(false);
        lbTipoChave.setVisible(false);
        cbTipoChave.setVisible(false);
        lbBandeira.setVisible(false);
        cbBandeira.setVisible(false);
        lbParcelas.setVisible(false);
        tfParcelas.setVisible(false);
    }
    
	private void definirEventos() {
        cbFormaPagamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                esconderTudo();
                String selecionado = (String) cbFormaPagamento.getSelectedItem();
 
                if (selecionado.equals("pix")) {
                    lbChavePix.setVisible(true);
                    tfChavePix.setVisible(true);
                    lbTipoChave.setVisible(true);
                    cbTipoChave.setVisible(true);
 
                } else if (selecionado.equals("cartão de credito")) {
                    lbBandeira.setVisible(true);
                    cbBandeira.setVisible(true);
                    lbParcelas.setVisible(true);
                    tfParcelas.setVisible(true);
 
                } else if (selecionado.equals("cartão de debito")) {
                    lbBandeira.setVisible(true);
                    cbBandeira.setVisible(true);
                }
            }
        });
    btPagar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            if (tfValor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o valor!");
                return;
            }

            float valor;
            try {
                valor = Float.parseFloat(tfValor.getText().replace(",", "."));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido!");
                return;
            }

            String selecionado = (String) cbFormaPagamento.getSelectedItem();
            FormaPagamento fp = null;

            if (selecionado.equals("dinheiro")) {
                fp = new Dinheiro();

            } else if (selecionado.equals("pix")) {
                if (tfChavePix.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe a chave Pix!");
                    return;
                }
                Pix pix = new Pix();
                pix.setChave(tfChavePix.getText());
                pix.setTipo((TipoChave) cbTipoChave.getSelectedItem());
                fp = pix;

            } else if (selecionado.equals("cartão de credito")) {
                CartaoCredito cc = new CartaoCredito();
                cc.setBandeira((BandeiraCartao) cbBandeira.getSelectedItem());
                try {
                    cc.setQuantidadeParcela(Byte.parseByte(tfParcelas.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Parcelas inválidas!");
                    return;
                }
                fp = cc;

            } else if (selecionado.equals("cartão de debito")) {
                CartaoDebito cd = new CartaoDebito();
                cd.setBandeira((BandeiraCartao) cbBandeira.getSelectedItem());
                fp = cd;
            }

            // Monta o pagamento
            Pagamento pagamento = new Pagamento();
            pagamento.setValor(valor);
            pagamento.setFormaPagamento(new FormaPagamento[]{fp});

            // Verifica se o pagamento é válido
            if (!pagamento.efetuarPagamento()) {
                JOptionPane.showMessageDialog(null, "Dados de pagamento inválidos!");
                return;
            }

            // Salva no banco
            Bd bd = new Bd();
            PagamentoDAO dao = new PagamentoDAO();
            dao.setBD(bd);
            dao.setPagamento(pagamento);

            String resultado = dao.atualizar(TipoOperacaoBd.INCLUSAO);
            JOptionPane.showMessageDialog(null, resultado);

            if (resultado.contains("sucesso")) {
                limparCampos();
            }
        }
    });
    btLimpar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            limparCampos();
        }
    });
    btSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	dispose();
        	}
    	});
	}

	private void limparCampos() {
		tfValor.setText("");
    	tfChavePix.setText("");
    	tfParcelas.setText("1");
    	cbFormaPagamento.setSelectedIndex(0);
    	esconderTudo();
	}

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



