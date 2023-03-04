package infoSystem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AdminMainMenu extends JFrame {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 5496396135871360175L;
	private JPanel contentPane;
	private JTable tblSearchResult;
	private boolean caseSensitive = true;
	private JPanel homeTab = null;
	private JPanel bookManageTab = null;
	private JPanel memberManageTab = null;
	private JPanel settingTab = null;
	int frameX;
	int frameY;
// Strings for using as button names
	final String ISBN = "ISBN";
	final String TITLE = "Title";
	final String NAME = "Author name";
	private JTable tblMemberInfo;
	private JTextField txtAdminName;
	private JTextField txtAdminPass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainMenu frame = new AdminMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminMainMenu() {

//Images
		ImageSource imageSource = new ImageSource();

		setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 255), new Color(255, 140, 0),
				new Color(250, 128, 114), new Color(255, 255, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.menu, SystemColor.control));
		panelMenu.setBackground(new Color(255, 255, 255));
		panelMenu.setBounds(0, 0, 243, 720);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

// Menu bar	//	
		JLabel lblMainLogo = new JLabel("");
		lblMainLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainLogo.setBounds(24, 50, 188, 88);
		lblMainLogo.setIcon(new ImageIcon(imageSource.getMainLogoImg()));
		panelMenu.add(lblMainLogo);

		JLabel lblTechUniversityLibrary = new JLabel("Tech University Library");
		lblTechUniversityLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblTechUniversityLibrary.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTechUniversityLibrary.setBounds(0, 150, 240, 23);
		panelMenu.add(lblTechUniversityLibrary);

// Home button
		JPanel panelHome = new JPanel();
		panelHome.setBackground(new Color(255, 255, 255));
		panelHome.setBounds(0, 215, 240, 55);
		panelMenu.add(panelHome);
		panelHome.setLayout(null);

		JLabel lblHomeMenuBtn = new JLabel("Home");
		lblHomeMenuBtn.setForeground(new Color(0, 0, 0));
		lblHomeMenuBtn.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblHomeMenuBtn.setBounds(70, 0, 170, 55);
		panelHome.add(lblHomeMenuBtn);
		panelHome.addMouseListener(new MenuBtnMouseAdapter(panelHome, lblHomeMenuBtn));

		JLabel lblHomeIcon = new JLabel("");
		lblHomeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeIcon.setBounds(12, 5, 45, 45);
		lblHomeIcon.setIcon(new ImageIcon(imageSource.getHomeLogoImg()));
		panelHome.add(lblHomeIcon);

// Search button
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(255, 255, 255));
		panelSearch.setBounds(0, 270, 240, 55);
		panelMenu.add(panelSearch);
		panelSearch.setLayout(null);

		JLabel lblBookSearchIcon = new JLabel("");
		lblBookSearchIcon.setBounds(12, 5, 45, 45);
		lblBookSearchIcon.setIcon(new ImageIcon(imageSource.getBookSearchLogoImg()));
		panelSearch.add(lblBookSearchIcon);

		JLabel lblSearchMenuBtn = new JLabel("Search book");
		lblSearchMenuBtn.setForeground(new Color(0, 0, 0));
		lblSearchMenuBtn.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblSearchMenuBtn.setBounds(70, 0, 170, 55);
		panelSearch.add(lblSearchMenuBtn);
		panelSearch.addMouseListener(new MenuBtnMouseAdapter(panelSearch, lblSearchMenuBtn));

// User setting button
		JPanel panelSetting = new JPanel();
		panelSetting.setBackground(new Color(255, 255, 255));
		panelSetting.setBounds(0, 325, 240, 55);
		panelMenu.add(panelSetting);
		panelSetting.setLayout(null);

		JLabel lblSettingMenuBtn = new JLabel("Setting");
		lblSettingMenuBtn.setForeground(new Color(0, 0, 0));
		lblSettingMenuBtn.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblSettingMenuBtn.setBounds(70, 0, 170, 55);
		panelSetting.add(lblSettingMenuBtn);
		panelSetting.addMouseListener(new MenuBtnMouseAdapter(panelSetting, lblSettingMenuBtn));

		JLabel lblSettingIcon = new JLabel("");
		lblSettingIcon.setBounds(12, 5, 45, 45);
		lblSettingIcon.setIcon(new ImageIcon(imageSource.getSettingLogoImg()));
		panelSetting.add(lblSettingIcon);

