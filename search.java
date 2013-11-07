
package Text_Editor;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class search extends javax.swing.JFrame {

   // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1; 
    private String userInput;    
    private JTextArea textArea;
    private String find;
    //final Highlighter highlt;
    //final Color HIGHLT_COLOR = Color.YELLOW;
    //final highlt.HighlightPainter paint= null;
    public search() {
      initComponents();
    }

 
    // End of variables declaration  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {
 
   

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setToolTipText("Search");
        jDesktopPane1.setName("Search"); 
        jTextField1.setBounds(120, 80, 280, 30);
        jDesktopPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Search for: ");
        jLabel1.setBounds(30, 80, 74, 30);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Next");
        jButton1.setBounds(85, 140, 90, 30);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Prev.");
        jButton2.setBounds(180, 140, 80, 30);
        jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDesktopPane1.getAccessibleContext().setAccessibleName("Search");

        pack();
	}

	
	//to get the next word on textarea  
    	// </editor-fold>                        
             // to get the next word on textarea
	     public void ButtonCommand (JTextArea ta){
    		    textArea = ta;
    	     }
	     public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		//highlt.removeAllHighlights();
		
		int index=0;         	
		// Hilight and find the next word on file
		userInput = textArea.getText();
		String s = userInput;
		index = userInput.indexOf(s,0);
		if (index <= 0) {
		   System.err.println("Input something to search for");
		   return;
		} 
		String content = textArea.getText();
		if (index >= 0){
			{
			     int end = index + userInput.length();
			     //highlt.addHighlight(index, end, paint);
			     System.err.println("-"+ userInput +"found");
			}
				
		}else{
		   System.err.println("-" + userInput +  "Was not found on file");
		   
		}
		  

    	    }                                    
}

