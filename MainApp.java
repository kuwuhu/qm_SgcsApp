package SgSuperStore.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainApp {
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainApp() {
		initialize();
	}

	public void judge() {

	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(600, 400);
		GUITools.center(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Label label_2 = new Label("苏果超市管理系统");
		label_2.setBounds(250, 50, 100, 40);
		label_2.setBackground(Color.GRAY);
		frame.getContentPane().add(label_2);
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(262, 200, 75, 25);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			int i = 3;

			public void actionPerformed(ActionEvent arg0) {
				String usr = textField.getText();
				String pwd = passwordField.getText();
				while (i != 0) {
					i--;
					if (usr.equals("") & pwd.equals("")) {
						JOptionPane.showMessageDialog(null, "登陆成功！苏果超市管理员~");
						new MainFrameController().setVisible(true);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "账户或密码错误，你还有" + (i) + "次机会");
						break;
					}
				}

				if (i == 0) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		Label label = new Label("账号");
		label.setBounds(225, 110, 34, 23);
		Label label_1 = new Label("密码");
		label_1.setBounds(225, 160, 34, 23);
		
		textField = new JTextField();
		textField.setBounds(255, 110, 97, 21);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(255, 160, 97, 21);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(label);
		frame.getContentPane().add(label_1);

	}

}
