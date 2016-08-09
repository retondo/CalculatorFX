package com.batata.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import com.batata.calculator.Model;

public class Controller {
	
	@FXML
	private Text output;
	
	private Model m = new Model();
	private String operator = "";
	private long num1 = 0;
	private int start = 1;
	
	@FXML
	public void onNumberClick(ActionEvent event)
	{
		if (start == 1) {
			output.setText("");
			start = 0;
		}
		String value = ((Button)event.getSource()).getText();
		output.setText(output.getText() + value);
	}
	
	@FXML
	public void onOperatorClick(ActionEvent event)
	{
		String value = ((Button)event.getSource()).getText();
		
		if (!"=".equals(value)) {
			if (!operator.isEmpty()) {
				start = 1;
				return;
			}
			
			if ("AC".equals(value)) {
				output.setText("");
				num1 = 0;
				start = 1;
				return;
			}
			
			operator = value;
			num1 = Long.parseLong(output.getText());
			output.setText("");
			
		} else {
			if (operator.isEmpty())
				return;
			
			output.setText(String.valueOf(m.calculate(num1, Long.parseLong(output.getText()), operator)));
			operator = "";
			start = 1;
		}

	}
}
