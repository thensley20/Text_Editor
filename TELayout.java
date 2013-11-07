//Nick Randall
//This part of the program sets the layout of the text editor and holds the save and open commands

package Text_Editor;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TELayout extends JFrame
{
	//image icons
	private ImageIcon openFileIcon= new ImageIcon(getClass().getResource("open.gif"));
	private ImageIcon saveFileIcon= new ImageIcon(getClass().getResource("save.gif"));
	private ImageIcon searchIcon= new ImageIcon(getClass().getResource("search.png"));
	private ImageIcon cutIcon= new ImageIcon(getClass().getResource("cut.png"));
	private ImageIcon copyIcon= new ImageIcon(getClass().getResource("copy.png"));
	private ImageIcon pasteIcon= new ImageIcon(getClass().getResource("paste.png"));

	//menu items
	private JMenuItem menuItemOpen= new JMenuItem("Open", openFileIcon);
	private JMenuItem menuItemSave= new JMenuItem("Save", saveFileIcon);
	private JMenuItem menuItemSearch= new JMenuItem("Search", searchIcon);
	private JMenuItem menuItemCut= new JMenuItem("Cut", cutIcon);
	private JMenuItem menuItemCopy= new JMenuItem("Copy", copyIcon);
	private JMenuItem menuItemPaste= new JMenuItem("Paste", pasteIcon);
	private JMenuItem menuItemExit= new JMenuItem("Exit");

	//buttons for menu bar
	private JButton openButton = new JButton(openFileIcon);
	private JButton saveButton = new JButton(saveFileIcon);
	private JButton searchButton= new JButton(searchIcon);
	private JButton cutButton= new JButton(cutIcon);
	private JButton copyButton= new JButton(copyIcon);
	private JButton pasteButton= new JButton(pasteIcon);
	private JLabel jlblStatus = new JLabel();

	//create file chooser
	private JFileChooser fileChooser = new JFileChooser(new File("untitled"));

	//text area
	private JTextArea jta = new JTextArea();

	//the text editor layout 
	public TELayout()
	{
		//get cut,copy,paste methods
		final Edit editControl= new Edit();

		//get search method
		//final search searchAction = new search();

		//create and set up menu
		JFrame frame = new JFrame("Text_Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setVisible(true);

		//adds the menu items to file
		JMenu menu = new JMenu("File");
		menu.add(menuItemOpen);
		menu.add(menuItemSave);
		menu.addSeparator();
		menu.add(menuItemExit);

		//add menu items to edit
		JMenu menu2 = new JMenu("Edit");
		menu2.add(menuItemSearch);
		menu2.add(menuItemCut);
		menu2.add(menuItemCopy);
		menu2.add(menuItemPaste);
		menu2.addSeparator();
		
		//create menu bar and add items
		JMenuBar menuBar= new JMenuBar();
		menuBar.add(menu);
		menuBar.add(menu2);

		//show the menu bar
		frame.setJMenuBar(menuBar);

		//create toolbar and add buttons
		JToolBar toolBar = new JToolBar();
		toolBar.add(openButton);
		toolBar.add(saveButton);
		toolBar.add(searchButton);
		toolBar.add(cutButton);
		toolBar.add(copyButton);
		toolBar.add(pasteButton);
	
		//runs open method from menu
		menuItemOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				openFile();
			}		
		});

		//runs save method from menu
		menuItemSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent f)
			{
				saveFile();
			}
		});

		//runs search method from menu
		menuItemSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				//searchAction.ButtonCommand(jta);
				//searchAction.initComponents();
				//searchAction.jButton1ActionPerformed(f);
			}
		});

		//runs cut method from menu
		menuItemCut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				editControl.cut();
			}
		});

		//runs copy method from menu
		menuItemCopy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				editControl.copy();
			}
		});

		//runs paste method from menu
		menuItemPaste.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				editControl.paste();
			}
		});

		//runs the exit command
		menuItemExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent f)
			{
				System.exit(0);
			}
		});

		//runs open method
		openButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				openFile();
			}
		});

		//runs save method
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				saveFile();
			}
		});

		//runs search method
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				//searchAction.ButtonCommand(jta);
				//searchAction.initComponents();
				//searchAction.jButton1ActionPerformed(f);
			}
		});

		//runs cut method
		cutButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				editControl.cut();
			}
		});
	
		//runs copy method
		copyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				editControl.copy();
			}
		});

		//runs paste method
		pasteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				editControl.paste();
			}
		});	
		
		frame.add(toolBar, BorderLayout.NORTH);
		frame.add(jlblStatus, BorderLayout.SOUTH);
		frame.add(new JScrollPane(jta), BorderLayout.CENTER);
	}

	//open files
	private void openFile()
	{
		if(fileChooser.showOpenDialog(this)== JFileChooser.APPROVE_OPTION)
		{
			openFile(fileChooser.getSelectedFile());
		}
	}

	private void openFile(File file)
	{
		try
		{
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			byte[] b = new byte[in.available()];
			in.read(b, 0, b.length);
			jta.append(new String(b, 0, b.length));
			in.close();

			//inform the user if it worked
			jlblStatus.setText(file.getName() + " opened successfully");
		}
		catch(IOException e)
		{
			jlblStatus.setText("Error openeing "+ file.getName());
		}
	}
	
	//save files
	private void saveFile()
	{
		if(fileChooser.showSaveDialog(this)== JFileChooser.APPROVE_OPTION)
		{
			saveFile(fileChooser.getSelectedFile());
		}
	}

	private void saveFile(File file)
	{
		try
		{
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			byte[] b = (jta.getText()).getBytes();
			out.write(b, 0, b.length);
			out.close();

			//inform the user if it worked
			jlblStatus.setText(file.getName() + " save complete");
		}
		catch(IOException e)
		{
			jlblStatus.setText("Error saving " + file.getName());
		}
	}

}		
			
