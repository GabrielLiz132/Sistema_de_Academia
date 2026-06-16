package views;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
import models.Bd;
import models.Exercicios;
import models.PlanoTreino;
import models.PlanoTreinoDAO;
 
public class GuiPlanoTreinoConsulta extends JFrame {
 
    private static final long serialVersionUID = 1L;
    private Container contentPane;
 
    private JTable tabelaExercicios;
    private JTextField tfIdPLanoTreino;
    private JButton btConsultarPlano;
    private JLabel lblValorTotal;
 
    public GuiPlanoTreinoConsulta() {
        inicializarComponentes();
        definirEventos();
    }
 
    private void inicializarComponentes() {
        setTitle("Consulta seu Plano de Treino");
        setBounds(600, 410, 570, 535);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        contentPane = getContentPane();
        contentPane.setLayout(null);
 
        JLabel lblTitulo = new JLabel("Consulta do seu Plano de Treino");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 17, 553, 47);
        contentPane.add(lblTitulo);
 
        JLabel lblNumeroIdPLanoTreino = new JLabel("Numero do ID do Plano de Treino: ");
        lblNumeroIdPLanoTreino.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumeroIdPLanoTreino.setBounds(10, 76, 200, 24);
        contentPane.add(lblNumeroIdPLanoTreino);
 
        tfIdPLanoTreino = new JTextField();
        tfIdPLanoTreino.setBounds(220, 78, 118, 20);
        contentPane.add(tfIdPLanoTreino);
        tfIdPLanoTreino.setColumns(10);
 
        btConsultarPlano = new JButton("Consultar Plano");
        btConsultarPlano.setBounds(85, 128, 140, 23);
        contentPane.add(btConsultarPlano);
 
        // Tabela dentro de um JScrollPane para exibir cabeçalho e permitir rolagem
        tabelaExercicios = new JTable(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Exercício", "Quantidade", "Valor Unitário", "Subtotal" }
        ));
        JScrollPane scrollPane = new JScrollPane(tabelaExercicios);
        scrollPane.setBounds(46, 180, 463, 250);
        contentPane.add(scrollPane);
 
        lblValorTotal = new JLabel("Valor Total: R$ 0,00");
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblValorTotal.setBounds(46, 440, 463, 25);
        contentPane.add(lblValorTotal);
    }
 
    private void definirEventos() {
    	// Evento responsável por consultar um plano de treino pelo ID informado
        btConsultarPlano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                if (tfIdPLanoTreino.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o ID do Plano de Treino!");
                    return;
                }
 
                int id;
                
             // Valida se o ID informado é um número válido
                try {
                    id = Integer.parseInt(tfIdPLanoTreino.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido! Informe um número.");
                    return;
                }
 
                // Cria o PlanoTreino vazio e set o Id digitado
                PlanoTreino planoTreino = new PlanoTreino();
                planoTreino.setIdPlanoTreino(id);
 
                Bd bd = new Bd();
                PlanoTreinoDAO dao = new PlanoTreinoDAO();
                dao.setBd(bd);
                dao.setPlanoTreino(planoTreino);
 
                if (!bd.connect()) {
                    JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco!");
                    return;
                }
                
                // Caso o plano seja encontrado, o método localizar()
                // preenche automaticamente o objeto planoTreino com os dados recuperados do banco de dados
                boolean encontrou = dao.localizar();
 
                if (encontrou) {
                    preencherTabela(planoTreino);
                } else {
                    JOptionPane.showMessageDialog(null, "Plano de Treino não encontrado!");
                    limparTabela();
                }
            }
        });
    }
 
    // Preenche a tabela com os exercícios do plano e calcula o valor total
    private void preencherTabela(PlanoTreino planoTreino) {
 
        Exercicios[] exercicios = planoTreino.getExercicios();
        int[] quantidades = planoTreino.getQuantidadeExercicios();
 
        DefaultTableModel modelo = (DefaultTableModel) tabelaExercicios.getModel();
 
        // Limpa as linhas antigas
        modelo.setRowCount(0);
 
        if (exercicios == null || quantidades == null) {
            lblValorTotal.setText("Valor Total: R$ 0,00");
            return;
        }
        // Percorre todos os exercícios do plano para preencher a tabela
        for (int i = 0; i < exercicios.length; i++) {
            Exercicios ex = exercicios[i];
            int quantidade = quantidades[i];
            float valorUnitario = ex.getValorUnitario();
            float subtotal = valorUnitario * quantidade;
            
            // Adiciona uma nova linha na tabela contendo os dados do exercício
            modelo.addRow(new Object[] {
                    ex.getClass().getSimpleName(),
                    quantidade,
                    String.format("R$ %.2f", valorUnitario),
                    String.format("R$ %.2f", subtotal)
            });
        }
 
        // Calcula e exibe o valor total do plano
        float total = planoTreino.calcularValorTotal();
        lblValorTotal.setText(String.format("Valor Total: R$ %.2f", total));
    }
    
    // Remove todas as linhas da tabela e reinicia o valor total
    private void limparTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaExercicios.getModel();
        modelo.setRowCount(0);
        lblValorTotal.setText("Valor Total: R$ 0,00");
    }
    // Abre a tela centralizada na área de trabalho do usuário
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
