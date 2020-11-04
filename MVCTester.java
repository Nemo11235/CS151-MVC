package cs151MVCTester;

import java.util.ArrayList;

/**
 * This is the tester that runs the MVC pattern
 * @author Zhexian Liu
 *
 */
public class MVCTester {
	public static void main(String args[]) {
		DataModel model = new DataModel(new ArrayList<String>());
		TestFrame frame = new TestFrame(model);
		
		model.attach(frame);
		
	}
	
}
