import java.awt.BorderLayout;

import javax.swing.JFrame;


public class MainFrame extends JFrame{
MainPanel mainPanel;
public  MainFrame (){
	
	mainPanel=new MainPanel();
	this.setLayout(new BorderLayout());
	this.setSize(300, 200);
	this.setVisible(true);
	
	this.setResizable(false);
	this.setLocation(400, 200);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.getContentPane().add(mainPanel);
}

}
