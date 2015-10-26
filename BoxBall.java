import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * The BoxBall class creates balls to be drawn inside a canvas without speed degradation or slow
 * down due to gravity. The BoxBalls should be able to bounce of any wall continuously and rebound
 * with full speed, going into other walls.
 * 
 * @author David Martinez
 * @version 1.2 (10-26-2015)
 */
public class BoxBall
{
    private Random rand = new Random();
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int groundPosition;      // y position of ground
    private int leftWallPosition;
    private int rightWallPosition;
    private int ceilingPosition;
    private Canvas canvas;
    private int ySpeed = (rand.nextInt(8))+1;                // initial downward speed
    private int xSpeed = (rand.nextInt(8))+1;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param lWallPos  the position of the left wall
     * @param rWallPos  the position of the right wall
     * @param ceilPos   the position of the ceiling
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int lWallPos, int rWallPos, int ceilPos,
                        Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        leftWallPosition = lWallPos;
        rightWallPosition = rWallPos;
        ceilingPosition = ceilPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw. Will also bounce off walls.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit any of the walls
        if(yPosition >= (groundPosition - diameter)) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed;
        } 
        else if (yPosition <= (ceilingPosition)) {
            yPosition = (int)(ceilingPosition);
            ySpeed = -ySpeed;
        }
        if (xPosition <= (leftWallPosition)) {
            xPosition = (int)(leftWallPosition);
            xSpeed = -xSpeed;
        } 
        else if (xPosition >= (rightWallPosition - diameter)) {
            xPosition = (int)(rightWallPosition - diameter);
            xSpeed = -xSpeed;
        }
        
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     * @return  the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     * @return  the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
