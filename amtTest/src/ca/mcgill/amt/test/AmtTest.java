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
    	int numChildren = layout.getChildCount();
    	
    	//Search for the button in the activity
    	for(int i = 0; i < numChildren; i++){
    		
    		final View child = layout.getChildAt(i);
    		
    		//Click the button
    		if(child instanceof Button){
    			
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
    	}
    	
    	//Check if the error message appears
    	String expectedMessage = "Error: You must enter a value for each side";
    	String message = "";

    	TextView errorBox = (TextView)layout.getChildAt(4);
    	message = errorBox.getText().toString();
    	   	
    	assertEquals(expectedMessage, message);
    }
}
