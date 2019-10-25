// -------------This is defining window properties. 

    //sets up the dimensions of the windowed screen
    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        setFocusable(true);
        requestFocus();

        int alpha = 127; //50%
        TRANSPARENT = new Color(0, 0, 0, alpha);

        image = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        running = true;

        sm = new StateManager(this);
        font = new Font("Ariel", Font.PLAIN, 12);
    }

    //
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init() { }

// -------------The run method where we are calling the methods for the rest of the game, including the draw.
// -------------This is also where we have the game loop itself. It will use the code to run at a dictated frame rate.
    //running the program
    public void run() {
        init();

        long start;
        long elapsed;
        long wait;

        //game loop
        while (running) {
            start = System.nanoTime();

            if(!paused) { update(); }
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if(wait<0) wait=5;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace(); //always do this
            }
        }
    }

    //pause game
    public void setPaused(boolean b) {paused = b;}
    public boolean getPaused() {return paused;}
    
// -------------Method for updating the game
    //updates the game
    private void update() {
        sm.update();
    }
    
// -------------Drawing our game, then using 'drawToScreen' to draw our game to the window space
    //draws the images from the new updates
    private void draw() {
        sm.draw(g);

        if(paused) {
            g.setColor(TRANSPARENT);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.RED);
            g.drawString("Paused", WIDTH/2 - 20, HEIGHT/2);
        }
    }

    //draws the draw event to the screen scale
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
        g2.dispose();
    }
