/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomTable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author laiss
 */
public class tableView {

    JFrame frame = new JFrame();
    public tableView(JFrame frame) {
        this.frame = frame;
    }

//Create columnTitle & Table Model 
    String[] columnTitle = { "ID", "Título", "Data de Empréstimo", "Data de Devolução", "Status", "Renovar Prazo" };
    DefaultTableModel model = new DefaultTableModel(columnTitle, 0);

    public JTable sampleTable(){
            JTable _dataTable = new JTable(model) {
                @Override
                public void updateUI() {
                    super.updateUI();
                    setRowHeight(34);
                    setAutoCreateRowSorter(true);

     //------------ Placing button at your desired column ------------

                    TableColumn column;
                    column = getColumnModel().getColumn(5);
                    column.setCellRenderer(new tableModel(frame).new viewRenderer());
                    column.setCellEditor(new tableModel(frame).new ButtonsEditorView(this));
                }
            };
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

       //-------- Adding data to your table row , use for loop for multiple data ---------

            model.addRow(new Object[]{"1","2","3"});
            return _dataTable;
    }

}