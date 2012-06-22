package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import methods.Euler;
import methods.RungeKutta;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame {
	JTextField txtDiscretValue;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 13));
		setTitle("Numerical Methods 2 - Final HomeWork");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 558);

		JSeparator separator = new JSeparator();

		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		
		Box geralBox = Box.createVerticalBox();
		geralBox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(geralBox, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblResults)
					.addContainerGap(551, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(geralBox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addComponent(lblResults)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		Box part2Box = Box.createHorizontalBox();
		geralBox.add(part2Box);
						
						Box rungePredictorBox = Box.createHorizontalBox();
						rungePredictorBox.setAlignmentX(Component.LEFT_ALIGNMENT);
						geralBox.add(rungePredictorBox);
						rungePredictorBox.setBorder(null);
						
						Component horizontalStrut = Box.createHorizontalStrut(20);
						rungePredictorBox.add(horizontalStrut);
						
								JButton btnRungeKutta = new JButton("Runge Kutta");
								btnRungeKutta.setAlignmentX(Component.RIGHT_ALIGNMENT);
								rungePredictorBox.add(btnRungeKutta);
								
										JButton btnPredictorCorrector = new JButton("Predictor Corrector");
										rungePredictorBox.add(btnPredictorCorrector);
										btnRungeKutta.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {

												double discretValue = Double.parseDouble(txtDiscretValue
														.getText());
												RungeKutta rk = new RungeKutta();
												double[] results = rk.solve(discretValue);

												textArea.setText("");
												for (int i = 0; i < results.length; i++) {
													textArea.append(String.valueOf(results[i]) + "\n");

												}
											}
										});
						
						Box part1Box = Box.createHorizontalBox();
						geralBox.add(part1Box);
						
						Box discretValueBox = Box.createHorizontalBox();
						part1Box.add(discretValueBox);
						discretValueBox.setBorder(null);
						
								JLabel lblError = new JLabel("Discret Value");
								discretValueBox.add(lblError);
								
										txtDiscretValue = new JTextField();
										txtDiscretValue.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										discretValueBox.add(txtDiscretValue);
										txtDiscretValue.setToolTipText("Put your Discret Value");
										txtDiscretValue.setText("0.001");
										txtDiscretValue.setColumns(5);
										
										Box eulersBox = Box.createHorizontalBox();
										part1Box.add(eulersBox);
										eulersBox.setBorder(null);
										
												JButton btnCalculate = new JButton("FW Euler");
												eulersBox.add(btnCalculate);
												
														JButton btnBwEuler = new JButton("BW Euler");
														eulersBox.add(btnBwEuler);
														
																JButton btnModifiedEuler = new JButton("Modified Euler");
																eulersBox.add(btnModifiedEuler);
																btnModifiedEuler.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {

																		double discretValue = Double.parseDouble(txtDiscretValue
																				.getText());
																		Euler eulerModified = new Euler();
																		double[] results = eulerModified.backward(discretValue);

																		textArea.setText("");
																		for (int i = 0; i < results.length; i++) {
																			textArea.append(String.valueOf(results[i]) + "\n");

																		}
																	}
																});
																btnBwEuler.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {

																		double discretValue = Double.parseDouble(txtDiscretValue
																				.getText());
																		Euler eulerBW = new Euler();
																		double[] results = eulerBW.backward(discretValue);

																		textArea.setText("");
																		for (int i = 0; i < results.length; i++) {
																			textArea.append(String.valueOf(results[i]) + "\n");

																		}
																	}
																});
																btnCalculate.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent arg0) {
																		double discretValue = Double.parseDouble(txtDiscretValue
																				.getText());
																		Euler eulerFW = new Euler();
																		double[] results = eulerFW.forward(discretValue);

																		textArea.setText("");
																		for (int i = 0; i < results.length; i++) {
																			textArea.append(String.valueOf(results[i]) + "\n");
																		}
																	}
																});
		
				textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
				textArea.setLineWrap(true);
				textArea.setColumns(10);
				textArea.setRows(10);
				textArea.setTabSize(20);
		getContentPane().setLayout(groupLayout);
	}
}
