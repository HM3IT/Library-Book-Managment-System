package infoSystem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class MemeberLogin extends JFrame {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 6930935022266630864L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUserName;

	Image loginImg = new ImageIcon(this.getClass().getResource("../images/login.png")).getImage().getScaledInstance(100,
			100, Image.SCALE_SMOOTH);
	Image exitImg = new ImageIcon(this.getClass().getResource("../images/exit.png")).getImage().getScaledInstance(30,
			30, Image.SCALE_SMOOTH);

	Image showEyeImg = new ImageIcon(MemeberLogin.class.getResource("../images/eyeView.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	Image blindEyeImg = new ImageIcon(MemeberLogin.class.getResource("../images/eyeHide.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	int frameX;
	int frameY;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					MemeberLogin frame = new MemeberLogin();
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
	public MemeberLogin() {

		UserAccountDataBase userDatabase = UserAccountDataBase.getInstance();
		User[] accounts = userDatabase.getUserAccountAry();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 480, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 255), new Color(175, 238, 238)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Member login");
		lblLogin.setFont(new Font("Cambria Math", Font.PLAIN, 26));
		lblLogin.setBounds(145, 93, 180, 31);
		contentPane.add(lblLogin);

		JLabel lblLoginIcon = new JLabel("");
		lblLoginIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginIcon.setBounds(175, 13, 111, 80);
		lblLoginIcon.setIcon(new ImageIcon(loginImg));
		contentPane.add(lblLoginIcon);

		JLabel lblUserName = new JLabel("User name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblUserName.setBounds(111, 160, 100, 25);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
		lblPassword.setBounds(111, 203, 100, 25);
		contentPane.add(lblPassword);

		txtPassword = new JPasswordField(15);
		txtPassword.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		txtPassword.setBounds(228, 205, 150, 25);
		contentPane.add(txtPassword);

		txtUserName = new JTextField(15);
		txtUserName.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		txtUserName.setBounds(228, 161, 150, 25);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		// Button
		JButton btnSignIn = new JButton("Sign in");

		btnSignIn.setFocusable(false);
		btnSignIn.setBackground(new Color(255, 255, 255));
		btnSignIn.setForeground(new Color(0, 0, 0));
		btnSignIn.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		btnSignIn.setBounds(255, 292, 100, 35);
		contentPane.add(btnSignIn);

		JButton btnCancel = new JButton("Cancel");

		btnCancel.setFocusable(false);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		btnCancel.setBounds(131, 292, 100, 35);
		contentPane.add(btnCancel);

		JLabel lblShowEyeIcon = new JLabel("");
		lblShowEyeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowEyeIcon.setIcon(new ImageIcon(showEyeImg));
		lblShowEyeIcon.setBounds(386, 203, 47, 27);
		contentPane.add(lblShowEyeIcon);

		JLabel lblBlindEyeIcon = new JLabel("");
		lblBlindEyeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlindEyeIcon.setIcon(new ImageIcon(blindEyeImg));
		lblBlindEyeIcon.setBounds(386, 203, 47, 27);
		contentPane.add(lblBlindEyeIcon);

// Error information message		
		JLabel lblSignInMesg = new JLabel("");
		lblSignInMesg.setForeground(new Color(255, 20, 147));
		lblSignInMesg.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignInMesg.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblSignInMesg.setBounds(121, 251, 256, 25);
		contentPane.add(lblSignInMesg);

// Event listeners //

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

// SignIn button 
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignIn.setBorder(BorderFactory.createLineBorder(new Color(57, 255, 20)));
				btnSignIn.setBackground(new Color(255, 255, 255));
				btnSignIn.setForeground(new Color(56, 172, 236));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btnSignIn.setBackground(new Color(0, 99, 65));
				btnSignIn.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSignIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				btnSignIn.setBackground(new Color(255, 255, 255));
				btnSignIn.setForeground(Color.BLACK);
			}
		});
// Sign in data checking
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtUserName.getText().length() <= 0) {
					lblSignInMesg.setText("Username required");
					txtUserName.grabFocus();

				} else if (txtPassword.getPassword().length <= 0) {
					lblSignInMesg.setText("Password required");
					txtPassword.grabFocus();

				} else {

					if (isAccountCorrect(txtUserName.getText(), txtPassword.getPassword(), accounts)) {
						MemberMainMenu mainMenu = new MemberMainMenu();
						JOptionPane.showMessageDialog(null, "Login successfully");
						dispose();
						mainMenu.setUser(txtUserName.getText(), txtPassword.getPassword());
						mainMenu.setVisible(true);

					} else {
						lblSignInMesg.setText("Wrong username or password!");
					}
				}

			}
		});

// Cancel button 
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setBorder(BorderFactory.createLineBorder(new Color(255, 69, 0)));
				btnCancel.setBackground(Color.WHITE);
				btnCancel.setForeground(new Color(248, 24, 148));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btnCancel.setBackground(new Color(255, 191, 0));
				btnCancel.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				btnCancel.setBackground(new Color(255, 255, 255));
				btnCancel.setForeground(Color.BLACK);
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSignInMesg.setText("");
				txtUserName.setText("");
				txtPassword.setText("");
			}
		});

		lblShowEyeIcon.setVisible(false);
		lblShowEyeIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblBlindEyeIcon.setVisible(true);
				lblShowEyeIcon.setVisible(false);
				txtPassword.setEchoChar('*');
			}
		});
		lblBlindEyeIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblBlindEyeIcon.setVisible(false);
				lblShowEyeIcon.setVisible(true);
				txtPassword.setEchoChar((char) 0);
			}
		});
// Exit button		
		JLabel lblExitIcon = new JLabel("");
		lblExitIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Exit application",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblExitIcon.setBounds(433, 13, 35, 31);
		lblExitIcon.setIcon(new ImageIcon(exitImg));
		contentPane.add(lblExitIcon);
	}

	public boolean compareUserName(String inputName, User[] accounts) {
		for (User user : accounts) {

			if (user.getUserName().equals(inputName)) {
				return true;
			}
		}
		return false;
	}

	public boolean compareUserPassword(char[] inputPassword, User[] accounts) {

		for (User user : accounts) {
			if (Arrays.equals(inputPassword, user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean isAccountCorrect(String inputName, char[] inputPassword, User[] accounts) {
		if (compareUserName(inputName, accounts) && compareUserPassword(inputPassword, accounts)) {
			return true;
		}
		return false;
	}
}
