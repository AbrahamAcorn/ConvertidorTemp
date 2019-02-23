import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

class ConverterTemp{
	public double kelAfah(double kel) {
		return ((kel-273.15)*9/5)+32;
	}
	
	public double fahAkel(double fah) {
		return ((fah-32)*5/9)+273.15;
	}
	
	public double centAfah(double cent) {
		return (cent*(9/5))+32;
	}
	
	public double fahAcent(double fah) {
		return ((fah-32)/1.8);
	}
	
	public double kelAcent(double kel) {
		return kel-273.15;
	}
	
	public double centAkel(double cent) {
		return cent+273.15;
	}

}

class Conversor extends JFrame implements ActionListener{
	JComboBox cb1,cb2;
	JTextField ent,sal;
	public Conversor() {
		getContentPane().setLayout(new FlowLayout());;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor ALV");
		setSize(240,130);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(new JLabel("Convertir:"));
		ent=new JTextField(5);
		ent.addActionListener(this);
		add(ent);
		cb1= new JComboBox();
		cb1.addItem("°Fahrenheit");
		cb1.addItem("°Celsius");
		cb1.addItem("°Kelvin");
		cb1.addActionListener(this);
		add(cb1);
		
		add(new JLabel("   A   "));
		
		cb2=new JComboBox();
		cb2.addItem("°Celsius");
		cb2.addItem("°Fahrenheit");
		cb2.addItem("°Kelvin");
		cb2.addActionListener(this);
		add(cb2);
		
		add(new JLabel(" = "));
		sal=new JTextField(5);
		add(sal);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ConverterTemp ct=new ConverterTemp();
		//double dat=Double.parseDouble(ent.getText());
		double dat=0;
		try {
			dat=Double.parseDouble( ent.getText());
		}catch(NumberFormatException e2) {
			JOptionPane.showMessageDialog(this,"Solo pudes ingresar numeros");
		}
		
		String op1=cb1.getSelectedItem().toString();
		String op2=cb2.getSelectedItem().toString();
		
	//"°Fahrenheit"
	//"°Celsius"
	//"°Kelvin"
		if(op1.equals("°Fahrenheit")&& op2.equals("°Celsius")) {
			sal.setText(String.valueOf(ct.fahAcent(dat)));
		}else if(op1.equals("°Fahrenheit")&& op2.equals("°Kelvin")) {
			sal.setText(String.valueOf(ct.fahAkel(dat)));
		}else if(op1.equals("°Fahrenheit")&& op2.equals("°Fahrenheit")) {
			sal.setText(String.valueOf(dat));
		}else if(op1.equals("°Kelvin")&& op2.equals("°Fahrenheit")) {
			sal.setText(String.valueOf(ct.kelAfah(dat)));
		}else if(op1.equals("°Kelvin")&& op2.equals("°Celsius")) {
			sal.setText(String.valueOf(ct.kelAcent(dat)));
		}else if(op1.equals("°Kelvin")&& op2.equals("°Kelvin")) {
			sal.setText(String.valueOf(dat));
		}else if(op1.equals("°Celsius")&& op2.equals("°Kelvin")) {
			sal.setText(String.valueOf(ct.centAkel(dat)));
		}else  if (op1.equals("°Celsius")&& op2.equals("°Fahrenheit")) {
			sal.setText(String.valueOf(ct.centAfah(dat)));
		}else if(op1.equals("°Celsius")&& op2.equals("°Celsius")) {
			sal.setText(String.valueOf(dat));
		}
		
	}
	
}


public class Convertidor {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Conversor cnvr=new Conversor();
			}
		});

	}

}
