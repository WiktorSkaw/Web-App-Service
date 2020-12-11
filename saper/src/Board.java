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
        display();
    }

    void randBombs() {

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

        if (board[x][y].isMine)
            return true;
        else
            return false;
    }

    int countMines(int x, int y) {
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

      void display () {

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (board[i][j].isMine)
                        System.out.printf("[x]");
                    else {
                        System.out.printf("[" + countMines(i, j) + "]");
                    }
                }
                System.out.print("\n");
            }
        }

    }


