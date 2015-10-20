import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    /**
     * Simulate any number of balls bouncing around infinitely inside a box.
     */
    public void boxBounce()
    {
        int ground = 400;   // position of the ground line
        int ceiling = 100;  // position of the ceiling line
        int leftWall = 50;  // position of the left wall line
        int rightWall = 550;    //position of the right wall line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, ceiling, 550, ceiling);
        myCanvas.drawLine(leftWall, 100, leftWall, 400);
        myCanvas.drawLine(rightWall, 100, rightWall, 400);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BoxBall ball2 = new BoxBall(100, 100, 16, Color.RED, ground, leftWall, rightWall,
                                    ceiling, myCanvas);

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            myCanvas.drawLine(50, ground, 550, ground);
            myCanvas.drawLine(50, ceiling, 550, ceiling);
            myCanvas.drawLine(leftWall, 100, leftWall, 400);
            myCanvas.drawLine(rightWall, 100, rightWall, 400);
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
