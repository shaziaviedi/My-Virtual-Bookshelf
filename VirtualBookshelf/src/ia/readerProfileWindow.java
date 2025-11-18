package ia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class readerProfileWindow extends JFrame {
	private JLabel headerText;
	private JFrame frame;
	
	public readerProfileWindow(String newName) {
		
		// JFrame
		JFrame frame = new JFrame("Reader Profile"); 
        frame.setSize(800, 600); //Set size
        frame.setLayout(new BorderLayout());

        // header
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1, 3)); // Set the layout of the header panel
        Color headerColor = new Color(204, 159, 202);// Set the background colour of the header panel
        header.setBackground(headerColor);
        frame.add(header,  BorderLayout.NORTH);

        // Create a JButton for the main menu icon
        JButton mainMenuButton = new JButton(new ImageIcon("main_menu_icon.png")); // Replace "main_menu_icon.png" with custom image file name
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//JOptionPane.showMessageDialog(frame, "You're Already in the Main Menu!");
            	frame.dispose();
            	new mainMenu().setNewName(newName);
            }
        });
        header.add(mainMenuButton); //add main menu button to the header panel
        
       // Create a JLabel for the greeting text
       JLabel headerText = new JLabel(newName + "'s Profile");
       headerText.setFont(new Font("Arial", Font.BOLD, 50)); // Set the font and alignment of the greeting label
       headerText.setHorizontalAlignment(SwingConstants.CENTER);
       header.add(headerText); // Add the greeting label to the header panel
       
       // Create a JButton for the reader profile icon
       JButton readerProfileButton = new JButton(new ImageIcon("reader_profile_icon.png")); // Replace "reader_profile_icon.png" with your custom image file name
       readerProfileButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               //new readerProfileWindow().setVisible(true); //function
        	   JOptionPane.showMessageDialog(frame, "You're already in Reader Profile!");
        	   //new readerProfileWindow();
           }
       });
       header.add(readerProfileButton);
       
       // Create a JPanel for the body section
       JPanel body = new JPanel();
       //body.setLayout(new GridLayout(1, 1)); //might need to revise
       Color bodyColor = new Color(220, 209, 232);
       body.setBackground(bodyColor);
       
     //adding elements
       frame.add(body, BorderLayout.CENTER); //add the body panel to the center region of the JFrame
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //set the default close operation 
       frame.setVisible(true); //visibility of JFrame
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new readerProfileWindow("").setVisible(true);
            }
        });
	}

}
