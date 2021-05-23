import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Calculator{

    private static final int WINDOW_WIDTH = 405;
    private static final int WINDOW_HEIGHT = 605;
    
	private JFrame window;
	private JLabel answer, equation, modeText;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMul, btnDiv,
					btnPoint, btnAns, btnRoot, btnSquared, btnPower, btnLog, btnLn, btnMod, btnPow, btnFactorial,
					btnASin, btnACos, btnATan, btnExp, btnSin, btnCos, btnTan, btnSinh, btnCosh, btnTanh, btnEqual, btnOParenthesis, btnCParenthesis, btnBack, btnAC;
	
    private JMenuBar menuBar;
    private JMenu menuFile, menuMode, menuTheme, menuHelp;
    private JMenuItem menuitemScientific, menuitemExit, menuitemLight, menuitemDark, menuitemAbout;
    public JPanel contentPane;
    private boolean isScientificMode = false;
    double result = 0;
    String input = "";
    
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Calculator window = new Calculator();
				window.window.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}

	public Calculator() {
		initialize();
	}

	@SuppressWarnings("serial")
	public void initialize() {
		ImageIcon image = new ImageIcon(getClass().getResource("/images/calc.png"));
		window = new JFrame();
		KeyListener l = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_0 :
				case KeyEvent.VK_NUMPAD0 : btn0.doClick();
				break;
				case KeyEvent.VK_1 :
				case KeyEvent. VK_NUMPAD1 : btn1.doClick();
				break;
				case KeyEvent.VK_2 :
				case KeyEvent.VK_NUMPAD2 : btn2.doClick();
				break;
				case KeyEvent.VK_3 :
				case KeyEvent.VK_NUMPAD3 : btn3.doClick();
				break;
				case KeyEvent.VK_4 :
				case KeyEvent.VK_NUMPAD4 : btn4.doClick();
				break;
				case KeyEvent.VK_5 :
				case KeyEvent.VK_NUMPAD5 : btn5.doClick();
				break;
				case KeyEvent.VK_6 :
				case KeyEvent.VK_NUMPAD6 : btn6.doClick();
				break;
				case KeyEvent.VK_7 :
				case KeyEvent.VK_NUMPAD7 : btn7.doClick();
				break;
				case KeyEvent.VK_8 :
				case KeyEvent.VK_NUMPAD8 : btn8.doClick();
				break;
				case KeyEvent.VK_9 :
				case KeyEvent.VK_NUMPAD9 : btn9.doClick();
				break;
				case KeyEvent.VK_PERIOD :
				case KeyEvent.VK_DECIMAL : btnPoint.doClick();
				break;
				case KeyEvent.VK_EQUALS :
				case KeyEvent.VK_ENTER : btnEqual.doClick();
				break;
				case KeyEvent.VK_ADD : btnAdd.doClick();
				break;
				case KeyEvent.VK_MINUS :
				case KeyEvent.VK_SUBTRACT : btnSub.doClick();
				break;
				case KeyEvent.VK_MULTIPLY : btnMul.doClick();
				break;
				case KeyEvent.VK_DIVIDE :
				case KeyEvent.VK_SLASH : btnDiv.doClick();
				break;
				case KeyEvent.VK_BACK_SPACE : btnBack.doClick();
				break;
				case KeyEvent.VK_C : btnAC.doClick();
				break;
 
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};

