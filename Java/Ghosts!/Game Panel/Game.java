// -----------------This is setting up the JFrame (Window) to run our GamePanel code

    public static void main(String[] args) {
        //setting up game window
    	JFrame window = new JFrame("Ghosts!!");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
