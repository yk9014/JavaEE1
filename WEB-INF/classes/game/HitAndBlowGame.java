package game;

import java.util.Random;

public class HitAndBlowGame {
    private final String answer; // 正解を入れておく
    private int turnCount; // ターンの回数
    private static final int MAX_TURNS = 10;// ゲームの制限回数（１０回）

    // コンストラクタ：同時にランダムで4桁の重複なしの正解を生成（本番用）
    public HitAndBlowGame() {
        this.answer = generateRandomAnswer();
        this.turnCount = 0;
    }

    // コンストラクタ：テスト用に任意の正解を指定可能なコンストラクタ
    public HitAndBlowGame(String answer) {
        this.answer = answer;
        this.turnCount = 0;
    }

    // プレイヤーの予想入力を受け取り、判定結果を文字列で返す

    public String guess(String input) {
        // 入力バリデーション 半角英数で４文字だけを受け付ける
        if (input == null || input.length() != 4) {
            return "4桁の数値を入力してください。";
        }

        // ゲームカウンタのインクリメントと、出力文字列の初期化
        turnCount++;
        int hit = 0;
        int blow = 0;

        // Hit & Blow の判定ロジック 入力文字を１文字ずつ判定
        for (int i = 0; i < 4; i++) {
            char inputChar = input.charAt(i);// 入力値のi文字目を一文字取り出しセット
            if (inputChar == answer.charAt(i)) {// 答えのi文字目とマッチするか判定
                hit++; // マッチすればヒット
            } else if (answer.contains(String.valueOf(inputChar))) {
                blow++; // Stringのcontains()メソッドを使って含まれていればblowをインクリメント
            }
        }

        // 判定結果の分岐
        if (hit == 4) {// 勝ち抜けの判定
            return "正解、あなたの勝ちです";
        }

        if (turnCount >= MAX_TURNS) {// 制限ターン(１０）を超えていないかの判定
            return "負け、正解は" + answer + "です";
        }

        // 勝ちでも負けでもなければhit blowの数を返す
        return hit + "Hit " + blow + "Blow";
    }

    // getter類（Servletなどで状態を表示したい場合用のために一応書いておく）
    public int getTurnCount() {
        return turnCount;
    }

    public boolean isGameOver() {
        return turnCount >= MAX_TURNS;
    }

    // 4桁の重複のないランダムな数字を生成
    private String generateRandomAnswer() {
        Random random = new Random(); // Randomのインスタンス化
        StringBuilder sb = new StringBuilder(); // 今回はStringよりStringBuilder()が使いやすい
        while (sb.length() < 4) { // ４文字になるまでループ
            // １０未満の数をRandom生成して、Stringにして変数に格納
            String num = String.valueOf(random.nextInt(10));
            // StringBuiderの中に同じ数値文字列がないかチェック。OKなら追加。
            if (!sb.toString().contains(num)) {
                sb.append(num);
            }
        }
        // ４文字分作れたらリターン
        return sb.toString();
    }
}