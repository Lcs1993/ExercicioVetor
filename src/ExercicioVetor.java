import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class ExercicioVetor {

	private JFrame frame;

	int vetor[] = new int[5];
	DefaultListModel lista = new DefaultListModel();
	int selecionado = 0;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExercicioVetor window = new ExercicioVetor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExercicioVetor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSpinner txtNum = new JSpinner();
		txtNum.setBounds(10, 41, 41, 20);
		frame.getContentPane().add(txtNum);

		JLabel lblNewLabel = new JLabel("Vetor");
		lblNewLabel.setBounds(260, 44, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblSelecionado = new JLabel("[0]");
		lblSelecionado.setBounds(327, 44, 46, 14);
		frame.getContentPane().add(lblSelecionado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 76, 111, 89);
		frame.getContentPane().add(scrollPane);

		JList lstVetor = new JList();
		lstVetor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int posicaoSelecionada = lstVetor.getSelectedIndex();
				lblSelecionado.setText("[" + posicaoSelecionada + "]");
			}
		});

		lstVetor.setModel(lista);
		scrollPane.setViewportView(lstVetor);
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lista.getSize() == 0) {
					vetor[selecionado] = Integer.parseInt(txtNum.getValue().toString());
					lista.removeAllElements();
					for (int c = 0; c < vetor.length; c++) {
						lista.addElement(vetor[c]);
					}

				} else {
					int posicaoSelecionada = lstVetor.getSelectedIndex()==-1?0:lstVetor.getSelectedIndex();
					int valor = Integer.parseInt(txtNum.getValue().toString());
					vetor[posicaoSelecionada]=valor;
					lista.removeAllElements();
					for (int c = 0; c < vetor.length; c++) {
						lista.addElement(vetor[c]);
					}
					
		
				}
			}
		});
		btnAdd.setBounds(72, 40, 89, 23);
		frame.getContentPane().add(btnAdd);
		JButton btnRemove = new JButton("Remover");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posicaoSelecionada = lstVetor.getSelectedIndex();
				vetor[posicaoSelecionada]=0;
				lista.removeAllElements();
				for (int c = 0; c < vetor.length; c++) {
					lista.addElement(vetor[c]);
				}
			
			}
		});
		btnRemove.setBounds(72, 76, 89, 23);
		frame.getContentPane().add(btnRemove);
		JButton btnOrdem = new JButton("Ordenar");
		btnOrdem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Arrays.sort(vetor);
				for (int c=0;c <vetor.length;c++) {
					System.out.println(vetor[c]);
				}
				lista.removeAllElements();
				for (int c = 0; c < vetor.length; c++) {
					lista.addElement(vetor[c]);
				}
			}

		});
		btnOrdem.setBounds(72, 114, 89, 23);
		frame.getContentPane().add(btnOrdem);

	}
}
