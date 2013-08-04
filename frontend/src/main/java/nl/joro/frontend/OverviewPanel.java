package nl.joro.frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class OverviewPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public OverviewPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][grow][][][][grow]", "[]"));
		
		JLabel lblNewLabel = new JLabel("Rekening");
		panel.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 0,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Aantal mutaties");
		panel.add(lblNewLabel_1, "cell 2 0");
		
		JLabel lblNewLabel_2 = new JLabel("0");
		panel.add(lblNewLabel_2, "cell 3 0");
		
		JLabel lblNewLabel_3 = new JLabel("Jaar");
		panel.add(lblNewLabel_3, "cell 4 0,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1, "cell 5 0,growx");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Datum", "Tegenrekening", "Naam/Omschrijving", "Bedrag", "Bij/Af", "Mutatiesoort", "Rekening", "Mededelingen", "Post"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(6).setResizable(false);
		
		panel_1.add(new JScrollPane(table), BorderLayout.CENTER);
	}

}
