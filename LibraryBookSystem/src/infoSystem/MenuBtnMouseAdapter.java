package infoSystem;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBtnMouseAdapter extends MouseAdapter {
	JPanel panelBtn;
	JLabel lblBtn;

	public MenuBtnMouseAdapter(JPanel panelBtn, JLabel lblBtn) {
		this.panelBtn = panelBtn;
		this.lblBtn = lblBtn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		panelBtn.setBackground(new Color(0, 82, 126));
		lblBtn.setForeground(Color.WHITE);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		panelBtn.setBackground(Color.BLACK);
		lblBtn.setForeground(Color.WHITE);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		panelBtn.setBackground(Color.WHITE);
		lblBtn.setForeground(Color.BLACK);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panelBtn.setBackground(new Color(0, 82, 126));
		lblBtn.setForeground(Color.WHITE);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		panelBtn.setBackground(Color.WHITE);
		lblBtn.setForeground(Color.BLACK);
	}
}
