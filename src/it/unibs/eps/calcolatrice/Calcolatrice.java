package it.unibs.eps.calcolatrice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;

/**
 * <p>
 * Questa classe simula il funzionamento di una calcolatrice,  sia dal punto di vista grafico, che di quello funzionale.
 * Le operazioni che possono essere svolte sono le seguenti:
 * <ol>CE: cancella quanto scritto nella casella;</ol>
 * <ol>+: Dati due numeri a e b, esegue l'operazione a = a+b;</ol>
 * <ol>-: Dati due numeri a e b, esegue l'operazione a = a-b;</ol>
 * <ol>*: Dati due numeri a e b, esegue l'operazione a = a*b;</ol>
 * <ol>/: Dati due numeri a e b, esegue l'operazione a = a/b;</ol>
 * <ol>sqrt: Dato un numero a, eseque l'operazione a = sqrt(a);</ol>
 * <ol>^: Dati due numeri a e b, esegue l'operazione a = a^b;</ol>
 * <ol>%: Dati due numeri a e b, esegue l'operazione a = b% * a</ol>
 * </p>
 * @author Davide Leone - 723335
 *
 */

public class Calcolatrice extends JFrame implements ActionListener {
	
	private static final String ERROR_DIVIDE_BY_0 = "Error: divide by 0.";
	
	private final static Color OPCOLOR = new Color(63,63,63);
	private final static Color NUMCOLOR = new Color(32,32,32);
	private final static Color EQCOLOR = new Color(96,125,139);
	private final static Color TXTCOLOR = new Color(255,255,255);
	private final static Color PANELCOLOR = new Color(79,79,79);
	
	private final static Font OPFONT = new Font("Consolas", Font.BOLD, 15);
	private JLabel label;
	private String op1 = "", op2 = "", op = "";

