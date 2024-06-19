public class Main57288978 {
    public static void main(String[] args) {
        //point of my program
        Maze maze = new Maze();
        Robot robot = new Robot();
    }

    private static class Robot{
        private double probSameDirection = 0.5;
        private double probTurnLeft = 0.2;
        private double probTurnRight = 0.3;

        Robot(){}
    }

    private static class Maze{
        int[][] maze = new int[7][7];

        Maze(){
            //Set default maze. For loop can't be written outside.
            for(int i=0;i<7;i++){
                for(int j=0;j<7;j++){
                    //0 means the robot has not yet passed through this point.
                    maze[i][j]=0;
                    System.out.print(maze[i][j]+" ");
                }
                System.out.println();
            }
            maze[0][0]=1;//Start point
        }
    }
}


