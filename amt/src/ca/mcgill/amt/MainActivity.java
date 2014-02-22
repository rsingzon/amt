package ca.mcgill.amt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView errorBox;
	private double firstSide, secondSide, thirdSide;
	private EditText firstInput, secondInput, thirdInput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/* Called after clicking on the "Get triangle" button
	 * Checks the user input for errors and determines what type of 
	 * triangle the user has input
	 */
	public void getTriangle(View v){
					
		TextView errorBox = (TextView)findViewById(R.id.error_box);
		
		//Obtain user input
		firstInput = (EditText)findViewById(R.id.first_side);
		secondInput = (EditText)findViewById(R.id.second_side);
		thirdInput = (EditText)findViewById(R.id.third_side);

		int firstSide, secondSide, thirdSide;
		
		//Check if any of the inputs are empty
		if(firstInput.getText().toString().equals("") 		||
				secondInput.getText().toString().equals("")	||
				thirdInput.getText().toString().equals("")	){
			
			//Displays an error message if any inputs are empty
			errorBox.setText("Error: You must enter a value for each side");
			errorBox.setVisibility(View.VISIBLE);
		}

		//Check if the inputs are the right type
		else if(!firstInput.getText().toString().matches("[0-9]+")  ||
				!secondInput.getText().toString().matches("[0-9]+") ||
				!thirdInput.getText().toString().matches("[0-9]+") ){

			//Displays an error message if any inputs are not numbers
			errorBox.setText("Error: You may only enter positive numbers");
			errorBox.setVisibility(View.VISIBLE);
		}
		
		firstSide = Integer.parseInt(firstInput.getText().toString());
		secondSide = Integer.parseInt(secondInput.getText().toString());
		thirdSide = Integer.parseInt(thirdInput.getText().toString());
		
		//Check if the inputs are within the valid range
		if(firstSide   < 1 || firstSide  > 100 ||
			secondSide < 1 || secondSide > 100 ||
			thirdSide  < 1 || secondSide > 100 ){
			
			//Displays an error message if any number is out of bounds
			errorBox.setText("Error: You must enter numbers between 1 and 100 inclusive");
			errorBox.setVisibility(View.VISIBLE);
		}
		
		//Check if the inputs actually create a triangle
		else if((firstSide + secondSide) < thirdSide  ||
				(firstSide + thirdSide ) < secondSide ||
				(secondSide + thirdSide) < firstSide ){
			
			//Displays an error message
			errorBox.setText("Error: The lengths entered do not create a triangle");
			errorBox.setVisibility(View.VISIBLE);
		}
		
	}
}
