package lesson_2026_04_03.homework;
import java.util.*;

//1.1 Ստեղծել Point դասը, որը կունենա է  x , y  դաշտերը և  2 կամ ավել կոնստրուկտորներ։
//Առաջին կոնստրուկտորը ստանալով երկու պարամետրեր համապատասխան  x , y  դաշտերին վերագրում է այդ պարամետրերը։
//Երկրորդ կոնստրուկտորը ստանալով  Point տիպի մեկ պարամետր վերագրում է x , y դաշտերին ։
//Նաև ստեղծում ենք  printPoint ֆունկցիան , որը տպում է կետի արժեքները և  printEqual  ֆունկցիաները ,որը ստուգում է երկու կետերի(այդ կետերից մեկը ընթացիկ կետն է) հավասարությունը:
//main -ում ստեղծում ենք  մի քանի օբյեկտ Point դասից ՝  point1,point2, ….։ 
class point
{
    double x,y;

    point(double inputx, double inputy)
    {
        x=inputx;
        y=inputy;
    }

    point(double inputxy){
        x=inputxy;
        y=inputxy;
    }

    void printPoint()
    {
        System.out.println("x = " + x + "   " + "y = " + y);
    }

    boolean printEquals(point p2)
    {
        if(x==p2.x && y==p2.y) {
            return true;
        }
        return false;
    }

//1.2 Point դասում  ստեղծում ենք  quarterPrint և distancePoint ֆունկցիաները ։ Առաջին quarterPrint ֆունկցիան տպում է թե , որ քառորդում է գտնվում տվյալ կետը։ Երկրորդ distancePoint  ֆունկցիան 	ստանալով Point տիպի պարամետր   վերադարձնում է ընթացիկ օբյեկտի և այդ պարամետրի միջև հեռավորությունը (երկու կետերի միջև հեռավորությունը)։
//main -ում  point1-ի համար  կանչում ենք quarterPrint-ը և distancePoint-ը(այստեղ,  որպես պարամետր տալիս ենք point2-ը) :

    int quarterPrint(){
        if(x>0 && y>0){
            return 1;
        }
        else if(x<0 && y>0){
            return 2;
        }
        else if(x<0 && y<0){
            return 3;
        }
        else{
            return 4;
        }
    }

    double distancePoint(point p2)
    {
        return Math.sqrt((p2.x-x)*(p2.x-x)+(p2.y-y)*(p2.y-y));
    }

//1.3 Point  դասում հայտարարում ենք bigPoint  ֆունկցիան,որը ընթացիկ  օբյեկտի   x ,y դաշտերը  բազմապատկում է 4-ով և նոր Point տիպի օբյեկտ ստեղծում  և վերադարձնում։ main -ում  point3-ին վերագրում ենք point1․bigPoint ()-ը և տպում։

    point bigPoint()
    {
        return new point(4 * x, 4 * y);
    }

//1.4 Point դասում հայտարարում ենք  minDistance ֆունկցիան,որը ընդունում է   Point դասի զանգված և արտածում  այն կետը, որը ամենամոտն է  (0,0 ) սկզբնակետին :
//	main -ում  ստեղծում ենք Point դասի   5 էլեմենտանոց զանգված, վերագրում 5 օբյեկտ և գնտում սկզբնակետի ամեանմոտ կետին:

    point minDistance(point[] pointarr)
    {
        point startpoint = new point(0,0);
        double mindist = pointarr[0].distancePoint(startpoint);
        point minpoint = pointarr[0];
        for(int i=1;i<pointarr.length;i++){
            double dist=pointarr[i].distancePoint(startpoint);
            if(dist<mindist){
                mindist=dist;
                minpoint=pointarr[i];
            }
        }
        return minpoint;
    }

    //1.5 Ստեղծում  ենք   sameLine    բուլիան  ֆունկցիան ,որը ստուգում է արդյոք տրված երկու կետը(այդ կետերից մեկը ընթացիկ կետն է)  գտնվում են  նույն ուղղի վրա :
    boolean sameLine(point p2)
    {
        if(y==p2.y) {
            return true;
        }
        return false;
    }

    //1.6 Ստեղծել մեթոդ՝ isTriangle(Point a, Point b, Point c) , որը կստուգի  արդյոք  երեք կետերով  կազմվում է եռանկյուն թե ոչ:
    boolean isTriangle(point p1, point p2, point p3){
        double d1 = p1.distancePoint(p2);
        double d2 = p1.distancePoint(p3);
        double d3 = p2.distancePoint(p3);
        if(d1+d2>d3 && d1+d3>d2 && d2+d3>d1){
            return true;
        }
        return false;
    }

