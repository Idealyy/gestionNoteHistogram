package com.ideal.gestion_note.panels.table;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ideal.gestion_note.interfaces.Updatable;
import com.ideal.gestion_note.model.Student;
import com.ideal.gestion_note.services.StudentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ideal
 */
public class TablePanel extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel(TableColumn.values(), 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column != TableColumn.Observation.getIndex() && column != TableColumn.NumEt.getIndex();
        }
    };
    private final StudentService service = new StudentService();
    private final Updatable observer;

    /**
     * Creates new form of TablePanel
     */
    public TablePanel(Updatable observer) {
        this.observer = observer;
        initComponents();
        initTable();
        setListeners();
    }

    private void setListeners() {
        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (row != -1 && column != -1) {
                Object value = model.getValueAt(row, column);
                Student student = updateCell(row, column, value.toString());
                if (student != null) {
                    service.update(student.getNumEt(), student);
                    observer.update();
                }
            }
        });
    }

    private void initTable() {
        addRows(service.findAll());
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
        addBtn.addActionListener(this::addBtnActionPerformed);

        deleteBtn.setText("Supprimer");
        deleteBtn.addActionListener(this::deleteBtnActionPerformed);

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

    /**
     * Save a student
     */
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String numEt = (numTF.getText());
        String nom = nameTF.getText();
        try {
            double moyenne = Double.parseDouble(moyenneTF.getText());
            Student student = service.create(new Student(numEt, nom, moyenne));
            addRow(student);
            observer.update();
        } catch (NumberFormatException ex) {
            showErrorMessageDialog("Moyenne invalide");
        } catch (RuntimeException e) {
            showErrorMessageDialog(e.getMessage());
        }
        resetTextFields();
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = dataTable.getSelectedRow();
        if (selectedRow != -1) {
            String numEt = model.getValueAt(selectedRow, 0).toString(); // Numéro de l'étudiant
            if (showConfirmDialog("Etes vous sur de vouloir supprimer l'etudiant #" + numEt)) {
                service.delete(numEt);
                model.removeRow(selectedRow);
                observer.update();
            }
        } else {
            showErrorMessageDialog("Sélectionne une ligne à supprimer.");
        }
    }

    private List<Student> parseToStudent(String json) {
        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    private void addRow(Student s) {
        model.addRow(new Object[]{s.getNumEt(), s.getNom(), s.getMoyenne(), s.getObservation()});
    }

    private void addRows(List<Student> students) {
        for (Student student : students) addRow(student);
    }

    private Student getRowAt(int row) {
        if (row == -1)
            return null;
        String numEt = model.getValueAt(row, 0).toString();
        String nom = model.getValueAt(row, 1).toString();
        double moyenne = Double.parseDouble(model.getValueAt(row, 2).toString());
        try {
            return new Student(numEt, nom, moyenne);
        } catch (NumberFormatException e) {
            showErrorMessageDialog("La moyenne doit etre entre 0 et 20");
            return null;
        }
    }

    private Student updateCell(int row, int col, String val) {
        if (row == -1 || col == -1) {
            return null;
        }
        Student student = getRowAt(row);
        if (student == null) {
            return null;
        }
        switch (col) {
            case 0: {
                student.setNumEt(val);
                break;
            }
            case 1: {
                student.setNom(val);
                break;
            }
            case 2: {
                try {
                    student.setMoyenne(Double.parseDouble(val));
                    model.setValueAt(student.getObservation(), row, 3);
                    break;
                } catch (NumberFormatException exception) {
                    showErrorMessageDialog("Moyenne invalide");
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

    private void showErrorMessageDialog(String message) {
        JOptionPane.showMessageDialog(
                dataTable,
                message == null ? "Erreur" : message,
                "Erreur",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private boolean showConfirmDialog(String message) {
        int result = JOptionPane.showConfirmDialog(
                dataTable,
                message == null ? "Êtes-vous sûr ?" : message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );
        return result == JOptionPane.YES_OPTION;
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
