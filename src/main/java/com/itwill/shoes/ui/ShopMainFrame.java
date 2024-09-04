package com.itwill.shoes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.shoes.user.User;
import com.itwill.shoes.user.UserService;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

public class ShopMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userLoginIdTF;
	private JTextField UserLoginPasswordTF;
	private JTextField userJoinPasswordTF;
	private JTextField userJoinNameTF;
	private JTextField userJoinAddressTF;
	private JTextField userJoinPhonenumberTF;
	private JTextField userJoinIdTF;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField phonenumberTextField;
	private JLabel userLoginIdMessageLabel;
	private JLabel loginPasswordMessageLabel;
	private JLabel userJoinIdMsgLB;

	private User loginUser =null;
	
	private UserService userService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame frame = new ShopMainFrame();
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
	public ShopMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JComboBox NorthPanel = new JComboBox();
		contentPane.add(NorthPanel, BorderLayout.NORTH);
		
		JTabbedPane middlePane = new JTabbedPane(JTabbedPane.TOP);
		middlePane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(middlePane, BorderLayout.CENTER);
		
		JPanel Popular = new JPanel();
		middlePane.addTab("Popularshoes", null, Popular, null);
		
		JPanel Sneakers = new JPanel();
		middlePane.addTab("Sneakers", null, Sneakers, null);
		
		JPanel Shoes = new JPanel();
		middlePane.addTab("Shoes", null, Shoes, null);
		
		JPanel Walkers = new JPanel();
		middlePane.addTab("Walkers", null, Walkers, null);
		
		JPanel Cart = new JPanel();
		middlePane.addTab("Cart", null, Cart, null);
		
		JPanel userPanel = new JPanel();
		middlePane.addTab("User", null, userPanel, null);
		userPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane usertabbedPane = new JTabbedPane(JTabbedPane.TOP);
		usertabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		userPanel.add(usertabbedPane);
		
		JPanel userLoginPanel = new JPanel();
		usertabbedPane.addTab("로그인", null, userLoginPanel, null);
		userLoginPanel.setLayout(null);
		
		JLabel userLoginIdLabel = new JLabel("아이디");
		userLoginIdLabel.setBounds(68, 100, 57, 15);
		userLoginPanel.add(userLoginIdLabel);
		
		JLabel userLoginPasswordLabel = new JLabel("패스워드");
		userLoginPasswordLabel.setBounds(68, 152, 57, 15);
		userLoginPanel.add(userLoginPasswordLabel);
		
		userLoginIdTF = new JTextField();
		userLoginIdTF.setBounds(154, 97, 176, 21);
		userLoginPanel.add(userLoginIdTF);
		userLoginIdTF.setColumns(10);
		
		UserLoginPasswordTF = new JTextField();
		UserLoginPasswordTF.setBounds(154, 149, 176, 21);
		userLoginPanel.add(UserLoginPasswordTF);
		UserLoginPasswordTF.setColumns(10);
		
		JButton userLoginLoginBtn = new JButton("로그인");
		userLoginLoginBtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				String userid = userLoginIdTF.getText();
				String password = UserLoginPasswordTF.getText();
				if (userid.equals("")) {
					
					userLoginIdMessageLabel.setText("아이디를 입력하세요.");
					userLoginIdTF.requestFocus();
					return;
					
				}
				if (password.equals("")) {
					loginPasswordMessageLabel.setText("패스워드를 입력하세요.");
					UserLoginPasswordTF.requestFocus();
					return;
					
				}
				
				
				try {
					int result = userService.login(userid, password);
					if (result == 1) {
						
						User loginUser = userService.findUser(userid);
						loginProcess(loginUser);
				
					
				}else if (result ==0) {
					
					userLoginIdMessageLabel.setText("아이디또는 비밀번호가 일치하지 않습니다.");
					userLoginIdTF.requestFocus();
					userLoginIdTF.setSelectionStart(0);
					userLoginIdTF.setSelectionEnd(userid.length());
					
				}
					
				
				
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}
				
			}

			private void loginProcess(User loginUser) throws Exception{
			
				
				
			}
		
				
			
			
		});
		userLoginLoginBtn.setBounds(100, 225, 97, 23);
		userLoginPanel.add(userLoginLoginBtn);
		
		userLoginIdMessageLabel = new JLabel("");
		userLoginIdMessageLabel.setBounds(154, 128, 176, 15);
		userLoginPanel.add(userLoginIdMessageLabel);
		
		loginPasswordMessageLabel = new JLabel("");
		loginPasswordMessageLabel.setBounds(154, 180, 176, 15);
		userLoginPanel.add(loginPasswordMessageLabel);
		
		JLabel userinfoTitleLabel = new JLabel("로그인");
		userinfoTitleLabel.setBounds(170, 51, 57, 15);
		userLoginPanel.add(userinfoTitleLabel);
		
		JButton userLoginJoinBtn = new JButton("회원가입");
		userLoginJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usertabbedPane.setSelectedIndex(1);
			}
		});
		
		userLoginJoinBtn.setBounds(208, 225, 97, 23);
		userLoginPanel.add(userLoginJoinBtn);
		
		JPanel userJoinPanel = new JPanel();
		usertabbedPane.addTab("회원가입", null, userJoinPanel, null);
		userJoinPanel.setLayout(null);
		
		JLabel userJoinIdLabel = new JLabel("아이디");
		userJoinIdLabel.setBounds(34, 103, 57, 15);
		userJoinPanel.add(userJoinIdLabel);
		
		JLabel userJoinPasswordLabel = new JLabel("패스워드");
		userJoinPasswordLabel.setBounds(34, 157, 57, 15);
		userJoinPanel.add(userJoinPasswordLabel);
		
		JLabel userJoinNameLabel = new JLabel("이름");
		userJoinNameLabel.setBounds(34, 210, 57, 15);
		userJoinPanel.add(userJoinNameLabel);
		
		JLabel userJoinAddressLabel = new JLabel("주소");
		userJoinAddressLabel.setBounds(34, 268, 57, 15);
		userJoinPanel.add(userJoinAddressLabel);
		
		JLabel userJoinPhonenumberLabel = new JLabel("핸드폰 번호");
		userJoinPhonenumberLabel.setBounds(34, 318, 89, 15);
		userJoinPanel.add(userJoinPhonenumberLabel);
		
		userJoinIdTF = new JTextField();
		userJoinIdTF.setBounds(143, 100, 192, 21);
		userJoinPanel.add(userJoinIdTF);
		userJoinIdTF.setColumns(10);
		
		userJoinPasswordTF = new JTextField();
		userJoinPasswordTF.setBounds(143, 154, 192, 21);
		userJoinPanel.add(userJoinPasswordTF);
		userJoinPasswordTF.setColumns(10);
		
		userJoinNameTF = new JTextField();
		userJoinNameTF.setBounds(143, 207, 192, 21);
		userJoinPanel.add(userJoinNameTF);
		userJoinNameTF.setColumns(10);
		
		userJoinAddressTF = new JTextField();
		userJoinAddressTF.setBounds(143, 265, 192, 21);
		userJoinPanel.add(userJoinAddressTF);
		userJoinAddressTF.setColumns(10);
		
		userJoinPhonenumberTF = new JTextField();
		userJoinPhonenumberTF.setBounds(144, 315, 191, 21);
		userJoinPanel.add(userJoinPhonenumberTF);
		userJoinPhonenumberTF.setColumns(10);
		
		JButton userJoinBtn = new JButton("가입");
		userJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				String userId = userJoinIdTF.getText();
				boolean isDuplicate = userService.isDuplicateId(userId);
				if(isDuplicate) {
					userJoinIdTF.setSelectionStart(0);
					userJoinIdTF.setSelectionEnd(userId.length());
					userJoinIdTF.requestFocus();
					userJoinIdMsgLB.setText("아이디가 사용중입니다.");
					return;
				}
				String password = userJoinPasswordTF.getText();
				String name = userJoinNameTF.getText();
				String address = userJoinAddressTF.getText();
				String phonenumber = userJoinPhonenumberTF.getText();
				User user = new User(userId, password, name, address, phonenumber);
				userService.create(user);
				usertabbedPane.setSelectedIndex(0);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
					
					
				
				
			}
		});
		userJoinBtn.setBounds(77, 403, 97, 23);
		userJoinPanel.add(userJoinBtn);
		
		JButton userJoinCancleBtn = new JButton("취소");
		userJoinCancleBtn.setBounds(208, 403, 97, 23);
		userJoinPanel.add(userJoinCancleBtn);
		
		JLabel userJoinTitleLabel = new JLabel("회원가입");
		userJoinTitleLabel.setBounds(153, 62, 57, 15);
		userJoinPanel.add(userJoinTitleLabel);
		
		JLabel userJoinIdMsgLB = new JLabel("");
		userJoinIdMsgLB.setBounds(143, 131, 192, 15);
		userJoinPanel.add(userJoinIdMsgLB);
		
		JPanel userInfoPanel = new JPanel();
		usertabbedPane.addTab("회원정보", null, userInfoPanel, null);
		userInfoPanel.setLayout(null);
		
		JLabel userInfoLabel = new JLabel("회원정보");
		userInfoLabel.setBounds(159, 74, 57, 15);
		userInfoPanel.add(userInfoLabel);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(84, 162, 57, 15);
		userInfoPanel.add(idLabel);
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(84, 212, 57, 15);
		userInfoPanel.add(nameLabel);
		
		JLabel addressLabel = new JLabel("주소");
		addressLabel.setBounds(84, 268, 57, 15);
		userInfoPanel.add(addressLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(190, 159, 116, 21);
		userInfoPanel.add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(190, 209, 116, 21);
		userInfoPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(190, 265, 116, 21);
		userInfoPanel.add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel phonenumberLabel = new JLabel("핸드폰번호");
		phonenumberLabel.setBounds(84, 319, 74, 15);
		userInfoPanel.add(phonenumberLabel);
		
		phonenumberTextField = new JTextField();
		phonenumberTextField.setBounds(190, 316, 116, 21);
		userInfoPanel.add(phonenumberTextField);
		phonenumberTextField.setColumns(10);
		
		JButton logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		logoutButton.setBounds(136, 394, 97, 23);
		userInfoPanel.add(logoutButton);
		
		JPanel Order = new JPanel();
		middlePane.addTab("Order", null, Order, null);
		
		
	
		
		
		
		
		
		
		/************* Service 객체맴버변수초기화 ***************/
		
		try {
			userService = new UserService();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

	
		
		
	
}
