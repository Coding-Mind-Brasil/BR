package calculator;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Script implements ActionListener {
	private CalculatorApp context;
	private String displayText;
	
	public Script(CalculatorApp context) {
		if(this.context == null)
			this.context = context;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setNumber(e.getActionCommand());
		setOperator(e.getActionCommand());
		setResult(e.getActionCommand());
		reset(e.getActionCommand());
		setDisplayText(e.getActionCommand());
		context.setDisplay(displayText);
		
		System.out.println("====================================");
		System.out.println("FNumber  => " + context.numberOne);
		System.out.println("Operator => " + context.operator);
		System.out.println("SNumber  => " + context.numberTwo);
		System.out.println("Result   => " + context.result);
		System.out.println("====================================");
		
	}
	
	private void setDisplayText(String actionCommand) {
		displayText =  (context.display.getText().equals("0") ? "" : context.display.getText());
		displayText = (actionCommand.matches("[0-9.]")?displayText+actionCommand:displayText);
		if(context.numberOne.length()!= 0 && context.operator == null && context.numberTwo.length() == 0)
			displayText = context.numberOne.toString();
		else if(context.numberOne.length()!=0 && context.operator != null && context.numberTwo.length() == 0){
			displayText = context.operator;
		}else {
			displayText = "";
			displayText = context.numberTwo.toString();
		}
	} 
	
	private void setNumber(String actionCommand) {
		if(!actionCommand.matches("^([0-9.]+)$"))
			return;
		if(context.operator == null || context.operator.isBlank() || context.operator.isEmpty())
			setNumberOne(actionCommand);
		else
			setNumberTwo(actionCommand);
	}
	
	private void setNumberOne(String value) {
		context.numberOne.append(value);
	}
	private void setNumberTwo(String value) {
		context.numberTwo.append(value);
	}
	
	private void setOperator(String value) {
		if(!value.matches("([+|\\-|/|x|%])"))
			return;
		if(context.numberOne.length() == 0  && context.numberTwo.length() == 0 )
			return;
		context.operator = value;
	}
	
	public Double sum(Double numberOne, Double numberTwo) {
		return (numberOne+numberTwo);
	}
	public Double sub(Double numberOne, Double numberTwo) {
		return  (numberOne-numberTwo);
	}
	public Double mult(Double numberOne, Double numberTwo) {
		return  (numberOne*numberTwo);
	}
	public Double div(Double numberOne, Double numberTwo) {
		return  (numberOne/numberTwo);
	}
	
	public void setResult(String value){
		if(context.numberOne.length()== 0 && context.operator == null && context.numberTwo.length() == 0)
			return;
		if(!value.matches("[=]"))
			return;
		
		Double a = Double.parseDouble(context.numberOne.toString());
		Double b = Double.parseDouble(context.numberTwo.toString());
		context.numberOne = new StringBuffer();
		
		if(context.operator.matches("[+]")) {
			context.result = sum(a, b);
			context.numberOne.append(context.result);
		}
		if(context.operator.matches("[\\-]")) {
			context.result = sub(a, b);
			context.numberOne.append(context.result);
		}
		if(context.operator.matches("[x]"))
			context.numberOne.append(context.result = mult(a, b));
		if(context.operator.matches("[/]"))
			context.numberOne.append(context.result = div(a, b));
		
		context.numberTwo=new StringBuffer();
		context.operator   = null;
	}
	
	public void reset(String value) {
		if(!value.matches("(AC|C)"))
			return;
		context.numberOne=new StringBuffer();
		context.numberTwo=new StringBuffer();
		context.result   = null;
		context.operator = null;
	
	}
}