//		JPanel contentPane = new JPanel() {  
//			public void paintComponent(Graphics g) {  
//				Image img = Toolkit.getDefaultToolkit().getImage(Calculator.class.getResource("images/LtoD.png"));  
//				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
//				}  
//			};
//		window.setContentPane(contentPane);
		
		Font menuFont = new Font("century gothic", Font.BOLD, 12);
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuFile.setFont(menuFont);
		menuBar.add(menuFile);
		
		menuitemExit = new JMenuItem("Exit");
		menuitemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 
				ActionEvent.CTRL_MASK));
		menuitemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		menuitemExit.setFont(menuFont);
		menuFile.add(menuitemExit);
		
		menuMode = new JMenu("Mode");
		menuMode.setFont(menuFont);
		menuBar.add(menuMode);
		
		menuitemScientific = new JMenuItem("Scientific");
		menuitemScientific.addActionListener(event -> onShowScientificMode());

		menuitemScientific.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 
				ActionEvent.CTRL_MASK));
		menuitemScientific.setFont(menuFont);
		menuMode.add(menuitemScientific);
		
		menuTheme = new JMenu("Theme");
		menuTheme.setFont(menuFont);
		menuBar.add(menuTheme);
		
		menuitemLight = new JMenuItem("Light");
		menuitemLight.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 
				ActionEvent.CTRL_MASK));
		menuitemLight.addActionListener(event -> onLightMode());
		menuitemLight.setFont(menuFont);
		menuTheme.add(menuitemLight);
		
		menuitemDark = new JMenuItem("Dark");
		menuitemDark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, 
				ActionEvent.CTRL_MASK));
		menuitemDark.addActionListener(event -> onDarkMode());
		menuitemDark.setFont(menuFont);
		menuTheme.add(menuitemDark);
		
		menuHelp = new JMenu("Help");
		menuHelp.setFont(menuFont);
		menuBar.add(menuHelp);

		menuitemAbout = new JMenuItem("About Calculator");
		menuitemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 
				ActionEvent.CTRL_MASK));
		menuitemAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
			JOptionPane.showMessageDialog(null,  "Calculator v1.0 by James Carlo M.");
			}
		});
		menuitemAbout.setFont(menuFont);
		menuHelp.add(menuitemAbout);
        
        Font largeFont = new Font("century gothic", Font.PLAIN, 27);
        Font medFont = new Font("century gothic", Font.PLAIN, 16);
        Font smallFont = new Font("century gothic", Font.PLAIN, 13);
        
        window.setSize(513, 605);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Calculator");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
		window.addKeyListener(l);
		window.setIconImage(image.getImage());
		window.setLocationRelativeTo(null);
		
        modeText = new JLabel("mT");
        modeText.setText("Normal");
        modeText.setFont(new Font("century gothic", Font.BOLD, 18));
        modeText.setBounds(20, 12, 110, 20);
        modeText.setForeground(new Color(0, 0, 0));
        window.getContentPane().add(modeText);
        
		Border border = LineBorder.createGrayLineBorder();
		window.getContentPane().setLayout(null);
		
		equation = new javax.swing.JLabel("0");
		equation.setBounds(10, 15, 260, 14);
		equation.setOpaque(true);
		equation.setBackground(Color.WHITE);
		equation.setForeground(Color.BLACK);
		equation.setFont(new Font("century gothic", Font.BOLD, 28));
		equation.setHorizontalAlignment(SwingConstants.LEFT);
		
		answer = new javax.swing.JLabel("");
		answer.setBounds(20, 40, 350, 70);
		answer.setHorizontalAlignment(SwingConstants.RIGHT);
		answer.setVerticalAlignment(SwingConstants.BOTTOM);
		answer.setOpaque(true);
		answer.setBackground(Color.WHITE);
		answer.setForeground(Color.BLACK);
		answer.setBorder(border);
		answer.setLayout(new BorderLayout());
		answer.setFont(new Font("century gothic", Font.BOLD, 33));
		answer.add(equation, BorderLayout.PAGE_START);
		window.getContentPane().add(answer);

		btn1 = new JButton("1");
		btn1.setBounds(20, 375, 80, 70);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("1");
			}
		});
		btn1.setFont(largeFont);
		btn1.setFocusable(false);
		btn1.setContentAreaFilled(true);
		window.getContentPane().add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(110, 375, 80, 70);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("2");
			}
		});
		btn2.setFont(largeFont);
		btn2.setFocusable(false);
		btn2.setContentAreaFilled(true);
		window.getContentPane().add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(200, 375, 80, 70);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("3");
			}
		});
		btn3.setFont(largeFont);
		btn3.setFocusable(false);
		btn3.setContentAreaFilled(true);
		window.getContentPane().add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(20, 295, 80, 70);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("4");
			}
		});
		btn4.setFont(largeFont);
		btn4.setFocusable(false);
		btn4.setContentAreaFilled(true);
		window.getContentPane().add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(110, 295, 80, 70);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("5");
			}
		});
		btn5.setFont(largeFont);
		btn5.setFocusable(false);
		btn5.setContentAreaFilled(true);
		window.getContentPane().add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBounds(200, 295, 80, 70);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("6");
			}
		});
		btn6.setFont(largeFont);
		btn6.setFocusable(false);
		btn6.setContentAreaFilled(true);
		window.getContentPane().add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBounds(20, 215, 80, 70);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("7");
			}
		});
		btn7.setFont(largeFont);
		btn7.setFocusable(false);
		btn7.setContentAreaFilled(true);
		window.getContentPane().add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBounds(110, 215, 80, 70);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("8");
			}
		});
		btn8.setFont(largeFont);
		btn8.setFocusable(false);
		btn8.setContentAreaFilled(true);
		window.getContentPane().add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBounds(200, 215, 80, 70);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("9");
			}
		});
		btn9.setFont(largeFont);
		btn9.setFocusable(false);
		btn9.setContentAreaFilled(true);
		window.getContentPane().add(btn9);
		
		btn0 = new JButton("0");
		btn0.setBounds(110, 455, 80, 70);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("0");
			}
		});
		btn0.setFont(largeFont);
		btn0.setFocusable(false);
		btn0.setContentAreaFilled(true);
		window.getContentPane().add(btn0);
		
		btnAdd = new JButton("+");
		btnAdd.setBounds(290, 375, 80, 70);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("+");
			}
		});
		btnAdd.setFont(largeFont);
		btnAdd.setFocusable(false);
		btnAdd.setContentAreaFilled(true);
		window.getContentPane().add(btnAdd);
		
		btnSub = new JButton("-");
		btnSub.setBounds(290, 295, 80, 70);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("-");
			}
		});
		btnSub.setFont(largeFont);
		btnSub.setFocusable(false);
		btnSub.setContentAreaFilled(true);
		window.getContentPane().add(btnSub);
		
		btnMul = new JButton("*");
		btnMul.setBounds(290, 215, 80, 70);
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("*");
			}
		});
		btnMul.setFont(largeFont);
		btnMul.setFocusable(false);
		btnMul.setContentAreaFilled(true);
		window.getContentPane().add(btnMul);
		
		btnDiv = new JButton("/");
		btnDiv.setBounds(290, 135, 80, 70);
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("/");
			}
		});
		btnDiv.setFont(largeFont);
		btnDiv.setFocusable(false);
		btnDiv.setContentAreaFilled(true);
		window.getContentPane().add(btnDiv);

		btnPoint = new JButton(".");
		btnPoint.setBounds(20, 455, 80, 70);
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input(".");
			}
		});
		btnPoint.setFont(largeFont);
		btnPoint.setFocusable(false);
		btnPoint.setContentAreaFilled(true);
		window.getContentPane().add(btnPoint);
		
		btnAns = new JButton("Ans");
		btnAns.setBounds(200, 135, 80, 70);
		btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input("Ans");
			}
		});
		btnAns.setFont(largeFont);
		btnAns.setFocusable(false);
		btnAns.setContentAreaFilled(true);
		window.getContentPane().add(btnAns);
		
		btnRoot = new JButton("sqrt"); //\u221A
		btnRoot.setBounds(470, 135, 80, 70);
		btnRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("sqrt");
			}
		});
		btnRoot.setVisible(false);
		btnRoot.setFont(largeFont);
		btnRoot.setFocusable(false);
		btnRoot.setContentAreaFilled(true);
		window.getContentPane().add(btnRoot);
		
		btnSquared = new JButton("^2");
		btnSquared.setBounds(560, 135, 80, 70);
		btnSquared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("^2");
			}
		});
		btnSquared.setVisible(false);
		btnSquared.setFont(largeFont);
		btnSquared.setFocusable(false);
		btnSquared.setContentAreaFilled(true);
		window.getContentPane().add(btnSquared);
		
		btnPower = new JButton("^");
		btnPower.setBounds(470, 215, 80, 70);
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("^");
			}
		});
		btnPower.setVisible(false);
		btnPower.setFont(largeFont);
		btnPower.setFocusable(false);
		btnPower.setContentAreaFilled(true);
		window.getContentPane().add(btnPower);
		
		btnLog = new JButton("log");
		btnLog.setBounds(650, 455, 80, 70);
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("log");
			}
		});
		btnLog.setVisible(false);
		btnLog.setFont(largeFont);
		btnLog.setFocusable(false);
		btnLog.setContentAreaFilled(true);
		window.getContentPane().add(btnLog);
		
		btnLn = new JButton("ln");
		btnLn.setBounds(650, 375, 80, 70);
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("ln");
			}
		});
		btnLn.setVisible(false);
		btnLn.setFont(largeFont);
		btnLn.setFocusable(false);
		btnLn.setContentAreaFilled(true);
		window.getContentPane().add(btnLn);
		
		btnMod = new JButton("%");
		btnMod.setBounds(380, 135, 80, 70);
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("%");
			}
		});
		btnMod.setVisible(false);
		btnMod.setFont(largeFont);
		btnMod.setFocusable(false);
		btnMod.setToolTipText("Do not use any mathematical operations. Ex: 100%20");
		btnMod.setContentAreaFilled(true);
		window.getContentPane().add(btnMod);
		
		btnPow = new JButton("10^");
		btnPow.setBounds(380, 215, 80, 70);
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("10^");
			}
		});
		btnPow.setVisible(false);
		btnPow.setFont(medFont);
		btnPow.setFocusable(false);
		btnPow.setContentAreaFilled(true);
		window.getContentPane().add(btnPow);
		
		btnASin = new JButton("arcsin");
		btnASin.setBounds(560, 295, 80, 70);
		btnASin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("arcsin");
			}
		});
		
		btnFactorial = new JButton("!");
		btnFactorial.setBounds(650, 295, 80, 70);
		btnFactorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("!");
			}
		});
		btnFactorial.setVisible(false);
		btnFactorial.setFont(largeFont);
		btnFactorial.setFocusable(false);
		btnFactorial.setContentAreaFilled(true);
		window.getContentPane().add(btnFactorial);
		
		btnASin.setVisible(false);
		btnASin.setFont(medFont);
		btnASin.setFocusable(false);
		btnASin.setContentAreaFilled(true);
		window.getContentPane().add(btnASin);
		
		btnACos = new JButton("arccos");
		btnACos.setBounds(560, 375, 80, 70);
		btnACos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("arccos");
			}
		});
		btnACos.setVisible(false);
		btnACos.setFont(smallFont);
		btnACos.setFocusable(false);
		btnACos.setContentAreaFilled(true);
		window.getContentPane().add(btnACos);
		
		btnATan = new JButton("arctan");
		btnATan.setBounds(560, 455, 80, 70);
		btnATan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("arctan");
			}
		});
		btnATan.setVisible(false);
		btnATan.setFont(smallFont);
		btnATan.setFocusable(false);
		btnATan.setContentAreaFilled(true);
		window.getContentPane().add(btnATan);
		
		btnExp = new JButton("e");
		btnExp.setBounds(560, 215, 80, 70);
		btnExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("e");
			}
		});
		btnExp.setVisible(false);
		btnExp.setFont(largeFont);
		btnExp.setFocusable(false);
		btnExp.setContentAreaFilled(true);
		window.getContentPane().add(btnExp);
		
		btnSin = new JButton("sin");
		btnSin.setBounds(380, 295, 80, 70);
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("sin");
			}
		});
		btnSin.setVisible(false);
		btnSin.setFont(largeFont);
		btnSin.setFocusable(false);
		btnSin.setContentAreaFilled(true);
		window.getContentPane().add(btnSin);
		
		btnCos = new JButton("cos");
		btnCos.setBounds(380, 375, 80, 70);
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("cos");
			}
		});
		btnCos.setVisible(false);
		btnCos.setFont(largeFont);
		btnCos.setFocusable(false);
		btnCos.setContentAreaFilled(true);
		window.getContentPane().add(btnCos);
		
		btnTan = new JButton("tan");
		btnTan.setBounds(380, 455, 80, 70);
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("tan");
			}
		});
		btnTan.setVisible(false);
		btnTan.setFont(largeFont);
		btnTan.setFocusable(false);
		btnTan.setContentAreaFilled(true);
		window.getContentPane().add(btnTan);
		
		btnSinh = new JButton("sinh");
		btnSinh.setBounds(470, 295, 80, 70);
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("sinh");
			}
		});
		btnSinh.setVisible(false);
		btnSinh.setFont(medFont);
		btnSinh.setFocusable(false);
		btnSinh.setContentAreaFilled(true);
		window.getContentPane().add(btnSinh);
		
		btnCosh = new JButton("cosh");
		btnCosh.setBounds(470, 375, 80, 70);
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("cosh");
			}
		});
		btnCosh.setVisible(false);
		btnCosh.setFont(medFont);
		btnCosh.setFocusable(false);
		btnCosh.setContentAreaFilled(true);
		window.getContentPane().add(btnCosh);
		
		btnTanh = new JButton("tanh");
		btnTanh.setBounds(470, 455, 80, 70);
		btnTanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("tanh");
			}
		});
		btnTanh.setVisible(false);
		btnTanh.setFont(medFont);
		btnTanh.setFocusable(false);
		btnTanh.setContentAreaFilled(true);
		window.getContentPane().add(btnTanh);
		
		btnOParenthesis = new JButton("(");
		btnOParenthesis.setBounds(650, 135, 80, 70);
		btnOParenthesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("(");
			}
		});
		btnOParenthesis.setVisible(false);
		btnOParenthesis.setFont(largeFont);
		btnOParenthesis.setFocusable(false);
		btnOParenthesis.setContentAreaFilled(true);
		window.getContentPane().add(btnOParenthesis);
		
		btnCParenthesis = new JButton(")");
		btnCParenthesis.setBounds(650, 215, 80, 70);
		btnCParenthesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input(")");
			}
		});
		btnCParenthesis.setVisible(false);
		btnCParenthesis.setFont(largeFont);
		btnCParenthesis.setFocusable(false);
		btnCParenthesis.setContentAreaFilled(true);
		window.getContentPane().add(btnCParenthesis);
		
		btnEqual = new JButton("=");
		btnEqual.setForeground(new Color(127, 255, 0));
		btnEqual.setBounds(200, 455, 170, 70);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("=");
			}
		});
		btnEqual.setFont(largeFont);
		btnEqual.setFocusable(false);
		btnEqual.setContentAreaFilled(true);
		window.getContentPane().add(btnEqual);
		
		btnBack = new JButton("C");
		btnBack.setBounds(110, 135, 80, 70);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("C");
			}
		});
		btnBack.setFont(largeFont);
		btnBack.setFocusable(false);
		btnBack.setToolTipText("DELETE - Press \"Backspace\" instead");
		btnBack.setContentAreaFilled(true);
		window.getContentPane().add(btnBack);
		
		btnAC = new JButton("AC");
		btnAC.setBounds(20, 135, 80, 70);
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input("AC");
			}
		});
		btnAC.setFont(largeFont);
		btnAC.setFocusable(false);
		btnAC.setToolTipText("ALL CLEAR - Press \"C\" instead");
		btnAC.setContentAreaFilled(true);
		window.getContentPane().add(btnAC);

		window.getContentPane().setBackground(new Color(240, 240, 240));

        btn1.setBackground(null);
        btn2.setBackground(null);
        btn3.setBackground(null);
        btn4.setBackground(null);
        btn5.setBackground(null);
        btn6.setBackground(null);
        btn7.setBackground(null);
        btn8.setBackground(null);
        btn9.setBackground(null);
        btn0.setBackground(null);
        btnPoint.setBackground(null);
        btnPoint.setForeground(null);

        btnAC.setBackground(null);
        btnBack.setBackground(null);
        btnDiv.setBackground(null);
        btnMul.setBackground(null);
        btnSub.setBackground(null);
        btnAdd.setBackground(null);
        btnAns.setBackground(null);
        btnEqual.setBackground(null);
        
        
        btnAC.setForeground(Color.BLACK);
        btnBack.setForeground(Color.BLACK);
        btnDiv.setForeground(Color.BLACK);
        btnMul.setForeground(Color.BLACK);
        btnSub.setForeground(Color.BLACK);
        btnAdd.setForeground(Color.BLACK);
        btnAns.setForeground(Color.BLACK);
        btnEqual.setForeground(Color.BLACK);
                
        btnRoot.setBackground(null);
        btnLog.setBackground(null);
        btnMod.setBackground(null);
        btnPower.setBackground(null);
        btnPow.setBackground(null);
        btnASin.setBackground(null);
        btnACos.setBackground(null);
        btnATan.setBackground(null);
        btnSinh.setBackground(null);
        btnCosh.setBackground(null);
        btnTanh.setBackground(null);
        btnSin.setBackground(null);
        btnCos.setBackground(null);
        btnTan.setBackground(null);
        btnSquared.setBackground(null);
        btnExp.setBackground(null);
        btnFactorial.setBackground(null);
        btnLn.setBackground(null);
        btnOParenthesis.setBackground(null);
        btnCParenthesis.setBackground(null);
        
        btnRoot.setForeground(Color.BLACK);
        btnLog.setForeground(Color.BLACK);
        btnMod.setForeground(Color.BLACK);
        btnPower.setForeground(Color.BLACK);
        btnPow.setForeground(Color.BLACK);
        btnASin.setForeground(Color.BLACK);
        btnACos.setForeground(Color.BLACK);
        btnATan.setForeground(Color.BLACK);
        btnSinh.setForeground(Color.BLACK);
        btnCosh.setForeground(Color.BLACK);
        btnTanh.setForeground(Color.BLACK);
        btnSin.setForeground(Color.BLACK);
        btnCos.setForeground(Color.BLACK);
        btnTan.setForeground(Color.BLACK);
        btnSquared.setForeground(Color.BLACK);
        btnExp.setForeground(Color.BLACK);
        btnFactorial.setForeground(Color.BLACK);
        btnLn.setForeground(Color.BLACK);
        btnOParenthesis.setForeground(Color.BLACK);
        btnCParenthesis.setForeground(Color.BLACK);
        
	}
	
	public void input(String s){
		if(s.equals("=")){
			if (!equation.getText().isEmpty()) {
				try {
                	result = Double.parseDouble(String.valueOf((double)Expression.evaluate(equation.getText())));
                	answer.setText(removeZeros(result));
                } catch (Exception exception) {
                    answer.setText(exception.getMessage());
                      }
                } else {
                	answer.setText("Syntax Error");
                }
            }
            
        else if(s.equals("C")) {
        	if(answer.getText().isEmpty())
        		equation.setText((equation.getText() == null || equation.getText().length() == 0) ? equation.getText() : equation.getText().substring(0, equation.getText().length() - 1));
        	else {
        		answer.setText("");
            	equation.setText("0");
        	}
        }
        
        else if(s.equals("AC")) {
        	answer.setText("");
        	equation.setText("0");
        }
        
        else if(s.equals("Ans")){
            equation.setText(removeZeros(result));
        }
   	
        else {
        	if (equation.getText().length() == 19) {
				Toolkit.getDefaultToolkit().beep();
				return;
			}
        	if (equation.getText().equals("0")) equation.setText("");
				equation.setText(equation.getText() + s);
        }
	}
	   
	private String removeZeros(Double n) {
		String in = String.valueOf(n);
		while (in.indexOf(".") != -1) {
			if (in.substring(in.length() - 1).equals("0") ||
					in.substring(in.length() - 1).equals("."))
				in = in.substring(0, in.length() - 1);
			else break;
		}
		return in;
	}
	
    public void onLightMode() {	
    	modeText.setForeground(new Color(0, 0, 0));
    	
		equation.setBackground(Color.WHITE);
		equation.setForeground(Color.BLACK);

		answer.setBackground(Color.WHITE);
		answer.setForeground(Color.BLACK);
    	
    	window.getContentPane().setBackground(new Color(240, 240, 240));

        btn1.setBackground(null);
        btn2.setBackground(null);
        btn3.setBackground(null);
        btn4.setBackground(null);
        btn5.setBackground(null);
        btn6.setBackground(null);
        btn7.setBackground(null);
        btn8.setBackground(null);
        btn9.setBackground(null);
        btn0.setBackground(null);
        btnPoint.setBackground(null);
        btnPoint.setForeground(null);

        btnAC.setBackground(null);
        btnBack.setBackground(null);
        btnDiv.setBackground(null);
        btnMul.setBackground(null);
        btnSub.setBackground(null);
        btnAdd.setBackground(null);
        btnAns.setBackground(null);
        btnEqual.setBackground(null);
        
        
        btnAC.setForeground(Color.BLACK);
        btnBack.setForeground(Color.BLACK);
        btnDiv.setForeground(Color.BLACK);
        btnMul.setForeground(Color.BLACK);
        btnSub.setForeground(Color.BLACK);
        btnAdd.setForeground(Color.BLACK);
        btnAns.setForeground(Color.BLACK);
        btnEqual.setForeground(Color.BLACK);
                
        btnRoot.setBackground(null);
        btnLog.setBackground(null);
        btnMod.setBackground(null);
        btnPower.setBackground(null);
        btnPow.setBackground(null);
        btnASin.setBackground(null);
        btnACos.setBackground(null);
        btnATan.setBackground(null);
        btnSinh.setBackground(null);
        btnCosh.setBackground(null);
        btnTanh.setBackground(null);
        btnSin.setBackground(null);
        btnCos.setBackground(null);
        btnTan.setBackground(null);
        btnSquared.setBackground(null);
        btnExp.setBackground(null);
        btnFactorial.setBackground(null);
        btnLn.setBackground(null);
        btnOParenthesis.setBackground(null);
        btnCParenthesis.setBackground(null);
        
        btnRoot.setForeground(Color.BLACK);
        btnLog.setForeground(Color.BLACK);
        btnMod.setForeground(Color.BLACK);
        btnPower.setForeground(Color.BLACK);
        btnPow.setForeground(Color.BLACK);
        btnASin.setForeground(Color.BLACK);
        btnACos.setForeground(Color.BLACK);
        btnATan.setForeground(Color.BLACK);
        btnSinh.setForeground(Color.BLACK);
        btnCosh.setForeground(Color.BLACK);
        btnTanh.setForeground(Color.BLACK);
        btnSin.setForeground(Color.BLACK);
        btnCos.setForeground(Color.BLACK);
        btnTan.setForeground(Color.BLACK);
        btnSquared.setForeground(Color.BLACK);
        btnExp.setForeground(Color.BLACK);
        btnFactorial.setForeground(Color.BLACK);
        btnLn.setForeground(Color.BLACK);
        btnOParenthesis.setForeground(Color.BLACK);
        btnCParenthesis.setForeground(Color.BLACK);
    }
	
	public void onDarkMode() {  
    	modeText.setForeground(new Color(240, 240, 240));
    	
		equation.setBackground(Color.BLACK);
		equation.setForeground(Color.YELLOW);

		answer.setBackground(Color.BLACK);
		answer.setForeground(Color.GREEN);

    	final Color ops = new Color(2, 161, 155);
        final Color gray = new Color(171, 171, 171);
        final Color orange = new Color(207, 139, 37);

        window.getContentPane().setBackground(new Color(68, 68, 68));
        btn1.setBackground(gray);
        btn2.setBackground(gray);
        btn3.setBackground(gray);
        btn4.setBackground(gray);
        btn5.setBackground(gray);
        btn6.setBackground(gray);
        btn7.setBackground(gray);
        btn8.setBackground(gray);
        btn9.setBackground(gray);
        btn0.setBackground(gray);
        btn0.setBackground(gray);
        btnPoint.setBackground(gray);

        btnAC.setBackground(orange);
        btnBack.setBackground(orange);
        btnDiv.setBackground(orange);
        btnMul.setBackground(orange);
        btnSub.setBackground(orange);
        btnAdd.setBackground(orange);
        btnAns.setBackground(orange);
        btnEqual.setBackground(new Color(163, 168, 0));
        
        
        btnAC.setForeground(Color.WHITE);
        btnBack.setForeground(Color.WHITE);
        btnDiv.setForeground(Color.WHITE);
        btnMul.setForeground(Color.WHITE);
        btnSub.setForeground(Color.WHITE);
        btnAdd.setForeground(Color.WHITE);
        btnAns.setForeground(Color.WHITE);
        btnEqual.setForeground(Color.WHITE);
        
        btnRoot.setBackground(ops);
        btnLog.setBackground(ops);
        btnMod.setBackground(ops);
        btnPower.setBackground(ops);
        btnPow.setBackground(ops);
        btnASin.setBackground(ops);
        btnACos.setBackground(ops);
        btnATan.setBackground(ops);
        btnSinh.setBackground(ops);
        btnCosh.setBackground(ops);
        btnTanh.setBackground(ops);
        btnSin.setBackground(ops);
        btnCos.setBackground(ops);
        btnTan.setBackground(ops);
        btnSquared.setBackground(ops);
        btnExp.setBackground(ops);
        btnFactorial.setBackground(ops);
        btnLn.setBackground(ops);
        btnOParenthesis.setBackground(ops);
        btnCParenthesis.setBackground(ops);
        
        btnRoot.setForeground(Color.WHITE);
        btnLog.setForeground(Color.WHITE);
        btnMod.setForeground(Color.WHITE);
        btnPower.setForeground(Color.WHITE);
        btnPow.setForeground(Color.WHITE);
        btnASin.setForeground(Color.WHITE);
        btnACos.setForeground(Color.WHITE);
        btnATan.setForeground(Color.WHITE);
        btnSinh.setForeground(Color.WHITE);
        btnCosh.setForeground(Color.WHITE);
        btnTanh.setForeground(Color.WHITE);
        btnSin.setForeground(Color.WHITE);
        btnCos.setForeground(Color.WHITE);
        btnTan.setForeground(Color.WHITE);
        btnSquared.setForeground(Color.WHITE);
        btnExp.setForeground(Color.WHITE);
        btnFactorial.setForeground(Color.WHITE);
        btnLn.setForeground(Color.WHITE);
        btnOParenthesis.setForeground(Color.WHITE);
        btnCParenthesis.setForeground(Color.WHITE);
        
    }
	
    private void onShowScientificMode() {
        if (isScientificMode) {
            modeText.setText("Normal");

    		answer.setBounds(20, 40, 350, 70);
    	
            window.setSize(WINDOW_WIDTH , WINDOW_HEIGHT);
            btnRoot.setVisible(false);
            btnPower.setVisible(false);
            btnLog.setVisible(false);
            btnMod.setVisible(false);
            btnPow.setVisible(false);
            btnASin.setVisible(false);
            btnACos.setVisible(false);
            btnATan.setVisible(false);
            btnSin.setVisible(false);
            btnCos.setVisible(false);
            btnTan.setVisible(false);
            btnSquared.setVisible(false);
            btnLn.setVisible(false);
            btnExp.setVisible(false);
            
            isScientificMode = false;
            
        } else {
        	modeText.setText("Scientific");

    		answer.setBounds(20, 40, 710, 70);
    		
            window.setSize(WINDOW_WIDTH + 360, WINDOW_HEIGHT);
            btnRoot.setVisible(true);
            btnPower.setVisible(true);
            btnLog.setVisible(true);
            btnMod.setVisible(true);
            btnPow.setVisible(true);
            btnASin.setVisible(true);
            btnACos.setVisible(true);
            btnATan.setVisible(true);
            btnSin.setVisible(true);
            btnCos.setVisible(true);
            btnTan.setVisible(true);
            btnSinh.setVisible(true);
            btnCosh.setVisible(true);
            btnTanh.setVisible(true);
            btnOParenthesis.setVisible(true);
            btnCParenthesis.setVisible(true);
            btnSquared.setVisible(true);
            btnLn.setVisible(true);
            btnExp.setVisible(true);
            btnFactorial.setVisible(true);
            
            isScientificMode = true;
        }
    }
 }