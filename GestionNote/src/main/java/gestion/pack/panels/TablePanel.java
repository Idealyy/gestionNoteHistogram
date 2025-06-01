package gestion.pack.panels;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gestion.pack.model.Student;

import java.lang.reflect.Type;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author ideal
 */
public class TablePanel extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel(
            new String[] {
                    "Numéro",
                    "Nom",
                    "Moyenne",
                    "Observation"
            }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column != 3;
        }
    };

    /**
     * {@link Deprecated}
     * Todo
     * A service layer will be implemented to get moyenne stats from REST
     */
    public double[] getMoyenneStats() {
        int rowCount = model.getRowCount();
        if (rowCount == 0) return new double[]{0, 0, 0};

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;

        for (int i = 0; i < rowCount; i++) {
            Object val = model.getValueAt(i, 2);
            if (val != null) {
                try {
                    double moyenne = Double.parseDouble(val.toString());
                    min = Math.min(min, moyenne);
                    max = Math.max(max, moyenne);
                    sum += moyenne;
                } catch (NumberFormatException ignored) {
                }
            }
        }

        double avg = sum / rowCount;
        return new double[]{min, avg, max};
    }

    /**
     * Creates new form TablePanel
     */
    public TablePanel() {
        initComponents();
        initTable();

        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (row != -1 && column != -1) {
                Object value = model.getValueAt(row, column);
                Student student = updateCell(row, column, value.toString());
                // TODO: Appel API PUT ici pour mettre à jour la moyenne et l'observation
                System.out.println("Cellule {r=" + row + ", c=" + column + "} modifiée : " + student.toString());
            }
        });

    }

    private void initTable() {
        dataTable.getColumnModel().getColumn(0).setHeaderValue("NumEt");
        dataTable.getColumnModel().getColumn(1).setHeaderValue("Nom");
        dataTable.getColumnModel().getColumn(2).setHeaderValue("Moyenne");
        dataTable.getColumnModel().getColumn(3).setHeaderValue("Observation");
        dataTable.getTableHeader().repaint();

        // TODO
        // fetch webservice from here
        String json = "[{\"numEt\": 1, \"nom\": \"Alice\", \"moyenne\": 14.5}, {\"numEt\": 2, \"nom\": \"Bob\", \"moyenne\": 12.75}]";
        addRows(parseToStudent(json));
        dataTable.setModel(model);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numTF = new javax.swing.JTextField();
        nameTF = new javax.swing.JTextField();
        moyenneTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        dataTable.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(dataTable);

        jLabel1.setText("Numéro :");

        jLabel2.setText("Nom et Prénom :");

        jLabel3.setText("Moyenne :");

        numTF.setToolTipText("Numéro de l'étudiant");

        nameTF.setToolTipText("Nom et Prénom de l'étudiant");

        moyenneTF.setToolTipText("Moyenne de l'étudiant");

        jLabel4.setText("Moyenne de classe :");

        addBtn.setText("Ajouter");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Supprimer");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(nameTF, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(numTF, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(moyenneTF))
                                                .addGap(63, 63, 63)
                                                .addComponent(addBtn)
                                                .addGap(68, 68, 68)))
                                .addGap(40, 40, 40))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteBtn)
                                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(numTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(moyenneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(deleteBtn))
                                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try {
            String numEt = (numTF.getText());
            String nom = nameTF.getText();
            double moyenne = Double.parseDouble(moyenneTF.getText());
            Student student = new Student(numEt, nom, moyenne);
            // TODO
            //  save added data here
            addRow(student);
            resetTextFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Moyenne invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = dataTable.getSelectedRow();
        if (selectedRow != -1) {
            String numEt = model.getValueAt(selectedRow, 0).toString(); // Numéro de l'étudiant
            // TODO: Appel API DELETE ici pour supprimer l'étudiant avec ce numéro
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Sélectionne une ligne à supprimer.");
        }
    }

    public List<Student> parseToStudent(String json) {
        Type listType = new TypeToken<List<Student>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }

    public void addRow (Student s) {
        model.addRow(new Object[]{s.getNumEt(), s.getNom(), s.getMoyenne(), s.getObs()});
    }

    public void addRows(List<Student> students) {
        for (Student student : students) addRow(student);
    }

    public Student getRowAt(int row) {
        if (row == -1)
            return null;
        String numEt = model.getValueAt(row, 0).toString();
        String nom = model.getValueAt(row, 1).toString();
        double moyenne = Double.parseDouble(model.getValueAt(row, 2).toString());
        return new Student(numEt, nom, moyenne);
    }

    public Student updateCell(int row, int col, String val) {
        if (row == -1 || col == -1) {
            return null;
        }
        Student student = getRowAt(row);
        switch (col) {
            case 0 : {
                student.setNumEt(val);
                break;
            } case 1 : {
                student.setNom(val);
                break;
            } case 2 : {
                try {
                    student.setMoyenne(Double.parseDouble(val));
                    model.setValueAt(student.getObs(), row, 3);
                    break;
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Moyenne invalide",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
        return student;
    }

    private void resetTextFields() {
        numTF.setText("");
        nameTF.setText("");
        moyenneTF.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField moyenneTF;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField numTF;
    // End of variables declaration//GEN-END:variables
}