	public Calcolatrice(String s) {
		super(s);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(350, 450);
		//Imposta la finestra NON ridimensionabile
		setResizable(false);
		
		//Imposta layout frame
		setLayout(new GridLayout(2,1));
		
		
		//Creazione pannelli
		JPanel buttonPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		
		buttonPanel.setBackground(PANELCOLOR);
		labelPanel.setBackground(PANELCOLOR);
		
		//Aggiunta pannelli al frame
		add(labelPanel);
		add(buttonPanel);
		
		//Creazione campo di testo
		label = new JLabel();
		
		label.setForeground(TXTCOLOR);
		
		//Aggiunta label al pannello di testo
		labelPanel.add(label);
		
		//Set dei layout dei pannelli
		buttonPanel.setLayout(new GridLayout(4, 5));
		
		
		//Creazione bottoni
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
		JButton bCE = new JButton("CE");
		JButton bSqrt = new JButton("sqrt");
		JButton bPow = new JButton("^");
		JButton bPercent = new JButton("%");
			
		//Aggiunta pulsanti al pannello pulsanti
		buttonPanel.add(b7);buttonPanel.add(b8);buttonPanel.add(b9);buttonPanel.add(bDiv);
		buttonPanel.add(bCE);
		buttonPanel.add(b4);buttonPanel.add(b5);buttonPanel.add(b6);buttonPanel.add(bMult);
		buttonPanel.add(bSqrt);
		buttonPanel.add(b1);buttonPanel.add(b2);buttonPanel.add(b3);buttonPanel.add(bMinus);
		buttonPanel.add(bPow);
		buttonPanel.add(b0);buttonPanel.add(bPoint);buttonPanel.add(bEqual);buttonPanel.add(bPlus);
		buttonPanel.add(bPercent);
				
		//Aggiunta listener ai pulsanti
		b0.addActionListener(this);b1.addActionListener(this);b2.addActionListener(this);
		b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
		b6.addActionListener(this);b7.addActionListener(this);b8.addActionListener(this);
		b9.addActionListener(this);bDiv.addActionListener(this);bMult.addActionListener(this);
		bMinus.addActionListener(this);bPoint.addActionListener(this);bEqual.addActionListener(this);
		bPlus.addActionListener(this);bCE.addActionListener(this);bSqrt.addActionListener(this);
		bPow.addActionListener(this);bPercent.addActionListener(this);
		
		//Imposta colore bottoni operatori
		bDiv.setBackground(OPCOLOR);bMult.setBackground(OPCOLOR);bMinus.setBackground(OPCOLOR);
		bEqual.setBackground(EQCOLOR);bPlus.setBackground(OPCOLOR);bCE.setBackground(OPCOLOR);
		bSqrt.setBackground(OPCOLOR);bPow.setBackground(OPCOLOR);bPercent.setBackground(OPCOLOR);
		
		//Imposta il colore del testo dei bottoni dgli operatori
		bDiv.setForeground(TXTCOLOR);bMult.setForeground(TXTCOLOR);bMinus.setForeground(TXTCOLOR);
		bEqual.setForeground(TXTCOLOR);bPlus.setForeground(TXTCOLOR);bCE.setForeground(TXTCOLOR);
		bSqrt.setForeground(TXTCOLOR);bPow.setForeground(TXTCOLOR);bPercent.setForeground(TXTCOLOR);
		
		//Imposta i font del testo dei bottoni degli operatori
		bDiv.setFont(OPFONT);bMult.setFont(OPFONT);bMinus.setFont(OPFONT);bEqual.setFont(OPFONT);
		bPlus.setFont(OPFONT);bCE.setFont(OPFONT);bSqrt.setFont(OPFONT);bPow.setFont(OPFONT);
		bPercent.setFont(OPFONT);
		
		//Imposta colore bottoni numeri e punto
		b0.setBackground(NUMCOLOR);b1.setBackground(NUMCOLOR);b2.setBackground(NUMCOLOR);
		b3.setBackground(NUMCOLOR);b4.setBackground(NUMCOLOR);b5.setBackground(NUMCOLOR);
		b6.setBackground(NUMCOLOR);b7.setBackground(NUMCOLOR);b8.setBackground(NUMCOLOR);
		b9.setBackground(NUMCOLOR);bPoint.setBackground(NUMCOLOR);
		
		//Imposta il colroe del testo dei bottoni numerici
		b0.setForeground(TXTCOLOR);b1.setForeground(TXTCOLOR);b2.setForeground(TXTCOLOR);
		b3.setForeground(TXTCOLOR);b4.setForeground(TXTCOLOR);b5.setForeground(TXTCOLOR);
		b6.setForeground(TXTCOLOR);b7.setForeground(TXTCOLOR);b8.setForeground(TXTCOLOR);
		b9.setForeground(TXTCOLOR);bPoint.setForeground(TXTCOLOR);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		double result = 0.0;

		if(s.equals("CE")) {
			op1 = ""; op = ""; op2 = "";
			label.setText("");
		}
		else if(isANumber(s)) {
			if(op.equals("")) {
				op1 += s;	
				label.setText(op1);
			}
			else if(!op.equals("sqrt")){
				op2 += s;
				label.setText(op1 + " " + op + " " + op2);
			}		
		}
		else if(!s.equals("=")  && !op1.equals("")){
			if(s.equals("sqrt")) {
				op = s;
				result = Math.sqrt(Double.parseDouble(op1));
				op1 = Double.toString(result);
				op = ""; op2 = "";
				label.setText(op1);
			}
			else if (s.equals(".")) {
				if(!op1.equals("") && !hasComma(op1) && op.equals("")) {
					op1 += s;
					label.setText(op1);
				}	
				else if(!op2.equals("")  && !hasComma(op2)) {
					op2 += s;
					label.setText(op1 + " " + op + " " + op2);
				}			
			}
		else {	
			op = s;
			label.setText(op1 + " " + op);
			}
		}
		
		if (s.equals("=") && !op.equals("") && !op2.equals("") && !op.equals("sqrt")) {
			
			BigDecimal bOp1 = new BigDecimal(op1);
			BigDecimal bOp2 = new BigDecimal(op2);
			
			switch(op) {
			
			case "+": 	result = bOp1.add(bOp2).doubleValue();
						op1 = Double.toString(result);
						op = ""; op2 = "";
						label.setText(op1);
						break;
			
			case "-":  	result = bOp1.subtract(bOp2).doubleValue();
						op1 = Double.toString(result);
						op = ""; op2 = "";
						label.setText(op1);
						break;		
			
			case "*": 	result = bOp1.multiply(bOp2).doubleValue();
						op1 = Double.toString(result);
						op = ""; op2 = "";
						label.setText(op1);
						break;	
						
			case "/":   try {
						result = bOp1.divide(bOp2).doubleValue();
						label.setText(op1);
						}
						catch(ArithmeticException exception) {
							label.setText(ERROR_DIVIDE_BY_0);
							op1 = "";
						}
						op1 = Double.toString(result);
							
						op = ""; op2 = "";
						break;	
						
			case "^": 	result = Math.pow(Double.parseDouble(op1), Double.parseDouble(op2));
						op1 = Double.toString(result);	
						op = ""; op2 = "";
						label.setText(op1);
						break;
						
			case "%": 	result = Double.parseDouble(op1) / 100 * Double.parseDouble(op2);
						op1 = Double.toString(result);
						op = ""; op2 = "";
						label.setText(op1);
						break;
			}
		}
			
	}
	

	/**
	 * <p>
	 * Verifica se il parametro stringa e' un numero.
	 * </p>
	 * @param s
	 * @return True se il parametro stringa e' convertivile in un double, False altrimenti.
	 */
	private boolean isANumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * <p>
	 * Verifica se il parametro stringa contiene il carattere punto.
	 * </p>
	 * @param s
	 * @return True se il parametro stringa contiene il carattere punto, False altrimenti.
	 */
	private boolean hasComma(String s) {
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) == '.')
				return true;
		
		return false;
			
	}

	

	
	
	
	
}
