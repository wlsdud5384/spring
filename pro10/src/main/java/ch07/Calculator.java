package ch07;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc1")
public class Calculator {
	private int n1;
	private int n2;
	private String op;
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
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public long clac() {
		long result = 0;
		switch(op) {
		case "+": result = n1+n2; break;
		case "-": result = n1+n2; break;
		case "*": result = n1+n2; break;
		case "/": result = n1+n2; break;
		}
		return result;
	}
	
	
	
	
	
}