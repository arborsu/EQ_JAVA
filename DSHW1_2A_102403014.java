import java.util.*;
import java.util.Stack;
/* �p�ôb
 * ���i�����d�Үy�ЬO�H (Y�y�СAX�y��)������
 * ���i�����d�Үy�п�X�A�������(up to bottom)���O���G�O�ۤ�
 * �ҥH�ڪ���X���G���Ӥ��i������X�e���h��
 * */

/*��ޤGA_Ĭ�f�u_102403014*/
public class DSHW1_2A_102403014{
  static int[] board = new int[8];//
  static int x;//X�y��(��b��X�y�вĤG�ӼƦr)
  static int y;//Y�y��(��b��X�@�Ъ��@�ӼƦr)
  static int test;
  static int boardSize=0;//�ѽL�j�p
  static String coorx,coory;
  static Stack<String> stackx = new Stack<String>();
  static Stack<String> stacky = new Stack<String>();
  static String outptcoor[];
  //�D�{��
  public static void main(String[] args) 
  {
	getboardsize();
	fillboard();
  }
  
  
 //�ˬd�O�_�i�H�U
  static boolean checksafe(int y) 
  {
    x = board[y];
    for (int i = 1; i <= y; i++) 
    {
      test = board[y - i];//��e��y��A�M��i��i���ˬd
      if (test == x ||//�����u
          test == x - i ||//���W��V
          test == x + i) //�k�W��V
      {
        return true;
      }
    }
 
    return false;
  }
  
 //���o�ѽL�j�p
  public static void getboardsize()
	{
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("��J�ѽL�j�pn�A4��n��8�G");
		boardSize = scanner.nextInt();
		while(boardSize<4 || boardSize>8)//���� n �S���ŦX 4��n��8
		{
			System.out.println("���ŦX����A��J�ѽL�j�pn�A4��n��8�G");
			boardSize = scanner.nextInt();
		}

	}
 
  //�L�X�ѽL
  public static void printboard() {
    System.out.println("");
    for ( y = 0; y < boardSize; y++) 
    {
      for ( x = 0; x < boardSize; x++) 
      {
    	if(board[y] == x)
    	{
    		System.out.print("1");
    		//�N�y�Цs�istack
    		coorx = Integer.toString(x+1); 
    		coory = Integer.toString(y+1);
    		stackx.push(coorx);
    		stacky.push(coory);
    	}
    	else
    		System.out.print("0");        
      }
    System.out.print("\n");//�ǳƦL�U�@��A����
    }
  }

  //�L�X�y��
  public static void printcoordinate()
	{
		System.out.print("Stack<up to bottom>:");
		for(int coorcount = 1; coorcount <= boardSize; coorcount++)
		{
			System.out.print(stacky.pop()+","+stackx.pop()+"|");
		}
	    System.out.println("");
	}
  
  //��Ѥl
  //�}�C�Ĥ@�Ӥ����q0�}�l�A�G Y �q 0�}�l
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
//����