// Sing out button
		JPanel panelSingOut = new JPanel();
		panelSingOut.setBackground(new Color(255, 255, 255));
		panelSingOut.setBounds(0, 380, 240, 55);
		panelMenu.add(panelSingOut);
		panelSingOut.setLayout(null);

		JLabel lblSignOutMenuBtn = new JLabel("Sign Out");
		lblSignOutMenuBtn.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblSignOutMenuBtn.setForeground(new Color(0, 0, 0));
		lblSignOutMenuBtn.setBounds(69, 0, 171, 55);
		panelSingOut.add(lblSignOutMenuBtn);
		panelSingOut.addMouseListener(new MenuBtnMouseAdapter(panelSingOut, lblSignOutMenuBtn));

		// Exit button
		JLabel lblExitIcon = new JLabel("");
		lblExitIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblExitIcon.setIcon(new ImageIcon(imageSource.getExitLogoHoverImg()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblExitIcon.setIcon(new ImageIcon(imageSource.getExitLogoImg()));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Exit application",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		lblExitIcon.setBounds(1210, 13, 50, 52);
		lblExitIcon.setIcon(new ImageIcon(imageSource.getExitLogoImg()));
		contentPane.add(lblExitIcon);

		JLabel lblMainTitle = new JLabel("Welcome to Tech University Library ");
		lblMainTitle.setBackground(new Color(0, 0, 128));
		lblMainTitle.setForeground(new Color(127, 255, 212));
		lblMainTitle.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lblMainTitle.setOpaque(true);
		lblMainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainTitle.setBounds(246, 13, 1022, 62);
		contentPane.add(lblMainTitle);

		JLabel lblSingOutIcon = new JLabel("");
		lblSingOutIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingOutIcon.setBounds(12, 5, 45, 45);
		lblSingOutIcon.setIcon(new ImageIcon(imageSource.getSingOutLogoImg()));
		panelSingOut.add(lblSingOutIcon);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(218, 112, 214));
		separator.setBounds(10, 186, 221, 2);
		panelMenu.add(separator);

		JPanel panelMain = new JPanel();
		panelMain.setBounds(246, 73, 1022, 642);
		contentPane.add(panelMain);
		panelMain.setBackground(Color.WHITE);
		panelMain.setLayout(null);

		// Default home tab visible
		homeTab = createHomeTab(imageSource.getBookManageImg(), imageSource.getMemberManageImg(), panelMain);
		homeTab.repaint();
		homeTab.setVisible(true);

// Menu button action event		
		panelSearch.addMouseListener(new MouseAdapter() { // event listener
			@Override
			public void mousePressed(MouseEvent e) {
				if (bookManageTab == null) { // optimizing
					bookManageTab = createBookManageTab();
				}
				invisibleAllTab();
				panelMain.add(bookManageTab);
				bookManageTab.repaint();
				bookManageTab.setVisible(true);
			}
		});
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (homeTab == null) {
					homeTab = createHomeTab(imageSource.getBookManageImg(), imageSource.getMemberManageImg(),
							panelMain);
				}
				invisibleAllTab();
				/*
				 * repaint() = used to update the new appearance of the component on the GUI but
				 * have not made any changes to its size
				 */
				homeTab.repaint();
				homeTab.setVisible(true);
			}
		});
		panelSetting.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				// Optimizing- checking whether the object is already created
				if (settingTab == null) {
					settingTab = createSettingTab(panelMain);
				}
				invisibleAllTab();
				panelMain.add(settingTab);
				settingTab.repaint();
				settingTab.setVisible(true);
			}
		});

		panelSingOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// closing the main form JFrame
				dispose();
				AdminLogin loginForm = new AdminLogin();
				loginForm.setVisible(true);
			}
		});

