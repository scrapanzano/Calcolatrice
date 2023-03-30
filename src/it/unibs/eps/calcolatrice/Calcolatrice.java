package it.unibs.eps.calcolatrice;

import java.awt.*;
import javax.swing.*;

/*
  	Creare una Calcolatrice utilizzando Java Swing con le operazioni di base: 
  	addizione, sottrazione, moltiplicazione, divisione, elevamento a potenza 
  	e percentuale.
  	Per rendere lo sviluppo più semplice e concentrarsi sulla parte grafica, 
  	la calcolatrice potrà effettuare un’operazione per volta.

	(Suggerimento) Per eseguire calcoli con numeri molto grandi 
	(che superano i limiti dei dati primitivi long e double) si 
	possono usare le classi BigInteger e BigDecimal della libreria java.math. 
	In questo caso, i calcoli però non si possono usare i normali 
	operatori aritmetici ma bisogna utilizzare i metodi 
	add(), subtract(), multiply() e divide()).
*/

public class Calcolatrice extends JFrame{

	public Calcolatrice(String s) {
		super(s);
		
		setSize(400, 500);
		
		setLayout(new GridLayout(2, 1));
		
		//Creazione campo di testo
		JLabel label = new JLabel();
		//Aggiunta label al pannello di testo
		add(label);	
		
		//Creazione pannelli
		JPanel buttonPanel = new JPanel();
		
		add(buttonPanel);
		
		//Set dei layout dei pannelli
		buttonPanel.setLayout(new GridLayout(4, 4));
		
		
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bDiv = new JButton("/");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bMult = new JButton("*");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bMinus = new JButton("-");
		JButton b0 = new JButton("0");
		JButton bPoint = new JButton(".");
		JButton bEqual = new JButton("=");
		JButton bPlus = new JButton("+");
		
		buttonPanel.add(b7);
		buttonPanel.add(b8);
		buttonPanel.add(b9);
		buttonPanel.add(bDiv);
		buttonPanel.add(b4);
		buttonPanel.add(b5);
		buttonPanel.add(b6);
		buttonPanel.add(bMult);
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(bMinus);
		buttonPanel.add(b0);
		buttonPanel.add(bPoint);
		buttonPanel.add(bEqual);
		buttonPanel.add(bPlus);
		
	}
	
	
	
}
