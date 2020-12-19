import java.util.Random;

public class Board {

    SaperJbutton[][] board;
    int width;
    int height;


    Board(int x, int y) {
        board = new SaperJbutton[x][y];
        width = x;
        height = y;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++)
                board[i][j] = new SaperJbutton();
        }

    for (int i = 1; i <= 10; i++)
            randBombs();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j].minNumber = countMines(i, j);
            }
        }
    }

    void randBombs() { // losuje bomby

        Random r = new Random();

        int a = r.nextInt(10);
        int b = r.nextInt(10);

       if(!board[a][b].isMine)
           board[a][b].isMine = true;
       else{
           randBombs();
       }
    }

    boolean hasMine(int x, int y) {

        return board[x][y].isMine;

    }

    int countMines(int x, int y) { // liczy bomby wokol pola
        int sum = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            if(i>=0 && i<width)
                for (int j = y - 1; j <= y + 1; j++) {
                    if(j>=0 && j<height)
                        if(i!=x || j!=y)
                            if (hasMine(i, j))
                                sum++;
                            }
                        }
        return sum;
    }

}


