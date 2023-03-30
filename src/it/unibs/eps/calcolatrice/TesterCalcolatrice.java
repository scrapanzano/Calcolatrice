package it.unibs.eps.calcolatrice;

import javax.swing.JFrame;

public class TesterCalcolatrice {

	public static void main(String[] args) {
		
		Calcolatrice c = new Calcolatrice("Calcolatrice");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);

	}

}
