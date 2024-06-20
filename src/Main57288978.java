import java.util.Random;

public class Main57288978 {
    public static void main(String[] args) {
        //point of my program
        Maze maze = new Maze();
        Robot robot = new Robot(maze);
    }

    private static class Robot{
        private double probSameDirection = 0.5;
        private double probTurnLeft = 0.2;
        private double probTurnRight = 0.3;
        private int x=0;
        private int y=0;
        private Maze maze;
        private int previousDirection = 0; //0=right,1=down,2=left,3=up


        Robot(Maze maze){ //Robot(maze) will be interpreted as a regular method call, not a constructor
            this.x=x;
            this.y=y;
            this.maze=maze;
        }


        public void sameDirection(){
            if(previousDirection==0) y++;
            else if(previousDirection==1) x++;
            else if(previousDirection==2) y--;
            else if(previousDirection==3) x--;
        }
        public void turnLeft(){
            if(previousDirection==0) x--;
            else if(previousDirection==1) y++;
            else if(previousDirection==2) x++;
            else if(previousDirection==3) y--;

        }
        public void turnRight(){
            if(previousDirection==0) x++;
            else if(previousDirection==1){}
            else if(previousDirection==2){}
            else if(previousDirection==3){}
        }
        public void move(){
            Random rand = new Random();
            if (rand.nextDouble()<probSameDirection) sameDirection();
            if ((rand.nextDouble()>=probSameDirection) && rand.nextDouble()<(probSameDirection+probTurnLeft)) turnLeft();
            if (rand.nextDouble()>=probSameDirection+probTurnLeft) turnRight();
        }
    }

    private static class Maze{
        int[][] maze = new int[7][7];

        Maze(){
            //Set default maze. For loop can't be written outside.
            for(int i=0;i<7;i++){
                for(int j=0;j<7;j++){
                    //0 means the robot has not yet passed through this point.
                    maze[i][j]=0;
                }
            }
            maze[0][0]=1;//Start point
        }
    }
}


