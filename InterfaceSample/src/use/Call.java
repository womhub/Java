package use;

import used.AddCalc;
import used.SubCalc;
import used.Calculator;
//インターフェース依存を確認するためのクラス

public class Call {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new AddCalc(); //インターフェース型の変数に代入
		int result = calculator.calc(10,5);
		System.out.println("計算結果は「" + result + "」です！");
	}
}
