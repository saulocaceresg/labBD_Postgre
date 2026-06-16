package view;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;

public class Form extends JFrame {
	private JTextField txtcarcod;
	private JTextField txtcarnom;
	private JTextField textField_2;

	public Form() {
		setTitle("CARGO");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JPanel registro_cargo = new JPanel();
		registro_cargo.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Registro de Cargo", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(registro_cargo, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(279, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(registro_cargo, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(309, Short.MAX_VALUE))
		);
		GridBagLayout gbl_registro_cargo = new GridBagLayout();
		gbl_registro_cargo.columnWidths = new int[] {55, 250};
		gbl_registro_cargo.rowHeights = new int[] {20};
		gbl_registro_cargo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_registro_cargo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		registro_cargo.setLayout(gbl_registro_cargo);
		
		JLabel carid = new JLabel("Código");
		GridBagConstraints gbc_carid = new GridBagConstraints();
		gbc_carid.fill = GridBagConstraints.BOTH;
		gbc_carid.insets = new Insets(0, 0, 5, 5);
		gbc_carid.gridx = 0;
		gbc_carid.gridy = 0;
		registro_cargo.add(carid, gbc_carid);
		
		txtcarcod = new JTextField();
		GridBagConstraints gbc_txtcarcod = new GridBagConstraints();
		gbc_txtcarcod.anchor = GridBagConstraints.LINE_START;
		gbc_txtcarcod.insets = new Insets(0, 0, 5, 5);
		gbc_txtcarcod.gridx = 1;
		gbc_txtcarcod.gridy = 0;
		registro_cargo.add(txtcarcod, gbc_txtcarcod);
		txtcarcod.setColumns(10);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		registro_cargo.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 0;
		registro_cargo.add(label_1, gbc_label_1);
		
		JLabel carnom = new JLabel("Nombre");
		carnom.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_carnom = new GridBagConstraints();
		gbc_carnom.fill = GridBagConstraints.BOTH;
		gbc_carnom.insets = new Insets(0, 0, 5, 5);
		gbc_carnom.gridx = 0;
		gbc_carnom.gridy = 1;
		registro_cargo.add(carnom, gbc_carnom);
		
		txtcarnom = new JTextField();
		GridBagConstraints gbc_txtcarnom = new GridBagConstraints();
		gbc_txtcarnom.anchor = GridBagConstraints.LINE_START;
		gbc_txtcarnom.insets = new Insets(0, 0, 5, 5);
		gbc_txtcarnom.gridx = 1;
		gbc_txtcarnom.gridy = 1;
		registro_cargo.add(txtcarnom, gbc_txtcarnom);
		txtcarnom.setColumns(10);
		
		JLabel cardes = new JLabel("Descripción");
		GridBagConstraints gbc_cardes = new GridBagConstraints();
		gbc_cardes.fill = GridBagConstraints.BOTH;
		gbc_cardes.insets = new Insets(0, 0, 5, 5);
		gbc_cardes.gridx = 0;
		gbc_cardes.gridy = 2;
		registro_cargo.add(cardes, gbc_cardes);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.LINE_START;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		registro_cargo.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel carestreg = new JLabel("Estado Registro");
		GridBagConstraints gbc_carestreg = new GridBagConstraints();
		gbc_carestreg.fill = GridBagConstraints.BOTH;
		gbc_carestreg.insets = new Insets(0, 0, 5, 5);
		gbc_carestreg.gridx = 0;
		gbc_carestreg.gridy = 3;
		registro_cargo.add(carestreg, gbc_carestreg);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.fill = GridBagConstraints.BOTH;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 3;
		registro_cargo.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		registro_cargo.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 4;
		registro_cargo.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 4;
		gbc_label_4.gridy = 4;
		registro_cargo.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.gridx = 6;
		gbc_label_5.gridy = 4;
		registro_cargo.add(label_5, gbc_label_5);
		panel.setLayout(gl_panel);
//		create
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		JFrame j1 = new JFrame("Title");
		
		
	}
}
