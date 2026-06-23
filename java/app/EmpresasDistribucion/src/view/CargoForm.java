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
import java.awt.ComponentOrientation;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class CargoForm extends JFrame {
	private JTextField txtcarcod;
	private JTextField txtcarnom;
	private JTextField txtcardes;
	private JTable table;

	public CargoForm() {
		setTitle("CARGO");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pan_cargo = new JPanel();
		getContentPane().add(pan_cargo);
		
		JPanel registro_cargo = new JPanel();
		registro_cargo.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Registro de Cargo", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel pan_tabla_cargo = new JPanel();
		pan_tabla_cargo.setBorder(new TitledBorder(null, "Tabla_cargo", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel pan_buttons = new JPanel();
		pan_buttons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_pan_cargo = new GroupLayout(pan_cargo);
		gl_pan_cargo.setHorizontalGroup(
			gl_pan_cargo.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pan_cargo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pan_cargo.createParallelGroup(Alignment.LEADING)
						.addComponent(registro_cargo, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(pan_buttons, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(pan_tabla_cargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		gl_pan_cargo.setVerticalGroup(
			gl_pan_cargo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_cargo.createSequentialGroup()
					.addContainerGap()
					.addComponent(registro_cargo, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pan_tabla_cargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pan_buttons, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		GridBagLayout gbl_pan_buttons = new GridBagLayout();
		gbl_pan_buttons.columnWidths = new int[] {20, 20, 20};
		gbl_pan_buttons.rowHeights = new int[] {20};
		gbl_pan_buttons.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_pan_buttons.rowWeights = new double[]{0.0, 0.0};
		pan_buttons.setLayout(gbl_pan_buttons);
		
		JButton btn_add = new JButton("Adicionar");
		btn_add.setSize(new Dimension(50, 20));
		btn_add.setMinimumSize(new Dimension(20, 10));
		btn_add.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_add.setMargin(new Insets(10, 20, 10, 20));
		btn_add.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_add = new GridBagConstraints();
		gbc_btn_add.fill = GridBagConstraints.BOTH;
		gbc_btn_add.insets = new Insets(0, 0, 5, 5);
		gbc_btn_add.gridx = 0;
		gbc_btn_add.gridy = 0;
		pan_buttons.add(btn_add, gbc_btn_add);
		
		JButton btn_mod = new JButton("Modificar");
		btn_mod.setSize(new Dimension(50, 20));
		btn_mod.setMinimumSize(new Dimension(20, 10));
		btn_mod.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_mod.setMargin(new Insets(10, 20, 10, 20));
		btn_mod.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_mod = new GridBagConstraints();
		gbc_btn_mod.fill = GridBagConstraints.BOTH;
		gbc_btn_mod.insets = new Insets(0, 0, 5, 5);
		gbc_btn_mod.gridx = 1;
		gbc_btn_mod.gridy = 0;
		pan_buttons.add(btn_mod, gbc_btn_mod);
		
		JButton btn_eliminar = new JButton("Eliminar");
		btn_eliminar.setSize(new Dimension(50, 20));
		btn_eliminar.setMinimumSize(new Dimension(20, 10));
		btn_eliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_eliminar.setMargin(new Insets(10, 20, 10, 20));
		btn_eliminar.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_eliminar = new GridBagConstraints();
		gbc_btn_eliminar.fill = GridBagConstraints.BOTH;
		gbc_btn_eliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btn_eliminar.gridx = 2;
		gbc_btn_eliminar.gridy = 0;
		pan_buttons.add(btn_eliminar, gbc_btn_eliminar);
		
		JButton btn_cancel = new JButton("Cancelar");
		btn_cancel.setSize(new Dimension(50, 20));
		btn_cancel.setMinimumSize(new Dimension(20, 10));
		btn_cancel.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_cancel.setMargin(new Insets(10, 20, 10, 20));
		btn_cancel.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_cancel = new GridBagConstraints();
		gbc_btn_cancel.fill = GridBagConstraints.BOTH;
		gbc_btn_cancel.insets = new Insets(0, 0, 5, 0);
		gbc_btn_cancel.gridx = 3;
		gbc_btn_cancel.gridy = 0;
		pan_buttons.add(btn_cancel, gbc_btn_cancel);
		
		JButton btn_inactivate = new JButton("Inactivar");
		btn_inactivate.setSize(new Dimension(50, 20));
		btn_inactivate.setMinimumSize(new Dimension(20, 10));
		btn_inactivate.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_inactivate.setMargin(new Insets(10, 20, 10, 20));
		btn_inactivate.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_inactivate = new GridBagConstraints();
		gbc_btn_inactivate.fill = GridBagConstraints.BOTH;
		gbc_btn_inactivate.insets = new Insets(0, 0, 0, 5);
		gbc_btn_inactivate.gridx = 0;
		gbc_btn_inactivate.gridy = 1;
		pan_buttons.add(btn_inactivate, gbc_btn_inactivate);
		
		JButton btn_reactivate = new JButton("Reactivar");
		btn_reactivate.setSize(new Dimension(50, 20));
		btn_reactivate.setMinimumSize(new Dimension(20, 10));
		btn_reactivate.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_reactivate.setMargin(new Insets(10, 20, 10, 20));
		btn_reactivate.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_reactivate = new GridBagConstraints();
		gbc_btn_reactivate.fill = GridBagConstraints.BOTH;
		gbc_btn_reactivate.insets = new Insets(0, 0, 0, 5);
		gbc_btn_reactivate.gridx = 1;
		gbc_btn_reactivate.gridy = 1;
		pan_buttons.add(btn_reactivate, gbc_btn_reactivate);
		
		JButton btn_update = new JButton("Actualizar");
		btn_update.setSize(new Dimension(50, 20));
		btn_update.setMinimumSize(new Dimension(20, 10));
		btn_update.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_update.setMargin(new Insets(10, 20, 10, 20));
		btn_update.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_update = new GridBagConstraints();
		gbc_btn_update.fill = GridBagConstraints.BOTH;
		gbc_btn_update.insets = new Insets(0, 0, 0, 5);
		gbc_btn_update.gridx = 2;
		gbc_btn_update.gridy = 1;
		pan_buttons.add(btn_update, gbc_btn_update);
		
		JButton btn_exit = new JButton("Salir");
		btn_exit.setSize(new Dimension(50, 20));
		btn_exit.setMinimumSize(new Dimension(20, 10));
		btn_exit.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_exit.setMargin(new Insets(10, 20, 10, 20));
		btn_exit.setMaximumSize(new Dimension(30, 20));
		GridBagConstraints gbc_btn_exit = new GridBagConstraints();
		gbc_btn_exit.fill = GridBagConstraints.BOTH;
		gbc_btn_exit.gridx = 3;
		gbc_btn_exit.gridy = 1;
		pan_buttons.add(btn_exit, gbc_btn_exit);
		
		JScrollPane scrl_tab_cargo = new JScrollPane();
		scrl_tab_cargo.setPreferredSize(new Dimension(400, 80));
		scrl_tab_cargo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrl_tab_cargo.setSize(new Dimension(0, 5));
		pan_tabla_cargo.add(scrl_tab_cargo);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Descripci\u00F3n", "Sueldo", "Estado Registro"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrl_tab_cargo.setViewportView(table);
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
		
		txtcardes = new JTextField();
		GridBagConstraints gbc_txtcardes = new GridBagConstraints();
		gbc_txtcardes.anchor = GridBagConstraints.LINE_START;
		gbc_txtcardes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcardes.insets = new Insets(0, 0, 5, 5);
		gbc_txtcardes.gridx = 1;
		gbc_txtcardes.gridy = 2;
		registro_cargo.add(txtcardes, gbc_txtcardes);
		txtcardes.setColumns(10);
		
		JLabel carestreg = new JLabel("Estado Registro");
		GridBagConstraints gbc_carestreg = new GridBagConstraints();
		gbc_carestreg.fill = GridBagConstraints.BOTH;
		gbc_carestreg.insets = new Insets(0, 0, 5, 5);
		gbc_carestreg.gridx = 0;
		gbc_carestreg.gridy = 3;
		registro_cargo.add(carestreg, gbc_carestreg);
		
		JCheckBox chbxcarestreg = new JCheckBox("");
		GridBagConstraints gbc_chbxcarestreg = new GridBagConstraints();
		gbc_chbxcarestreg.fill = GridBagConstraints.BOTH;
		gbc_chbxcarestreg.insets = new Insets(0, 0, 5, 5);
		gbc_chbxcarestreg.gridx = 1;
		gbc_chbxcarestreg.gridy = 3;
		registro_cargo.add(chbxcarestreg, gbc_chbxcarestreg);
		
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
		pan_cargo.setLayout(gl_pan_cargo);
//		create
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		CargoForm frm = new CargoForm();
		frm.setVisible(true);
		
	}
}
