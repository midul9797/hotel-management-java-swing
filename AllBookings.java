import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AllBookings extends JFrame {
    public AllBookings(){
        setTitle("Hotel Management System");

         String[] columnNames = {"Name", "Mobile","Age","Bed","Room","Staying Days","Check-in","Rooms"};

        setSize(1200,500);
        setVisible(true);
        try {

            URL url = new URL("https://java-swing-project.vercel.app/booking");


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            String s = response.toString();
            //Splitting String into String Array for JTable 
            String[] l = s.split("->");
            String[][] data = new String[l.length][];
            for(int i=0; i<l.length; i++){
                data[i] = l[i].split(",");
            }
            JTable table = new JTable(data, columnNames);
            table.setBounds(20,30,8,300);

            for(int i=0; i<table.getColumnCount(); i++)
            {
                table.getColumnModel().getColumn(i).setCellRenderer(new ZebraTable());
            }
            JScrollPane scrollPane = new JScrollPane(table);

            add(scrollPane);


            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