// Administrator control panel		

//JFrame dragged moving implementation
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frameX = e.getXOnScreen() - getX();
				frameY = e.getYOnScreen() - getY();
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen() - frameX, e.getYOnScreen() - frameY);
			}
		});
	}

	public JPanel createSettingTab(JPanel panelMain) {
		JPanel panelSettingTab = new JPanel();
		panelSettingTab.setBounds(12, 13, 998, 680);
		panelMain.add(panelSettingTab);
		panelSettingTab.setLayout(null);
		panelSettingTab.setVisible(false);
		JLabel lblAdminAccountInformation = new JLabel("Admin account information");
		lblAdminAccountInformation.setForeground(Color.BLUE);
		lblAdminAccountInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminAccountInformation.setFont(new Font("Cambria Math", Font.PLAIN, 23));
		lblAdminAccountInformation.setBounds(337, 30, 309, 54);
		panelSettingTab.add(lblAdminAccountInformation);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(362, 154, 95, 32);
		panelSettingTab.add(lblName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(362, 216, 95, 32);
		panelSettingTab.add(lblPassword);

		txtAdminName = new JTextField();
		txtAdminName.setFont(new Font("Arial", Font.PLAIN, 16));
		txtAdminName.setBounds(479, 161, 142, 22);
		panelSettingTab.add(txtAdminName);
		txtAdminName.setColumns(10);

		txtAdminPass = new JTextField();
		txtAdminPass.setFont(new Font("Arial", Font.PLAIN, 16));
		txtAdminPass.setColumns(10);
		txtAdminPass.setBounds(479, 223, 142, 22);
		panelSettingTab.add(txtAdminPass);
		// getting administrator name
		String admin = User.getAdminName();
		// getting administrator password
		char[] adminPassword = User.getAdminPassword();
		String password = new String(adminPassword);
		txtAdminName.setText(admin);
		txtAdminPass.setText(password);
		return panelSettingTab;
	}

	public JPanel createMemberManageTab(JPanel panelMain) {

		JPanel JPanelmemberManageTab = new JPanel();
		JPanelmemberManageTab.setBackground(Color.WHITE);
		JPanelmemberManageTab.setBounds(12, 13, 1010, 629);
		panelMain.add(JPanelmemberManageTab);
		JPanelmemberManageTab.setLayout(null);
		JPanelmemberManageTab.setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 134, 777, 482);
		JPanelmemberManageTab.add(scrollPane);

		tblMemberInfo = new JTable();
		tblMemberInfo.setFont(new Font("Century", Font.PLAIN, 16));
		tblMemberInfo.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "No", "Member", "Gmail", "Phone", "Gender" }) {
			/**
			 * Generated serialVersionUID
			 */
			private static final long serialVersionUID = 2732573805523610181L;
			boolean[] columnEditables = new boolean[] { true, true, true, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblMemberInfo.getColumnModel().getColumn(0).setPreferredWidth(34);
		tblMemberInfo.getColumnModel().getColumn(1).setPreferredWidth(118);
		tblMemberInfo.getColumnModel().getColumn(2).setPreferredWidth(172);
		tblMemberInfo.getColumnModel().getColumn(3).setPreferredWidth(180);
		scrollPane.setViewportView(tblMemberInfo);
		tblMemberInfo.setRowHeight(20);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		JLabel lblMemberGreet = new JLabel("Member information");
		lblMemberGreet.setForeground(Color.MAGENTA);
		lblMemberGreet.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblMemberGreet.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberGreet.setBounds(237, 38, 408, 42);
		JPanelmemberManageTab.add(lblMemberGreet);

		return JPanelmemberManageTab;
	}

	/**
	 * @return JPanel object with visible property false that decorated to show home
	 *         tab when user clicks the home button from the menu bar
	 */
	public JPanel createHomeTab(Image bookManageImg, Image memberManageImg, JPanel panelMain) {

		JPanel panelHomeTab = new JPanel();
		panelHomeTab.setBounds(0, 0, 1022, 642);
		panelHomeTab.setBackground(Color.WHITE);
		panelHomeTab.setLayout(null);
		panelHomeTab.setVisible(false);
		panelMain.add(panelHomeTab);
		JLabel lblTitle = new JLabel("Admin Control panel");
		lblTitle.setBounds(0, 0, 1022, 71);
		lblTitle.setOpaque(true);
		panelHomeTab.add(lblTitle);
		lblTitle.setBackground(SystemColor.textHighlightText);
		lblTitle.setForeground(new Color(255, 99, 71));
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblBookManageIcon = new JLabel("");
		lblBookManageIcon.addMouseListener(new AdminPanelBtnMouseAdapter(lblBookManageIcon));
		lblBookManageIcon.setBackground(new Color(248, 248, 255));
		lblBookManageIcon.setOpaque(true);
		lblBookManageIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookManageIcon.setBounds(30, 100, 150, 140);
		lblBookManageIcon.setIcon(new ImageIcon(bookManageImg));
		panelHomeTab.add(lblBookManageIcon);

		JLabel lblBookManage = new JLabel("Book Management");
		lblBookManage.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBookManage.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookManage.setBounds(30, 242, 150, 27);
		panelHomeTab.add(lblBookManage);

		JLabel lblMemberMangeIcon = new JLabel("");
		lblMemberMangeIcon.addMouseListener(new AdminPanelBtnMouseAdapter(lblMemberMangeIcon));
		lblMemberMangeIcon.setBackground(new Color(248, 248, 255));
		lblMemberMangeIcon.setOpaque(true);
		lblMemberMangeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberMangeIcon.setBounds(243, 100, 150, 140);
		lblMemberMangeIcon.setIcon(new ImageIcon(memberManageImg));
		panelHomeTab.add(lblMemberMangeIcon);

		JLabel lblMemberManage = new JLabel("Member Management");
		lblMemberManage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberManage.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMemberManage.setBounds(243, 242, 150, 27);
		panelHomeTab.add(lblMemberManage);

// Management button event action	
		lblBookManageIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (bookManageTab == null) { // Optimizing
					bookManageTab = createBookManageTab();
				}
				invisibleAllTab();
				panelMain.add(bookManageTab);
				bookManageTab.repaint();
				bookManageTab.setVisible(true);
			}
		});
		lblMemberMangeIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (memberManageTab == null) { // Optimizing
					memberManageTab = createMemberManageTab(panelMain);
				}
				invisibleAllTab();

				panelMain.add(memberManageTab);
				UserAccountDataBase userDatabase = new UserAccountDataBase();
				User userAry[] = userDatabase.getUserAccountAry();
				setTable(userAry);
				memberManageTab.repaint();
				memberManageTab.setVisible(true);
			}
		});

		createMemberManageTab(panelMain);

		return panelHomeTab;
	}

	/**
	 * @return JPanel object with visible property false that decorated to show
	 *         BookManage Tab when user clicks the search button from the menu bar
	 *         or book management button from the home tab.
	 */
	public JPanel createBookManageTab() {
		Image searchImg = new ImageIcon(this.getClass().getResource("../images/searchIcon.png")).getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Image refreshImg = new ImageIcon(this.getClass().getResource("../images/refresh.png")).getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		JPanel panelBookManageTab = new JPanel();
		panelBookManageTab.setBounds(0, 0, 1022, 642);
		panelBookManageTab.setLayout(null);
		panelBookManageTab.setBackground(Color.WHITE);
		panelBookManageTab.setVisible(true);

		JLabel lblLibraryInformationSystem = new JLabel("LIbrary information system");
		lblLibraryInformationSystem.setForeground(new Color(153, 50, 204));
		lblLibraryInformationSystem.setFont(new Font("Cambria Math", Font.PLAIN, 24));
		lblLibraryInformationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibraryInformationSystem.setBounds(12, 13, 1010, 35);
		panelBookManageTab.add(lblLibraryInformationSystem);

		JLabel lblRefreshIcon = new JLabel("");
		lblRefreshIcon.setBackground(new Color(255, 255, 255));
		lblRefreshIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefreshIcon.setBounds(930, 70, 45, 45);
		lblRefreshIcon.setIcon(new ImageIcon(refreshImg));
		panelBookManageTab.add(lblRefreshIcon);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 140, 0));
		separator_1.setBounds(73, 61, 915, 2);
		panelBookManageTab.add(separator_1);

		JLabel lblSortingWith = new JLabel("Sorting with :");
		lblSortingWith.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblSortingWith.setBounds(12, 85, 101, 22);
		panelBookManageTab.add(lblSortingWith);

		JTextField txtSearchData = new JTextField();
		txtSearchData.setBounds(234, 182, 206, 22);
		panelBookManageTab.add(txtSearchData);
		txtSearchData.setColumns(10);

