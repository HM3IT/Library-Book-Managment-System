package infoSystem;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageSource {
	private Image mainLogoImg;
	private Image homeLogoImg;
	private Image bookSearchLogoImg;
	private Image settingLogoImg;
	private Image singOutLogoImg;
	private Image exitLogoImg;
	private Image exitLogoHoverImg;
	private Image bookManageImg;
	private Image memberManageImg;
	private Image memberLoginLogo;

	ImageSource() {
		mainLogoImg = new ImageIcon(this.getClass().getResource("../images/techUniLogo.png")).getImage()
				.getScaledInstance(140, 90, Image.SCALE_SMOOTH);
		homeLogoImg = new ImageIcon(this.getClass().getResource("../images/homeIcon.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		bookSearchLogoImg = new ImageIcon(this.getClass().getResource("../images/bookSearch.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		settingLogoImg = new ImageIcon(this.getClass().getResource("../images/userSettingIcon.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		singOutLogoImg = new ImageIcon(this.getClass().getResource("../images/signOut.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		exitLogoImg = new ImageIcon(this.getClass().getResource("../images/closeRedBtn.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		exitLogoHoverImg = new ImageIcon(this.getClass().getResource("../images/closeBtn.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		bookManageImg = new ImageIcon(this.getClass().getResource("../images/bookManage.png")).getImage()
				.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
		memberManageImg = new ImageIcon(this.getClass().getResource("../images/memberManage.png")).getImage()
				.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
		memberLoginLogo = new ImageIcon(this.getClass().getResource("../images/adminLoginLogo.png")).getImage()
				.getScaledInstance(125, 125, Image.SCALE_SMOOTH);

	}

	public Image getMainLogoImg() {
		return mainLogoImg;
	}

	public Image getHomeLogoImg() {
		return homeLogoImg;
	}

	public Image getBookSearchLogoImg() {
		return bookSearchLogoImg;
	}

	public Image getSettingLogoImg() {
		return settingLogoImg;
	}

	public Image getSingOutLogoImg() {
		return singOutLogoImg;
	}

	public Image getExitLogoImg() {
		return exitLogoImg;
	}

	public Image getExitLogoHoverImg() {
		return exitLogoHoverImg;
	}

	public Image getBookManageImg() {
		return bookManageImg;
	}

	public Image getMemberManageImg() {
		return memberManageImg;
	}

	public Image getMemberLoginLogo() {
		return memberLoginLogo;
	}
}
