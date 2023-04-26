import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Cost extends JFrame {
    public Cost(){
        setTitle("Hotel Management System");
        String[] columnNames = {"Room Type", "Bed Type", "Cost per Day"};
        String[][]data={{"Non-AC","Single","500TK"},{"Non-AC","Double","800TK" },{"AC","Single","700TK"},{"AC","Double","100TK"}};


        setSize(1200,500);
        setVisible(true);
        try {

            JTable table = new JTable(data, columnNames);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            Font font = new Font("Fira Code", Font.BOLD, 20);
            renderer.setFont(font);
            table.setDefaultRenderer(Object.class, renderer);

            DefaultCellEditor editor = new DefaultCellEditor(new JTextField());

            editor.getComponent().setFont(font);

            table.setDefaultEditor(Object.class, editor);
            table.setRowHeight(40);
            for(int i=0; i<table.getColumnCount(); i++)
            {
                table.getColumnModel().getColumn(i).setCellRenderer(new ZebraTable());
            }
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane);


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