// Sort radio buttons		
		JRadioButton rdbtnIsbnSort = new JRadioButton(ISBN);
		rdbtnIsbnSort.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnIsbnSort.setSelected(true);
		rdbtnIsbnSort.setBackground(Color.WHITE);
		rdbtnIsbnSort.setBounds(115, 84, 69, 25);
		panelBookManageTab.add(rdbtnIsbnSort);

		JRadioButton rdbtnTitleSort = new JRadioButton(TITLE);
		rdbtnTitleSort.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnTitleSort.setBackground(Color.WHITE);
		rdbtnTitleSort.setBounds(203, 84, 70, 25);
		panelBookManageTab.add(rdbtnTitleSort);

		JRadioButton rdbtnAuthorSort = new JRadioButton(NAME);
		rdbtnAuthorSort.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnAuthorSort.setBackground(Color.WHITE);
		rdbtnAuthorSort.setBounds(280, 85, 130, 25);
		panelBookManageTab.add(rdbtnAuthorSort);

		JRadioButton rdbtnCategorySort = new JRadioButton("Category");
		rdbtnCategorySort.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnCategorySort.setBackground(Color.WHITE);
		rdbtnCategorySort.setBounds(409, 86, 96, 25);
		panelBookManageTab.add(rdbtnCategorySort);

		JRadioButton rdbtnEditionSort = new JRadioButton("Edition");
		rdbtnEditionSort.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnEditionSort.setBackground(Color.WHITE);
		rdbtnEditionSort.setBounds(509, 84, 110, 25);
		panelBookManageTab.add(rdbtnEditionSort);

		ButtonGroup sortingChoiceGroup = new ButtonGroup();
		sortingChoiceGroup.add(rdbtnAuthorSort);
		sortingChoiceGroup.add(rdbtnCategorySort);
		sortingChoiceGroup.add(rdbtnTitleSort);
		sortingChoiceGroup.add(rdbtnIsbnSort);
		sortingChoiceGroup.add(rdbtnEditionSort);

