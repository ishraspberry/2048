import java.util.*;
public class twentyfourtyeight{

    public static int[][] board = new int[4][4];
    public boolean gameover = false;
    public static Scanner in = new Scanner(System.in);
    
    public void makeRand(){
        boolean works = false;
    
        while(works==false){
            int x = (int)(Math.random() * 4);// from any of the rows
            int y = (int)(Math.random() * 4);
            
                if(board[x][y] == 0){
                    board[x][y] = ((int)((Math.random() *2) + 1) *2); //Random 2 or 4
                    works = true;
                }
            }
    }

    public boolean MovingDown() {
        System.out.println("Moving down...");
    
        boolean nextR;
        boolean moved = false;
    
        for(int x = 0; x < 4; x++){
            boolean[] combine= new boolean[4];
            do{
                nextR = true;
                for(int y = 3; y > 0; y--)
                {
                    if((board[y][x] == 0) && (board[y-1][x] != 0))//if the space is empty
                    {
                        board[y][x] = board[y-1][x];
                        board[y-1][x] = 0;
                        nextR = false;//dont go to next row
                        moved = true;//it moved
                    }
                    else if((board[y][x] != 0) && (board[y][x] == board[y-1][x]) && combine[y]==false && combine[y-1]==false)
                    {
                        board[y][x] += board[y-1][x];//add to the next num on board
                        board[y-1][x] = 0;
                        combine[y] = true;
                        nextR = false;
                        moved = true;
                    }
                }
            } while(nextR==false);
        }
        return moved;
    }

    public boolean MovingUp(){
        System.out.println("Moving up...");

        boolean nextR;
        boolean moved = false;

        for(int x = 0; x < 4; x++){
            boolean[] combine = new boolean[4];   
            do{
                nextR = true;
                for(int y = 0; y < 3; y++){
                    if((board[y][x] == 0) && (board[y+1][x] != 0)){
                        board[y][x] = board[y+1][x];
                        board[y+1][x] = 0;
                        nextR = false;
                        moved = true;
                    }
                    else if((board[y][x] != 0) && (board[y][x] == board[y+1][x]) && combine[y]==false && combine[y+1]==false){
                        board[y][x] += board[y+1][x];
                        board[y+1][x] = 0;
                        combine[y] = true;
                        nextR = false;
                        moved = true;
                    }
                }
            }while(nextR==false);
        }
        return moved;
    }
    
    public boolean MovingRight(){
        System.out.println("Moving Right...");

        boolean nextR;
        boolean moved = false;

        for(int x = 0; x < 4; x++){
            boolean[] combine = new boolean[4];
            do{
                nextR = true;
                for(int y = 3; y > 0; y--){
                    if((board[x][y] == 0) && (board[x][y-1] != 0)){
                        board[x][y] = board[x][y-1];
                        board[x][y-1] = 0;
                        nextR = false;
                        moved = true;
                    }
                    else if((board[x][y] != 0) && (board[x][y] == board[x][y-1]) && combine[y]==false && combine[y-1]==false){
                        board[x][y] += board[x][y-1];
                        board[x][y-1] = 0;
                        combine[y] = true;
                        nextR = false;
                        moved = true;
                    }
                }
            }while(nextR==false);
        }
        return moved;
    }
    
    public boolean MovingLeft(){
        System.out.println("Moving Left...");

        boolean nextR;
        boolean moved = false;
        for(int x = 0; x < 4; x++){
            boolean[] combine = new boolean[4];
            do{
                nextR = true;
                for(int y = 0; y < 3; y++){
                    if((board[x][y] == 0) && (board[x][y+1] != 0)){
                        board[x][y] = board[x][y+1];
                        board[x][y+1] = 0;
                        nextR = false;
                        moved = true;
                    }
                    else if((board[x][y] != 0) && (board[x][y] == board[x][y+1]) && combine[y]==false && combine[y+1]==false){
                        board[x][y] += board[x][y+1];
                        board[x][y+1] = 0;
                        combine[y] = true;
                        nextR = false;
                        moved = true;
                    }
                }   
            }while(nextR==false);
        }
        return moved;
    }
    
    public void Move(){
        boolean finish=false;
        do{
            if(in.hasNext()){
                char enter = in.next().charAt(0);
            }
            if(enter == 'a'){
                finish= MovingLeft();
                if(finish ==  false){
                    System.out.println("please enter another letter, you cannot go left right now");
                }
            }
            else if(enter == 's'){
                finish= MovingDown();
                if(finish ==  false){
                    System.out.println("please enter another letter, you cannot go down right now");
                }           
            }
            else if(enter == 'd'){
                finish= MovingRight();
                if(finish ==  false){
                    System.out.println("please enter another letter, you cannot go right right now");
                }
            }
            else if(enter == 'w'){
                finish= MovingUp();
                if(finish ==  false){
                    System.out.println("please enter another letter, you cannot go left up now");
                }
            }
            else{
                System.out.println("Wrong Input");
            }
        }while(finish==false);
    }
    
    public boolean Gameover(){
        System.out.println("checking for a gameover...");
        
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                if(board[x][y] == 0){
                    return false;
                }
                else if(x != 0 && board[x][y] == board[x-1][y]){
                    return false;
                }
                else if(x != 3 && board[x][y] == board[x+1][y]){
                    return false;
                }
                else if(y != 0 && board[x][y] == board[x][y-1]){
                    return false;
                }
                else if(y != 3 && board[x][y] == board[x][y+1]){
                    return false;
                }  
            }
        }
        return true;
    }

    public void PrintBoard(){
        System.out.println("---------------------");
        System.out.println("|    |    |    |    |");
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++)
            {
                if(board[x][y] != 0){
                    System.out.print(String.format("|%4d", board[x][y]));//4d represents width
                }
                else System.out.print("|    ");
            }
            System.out.println("|\n|    |    |    |    |");
            if(x != 3){
                System.out.println("|----|----|----|----|");
                System.out.println("|    |    |    |    |");
            }
            else{
                System.out.println("----------------------");
            }
        }
    }
    
    public twentyfourtyeight(){
        makeRand();
        makeRand();
        do{
            PrintBoard();
            Move();
            gameover = Gameover();
            if(gameover==false){
                makeRand();
            }
        }while(gameover==false);
    }

    public static void main(String[] args){
        twentyfourtyeight newGame = new twentyfourtyeight();
    }
}
