    //variables 
    protected boolean dead;
    protected BufferedImage sprite;
    protected int health;
    protected int damage;

	  //position and vector
    protected double x;
    protected double y;
    protected double dx;
    protected double dy;

    //dimensions
    protected int width;
    protected int height;

    //collision box
    protected int cWidth;
    protected int cHeight;

    //collision
    protected double xDest;
    protected double yDest;
    protected double xTemp;
    protected double yTemp;

    //four point method collision
    protected boolean topLeft;
    protected boolean topRight;
    protected boolean bottomLeft;
    protected boolean bottomRight;

    //movement
    protected boolean left;
    protected boolean right;

    //projectile
    protected boolean firing;
    protected double fireRate;
    protected double nextFire;

    //movement attributes
    protected double moveSpeed;
    protected double maxSpeed;

    //constructor
    public Entities() { }

    //check if objects have collided
    public boolean intersects(Entities o) {
        Rectangle r1 = getRectangle();
        Rectangle r2 = o.getRectangle();
        return r1.intersects(r2);
    }
    public Rectangle getRectangle() {
        return new Rectangle(
                (int) x - cWidth/2,
                (int) y - cHeight/2,
                cWidth,
                cHeight
                );
    }
 	public void calculateCorners(double x, double y) {
        int leftTile = (int)(x - cWidth / 2);
        int rightTile = (int)(x + cWidth / 2 + 1);
        int topTile = (int)(y - cHeight / 2);
        int bottomTile = (int)(y + cHeight / 2 - 1);

        //keeps you in frame bounds
        if(     topTile < 0 || bottomTile >=  GamePanel.HEIGHT ||
                leftTile < 0 || rightTile >=  GamePanel.WIDTH ) {
            topLeft = topRight = bottomLeft = bottomRight = true;
            return;
        } else {
            topLeft = topRight = bottomLeft = bottomRight = false;
        }
    }

	//collision checks
    public void checkCollision() {
        xDest = x + dx;
        xTemp = x;

        //x direction
        calculateCorners(xDest, y);
        //check going left
        if(dx < 0) {
            if(topLeft || bottomLeft) {
                dx = 0;
            } else {
                xTemp += dx;
            }
        }
        //check going right
        if(dx > 0) {
            if(topRight || bottomRight) {
                dx = 0;
            } else {
                xTemp += dx;
            }
        }
    }



    //getters
    public int getX() { return (int)x; }
    public int getY() { return (int)y; }
    public boolean getLeft() { return left; }
    public boolean getRight() { return right; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getCWidth() { return cWidth; }
    public int getCHeight() { return cHeight; }
    public double getMoveSpeed() { return moveSpeed; }
    public boolean getFiring () { return firing; }
    public boolean getDead() {return dead;}
    public int getHealth() {return health;}
    public int getDamage() {return damage;}
    public boolean getCheating() {return cheating; }

    //setters
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setLeft (boolean b) {left = b;}
    public void setRight (boolean b) {right = b;}
    public void setFiring (boolean b) {firing = b;}
    public void setMoveSpeed (double s) {moveSpeed = s;}
    public void setDead(boolean b) {dead = b;}
    public void setHealth(int i) {health = i;}
    public void hit(int i ) {health -= i;}
    public void setCheating(boolean b) {cheating = b; }
    
    //draw rock
    public void draw(Graphics2D g) {
        //draw rock
        g.drawImage(sprite, (int)x - (width/2), (int)y - (height/2), null);
    }