// Search radio buttons
		JLabel lblSearchWith = new JLabel("Search with :");
		lblSearchWith.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblSearchWith.setBounds(12, 134, 101, 21);
		panelBookManageTab.add(lblSearchWith);

		JRadioButton rdbtnAuthorSearch = new JRadioButton("Author name");
		rdbtnAuthorSearch.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnAuthorSearch.setBackground(Color.WHITE);
		rdbtnAuthorSearch.setBounds(203, 134, 123, 24);
		panelBookManageTab.add(rdbtnAuthorSearch);

		JRadioButton rdbtnIsbnSearch = new JRadioButton("ISBN");
		rdbtnIsbnSearch.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnIsbnSearch.setSelected(true);
		rdbtnIsbnSearch.setBackground(Color.WHITE);
		rdbtnIsbnSearch.setBounds(115, 134, 69, 22);
		panelBookManageTab.add(rdbtnIsbnSearch);

		JRadioButton rdbtnTitleSearch = new JRadioButton("Title");
		rdbtnTitleSearch.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		rdbtnTitleSearch.setBackground(Color.WHITE);
		rdbtnTitleSearch.setBounds(330, 135, 77, 25);
		panelBookManageTab.add(rdbtnTitleSearch);

		ButtonGroup searchChoiceGroup = new ButtonGroup();
		searchChoiceGroup.add(rdbtnAuthorSearch);
		searchChoiceGroup.add(rdbtnIsbnSearch);
		searchChoiceGroup.add(rdbtnTitleSearch);

		JScrollPane scrollPaneSearchInfo = new JScrollPane();
		scrollPaneSearchInfo.setBounds(73, 232, 922, 397);
		panelBookManageTab.add(scrollPaneSearchInfo);

