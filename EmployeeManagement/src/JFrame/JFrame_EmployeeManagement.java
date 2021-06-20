/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import JSupport.Validator;
import Object.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static JSupport.showMes.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public final class JFrame_EmployeeManagement extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_EmployeeManagement
     */
    ArrayList<Employee> list = new ArrayList<>();
    DefaultTableModel tableModel = new DefaultTableModel();
    int index;

    public JFrame_EmployeeManagement() {
        initComponents();
        setLocationRelativeTo(null);

        initData();
        if (list.size() > 0) {
            index = 0;
            fillToTable();
            showDetail();
        }

        Datetime();
        runText();
    }

    void initData() {
        list.add(new Employee("01", "Đỗ Thiện Thế Anh", "Nam", 28, "anhdtt@fpt.edu.vn", 9500000, ChucVu.getTP(), Department.getNS(), "Hòa đồng, dễ gần, tuy nhiên cần chăm chỉ và chú tâm hơn trong \ncông việc"));
        list.add(new Employee("02", "Lương Minh Đức", "Nam", 25, "duclm@fpt.edu.vn", 9500000, ChucVu.getTP(), Department.getKT_CN(), "Nhanh nhẹn, hào đồng, vui tính, cần cù trong công việc"));
        list.add(new Employee("03", "Nguyễn Ngọc Ánh", "Nữ", 24, "anhnn@fpt.edu.vn", 8000000, ChucVu.getNV(), Department.getMAR(), "Chăm chỉ, thân thiện, chịu học hỏi"));
        list.add(new Employee("04", "Vũ Chí Bằng", "Nam", 25, "bangvc@fpt.edu.vn", 5000000, ChucVu.getNV(), Department.getKT_CN(), "Hòa đồng, dễ gần, tuy nhiên còn hơi nóng tính và cần chăm chỉ \nhơn trong công việc"));
        list.add(new Employee("05", "Nguyễn Thị Thoan", "Nữ", 27, "thoannt@fpt.edu.vn", 7500000, ChucVu.getNV(), Department.getTC_KT(), "Thân thiện, hòa đồng, chịu khó trong công việc"));
        list.add(new Employee("06", "Nguyễn Thị Quỳnh Anh", "Nữ", 29, "anhntq@fpt.edu.vn", 9500000, ChucVu.getTP(), Department.getMAR(), "Tận tụy với công việc, nhanh nhẹn, hoạt bát, chịu học hỏi"));
        list.add(new Employee("07", "Nguyễn Trí Kiên", "Nam", 26, "kiennt@fpt.edu.vn", 5000000, ChucVu.getNV(), Department.getNS(), "Dễ gần, thân thiện, vui tính, tuy nhiên cần chăm chỉ hơn trong \ncông việc"));
        list.add(new Employee("08", "Trần Văn Quân", "Nam", 28, "quantv@fpt.edu.vn", 9500000, ChucVu.getTP(), Department.getTC_KT(), "Chăm chỉ, cần cù chịu khó trong công việc tuy nhiên cần \nhòa đồng hơn"));
        list.add(new Employee("09", "Trần Minh Quân", "Nam", 24, "quantm@fpt.edu.vn", 8500000, ChucVu.getNV(), Department.getKT_CN(), "Hoạt bát, nhanh nhẹn, hòa đồng, vui tính, cần chăm chỉ hơn \ntrong công việc"));
        list.add(new Employee("10", "Nguyễn Thị Minh Huyền", "Nữ", 23, "huyenntm@fpt.edu.vn", 9000000, ChucVu.getNV(), Department.getKT_CN(), "Chăm chỉ, tận tụy với công việc, chịu học hỏi tiếp thu, cần \nhòa đồng hơn"));
    }

    void fillToTable() {
        tableModel = (DefaultTableModel) tbl_data.getModel();
        tableModel.setRowCount(0);
        list.stream().forEach((nv) -> {
            tableModel.addRow(new Object[]{nv.getEmployeeID(), nv.getFullName(), nv.getSex(), nv.getAge(), nv.getEmail(), nv.getSalary(), nv.getRole(), nv.getDepartment(), nv.getAssess()});
        });
    }

    private void newForm() {
        txt_employeeID.setText("");
        txt_fullName.setText("");
        txt_age.setText("");
        txt_email.setText("");
        txt_salary.setText("");
        ckb_role.setSelected(false);
        cbb_department.setSelectedIndex(0);
        txtarea_assess.setText("");
        lbl_record.setText("Record: ...");
        index = -1;
    }

    private void showDetail() {
        Employee nv = list.get(index);
        txt_employeeID.setText(nv.getEmployeeID());
        txt_fullName.setText(nv.getFullName());
        if (nv.getSex().trim().equalsIgnoreCase("Nam")) {
            rdo_nam.setSelected(true);
        } else {
            rdo_nu.setSelected(true);
        }
        txt_age.setText(nv.getAge() + "");
        txt_email.setText(nv.getEmail());
        txt_salary.setText(nv.getSalary() + "");
        if (nv.getRole().trim().equalsIgnoreCase("Trưởng phòng")) {
            ckb_role.setSelected(true);
        } else {
            ckb_role.setSelected(false);
        }
        cbb_department.setSelectedItem(nv.getDepartment());
        txtarea_assess.setText(nv.getAssess());
        lbl_record.setText("Record: " + (index + 1) + " of " + list.size());
        tbl_data.setRowSelectionInterval(index, index);
    }

    void save() {
        StringBuilder sb = new StringBuilder();
        Validator.checkNull(txt_employeeID, "Employee ID cannot be null", sb);
        Validator.checkNull(txt_fullName, "Fullname cannot be null", sb);
        Validator.checkAge(txt_age, sb);
        if (!txt_email.getText().isEmpty()) {
            Validator.checkEmail(txt_email, sb);
        }
        Validator.checkSalary(txt_salary, sb);

        if (sb.length() > 0) {
            showMes4(sb.toString());
            return;
        }

        Employee nv = new Employee();
        nv.setEmployeeID(txt_employeeID.getText());
        nv.setFullName(txt_fullName.getText());
        nv.setSex(rdo_nam.isSelected() ? "Nam" : "Nữ");
        nv.setAge(Integer.parseInt(txt_age.getText()));
        nv.setEmail(txt_email.getText());
        nv.setSalary(Double.parseDouble(txt_salary.getText()));
        nv.setRole(ckb_role.isSelected() ? "Trưởng phòng" : "Nhân viên");
        nv.setDepartment(cbb_department.getSelectedItem().toString());
        nv.setAssess(txtarea_assess.getText());

        if (index == -1) {
            if (checkTrung(txt_employeeID, "EmployeeID has already existed")) {
                return;
            }
            list.add(nv);
            tableModel.addRow(new Object[]{nv.getEmployeeID(), nv.getFullName(), nv.getSex(), nv.getAge(), nv.getEmail(), nv.getSalary(), nv.getRole(), nv.getDepartment(), nv.getAssess()});
            index = list.size() - 1;
            showDetail();
        } else {
            updateTable(nv.getFullName(), index, 1);
            list.get(index).setFullName(txt_employeeID.getText());

            updateTable(nv.getSex(), index, 2);
            list.get(index).setSex(rdo_nam.isSelected() ? "Nam" : "Nữ");

            updateTable(nv.getAge(), index, 3);
            list.get(index).setAge(Integer.parseInt(txt_age.getText()));

            updateTable(nv.getEmail(), index, 4);
            list.get(index).setEmail(txt_email.getText());

            updateTable(nv.getSalary(), index, 5);
            list.get(index).setSalary(Double.parseDouble(txt_salary.getText()));

            updateTable(nv.getRole(), index, 6);
            list.get(index).setRole(ckb_role.isSelected() ? "Trưởng phòng" : "Nhân viên");

            updateTable(nv.getDepartment(), index, 7);
            list.get(index).setDepartment(cbb_department.getSelectedItem().toString());

            updateTable(nv.getAssess(), index, 8);
            list.get(index).setAssess(txtarea_assess.getText());
        }
    }

    private boolean checkTrung(JTextField txt, String mes) {
        boolean ok = false;
        for (Employee nv : list) {
            if (nv.getEmployeeID().equalsIgnoreCase(txt.getText())) {
                txt.setBackground(Color.yellow);
                showMes2(mes + nv.getFullName());
                txt.requestFocus();
                ok = true;
            }
        }
        if (!ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    }

    void updateTable(Object aValue, int row, int column) {
        tbl_data.setValueAt(aValue, row, column);
    }

    void Datetime() {
        Thread t = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                while (true) {
                    Date d = new Date();
                    lbl_time.setText(sdf.format(d));
                    lbl_date.setText(sdf1.format(d));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        };
        t.start();
    }

    void runText() {
        Thread t = new Thread() {
            @Override
            public void run() {
                int i = 0;
                String text = lbl_title.getText();
                while (true) {
                    String c1 = text.substring(i, i + 1);
                    String c2 = text.substring(i, text.length());
                    text += c1;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        break;
                    }
                    lbl_title.setText(c2);
                    i++;
                }
            }
        };
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_employeeID = new javax.swing.JTextField();
        txt_fullName = new javax.swing.JTextField();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        txt_age = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_salary = new javax.swing.JTextField();
        ckb_role = new javax.swing.JCheckBox();
        cbb_department = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_assess = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btn_first = new javax.swing.JButton();
        btn_pre = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        lbl_record = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_find = new javax.swing.JButton();
        btn_open = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");

        lbl_title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(51, 0, 255));
        lbl_title.setText("EMPLOYEE MANAGEMENT   ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("EMPLOYEE ID");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("FULLNAME");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("SEX");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("AGE");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("SALARY");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("ROLE");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DEPARTMENT");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ASSESSMENT");

        buttonGroup1.add(rdo_nam);
        rdo_nam.setSelected(true);
        rdo_nam.setText("Nam");

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("Nữ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("EMAIL");

        ckb_role.setText("Trưởng phòng?");

        cbb_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kỹ thuật - Công nghệ", "Tài chính - Kế toán", "Nhân sự", "Marketing" }));

        txtarea_assess.setColumns(20);
        txtarea_assess.setRows(5);
        jScrollPane2.setViewportView(txtarea_assess);

        btn_first.setText("|<");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_pre.setText("<<");
        btn_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preActionPerformed(evt);
            }
        });

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.setText(">|");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Fullname", "Sex", "Age", "Email", "Salary", "Role", "Department", "Assessment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_data.setRowHeight(25);
        tbl_data.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_data);

        lbl_record.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_record.setForeground(new java.awt.Color(255, 51, 51));
        lbl_record.setText("Record: ...");

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_date.setForeground(new java.awt.Color(255, 0, 0));
        lbl_date.setText("CN, 13-06-2002");

        lbl_time.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(255, 0, 0));
        lbl_time.setText("13:06 CH");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_del.setText("Delete");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_find.setText("Find");
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });

        btn_open.setText("Open");
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });

        btn_exit.setText("Exit");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_new)
                    .addComponent(btn_save)
                    .addComponent(btn_del)
                    .addComponent(btn_find)
                    .addComponent(btn_open)
                    .addComponent(btn_exit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_del, btn_exit, btn_find, btn_new, btn_open, btn_save});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_new)
                .addGap(18, 18, 18)
                .addComponent(btn_save)
                .addGap(18, 18, 18)
                .addComponent(btn_del)
                .addGap(18, 18, 18)
                .addComponent(btn_find)
                .addGap(18, 18, 18)
                .addComponent(btn_open)
                .addGap(18, 18, 18)
                .addComponent(btn_exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_fullName)
                                        .addGap(94, 94, 94))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_email))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(ckb_role))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbb_department, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdo_nam)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdo_nu))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2)))
                                .addGap(75, 75, 75)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_time)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btn_first)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_last)
                .addGap(18, 18, 18)
                .addComponent(lbl_record, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(lbl_date)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(244, 244, 244))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_time))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdo_nam)
                            .addComponent(rdo_nu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ckb_role))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbb_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first)
                    .addComponent(btn_pre)
                    .addComponent(btn_next)
                    .addComponent(btn_last)
                    .addComponent(lbl_record)
                    .addComponent(lbl_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        try {
            newForm();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try {
            save();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        try {
            if (list.isEmpty()) {
                showMes2("No data to be deleted");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete this data?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            list.remove(index);
            tableModel.removeRow(index);

            if (list.isEmpty()) {
                newForm();
            } else {
                if (index == list.size()) {
                    index--;
                }
                showDetail();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
        try {
            String find = JOptionPane.showInputDialog(this, "Input your id to find");
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (find.equalsIgnoreCase(list.get(i).getEmployeeID())) {
                    index = i;
                    showDetail();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                showMes2("Can't find your id" + find);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_findActionPerformed

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        try {
            list = (ArrayList<Employee>) JSupport.IOFile.readObject("EmployeeList.txt");
            if (list.size() > 0) {
                index = 0;
                fillToTable();
                showDetail();
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }//GEN-LAST:event_btn_openActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to save data before exiting the program?");
            if (confirm == JOptionPane.YES_OPTION) {
                JFileChooser jfc = new JFileChooser();
                int path = jfc.showSaveDialog(this);
                if (path == JFileChooser.APPROVE_OPTION) {
                    String fileName = jfc.getSelectedFile().getAbsolutePath();
                    JSupport.IOFile.writeObject(fileName, list);
                    showMes2("Save the data successfully");
                    System.exit(0);
                }
            } else if (confirm == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } catch (HeadlessException | IOException e) {
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        try {
            index = tbl_data.getSelectedRow();
            showDetail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        try {
            index = 0;
            showDetail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preActionPerformed
        try {
            if (index > 0) {
                index--;
            }
            showDetail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_preActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try {
            if (index < list.size() - 1) {
                index++;
            }
            showDetail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        try {
            index = list.size() - 1;
            showDetail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_lastActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFrame_EmployeeManagement().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_find;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_pre;
    private javax.swing.JButton btn_save;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_department;
    private javax.swing.JCheckBox ckb_role;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_record;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_employeeID;
    private javax.swing.JTextField txt_fullName;
    private javax.swing.JTextField txt_salary;
    private javax.swing.JTextArea txtarea_assess;
    // End of variables declaration//GEN-END:variables
}
