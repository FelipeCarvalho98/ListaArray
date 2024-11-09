package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.lista.model.Aluno;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class Tela1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private static ArrayList<Aluno> listaAlunos = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
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
	public Tela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(62, 63, 237, 20);
		txt_nome.setColumns(10);
		contentPane.add(txt_nome);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//cadastrar aluno
			String nome = txt_nome.getText();
			String telefone = txt_telefone.getText();
		  
			
			if(!nome.isEmpty()&&!telefone.isEmpty()) {
				listaAlunos.add(new Aluno(nome,telefone));
				JOptionPane.showMessageDialog(btn_cadastrar, "Cadastro com sucesso");
				txt_nome.setText("");
				txt_telefone.setText("");
			}else {
				JOptionPane.showMessageDialog(btn_cadastrar, "Campos Vazio!");
			}
			}
		});
		btn_cadastrar.setBounds(62, 144, 237, 23);
		contentPane.add(btn_cadastrar);
		
		JButton btn_listar = new JButton("Listar");
		btn_listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame2 jframe2 = new JFrame2(listaAlunos);
				jframe2.setVisible(true);
			}
		});
		btn_listar.setBounds(253, 227, 91, 23);
		contentPane.add(btn_listar);
		
		txt_telefone = new JTextField();
		txt_telefone.setColumns(10);
		txt_telefone.setBounds(62, 104, 237, 20);
		contentPane.add(txt_telefone);
	}
}
