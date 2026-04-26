/************************************
外部から、数字の入力を受け付けて、
奇数か偶数かを判定するサンプル
************************************/
package janken;

//import文。Scannerの機能を呼び出すために必要
import java.util.Scanner;

//クラス宣言。クラス名はScannerSample
public class ScannerSample{
	
    public static void main(String[] args) {
		//Scannerの機能を使うための宣言
	    Scanner scanner = new Scanner(System.in);
		//画面にメッセージを出力
		System.out.println("半角で数字を入力してください。");
    	
		//入力された数値を、int型の変数numberに格納
		int number = scanner.nextInt();

		//画面にメッセージを出力
		System.out.print("あなたの入力した数字は"+number);

		if(number%2 == 0){
			System.out.println("で、偶数です。");
		}else{
			System.out.println("で、奇数です。");
		}
    
   	scanner.close();
	}
	
}