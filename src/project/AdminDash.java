/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package project;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class AdminDash extends javax.swing.JPanel {
private UniverstyManager manager;
  private java.awt.CardLayout cardLayout;
private javax.swing.JPanel container;


    public AdminDash() {
        initComponents();
    }
public AdminDash(UniverstyManager manager,javax.swing.JPanel container, java.awt.CardLayout cardLayout) {
    initComponents();
    this.container = container;
    this.cardLayout = cardLayout;
    this.manager = manager; // save reference to manager

    // ---------- Button Actions ----------

    // Search User
    jButton1.addActionListener(e -> {
        String id = jTextField1.getText().trim();
        if (id.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a user ID!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student s = manager.searchStudent(id);
        if (s != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Role: Student\n" + s.getName() + "\nEmail: " + s.getEmail(), "User Found", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Doctor d = manager.searchDoctor(id);
        if (d != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Role: Doctor\n" + d.getName() + "\nEmail: " + d.getEmail(), "User Found", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Staff st = manager.searchStaff(id);
        if (st != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Role: Staff/Admin\n" + st.getName() + "\nEmail: " + st.getEmail(), "User Found", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        javax.swing.JOptionPane.showMessageDialog(this, "No user found with ID: " + id, "Not Found", javax.swing.JOptionPane.ERROR_MESSAGE);
    });

    // View All Students
    jButton8.addActionListener(e -> {
        StringBuilder sb = new StringBuilder();
        Node temp = manager.getStudents().head;
        while (temp != null) {
            Student s = (Student) temp.data;
            sb.append("ID: ").append(s.getId()).append(", Name: ").append(s.getName()).append(", Email: ").append(s.getEmail()).append("\n");
            temp = temp.next;
        }
        if (sb.length() == 0) sb.append("No students found!");
        javax.swing.JOptionPane.showMessageDialog(this, sb.toString(), "All Students", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    });

    // View All Doctors
    jButton9.addActionListener(e -> {
        StringBuilder sb = new StringBuilder();
        Node temp = manager.getDoctors().head;
        while (temp != null) {
            Doctor d = (Doctor) temp.data;
            sb.append("ID: ").append(d.getId()).append(", Name: ").append(d.getName()).append(", Email: ").append(d.getEmail()).append("\n");
            temp = temp.next;
        }
        if (sb.length() == 0) sb.append("No doctors found!");
        javax.swing.JOptionPane.showMessageDialog(this, sb.toString(), "All Doctors", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    });

    // View All Staff
    jButton10.addActionListener(e -> {
        StringBuilder sb = new StringBuilder();
        Node temp = manager.getStaff().head;
        while (temp != null) {
            Staff st = (Staff) temp.data;
            sb.append("StaffID: ").append(st.getStaffId()).append(", Name: ").append(st.getName()).append(", Role: ").append(st.getPosition()).append("\n");
            temp = temp.next;
        }
        if (sb.length() == 0) sb.append("No staff found!");
        javax.swing.JOptionPane.showMessageDialog(this, sb.toString(), "All Staff", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    });

    // View All Courses
    jButton11.addActionListener(e -> {
        StringBuilder sb = new StringBuilder();
        Node temp = manager.getCourses().head;
        while (temp != null) {
            course c = (course) temp.data;
            sb.append("CourseID: ").append(c.getCourseID()).append(", Name: ").append(c.getCourseName()).append("\n");
            temp = temp.next;
        }
        if (sb.length() == 0) sb.append("No courses found!");
        javax.swing.JOptionPane.showMessageDialog(this, sb.toString(), "All Courses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    });
    
    
    
    // Delete User
jButton4.addActionListener(e -> {
    String id = jTextField2.getText().trim(); // user ID to delete
    if (id.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter a User ID!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean deleted = manager.deleteStudent(id) || manager.deleteDoctor(id) || manager.deleteStaff(id);
    if (deleted) {
        javax.swing.JOptionPane.showMessageDialog(this, "User with ID: " + id + " deleted successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "No user found with ID: " + id, "Not Found", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
});
// Delete Course
jButton7.addActionListener(e -> {
    String courseId = jTextField3.getText().trim(); // course ID to delete
    if (courseId.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter a Course ID!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean deleted = manager.deleteCourse(courseId);
    if (deleted) {
        javax.swing.JOptionPane.showMessageDialog(this, "Course with ID: " + courseId + " deleted successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "No course found with ID: " + courseId, "Not Found", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
});

    jButton2.addActionListener(e -> {
        AddUser addUserPanel = new AddUser(manager, container, cardLayout);
        container.add(addUserPanel, "AddUser"); // add to CardLayout
        cardLayout.show(container, "AddUser");  // show AddUser panel
    });
jButton3.addActionListener(e -> {
    UpdateUser updatePanel = new UpdateUser(manager, container, cardLayout);
    container.add(updatePanel, "UpdateUser");
    cardLayout.show(container, "UpdateUser");
});
jButton5.addActionListener(e ->
    cardLayout.show(container, "addCourse")
);
jButton6.addActionListener(e ->
    cardLayout.show(container, "addCourse")
);
jButton12.addActionListener(e ->
        cardLayout.show(container, "login")
    );
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1.setText("Search User");

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton2.setText("AddUser");

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3.setText("UpdateUser");

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton4.setText("DeleteUser");

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton5.setText("AddCourse");

        jButton6.setBackground(new java.awt.Color(255, 204, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton6.setText("UpdateCourse");

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton7.setText("DeleteCourse");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 204, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton8.setText("ViewAllStudents");

        jButton9.setBackground(new java.awt.Color(255, 204, 204));
        jButton9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton9.setText("ViewAllDoctors");

        jButton10.setBackground(new java.awt.Color(255, 204, 204));
        jButton10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton10.setText("ViewAllAdmins");

        jButton11.setBackground(new java.awt.Color(255, 204, 204));
        jButton11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton11.setText("ViewAllCourses");

        jButton12.setBackground(new java.awt.Color(153, 204, 255));
        jButton12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton12.setText("Logout");

        jLabel2.setText("please input the user ID....");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("CourseID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jButton12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jButton7)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11)
                            .addComponent(jButton10))
                        .addGap(29, 29, 29)))
                .addComponent(jButton12)
                .addGap(83, 83, 83))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
