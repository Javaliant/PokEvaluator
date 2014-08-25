/* Author: Luigi Vincent
*A pokemon Type Evaluator, shows the user the pokemon's outstanding type attributes.
*/

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class TypeChecker {
	static Double normMulti1 = 1.0, flyMulti1 = 1.0, fightMulti1 = 1.0, fireMulti1 = 1.0, waterMulti1 = 1.0,
        elecMulti1 = 1.0, grassMulti1 = 1.0, bugMulti1 = 1.0, poisMulti1 = 1.0, darkMulti1 = 1.0,
        psyMulti1 = 1.0, ghostMulti1 = 1.0, groundMulti1 = 1.0, rockMulti1 = 1.0, steelMulti1 = 1.0,
        iceMulti1 = 1.0, dragMulti1 = 1.0, faeMulti1 = 1.0;

    static String[] elements = {"Normal", "Flying", "Fighting", "Fire", "Water", "Electric",
      	"Grass", "Bug", "Poison", "Dark", "Psychic", "Ghost",
       	"Ground", "Rock", "Steel", "Ice", "Dragon", "Fairy"};
    static int len = elements.length;
    static Double[] multiplierList1 = new Double[len];

    static JTextField immune = new JTextField(15), res = new JTextField(15),
    	vuln = new JTextField(15);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Type Checker");
        JPanel panel = new JPanel(), result = new JPanel();
        result.setLayout(new GridLayout(3, 2, 0, 2));
        result.add(new JLabel("Immune to:"));
        result.add(immune);
        result.add(new JLabel("Resistant to:"));
        result.add(res);
        result.add(new JLabel("Vulnerable to:"));
        result.add(vuln);
        
        vuln.setEditable(false);
        res.setEditable(false);
        immune.setEditable(false);

        multiplerSet();

        ImageIcon[] types = new ImageIcon[len];
        for (int i = 0; i < len; i++) {
        	types[i] = new ImageIcon("Images/" + elements[i] + ".gif");
        }

        JComboBox<ImageIcon> typeList = new JComboBox<ImageIcon>(types);
        typeList.addItemListener(new ItemListener() {
     		@Override
     		public void itemStateChanged(ItemEvent e) {
     			if (e.getStateChange() == ItemEvent.SELECTED) {
     				for (int i = 0; i < len; i++) {
       					multiplierList1[i] = 1.0;
       					multiplierDisplay();
       				}
     			 	for (int i = 0; i < len; i++) {
     			 		if (e.getItem() == types[i]) {
     			 			switch(elements[i]) {
     			 				case "Normal":
     			 					fightMulti1 = 2.0;
     			 					ghostMulti1 = 0.0;
     			 					break;
     			 				case "Flying":
     			 					elecMulti1 = 2.0; iceMulti1 = 2.0; rockMulti1 = 2.0;
     			 					bugMulti1 = 0.5; fightMulti1 = 0.5; grassMulti1 = 0.5;
     			 					groundMulti1 = 0.0;
     			 					break;
     			 				case "Fighting":
     			 					flyMulti1 = 2.0; psyMulti1 = 2.0;
     			 					bugMulti1 = 0.5; rockMulti1 = 0.5;
     			 					break;
     			 				case "Fire":
     			 					groundMulti1 = 2.0; rockMulti1 = 2.0; waterMulti1 = 2.0;
     			 					bugMulti1 = 0.5; faeMulti1 = 0.5; fireMulti1 = 0.5;
     			 					grassMulti1 = 0.5; iceMulti1 = 0.5; steelMulti1 = 0.5;
     			 					break;
     			 				case "Water":
     			 					elecMulti1 = 2.0; grassMulti1 = 2.0;
     			 					fireMulti1 = 0.5; iceMulti1 = 0.5;
     			 					steelMulti1 = 0.5; waterMulti1 = 0.5;
     			 					break;
     			 				case "Electric":
     			 					groundMulti1 = 2.0;
     			 					elecMulti1 = 0.5; flyMulti1 = 0.5; steelMulti1 = 0.5;
     			 					break;
     			 				case "Grass":
     			 					bugMulti1 = 2.0; iceMulti1 = 2.0;
     			 					fireMulti1 = 2.0; flyMulti1 = 2.0; poisMulti1 = 2.0;
     			 					elecMulti1 = 0.5; grassMulti1 = 0.5;
     			 					groundMulti1 = 0.5; waterMulti1 = 0.5;
     			 					break;
     			 				case "Bug":
     			 					fireMulti1 = 2.0; flyMulti1 = 2.0; rockMulti1 = 2.0;
     			 					fightMulti1 = 0.5; grassMulti1 = 0.5; groundMulti1 = 0.5;
     			 					break;
     			 				case "Poison":
     			 					groundMulti1 = 2.0; psyMulti1 = 2.0;
     			 					bugMulti1 = 0.5; faeMulti1 = 0.5;
     			 					fightMulti1 = 0.5; grassMulti1 = 0.5; poisMulti1 = 0.5;
     			 					break;
     			 				case "Dark":
     			 					bugMulti1 = 2.0; faeMulti1 = 2.0; fightMulti1 = 2.0;
     			 					darkMulti1 = 0.5; ghostMulti1 = 0.5;
     			 					psyMulti1 = 0.0;
     			 					break;
     			 				case "Psychic":
     			 					bugMulti1 = 2.0; darkMulti1 = 2.0; ghostMulti1 = 2.0;
     			 					fightMulti1 = 0.5; psyMulti1 = 0.5;
     			 					break;
     			 				case "Ghost":
     			 					darkMulti1 = 2.0; ghostMulti1 = 2.0;
     			 					bugMulti1 = 0.5; poisMulti1 = 0.5;
     			 					fightMulti1 = 0.0; normMulti1 = 0.0;
     			 					break;
     			 				case "Ground":
     			 					iceMulti1 = 2.0; grassMulti1 = 2.0; waterMulti1 = 2.0;
     			 					poisMulti1 = 0.5; rockMulti1 = 0.5;
     			 					elecMulti1 = 0.0;
     			 					break;
     			 				case "Rock":
     			 					fightMulti1 = 2.0; grassMulti1 = 2.0;
     			 					groundMulti1 = 2.0; steelMulti1 = 2.0; waterMulti1 = 2.0;
     			 					fireMulti1 = 0.5; flyMulti1 = 0.5;
     			 					normMulti1 = 0.5; poisMulti1 = 0.5;
     			 					break;
     			 				case "Steel":
     			 					fightMulti1 = 2.0; fireMulti1 = 2.0; groundMulti1 = 2.0;
     			 					bugMulti1 = 0.5; dragMulti1 = 0.5; faeMulti1 = 0.5;
     			 					flyMulti1 = 0.5; grassMulti1 = 0.5; iceMulti1 = 0.5;
     			 					normMulti1 = 0.5; psyMulti1 = 0.5;
     			 					rockMulti1 = 0.5; steelMulti1 = 0.5;
     			 					poisMulti1 = 0.0;
     			 					break;
     			 				case "Ice":
     			 					fightMulti1 = 2.0; fireMulti1 = 2.0;
     			 					rockMulti1 = 2.0; steelMulti1 = 2.0;
     			 					iceMulti1 = 0.5;
     			 					break;
     			 				case "Dragon":
     			 					dragMulti1 = 2.0; faeMulti1 = 2.0; iceMulti1 = 2.0;
     			 					elecMulti1 = 0.5; fireMulti1 = 0.5;
     			 					grassMulti1 = 0.5; waterMulti1 = 0.5;
     			 					break;
     			 				case "Fairy":
     			 					poisMulti1 = 2.0; steelMulti1 = 2.0;
     			 					bugMulti1 = 0.5; darkMulti1 = 0.5; fightMulti1 = 0.5;
     			 					dragMulti1 = 0.0;
     			 				break; // final break purposely indented such
     			 			}
     			 			multiplerSet();
     			 			multiplierDisplay();
     			 		}
     			 	}
       			}
     		}
 		});

        panel.add(typeList);

        frame.setIconImage(new ImageIcon("Images/Icon.png").getImage());
        frame.add(result, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void multiplerSet() {
    	multiplierList1[0] = normMulti1;
	    multiplierList1[1] = flyMulti1;
	    multiplierList1[2] = fightMulti1;
	    multiplierList1[3] = fireMulti1;
	    multiplierList1[4] = waterMulti1;
	    multiplierList1[5] = elecMulti1;
	    multiplierList1[6] = grassMulti1;
	    multiplierList1[7] = bugMulti1;
	    multiplierList1[8] = poisMulti1;
	    multiplierList1[9] = darkMulti1;
	    multiplierList1[10] = psyMulti1;
	    multiplierList1[11] = ghostMulti1;
	    multiplierList1[12] = groundMulti1;
	    multiplierList1[13] = rockMulti1;
	    multiplierList1[14] = steelMulti1;
	    multiplierList1[15] = iceMulti1;
	    multiplierList1[16] = dragMulti1;
	    multiplierList1[17] = faeMulti1;
    }

    public static void multiplierDisplay() {
    	StringBuilder vln = new StringBuilder(), resist = new StringBuilder(),
    		imm = new StringBuilder();

    	for (int i = 0; i < len; i++) {
    		if (multiplierList1[i] == 0.0) {
    			if (imm.toString().isEmpty()) { imm.append(elements[i]); }
    			else { imm.append(", " + elements[i]); }
    		}
    		else if (multiplierList1[i] == 0.5) {
    			if (resist.toString().isEmpty()) { resist.append(elements[i]); }
    			else { resist.append(", " + elements[i]); }
    		}
    		else if (multiplierList1[i] == 2) {
    			if (vln.toString().isEmpty()) { vln.append(elements[i]); }
    			else { vln.append(", " + elements[i]); }
    		}
    	}

    	if (vln.toString().isEmpty()) { vln.append("None"); }
	   	if (imm.toString().isEmpty()) { imm.append("None"); }
	   	if (resist.toString().isEmpty()) { resist.append("None"); }
	   	immune.setText(imm.toString());
	   	res.setText(resist.toString());
	   	vuln.setText(vln.toString());
    }
}
