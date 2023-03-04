package infoSystem;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class AdminPanelBtnMouseAdapter extends MouseAdapter {

	JLabel labelBtn;

	public AdminPanelBtnMouseAdapter(JLabel labelBtn) {
		this.labelBtn = labelBtn;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		labelBtn.setBackground(Color.BLACK);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		labelBtn.setBackground(new Color(248, 248, 255));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		labelBtn.setBackground(new Color(0, 82, 126));

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		labelBtn.setBackground(new Color(248, 248, 255));

	}
}
