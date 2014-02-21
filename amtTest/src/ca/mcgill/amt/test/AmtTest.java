package ca.mcgill.amt.test;

import org.junit.Ignore;
import org.junit.Test;

import ca.mcgill.amt.R;
import ca.mcgill.amt.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.LinearLayout;

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
    	
    	assertEquals(count, 3);
    }
    
}
