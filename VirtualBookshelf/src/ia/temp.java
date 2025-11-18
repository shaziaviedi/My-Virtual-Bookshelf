package ia;

public class temp {
    
}



class mainMenu {
	public JLabel greeting;
	private JButton myBookshelfButton;
	private JButton wishlistButton;
	private JButton searchButton;
	private JButton purchaseHistoryButton;
	private JButton quitButton;
	private ImageIcon bookshelfImage;
	private JFrame frame;
	private String newName;
	
	//setter for nameInput
    public void setNewName(String name) {
 	   this.newName = name;
    }
    
    //getter for nameInput
    public String getNewName() {
 	   return newName;
    }

	
	public mainMenu() {  
		
		// JFrame
		JFrame frame = new JFrame("My Virtual Bookshelf"); 
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
            	JOptionPane.showMessageDialog(frame, "You're Already in the Main Menu!");
            }
        });
        header.add(mainMenuButton); //add main menu button to the header panel
        
       // Create a JLabel for the greeting text
       JLabel greeting = new JLabel("Hello, ");
       greeting.setFont(new Font("Arial", Font.BOLD, 50)); // Set the font and alignment of the greeting label
       greeting.setHorizontalAlignment(SwingConstants.CENTER);
       header.add(greeting); // Add the greeting label to the header panel
       if (newName == null || newName.isEmpty()) {
    	   JTextField nameInput = new JTextField();
    	   nameInput.addActionListener(new ActionListener() {
    		   public void actionPerformed(ActionEvent e) {
    			   newName = nameInput.getText(); // Get the user's input from the text field
    			   greeting.setText("Hello, " + newName); // Update the greeting label
    			   header.remove(nameInput);
    		   }
    	   });
    	   header.add(nameInput); 
       }else {
    	   greeting.setText("Hello, " + newName);
       }
       
     
       
       // Create a JButton for the reader profile icon
       JButton readerProfileButton = new JButton(new ImageIcon("reader_profile_icon.png")); // Replace "reader_profile_icon.png" with your custom image file name
       //JButton readerProfileButton = new JButton("reader profile button");
       readerProfileButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   //JOptionPane.showMessageDialog(frame, "Reader Profile button clicked");
        	   frame.setVisible(false);
        	   new readerProfileWindow(getNewName()); //pass user's name
           }
       });
       header.add(readerProfileButton);
       
       
       
       // Create a JPanel for the body section
       JPanel body = new JPanel();
       body.setLayout(new GridLayout(1, 3)); //might need to revise
       Color bodyColor = new Color(220, 209, 232);
       body.setBackground(bodyColor);

       
       // Create an ImageIcon for the bookshelf image
       bookshelfImage = new ImageIcon("bookshelf_image.png"); // Replace "bookshelf_image.png" with your custom image file name
       body.add(new JLabel(bookshelfImage)); // Create a JLabel for the bookshelf image and add it to the body panel
    
      
       // rounded panels
       roundedPanel options = new roundedPanel();
       Color panelColor = new Color(191,218,232);
       options.setBackground(panelColor);
       options.setOpaque(false); //remove background colour behind option panel 
       options.setPreferredSize(new Dimension(1000, 1200));
       options.setLayout(new GridLayout(3, 2)); 
       
	   
       
       // Create JButtons for each main menu option and add them to the options panel
       JButton myBookshelfButton = new JButton("My Bookshelf");
       options.add(myBookshelfButton); //add to options panel
       myBookshelfButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   frame.setVisible(false);
        	   new myBookshelfWindow(getNewName());
           }
       });
	
       JButton wishlistButton = new JButton("Wishlist");
       options.add(wishlistButton);
       wishlistButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   frame.setVisible(false);
        	   new wishlistWindow(getNewName()); 
           }
       });
	
       
       JButton searchButton = new JButton("Search");
       options.add(searchButton);
       searchButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
               new searchWindow(getNewName());
           }
       });
      
       JButton purchaseHistoryButton = new JButton("Purchase History");
       options.add(purchaseHistoryButton);
       purchaseHistoryButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
               new purchaseHistoryWindow(getNewName());
           }
       });
          
       JButton quitButton = new JButton("Quit");
       options.add(quitButton);
       //quitButton.setHorizontalAlignment(SwingConstants.CENTER);
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   System.exit(0);
           }
       });
       
       
       //adding elements
       body.add(options); //add options panel to east region of the body panel
       frame.add(body, BorderLayout.CENTER); //add the body panel to the center region of the JFrame
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set the default close operation 
       frame.setVisible(true); //visibility of JFrame
}
}
