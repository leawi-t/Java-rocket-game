import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameGui implements KeyListener{

    int seconds=0;
    boolean isInvulnerable = false;
    Random random = new Random();
    JFrame frame = new JFrame();

    int lives = 3;
    JLabel livesLabel = new JLabel("Lives left: " + lives);
    JLabel player = new JLabel();
    JLabel[] projectiles = new JLabel[7];
    JLabel secondsLabel = new JLabel("seconds passed: " + seconds);

    Timer timer1;
    Timer timer2;
    Timer timer3;

    GameGui(int x){

        ImageIcon icon = new ImageIcon(getClass().getResource("/rocket_5731863.png"));
        ImageIcon projIcon = new ImageIcon(getClass().getResource("/game_13527410 (1).png"));

        timer3 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                secondsLabel.setText("Seconds passed: " + seconds);
            }
        });
        timer3.start();

        player.setIcon(icon);
        player.setBounds(250,400,icon.getIconWidth(), icon.getIconHeight());
        livesLabel.setBackground(Color.WHITE);
        livesLabel.setBounds(350,0,100,30);
        livesLabel.setForeground(Color.BLACK);


        secondsLabel.setBackground(Color.WHITE);
        secondsLabel.setBounds(10,0,200,30);
        secondsLabel.setForeground(Color.BLACK);


        for(int i=0; i< projectiles.length;i++){
            projectiles[i] = new JLabel();
            projectiles[i].setIcon(projIcon);
            projectiles[i].setBounds(random.nextInt(0,450), 0, projIcon.getIconWidth(), projIcon.getIconHeight());
        }

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.add(player);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);
        frame.add(livesLabel);
        frame.add(secondsLabel);

        if(x==1){
            for(int i=0; i<3; i++){
                frame.add(projectiles[i]);
            }

            timer1 = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0; i<3; i++){
                        move(projectiles[i],x);
                    }
                }
            });

            timer1.start();
        }

        else if(x==2){
            for(int i=0; i<4; i++){
                frame.add(projectiles[i]);
            }

            timer1 = new Timer(random.nextInt(30,40), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0; i<4; i++){
                        move(projectiles[i],x);
                    }
                }
            });

            timer1.start();

        }


        if (x == 3) {
            for(int i=0; i<7; i++){
                frame.add(projectiles[i]);
            }

            timer1 = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0; i<=3; i++){
                        move(projectiles[i],x);
                    }
                }
            });

            timer2 = new Timer(30, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=4; i<7; i++){
                        move(projectiles[i],x);
                    }
                }
            });

            timer1.start();
            timer2.start();
        }

        frame.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'w':
                if(player.getY()==0){
                    player.setLocation(player.getX(), player.getY());
                }
                else{
                    player.setLocation(player.getX(), player.getY()-5);
                }
                break;

            case 's':
                if(player.getY() + player.getHeight() < frame.getContentPane().getHeight()){
                    player.setLocation(player.getX(), player.getY()+5);
                }
                else{
                    player.setLocation(player.getX(), player.getY());
                }
                break;

            case 'a':
                if(player.getX()==0){
                    player.setLocation(player.getX(), player.getY());
                }
                else{
                    player.setLocation(player.getX()-5, player.getY());
                }
                break;

            case 'd':
                if(player.getX() + player.getWidth() < frame.getContentPane().getWidth()){
                    player.setLocation(player.getX()+5, player.getY());
                }
                else{
                    player.setLocation(player.getX(), player.getY());
                }
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case 38:
                if(player.getY()==0){
                    player.setLocation(player.getX(), player.getY());
                }
                else{
                    player.setLocation(player.getX(), player.getY()-5);
                }
                break;

            case 40:
                if(player.getY() + player.getHeight() < frame.getContentPane().getHeight()){
                    player.setLocation(player.getX(), player.getY()+5);
                }
                else{
                    player.setLocation(player.getX(), player.getY());
                }
                break;

            case 37:
                if(player.getX()==0){
                    player.setLocation(player.getX(), player.getY());
                }
                else{
                    player.setLocation(player.getX()-5, player.getY());
                }
                break;

            case 39:
                if(player.getX() + player.getWidth() < frame.getContentPane().getWidth()){
                    player.setLocation(player.getX()+5, player.getY());
                }
                else{
                    player.setLocation(player.getX(), player.getY());
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You have released the key character " + e.getKeyChar());
        System.out.println("You have released the Key code " + e.getKeyCode());
    }

    public void move(JLabel proj, int x){
        int newY = proj.getY() + random.nextInt(4,10); // Move down by 5 pixels
        int newX = proj.getX();

        // Reset position if it goes beyond the frame height
        if (newY > frame.getHeight()) {
            newY = 0;
            newX = random.nextInt(0,450);
        }

        proj.setLocation(newX, newY);

        if(player.getBounds().intersects(proj.getBounds())){
            if(!isInvulnerable) {
                lives--;
                livesLabel.setText("Lives left " + lives);
                isInvulnerable=true;

                new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        isInvulnerable = false;
                    }
                }).start();
            }

            if (lives == 0) {
                if (x == 3) {
                    timer2.stop();
                }
                timer1.stop();
                timer3.stop();
                JOptionPane.showMessageDialog(null, "You lose, you lasted " + seconds + " seconds");
                frame.dispose();
            }
        }
    }
}
