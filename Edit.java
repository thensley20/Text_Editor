package Text_Editor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;


public class Edit extends JFrame  
{
	private JEditorPane editorPane;
	public void cut() 
	{
		editorPane= new JEditorPane("", "");
		JScrollPane scroller= new JScrollPane(editorPane);
		setContentPane(scroller);

		Action cutAction= new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, "Cut");
	}		
	
	public void copy()
	{
		editorPane= new JEditorPane("text/rtf", "");
                JScrollPane scroller= new JScrollPane(editorPane);
                setContentPane(scroller);

		Action copyAction= new DefaultEditorKit.CopyAction();
		copyAction.putValue(Action.NAME, "Copy");
	}	
	
	public void paste()
	{
		editorPane= new JEditorPane("text/rtf", "");
                JScrollPane scroller= new JScrollPane(editorPane);
                setContentPane(scroller);

		Action pasteAction= new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, "Paste");	
	}			
}
