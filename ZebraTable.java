import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ZebraTable implements TableCellRenderer {

    private static final Color ZEBRA_COLOR_1 = Color.WHITE; // Color for even rows
    private static final Color ZEBRA_COLOR_2 = new Color(235, 235, 235); // Color for odd rows
    private static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {

        // Use the default renderer to get the component
        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                column);

        // Set zebra colors for alternate rows
        if (row % 2 == 0) {
            renderer.setBackground(ZEBRA_COLOR_1);
        } else {
            renderer.setBackground(ZEBRA_COLOR_2);
        }

        return renderer;
    }
}
