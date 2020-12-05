
package coodorniates;

import java.util.*;
public class Coodorniates {

    public static void main(String[] args) {
    
    int[][] board = new int[5][5];
    int[][] ships = new int[3][2];
    int[] shoot = new int[2];
    

    initBoard(board);
    initShips(ships);

    System.out.println();

   

   
}

public static void initBoard(int[][] board){
    for(int row=0 ; row < 5 ; row++ )
        for(int column=0 ; column < 5 ; column++ )
            board[row][column]=-1;
}

public static void showBoard(int[][] board){
    System.out.println("\t1 \t2 \t3 \t4 \t5");
    System.out.println();

    for(int row=0 ; row < 5 ; row++ ){
        System.out.print((row+1)+"");
        for(int column=0 ; column < 5 ; column++ ){
            if(board[row][column]==-1){
                System.out.print("\t"+"~");
            }else if(board[row][column]==0){
                System.out.print("\t"+"*");
            }else if(board[row][column]==1){
                System.out.print("\t"+"X");
            }

        }
        System.out.println();
    }

}

public static void initShips(int[][] ships){
    Random random = new Random();

    for(int ship=0 ; ship < 3 ; ship++){
        ships[ship][0]=random.nextInt(5);
        ships[ship][1]=random.nextInt(5);

     
}
    }
    
}
