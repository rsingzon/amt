/**
 * ECSE 428 - Software Engineering Practice
 * Assignment B - Test Driven Development
 * Winter 2014
 * 
 * Singzon, Ryan 	260397455
 * Dao, Nhat-Quang 	260457711
 */

package ca.mcgill.amt.test;

import org.junit.Ignore;
import org.junit.Test;

import ca.mcgill.amt.R;
import ca.mcgill.amt.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AmtTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private MainActivity mainActivity;
    private LinearLayout layout;

    public AmtTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        setActivityInitialTouchMode(false);
        mainActivity = getActivity();
        layout = (LinearLayout) mainActivity.findViewById(R.id.layout);
    }

    @Test
    public void testLayoutNotEmpty(){
    	assertTrue(layout.getChildCount() > 0);
    }
    
    
    @Test
    public void testInputsExist(){
    	int numChildren = layout.getChildCount();
    	int count = 0;
    	
    	for(int i = 0; i < numChildren; i++){
    		if(layout.getChildAt(i) instanceof EditText){
    			count++;
    		}
    	}
    	
    	assertEquals(3, count);
    }
   
    @Test
    public void testButtonExists(){
    	int numChildren = layout.getChildCount();
    	int count = 0;
    	
    	//Searches list and increments count for every input
    	//field that is found
    	for(int i = 0; i < numChildren; i++){
    		if(layout.getChildAt(i) instanceof Button){
    			count++;
    		}
    	}
    	assertEquals(1, count);
    }
    
    @Test
    public void testNoInputsFilled(){
    	clickSubmit();	
    	
    	//Check if the error message appears
    	String expectedMessage = "Error: You must enter a value for each side";
    	String message = "";

    	TextView errorBox = (TextView)mainActivity.findViewById(R.id.error_box);
    	message = errorBox.getText().toString();
    	   	
    	assertEquals(expectedMessage, message);
    }
    
    
    @Test
    public void testInputType(){
    	
    	//Set the input fields to invalid inputs
    	EditText firstInput = (EditText)mainActivity.findViewById(R.id.first_side);
    	EditText secondInput = (EditText)mainActivity.findViewById(R.id.second_side);
    	EditText thirdInput = (EditText)mainActivity.findViewById(R.id.third_side);
    	
    	setViewText(firstInput, "a");
    	setViewText(secondInput, "b");
    	setViewText(thirdInput, "]");

    	clickSubmit();

    	//Check if the error message appears
    	String expectedMessage = "Error: You may only enter positive numbers";
    	String message = "";
    	
    	TextView errorBox = (TextView)mainActivity.findViewById(R.id.error_box);
    	message = errorBox.getText().toString();
    	   	
    	assertEquals(expectedMessage, message);
    }
    
    @Test
    public void testInputBounds(){
    	
    	//Set the input fields to values outside of 1 - 100 range
    	EditText firstInput = (EditText)mainActivity.findViewById(R.id.first_side);
    	EditText secondInput = (EditText)mainActivity.findViewById(R.id.second_side);
    	EditText thirdInput = (EditText)mainActivity.findViewById(R.id.third_side);
    	
    	setViewText(firstInput, "0");
    	setViewText(secondInput, "101");
    	setViewText(thirdInput, "100");

    	clickSubmit();
    	
    	//Check if the error message appears
    	String expectedMessage = "Error: You must enter numbers between 1 and 100 inclusive";
    	String message = "";
    	
    	TextView errorBox = (TextView)mainActivity.findViewById(R.id.error_box);
    	message = errorBox.getText().toString();
    	   	
    	assertEquals(expectedMessage, message);
    }
    
    @Test
    public void testIsTriangle(){
    	//Set two inputs such that their sum is smaller than third input
    	EditText firstInput = (EditText)mainActivity.findViewById(R.id.first_side);
    	EditText secondInput = (EditText)mainActivity.findViewById(R.id.second_side);
    	EditText thirdInput = (EditText)mainActivity.findViewById(R.id.third_side);
    	
    	setViewText(firstInput, "1");
    	setViewText(secondInput, "1");
    	setViewText(thirdInput, "100");

    	clickSubmit();
    	
    	//Check if the error message appears
    	String expectedMessage = "Error: The lengths entered do not create a triangle";
    	String message = "";
    	
    	TextView errorBox = (TextView)mainActivity.findViewById(R.id.error_box);
    	message = errorBox.getText().toString();
    	   	
    	assertEquals(expectedMessage, message);
    }
    
    @Test
    public void testIsIsosceles() {
    	EditText firstInput = (EditText)mainActivity.findViewById(R.id.first_side);
    	EditText secondInput = (EditText)mainActivity.findViewById(R.id.second_side);
    	EditText thirdInput = (EditText)mainActivity.findViewById(R.id.third_side);
    	
    	setViewText(firstInput, "60");
    	setViewText(secondInput, "60");
    	setViewText(thirdInput, "80");

    	clickSubmit();
    	
    	String expectedMessage = "Isosceles triangle";
    	String message;
    	
    	TextView outputBox = (TextView)mainActivity.findViewById(R.id.error_box);
    	message = outputBox.getText().toString();
    	
    	assertEquals(expectedMessage, message);
    	
    }
    
    @Test
    public void testIsEquilateral() {
    	EditText firstInput = (EditText)mainActivity.findViewById(R.id.first_side);
    	EditText secondInput = (EditText)mainActivity.findViewById(R.id.second_side);
    	EditText thirdInput = (EditText)mainActivity.findViewById(R.id.third_side);
    	
    	setViewText(firstInput, "60");
    	setViewText(secondInput, "60");
    	setViewText(thirdInput, "60");

    	clickSubmit();
    	
    	String expectedMessage = "Equilateral triangle";
    	String message;
    	
    	TextView outputBox = (TextView)mainActivity.findViewById(R.id.error_box);
    	message = outputBox.getText().toString();
    	
    	assertEquals(expectedMessage, message);
    	
    }
    
    @Test
    public void testIsScalene() {
    	EditText firstInput = (EditText)mainActivity.findViewById(R.id.first_side);
    	EditText secondInput = (EditText)mainActivity.findViewById(R.id.second_side);
    	EditText thirdInput = (EditText)mainActivity.findViewById(R.id.third_side);
    	
    	setViewText(firstInput, "30");
    	setViewText(secondInput, "40");
    	setViewText(thirdInput, "50");

    	clickSubmit();
    	
    	String expectedMessage = "Scalene triangle";
    	String message;
    	
    	TextView outputBox = (TextView)mainActivity.findViewById(R.id.error_box);
    	message = outputBox.getText().toString();
    	
    	assertEquals(expectedMessage, message);
    }
    
    /**
     * Helper methods
     */
    
    
    //Clicks the submit button on the main activity
    public void clickSubmit(){
    	final View child = layout.getChildAt(3);
		
		//Run button click on new thread
		try{
			runTestOnUiThread(new Runnable() {
				@Override
				public void run(){
					//Press the submit button
					Button button = (Button)child;
					button.performClick();
				}
			});
		} catch(Throwable e){
				
		}	
    }
    
    //Changes the text in an EditText view
    public void setViewText(final EditText textField, final String text){
		
		//Change text in new thread
		try{
			runTestOnUiThread(new Runnable() {
				@Override
				public void run(){
					textField.setText(text);
				}
			});
		} catch(Throwable e){
				
		}
    }
    
    public void setViewText(final EditText textField, final int text){
		
		//Change text in new thread
		try{
			runTestOnUiThread(new Runnable() {
				@Override
				public void run(){
					textField.setText(text);
				}
			});
		} catch(Throwable e){
				
		}
    }
}
