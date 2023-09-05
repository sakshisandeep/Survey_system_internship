import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class SurveyForm extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textContact;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected JRadioButton rdbtnExc;
	protected JRadioButton rdbtnPoor;
	protected JTextArea textFeedback;
	protected JSlider textRate;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SurveyForm frame = new SurveyForm();
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
	public SurveyForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\prati\\Downloads\\userimg.png"));
		setTitle("SURVEY FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 627);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(65, 107, 84, 25);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(65, 158, 102, 25);
		contentPane.add(lblEmail);
		
		JLabel lblContact = new JLabel("CONTACT");
		lblContact.setForeground(new Color(255, 255, 255));
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContact.setBounds(65, 214, 102, 25);
		contentPane.add(lblContact);
		
		JLabel textService = new JLabel("SERVICE");
		textService.setForeground(new Color(255, 255, 255));
		textService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textService.setBounds(65, 270, 95, 25);
		contentPane.add(textService);
		
		JLabel lblRate = new JLabel("RATE US");
		lblRate.setForeground(new Color(255, 255, 255));
		lblRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRate.setBounds(65, 328, 95, 25);
		contentPane.add(lblRate);
		
		JLabel lblFeed = new JLabel("FEEDBACK");
		lblFeed.setForeground(new Color(255, 255, 255));
		lblFeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFeed.setBounds(65, 386, 122, 25);
		contentPane.add(lblFeed);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/surveyform","root","sakshi2002");
			    String query="insert into surveysystem values(?,?,?,?,?,?)";
			    PreparedStatement ps=con.prepareStatement(query);
			    ps.setString(1, textName.getText());
			    ps.setString(2, textEmail.getText());
			    ps.setString(3, textContact.getText());
			    if(rdbtnExc.isSelected())
			    	ps.setString(4, rdbtnExc.getText());
			    else
			    	ps.setString(4, rdbtnPoor.getText());
			    ps.setInt(5,textRate.getValue());
			    ps.setString(6, textFeedback.getText());
			    
			    int i=ps.executeUpdate();
			    JOptionPane.showMessageDialog(btnSubmit, i+"Record added successfully");
			    ps.close();
			    con.close();
			    
			  } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(309, 493, 122, 55);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textName.setText("");
			textEmail.setText("");
			textContact.setText("");
			textService.setText("");
		
			textFeedback.setText("");
			buttonGroup.clearSelection();
			
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(563, 493, 116, 55);
		contentPane.add(btnCancel);
		
		JLabel lblTitle = new JLabel("SURVEY FORM");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblTitle.setBounds(407, 25, 272, 55);
		contentPane.add(lblTitle);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textName.setBounds(236, 107, 272, 29);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textEmail.setBounds(236, 158, 272, 29);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textContact = new JTextField();
		textContact.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textContact.setBounds(236, 215, 272, 29);
		contentPane.add(textContact);
		
		
		rdbtnExc = new JRadioButton("EXCELENT");
		rdbtnExc.setBackground(new Color(64, 0, 64));
		rdbtnExc.setForeground(new Color(255, 255, 255));
		rdbtnExc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnExc);
		rdbtnExc.setBounds(236, 273, 122, 27);
		contentPane.add(rdbtnExc);
		
		rdbtnPoor = new JRadioButton("POOR");
		rdbtnPoor.setBackground(new Color(64, 0, 64));
		rdbtnPoor.setForeground(new Color(255, 255, 255));
		rdbtnPoor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnPoor);
		rdbtnPoor.setBounds(407, 276, 116, 19);
		contentPane.add(rdbtnPoor);
		
		textFeedback = new JTextArea();
		textFeedback.setFont(new Font("Monospaced", Font.PLAIN, 19));
		textFeedback.setBounds(236, 386, 622, 75);
		contentPane.add(textFeedback);
		
		textRate = new JSlider();
		textRate.setBounds(242, 331, 266, 22);
		contentPane.add(textRate);
	}
}
