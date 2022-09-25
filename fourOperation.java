import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class fourOperation {
    static ArrayList<String> formulas = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("请输入算式数目：");
        Scanner sc = new Scanner(System.in);
//        String difficuty = sc.nextLine();
        BufferedWriter w1 = new BufferedWriter(new FileWriter("Exercises.txt"));
        BufferedWriter w2 = new BufferedWriter(new FileWriter("Answers.txt"));
        int num = sc.nextInt();

        for(int i=0;i<num;i++){
            printOperation("简单");
        }
        for(int i=0;i<formulas.size();i++){
            int j=i+1;
            w1.write(j+". "+formulas.get(i)+"=");
            w1.newLine();
        }
        for(int i=0;i<answers.size();i++){
            int j=i+1;
            w2.write(j+". "+answers.get(i));
            w2.newLine();
        }
        w1.close();
        w2.close();
    }
    public static void printOperation(String difficuty) throws IOException {
        Random r = new Random();
        String formula="";
        if(difficuty.equals("简单")) {
            int s = r.nextInt(2)+1;
            int lastNum=r.nextInt(99)+1;
            formula+=lastNum;
            int temp ;
            for(int i=0;i<2;i++){
                switch (s){
                    case 1:temp=intPlus(lastNum,99,difficuty);lastNum+=temp;formula+="+"+ temp;break;
                    case 2:temp=intSubtract(lastNum,99,difficuty);lastNum-=temp;formula+="-"+ temp;break;
                }
                if(lastNum<=0||lastNum>=100){
                    i=-1;
                    lastNum = r.nextInt(9)+1;
                    formula=String.valueOf(lastNum);
                }
                s=r.nextInt(2)+1;
            }
            answers.add(lastNum);
            formulas.add(formula);

        }
    }

    public static int intPlus(int lastNum,int bound,String difficuty){
        Random r = new Random();
        return r.nextInt(bound)+1;
    }
    public static int intSubtract(int lastNum,int bound,String difficuty){
        Random r = new Random();
        int newNum =r.nextInt(bound)+1;
        return newNum;
    }
    public static int intMulti(int lastNum, int bound,String difficuty){
        Random r = new Random();
        return r.nextInt(bound)+1;
    }
    public static int intDivi(int lastNum, int bound,String difficuty){
        Random r = new Random();
        int newNum  = r.nextInt(bound)+2;
        return newNum;
    }
}
//两种风格的题目：一种是单纯的四则运算，一种是混合的四则运算
//采用随机生成第一个操作数，后面用函数生成字符串“运算符+操作数”进行拼接，最后打印算式
//可以分简单和中等难度
//简单难度操作数不大于10，除法没有余数，减法没有负数
//中等难度有负数、余数，操作数10~100