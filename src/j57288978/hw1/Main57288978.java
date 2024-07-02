package j57288978.hw1;

import java.util.Random;

/****
20 results:0.327 0.327 0.328 0.327 0.328
           0.327 0.328 0.328 0.328 0.327
           0.327 0.328 0.327 0.327 0.328
           0.329 0.328 0.328 0.328 0.328
average:0.328
After 1000000 cycles, the results obtained each time are very similar.
This indicates that Monte Carlo estimation has a high accuracy rate.
 ****/

public class Main57288978 {
    public static void main(String[] args) {
        //entry point of program
        for (int a = 0; a < 1000000; a++) {
            Maze maze = new Maze();
            Robot robot = new Robot(maze);
            robot.move();
        }
        System.out.println("The Monte Carlo simulation result of one million runs:");
        System.out.println("No. of successful escape: "+Robot.success);
        String formattedP = String.format("%.3f", Robot.success/1000000.0);
        System.out.println("Success Rate P: "+ formattedP);
    }

    private static class Robot{
        private double probSameDirection = 0.5;
        private double probTurnLeft = 0.2;
        private double probTurnRight = 0.3;

        //start point,x = row,y = column
        private int x=1;
        private int y=1;
        private Maze maze;

        //Initial direction is right
        //0=right,1=down,2=left,3=up
        private int Direction = 0;
        static int success = 0;

        Robot(Maze maze){ //Robot(maze) will be interpreted as a regular method call, not a constructor
            this.maze=maze;
        }

        //change coordinate,don't change direction,0=right,1=down,2=left,3=up
        public void sameDirection(){
            if(Direction==0) y++;
            else if(Direction==1) x++;
            else if(Direction==2) y--;
            else if(Direction==3) x--;
        }

        //change coordinate and change direction,0=right,1=down,2=left,3=up
        public void turnLeft(){
            if(Direction==0) {
                x--;
                Direction = 3;
            }
            else if(Direction==1) {
                y++;
                Direction = 0;
            }
            else if(Direction==2) {
                x++;
                Direction = 1;
            }
            else if(Direction==3) {
                y--;
                Direction = 2;
            }
        }

        //change coordinate and change direction,0=right,1=down,2=left,3=up
        public void turnRight(){
            if(Direction==0) {
                x++;
                Direction = 1;
            }
            else if(Direction==1){
                y--;
                Direction = 2;
            }
            else if(Direction==2){
                x--;
                Direction = 3;
            }
            else if(Direction==3){
                y++;
                Direction = 0;
            }
        }

        public void move(){
            //loop until arriving the destination
            while(maze.coordinate[7][7]!=1){
                //Record the coordinates and direction of the previous step
                int lastX = x;
                int lastY = y;
                int lastDirection = Direction;

                //Using random numbers to simulate probabilities in different directions
                Random rand = new Random();
                double randRecord=rand.nextDouble();
                if (randRecord<probSameDirection) sameDirection();
                else if (randRecord<(probSameDirection+probTurnLeft)) turnLeft();
                else turnRight();

                //Set the value of the target point to 1 when the movable condition is met
                if(maze.inTheBoundary(x,y) && maze.coordinate[x][y]==0){
                    maze.coordinate[x][y]=1;
                    //Jump out of the loop when reaching the dead end
                    if(maze.isInDeadEnd(x,y)){
                        break;
                    }
                }
                //If robot can't reach the point, return to the previous point's state
                else{
                    x=lastX;
                    y=lastY;
                    Direction=lastDirection;
                }
            }
            //Record a success when reaching the exit
            if(maze.coordinate[7][7]==1)
                success++;
        }
    }

    private static class Maze{
        //Initialize the map, with the outermost layer being the wall for easy identification of dead ends
        //[1][1] is the start point
        //A value of 1 represents passing through this point
        int[][] coordinate = {{1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1}};


        Maze(){}

        //Scope of action, x = row, y = column
        private boolean inTheBoundary(int x,int y){
            if(x>=1 && x<=7 && y>=1 && y<=7)
                return true;
            else
                return false;
        }

        //If there are 1's in all directions, it means reaching a dead end
        private boolean isInDeadEnd(int x,int y){
            if(coordinate[x+1][y]==1 && coordinate[x-1][y]==1 && coordinate[x][y+1]==1 && coordinate[x][y-1]==1)
                return true;
            else
                return false;
        }
    }
}