// Table		
		tblSearchResult = new JTable();
		tblSearchResult.setFont(new Font("Arial", Font.PLAIN, 14));

		tblSearchResult.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "No.", "ISBN", "Title", "Category", "Author", "Publisher", "Edition" }) {
			/**
			 * Generated Serial Version ID
			 */
			private static final long serialVersionUID = -6042856605418326948L;

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblSearchResult.getColumnModel().getColumn(0).setPreferredWidth(53);
		tblSearchResult.getColumnModel().getColumn(1).setPreferredWidth(156);
		tblSearchResult.getColumnModel().getColumn(2).setPreferredWidth(227);
		tblSearchResult.getColumnModel().getColumn(3).setPreferredWidth(157);
		tblSearchResult.getColumnModel().getColumn(4).setPreferredWidth(200);
		tblSearchResult.getColumnModel().getColumn(5).setPreferredWidth(185);
		tblSearchResult.getColumnModel().getColumn(6).setPreferredWidth(120);

		// Adjusting table cell and align text center inside of table cell
		tblSearchResult.setRowHeight(20);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

		tblSearchResult.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblSearchResult.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblSearchResult.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

		scrollPaneSearchInfo.setViewportView(tblSearchResult);

		JLabel lblSearchInfo = new JLabel("Enter search information");
		lblSearchInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearchInfo.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblSearchInfo.setBounds(25, 183, 197, 21);
		panelBookManageTab.add(lblSearchInfo);

		JLabel lblSearchIcon = new JLabel("");
		lblSearchIcon.setBackground(new Color(255, 255, 255));
		lblSearchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchIcon.setBounds(445, 170, 45, 45);
		lblSearchIcon.setIcon(new ImageIcon(searchImg));
		panelBookManageTab.add(lblSearchIcon);

		JToggleButton toggleCaseBtn = new JToggleButton("Activate");
		toggleCaseBtn.setFont(new Font("Square721 BT", Font.PLAIN, 12));
		toggleCaseBtn.setBackground(new Color(127, 255, 0));
		toggleCaseBtn.setBounds(509, 181, 110, 25);
		panelBookManageTab.add(toggleCaseBtn);
		toggleCaseBtn.setFocusable(false);

		JLabel lblCaseSensitive = new JLabel("Case sensitive");
		lblCaseSensitive.setForeground(new Color(255, 99, 71));
		lblCaseSensitive.setBackground(new Color(255, 255, 255));
		lblCaseSensitive.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblCaseSensitive.setBounds(631, 182, 126, 19);
		panelBookManageTab.add(lblCaseSensitive);

// Cursor Hover effect
		// Case sensitive activate-deactivate button
		toggleCaseBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (toggleCaseBtn.isSelected()) {
					caseSensitive = true;
					toggleCaseBtn.setText("Activate");
					toggleCaseBtn.setBackground(new Color(57, 255, 20));
				} else {
					caseSensitive = false;
					toggleCaseBtn.setText("De-activate");
					toggleCaseBtn.setBackground(new Color(255, 123, 25));
				}
			}

		});
		// Search icon
		lblSearchIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblRefreshIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

