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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class ShopMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userLoginIdTF;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField phonenumberTextField;
	private JLabel userLoginIdMessageLabel;
	private JLabel userLoginpasswordMessageLabel;
	private JLabel userJoinIdMsgLB;

	private User loginUser = null;

	private UserService userService;
	private JTabbedPane middlePane;
	private JTabbedPane usertabbedPane;
	private JPasswordField userLoginpasswordTF;
	private JTextField userJoinIdTF;
	private JTextField userJoinPasswordTF;
	private JTextField userJoinNameTF;
	private JTextField userJoinAddressTF;
	private JTextField userJoinPhonenumberTF;

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
		setBounds(100, 100, 581, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JComboBox NorthPanel = new JComboBox();
		contentPane.add(NorthPanel, BorderLayout.NORTH);

		middlePane = new JTabbedPane(JTabbedPane.TOP);
		middlePane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(middlePane, BorderLayout.CENTER);

		JPanel Popular = new JPanel();
		middlePane.addTab("Popularshoes", null, Popular, null);
		Popular.setLayout(new BorderLayout(0, 0));
		
		JScrollPane productPopularshoesContentPanelScrollPane = new JScrollPane();
		Popular.add(productPopularshoesContentPanelScrollPane, BorderLayout.CENTER);
		
		JPanel productPopularshoesCententPanel = new JPanel();
		productPopularshoesCententPanel.setOpaque(false);
		productPopularshoesCententPanel.setDoubleBuffered(false);
		productPopularshoesCententPanel.setBorder(null);
		FlowLayout flowLayout = (FlowLayout) productPopularshoesCententPanel.getLayout();
		flowLayout.setVgap(7);
		flowLayout.setHgap(7);
		flowLayout.setAlignment(FlowLayout.LEFT);
		productPopularshoesContentPanelScrollPane.setViewportView(productPopularshoesCententPanel);
		
		
		/********popular shoes 시작 ***************/
		JPanel productPanel = new JPanel();
		productPanel.setSize(new Dimension(120, 120));
		productPanel.setPreferredSize(new Dimension(170, 210));
		productPanel.setMaximumSize(new Dimension(200, 200));
		productPanel.setMinimumSize(new Dimension(150, 150));
		productPanel.setBounds(new Rectangle(0, 0, 120, 120));
		productPopularshoesCententPanel.add(productPanel);
		productPanel.setLayout(null);
		
		JLabel productImageLabel = new JLabel("");
		productImageLabel.setBounds(0, 0, 170, 112);
		productPanel.add(productImageLabel);
		
		productImageLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/shoes.png")));
		
		JLabel productDestLabel = new JLabel("<html>\r\n\t<font size='2'>\r\n\t\t\r\n\t\t\t이름 : New Balance 2002R Grey<br>\r\n\t\t\t브랜드 : New Balance<br>\r\n\t\t\t가격 : 135,000원 <br>\r\n\t\t       설명 : MR2002의 라이프스타일 버전\r\n </font></html>");
		productDestLabel.setFont(new Font("굴림", Font.PLAIN, 10));
		productDestLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		productDestLabel.setVerticalAlignment(SwingConstants.TOP);
		productDestLabel.setHorizontalAlignment(SwingConstants.LEFT);
		productDestLabel.setBounds(0, 102, 124, 108);
		productPanel.add(productDestLabel);
		
		JComboBox cartQtyComboBox = new JComboBox();
		cartQtyComboBox.setBorder(null);
		cartQtyComboBox.setMaximumRowCount(10);
		cartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartQtyComboBox.setAutoscrolls(true);
		cartQtyComboBox.setOpaque(false);
		cartQtyComboBox.setBounds(126, 115, 32, 23);
		productPanel.add(cartQtyComboBox);
		
		productPopularshoesCententPanel.add(productPanel);
		
		JButton cartAddButton = new JButton("");
		cartAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>카트담기...");
				
				
			}
		});
		cartAddButton.setBorder(null);
		cartAddButton.setBounds(136, 187, 34, 23);
		productPanel.add(cartAddButton);
		cartAddButton.setOpaque(false);
		cartAddButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));

		JPanel Sneakers = new JPanel();
		middlePane.addTab("Sneakers", null, Sneakers, null);

		JPanel Shoes = new JPanel();
		middlePane.addTab("Shoes", null, Shoes, null);

		JPanel Walkers = new JPanel();
		middlePane.addTab("Walkers", null, Walkers, null);

		JPanel Cart = new JPanel();
		middlePane.addTab("Cart", null, Cart, null);
		Cart.setLayout(new BorderLayout(0, 0));
		
		JScrollPane cartContentPanelScrollPane = new JScrollPane();
		Cart.add(cartContentPanelScrollPane, BorderLayout.CENTER);
		
		JPanel cartContentPanel = new JPanel();
		cartContentPanel.setPreferredSize(new Dimension(390, 780));
		cartContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		cartContentPanelScrollPane.setViewportView(cartContentPanel);
		/*********cart************/
		JPanel cartItemPanel = new JPanel();
		cartItemPanel.setPreferredSize(new Dimension(350, 72));
		cartItemPanel.setBorder(null);
		cartContentPanel.add(cartItemPanel);
		cartItemPanel.setLayout(null);
		
		JLabel cartItemImageLabel = new JLabel("2002R Grey");
		cartItemImageLabel.setFont(new Font("굴림", Font.PLAIN, 9));
		cartItemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		cartItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		cartItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cartItemImageLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/shoes1.png")));
		cartItemImageLabel.setBounds(0, 0, 72, 72);
		cartItemPanel.add(cartItemImageLabel);
		
		JLabel cartItemDescLabel = new JLabel("135,000");
		cartItemDescLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cartItemDescLabel.setBounds(81, 29, 57, 15);
		cartItemPanel.add(cartItemDescLabel);
		
		JLabel cartItemTotPrice = new JLabel("135,000");
		cartItemTotPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		cartItemTotPrice.setBounds(213, 29, 57, 15);
		cartItemPanel.add(cartItemTotPrice);
		
		JComboBox cartItemQtyComboBox = new JComboBox();
		cartItemQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartItemQtyComboBox.setBounds(169, 25, 32, 23);
		cartItemPanel.add(cartItemQtyComboBox);
		
		JButton cartItemDeleteButton = new JButton("");
		cartItemDeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartItemDeleteButton.setBounds(282, 25, 56, 23);
		cartItemDeleteButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart_item_delete30.png")));
		cartItemPanel.add(cartItemDeleteButton);
		
		JLabel lblNewLabel = new JLabel("");
		cartContentPanel.add(lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(350, 15));
		
		JPanel cartEmptyItemPanel = new JPanel();
		cartEmptyItemPanel.setBorder(null);
		cartEmptyItemPanel.setPreferredSize(new Dimension(350, 72));
		cartContentPanel.add(cartEmptyItemPanel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setPreferredSize(new Dimension(350, 72));
		cartEmptyItemPanel.add(lblNewLabel_1);

		JPanel userPanel = new JPanel();
		middlePane.addTab("User", null, userPanel, null);
		userPanel.setLayout(new BorderLayout(0, 0));

		usertabbedPane = new JTabbedPane(JTabbedPane.TOP);
		usertabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int usertabbedPaneSelectedIndex = usertabbedPane.getSelectedIndex();
				switch (usertabbedPaneSelectedIndex) {
				case 0:

					break;

				case 1:
					idTextField.setText(loginUser.getUserId());
					nameTextField.setText(loginUser.getName());
					addressTextField.setText(loginUser.getAddress());
					phonenumberTextField.setText(loginUser.getPhonenumber());	

					break;

				case 2:
					
					
				
					break;
				
				}

			}
		});
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
		userLoginIdTF.setText("tksgo65");
		userLoginIdTF.setBounds(154, 97, 176, 21);
		userLoginPanel.add(userLoginIdTF);
		userLoginIdTF.setColumns(10);
												
		JButton userLoginLoginBtn = new JButton("로그인");
		userLoginLoginBtn.addActionListener(new ActionListener() {

		private User loginUser;

		public void actionPerformed(ActionEvent e) {

		String userid = userLoginIdTF.getText();
		String password = userLoginpasswordTF.getText();
		if (userid.equals("")) {

		userLoginIdMessageLabel.setText("아이디를 입력하세요.");
		userLoginIdTF.requestFocus();
	    return;

		}
	if (password.equals("")) {
	userLoginpasswordMessageLabel.setText("패스워드를 입력하세요.");
	userLoginpasswordTF.requestFocus();
	return;

		}

	try {
			int result = userService.login(userid, password);
			if (result == 1) {

			User loginUser = userService.findUser(userid);
			loginProcess(loginUser);

			} else if (result == 0) {

			userLoginIdMessageLabel.setText("아이디또는 비밀번호가 일치하지 않습니다.");
			userLoginIdTF.requestFocus();
			userLoginIdTF.setSelectionStart(0);
			userLoginIdTF.setSelectionEnd(userid.length());

			}

			} catch (Exception ex) {
			ex.printStackTrace();

	}

	}

															

		});
		userLoginLoginBtn.setBounds(100, 225, 97, 23);
		userLoginPanel.add(userLoginLoginBtn);
														
		userLoginIdMessageLabel = new JLabel("");
		userLoginIdMessageLabel.setBounds(154, 128, 245, 15);
		userLoginPanel.add(userLoginIdMessageLabel);
																
		userLoginpasswordMessageLabel = new JLabel("");
		userLoginpasswordMessageLabel.setBounds(154, 180, 265, 15);
		
		userLoginPanel.add(userLoginpasswordMessageLabel);
																		
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
																								
		userLoginpasswordTF = new JPasswordField();
		userLoginpasswordTF.setText("1111");
		userLoginpasswordTF.setBounds(154, 149, 176, 21);
		userLoginPanel.add(userLoginpasswordTF);

		JPanel userInfoPanel = new JPanel();
		usertabbedPane.addTab("회원정보", null, userInfoPanel, null);
		userInfoPanel.setLayout(null);
		
		

		JLabel userInfoLabel = new JLabel("회원정보");
		userInfoLabel.setBounds(159, 74, 57, 15);
		userInfoPanel.add(userInfoLabel);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(84, 137, 57, 15);
		userInfoPanel.add(idLabel);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(84, 193, 57, 15);
		userInfoPanel.add(nameLabel);

		JLabel addressLabel = new JLabel("주소");
		addressLabel.setBounds(84, 246, 57, 15);
		userInfoPanel.add(addressLabel);

		idTextField = new JTextField();
		idTextField.setBounds(190, 134, 116, 21);
		userInfoPanel.add(idTextField);
		idTextField.setColumns(10);
		idTextField.setEnabled(true);
		idTextField.setEditable(true);
		

		nameTextField = new JTextField();
		nameTextField.setBounds(190, 190, 116, 21);
		userInfoPanel.add(nameTextField);
		nameTextField.setColumns(10);

		addressTextField = new JTextField();
		addressTextField.setBounds(190, 243, 116, 21);
		userInfoPanel.add(addressTextField);
		addressTextField.setColumns(10);

		JLabel phonenumberLabel = new JLabel("핸드폰번호");
		phonenumberLabel.setBounds(84, 299, 74, 15);
		userInfoPanel.add(phonenumberLabel);

		phonenumberTextField = new JTextField();
		phonenumberTextField.setBounds(190, 296, 116, 21);
		userInfoPanel.add(phonenumberTextField);
		phonenumberTextField.setColumns(10);

		JButton logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logoutProcess(loginUser);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		usertabbedPane.setEnabledAt(1, false);
		
		
			
		
		

		logoutButton.setBounds(136, 394, 97, 23);
		userInfoPanel.add(logoutButton);

		JPanel Order = new JPanel();
		middlePane.addTab("Order", null, Order, null);

		
		
		JPanel userJoinPanel = new JPanel();
		userJoinPanel.setLayout(null);
		usertabbedPane.addTab("회원가입", null, userJoinPanel, null);
		
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
		userJoinIdTF.setColumns(10);
		userJoinIdTF.setBounds(143, 100, 192, 21);
		userJoinPanel.add(userJoinIdTF);
		
		userJoinPasswordTF = new JTextField();
		userJoinPasswordTF.setColumns(10);
		userJoinPasswordTF.setBounds(143, 154, 192, 21);
		userJoinPanel.add(userJoinPasswordTF);
		
		userJoinNameTF = new JTextField();
		userJoinNameTF.setColumns(10);
		userJoinNameTF.setBounds(143, 207, 192, 21);
		userJoinPanel.add(userJoinNameTF);
		
		userJoinAddressTF = new JTextField();
		userJoinAddressTF.setColumns(10);
		userJoinAddressTF.setBounds(143, 265, 192, 21);
		userJoinPanel.add(userJoinAddressTF);
		
		userJoinPhonenumberTF = new JTextField();
		userJoinPhonenumberTF.setColumns(10);
		userJoinPhonenumberTF.setBounds(144, 315, 191, 21);
		userJoinPanel.add(userJoinPhonenumberTF);
		
		JButton userJoinBtn = new JButton("가입");
		userJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String userId = userJoinIdTF.getText();
					boolean isDuplicate = userService.isDuplicateId(userId);
					if (isDuplicate) {
						userJoinIdTF.setSelectionStart(0);
						userJoinIdTF.setSelectionEnd(userId.length());
						userJoinIdTF.requestFocus();
						userJoinIdMsgLB.setText("아이디가 사용중입니다.");
						return;
					}
					String password = userJoinPasswordTF.getText();
					String name = userJoinNameTF.getText();
					String address = userJoinAddressTF.getText();
					String phonenumber=userJoinPhonenumberTF.getText();
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
		
		JLabel userJoinIdMsgLB_1 = new JLabel("");
		userJoinIdMsgLB_1.setBounds(143, 131, 192, 15);
		userJoinPanel.add(userJoinIdMsgLB_1);

		/************* Service 객체맴버변수초기화 ***************/

		try {
			userService = new UserService();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}
	
	

	public void loginProcess(User loginUser) throws Exception {
		
		
		this.loginUser = loginUser;
		setTitle(loginUser.getName()+"님 로그인");
		
		
		middlePane.setSelectedIndex(0);
		
		usertabbedPane.setEnabledAt(1, true);
		
		usertabbedPane.setEnabledAt(0, false);
		
		usertabbedPane.setSelectedIndex(1);
		
		
		
	}
public void logoutProcess(User logoutUser) throws Exception{
		
		this.loginUser = null;
		setTitle("");
		
		userLoginIdMessageLabel.setText("");
		userLoginpasswordMessageLabel.setText("");
		
		idTextField.setText("");
		nameTextField.setText("");
		addressTextField.setText("");
		phonenumberTextField.setText("");
		
		usertabbedPane.setSelectedIndex(0);
		
		
		
		usertabbedPane.setEnabledAt(1, false);
		
		//로그아웃 했을때 로그인 창 활성화
		usertabbedPane.setEnabledAt(0, true);
		
		
		
		
	}
}
