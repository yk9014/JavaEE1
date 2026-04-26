/************************************
外部から、数字の入力を受け付けて、
じゃんけん勝負をするサンプル
************************************/
package janken;

import java.util.Scanner;
import java.util.Random;

public class Janken {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 選択肢を表示
        System.out.println("じゃんけんをしましょう！");
        System.out.println("0: グー, 1: チョキ, 2: パー");
        System.out.print("あなたの手を選んでください: ");
        
        // ユーザーの入力を取得
        int userChoice = scanner.nextInt();
    	//int userChoice = Integer.parseInt(args[0]);

        // コンピュータの手をランダムに選択
        int computerChoice = random.nextInt(3);

        // 手の名前を配列で管理
        String[] hands = {"グー", "チョキ", "パー"};

        // 選択した手を表示
        System.out.println("あなたの手: " + hands[userChoice]);
        System.out.println("コンピュータの手: " + hands[computerChoice]);

        // 勝敗を判定
        if (userChoice == computerChoice) {
            System.out.println("結果: あいこです！");
        } else if ((userChoice == 0 && computerChoice == 1) || 
                   (userChoice == 1 && computerChoice == 2) || 
                   (userChoice == 2 && computerChoice == 0)) {
            System.out.println("結果: あなたの勝ちです！");
        } else {
            System.out.println("結果: あなたの負けです！");
        }

        scanner.close();
    }
	
	public static String janken(int number){
		String result = null;
		Random random = new Random();

        // ユーザーの入力を取得
        int userChoice = number;
    	//int userChoice = Integer.parseInt(args[0]);

        // コンピュータの手をランダムに選択
        int computerChoice = random.nextInt(3);

        // 手の名前を配列で管理
        String[] hands = {"グー", "チョキ", "パー"};

        // 選択した手を表示
        result = "あなたの手: " + hands[userChoice] + "<br>";
        result = result + "コンピュータの手: " + hands[computerChoice] + "<br>";

        // 勝敗を判定
        if (userChoice == computerChoice) {
            result = result + "結果: あいこです！" + "<br>";
        } else if ((userChoice == 0 && computerChoice == 1) || 
                   (userChoice == 1 && computerChoice == 2) || 
                   (userChoice == 2 && computerChoice == 0)) {
            result = result + "結果: あなたの勝ちです！" + "<br>";
        } else {
            result = result + "結果: あなたの負けです！" + "<br>";
        }


		return result;

	}
	
	
}