// Getting book data array from BookDatabase.java file
		BookDatabase bookDatabase = BookDatabase.getInstance();
		Book[] bookDataAry = bookDatabase.getBookAry();
		InfoSystem infoSystem = new InfoSystem();
		setTable(bookDataAry, infoSystem); // default data view of table

// Refresh button
		lblRefreshIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setTable(bookDataAry, infoSystem);
			}
		});

// Sorting radio button actionListener

		rdbtnIsbnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoSystem.quickSortBook(bookDataAry, BookProperty.ISBN);
				setTable(bookDataAry, infoSystem);
			}
		});
		rdbtnTitleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoSystem.quickSortBook(bookDataAry, BookProperty.TITLE);
				setTable(bookDataAry, infoSystem);
			}
		});
		rdbtnCategorySort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoSystem.quickSortBook(bookDataAry, BookProperty.CATEGORY);
				setTable(bookDataAry, infoSystem);
			}
		});
		rdbtnAuthorSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoSystem.quickSortBook(bookDataAry, BookProperty.AUTHOR);
				setTable(bookDataAry, infoSystem);
			}
		});
		rdbtnEditionSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoSystem.quickSortBook(bookDataAry, BookProperty.EDITION);
				setTable(bookDataAry, infoSystem);
			}
		});

// Search radio buttons actionListener
		rdbtnIsbnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblSearchInfo.setText("Enter ISBN :");
			}
		});
		rdbtnAuthorSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblSearchInfo.setText("Enter author name :");
			}
		});
		rdbtnTitleSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblSearchInfo.setText("Enter book title :");
			}
		});

		txtSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				searchRdbtnAction(txtSearchData, searchChoiceGroup, bookDataAry, infoSystem, caseSensitive);
			}
		});

		lblSearchIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				searchRdbtnAction(txtSearchData, searchChoiceGroup, bookDataAry, infoSystem, caseSensitive);
			}
		});

		return panelBookManageTab;
	}

	public void searchRdbtnAction(JTextField txtSearchData, ButtonGroup sortingChoiceGroup, Book[] bookDataAry,
			InfoSystem infoSystem, boolean caseSensitive) {
		if (txtSearchData.getText().length() <= 0) {
			setTable(bookDataAry, infoSystem);
		} else {
			searchRdbtGroup(txtSearchData, sortingChoiceGroup, bookDataAry, infoSystem, caseSensitive);
		}
	}

	/**
	 * @param txtSearchData      JTextField where the user enter the search keyword
	 * 
	 * @param sortingChoiceGroup ButtonGroup sorting button group
	 * 
	 * @param bookDataAry        Book array
	 * 
	 * @param infoSystem         InfoSystem object
	 * 
	 * @param caseSensitive      to search the book with or without case sensitive
	 */
	public void searchRdbtGroup(JTextField txtSearchData, ButtonGroup sortingChoiceGroup, Book[] bookDataAry,
			InfoSystem infoSystem, boolean caseSensitive) {
		/*
		 * getting all sorting radio buttons from @param sortingChoiceGroup by type
		 * casting List to arrayList
		 */
		ArrayList<AbstractButton> btn = Collections.list(sortingChoiceGroup.getElements());
		// looping all the radio sort button to check which radio button is selected
		String searchKeyWord = txtSearchData.getText();
		for (AbstractButton rdbtn : btn) {
			if (rdbtn.isSelected()) {
				if (rdbtn.getText().equals(ISBN)) {
					// checking the given ISBN is the correct format or not
					if (!InfoSystem.isIsbn(searchKeyWord)) {

						JOptionPane.showMessageDialog(null, "ISBN need to be 13 digits number ", "Wrong format",
								JOptionPane.ERROR_MESSAGE);
						break;
					}
					// search book based on ISBN property
					isbnSearch(searchKeyWord, bookDataAry, infoSystem);
					break;
				} else {
					// searching method based on the property except from ISBN property
					boolean found = searchBookProperty(bookDataAry, infoSystem, caseSensitive, rdbtn, searchKeyWord);
					if (found) {
						break;
					}
				}
			}

		}
	}