    //1.7 Գտնել տրված երեք կետերով եռանկյան մակերեսը։
    double triangleArea(point p1, point p2, point p3) {
        double a = p1.distancePoint(p2);
        double b = p2.distancePoint(p3);
        double c = p3.distancePoint(p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    //1․8 Ստեղծել մեթոդ՝ midPoint(Point other) , որը վերադարձնում է միջնակետը տվյալ կետի և փոխանցված կետի միջև։
    point midPoint(point other){
        return new point((other.x+x)/2,(other.y+y)/2);
    }

    //1․9 Ստեղծել մեթոդ՝ isInsideCircle(Point center, double radius) , որը  ստուգում է՝ արդյոք ընթացիկ կետը գտնվում է տրված շրջանի ներսում թե ոչ։
    boolean isInsideCircle(point center, double radius){
        if(x>center.x-radius && x<center.x+radius && y>center.y-radius && y<center.y+radius){
            return true;
        }
        return false;
    }

    //1.10 Գրել մեթոդ որը ընդունում է Point[] զանգված և վերադարձնում է այն կետերի ամենամեծ քանակը, որոնք ընկած են նույն ուղիղի վրա։
    int maxcountonsameline(point[] pointarr)
    {
        boolean arr[] = new boolean[pointarr.length];
        for(int i=0;i<pointarr.length;i++){
            arr[i]=false;
        }
        int maxcount = 0;
        for(int i=0;i<pointarr.length;i++){
            if(arr[i]!=true) {
                int count = 1;
                for (int j = i+1; j < pointarr.length; j++) {
                    if(pointarr[i].sameLine(pointarr[j])){
                        arr[i]=true;
                        count++;
                    }
                }
                if(count>maxcount){
                    maxcount=count;
                }
            }
        }
        return maxcount;
    }
}

//2․1 Ստեղծել Vector դասը, որը կազմված  կլինի երկու կետից՝ start և end (երկուսն էլ Point տիպի) ,  կոնստրուկտորից և վեկտորի տվյալները տպող մեթոդից։

class vector
{
    point start, end;

    vector(point inputstart, point inputend)
    {
        start = inputstart;
        end = inputend;
    }

    void printVector()
    {
        System.out.print("start - ");
        start.printPoint();
        System.out.println("end - ");
        end.printPoint();
    }

//2․2 Ստեղծել մեթոդ, որը վերադարձնում է վեկտորի երկարությունը։

    double vectorlenght()
    {
        return start.distancePoint(end);
    }

//2․3 Ստուգել արդյոք երկու վեկտորներ զուգահեռ են թե ոչ։

    double slope()
    {
        return (end.y-start.y)/(end.x-start.x);
    }

    boolean parallel(vector v){
        if(this.slope()==v.slope()){
            return true;
        }
        return false;
    }

//2․4 Գտնել երկու վեկտորի սկալյար արտադրյալը։

    double scalarproduct(vector v2)
    {
        double v1x = this.end.x - this.start.x;
        double v1y = this.end.y - this.start.y;
        double v2x = v2.end.x - v2.start.x;
        double v2y = v2.end.y - v2.start.y;
        return v1x*v2x + v1y*v2y;
    }

//2․5 Գտնել երկու վեկտորների կազմած անկյունը։

    double findingangle(vector v2)
    {
        double v1x = this.end.x - this.start.x;
        double v1y = this.end.y - this.start.y;
        double v2x = v2.end.x - v2.start.x;
        double v2y = v2.end.y - v2.start.y;
        return (v1x*v2x + v1y*v2y)/(this.vectorlenght()*v2.vectorlenght());
    }

//2․6 Գտնել երկու վեկտորի գումարումը։

    vector vectorsum(vector v2)
    {
        double v1x = this.end.x - this.start.x;
        double v1y = this.end.y - this.start.y;
        double v2x = v2.end.x - v2.start.x;
        double v2y = v2.end.y - v2.start.y;

        point newStart = this.start;
        point newEnd = new point(
                newStart.x + v1x + v2x,
                newStart.y + v1y + v2y
        );

        return new vector(newStart, newEnd);
    }

//2․7 Ստեղծել մեթոդ , որը ընդունում է վեկտորների զանգված  և  տպում  ամենաերկար վեկտորի տվյալները։

    vector maxlengthinarr(vector[] arr){
        double maxlength = arr[0].vectorlenght();
        vector maximum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i].vectorlenght()>maxlength){
                maxlength=arr[i].vectorlenght();
                maximum=arr[i];
            }
        }
        return maximum;
    }

}



public class hmw {
    static void main(String[] args) {
        point p1 = new point(1,2);
        point p2 = new point(1,2);
        point pditancetest = new point(-5);
        System.out.println(p1.printEquals(p2));
        System.out.println(p2.quarterPrint());
        System.out.println(p2.distancePoint(pditancetest));
        point p3 = p1.bigPoint();
        p3.printPoint();
        point[] arr = {
                new point(1,2),
                new point(3,3),
                new point(4,4),
                new point(-1),
                new point(4)
        };
        point minpoint = p1.minDistance(arr);
        minpoint.printPoint();
        System.out.println(p3.maxcountonsameline(arr));

        vector v1 = new vector(new point(0,0),new point(10,10));
        vector v2 = new vector(new  point(0,0),new point(15,15));
        System.out.println(v1.parallel(v2));
    }
}

