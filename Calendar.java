import javax.swing.*;
import java.awt.event.*;

class CalendarPanel extends JPanel implements ActionListener
{
	
	JLabel dayLabel, monthLabel, yearLabel, outputLabel;
	JTextField dayField, monthField, yearField;
	JButton getDayButton;
	
	CalendarPanel()
	{
		dayLabel = new JLabel("Day");
		monthLabel = new JLabel("Month");
		yearLabel = new JLabel("Year");
		outputLabel = new JLabel("Enter Date Above");
		
		dayField = new JTextField(2);
		monthField = new JTextField(2);
		yearField = new JTextField(4);
		
		getDayButton = new JButton("Get Day");
		getDayButton.addActionListener(this);
		
		add(dayLabel);
		add(dayField);
		add(monthLabel);
		add(monthField);
		add(yearLabel);
		add(yearField);
		add(getDayButton);
		add(outputLabel);			
	}
	

	
	
	public void actionPerformed(ActionEvent event) 
	{
		if (event.getSource() == getDayButton)
        {
			
			try
				{
				
				int day = Integer.parseInt(dayField.getText());
				int month = Integer.parseInt(monthField.getText());
				int year = Integer.parseInt(yearField.getText());
				
				int result = Doomsday.GetDayOfWeek(day, month, year);
				
				String output = selectDate(result);
				
				if (output == "Error")
				{
				outputLabel.setText("Error: Invalid Date");
				}
				
				else
				{
				 outputLabel.setText(day+"/"+month+"/"+year+" is a " +output);
				}
			

				}
			
			catch (Exception e)
		    	{
		    	outputLabel.setText("Parsing Error - please only enter numbers");
		    	}
     	

        }
		
	}
	
	
	String selectDate(int day)
	{
		String output = null;
		
		switch (day)
		{
		case -1: output = "Error";
		break;
		case 0: output = "Sunday";
		break;
		case 1: output = "Monday";
		break;
		case 2: output = "Tuesday";
		break;
		case 3: output = "Wednesday";
		break;
		case 4: output = "Thursday";
		break;
		case 5: output = "Friday";
		break;
		case 6: output = "Saturday";
		break;

		}
		return output;
		
	}

}


public class Calendar {

	public static void main(String[] args) {
		JFrame f = new JFrame("Calendar");
        f.setSize( 400, 200 );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // add an instance of MyPanel
        f.add( new CalendarPanel() );

        f.setVisible( true );

	}

}
