package sec02.ex01;

import java.sql.Date;

public class CalcBean {
	private int n1;
	private String nn;
	private int n2;
	private long result;

	public CalcBean() {
		
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public String getNn() {
		return nn;
	}


	public void setNn(String nn) {
		this.nn = nn;
	}
	
	public long getResult() {
		return result;
	}
	
	public void setResult(long result) {
		this.result = result;
	}

	public long getSum() {
		
		switch (nn) {
		case "+": result = n1 + n2; break;
		case "-": result = n1 - n2; break;
		case "*": result = n1 * n2; break;
		case "/": result = n1 / n2; break;
	}
		
		return result;
	}

	
}
