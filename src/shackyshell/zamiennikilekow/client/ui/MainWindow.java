package shackyshell.zamiennikilekow.client.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by Dawid on 26.02.2017.
 */
public class MainWindow{
    private JTextField searchField;
    private JButton searchButton;
    private JPanel panel;
    private JTable table1;
    private JButton addButton;
    private JButton removeButton;
    private JButton editButton;

    static Object[][] databaseInfo;
    static Object[] columns = {
           "MedicineName",
            "ingredient1",
            "ingredient2",
            "ingredient3",
            "ingredient4",
            "ingredient5",
            "ingredient6",
            "ingredient7",
            "ingredient8",
            "ingredient9",
            "ingredient10",
            "dose",
            "amount",
            "amountUnit",
            "form",
            "PhotoURL"
    };

    static ResultSet rows;
    static ResultSetMetaData metaData;
    static DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo, columns){
        public Class getColumnClass(int column){
            Class returnValue;

            if((column >=0) && (column <getColumnCount())){
                returnValue = getValueAt(0,column).getClass();
            } else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Zamienniki Leków");
        frame.setContentPane(new MainWindow().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "newuser","password");
        } catch (Exception e ){
            System.out.println("Wyjatek (SQLException|ClassNotFoundException): " + e );
        }
    }
}
