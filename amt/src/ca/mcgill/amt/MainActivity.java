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
	
		//Obtain user input
		firstInput = (EditText)findViewById(R.id.first_side);
		secondInput = (EditText)findViewById(R.id.second_side);
		thirdInput = (EditText)findViewById(R.id.third_side);

		//Check if any of the inputs are empty
		if(firstInput.getText().toString().equals("") 		||
				secondInput.getText().toString().equals("")	||
				thirdInput.getText().toString().equals("")	){
			
			//Displays an error message if any inputs are empty
			errorBox = (TextView)findViewById(R.id.error_box);
			errorBox.setText("Error: You must enter a value for each side");
			errorBox.setVisibility(View.VISIBLE);
		}
		
	}

}
