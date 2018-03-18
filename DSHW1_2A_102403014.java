import java.util.*;
import java.util.Stack;
/* 小疑惑
 * 公告中的範例座標是以 (Y座標，X座標)的型式
 * 公告中的範例座標輸出括弧內顯示(up to bottom)但是結果是相反
 * 所以我的輸出結果按照公告給的輸出畫面去做
 * */

/*資管二A_蘇柏菖_102403014*/
public class DSHW1_2A_102403014{
  static int[] board = new int[8];//
  static int x;//X座標(位在輸出座標第二個數字)
  static int y;//Y座標(位在輸出作標的一個數字)
  static int test;
  static int boardSize=0;//棋盤大小
  static String coorx,coory;
  static Stack<String> stackx = new Stack<String>();
  static Stack<String> stacky = new Stack<String>();
  static String outptcoor[];
  //主程式
  public static void main(String[] args) 
  {
	getboardsize();
	fillboard();
  }
  
  
 //檢查是否可以下
  static boolean checksafe(int y) 
  {
    x = board[y];
    for (int i = 1; i <= y; i++) 
    {
      test = board[y - i];//當前第y行，和第i行進行檢查
      if (test == x ||//垂直線
          test == x - i ||//左上方向
          test == x + i) //右上方向
      {
        return true;
      }
    }
 
    return false;
  }
  
 //取得棋盤大小
  public static void getboardsize()
	{
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("輸入棋盤大小n，4≦n≦8：");
		boardSize = scanner.nextInt();
		while(boardSize<4 || boardSize>8)//防止 n 沒有符合 4≦n≦8
		{
			System.out.println("不符合條件，輸入棋盤大小n，4≦n≦8：");
			boardSize = scanner.nextInt();
		}

	}
 
  //印出棋盤
  public static void printboard() {
    System.out.println("");
    for ( y = 0; y < boardSize; y++) 
    {
      for ( x = 0; x < boardSize; x++) 
      {
    	if(board[y] == x)
    	{
    		System.out.print("1");
    		//將座標存進stack
    		coorx = Integer.toString(x+1); 
    		coory = Integer.toString(y+1);
    		stackx.push(coorx);
    		stacky.push(coory);
    	}
    	else
    		System.out.print("0");        
      }
    System.out.print("\n");//準備印下一行，換行
    }
  }

  //印出座標
  public static void printcoordinate()
	{
		System.out.print("Stack<up to bottom>:");
		for(int coorcount = 1; coorcount <= boardSize; coorcount++)
		{
			System.out.print(stacky.pop()+","+stackx.pop()+"|");
		}
	    System.out.println("");
	}
  
  //放棋子
  //陣列第一個元素從0開始，故 Y 從 0開始
  public static void fillboard()
  {
	    y = 0;
	    board[0] = -1;
	    while (y >= 0) 
	    {
	      do 
	      {
	        board[y]++;
	      }while ((board[y] < boardSize) && checksafe(y));
	      if (board[y] < boardSize) 
	      {
	        if (y < boardSize-1) 
	        {
	          board[++y] = -1;
	        } else {
	          printboard();
	          printcoordinate();
	        }
	      } 
	      else 
	      {
	        y--;
	      }
	    }  
  }
}
//結束