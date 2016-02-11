package firstgame.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewPlayerSignUp extends JFrame{
	private JTextField userNameField;
	private JPasswordField passWordField;
	private JLabel un;
	private JLabel pw;
	private JButton createButton;
	private JButton cancelButton;
	
	public NewPlayerSignUp(){
		super("Create New User");
		
		//Main panel that fills whole screen that holds the following subPanels
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));	   
	    
	    //subPanels to be placed in Main Panel
	    JPanel userNamePanel = new JPanel();
	    JPanel passWordPanel = new JPanel();
	    JPanel buttonsPanel = new JPanel();
	    
	    
	    un = new JLabel("Username: ");
	    userNamePanel.add(un);
	    
	    userNameField = new JTextField(20);
	    userNamePanel.add(userNameField);
	    
	    
	    pw = new JLabel("Password: ");
	    passWordPanel.add(pw);
	    
	    passWordField = new JPasswordField(20);
	    passWordPanel.add(passWordField);
		
	    
	    //creates spacing between buttons and above password field
	    buttonsPanel.add(Box.createRigidArea(new Dimension(0,50)));
	    
	    createButton = new JButton("Create");
	    buttonsPanel.add(createButton);
	    
	    cancelButton = new JButton("Cancel");
	    buttonsPanel.add(cancelButton);
	    
	    //adds the SubPanels to the mainPanel in correct order
	    mainPanel.add(userNamePanel);
	    mainPanel.add(passWordPanel);
	    mainPanel.add(buttonsPanel);
	    
	    //adds mainPanel to the JFrame
	    add(mainPanel);	  

	    
	    NewPlayerHandler loginHandler = new NewPlayerHandler();
	    userNameField.addActionListener(loginHandler);
	    passWordField.addActionListener(loginHandler);
	    createButton.addActionListener(loginHandler);
	    cancelButton.addActionListener(loginHandler);
	    
	}
	
	private class NewPlayerHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			

			String getUserName = userNameField.getText();
			String getPassWord = passWordField.getText();
			String message = "";
			
			if(event.getSource() == passWordField){
				//creates new user in Text Document
				DataBaseManager DBMan = new DataBaseManager();
				try {
					message = DBMan.createUser(getUserName, getPassWord);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				//shows user if he has created a valid user or not
				JOptionPane.showMessageDialog(null, message);
				
				//If new user was successfully created, goes back to Login page
				if(message.equals("You created a new user. Login to start playing!")){
					LoginDisplay login = new LoginDisplay();
					setVisible(false);
	
					login.setPreferredSize(new Dimension(250,200));
					login.setMaximumSize(new Dimension(250,200));
					login.setMinimumSize(new Dimension(250,200));
					login.setResizable(false);
					
					login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					login.setLocationRelativeTo(null);	
					login.setVisible(true);	
				}
			}
			else if(event.getSource() == createButton){
				//creates new user in Text Document
				DataBaseManager DBMan = new DataBaseManager();
				try {
					message = DBMan.createUser(getUserName, getPassWord);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				//shows user if he has created a valid user or not
				JOptionPane.showMessageDialog(null, message);
				
				//If new user was successfully created, goes back to Login page
				if(message.equals("You created a new user. Login to start playing!")){
					LoginDisplay login = new LoginDisplay();
					setVisible(false);
	
					login.setPreferredSize(new Dimension(250,200));
					login.setMaximumSize(new Dimension(250,200));
					login.setMinimumSize(new Dimension(250,200));
					login.setResizable(false);
					
					login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					login.setLocationRelativeTo(null);	
					login.setVisible(true);	
				}
			}
			else if(event.getSource() == cancelButton){
				//goes back to Login page
				LoginDisplay login = new LoginDisplay();
				setVisible(false);

				login.setPreferredSize(new Dimension(250,200));
				login.setMaximumSize(new Dimension(250,200));
				login.setMinimumSize(new Dimension(250,200));
				login.setResizable(false);
				
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login.setLocationRelativeTo(null);	
				login.setVisible(true);	
			}
			
			
		}
		
	}
	
}