
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Klasa rozszerzająca Action Listener
 * @author Maciej Sulek
 *
 */
public class ExtendActionListener implements ActionListener
{
	private BlockingQueue<ExtendEvent> queue;
	
	public ExtendActionListener(BlockingQueue<ExtendEvent> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		String command = null;
		if(evt.getSource() instanceof JButton)
		{
			JButton currentButton = (JButton)evt.getSource();
			command = currentButton.getName();
		}
		else if (evt.getSource() instanceof JPanel)
		{
			JPanel currentPanel = (JPanel)evt.getSource();
			command = currentPanel.getName();
		}
		ExtendActionEvent action = new ExtendActionEvent(command);
		
		try 
		{
			//System.out.println(((NumberField)evt.getSource()).getText());
			queue.put(action);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}

}