package cs151MVCTester;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *This is the view class that presents the model in a text area
 * @author Zhexian Liu
 *
 */
public class TestFrame extends JFrame implements ChangeListener{
	public TestFrame(DataModel d) {
		dataModel = d;
		data = dataModel.getData();
		setLocation(0, 200);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JButton addBttn = new JButton("Add");
	    addBttn.setPreferredSize(new Dimension(400,50));
	    addBttn.addActionListener( (event) -> {
	    	dataModel.update(input.getText());
			String sum = "";
			for(String s : data) 
			{	sum += s + "\n";	}
			area.setText(sum);
	    });
	    area.setPreferredSize(new Dimension(400,400));
	    input.setPreferredSize(new Dimension(400,50));
	    panel.add(addBttn, BorderLayout.NORTH);
	    panel.add(area, BorderLayout.CENTER);
	    panel.add(input, BorderLayout.SOUTH);
	    add(panel);
	    pack();
	    setVisible(true);
	}

	/**
	 * Overriding the stateChagned function implements the interface
	 */
	public void stateChanged(ChangeEvent e) {
		data = dataModel.getData();
	    repaint();
	}
	
	JTextField input = new JTextField();
    JTextArea area = new JTextArea();
    private ArrayList<String> data = new ArrayList<String>();
	private DataModel dataModel;
}
