package smallComp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AlertMessagePanel {
	JFrame j;
	public AlertMessagePanel(String message){
		j=new JFrame();
		JOptionPane.showMessageDialog(j, message);
	}
}
