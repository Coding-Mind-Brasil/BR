package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class CalculatorApp {

	private JFrame frmCalculator;
	protected JTextField display;
	
	private JButton divBtn;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton multBtn;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton subBtn;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton sumBtn;
	private JButton btn_0;
	private JButton dotBtn;
	private JButton equalBtn;
	private JButton pBtn;
	
	protected StringBuffer numberOne;
	protected StringBuffer numberTwo;
	protected Double result;
	protected String operator;
	
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CalculatorApp window = new CalculatorApp();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		numberOne = new StringBuffer();
		numberTwo = new StringBuffer();
		
		
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("Calculator App");
		frmCalculator.setType(Type.UTILITY);
		frmCalculator.setBounds(100, 100, 450, 300);
		frmCalculator.setSize(300, 400);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		display = new JTextField();
		display.setEditable(false);
		display.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		display.setText("0");
		display.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setBounds(6, 9, 288, 69);
		frmCalculator.getContentPane().add(display);
		display.setColumns(10);
		
		JButton acBtn = new JButton("AC");
		acBtn.setBounds(14, 87, 57, 50);
		acBtn.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(acBtn);
		
		divBtn = new JButton("/");
		divBtn.setBounds(156, 87, 57, 50);
		divBtn.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(divBtn);
		
		btn_7 = new JButton("7");
		btn_7.setBounds(14, 146, 57, 50);
		btn_7.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_7);
		
		btn_8 = new JButton("8");
		btn_8.setBounds(85, 146, 57, 50);
		btn_8.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_8);
		
		btn_9 = new JButton("9");
		btn_9.setBounds(156, 146, 57, 50);
		btn_9.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_9);
		
		multBtn = new JButton("x");
		multBtn.setBounds(227, 87, 57, 50);
		multBtn.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(multBtn);
		
		btn_4 = new JButton("4");
		btn_4.addActionListener(new Script(this));
		btn_4.setBounds(14, 205, 57, 50);
		frmCalculator.getContentPane().add(btn_4);
		
		btn_5 = new JButton("5");
		btn_5.setBounds(85, 205, 57, 50);
		btn_5.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_5);
		
		btn_6 = new JButton("6");
		btn_6.setBounds(156, 205, 57, 50);
		btn_6.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_6);
		
		subBtn = new JButton("-");
		subBtn.setBounds(225, 146, 57, 50);
		subBtn.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(subBtn);
		
		btn_1 = new JButton("1");
		btn_1.setBounds(14, 264, 57, 50);
		btn_1.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_1);
		
		btn_2 = new JButton("2");
		btn_2.setBounds(85, 264, 57, 50);
		btn_2.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_2);
		
		btn_3 = new JButton("3");
		btn_3.setBounds(156, 264, 57, 50);
		btn_3.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_3);
		
		sumBtn = new JButton("+");
		sumBtn.setBounds(225, 205, 57, 50);
		sumBtn.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(sumBtn);
		
		btn_0 = new JButton("0");
		btn_0.setBounds(14, 323, 128, 50);
		btn_0.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(btn_0);
		
		dotBtn = new JButton(".");
		dotBtn.setBounds(156, 323, 57, 50);
		dotBtn.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(dotBtn);
		
		equalBtn = new JButton("=");
		equalBtn.setBounds(227, 264, 57, 109);
		equalBtn.addActionListener(new Script(this));
		frmCalculator.getContentPane().add(equalBtn);
		
		pBtn = new JButton("%");
		pBtn.addActionListener(new Script(this));
		pBtn.setBounds(85, 87, 57, 50);
		frmCalculator.getContentPane().add(pBtn);
	}

	public void setDisplay(String value){
		display.setText(value);
	}
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
}
