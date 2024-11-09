package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.lista.model.Aluno;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrame2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_at_nome;
	private JTextField txt_at_telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame2 frame = new JFrame2(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param listaAlunos 
	 */
	public JFrame2(ArrayList<Aluno> listaAlunos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_nome = new JLabel("New label");
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setBounds(101, 62, 183, 14);
		contentPane.add(lbl_nome);
		
		JLabel lbl_telefone = new JLabel("New label");
		lbl_telefone.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_telefone.setBounds(101, 87, 183, 14);
		contentPane.add(lbl_telefone);
		
		JComboBox comboBox = new JComboBox<>(listaAlunos.toArray(new Aluno[0]));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
				if(alunoSelecionado != null) {
					lbl_nome.setText(alunoSelecionado.getNome());
					lbl_telefone.setText(alunoSelecionado.getTelefone());
				}
			}
		});
		comboBox.setBounds(101, 29, 183, 22);
		contentPane.add(comboBox);
		
		txt_at_nome = new JTextField();
		txt_at_nome.setBounds(101, 130, 183, 20);
		contentPane.add(txt_at_nome);
		txt_at_nome.setColumns(10);
		
		txt_at_telefone = new JTextField();
		txt_at_telefone.setColumns(10);
		txt_at_telefone.setBounds(101, 175, 183, 20);
		contentPane.add(txt_at_telefone);
		
		JLabel lblNewLabel = new JLabel("Atualizar Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(101, 112, 183, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAtualizarTelefone = new JLabel("Atualizar Telefone");
		lblAtualizarTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarTelefone.setBounds(101, 161, 183, 14);
		contentPane.add(lblAtualizarTelefone);
		
		JButton btn_atualizar = new JButton("Atualizar");
		btn_atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar os dados?", 
					"Confirmação de atualização",
					JOptionPane.YES_NO_OPTION);

				String nomeat = txt_at_nome.getText();
				String telefoneat = txt_at_telefone.getText();
				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
			if (confirmacao == JOptionPane.YES_OPTION) {	
				
			
				if (!nomeat.isEmpty() && !telefoneat.isEmpty() ) {
					
				alunoSelecionado.setNome(nomeat);
				alunoSelecionado.setTelefone(telefoneat);
				
				comboBox.repaint();
				
				lbl_nome.setText(nomeat);
				lbl_telefone.setText(telefoneat);
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha os campos para a atualização");
				}
			
			} else {
				 JOptionPane.showMessageDialog(null, "Operação Cancelada");
			}
			}
		});
		btn_atualizar.setBounds(100, 206, 89, 23);
		contentPane.add(btn_atualizar);
		
		JButton btn_excluir = new JButton("Excluir ");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
				int confirmacao = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja excluir o aluno selecionado?",
						"Confirmação de exclusão",
						JOptionPane.YES_NO_OPTION);
				
			if(confirmacao == JOptionPane.YES_OPTION) {	
			
				listaAlunos.remove(alunoSelecionado);
				JOptionPane.showMessageDialog(btn_excluir, "Excluido !");
				
				comboBox.removeAllItems();
				for (Aluno aluno : listaAlunos) {
					comboBox.addItem(aluno);
				}
				lbl_nome.setText("");
				lbl_telefone.setText("");
				}
			else {
				JOptionPane.showMessageDialog(
		                null,
		                "Operação Cancelada!",
		                "Erro",
		                JOptionPane.ERROR_MESSAGE
		            );
			}
			}
		});
		btn_excluir.setBounds(195, 206, 89, 23);
		contentPane.add(btn_excluir);
		
		JButton btn_voltar = new JButton("Voltar");
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela1 jframe1 = new Tela1();
				jframe1.setVisible(true);
			}
		});
		btn_voltar.setBounds(335, 227, 89, 23);
		contentPane.add(btn_voltar);
		
		
	}
}
