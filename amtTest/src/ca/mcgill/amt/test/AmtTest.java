package ca.mcgill.amt.test;

import org.junit.Test;

import ca.mcgill.amt.R;
import ca.mcgill.amt.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

public class AmtTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private MainActivity mMainActivity;
    private EditText firstSide;

    public AmtTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        setActivityInitialTouchMode(false);
        mMainActivity = getActivity();
    }

    @Test
    public void testFirstInputBoxExists(){
        firstSide = (EditText) mMainActivity.findViewById(R.id.first_side);
        assertNotNull("First side text box does not exist", firstSide);
    }
}
