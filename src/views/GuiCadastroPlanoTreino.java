package views;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import models.*;

public class GuiCadastroPlanoTreino extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private Container contentPane;
	
	private JTextField tfMatriculaDoAluno, tfCpfDoProfessor, tfDataCriacaoTreino, tfIdPlanoTreino;
	private JLabel lblMatriculaDoAluno, lblExerciciosDePeito, lblExerciciosDeBiceps, lblExerciciosDeTriceps, lblExerciciosDeOmbro, lblIdPlanoTreino;
	private JLabel lblExerciciosDeQuadriceps, lblExerciciosDeCostas, lblExerciciosDeAbdomen, lblExerciciosDePosterior, lblGluteos, lbCpfDoProfessor;
	private JLabel lblDataDeCriao, lblPanturrilha, lbTitulo, lblCardio;
	private JCheckBox chckbxSupinoRetoComBarra, chckbxSupinoRetoComHalter, chckbxSupinoInclinado, chckbxBicepsRoscaComHalter;
	private JCheckBox chckbxBicepsRoscaNaPolia, chckbxTricepsComHalter, chckbxTricepsTesta, chckbxTricepsNaPolia;
	private JCheckBox chckbxElevacaoFrontal, chckbxElevacaoLateral, chckbxDesenvolvimentoComHalter, chckbxRemadaSerrote, chckbxRemadaCurvadaComHalter;
	private JCheckBox chckbxAbdominalArticulado, chckbxPranchaFrontal, chckbxPanturrilhaSentado, chckbxPanturrilhaEmPe, chckbxAgachamentoNoHack;
	private JCheckBox chckbxAgachamentoLivre, chckbxLegPress45, chckbxMesaFlexora, chckbxStiff,chckbxElevacaoPelvica, chckbxBulgaro, chckbxEscada, chckbxPularCorda;
	private JCheckBox chckbxBicicleta, chckbxEsteira, chckbxEliptico, chckbxWallSit;
	private JSpinner spSupinoRetoComBarra, spSupinoRetoComHalter, spSupinoInclinado, spBicepsRoscaNaPolia, spBicepsRoscaComHalter;
	private JSpinner spTricepsComHalter, spTricepsTesta, spTricepsNaPolia, spDesenvolvimentoComHalter, spElevacaoLateral, spElevacaoFrontal;
	private JSpinner spRemadaSerrote, spRemadaCurvadaComHalter, spAbdominalArticulado, spPranchaFrontal, spPanturrilhaSentado, spPanturrilhaEmPe;
	private JSpinner spAgachamentoLivre, spAgachamentoNoHack, spLegPress45, spStiff, spMesaFlexora, spEscada, spPularCorda, spBicicleta, spEsteira;
	private JSpinner spEliptico, spWallSit, spElevacaoPelvica, spBulgaro;
	private JButton btExcluir, btLimpar, btAlterar, btSalvar;
	
	public GuiCadastroPlanoTreino() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setTitle("Cadastro de Plano de Treino"); 
		setBounds(600, 410, 974, 645);
		
		contentPane = getContentPane();
        contentPane.setLayout(null);
        
		lbTitulo = new JLabel("Cadastro Plano de Treino");
		lbTitulo.setBounds(0, 31, 958, 25);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lbTitulo);
		
		lblMatriculaDoAluno = new JLabel("Matricula do Aluno:");
		lblMatriculaDoAluno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatriculaDoAluno.setBounds(29, 83, 113, 25);
		getContentPane().add(lblMatriculaDoAluno);
		
		lbCpfDoProfessor = new JLabel("CPF do Professor:");
		lbCpfDoProfessor.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCpfDoProfessor.setBounds(29, 119, 113, 25);
		getContentPane().add(lbCpfDoProfessor);
		
		lblDataDeCriao = new JLabel("Data de criação do treino (dd/MM/yyyy):");
		lblDataDeCriao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDeCriao.setBounds(458, 83, 240, 25);
		getContentPane().add(lblDataDeCriao);
		
		tfMatriculaDoAluno = new JTextField();
		tfMatriculaDoAluno.setBounds(152, 85, 276, 20);
		getContentPane().add(tfMatriculaDoAluno);
		tfMatriculaDoAluno.setColumns(10);
		
		tfCpfDoProfessor = new JTextField();
		tfCpfDoProfessor.setBounds(152, 121, 276, 20);
		getContentPane().add(tfCpfDoProfessor);
		tfCpfDoProfessor.setColumns(10);
		
		tfDataCriacaoTreino = new JTextField();
		tfDataCriacaoTreino.setBounds(708, 85, 93, 20);
		getContentPane().add(tfDataCriacaoTreino);
		tfDataCriacaoTreino.setColumns(10); 
		
		lblExerciciosDePeito = new JLabel("Exercicios de Peito");
		lblExerciciosDePeito.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDePeito.setBounds(29, 181, 156, 25);
		getContentPane().add(lblExerciciosDePeito);
		
		lblExerciciosDeBiceps = new JLabel("Exercicios de Biceps");
		lblExerciciosDeBiceps.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDeBiceps.setBounds(255, 181, 146, 25);
		getContentPane().add(lblExerciciosDeBiceps);
		
		lblExerciciosDeTriceps = new JLabel("Exercicios de Triceps");
		lblExerciciosDeTriceps.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDeTriceps.setBounds(495, 181, 156, 25);
		getContentPane().add(lblExerciciosDeTriceps);
		
		lblExerciciosDeOmbro = new JLabel("Exercicios de Ombro");
		lblExerciciosDeOmbro.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDeOmbro.setBounds(29, 295, 156, 25);
		getContentPane().add(lblExerciciosDeOmbro);
		
		lblExerciciosDeCostas = new JLabel("Exercicios de Costas");
		lblExerciciosDeCostas.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDeCostas.setBounds(255, 295, 156, 25);
		getContentPane().add(lblExerciciosDeCostas);
		
		lblExerciciosDeAbdomen = new JLabel("Exercicios de Abdomen");
		lblExerciciosDeAbdomen.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDeAbdomen.setBounds(495, 295, 167, 25);
		getContentPane().add(lblExerciciosDeAbdomen);
		
		lblExerciciosDeQuadriceps = new JLabel("Exercicios de Quadriceps");
		lblExerciciosDeQuadriceps.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDeQuadriceps.setBounds(24, 409, 167, 25);
		getContentPane().add(lblExerciciosDeQuadriceps);
		
		lblExerciciosDePosterior = new JLabel("Exercicios de Posterior de Coxa");
		lblExerciciosDePosterior.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosDePosterior.setBounds(246, 409, 195, 25);
		getContentPane().add(lblExerciciosDePosterior);
		
		lblGluteos = new JLabel("Gluteos");
		lblGluteos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGluteos.setBounds(493, 409, 158, 25);
		getContentPane().add(lblGluteos);
		
		lblPanturrilha = new JLabel("Panturrilha");
		lblPanturrilha.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanturrilha.setBounds(721, 181, 146, 25);
		getContentPane().add(lblPanturrilha);
		
		chckbxSupinoRetoComBarra = new JCheckBox("SupinoRetoComBarra");
		chckbxSupinoRetoComBarra.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxSupinoRetoComBarra.setBounds(39, 213, 146, 23);
		getContentPane().add(chckbxSupinoRetoComBarra);
		
		spSupinoRetoComBarra = new JSpinner();
		spSupinoRetoComBarra.setToolTipText("Quantidade de Repetiçoes");
		spSupinoRetoComBarra.setBounds(201, 213, 44, 20);
		getContentPane().add(spSupinoRetoComBarra);
		
		chckbxSupinoRetoComHalter = new JCheckBox("SupinoRetoComHalter");
		chckbxSupinoRetoComHalter.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxSupinoRetoComHalter.setBounds(39, 239, 146, 23);
		getContentPane().add(chckbxSupinoRetoComHalter);
		
		spSupinoRetoComHalter = new JSpinner();
		spSupinoRetoComHalter.setToolTipText("Quantidade de Repetiçoes");
		spSupinoRetoComHalter.setBounds(201, 239, 44, 20);
		getContentPane().add(spSupinoRetoComHalter);
		
		chckbxSupinoInclinado = new JCheckBox("SupinoInclinado");
		chckbxSupinoInclinado.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxSupinoInclinado.setBounds(39, 265, 146, 23);
		getContentPane().add(chckbxSupinoInclinado);
		
		spSupinoInclinado = new JSpinner();
		spSupinoInclinado.setToolTipText("Quantidade de Repetiçoes");
		spSupinoInclinado.setBounds(201, 265, 44, 20);
		getContentPane().add(spSupinoInclinado);
		
		chckbxBicepsRoscaComHalter = new JCheckBox("BicepsRoscaComHalter");
		chckbxBicepsRoscaComHalter.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxBicepsRoscaComHalter.setBounds(265, 213, 146, 23);
		getContentPane().add(chckbxBicepsRoscaComHalter);
		
		chckbxBicepsRoscaNaPolia = new JCheckBox("BicepsRoscaNaPolia");
		chckbxBicepsRoscaNaPolia.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxBicepsRoscaNaPolia.setBounds(265, 239, 146, 23);
		getContentPane().add(chckbxBicepsRoscaNaPolia);
		
		spBicepsRoscaNaPolia = new JSpinner();
		spBicepsRoscaNaPolia.setToolTipText("Quantidade de Repetiçoes");
		spBicepsRoscaNaPolia.setBounds(428, 239, 44, 20);
		getContentPane().add(spBicepsRoscaNaPolia);
		
		spBicepsRoscaComHalter = new JSpinner();
		spBicepsRoscaComHalter.setToolTipText("Quantidade de Repetiçoes");
		spBicepsRoscaComHalter.setBounds(428, 213, 44, 20);
		getContentPane().add(spBicepsRoscaComHalter);
		
		chckbxTricepsComHalter = new JCheckBox("TricepsComHalter");
		chckbxTricepsComHalter.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxTricepsComHalter.setBounds(505, 213, 146, 23);
		getContentPane().add(chckbxTricepsComHalter);
		
		chckbxTricepsTesta = new JCheckBox("TricepsTesta");
		chckbxTricepsTesta.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxTricepsTesta.setBounds(505, 239, 146, 23);
		getContentPane().add(chckbxTricepsTesta);
		 
		spTricepsTesta = new JSpinner();
		spTricepsTesta.setToolTipText("Quantidade de Repetiçoes");
		spTricepsTesta.setBounds(668, 242, 43, 20);
		getContentPane().add(spTricepsTesta);
		
		spTricepsComHalter = new JSpinner();
		spTricepsComHalter.setToolTipText("Quantidade de Repetiçoes");
		spTricepsComHalter.setBounds(668, 216, 43, 20);
		getContentPane().add(spTricepsComHalter);
		
		chckbxTricepsNaPolia = new JCheckBox("TricepsNaPolia");
		chckbxTricepsNaPolia.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxTricepsNaPolia.setBounds(505, 265, 146, 23);
		getContentPane().add(chckbxTricepsNaPolia);
		
		spTricepsNaPolia = new JSpinner();
		spTricepsNaPolia.setToolTipText("Quantidade de Repetiçoes");
		spTricepsNaPolia.setBounds(668, 268, 43, 20);
		getContentPane().add(spTricepsNaPolia);
		
		chckbxDesenvolvimentoComHalter = new JCheckBox("DesenvolvimentoComHalter");
		chckbxDesenvolvimentoComHalter.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxDesenvolvimentoComHalter.setBounds(39, 379, 157, 23);
		getContentPane().add(chckbxDesenvolvimentoComHalter);
		
		spDesenvolvimentoComHalter = new JSpinner();
		spDesenvolvimentoComHalter.setToolTipText("Quantidade de Repetiçoes");
		spDesenvolvimentoComHalter.setBounds(201, 379, 44, 20);
		getContentPane().add(spDesenvolvimentoComHalter);
		
		spElevacaoLateral = new JSpinner();
		spElevacaoLateral.setToolTipText("Quantidade de Repetiçoes");
		spElevacaoLateral.setBounds(201, 354, 44, 20);
		getContentPane().add(spElevacaoLateral);
		
		chckbxElevacaoLateral = new JCheckBox("ElevacaoLateral");
		chckbxElevacaoLateral.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxElevacaoLateral.setBounds(39, 353, 146, 23);
		getContentPane().add(chckbxElevacaoLateral);
		
		chckbxElevacaoFrontal = new JCheckBox("ElevacaoFrontal");
		chckbxElevacaoFrontal.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxElevacaoFrontal.setBounds(39, 327, 146, 23);
		getContentPane().add(chckbxElevacaoFrontal);
		
		spElevacaoFrontal = new JSpinner();
		spElevacaoFrontal.setToolTipText("Quantidade de Repetiçoes");
		spElevacaoFrontal.setBounds(201, 327, 44, 20);
		getContentPane().add(spElevacaoFrontal);
		
		chckbxRemadaSerrote = new JCheckBox("RemadaSerrote");
		chckbxRemadaSerrote.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxRemadaSerrote.setBounds(265, 327, 146, 23);
		getContentPane().add(chckbxRemadaSerrote);
		
		chckbxRemadaCurvadaComHalter = new JCheckBox("RemadaCurvadaComHalter");
		chckbxRemadaCurvadaComHalter.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxRemadaCurvadaComHalter.setBounds(265, 353, 157, 23);
		getContentPane().add(chckbxRemadaCurvadaComHalter);
		
		spRemadaCurvadaComHalter = new JSpinner();
		spRemadaCurvadaComHalter.setToolTipText("Quantidade de Repetiçoes");
		spRemadaCurvadaComHalter.setBounds(428, 353, 44, 20);
		getContentPane().add(spRemadaCurvadaComHalter);
		
		spRemadaSerrote = new JSpinner();
		spRemadaSerrote.setToolTipText("Quantidade de Repetiçoes");
		spRemadaSerrote.setBounds(428, 328, 44, 20);
		getContentPane().add(spRemadaSerrote);
		
		chckbxPranchaFrontal = new JCheckBox("PranchaFrontal (minutos)");
		chckbxPranchaFrontal.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPranchaFrontal.setBounds(505, 351, 157, 23);
		getContentPane().add(chckbxPranchaFrontal);
		
		chckbxAbdominalArticulado = new JCheckBox("AbdominalArticulado");
		chckbxAbdominalArticulado.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxAbdominalArticulado.setBounds(505, 325, 146, 23);
		getContentPane().add(chckbxAbdominalArticulado);
		
		spAbdominalArticulado = new JSpinner();
		spAbdominalArticulado.setToolTipText("Quantidade de Repetiçoes");
		spAbdominalArticulado.setBounds(668, 326, 43, 20);
		getContentPane().add(spAbdominalArticulado);
		
		spPranchaFrontal = new JSpinner();
		spPranchaFrontal.setToolTipText("Quantidade de Tempo");
		spPranchaFrontal.setBounds(668, 351, 43, 20);
		getContentPane().add(spPranchaFrontal);
		
		chckbxPanturrilhaSentado = new JCheckBox("PanturrilhaSentado");
		chckbxPanturrilhaSentado.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPanturrilhaSentado.setBounds(731, 213, 146, 23);
		getContentPane().add(chckbxPanturrilhaSentado);
		
		chckbxPanturrilhaEmPe = new JCheckBox("PanturrilhaEmPe");
		chckbxPanturrilhaEmPe.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPanturrilhaEmPe.setBounds(731, 239, 157, 23);
		getContentPane().add(chckbxPanturrilhaEmPe);
		
		spPanturrilhaEmPe = new JSpinner();
		spPanturrilhaEmPe.setToolTipText("Quantidade de Repetiçoes");
		spPanturrilhaEmPe.setBounds(894, 239, 43, 20);
		getContentPane().add(spPanturrilhaEmPe);
		
		spPanturrilhaSentado = new JSpinner();
		spPanturrilhaSentado.setToolTipText("Quantidade de Repetiçoes");
		spPanturrilhaSentado.setBounds(894, 214, 43, 20);
		getContentPane().add(spPanturrilhaSentado);
		
		chckbxAgachamentoLivre = new JCheckBox("AgachamentoLivre");
		chckbxAgachamentoLivre.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxAgachamentoLivre.setBounds(39, 491, 157, 23);
		getContentPane().add(chckbxAgachamentoLivre);
		
		chckbxAgachamentoNoHack = new JCheckBox("AgachamentoNoHack");
		chckbxAgachamentoNoHack.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxAgachamentoNoHack.setBounds(39, 465, 146, 23);
		getContentPane().add(chckbxAgachamentoNoHack);
		
		chckbxLegPress45 = new JCheckBox("LegPress45");
		chckbxLegPress45.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxLegPress45.setBounds(39, 439, 146, 23);
		getContentPane().add(chckbxLegPress45);
		
		spLegPress45 = new JSpinner();
		spLegPress45.setToolTipText("Quantidade de Repetiçoes");
		spLegPress45.setBounds(201, 439, 44, 20);
		getContentPane().add(spLegPress45);
		
		spAgachamentoNoHack = new JSpinner();
		spAgachamentoNoHack.setToolTipText("Quantidade de Repetiçoes");
		spAgachamentoNoHack.setBounds(201, 466, 44, 20);
		getContentPane().add(spAgachamentoNoHack);
		
		spAgachamentoLivre = new JSpinner();
		spAgachamentoLivre.setToolTipText("Quantidade de Repetiçoes");
		spAgachamentoLivre.setBounds(201, 491, 44, 20);
		getContentPane().add(spAgachamentoLivre);
		
		chckbxStiff = new JCheckBox("Stiff");
		chckbxStiff.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxStiff.setBounds(265, 465, 157, 23);
		getContentPane().add(chckbxStiff);
		
		chckbxMesaFlexora = new JCheckBox("MesaFlexora");
		chckbxMesaFlexora.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxMesaFlexora.setBounds(265, 439, 146, 23);
		getContentPane().add(chckbxMesaFlexora);
		
		spStiff = new JSpinner();
		spStiff.setToolTipText("Quantidade de Repetiçoes");
		spStiff.setBounds(428, 465, 44, 20);
		getContentPane().add(spStiff);
		
		spMesaFlexora = new JSpinner();
		spMesaFlexora.setToolTipText("Quantidade de Repetiçoes");
		spMesaFlexora.setBounds(428, 440, 44, 20);
		getContentPane().add(spMesaFlexora);
		
		chckbxElevacaoPelvica = new JCheckBox("ElevacaoPelvica");
		chckbxElevacaoPelvica.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxElevacaoPelvica.setBounds(503, 439, 146, 23);
		getContentPane().add(chckbxElevacaoPelvica);
		
		chckbxBulgaro = new JCheckBox("Bulgaro");
		chckbxBulgaro.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxBulgaro.setBounds(503, 465, 157, 23);
		getContentPane().add(chckbxBulgaro);
		
		spBulgaro = new JSpinner();
		spBulgaro.setToolTipText("Quantidade de Repetiçoes");
		spBulgaro.setBounds(666, 465, 45, 20);
		getContentPane().add(spBulgaro);
		
		spElevacaoPelvica = new JSpinner();
		spElevacaoPelvica.setToolTipText("Quantidade de Repetiçoes");
		spElevacaoPelvica.setBounds(666, 440, 45, 20);
		getContentPane().add(spElevacaoPelvica);
		 
		lblCardio = new JLabel("Cardio (quantidade em minutos)");
		lblCardio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardio.setBounds(721, 295, 195, 25);
		getContentPane().add(lblCardio);
		
		chckbxBicicleta = new JCheckBox("Bicicleta");
		chckbxBicicleta.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxBicicleta.setBounds(731, 379, 146, 23);
		getContentPane().add(chckbxBicicleta);
		
		spBicicleta = new JSpinner();
		spBicicleta.setToolTipText("Quantidade em Tempo");
		spBicicleta.setBounds(894, 382, 43, 20);
		getContentPane().add(spBicicleta);
		
		spPularCorda = new JSpinner();
		spPularCorda.setToolTipText("Quantidade em Tempo");
		spPularCorda.setBounds(894, 356, 43, 20);
		getContentPane().add(spPularCorda);
		
		spEscada = new JSpinner();
		spEscada.setToolTipText("Quantidade em Tempo");
		spEscada.setBounds(894, 330, 43, 20);
		getContentPane().add(spEscada);
		
		chckbxEscada = new JCheckBox("Escada");
		chckbxEscada.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxEscada.setBounds(731, 327, 146, 23);
		getContentPane().add(chckbxEscada);
		
		chckbxPularCorda = new JCheckBox("PularCorda");
		chckbxPularCorda.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPularCorda.setBounds(731, 353, 146, 23);
		getContentPane().add(chckbxPularCorda);
		
		chckbxWallSit = new JCheckBox("WallSit");
		chckbxWallSit.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxWallSit.setBounds(731, 457, 146, 23);
		getContentPane().add(chckbxWallSit);
		
		spWallSit = new JSpinner();
		spWallSit.setToolTipText("Quantidade em Tempo");
		spWallSit.setBounds(894, 458, 43, 20);
		getContentPane().add(spWallSit);
		
		spEliptico = new JSpinner();
		spEliptico.setToolTipText("Quantidade em Tempo");
		spEliptico.setBounds(894, 432, 43, 20);
		getContentPane().add(spEliptico);
		
		spEsteira = new JSpinner();
		spEsteira.setToolTipText("Quantidade em Tempo");
		spEsteira.setBounds(894, 409, 43, 20);
		getContentPane().add(spEsteira);
		
		chckbxEsteira = new JCheckBox("Esteira");
		chckbxEsteira.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxEsteira.setBounds(731, 405, 146, 23);
		getContentPane().add(chckbxEsteira);
		
		chckbxEliptico = new JCheckBox("Eliptico");
		chckbxEliptico.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxEliptico.setBounds(731, 431, 146, 23);
		getContentPane().add(chckbxEliptico);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(571, 558, 80, 25);
		getContentPane().add(btLimpar);
		
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(152, 558, 80, 25);
		getContentPane().add(btSalvar);
		
		btAlterar = new JButton("Alterar");
		btAlterar.setBounds(348, 558, 80, 25);
		getContentPane().add(btAlterar);
		
		btExcluir = new JButton("Excluir");
		btExcluir.setBounds(763, 558, 80, 25);
		getContentPane().add(btExcluir);
		
		tfIdPlanoTreino = new JTextField();
		tfIdPlanoTreino.setBounds(708, 121, 93, 20);
		getContentPane().add(tfIdPlanoTreino);
		tfIdPlanoTreino.setColumns(10);
		
		lblIdPlanoTreino = new JLabel("Id do Plano de Treino: ");
		lblIdPlanoTreino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdPlanoTreino.setBounds(571, 121, 127, 20);
		getContentPane().add(lblIdPlanoTreino);
	}
	
	private void definirEventos() {
		// TODO Auto-generated method stub
		btSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlanoTreino planoTreino = preencherPlanoTreino();
                if (planoTreino == null) return;
 
                Bd bd = new Bd();
                PlanoTreinoDAO dao = new PlanoTreinoDAO();
                dao.setBd(bd);
                dao.setPlanoTreino(planoTreino);
 
                String resultado = dao.atualizar(TipoOperacaoBd.INCLUSAO);
                JOptionPane.showMessageDialog(null, resultado);
            }
        });
 
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlanoTreino planoTreino= preencherPlanoTreino();
                if (planoTreino == null) return;
 
                Bd bd = new Bd();
                PlanoTreinoDAO dao = new PlanoTreinoDAO();
                dao.setBd(bd);
                dao.setPlanoTreino(planoTreino);
 
                String resultado = dao.atualizar(TipoOperacaoBd.ALTERACAO);
                JOptionPane.showMessageDialog(null, resultado);
            }
        });
 
        btExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfIdPlanoTreino.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o ID do plano de treino!");
                    return;
                }
 
                int confirm = JOptionPane.showConfirmDialog(null,
                    "Deseja excluir este Plano de Treino?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
 
                if (confirm == JOptionPane.YES_OPTION) {
                    PlanoTreino planoTreino = new PlanoTreino();
                    planoTreino.setIdPlanoTreino(Integer.parseInt(tfIdPlanoTreino.getText()));
 
                    Bd bd = new Bd();
                    PlanoTreinoDAO dao = new PlanoTreinoDAO();
                    dao.setBd(bd);
                    dao.setPlanoTreino(planoTreino);
 
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
 
	private void adicionarExercicio(
	        JCheckBox checkBox,
	        JSpinner spinner,
	        Exercicios exercicio,
	        ArrayList<Exercicios> listaExercicios,
	        ArrayList<Integer> listaQuantidades) {

	    if (checkBox.isSelected()) {

	        listaExercicios.add(exercicio);

	        listaQuantidades.add(
	                (Integer) spinner.getValue());
	    }
	}
	
	private PlanoTreino preencherPlanoTreino() {
	    if (tfMatriculaDoAluno.getText().isEmpty() || tfCpfDoProfessor.getText().isEmpty()) { 
	        JOptionPane.showMessageDialog(null, "Matricula do Aluno e CPF do Professor são obrigatórios!");
	        return null;
	    }
	    // Cria o objeto PlanoTreino	
	    PlanoTreino planoTreino = new PlanoTreino();
	  
	    try {
	    	
	        // Cria o Aluno e define a matrícula informada
	        Aluno aluno = new Aluno();
	        aluno.setMatricula(
	                Integer.parseInt(tfMatriculaDoAluno.getText()));

	        // Cria o Professor e define o CPF informado
	        Professor professor = new Professor();
	        professor.setCpf(
	                tfCpfDoProfessor.getText());

	        // Converte a data digitada para Date
	        SimpleDateFormat sdf =
	                new SimpleDateFormat("dd/MM/yyyy");

	        Date dataCriacao =
	                sdf.parse(tfDataCriacaoTreino.getText());

	        // Listas temporárias para armazenar exercícios e quantidades
	        ArrayList<Exercicios> listaExercicios =
	                new ArrayList<>();

	        ArrayList<Integer> listaQuantidades =
	                new ArrayList<>();

		     // Exercícios de Peito
	
	        adicionarExercicio(chckbxSupinoRetoComBarra, spSupinoRetoComBarra, new SupinoRetoComBarra(),listaExercicios,listaQuantidades);
	
	        adicionarExercicio(chckbxSupinoRetoComHalter, spSupinoRetoComHalter, new SupinoRetoComHalter(),listaExercicios,listaQuantidades);
	
		    adicionarExercicio(chckbxSupinoInclinado, spSupinoInclinado, new SupinoInclinado(), listaExercicios, listaQuantidades);
	
		     // Exercícios de Bíceps
	
		     adicionarExercicio(chckbxBicepsRoscaComHalter,spBicepsRoscaComHalter, new BicepsRoscaComHalter(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxBicepsRoscaNaPolia, spBicepsRoscaNaPolia, new BicepsRoscaNaPolia(),listaExercicios,listaQuantidades);
	
		     // Exercícios de Tríceps
	
		     adicionarExercicio(chckbxTricepsComHalter, spTricepsComHalter, new TricepsComHalter(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxTricepsTesta, spTricepsTesta, new TricepsTesta(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxTricepsNaPolia, spTricepsNaPolia, new TricepsNaPolia(), listaExercicios, listaQuantidades);
	
		     // Exercícios de Ombro
		     
		     adicionarExercicio(chckbxElevacaoFrontal,spElevacaoFrontal, new ElevacaoFrontal(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxElevacaoLateral, spElevacaoLateral, new ElevacaoLateral(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxDesenvolvimentoComHalter, spDesenvolvimentoComHalter, new DesenvolvimentoComHalter(), listaExercicios, listaQuantidades);
	
		     // Exercícios de Costas
		    
		     adicionarExercicio(chckbxRemadaCurvadaComHalter, spRemadaCurvadaComHalter, new RemadaCurvadaComHalter(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxRemadaSerrote, spRemadaSerrote, new RemadaSerrote(), listaExercicios, listaQuantidades);
	
		     // Exercícios de Abdômen
	
		     adicionarExercicio(chckbxAbdominalArticulado, spAbdominalArticulado, new AbdominalArticulado(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxPranchaFrontal, spPranchaFrontal, new PranchaFrontal(), listaExercicios, listaQuantidades);
	
		     // Exercícios de Quadríceps

		     adicionarExercicio(chckbxLegPress45, spLegPress45, new LegPress45(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxAgachamentoNoHack, spAgachamentoNoHack, new AgachamentoNoHack(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxWallSit, spWallSit, new WallSit(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxAgachamentoLivre, spAgachamentoLivre, new AgachamentoLivre(), listaExercicios, listaQuantidades);
	
		     // Exercícios de Posterior de Coxa
	
		     adicionarExercicio(chckbxMesaFlexora, spMesaFlexora, new MesaFlexora(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxStiff, spStiff, new Stiff(), listaExercicios, listaQuantidades);

		     // Exercícios de Glúteos
		     
		     adicionarExercicio(chckbxElevacaoPelvica, spElevacaoPelvica, new ElevacaoPelvica(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxBulgaro, spBulgaro, new Bulgaro(), listaExercicios, listaQuantidades);
	
		     // Exercícios Cardio
		
		     adicionarExercicio(chckbxEsteira, spEsteira, new Esteira(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxBicicleta, spBicicleta, new Bicicleta(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxEliptico, spEliptico, new Eliptico(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxEscada, spEscada, new Escada(), listaExercicios, listaQuantidades);
	
		     adicionarExercicio(chckbxPularCorda, spPularCorda, new PularCorda(), listaExercicios, listaQuantidades);

	        // Converte ArrayList para array de Exercicios
	        Exercicios[] exercicios =
	                listaExercicios.toArray(
	                        new Exercicios[0]);

	        // Converte ArrayList<Integer> para int[]
	        int[] quantidades =
	                new int[listaQuantidades.size()];

	        for (int i = 0; i < listaQuantidades.size(); i++) {
	            quantidades[i] =
	                    listaQuantidades.get(i);
	        }

	        // Preenche o PlanoTreino
	        planoTreino.setAluno(aluno);
	        planoTreino.setProfessorResponsavel(professor);
	        planoTreino.setDataDeCriacao(dataCriacao);
	        planoTreino.setExercicios(exercicios);
	        planoTreino.setQuantidadeExercicios(quantidades);

	        return planoTreino;
	    }
	    catch (Exception erro) {

	        JOptionPane.showMessageDialog(
	                null,
	                "Erro ao preencher plano de treino: "
	                        + erro.getMessage());

	        return null;
	    }
	}
	
	private void limparCampos() {
		tfMatriculaDoAluno.setText("");
		tfCpfDoProfessor.setText("");
		tfDataCriacaoTreino.setText("");
		tfIdPlanoTreino.setText("");
		JCheckBox[] checkboxes = { chckbxSupinoRetoComBarra, chckbxSupinoRetoComHalter, chckbxSupinoInclinado, chckbxBicepsRoscaComHalter,
								   chckbxBicepsRoscaNaPolia, chckbxTricepsComHalter, chckbxTricepsTesta, chckbxTricepsNaPolia, 
								   chckbxElevacaoFrontal, chckbxElevacaoLateral, chckbxDesenvolvimentoComHalter, chckbxRemadaSerrote,
								   chckbxRemadaCurvadaComHalter, chckbxAbdominalArticulado, chckbxPranchaFrontal, chckbxPanturrilhaSentado, 
								   chckbxPanturrilhaEmPe, chckbxAgachamentoNoHack, chckbxAgachamentoLivre, chckbxLegPress45, chckbxMesaFlexora,
								   chckbxStiff,chckbxElevacaoPelvica, chckbxBulgaro, chckbxEscada, chckbxPularCorda, chckbxBicicleta, chckbxEsteira,
								   chckbxEliptico, chckbxWallSit
								  };
		for (JCheckBox cb : checkboxes) {
		        cb.setSelected(false);
		}  
		JSpinner[] spinners = { spSupinoRetoComBarra, spSupinoRetoComHalter, spSupinoInclinado, spBicepsRoscaNaPolia, spBicepsRoscaComHalter,
								spTricepsComHalter, spTricepsTesta, spTricepsNaPolia, spDesenvolvimentoComHalter, spElevacaoLateral,
								spElevacaoFrontal,spRemadaSerrote, spRemadaCurvadaComHalter, spAbdominalArticulado, spPranchaFrontal,
								spPanturrilhaSentado, spPanturrilhaEmPe, spAgachamentoLivre, spAgachamentoNoHack, spLegPress45, spStiff, 
								spMesaFlexora, spEscada, spPularCorda, spBicicleta, spEsteira, spEliptico, spWallSit, spElevacaoPelvica, spBulgaro
							  };
		for (JSpinner sp : spinners) {
		    sp.setValue(0);
		}
    }
    public static void abrir() {
        GuiCadastroPlanoTreino frame = new GuiCadastroPlanoTreino();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
            (tela.width - frame.getSize().width) / 2,
            (tela.height - frame.getSize().height) / 2
        );
        frame.setVisible(true);
    }
}

