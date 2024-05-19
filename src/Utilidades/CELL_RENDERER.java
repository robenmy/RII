package Utilidades;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CELL_RENDERER extends JCheckBox implements TableCellRenderer {
	private static final long serialVersionUID = 1L;
	 
    public CELL_RENDERER(){
        setHorizontalAlignment(JLabel.CENTER);
    }
    public java.awt.Component getTableCellRendererComponent(JTable arg0,
            Object value, boolean arg2, boolean arg3, int arg4, int arg5) {
        setSelected((value != null && ((Boolean) value).booleanValue()));
        setBackground(arg0.getBackground());
        setHorizontalAlignment(JLabel.CENTER);
        return this;
    }

}
