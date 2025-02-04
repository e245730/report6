package jp.ac.uryukyu.ie.e245730;
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;

/**検証すること
ひっくり返るかどうか検証
ひっくり返す処理をする前の場所１の色とひっくり返す処理をした後の場所１の色の変数{配列に保存されたやつかも}情報が等しくないことを確かめる
*/
class  BoardTest {
    @Test
    void turnColorTest(){
        
        Board Board = new Board();
        Board.Initialize();
        Board.ShowBoard();
        String currentPlayer = Board.Black; // 黒からスタート
        String beforeColor=Board.board[4][3];
        
        System.out.print("列を入力して下さい=>今回は４");
        int input_row= 4; 
        System.out.println("列は"+input_row);
        System.out.print("行を入力して下さい=>今回は３");
        int input_col=3;
        System.out.println("行は"+input_col);
        if(Board.placeStone(input_row,input_col,currentPlayer)){
                Board.ShowBoard();
                String afterColor=Board.board[4][3];
                assertNotSame(beforeColor,afterColor);
            }    
    }
}
    