package jp.ac.uryukyu.ie.e245730;
//盤面を管理するクラス
public class Board {
   static String board[][]  = new String [8][8];  //8*8の盤面を用意
   static String Empty = " ";
   static String Black = "B";
   static String White = "W";

//盤面にempty,中央に白黒を設置する
    public static void Initialize(){
        for (int i = 0; i < 8; i++){
            for(int t = 0;t<8;t++){
                board[i][t]= Empty;
            }
        }
        //下記を設定するために表示するBoardに変数を用いて番号をつけなければならない
        board[3][3] = Black;
        board[3][4] = White;
        board[4][3] = White;
        board[4][4] = Black;
    }
   //番号をつけたBoardを表示させる
    public static void ShowBoard (){
        for (int i=0;i<8;i++){
            System.out.print(" "+i+" ");  //列番号表示
            }
        System.out.println();
        System.out.println("----".repeat(7));
        for (int t=0;t<8;t++){
            System.out.print(t);  //行番号表示
            for(int i=0;i<8;i++){
                System.out.print("| "+board[i][t]);
            }
            System.out.println();
            System.out.println("----".repeat(7));
        }
    }
}

    

