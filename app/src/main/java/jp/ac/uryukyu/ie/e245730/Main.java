package jp.ac.uryukyu.ie.e245730;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Board Board = new Board();
        Board.Initialize();
        Board.ShowBoard();
        Scanner scanner=new Scanner(System.in);//スキャナーをインスタンス化
        String currentPlayer = Board.Black; // 黒からスタート
        while (true) {
            System.out.print("列を入力して下さい=>");
            int input_row= scanner.nextInt(); //入力された行をインスタンスから取得
            System.out.println("列は"+input_row);
            System.out.print("行を入力して下さい=>");
            int input_col=scanner.nextInt();;//入力された列をインスタンスから取得
            System.out.println("行は"+input_col);
            
            if(Board.placeStone(input_row,input_col,currentPlayer)){
                Board.ShowBoard();
                //プレイヤー交代
                if(currentPlayer.equals(Board.Black)){
                    currentPlayer=Board.White;
                }else{
                    currentPlayer = Board.Black;
                }
            }else {
                System.out.println("そこには置けません。もう一度選んでください。");}
            
        }


        
       
    }
}
