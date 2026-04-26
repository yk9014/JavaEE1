/************************************
外部から、数字の入力を受け付けて、
さいころの目を当てるサンプル
************************************/
package janken;

//import文。Scannerの機能を呼び出すために必要
import java.util.Scanner;
import java.util.Random;

//クラス宣言。クラス名はScannerSample
public class Dice{
	
    public static void main(String[] args) {
		//ScannerとRandomの機能を使うための宣言
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
    	
    	System.out.println("さて、賽の目はいくつだと思いますか？");
		
    	// ユーザーの入力を取得
		int userNumber = scanner.nextInt();
		
		// コンピュータのダイスの出目をランダムに選択
		int computerChoice = random.nextInt(6);    	
		//このままだと出目が０～５になるのでインクリメント
		computerChoice++;
		
		//画面にメッセージを出力
		System.out.println("賽の目は"+computerChoice+"　あなたの読みは"+userNumber);

    	String[] loser={
    	"大外れ。読みの才能なし。","ダメだ、引き弱いわぁ","当てる気ある？","もう帰りなさいよ。",
    	"悲しいぐらい運がないね。","悪いことは言わない。もうやめときな",
    	"あんたのせいで埼京線が遅延するんだよ","税金払わない奴は道路歩くな"	
    	};
    	
    	//勝敗判定
		if(computerChoice==userNumber){
			System.out.println("読みは的中！あなたの勝ちです！");
		}else{
			System.out.println("残念ながらあなたの負けです。");
			//オプション、上で宣言した配列からランダムにメッセージを読み込む。
			System.out.println(loser[random.nextInt(loser.length)]);
		}
    	scanner.close();
    }
	
}