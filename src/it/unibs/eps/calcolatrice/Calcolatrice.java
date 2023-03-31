package it.unibs.eps.calcolatrice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Calcolatrice extends JFrame implements ActionListener{
	
	private static final String ERROR_DIVIDE_BY_0 = "Error: divide by 0.";
	private final static Color OPCOLOR = new Color(212, 175,55);
	private JLabel label;
	private String op1 = "", op2 = "", op = "";

	public Calcolatrice(String s) {
		super(s);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 350);
		//Imposta la finestra NON ridimensionabile
		setResizable(false);
		
		//Imposta layout frame
		setLayout(new BorderLayout());
		
		
		
		//Creazione pannelli
		JPanel buttonPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		
		//Aggiunta pannelli al frame
		add(labelPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		
		//Creazione campo di testo
		label = new JLabel();
		//Aggiunta label al pannello di testo
		labelPanel.add(label);
		
		//Set dei layout dei pannelli
		buttonPanel.setLayout(new GridLayout(4, 4));
		
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
		JButton bPow = new JButton("pow");
		JButton b = new JButton("<>");
		
		//Aggiunta pulsanti al pannello pulsanti
		buttonPanel.add(b7);buttonPanel.add(b8);buttonPanel.add(b9);buttonPanel.add(bDiv);
		buttonPanel.add(bCE);
		buttonPanel.add(b4);buttonPanel.add(b5);buttonPanel.add(b6);buttonPanel.add(bMult);
		buttonPanel.add(bSqrt);
		buttonPanel.add(b1);buttonPanel.add(b2);buttonPanel.add(b3);buttonPanel.add(bMinus);
		buttonPanel.add(bPow);
		buttonPanel.add(b0);buttonPanel.add(bPoint);buttonPanel.add(bEqual);buttonPanel.add(bPlus);
		buttonPanel.add(b);
		
		//Aggiunta listener ai pulsanti
		b0.addActionListener(this);b1.addActionListener(this);b2.addActionListener(this);
		b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
		b6.addActionListener(this);b7.addActionListener(this);b8.addActionListener(this);
		b9.addActionListener(this);bDiv.addActionListener(this);bMult.addActionListener(this);
		bMinus.addActionListener(this);bPoint.addActionListener(this);bEqual.addActionListener(this);
		bPlus.addActionListener(this);bCE.addActionListener(this);bSqrt.addActionListener(this);
		bPow.addActionListener(this);
		
		//Imposta colore bottoni operatori
		bDiv.setBackground(OPCOLOR);bMult.setBackground(OPCOLOR);bMinus.setBackground(OPCOLOR);
		bEqual.setBackground(OPCOLOR);bPlus.setBackground(OPCOLOR);bCE.setBackground(Color.red);
		bSqrt.setBackground(OPCOLOR);bPow.setBackground(OPCOLOR);b.setBackground(OPCOLOR);
		
		//Imposta font dei bottoni operatori
		bDiv.setFont(new Font("Serif", Font.BOLD, 24));bMult.setFont(new Font("Serif", Font.BOLD, 24));
		bMinus.setFont(new Font("Serif", Font.BOLD, 24));bEqual.setFont(new Font("Serif", Font.BOLD, 24));
		bPlus.setFont(new Font("Serif", Font.BOLD, 24));
		
		//Imposta font dei bottoni numeri e bottone punto
		b0.setFont(new Font("Serif", Font.ITALIC, 24));b1.setFont(new Font("Serif", Font.ITALIC, 24));
		b2.setFont(new Font("Serif", Font.ITALIC, 24));b3.setFont(new Font("Serif", Font.ITALIC, 24));
		b4.setFont(new Font("Serif", Font.ITALIC, 24));b5.setFont(new Font("Serif", Font.ITALIC, 24));
		b6.setFont(new Font("Serif", Font.ITALIC, 24));b7.setFont(new Font("Serif", Font.ITALIC, 24));
		b8.setFont(new Font("Serif", Font.ITALIC, 24));b9.setFont(new Font("Serif", Font.ITALIC, 24));
		bPoint.setFont(new Font("Serif", Font.ITALIC, 24));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		double result = 0.0;
	
		switch(s) {
		
		case "+": 	if(op.equals("") && !op1.equals("")) {
						op = s;
						label.setText(op1 + " " + op);
					}
				  	break;
				 
		
		case "-": 	if(op.equals("") && !op1.equals("")) {
					op = s;
					label.setText(op1 + " " + op);
					}
					break; 		  	
				  	
		case "*": 	if(op.equals("") && !op1.equals("")) {
						op = s;
						label.setText(op1 + " " + op);
					}
		  			break;
		
		case "/": 	if(op.equals("") && !op1.equals("")) {
						op1 = s;
						label.setText(op1 + " " + op);
					}
  					break;
		case "CE": 	op1 = ""; op = ""; op2 = "";
					label.setText("");
					break;
					
		case "sqrt": if(op.equals("") && !op1.equals("")) {
						op = s;
					}
			
					break;
  				
		case ".": 	/*	TODOif(op.equals("") && !op1.equals("")) {
						op = s;
						op1 += op;
						label.setText(op1);
					}*/
					break;
					
		  			
		case "=":   if(!op.equals("")) {
					switch(op) {
					case "+": 	result = Double.parseDouble(op1) + Double.parseDouble(op2);
								op1 = Double.toString(result); op = ""; op2 = "";
								label.setText(op1);
								break;
					
					case "-": 	result = Double.parseDouble(op1) - Double.parseDouble(op2);
								op1 = Double.toString(result); op = ""; op2 = "";
								label.setText(op1);
								break;
								
					case "*":	result = Double.parseDouble(op1) * Double.parseDouble(op2);
								op1 = Double.toString(result); op = ""; op2 = "";
								label.setText(op1);
								break;
								
					case "/": 	result = Double.parseDouble(op1) / Double.parseDouble(op2);
								op1 = Double.toString(result); 
								if(op1.equals("Infinity")) {
									label.setText(ERROR_DIVIDE_BY_0);
									op1 = ""; op = ""; op2 = "";
								}
								else {
									label.setText(op1);
									op = ""; op2 = "";
								}
											
								break;
								
					case "sqrt": 	result = Math.sqrt(Double.parseDouble(op1));
									op1 = Double.toString(result); 
									label.setText(op1);
									op = ""; op2 = "";
									break;
					}
					}
					break; 	
					
		/*Se l'utente non ha schiacciato nessun tasto riferito ad una operazione aritmetica,
		 *  imposto gli operatori.
		 */ 
		default: 
				if(op1.equals("") && op.equals("")) {
					op1 = s;
					label.setText(op1);
				}
				else if(!op1.equals("") && !op.equals("") && op2.equals("") && !s.equals(".")) {
					op2 = s;
					label.setText(op1 + " " + op + " " + op2);
				}					
		}	
			
	}
	
	
	
}
