package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.EmpresaController;
import model.Empresa;

public class EmpresaForm extends JFrame {
	
	private JTextField txtempcod;
	private JTextField txtempnom;
	private JTable table;
	private JTextField txtempestreg;
	private JTextField txt_tipemp;

	public EmpresaForm() {
		setSize(new Dimension(520, 500));
		setTitle("EMPRESAS");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pan_emp = new JPanel();
		getContentPane().add(pan_emp);
		
		JPanel registro_empresa = new JPanel();
		registro_empresa.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Registro de Empresas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel pan_tabla_empresa = new JPanel();
		pan_tabla_empresa.setBorder(new TitledBorder(null, "Tabla_empresa", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel pan_buttons = new JPanel();
		pan_buttons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_pan_emp = new GroupLayout(pan_emp);
		gl_pan_emp.setHorizontalGroup(
			gl_pan_emp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_emp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pan_emp.createParallelGroup(Alignment.LEADING)
						.addComponent(registro_empresa, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addComponent(pan_tabla_empresa, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addComponent(pan_buttons, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
					.addGap(31))
		);
		gl_pan_emp.setVerticalGroup(
			gl_pan_emp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_emp.createSequentialGroup()
					.addContainerGap()
					.addComponent(registro_empresa, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pan_tabla_empresa, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pan_buttons, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
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
		btn_mod.setEnabled(false); // se inhabilita hasta que se selecciona un registro
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
		btn_eliminar.setEnabled(false);
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
		btn_cancel.setEnabled(false);
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
		btn_inactivate.setEnabled(false);
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
		btn_reactivate.setEnabled(false);
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
		
		JScrollPane scrl_tab_empresa = new JScrollPane();
		scrl_tab_empresa.setPreferredSize(new Dimension(400, 100));
		scrl_tab_empresa.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrl_tab_empresa.setSize(new Dimension(0, 4));
		pan_tabla_empresa.add(scrl_tab_empresa);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Estado Registro"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setMinWidth(16);
		scrl_tab_empresa.setViewportView(table);
		GridBagLayout gbl_registro_empresa = new GridBagLayout();
		gbl_registro_empresa.columnWidths = new int[] {55, 250};
		gbl_registro_empresa.rowHeights = new int[] {0, 20, 20, 0};
		gbl_registro_empresa.columnWeights = new double[]{0.0, 1.0};
		gbl_registro_empresa.rowWeights = new double[]{0.0, 0.0, 0.0};
		registro_empresa.setLayout(gbl_registro_empresa);
		
		JLabel empid = new JLabel("Código");
		GridBagConstraints gbc_empid = new GridBagConstraints();
		gbc_empid.anchor = GridBagConstraints.LINE_START;
		gbc_empid.fill = GridBagConstraints.BOTH;
		gbc_empid.insets = new Insets(0, 10, 5, 5);
		gbc_empid.gridx = 0;
		gbc_empid.gridy = 0;
		registro_empresa.add(empid, gbc_empid);
		
		txtempcod = new JTextField();
		txtempcod.setEditable(false);
		txtempcod.setEnabled(false);
		GridBagConstraints gbc_txtempcod = new GridBagConstraints();
		gbc_txtempcod.anchor = GridBagConstraints.LINE_START;
		gbc_txtempcod.insets = new Insets(0, 0, 5, 0);
		gbc_txtempcod.gridx = 1;
		gbc_txtempcod.gridy = 0;
		registro_empresa.add(txtempcod, gbc_txtempcod);
		txtempcod.setColumns(10);
		
		JLabel tipnom = new JLabel("Nombre");
		tipnom.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_tipnom = new GridBagConstraints();
		gbc_tipnom.anchor = GridBagConstraints.LINE_START;
		gbc_tipnom.fill = GridBagConstraints.BOTH;
		gbc_tipnom.insets = new Insets(0, 10, 5, 5);
		gbc_tipnom.gridx = 0;
		gbc_tipnom.gridy = 1;
		registro_empresa.add(tipnom, gbc_tipnom);
		
		txtempnom = new JTextField();
		txtempnom.setEditable(false);
		txtempnom.setEnabled(false);
		GridBagConstraints gbc_txttipnom = new GridBagConstraints();
		gbc_txttipnom.anchor = GridBagConstraints.LINE_START;
		gbc_txttipnom.insets = new Insets(0, 0, 5, 0);
		gbc_txttipnom.gridx = 1;
		gbc_txttipnom.gridy = 1;
		registro_empresa.add(txtempnom, gbc_txttipnom);
		txtempnom.setColumns(10);
		
		JLabel lbl_tipid = new JLabel("Tipo de Empresa");
		lbl_tipid.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_tipid = new GridBagConstraints();
		gbc_lbl_tipid.anchor = GridBagConstraints.EAST;
		gbc_lbl_tipid.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_tipid.gridx = 0;
		gbc_lbl_tipid.gridy = 2;
		registro_empresa.add(lbl_tipid, gbc_lbl_tipid);
		
		txt_tipemp = new JTextField();
		txt_tipemp.setEnabled(false);
		txt_tipemp.setEditable(false);
		txt_tipemp.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txt_tipemp = new GridBagConstraints();
		gbc_txt_tipemp.anchor = GridBagConstraints.WEST;
		gbc_txt_tipemp.insets = new Insets(0, 0, 5, 0);
		gbc_txt_tipemp.gridx = 1;
		gbc_txt_tipemp.gridy = 2;
		registro_empresa.add(txt_tipemp, gbc_txt_tipemp);
		txt_tipemp.setColumns(10);
		
		JLabel tipestreg = new JLabel("Estado Registro");
		GridBagConstraints gbc_tipestreg = new GridBagConstraints();
		gbc_tipestreg.anchor = GridBagConstraints.EAST;
		gbc_tipestreg.fill = GridBagConstraints.VERTICAL;
		gbc_tipestreg.insets = new Insets(0, 10, 0, 5);
		gbc_tipestreg.gridx = 0;
		gbc_tipestreg.gridy = 3;
		registro_empresa.add(tipestreg, gbc_tipestreg);
		
		txtempestreg = new JTextField();
		txtempestreg.setEnabled(false);
		txtempestreg.setEditable(false);
		GridBagConstraints gbc_txttipestreg = new GridBagConstraints();
		gbc_txttipestreg.weightx = 1.0;
		gbc_txttipestreg.anchor = GridBagConstraints.LINE_START;
		gbc_txttipestreg.gridx = 1;
		gbc_txttipestreg.gridy = 3;
		registro_empresa.add(txtempestreg, gbc_txttipestreg);
		txtempestreg.setColumns(3);
		pan_emp.setLayout(gl_pan_emp);
//		create
		setVisible(true);
		
		// Objeto Controller para conectar con la BD
		EmpresaController controller = new EmpresaController(this);
		
		controller.loadTable();
		
		btn_add.addActionListener(e -> {
			btn_cancel.setEnabled(true);
			
			txtempnom.setEnabled(true);
			txtempnom.setEditable(true);
			txtempnom.setFocusable(true);
			
			txt_tipemp.setEnabled(true);
			txt_tipemp.setEditable(true);
			
			txtempestreg.setText("A");
			controller.add();
		});
		
		// detecta cuando el usuario hace click en una de las grillas
		table.getSelectionModel().addListSelectionListener(e -> {
			
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				boolean isSelection = row != -1;
				
				btn_mod.setEnabled(isSelection);
				btn_eliminar.setEnabled(isSelection);
				
				if (isSelection) {
					String estreg = table.getValueAt(row, 4).toString();
					btn_inactivate.setEnabled(estreg.equals("A"));
					btn_reactivate.setEnabled(estreg.equals("I"));
				} else {
					btn_inactivate.setEnabled(false);
					btn_reactivate.setEnabled(false);
				}
			}
		});
		
		btn_mod.addActionListener(e -> {
			btn_cancel.setEnabled(true);
			
			int row = table.getSelectedRow();
			if (row == -1) return;
			
			txtempcod.setText(table.getValueAt(row, 0).toString());
		    txtempnom.setText(table.getValueAt(row, 1).toString());
		    txtempnom.setEnabled(true);
		    txtempnom.setEditable(true);
		    txtempestreg.setText(table.getValueAt(row, 4).toString());
		    
		    // inhabilita el código y el estado de registro
		    txtempcod.setEditable(false);
		    txtempestreg.setEditable(false);
		    
			controller.modify();
		});
		
		btn_eliminar.addActionListener(e -> {
			int id = getSelectedTipId();
			if (id != -1) controller.delete(id);
		});
		
		btn_cancel.addActionListener(e -> {
			disableFields();
			controller.cancel();
		    table.clearSelection();
		    btn_mod.setEnabled(false);
		    btn_cancel.setEnabled(false);
		});
		
		btn_inactivate.addActionListener(e -> {
			int id = getSelectedTipId();
			if (id != -1) controller.inactivate(id);
			//btn_inactivate.setEnabled(false);
		});
		
		btn_reactivate.addActionListener(e -> {
			int id = getSelectedTipId();
			if (id != -1) controller.reactivate(id); 
			//btn_reactivate.setEnabled(false);
		});
		
		btn_update.addActionListener(e -> {
			controller.update();
		});
		
		btn_exit.addActionListener(e -> {
			dispose();
		});
	}
	
	// inhabilita los campos para evitar errores luego de cancelar una acción. 
	// El usuario podría ingresar datos y estos generar errores.
	public void disableFields() {
		txtempcod.setText("");
		txtempcod.setEnabled(false);
		txtempcod.setEditable(false);
		txtempnom.setText("");
		txtempnom.setEnabled(false);
		txtempnom.setEditable(false);
	    txtempestreg.setEnabled(false);
	    txtempestreg.setEditable(false);
	}
	
	public String getEmpid() {
		return txtempcod.getText().trim();
	}

	public String getEmpnom() {
		return txtempnom.getText().trim();
	}

	public String getEmpestreg() {
		return txtempestreg.getText().trim();
	}

	public int getTipId() {
		return Integer.parseInt(txt_tipemp.getText().trim());
	}
	
	public void loadTable(List<Empresa> empresas) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		for (Empresa c : empresas) {
			model.addRow(new Object[] {
					c.getTipid(),
					c.getEmpnom(),
					c.getEmpestreg()
			});
		}
	}
	
	// método para obtener el código
	public int getSelectedTipId() {
		int row = table.getSelectedRow();
		if (row != -1) return -1;
		int id = Integer.parseInt(table.getValueAt(row, 0).toString());
		System.out.println("Id de la fila seleccionada: " + id);
		return id;
	}

	public static void main(String[] args) {

		EmpresaForm frm = new EmpresaForm();
		frm.setVisible(true);
		
	}
}
