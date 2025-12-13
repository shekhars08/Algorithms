package backtracking;

public class StaircaseProblem {

    public static void main(String[] args){

        int n = 3;
        printStairCase(n);
    }

    public static void printStairCase(int A){


        generatePaths(A, "");
    }

    public static void generatePaths(int A, String currPath){

        if(A < 0){
            return;
        }
        if(A == 0){
            System.out.println(currPath);
            return;
        }
        generatePaths(A-1, currPath+"1");
        generatePaths(A-2, currPath+"2");
    }

}
