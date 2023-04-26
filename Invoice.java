//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Invoice extends JFrame implements ActionListener {
//    JLabel roomsLabel, daysLabel, roomTypeLabel, bedTypeLabel, billLabel;
//    public Invoice(int rooms, int days, String roomType, String bedType,int bill)
//    {
//        setTitle("Hotel Management System");
//        setSize(500,700);
//        Font font = new Font("Fira Code", Font.BOLD, 20);
//        roomsLabel = new JLabel("Rooms: "+rooms);
//        roomsLabel.setBounds(50,100,100,30);
//        roomsLabel.setFont(font);
//        daysLabel = new JLabel("Days: "+days);
//        daysLabel.setBounds(150, 100,100,100);
//        daysLabel.setFont(font);
//        roomTypeLabel = new JLabel(roomType);
//        roomTypeLabel.setBounds(250,100,100,30);
//        roomTypeLabel.setFont(font);
//        bedTypeLabel = new JLabel(bedType);
//        bedTypeLabel.setBounds(350,100,100,30);
//        bedTypeLabel.setFont(font);
//        billLabel = new JLabel("Bill: "+bill);
//        billLabel.setBounds(100, 200, 100,45);
//        billLabel.setFont(font);
//        GradientButton invoice = new GradientButton("Print Invoice");
//        invoice.setBounds(300,300,150,35);
//        invoice.setForeground(Color.WHITE);
//        add(roomsLabel);
//        add(roomTypeLabel);
//        add(billLabel);
//        add(bedTypeLabel);
//        add(daysLabel);
//        add(invoice);
//        setVisible(true);
//        invoice.addActionListener(this);
//
//
//    }
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource().equals("Print Invoice"))
//        {
//            System.out.println("Invoice");
//            dispose();
//
//        }
//    }
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Invoice {


    public Invoice (String name, String mobile,String roomType, String bedType, String days, String rooms, int bill) {


                try {
                    URL url = new URL("https://java-swing-project.vercel.app/download/"+name+"/"+mobile+"/"+roomType+"/"+bedType+"/"+days+"/"+rooms+"/"+bill );
                    URLConnection connection = url.openConnection();

                    InputStream in = connection.getInputStream();
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                    int nRead;
                    byte[] data = new byte[1024];

                    while ((nRead = in.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, nRead);
                    }

                    buffer.flush();

                    byte[] binaryData = buffer.toByteArray();
                    JFileChooser fileChooser = new JFileChooser();
                    File file = new File("invoice");
                    fileChooser.setSelectedFile(file);
                    int returnValue = fileChooser.showSaveDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        System.out.println(returnValue+"X");

                        String path = fileChooser.getSelectedFile().getAbsolutePath();
                        FileOutputStream out = new FileOutputStream(path+".pdf");
                        out.write(binaryData);
                        out.close();

                    }
                }catch(Exception e){e.printStackTrace();

                    JOptionPane.showMessageDialog(null, "Failed to print invoice");

                }

    }


}
