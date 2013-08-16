package nl.joro.frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;

public class Main {

	private JFrame frmOfflineRekeningOverzicht;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmOfflineRekeningOverzicht.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOfflineRekeningOverzicht = new JFrame();
		frmOfflineRekeningOverzicht.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/euro munt.jpg")));
		frmOfflineRekeningOverzicht.setTitle("Offline Rekening Overzicht");
		frmOfflineRekeningOverzicht.setBounds(100, 100, 800, 600);
		frmOfflineRekeningOverzicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmOfflineRekeningOverzicht.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Bestand");
		mnFile.setMnemonic('b');
		menuBar.add(mnFile);
		
		JMenuItem mntmAccounts = new JMenuItem("Rekeningen");
		mnFile.add(mntmAccounts);

		JMenuItem mntmImport = new JMenuItem("Importeren");
		mnFile.add(mntmImport);
		
		JMenuItem mntmMutationPost = new JMenuItem("Mutatieposten");
		mnFile.add(mntmMutationPost);

		JMenuItem mntmAutoPost = new JMenuItem("Autoposten");
		mnFile.add(mntmAutoPost);
		
		JMenuItem mntmCategories = new JMenuItem("Categorieen");
		mnFile.add(mntmCategories);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmQuickSearch = new JMenuItem("Snel zoeken");
		mnFile.add(mntmQuickSearch);
		
		JMenuItem mntmExport = new JMenuItem("Exporteren");
		mnFile.add(mntmExport);
		
		JMenuItem mntmPrint = new JMenuItem("Printen");
		mnFile.add(mntmPrint);
		
		JMenuItem mntmExit = new JMenuItem("Afsluiten");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		mnFile.add(mntmExit);
		
		JMenu mnMutations = new JMenu("Mutaties");
		mnMutations.setMnemonic('m');
		menuBar.add(mnMutations);

		JMenuItem mntmManualAdd = new JMenuItem("Handmatig toevoegen");
		mnMutations.add(mntmManualAdd);

		JMenuItem mntmManualRemove = new JMenuItem("Verwijderen");
		mnMutations.add(mntmManualRemove);

		JMenu mnSelection = new JMenu("Selectie");
		mnSelection.setMnemonic('s');
		menuBar.add(mnSelection);
		
		JMenuItem mntmSelection = new JMenuItem("Nieuwe selectie");
		mnSelection.add(mntmSelection);

		JMenu mnOverviews = new JMenu("Overzichten");
		mnOverviews.setMnemonic('o');
		menuBar.add(mnOverviews);

		JMenuItem mntmTotalByYear = new JMenuItem("Jaartotalen");
		mnOverviews.add(mntmTotalByYear);
		
		JMenuItem mntmYearOverview = new JMenuItem("Overzicht meerdere jaren");
		mnOverviews.add(mntmYearOverview);
		
		JMenuItem mntmTotalByMutationGroup = new JMenuItem("Totalen per mutatiepost");
		mnOverviews.add(mntmTotalByMutationGroup);

		JMenuItem mntmTotalByCategory = new JMenuItem("Totalen per categorie");
		mnOverviews.add(mntmTotalByCategory);
		
		JMenu mnExtra = new JMenu("Extra");
		mnExtra.setMnemonic('x');
		menuBar.add(mnExtra);
		
		JMenuItem mntmReferenceBalance = new JMenuItem("Referentie saldi");
		mnExtra.add(mntmReferenceBalance);
		
		JMenuItem mntmBalances = new JMenuItem("Saldi");
		mnExtra.add(mntmBalances);
		
		JMenuItem mntmOverviewImports = new JMenuItem("Overzicht import");
		mnExtra.add(mntmOverviewImports);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('h');
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("Over dit programma");
		mnHelp.add(mntmAbout);
		frmOfflineRekeningOverzicht.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmOfflineRekeningOverzicht.getContentPane().add(tabbedPane, "cell 0 0,grow");
		OverviewPanel overviewPanel = new OverviewPanel();
		tabbedPane.addTab("Overzicht", null, overviewPanel, null);
		
		JTabbedPane tabSearch = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Zoeken", null, tabSearch, null);
	}

}
