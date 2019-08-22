/* *****************************************************************************
 *  Author:    Kara Dowling
 *
 *  Description:  This program uses the BouncingBallDeluxe.java program from
 *  Princeton's IntroCS course as a template for a missile simulation program.
 *  The program reads in data printed by the python missile simulation and
 *  creates a visual simulation from it using the StdDraw program created
 *  at Princeton.
 *
 * Explosion Picture:
 * http://www.textures4photoshop.com/tex/thumbs/explosion-background-for-
 * photoshop-free-thumb39.jpg
 *
 * American Destroyer Picture:
 * https://www.public.navy.mil/surflant/ddg80/PublishingImages/mainimage.png
 *
 * Chinese Destroyer Picture:
 * https://amp.businessinsider.com/images/5cdaf325021b4c60a33220e7-750-375.jpg
 *
 * Compile code: javac-introcs MissileSimulation.java
 *
 * Run code with: java-introcs MissileSimulation < animationFile.txt
 * **or whatever file you want to redirect into it as input**
 *
 * Ocean Picture:
 * https://www.businessnewsdaily.com/images/i/000/008/389/original/
 * blue-ocean.jpg?1427902830
 **************************************************************************** */


public class MissileSimulation {

    //@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("FE_FLOATING_POINT_EQUALITY")
    public static void main(String[] args) {

        // initial values

        // initialize standard drawing
        StdDraw.setCanvasSize(1024, 256);
        StdDraw.setXscale(-20, 320);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // main animation loop
        double currentTime = 0.0;

        double t = StdIn.readDouble();
        while (!StdIn.isEmpty()) {

            // read missile information and plot all missiles at time t
            while (!StdIn.isEmpty() && t == currentTime) {
                double xLoc = StdIn.readDouble();
                String color = StdIn.readString();
                StdIn.readString();
                String missileShipType = StdIn.readString();
                String hit = StdIn.readString();
                String icon;
                if (hit.equals("True")) {
                    icon = "explosion.png";
                } else {
                    if (missileShipType.equals("ship")) {
                        if (color.equals("Red"))
                            icon = "ChineseDestroyer.jpg";
                        else
                            icon = "AmericanDestroyer.png";
                    } else if (missileShipType.equals("offensive")) {
                        icon = "K";
                    } else {
                        icon = "d";
                    }
                }
                if (color.equals("Red"))
                    StdDraw.setPenColor(StdDraw.RED);
                else
                    StdDraw.setPenColor(StdDraw.BLUE);
                if (icon.equals("explosion.png"))
                    StdDraw.picture(xLoc, 0, icon, 50, 1);
                else if (icon.equals("ChineseDestroyer.jpg"))
                    StdDraw.picture(xLoc, 0, icon, 25, .4);
                else if (icon.equals("AmericanDestroyer.png"))
                    StdDraw.picture(xLoc, 0, icon, 25, .4);
                else
                    StdDraw.text(xLoc, 0, icon);
                if (!StdIn.isEmpty())
                    t = StdIn.readDouble();
            }

            // display and pause for 20 ms
            StdDraw.show();  // double buffer is enabled
            StdDraw.pause(75);

            // set the background to light gray
            StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.picture(150, 0, "blue-oceanCropped.jpg", 340, 2);

            currentTime += 0.25;
        }

    }
}
