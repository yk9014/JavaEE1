package game;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HitAndBlowGame game = new HitAndBlowGame(); // ランダムな正解でゲーム開始

        System.out.println("★Hit & Blow スタート（制限回数: 10回）★");
        System.out.println("重複のない4桁の数字を入力してください。");

        while (true) {
            System.out.print((game.getTurnCount() + 1) + "回目: ");
            String input = scanner.nextLine();
            //String input = args[0];

            // 判定を行う
            String result = game.guess(input);
            System.out.println("結果: " + result);

            // ゲーム終了の判定（勝敗が決まったらループを抜ける）
            if (result.contains("勝ち") || result.contains("負け")) {
                break;
            }
        }
        scanner.close();
    }
}