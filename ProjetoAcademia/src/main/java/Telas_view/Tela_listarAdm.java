/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_view;

import Academia.Deletar;
import Academia.Relatorios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author janiele 
 */
public class Tela_listarAdm extends javax.swing.JFrame {
     public void carregar_tabela() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) Tabela_adm.getModel();
        modelo.setRowCount(0); // limpa tabela

        Relatorios rl = new Relatorios();
        Object[][] dados = rl.relatorioAdm();
        for (Object[] linha : dados) {
            modelo.addRow(linha);
        }
    }
    /**
     * Creates new form Tela_listarAdm
     */
    public Tela_listarAdm() {
        initComponents();
        Tabela_adm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = Tabela_adm.getSelectedRow();
                if (linha != -1) {
                    String nome = Tabela_adm.getValueAt(linha, 0).toString(); // Nome = coluna 0
                    nome_adm.setText(nome);
                }
            }
        });

        try {
            carregar_tabela();
        } catch (SQLException ex) {
            Logger.getLogger(Tela_listagemAluno.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_adm = new javax.swing.JTable();
        nome_adm = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 610, 210, 80));

        Tabela_adm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Email", "Cpf", "Data de nascimento", "Telefone", "setor"
            }
        ));
        jScrollPane1.setViewportView(Tabela_adm);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 1220, 430));
        getContentPane().add(nome_adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 640, 430, 50));

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Tela Adm - ListagemAluno.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int linha_selecionada = Tabela_adm.getSelectedRow();
        if (linha_selecionada != -1) { // verifica se alguma linha foi selecionada
            String nome = Tabela_adm.getValueAt(linha_selecionada, 0).toString(); // coluna 0
            String email = Tabela_adm.getValueAt(linha_selecionada, 1).toString(); // coluna 1

            try {

                Deletar del = new Deletar();
                del.deletarAdm(email);
                
                carregar_tabela();
                JOptionPane.showMessageDialog(this, "Deletado!");

            } catch (SQLException ex) {
                Logger.getLogger(Tela_escolherPersonal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "erro!");
            } catch (Exception ex) {
                Logger.getLogger(Tela_escolherPersonal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "erro!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Tela_adm tl = new Tela_adm();
        tl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela_adm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome_adm;
    // End of variables declaration//GEN-END:variables
}
