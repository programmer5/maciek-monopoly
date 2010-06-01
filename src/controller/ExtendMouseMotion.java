
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.BlockingQueue;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Klasa implementujaca Nasluchwiacz Ruchow Myszy
 * @author Maciej Sulek
 *
 */
public class ExtendMouseMotion implements MouseMotionListener
{
	private BlockingQueue<ExtendEvent> queue;
	
	public ExtendMouseMotion(BlockingQueue<ExtendEvent> queue)
	{
		this.queue = queue;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent evt)
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
		ExtendMouseEvent action = new ExtendMouseEvent(command);
		
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