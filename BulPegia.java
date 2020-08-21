
import java.util.*;
    public class BulPegia
{
    static Scanner reader=new Scanner (System.in);
     public static int level() //פעולה הקולטת מהשמתמש באיזה רמה הוא ירצה לשחק
     {
         System.out.println("Choose level: 1=easy, 2=intermediate, 3=hard ");
         int level=reader.nextInt();
         int size=level+3;
         return(size);
  }
     
     public static boolean exist(int[]computer,int num)//פעולה הבודקת אם ספרה שהיא מקבלת קיימת במערך שהיא מקבלת
     {
         for(int j=0;j<computer.length;j++)
        {
           if(computer[j]==num)
           {
            return true;
            }
        } 
            return false;
     }
     
      public static int[] computer(int size)//פעולה המגרילה מספרים מ0 עד 9 למערך בגודל מבוקש 
     {
       int[]computer=new int[size];
       for(int i=0;i<computer.length;i++)
        {
            computer[i]=-1;
            //איפוס המערך ב-1כדי שהפעולה existתאפשר ליצור את המספר 0 כי כך המספר לא יהיה קיים במערך
        }
       for(int i=0;i<computer.length;i++)
        {
          int num=(int)(Math.random() * 10);
          while (exist(computer,num)==true){
              num=(int)(Math.random() * 10);
            }
          
          computer[i]=num;
        }
        //To have an easier time checking ;)
        //System.out.println("Answer is: ");
       // for(int i=0;i<computer.length;i++)
        //{ System.out.println(computer[i]);
        // }
        return computer;

     }
     public static char[] checker(int[]computer,int[] answer, int size)//פעולה הבודקת אם התשובה נכונה ומחזירה מערך עם תוים בהתאם
     {
         char[]checker=new char[size]; 
       for(int i=0;i<answer.length;i++)
        {
          if (computer[i]==answer[i])
          checker[i]='x';
         else
         if(exist(computer, answer[i]))
         checker[i]='0';  
         else
         checker[i]='-';
            
        }
        return checker;
     }
      public static int[] answer(int size)//פעטלה הקולטת את התשובה למערך
     {
         int count=1;
         int[]answer=new int[size];
       for(int i=0;i<size;i++)
        {
          System.out.println("Enter  unit number "+count+" out of "+size);
          answer[i]=reader.nextInt();
          count++;
        }
        return answer;

     }
     public static void print (char[] checker){//פעולה המדפיסה תוים לפי התשובה
     System.out.println(" ");

         for (int i=0;i<checker.length;i++)
         {
             System.out.print(checker[i]);

            }
         System.out.println(" ");

        } 
     public static int WinCheck (char[] checker,int round, int size){//פעולה הבודקת אם ניצחת במשחק ומחזירה ערך לסבב בהתאם, אם לא ניצחת הערך לא ישתנה, ואם כן ניצחת הערך יהיה -1 ולכן המשחק יסתיים
         int x=1;
         for (int i=0;i<checker.length;i++){
             if (checker[i] != 'x') {
                 x = 0;
                 break;
             }
            }
          if(x==1){
           System.out.println("You won!!!");
           return round=-1;
        }
        return round;
    }
    
    public static boolean playAgain(){//תוספת שלי: פעולה הבודקת אם תרצה לשחק שוב
    System.out.println("Do you want to play again? (true or false) ");
    boolean again=reader.nextBoolean();    
    return again;    
    }
    
    public static void main (String[]args)//מחלקה ראשית, המפעילה את הפעולות
    {
       boolean play=true;
       while(play){
       int Game=1;
       int round = 1;
       int size= level();
       int[]computer= computer(size);
       System.out.println("You are in game number "+ Game);
       System.out.println("Enter each unit one after the other!");
       while (round!=-1){
       System.out.println("You are in round number "+ round);
       int[]answer= answer(size);
       char[]checker= checker(computer,answer,size);
       System.out.println("You got: " );
       print(checker);
       round++;
       round= WinCheck(checker,round,size);  
       //System.out.println("round: "+round );

       if (round==-1)
       play=playAgain();
       if (!play)
       System.out.println("Nice game, bye!");    
           
    }
        Game++;
    }
        }
    }
