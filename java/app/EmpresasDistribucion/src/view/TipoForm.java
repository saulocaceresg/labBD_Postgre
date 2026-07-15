package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
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

import controller.CargoController;
import controller.TipoEmpresaController;
import model.Cargo;
import model.TipoEmpresa;

public class TipoForm extends JFrame{
	
	private JTextField txttipcod;
	private JTextField txttipnom;
	private JTable table;
	private JTextField txttipestreg;

	public TipoForm () {
		setSize(new Dimension(520, 500));
		setTitle("TIPO DE EMPRESA");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pan_tipo = new JPanel();
		getContentPane().add(pan_tipo);
		
		JPanel registro_tipo = new JPanel();
		registro_tipo.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Registro de Tipos de Empresas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel pan_tabla_tipo = new JPanel();
		pan_tabla_tipo.setBorder(new TitledBorder(null, "Tabla_tipo", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel pan_buttons = new JPanel();
		pan_buttons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_pan_tipo = new GroupLayout(pan_tipo);
		gl_pan_tipo.setHorizontalGroup(
			gl_pan_tipo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_tipo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pan_tipo.createParallelGroup(Alignment.LEADING)
						.addComponent(registro_tipo, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addComponent(pan_tabla_tipo, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addComponent(pan_buttons, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
					.addGap(31))
		);
		gl_pan_tipo.setVerticalGroup(
			gl_pan_tipo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan_tipo.createSequentialGroup()
					.addContainerGap()
					.addComponent(registro_tipo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pan_tabla_tipo, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
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
		
		JScrollPane scrl_tab_tipo = new JScrollPane();
		scrl_tab_tipo.setPreferredSize(new Dimension(400, 100));
		scrl_tab_tipo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrl_tab_tipo.setSize(new Dimension(0, 4));
		pan_tabla_tipo.add(scrl_tab_tipo);
		
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
		scrl_tab_tipo.setViewportView(table);
		GridBagLayout gbl_registro_cargo = new GridBagLayout();
		gbl_registro_cargo.columnWidths = new int[] {55, 250};
		gbl_registro_cargo.rowHeights = new int[] {0, 20, 20, 0};
		gbl_registro_cargo.columnWeights = new double[]{0.0, 1.0};
		gbl_registro_cargo.rowWeights = new double[]{0.0, 0.0, 0.0};
		registro_tipo.setLayout(gbl_registro_cargo);
		
		JLabel carid = new JLabel("Código");
		GridBagConstraints gbc_carid = new GridBagConstraints();
		gbc_carid.anchor = GridBagConstraints.LINE_START;
		gbc_carid.fill = GridBagConstraints.BOTH;
		gbc_carid.insets = new Insets(0, 10, 5, 5);
		gbc_carid.gridx = 0;
		gbc_carid.gridy = 0;
		registro_tipo.add(carid, gbc_carid);
		
		txttipcod = new JTextField();
		txttipcod.setEditable(false);
		txttipcod.setEnabled(false);
		GridBagConstraints gbc_txttipcod = new GridBagConstraints();
		gbc_txttipcod.anchor = GridBagConstraints.LINE_START;
		gbc_txttipcod.insets = new Insets(0, 0, 5, 0);
		gbc_txttipcod.gridx = 1;
		gbc_txttipcod.gridy = 0;
		registro_tipo.add(txttipcod, gbc_txttipcod);
		txttipcod.setColumns(10);
		
		JLabel tipnom = new JLabel("Nombre");
		tipnom.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_tipnom = new GridBagConstraints();
		gbc_tipnom.anchor = GridBagConstraints.LINE_START;
		gbc_tipnom.fill = GridBagConstraints.BOTH;
		gbc_tipnom.insets = new Insets(0, 10, 5, 5);
		gbc_tipnom.gridx = 0;
		gbc_tipnom.gridy = 1;
		registro_tipo.add(tipnom, gbc_tipnom);
		
		txttipnom = new JTextField();
		txttipnom.setEditable(false);
		txttipnom.setEnabled(false);
		GridBagConstraints gbc_txttipnom = new GridBagConstraints();
		gbc_txttipnom.anchor = GridBagConstraints.LINE_START;
		gbc_txttipnom.insets = new Insets(0, 0, 5, 0);
		gbc_txttipnom.gridx = 1;
		gbc_txttipnom.gridy = 1;
		registro_tipo.add(txttipnom, gbc_txttipnom);
		txttipnom.setColumns(10);
		
		JLabel tipestreg = new JLabel("Estado Registro");
		GridBagConstraints gbc_tipestreg = new GridBagConstraints();
		gbc_tipestreg.anchor = GridBagConstraints.EAST;
		gbc_tipestreg.fill = GridBagConstraints.VERTICAL;
		gbc_tipestreg.insets = new Insets(0, 10, 5, 5);
		gbc_tipestreg.gridx = 0;
		gbc_tipestreg.gridy = 2;
		registro_tipo.add(tipestreg, gbc_tipestreg);
		
		txttipestreg = new JTextField();
		txttipestreg.setEnabled(false);
		txttipestreg.setEditable(false);
		GridBagConstraints gbc_txttipestreg = new GridBagConstraints();
		gbc_txttipestreg.insets = new Insets(0, 0, 5, 0);
		gbc_txttipestreg.weightx = 1.0;
		gbc_txttipestreg.anchor = GridBagConstraints.LINE_START;
		gbc_txttipestreg.gridx = 1;
		gbc_txttipestreg.gridy = 2;
		registro_tipo.add(txttipestreg, gbc_txttipestreg);
		txttipestreg.setColumns(3);
		pan_tipo.setLayout(gl_pan_tipo);
//		create
		setVisible(true);
		
		// Objeto Controller para conectar con la BD
		TipoEmpresaController controller = new TipoEmpresaController(this);
		
		controller.loadTable();
		
		btn_add.addActionListener(e -> {
			btn_cancel.setEnabled(true);
			
			txttipnom.setEnabled(true);
			txttipnom.setEditable(true);
			txttipnom.setFocusable(true);
			
			txttipestreg.setText("A");
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
			
			txttipcod.setText(table.getValueAt(row, 0).toString());
		    txttipnom.setText(table.getValueAt(row, 1).toString());
		    txttipnom.setEnabled(true);
		    txttipnom.setEditable(true);
		    txttipestreg.setText(table.getValueAt(row, 4).toString());
		    
		    // inhabilita el código y el estado de registro
		    txttipcod.setEditable(false);
		    txttipestreg.setEditable(false);
		    
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
		txttipcod.setText("");
		txttipcod.setEnabled(false);
		txttipcod.setEditable(false);
		txttipnom.setText("");
		txttipnom.setEnabled(false);
		txttipnom.setEditable(false);
	    txttipestreg.setEnabled(false);
	    txttipestreg.setEditable(false);
	}
	
	public String getTipid() {
		return txttipcod.getText().trim();
	}

	public String getTipnom() {
		return txttipnom.getText().trim();
	}

	public String getTipestreg() {
		return txttipestreg.getText().trim();
	}
	
	public void loadTable(List<TipoEmpresa> tipos) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		for (TipoEmpresa c : tipos) {
			model.addRow(new Object[] {
					c.getTipid(),
					c.getTipnom(),
					c.getTipestreg()
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
		
		TipoForm frm = new TipoForm();
		frm.setVisible(true);

	}

}
