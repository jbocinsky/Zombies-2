package firstgame.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginDisplay extends JFrame{

	public LoginDisplay(){
	    super();
	    
	    setSize(600, 400);
	    
	    JPanel display = new JPanel();
	    
	    JButton a = new JButton("Login");
	    JButton b = new JButton("Sign Up");
	    
	    display.add(a);
	    display.add(b);
	    
	    add(display);
	}

	
}
