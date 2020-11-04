package cs151MVCTester;

import java.util.ArrayList;
import javax.swing.event.*;

/**
 * (borrowed from textbook, edited)
  A Subject class for the observer pattern.
*/
public class DataModel
{
   /**
      Constructs a DataModel object
      @param d the data to model
   */
   public DataModel(ArrayList<String> d)
   {
      data = d;
      listeners = new ArrayList<ChangeListener>();
   }

   /**
      Constructs a DataModel object
      @return the data in an ArrayList
   */
   public ArrayList<String> getData()
   {
      return (ArrayList<String>) (data.clone());
   }

   /**
      Attach a listener to the Model
      @param c the listener
   */
   public void attach(ChangeListener c)
   {
      listeners.add(c);
   }

   /**
      Change the data in the model at a particular location
      @param location the index of the field to change
      @param value the new value
   */
   public void update(String value)
   {
      data.add(new String(value));
      for (ChangeListener l : listeners) {
         l.stateChanged(new ChangeEvent(this));
      }
   }

   ArrayList<String> data;
   ArrayList<ChangeListener> listeners;
}
