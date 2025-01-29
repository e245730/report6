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
                System.out.print("| "+board[i][t]);  //配列の値を取得、表示
            }
            System.out.println();
            System.out.println("----".repeat(7));
        }
    }
    
    
    //行と列をrowとcolで,自分の色をcolorで設定
    public static boolean isJudement(int row, int col, String color) {
        //指定の場所が空かどうか判定
        if (!board[row][col].equals(Empty)) {
            return false;
        }
        //相手の石の色を決定
        String opponentColor;
        if (color.equals(Black)) {
            opponentColor = White; // 自分が黒なら相手は白
        } else {
            opponentColor = Black; // 自分が白なら相手は黒
        }       
        //8方向をチェック  選択した場所の周り8方向を座標（行と列）でチェック
        int[] directionsRow = {-1, -1, -1, 0, 0, 1, 1, 1}; // 上, 上右, 右, 下右, 下, 下左, 左, 上左
        int[] directionsCol = {-1, 0, 1, 1, -1, -1, 0, 1};
        //dは各方向の行、列を表した配列のインデックス
        for (int d = 0; d < 8; d++) {
            int currentRow = row + directionsRow[d]; //currentRow：検証する行番号
            int currentCol = col + directionsCol[d]; //currentCol：検証する列番号
            boolean foundOpponent = false;
    
            // 方向ごとに検証
            while (currentRow >= 0 && currentRow < 8 && currentCol >= 0 && currentCol < 8) {
                // 現在判定している場所の石の色について判定
                if (board[currentRow][currentCol].equals(opponentColor)) {
                    foundOpponent = true;
                }
                // 現在判定している場所の色が自分と同じ色の場合
                else if (board[currentRow][currentCol].equals(color)) {
                    if (foundOpponent) {
                        return true; // 挟み込みが成立
                    } else {
                        break; //相手の石が見つからない場合は無効
                    }
                }
                //おきたい場所の周り方向に空ますが発覚した場合、その方向とでは挟み込めないのでその方向では判定終了
                else {
                    break; // 探索終了
                }
    
                // 次のマスを確認、dは行、列それぞれの変化量
                currentRow += directionsRow[d];
                currentCol += directionsCol[d];
            }
        }
    
        // どの方向にも有効な挟み込みが見つからない場合
        return false;
    }
    
    
    //石をひっくり返すメゾット
    public static void turnColor(int row, int col, String color){
   //相手の石の色を決定
        String opponentColor;
        if (color.equals(Black)) {
             opponentColor = White; // 自分が黒なら相手は白
        } else {
        opponentColor = Black; // 自分が白なら相手は黒
        } 
       // 8方向を配列で表す
        int[] directionsRow = {-1, -1, -1, 0, 0, 1, 1, 1}; // 上, 上右, 右, 下右, 下, 下左, 左, 上左
        int[] directionsCol = {-1, 0, 1, 1, -1, -1, 0, 1};

    // 
        for (int d = 0; d < 8; d++) {
            int currentRow = row + directionsRow[d];//検証している行＝指定した行＋dインデックスの変化量
            int currentCol = col + directionsCol[d];//検証している列＝指定した列＋dインデックスの変化量
            boolean foundOpponent = false;

            // 検証している場所の石の色を確認
            while (currentRow >= 0 && currentRow < 8 && currentCol >= 0 && currentCol < 8) {
                if (board[currentRow][currentCol].equals(opponentColor)) {
                    foundOpponent = true; // 相手の石が見つかった
                } else if (board[currentRow][currentCol].equals(color)) {
                    if (foundOpponent) {
                        // 挟み込みが成立している場合、その方向の石をひっくり返す
                        //相手の色ではなく自分の色が発見された場合、挟み込みが成立
                        int flipRow = row + directionsRow[d];  //ひっくり返した行
                        int flipCol = col + directionsCol[d];  //ひっくり返した列
                        //ひっくり返した行、列のどちらかが
                        while (flipRow != currentRow || flipCol != currentCol) {
                            board[flipRow][flipCol] = color; // 石を自分の色に変える
                            flipRow += directionsRow[d];
                            flipCol += directionsCol[d];
                        }
                    }
                    break; // 自分の石が見つかったので終了
                } else {
                    break; // 空のマスが見つかった場合、その方向では挟めない
                }

                // 次のマスを確認（右に一マス、左に一マスなど）
                currentRow += directionsRow[d];
                currentCol += directionsCol[d];
            }
        }
  }








}