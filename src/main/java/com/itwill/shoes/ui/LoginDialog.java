package com.itwill.shoes.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.shoes.user.User;
import com.itwill.shoes.user.UserService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField userIdTextField;
	private JPasswordField userPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setBounds(100, 100, 391, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel idLabel = new JLabel("아이디");
			idLabel.setBounds(55, 62, 57, 15);
			contentPanel.add(idLabel);
		}
		{
			JLabel passwordLabel = new JLabel("패스워드");
			passwordLabel.setBounds(55, 106, 57, 15);
			contentPanel.add(passwordLabel);
		}
		{
			userIdTextField = new JTextField();
			userIdTextField.setToolTipText("아이디");
			userIdTextField.setBounds(136, 59, 187, 21);
			contentPanel.add(userIdTextField);
			userIdTextField.setColumns(10);
		}
		
		userPasswordField = new JPasswordField();
		userPasswordField.setToolTipText("패스워드");
		userPasswordField.setBounds(136, 103, 187, 21);
		contentPanel.add(userPasswordField);
		
		JLabel loginMessageLabel = new JLabel("");
		loginMessageLabel.setBounds(136, 153, 187, 15);
		contentPanel.add(loginMessageLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton loginButton = new JButton("로그인");
				loginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String userid = userIdTextField.getText();
						String password=userPasswordField.getText();
						if(userid.equals("")) {
							loginMessageLabel.setText("아이디를 입력하세요.");
							userIdTextField.requestFocus();
							return;
						}
						try {
							int result =UserService.login(userid, password);
							if(result==1) {
								User loginUser = UserService.findUser(userid);
								ShopMainFrame.loginProcess(loginUser);
								dispose();
								
							}else if(result==0) {
								loginMessageLabel.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
								userIdTextField.requestFocus();
								userIdTextField.setSelectionStart(0);
								userIdTextField.setSelectionEnd(userid.length());
							}
						}catch (Exception ex) {
							ex.printStackTrace();
						}
						
					}
				});
				loginButton.setActionCommand("OK");
				buttonPane.add(loginButton);
				getRootPane().setDefaultButton(loginButton);
			}
			{
				JButton loginCancelButton = new JButton("취소");
				loginCancelButton.setActionCommand("Cancel");
				buttonPane.add(loginCancelButton);
			}
			
			JButton userJoinButton = new JButton("회원가입");
			buttonPane.add(userJoinButton);
		}
		
	
	
	     userService=new UserService();
}
	
	
}
