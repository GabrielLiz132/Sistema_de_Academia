package views;
 
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
 
import models.AlunoDAO;
import models.Bd;
import models.TipoOperacaoBd;
import models.Aluno;
 
public class GuiCadastroAluno extends JFrame {
 
    private static final long serialVersionUID = 1L;
    private Container contentPane;
 
    private JLabel lbTitulo, lbMatricula, lbNome, lbCpf, lbDataNascimento, lbTelefone;
    private JTextField tfMatricula, tfNome, tfCpf, tfDataNascimento, tfTelefone;
    private JButton btSalvar, btBuscar, btAlterar, btExcluir, btLimpar;

 
    public GuiCadastroAluno() {
        inicializarComponentes();
        definirEventos();
    }
 
    private void inicializarComponentes() {
        setTitle("Cadastro de Aluno");
        setBounds(600, 410, 446, 359);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
 
        contentPane = getContentPane();
        contentPane.setLayout(null);
 
        lbTitulo = new JLabel("Cadastro de Aluno", SwingConstants.CENTER);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lbTitulo.setBounds(0, 10, 390, 25);
        contentPane.add(lbTitulo);
 
        lbMatricula = new JLabel("Matrícula:");
        lbMatricula.setBounds(20, 50, 120, 20);
        contentPane.add(lbMatricula);
        tfMatricula = new JTextField();
        tfMatricula.setBounds(150, 50, 200, 20);
        contentPane.add(tfMatricula);
 
        lbNome = new JLabel("Nome:");
        lbNome.setBounds(20, 80, 120, 20);
        contentPane.add(lbNome);
        tfNome = new JTextField();
        tfNome.setBounds(150, 80, 200, 20);
        contentPane.add(tfNome);
 
        lbCpf = new JLabel("CPF:");
        lbCpf.setBounds(20, 110, 120, 20);
        contentPane.add(lbCpf);
        tfCpf = new JTextField();
        tfCpf.setBounds(150, 110, 200, 20);
        contentPane.add(tfCpf);
 
        lbDataNascimento = new JLabel("Data Nasc. (dd/MM/yyyy):");
        lbDataNascimento.setBounds(20, 140, 160, 20);
        contentPane.add(lbDataNascimento);
        tfDataNascimento = new JTextField();
        tfDataNascimento.setBounds(190, 140, 160, 20);
        contentPane.add(tfDataNascimento);
 
        lbTelefone = new JLabel("Telefone:");
        lbTelefone.setBounds(20, 170, 120, 20);
        contentPane.add(lbTelefone);
        tfTelefone = new JTextField();
        tfTelefone.setBounds(150, 170, 200, 20);
        contentPane.add(tfTelefone);
 
        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(20, 220, 80, 25);
        contentPane.add(btSalvar);
 
        btBuscar = new JButton("Buscar");
        btBuscar.setBounds(110, 220, 80, 25);
        contentPane.add(btBuscar);
 
        btAlterar = new JButton("Alterar");
        btAlterar.setBounds(200, 220, 80, 25);
        contentPane.add(btAlterar);
 
        btExcluir = new JButton("Excluir");
        btExcluir.setBounds(290, 220, 80, 25);
        contentPane.add(btExcluir);
 
        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(155, 255, 80, 25);
        contentPane.add(btLimpar);
    }
 
    private void definirEventos() {
 
        btSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = preencherAluno();
                if (aluno == null) return;
 
                Bd bd = new Bd();
                AlunoDAO dao = new AlunoDAO();
                dao.setBd(bd);
                dao.setAluno(aluno);
 
                String resultado = dao.atualizar(TipoOperacaoBd.INCLUSAO);
                JOptionPane.showMessageDialog(null, resultado);
            }
        });
 
        btBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfMatricula.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe a matrícula!");
                    return;
                }
 
                Aluno aluno = new Aluno();
                aluno.setMatricula(Integer.parseInt(tfMatricula.getText()));
 
                Bd bd = new Bd();
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
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                }
            }
        });
 
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = preencherAluno();
                if (aluno == null) return;
 
                Bd bd = new Bd();
                AlunoDAO dao = new AlunoDAO();
                dao.setBd(bd);
                dao.setAluno(aluno);
 
                String resultado = dao.atualizar(TipoOperacaoBd.ALTERACAO);
                JOptionPane.showMessageDialog(null, resultado);
            }
        });
 
        btExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfMatricula.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe a matrícula!");
                    return;
                }
 
                int confirm = JOptionPane.showConfirmDialog(null,
                    "Deseja excluir este aluno?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
 
                if (confirm == JOptionPane.YES_OPTION) {
                    Aluno aluno = new Aluno();
                    aluno.setMatricula(Integer.parseInt(tfMatricula.getText()));
 
                    Bd bd = new Bd();
                    AlunoDAO dao = new AlunoDAO();
                    dao.setBd(bd);
                    dao.setAluno(aluno);
 
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
 
    private Aluno preencherAluno() {
        if (tfMatricula.getText().isEmpty() || tfNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Matrícula e Nome são obrigatórios!");
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
            JOptionPane.showMessageDialog(null, "Matrícula e Telefone devem ser números!");
            return null;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy");
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
 
    public static void abrir() {
        GuiCadastroAluno frame = new GuiCadastroAluno();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
            (tela.width - frame.getSize().width) / 2,
            (tela.height - frame.getSize().height) / 2
        );
        frame.setVisible(true);
    }
}
