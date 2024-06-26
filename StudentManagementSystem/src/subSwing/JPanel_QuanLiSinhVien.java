/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subSwing;

import jSupport.ShowDialog;
import static jSupport.Validator.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import objects.*;

/**
 *
 * @author DaiAustinYersin
 */
public class JPanel_QuanLiSinhVien extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_QuanLiSinhVien
     */
    mainJFrame.MainJFrame parent;
    DefaultTableModel tableModel_QLSV = new DefaultTableModel();
    int index;
    StringBuilder sb;
    List<SinhVien> list = new ArrayList<>();
    String image = "sinhvien.jpg";

    public JPanel_QuanLiSinhVien() {
        initComponents();

        loadDataToTable();
        if (list.size() > 0) {
            index = 0;
            display();
        }
        jSupport.JThread.dateTime(lblDateTime);
        jSupport.JThread.runText(lblQLSV);
    }

    private void loadDataToTable() {
        tableModel_QLSV = (DefaultTableModel) tblQLSV.getModel();
        tableModel_QLSV.setRowCount(0);
        try {
            QuanLySinhVien qlsv = new QuanLySinhVien();
            list = qlsv.selectAll();
            for (SinhVien sv : list) {
                tableModel_QLSV.addRow(new Object[]{
                    sv.getMaSinhVien(), sv.getHoTen(), sv.getEmail(), sv.getSoDT(),
                    sv.getGioiTinh() ? "Nam" : "Nữ", sv.getDiaChi(), sv.getHinh()
                });
            }
            tableModel_QLSV.fireTableDataChanged();
        } catch (Exception e) {
            ShowDialog.showMes(parent, e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlQLSV = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnLast = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblQLSV = new javax.swing.JTable();
        lblDateTime = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblQLSV = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        btnNext = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        lblRecord = new javax.swing.JLabel();
        btnOpenImage = new javax.swing.JButton();

        setBackground(new java.awt.Color(248, 148, 6));

        pnlQLSV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        tblQLSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLSV.setRowHeight(25);
        tblQLSV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblQLSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblQLSV);

        lblDateTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDateTime.setForeground(new java.awt.Color(255, 0, 0));
        lblDateTime.setText("01/07/2021 5:33:00 CH");

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save1.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sinhvien.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblQLSV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblQLSV.setForeground(new java.awt.Color(51, 51, 255));
        lblQLSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQLSV.setText("QUẢN LÝ SINH VIÊN   ");

        jLabel8.setText("Họ tên:");

        jLabel10.setText("Email:");

        jLabel16.setText("Số điện thoại:");

        jLabel23.setText("Giới tính:");

        jLabel24.setText("Địa chỉ:");

        jLabel25.setText("Mã sinh viên:");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane4.setViewportView(txtDiaChi);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail)
                    .addComponent(txtSDT)
                    .addComponent(txtHoTen)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoNu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(txtMaSV))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/del1.jpg"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add1.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/first.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pre.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        lblRecord.setForeground(new java.awt.Color(255, 0, 0));
        lblRecord.setText("Record: ...");

        btnOpenImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open1.png"))); // NOI18N
        btnOpenImage.setText("Mở hình");
        btnOpenImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlQLSVLayout = new javax.swing.GroupLayout(pnlQLSV);
        pnlQLSV.setLayout(pnlQLSVLayout);
        pnlQLSVLayout.setHorizontalGroup(
            pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQLSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator6)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQLSVLayout.createSequentialGroup()
                        .addComponent(lblRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDateTime))
                    .addGroup(pnlQLSVLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlQLSVLayout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQLSVLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnOpenImage)
                                        .addGap(52, 52, 52))
                                    .addGroup(pnlQLSVLayout.createSequentialGroup()
                                        .addGap(284, 284, 284)
                                        .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator1)))))
                            .addGroup(pnlQLSVLayout.createSequentialGroup()
                                .addComponent(btnLamMoi)
                                .addGap(18, 18, 18)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );

        pnlQLSVLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLuu, btnXoa});

        pnlQLSVLayout.setVerticalGroup(
            pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQLSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlQLSVLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(pnlQLSVLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOpenImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLamMoi)
                        .addComponent(btnLuu)
                        .addComponent(btnXoa)
                        .addComponent(btnCapNhat))
                    .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnNext, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLast)))
                .addGap(18, 18, 18)
                .addGroup(pnlQLSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateTime)
                    .addComponent(lblRecord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlQLSVLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCapNhat, btnLamMoi, btnLuu, btnXoa});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(pnlQLSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlQLSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            index = list.size() - 1;
            display();
        } catch (Exception e) {
            ShowDialog.showMes(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            index = 0;
            display();
        } catch (Exception e) {
            ShowDialog.showMes(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            if (index < list.size() - 1) {
                index++;
                display();
            }
        } catch (Exception e) {
            ShowDialog.showMes(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        try {
            if (index > 0) {
                index--;
                display();
            }
        } catch (Exception e) {
            ShowDialog.showMes(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        sb = new StringBuilder();
        if (Validator(sb)) {
            return;
        }
        try {
            SinhVien sv = new SinhVien();
            sv.setMaSinhVien(txtMaSV.getText());
            sv.setHoTen(txtHoTen.getText());
            sv.setEmail(txtEmail.getText());
            sv.setSoDT(txtSDT.getText());
            sv.setDiaChi(txtDiaChi.getText());
            sv.setGioiTinh(rdoNam.isSelected());
            sv.setHinh(image);

            QuanLySinhVien qlsv = new QuanLySinhVien();
            if (qlsv.insert(sv)) {
                list.add(sv);
                tableModel_QLSV.addRow(new Object[]{
                    sv.getMaSinhVien(), sv.getHoTen(), sv.getEmail(), sv.getSoDT(), sv.getGioiTinh() ? "Nam" : "Nữ", sv.getDiaChi(), sv.getHinh()
                });
                index = list.size() - 1;
                display();
                ShowDialog.showMessage(parent, "Thông báo", "Sinh viên mã " + txtMaSV.getText() + " đã được lưu");
            } else {
                ShowDialog.showError(parent, "Cảnh báo", "Sinh viên không được lưu do lỗi");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ShowDialog.showError(parent, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        sb = new StringBuilder();
        jSupport.Validator.checkNull(txtMaSV, "Mã sinh viên không được để trống", sb);
        if (sb.length() > 0) {
            ShowDialog.showMessage(parent, "Dữ liệu không hợp lệ", sb.toString());
            return;
        }
        if (ShowDialog.showConfirm(parent, "Xác nhận", "Bạn có muốn xóa sinh viên không?") != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            QuanLySinhVien qlsv = new QuanLySinhVien();
            if (qlsv.delete(txtMaSV.getText())) {
                list.remove(index);
                tableModel_QLSV.removeRow(index);

                if (list.isEmpty()) {
                    clearForm();
                } else {
                    if (index == list.size()) {
                        index--;
                    }
                    display();
                }
                ShowDialog.showMessage(parent, "Thông báo", "Sinh viên đã được xóa");
            } else {
                ShowDialog.showError(parent, "Cảnh báo", "Sinh viên không được xóa do lỗi");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ShowDialog.showError(parent, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        sb = new StringBuilder();
        if (Validator(sb)) {
            return;
        }
        if (ShowDialog.showConfirm(parent, "Xác nhận", "Bạn có muốn cập nhật sinh viên không?") != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            SinhVien sv = new SinhVien();
            sv.setMaSinhVien(txtMaSV.getText());
            sv.setHoTen(txtHoTen.getText());
            sv.setEmail(txtEmail.getText());
            sv.setSoDT(txtSDT.getText());
            sv.setDiaChi(txtDiaChi.getText());
            sv.setGioiTinh(rdoNam.isSelected());
            sv.setHinh(image);

            QuanLySinhVien qlsv = new QuanLySinhVien();
            if (qlsv.update(sv)) {
                loadDataToTable();
                display();
                ShowDialog.showMessage(parent, "Thông báo", "Sinh viên mã " + txtMaSV.getText() + " đã được cập nhật");
            } else {
                ShowDialog.showError(parent, "Cảnh báo", "Sinh viên không được cập nhật do lỗi");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ShowDialog.showError(parent, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnOpenImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(parent) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File f = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(f.getPath());
            lblImage.setIcon(icon);
            Path p = Paths.get(f.getPath());
            image = p.getFileName().toString();
        } catch (Exception e) {
            e.printStackTrace();
            ShowDialog.showMessage(parent, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnOpenImageActionPerformed

    private void tblQLSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSVMouseClicked
        try {
            index = tblQLSV.getSelectedRow();
            display();
        } catch (Exception e) {
            ShowDialog.showMessage(parent, "Lỗi", e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblQLSVMouseClicked

    private boolean Validator(StringBuilder sb) throws HeadlessException {
        checkNull(txtMaSV, "Mã sinh viên chưa nhập", sb);
        checkNull(txtHoTen, "Họ tên chưa nhập", sb);
        checkEmail(txtEmail, sb);
        checkSDT(txtSDT, sb);
        if (sb.length() > 0) {
            ShowDialog.showError(parent, "Dữ liệu không hợp lệ", sb.toString());
            return true;
        }
        return false;
    }

    private void display() {
        tblQLSV.setRowSelectionInterval(index, index);
        txtMaSV.setText(tblQLSV.getValueAt(index, 0).toString());
        txtHoTen.setText(tblQLSV.getValueAt(index, 1).toString());
        txtEmail.setText(tblQLSV.getValueAt(index, 2).toString());
        txtSDT.setText(tblQLSV.getValueAt(index, 3).toString());
        if (tblQLSV.getValueAt(index, 4).toString().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(tblQLSV.getValueAt(index, 5).toString());
        if (tblQLSV.getValueAt(index, 6) != null) {
            lblImage.setIcon(new ImageIcon(getClass().getResource("/images/" + tblQLSV.getValueAt(index, 6))));
        } else {
            image = "sinhvien.jpg";
            lblImage.setIcon(new ImageIcon(getClass().getResource("/images/sinhvien.jpg")));
        }
        lblRecord.setText("Record: " + (index + 1) + " of " + tblQLSV.getRowCount());
    }

    private void clearForm() {
        lblImage.setIcon(new ImageIcon(getClass().getResource("/images/sinhvien.jpg")));
        lblRecord.setText("Record: ... of ...");
        txtMaSV.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        index = -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpenImage;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblQLSV;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JPanel pnlQLSV;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblQLSV;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
