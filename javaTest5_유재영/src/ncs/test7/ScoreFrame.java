package ncs.test7;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class ScoreFrame {

	private JFrame frame;
	private JTextField javaScore;
	private JTextField sqlScore;
	private JTextField total;
	private JTextField average;

	public ScoreFrame() {
		frame = new JFrame("¹®Á¦ 7");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC810\uC218\uB97C \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel.setBounds(6, 6, 438, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC790\uBC14 :");
		label.setBounds(16, 86, 36, 16);
		frame.getContentPane().add(label);
		
		javaScore = new JTextField();
		javaScore.setBounds(64, 81, 130, 26);
		frame.getContentPane().add(javaScore);
		javaScore.setColumns(10);
		
		JLabel lblSql = new JLabel("SQL :");
		lblSql.setBounds(237, 86, 36, 16);
		frame.getContentPane().add(lblSql);
		
		sqlScore = new JTextField();
		sqlScore.setBounds(285, 81, 130, 26);
		frame.getContentPane().add(sqlScore);
		sqlScore.setColumns(10);
		
		JLabel label_1 = new JLabel("\uCD1D\uC810 :");
		label_1.setBounds(16, 212, 36, 16);
		frame.getContentPane().add(label_1);
		
		total = new JTextField();
		total.setBounds(64, 207, 130, 26);
		frame.getContentPane().add(total);
		total.setColumns(10);
		
		JLabel label_2 = new JLabel("\uD3C9\uADE0 :");
		label_2.setBounds(237, 212, 36, 16);
		frame.getContentPane().add(label_2);
		
		average = new JTextField();
		average.setBounds(285, 207, 130, 26);
		frame.getContentPane().add(average);
		average.setColumns(10);
		
		JButton calcBtn = new JButton("\uACC4\uC0B0\uD558\uAE30");
		calcBtn.setBounds(156, 138, 117, 29);
		frame.getContentPane().add(calcBtn);
		calcBtn.addActionListener(new ActionHandler());
		
		frame.setVisible(true);
	}
	
	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			total.setText(Integer.parseInt(javaScore.getText()) + Integer.parseInt(sqlScore.getText()) + "");
			average.setText((Integer.parseInt(javaScore.getText()) + Integer.parseInt(sqlScore.getText())) / 2 + "");
			
		}
		
	}
	
	
}
