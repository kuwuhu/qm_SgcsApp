package SgSuperStore.app;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public abstract class AbstractMainFrame extends JFrame {
	private JLabel titleLabel = new JLabel(new ImageIcon("title.png"));
	public JButton btn = new JButton("����ϵͳ");

	public AbstractMainFrame() {
		this.init();
		this.addComponent();
		this.addListener();
	}

	public void init() {
		this.setTitle("�չ����л�ӭ����");
		this.setSize(600, 400);
		GUITools.center(this);
		GUITools.setTitleImage(this, "title.png");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addComponent() {
		this.add(this.titleLabel, BorderLayout.CENTER);
		this.add(this.btn,BorderLayout.EAST);
	}

	public void addListener() {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAdminDialog();
			}
		});
	}

	public abstract void showAdminDialog();
}