// searching method based on the property except from ISBN property
	/**
	 * @return true if the selected radio has been executed
	 * 
	 * @return false the selected radio button is not found
	 */
	public boolean searchBookProperty(Book[] bookDataAry, InfoSystem infoSystem, boolean caseSensitive,
			AbstractButton rdbtn, String searchKeyWord) {
		Book[] possibleBookList = null;
		String rdBtnName = rdbtn.getText();
		if (rdBtnName.equals(TITLE)) {
			// book search based on title
			possibleBookList = infoSystem.searchBookProperty(bookDataAry, searchKeyWord, BookProperty.TITLE,
					caseSensitive);

		} else if (rdBtnName.equals(NAME)) {
			// book search based on author name
			possibleBookList = infoSystem.searchBookProperty(bookDataAry, searchKeyWord, BookProperty.AUTHOR,
					caseSensitive);
		} // continuing if more book properties are added

		if (possibleBookList == null) { // searching books not found
			JOptionPane.showMessageDialog(null, searchKeyWord + "'s is not found", "Book not found",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		setTable(possibleBookList, infoSystem);
		return true;

	}

	public void isbnSearch(String isbn, Book[] bookDataAry, InfoSystem infoSystem) {
		int index = infoSystem.searchIsbn(bookDataAry, isbn);
		if (index >= 0) {
			setTable(bookDataAry, infoSystem, index);
		} else {// book not found in the array
			JOptionPane.showMessageDialog(null, "There is no book with " + isbn, "Book not found",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// set up table with array of book
	void setTable(Book[] bookAry, InfoSystem infoSystem) {
		DefaultTableModel tblModel = (DefaultTableModel) tblSearchResult.getModel();
		tblModel.setRowCount(0);
		int serialNum = 1; // always 1 because ISBN is unique
		for (Book book : bookAry) {
			String isbn = infoSystem.formattingIsbn(book.getIsbn());
			String title = book.getTitle();
			String category = book.getCategory();
			String author = book.getAuthor();
			String publisher = book.getPublisher();
			String Edition = book.getEdition();
			Object[] rowData = new Object[] { serialNum, isbn, title, category, author, publisher, Edition };
			tblModel.addRow(rowData);
			serialNum++;
		}
	}

	// set up table with only one specific index of book array
	void setTable(Book[] bookAry, InfoSystem infoSystem, int index) {
		DefaultTableModel tblModel = (DefaultTableModel) tblSearchResult.getModel();
		tblModel.setRowCount(0);
		int serialNum = 1;
		String isbn = infoSystem.formattingIsbn(bookAry[index].getIsbn());
		String title = bookAry[index].getTitle();
		String category = bookAry[index].getCategory();
		String author = bookAry[index].getAuthor();
		String publisher = bookAry[index].getPublisher();
		String Edition = bookAry[index].getEdition();

		Object[] row = new Object[] { serialNum, isbn, title, category, author, publisher, Edition };

		tblModel.addRow(row);
	}

	// set up user table with member
	void setTable(User[] userAry) {
		DefaultTableModel tblModel = (DefaultTableModel) tblMemberInfo.getModel();
		tblModel.setRowCount(0);
		int serialNum = 1; // always 1 because ISBN is unique
		for (User user : userAry) {

			String userName = user.getUserName();
			String gender = user.getGender();
			String email = user.getEmail();
			String phoneNum = user.getPhoneNum();

			Object[] rowData = new Object[] { serialNum, userName, email, phoneNum, gender };
			tblModel.addRow(rowData);
			serialNum++;
		}
	}

	void invisibleAllTab() {
		if (homeTab != null) {
			homeTab.setVisible(false);
		}
		if (bookManageTab != null) {
			bookManageTab.setVisible(false);
		}
		if (memberManageTab != null) {
			memberManageTab.setVisible(false);
		}
		if (settingTab != null) {
			settingTab.setVisible(false);
		}
	}
}
