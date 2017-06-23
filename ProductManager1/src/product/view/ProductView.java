package product.view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import product.controller.ProductController;
import product.model.vo.Product;

import java.awt.*;
import java.awt.event.*;

public class ProductView {
	ProductController pc = new ProductController();
	private JFrame frame;
	private JTable table;
	private JTextField textFSearch;
	private JTextField textFId;
	private JTextField textFPname;
	private JTextField textFDesc;
	private JSpinner spinner;
	private String[] columnItem = {"product_id", "p_name", "price", "description"};
	private DefaultTableModel dtm;
	
	public ProductView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		table = new JTable(pc.showTRow(pc.selectList()), columnItem);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 0, 513, 375);
		
		jsp.setViewportView(table);
		jsp.getViewport().setBackground(Color.WHITE);
		frame.getContentPane().add(jsp);
		
		JRadioButton rbtPid = new JRadioButton("Product ID");
		rbtPid.setBounds(538, 17, 94, 23);
		frame.getContentPane().add(rbtPid);
		
		JRadioButton rbtPname = new JRadioButton("Product Name");
		rbtPname.setBounds(647, 17, 116, 23);
		frame.getContentPane().add(rbtPname);
		
		ButtonGroup gp = new ButtonGroup();
		gp.add(rbtPid);
		gp.add(rbtPname);
		
		
		System.out.println(gp.getSelection());
		
		JButton btnSelList = new JButton("\uBAA9\uB85D\uBCF4\uAE30");
		btnSelList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table = new JTable(pc.showTRow(pc.selectList()), columnItem);
				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(0, 0, 513, 375);
				frame.getContentPane().add(jsp);
				
			}
		});
		btnSelList.setBounds(771, 17, 104, 23);
		frame.getContentPane().add(btnSelList);
	
		
		
		JButton btnSearch = new JButton("°Ë»ö");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtPid.isSelected()) {
					Product p = pc.selectProduct(textFSearch.getText());
//					table = new JTable(controller.tableRow(p),
//							columnItem);
					textFId.setText(p.getProduct_Id());
					textFPname.setText(p.getP_name());
					spinner.setValue(p.getPrice());
					textFDesc.setText(p.getDescription());
					
							
				}
				else {
					Product p = pc.selectProductName(textFSearch.getText());
					textFId.setText(p.getProduct_Id());
					textFPname.setText(p.getP_name());
					spinner.setValue(p.getPrice());
					textFDesc.setText(p.getDescription());
				}
					
			}
		});
		btnSearch.setBounds(814, 50, 61, 23);
		frame.getContentPane().add(btnSearch);
		
		textFSearch = new JTextField();
		textFSearch.setBounds(548, 51, 255, 21);
		frame.getContentPane().add(textFSearch);
		textFSearch.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(525, 143, 350, 209);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textFId = new JTextField();
		textFId.setBounds(88, 29, 250, 21);
		panel.add(textFId);
		textFId.setColumns(10);
		
		textFPname = new JTextField();
		textFPname.setBounds(88, 60, 250, 21);
		panel.add(textFPname);
		textFPname.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(145, 91, 193, 22);
		panel.add(spinner);
		
		textFDesc = new JTextField();
		textFDesc.setBounds(88, 123, 250, 21);
		panel.add(textFDesc);
		textFDesc.setColumns(10);
		
		JButton btnAdd = new JButton("Ãß°¡");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pd = new Product(textFId.getText(), textFPname.getText(), (Integer)spinner.getValue(),textFDesc.getText());
				pc.productInsert(pd);
				textFieldinit();
				tableInit();
				
			}
		});
		btnAdd.setBounds(42, 176, 67, 23);
		panel.add(btnAdd);
		
		JButton btnMod = new JButton("¼öÁ¤");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pd = new Product();
				pd.setProduct_Id(textFId.getText());
				pd.setP_name(textFPname.getText());
				pd.setPrice((Integer)spinner.getValue());
				pd.setDescription(textFDesc.getText());
				
				pc.updateProduct(pd);
				textFieldinit();
				tableInit();
			}
		});
		btnMod.setBounds(133, 176, 67, 23);
		panel.add(btnMod);
		
		JButton btnDel = new JButton("»èÁ¦");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc.deleteProduct(textFId.getText());
				textFieldinit();
				tableInit();
			}
		});
		btnDel.setBounds(227, 176, 67, 23);
		panel.add(btnDel);
		
		JLabel label = new JLabel("-----\uC0C1\uC138 \uBCF4\uAE30-----");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("±¼¸²", Font.BOLD, 14));
		label.setBounds(95, 4, 199, 15);
		panel.add(label);
		
		JLabel lblId = new JLabel("\uC0C1\uD488  ID :");
		lblId.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblId.setBounds(12, 32, 69, 15);
		panel.add(lblId);
		
		JLabel lblNewLabel = new JLabel("\uC0C1 \uD488 \uBA85 :");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel.setBounds(14, 63, 67, 15);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\uAC00     \uACA9 :");
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_1.setBounds(12, 94, 69, 15);
		panel.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488\uC124\uBA85 :");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_1.setBounds(14, 126, 67, 15);
		panel.add(lblNewLabel_1);
	}
	public void displayMenu(){
		frame.setVisible(true);
	}
	
	public void textFieldinit() {
		textFId.setText(null);
		textFPname.setText(null);
		textFDesc.setText(null);
		spinner.setValue((int)0);
	}
	
	public void tableInit() {
		table = new JTable(pc.showTRow(pc.selectList()), columnItem);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 0, 513, 375);
		
		jsp.setViewportView(table);
		jsp.getViewport().setBackground(Color.WHITE);
		frame.getContentPane().add(jsp);
	}
}
