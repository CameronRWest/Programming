// ---------------------Needs to check input and move player accordingly. If player shoots bullets, watch 
// ---------------------to see how many bullets on screen to control firing rate. 

// ---------------------Establishing the player, constructor used to set variables about the class Player
    //constructor
    public Player(StateManager sm, SpriteManager sp) {
        spMgr = sp;
        stMgr = sm;

    	width = 15;   //sprite width
        height = 15;  //sprite height
        cWidth = 15;  //bbox width
        cHeight = 10; //bbox height

        health = 1;
        dead = false;

    	moveSpeed = 0.6;
        maxSpeed = 3;
        friction = 0.8;

        bullets = new ArrayList<Player_Bullet>();
        fireRate = 500000000;

        //load sprite
        try {
            sprite = spMgr.playerSprite();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sound
        sfx = new HashMap<String, AudioPlayer>();
        sfx.put("shoot", new AudioPlayer("/Resources/Audio/player.wav"));
    }

    //shoot bullet
    public void shoot() {
    	bullets.add(new Player_Bullet(spMgr));
    	bullets.get(bullets.size()-1).setPosition(x, y);
        //sound
        sfx.get("shoot").setVolume(0.01f);
        sfx.get("shoot").play();
        nextFire = System.nanoTime() + fireRate;
    }

    //check if bullet hit enemies
    public void checkAttack(ArrayList<Enemy> enemies, StateManager sm, int points) {
        for (int i = 0; i < enemies.size(); i++) {
            for(int j = 0; j < bullets.size(); j++) {
                if(bullets.get(j).intersects(enemies.get(i))) {
                    enemies.remove(i);
                    bullets.remove(j);
                    sm.setScore(points);
                    return;
                } 
            }
        }
    }

    //check if bullet hit rocks
    public void checkAttackRocks(ArrayList<Rock> rocks) {
        for (int i = 0; i < rocks.size(); i++) {
            for(int j = 0; j < bullets.size(); j++) {
                if(bullets.get(j).intersects(rocks.get(i))) {
                    bullets.remove(j);
                    return;
                }
            }
        }
    }

    //positioning
    private void getNextPosition() {
        //movement right or left
        if(left) {
            dx -= moveSpeed;
            if(dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else if (right) {
            dx += moveSpeed;
            if(dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx > 0) {
                dx -= friction;
                if(dx < 0) {
                    dx = 0;
                }
            } else if (dx < 0) {
                dx += friction;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }
    }
    
// ---------------------Calling various methods to run the player on update
    //update player
    public void update() {
        //positiion
        getNextPosition();
        checkCollision();
        setPosition(xTemp, GamePanel.HEIGHT - 10);

        //fire
        if(firing && (System.nanoTime() > nextFire)) {
            firing = false;
        	shoot();
        }

        //update player's bullet
        for(int i = 0; i < bullets.size(); i++) {
        	bullets.get(i).update();
        }

        //check bullets off screen
        for (int i = 0; i < bullets.size(); i++) {
            if(bullets.get(i).getY() <= -15) { 
                bullets.remove(i); 
            }
        }

        //check if dead
        if (health <= 0) {
            dead = true;
        }
    }

    //draw player
    public void draw(Graphics2D g) {
    	//draw bullets
        for (int i = 0; i < bullets.size(); i++) {
        	bullets.get(i).draw(g);
    	}
        
        super.draw(g);
    }
