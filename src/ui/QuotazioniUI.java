/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.Player;
import extractor.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.Cash;

import socket.SaveQuotes;

/**
 *
 * @author kix
 */
public class QuotazioniUI extends javax.swing.JFrame {
    
    private ArrayList<ArrayList<Player>> listaPlayers = new ArrayList<ArrayList<Player>>();
    private HashMap<String, Cash> cassaSquadre = new HashMap<String, Cash>();
    private SaveQuotes saveQuotes;


    /**
     * Creates new form q
     */
    public QuotazioniUI() throws IOException {
        
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.saveQuotes = new SaveQuotes(this);
        
        setLocationRelativeTo(null);
        
    }

    
      public void loadCashTeam(){
        
        ArrayList<String> teams = new ArrayList<String>(); 
        Set<String> teamSet = this.cassaSquadre.keySet();
        
        for (String s : teamSet){
            teams.add(s);
        }
        
        this.jTextFieldT1.setText(teams.get(0));
        this.jTextFieldT2.setText(teams.get(1));
        this.jTextFieldT3.setText(teams.get(2));
        this.jTextFieldT4.setText(teams.get(3));
        this.jTextFieldT5.setText(teams.get(4));
        this.jTextFieldT6.setText(teams.get(5));
        this.jTextFieldT7.setText(teams.get(6));
        this.jTextFieldT8.setText(teams.get(7));
        this.jTextFieldT9.setText(teams.get(8));
        this.jTextFieldT10.setText(teams.get(9));
        this.jTextFieldT11.setText(teams.get(10));
        this.jTextFieldT12.setText(teams.get(11));
        
        
        this.jTextFieldCharge1.setText(String.valueOf(this.cassaSquadre.get(teams.get(0)).getCharge()));
        this.jTextFieldCharge2.setText(String.valueOf(this.cassaSquadre.get(teams.get(1)).getCharge()));
        this.jTextFieldCharge3.setText(String.valueOf(this.cassaSquadre.get(teams.get(2)).getCharge()));
        this.jTextFieldCharge4.setText(String.valueOf(this.cassaSquadre.get(teams.get(3)).getCharge()));
        this.jTextFieldCharge5.setText(String.valueOf(this.cassaSquadre.get(teams.get(4)).getCharge()));
        this.jTextFieldCharge6.setText(String.valueOf(this.cassaSquadre.get(teams.get(5)).getCharge()));
        this.jTextFieldCharge7.setText(String.valueOf(this.cassaSquadre.get(teams.get(6)).getCharge()));
        this.jTextFieldCharge8.setText(String.valueOf(this.cassaSquadre.get(teams.get(7)).getCharge()));
        this.jTextFieldCharge9.setText(String.valueOf(this.cassaSquadre.get(teams.get(8)).getCharge()));
        this.jTextFieldCharge10.setText(String.valueOf(this.cassaSquadre.get(teams.get(9)).getCharge()));
        this.jTextFieldCharge11.setText(String.valueOf(this.cassaSquadre.get(teams.get(10)).getCharge()));
        this.jTextFieldCharge12.setText(String.valueOf(this.cassaSquadre.get(teams.get(11)).getCharge()));
        
        
        this.jTextFieldCash1.setText(String.valueOf(this.cassaSquadre.get(teams.get(0)).getCash()));
        this.jTextFieldCash2.setText(String.valueOf(this.cassaSquadre.get(teams.get(1)).getCash()));
        this.jTextFieldCash3.setText(String.valueOf(this.cassaSquadre.get(teams.get(2)).getCash()));
        this.jTextFieldCash4.setText(String.valueOf(this.cassaSquadre.get(teams.get(3)).getCash()));
        this.jTextFieldCash5.setText(String.valueOf(this.cassaSquadre.get(teams.get(4)).getCash()));
        this.jTextFieldCash6.setText(String.valueOf(this.cassaSquadre.get(teams.get(5)).getCash()));
        this.jTextFieldCash7.setText(String.valueOf(this.cassaSquadre.get(teams.get(6)).getCash()));
        this.jTextFieldCash8.setText(String.valueOf(this.cassaSquadre.get(teams.get(7)).getCash()));
        this.jTextFieldCash9.setText(String.valueOf(this.cassaSquadre.get(teams.get(8)).getCash()));
        this.jTextFieldCash10.setText(String.valueOf(this.cassaSquadre.get(teams.get(9)).getCash()));
        this.jTextFieldCash11.setText(String.valueOf(this.cassaSquadre.get(teams.get(10)).getCash()));
        this.jTextFieldCash12.setText(String.valueOf(this.cassaSquadre.get(teams.get(11)).getCash()));
        
    } 
        
    public void fillTable(){
        
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);
       
            
            for (List<Player> l : listaPlayers) {
                for (Player g : l) {

                      tm.addRow(new Object[]{g.getNome(), g.getSquadra(), g.getQuotazione(), g.getRuolo(),g.getBuyPrice(), g.getFantaTeam(),g.getScadenza(),g.getRinnovabile()});
                    
                }

            }
    }
    
    
    public void fillGoalKeeperTable(){
        
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);
        
         for (List<Player> l : this.listaPlayers) {
                for (Player g : l) {
                    if(g.getRuolo().equals("portiere")){
                        tm.addRow(new Object[]{g.getNome(), g.getSquadra(), g.getQuotazione(), g.getRuolo(),g.getBuyPrice(), g.getFantaTeam(),g.getScadenza(),g.getRinnovabile()});
                    }
                }

            }
    }
    
    public void fillDifenseTable(){
        
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);
        
         for (List<Player> l : this.listaPlayers) {
                for (Player g : l) {
                    if(g.getRuolo().equals("difensore")){
                        tm.addRow(new Object[]{g.getNome(), g.getSquadra(), g.getQuotazione(), g.getRuolo(),g.getBuyPrice(), g.getFantaTeam(),g.getScadenza(),g.getRinnovabile()});
                    }
                }

            }
    }
    
     public void fillMidfielderTable(){
        
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);
        
         for (List<Player> l : this.listaPlayers) {
                for (Player g : l) {
                    if(g.getRuolo().equals("centrocampista")){
                       
                        tm.addRow(new Object[]{g.getNome(), g.getSquadra(), g.getQuotazione(), g.getRuolo(),g.getBuyPrice(), g.getFantaTeam(),g.getScadenza(),g.getRinnovabile()});
                    }
                }

            }
    } 
     
     public void fillAttackerTable(){
        
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);
        
         for (List<Player> l : this.listaPlayers) {
                for (Player g : l) {
                    if(g.getRuolo().equals("attaccante")){
                        tm.addRow(new Object[]{g.getNome(), g.getSquadra(), g.getQuotazione(), g.getRuolo(),g.getBuyPrice(), g.getFantaTeam(),g.getScadenza(),g.getRinnovabile()});
                    }
                }

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        buttonMod = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        jTextFieldQuot = new javax.swing.JTextField();
        buttonApply = new javax.swing.JButton();
        togglePortieri = new javax.swing.JToggleButton();
        toggleDifensori = new javax.swing.JToggleButton();
        toggleCentro = new javax.swing.JToggleButton();
        toggleAttaccanti = new javax.swing.JToggleButton();
        toggleAll = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButtonLoad = new javax.swing.JButton();
        jButtonExtract = new javax.swing.JButton();
        jComboBoxScadenza = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButtonSafeReconnect = new javax.swing.JButton();
        jButtonLocal = new javax.swing.JButton();
        jTextFieldSystem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxRinnovo = new javax.swing.JComboBox();
        jTextFieldT1 = new javax.swing.JTextField();
        jTextFieldT2 = new javax.swing.JTextField();
        jTextFieldT3 = new javax.swing.JTextField();
        jTextFieldT4 = new javax.swing.JTextField();
        jTextFieldT5 = new javax.swing.JTextField();
        jTextFieldT6 = new javax.swing.JTextField();
        jTextFieldT7 = new javax.swing.JTextField();
        jTextFieldT8 = new javax.swing.JTextField();
        jTextFieldT9 = new javax.swing.JTextField();
        jTextFieldT10 = new javax.swing.JTextField();
        jTextFieldT11 = new javax.swing.JTextField();
        jTextFieldT12 = new javax.swing.JTextField();
        jTextFieldCash1 = new javax.swing.JTextField();
        jTextFieldCash2 = new javax.swing.JTextField();
        jTextFieldCash3 = new javax.swing.JTextField();
        jTextFieldCash4 = new javax.swing.JTextField();
        jTextFieldCash5 = new javax.swing.JTextField();
        jTextFieldCash6 = new javax.swing.JTextField();
        jTextFieldCash7 = new javax.swing.JTextField();
        jTextFieldCash8 = new javax.swing.JTextField();
        jTextFieldCash9 = new javax.swing.JTextField();
        jTextFieldCash10 = new javax.swing.JTextField();
        jTextFieldCash11 = new javax.swing.JTextField();
        jTextFieldCash12 = new javax.swing.JTextField();
        jTextFieldCharge1 = new javax.swing.JTextField();
        jTextFieldCharge2 = new javax.swing.JTextField();
        jTextFieldCharge3 = new javax.swing.JTextField();
        jTextFieldCharge4 = new javax.swing.JTextField();
        jTextFieldCharge5 = new javax.swing.JTextField();
        jTextFieldCharge6 = new javax.swing.JTextField();
        jTextFieldCharge7 = new javax.swing.JTextField();
        jTextFieldCharge8 = new javax.swing.JTextField();
        jTextFieldCharge9 = new javax.swing.JTextField();
        jTextFieldCharge10 = new javax.swing.JTextField();
        jTextFieldCharge11 = new javax.swing.JTextField();
        jTextFieldCharge12 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(70, 70, 70));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Squadra", "Quotazione", "Ruolo", "Ingaggio", "FantaTeam", "Scadenza", "Rinnovabile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonMod.setBackground(new java.awt.Color(242, 253, 96));
        buttonMod.setText("Modifica");
        buttonMod.setEnabled(false);
        buttonMod.setName(""); // NOI18N
        buttonMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModActionPerformed(evt);
            }
        });

        buttonSave.setBackground(new java.awt.Color(128, 254, 86));
        buttonSave.setText("Salva");
        buttonSave.setEnabled(false);
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jTextFieldQuot.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonApply.setBackground(new java.awt.Color(99, 254, 252));
        buttonApply.setText("Applica");
        buttonApply.setEnabled(false);
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
            }
        });

        togglePortieri.setText("Portieri");
        togglePortieri.setEnabled(false);
        togglePortieri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglePortieriActionPerformed(evt);
            }
        });

        toggleDifensori.setText("Difensori");
        toggleDifensori.setEnabled(false);
        toggleDifensori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleDifensoriActionPerformed(evt);
            }
        });

        toggleCentro.setText("Centrocampisti");
        toggleCentro.setEnabled(false);
        toggleCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleCentroActionPerformed(evt);
            }
        });

        toggleAttaccanti.setText("Attaccanti");
        toggleAttaccanti.setEnabled(false);
        toggleAttaccanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleAttaccantiActionPerformed(evt);
            }
        });

        toggleAll.setText("Tutti");
        toggleAll.setEnabled(false);
        toggleAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleAllActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Giocatore");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Q");

        jTextFieldPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPriceActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("I");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "libero", "acdc", "acybris", "astronzo", "cska", "dlc", "fanfulla", "fantaroma", "felix", "gpsundergland", "paris", "tccfc", "vts" }));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Squadra");

        jButtonLoad.setBackground(new java.awt.Color(100, 177, 253));
        jButtonLoad.setText("Carica");
        jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadActionPerformed(evt);
            }
        });

        jButtonExtract.setBackground(new java.awt.Color(100, 177, 253));
        jButtonExtract.setText("Estrai");
        jButtonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExtractActionPerformed(evt);
            }
        });

        jComboBoxScadenza.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "libero", "2014", "2015", "2016", "2017", "2018" }));
        jComboBoxScadenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxScadenzaActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Scadenza");

        jButtonSafeReconnect.setBackground(new java.awt.Color(255, 111, 111));
        jButtonSafeReconnect.setText("safeReconnect");
        jButtonSafeReconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSafeReconnectActionPerformed(evt);
            }
        });

        jButtonLocal.setBackground(new java.awt.Color(255, 111, 111));
        jButtonLocal.setText("Local");
        jButtonLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocalActionPerformed(evt);
            }
        });

        jTextFieldSystem.setEditable(false);
        jTextFieldSystem.setBackground(new java.awt.Color(254, 252, 108));
        jTextFieldSystem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSystem.setText("System not connected");
        jTextFieldSystem.setFocusable(false);
        jTextFieldSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSystemActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Rinnovabile");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBoxRinnovo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));

        jTextFieldCash1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash11.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCash12.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge11.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldCharge12.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cassa");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(togglePortieri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleDifensori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleAttaccanti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExtract, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSafeReconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldSystem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldQuot)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jComboBox1, 0, 1, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBoxScadenza, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jComboBoxRinnovo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldT12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jTextFieldT11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldT10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldT9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldT8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldT7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldT6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldT5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldT1)
                            .addComponent(jTextFieldT3)
                            .addComponent(jTextFieldT2)
                            .addComponent(jTextFieldT4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                                            .addComponent(jTextFieldCash1))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextFieldCharge1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jTextFieldCash2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextFieldCharge2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addComponent(jTextFieldCash3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jTextFieldCharge3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jTextFieldCash4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextFieldCharge4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jTextFieldCash5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jTextFieldCharge5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jTextFieldCash6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldCharge6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jTextFieldCash7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jTextFieldCharge7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jTextFieldCash8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldCharge8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jTextFieldCash9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldCharge9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextFieldCash10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCharge10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jTextFieldCash11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldCharge11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldCash12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCharge12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSafeReconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonLoad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonExtract, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(togglePortieri)
                                .addGap(18, 18, 18)
                                .addComponent(toggleDifensori)
                                .addGap(18, 18, 18)
                                .addComponent(toggleCentro)
                                .addGap(18, 18, 18)
                                .addComponent(toggleAttaccanti)
                                .addGap(18, 18, 18)
                                .addComponent(toggleAll)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldT12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCash12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCharge12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMod)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonApply)
                    .addComponent(buttonSave)
                    .addComponent(jComboBoxScadenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRinnovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    
    
    private void jButtonLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocalActionPerformed
        this.togglePortieri.setEnabled(true);
        this.toggleDifensori.setEnabled(true);
        this.toggleCentro.setEnabled(true);
        this.toggleAttaccanti.setEnabled(true);
        this.toggleAll.setEnabled(true);
        this.buttonMod.setEnabled(true);
    }//GEN-LAST:event_jButtonLocalActionPerformed

    private void jButtonSafeReconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSafeReconnectActionPerformed
        try {
            QuotazioniUI newQui = new QuotazioniUI();
            newQui.setListaPlayers(listaPlayers);
            newQui.setCassaSquadre(cassaSquadre);
            newQui.show();
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(QuotazioniUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSafeReconnectActionPerformed

    private void jComboBoxScadenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxScadenzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxScadenzaActionPerformed

    private void jButtonExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExtractActionPerformed

        try {
            this.listaPlayers = extractor.extract();
        } catch (IOException ex) {
            Logger.getLogger(QuotazioniUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.togglePortieri.setEnabled(true);
        this.toggleDifensori.setEnabled(true);
        this.toggleCentro.setEnabled(true);
        this.toggleAttaccanti.setEnabled(true);
        this.toggleAll.setEnabled(true);
        this.buttonMod.setEnabled(true);

    }//GEN-LAST:event_jButtonExtractActionPerformed

    private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadActionPerformed

        this.saveQuotes.loadPlayers();
        this.saveQuotes.loadCash();
        
        this.togglePortieri.setEnabled(true);
        this.toggleDifensori.setEnabled(true);
        this.toggleCentro.setEnabled(true);
        this.toggleAttaccanti.setEnabled(true);
        this.toggleAll.setEnabled(true);
        this.buttonMod.setEnabled(true);
    }//GEN-LAST:event_jButtonLoadActionPerformed

    private void jTextFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPriceActionPerformed

    private void toggleAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleAllActionPerformed
        this.togglePortieri.setSelected(false);
        this.toggleAttaccanti.setSelected(false);
        this.toggleCentro.setSelected(false);
        this.toggleDifensori.setSelected(false);

        fillTable();
    }//GEN-LAST:event_toggleAllActionPerformed

    private void toggleAttaccantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleAttaccantiActionPerformed
        this.togglePortieri.setSelected(false);
        this.toggleCentro.setSelected(false);
        this.toggleDifensori.setSelected(false);
        this.toggleAll.setSelected(false);

        fillAttackerTable();
    }//GEN-LAST:event_toggleAttaccantiActionPerformed

    private void toggleCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleCentroActionPerformed
        this.togglePortieri.setSelected(false);
        this.toggleAttaccanti.setSelected(false);
        this.toggleDifensori.setSelected(false);
        this.toggleAll.setSelected(false);

        fillMidfielderTable();
    }//GEN-LAST:event_toggleCentroActionPerformed

    private void toggleDifensoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleDifensoriActionPerformed
        this.togglePortieri.setSelected(false);
        this.toggleAttaccanti.setSelected(false);
        this.toggleCentro.setSelected(false);
        this.toggleAll.setSelected(false);

        fillDifenseTable();
    }//GEN-LAST:event_toggleDifensoriActionPerformed

    private void togglePortieriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglePortieriActionPerformed

        this.toggleAll.setSelected(false);
        this.toggleAttaccanti.setSelected(false);
        this.toggleCentro.setSelected(false);
        this.toggleDifensori.setSelected(false);

        fillGoalKeeperTable();

    }//GEN-LAST:event_togglePortieriActionPerformed

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed

        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            
          
        try{
            int oldCash = this.cassaSquadre.get(this.jComboBox1.getSelectedItem().toString()).getCash();
            this.cassaSquadre.get(this.jComboBox1.getSelectedItem().toString()).setCash(oldCash - Integer.parseInt(jTextFieldPrice.getText()));
        }
        catch(Exception e){
            System.err.println(e);
        }
        
        try{
            int oldCharge = this.cassaSquadre.get(this.jComboBox1.getSelectedItem().toString()).getCharge();
            this.cassaSquadre.get(this.jComboBox1.getSelectedItem().toString()).setCharge(oldCharge + Integer.parseInt(jTextFieldPrice.getText()));
        }
        catch(Exception e){
            System.err.println(e);
        }
        try{
        loadCashTeam();}
        catch(Exception e){
            System.err.println(e);
        }
        
        this.saveQuotes.deleteQuotes();
        this.buttonSave.setEnabled(true);
        for(List<Player> l : this.listaPlayers){
            for(Player p : l){
                if(p.getNome().equals(this.jTextField1.getText())){

                    p.setQuotazione(Integer.parseInt(this.jTextFieldQuot.getText()));
                    p.setBuyPrice(Integer.parseInt(this.jTextFieldPrice.getText()));
                    p.setFantaTeam(this.jComboBox1.getSelectedItem().toString());
                    p.setScadenza(this.jComboBoxScadenza.getSelectedItem().toString());
                    p.setRinnovabile(this.jComboBoxRinnovo.getSelectedItem().toString());
                }

            }
        }

        this.jTable1.setValueAt(Integer.parseInt(jTextFieldQuot.getText()), jTable1.getSelectedRow(), 2);
        this.jTable1.setValueAt(Integer.parseInt(jTextFieldPrice.getText()), jTable1.getSelectedRow(), 4);
        this.jTable1.setValueAt(this.jComboBox1.getSelectedItem().toString(), jTable1.getSelectedRow(), 5);
        this.jTable1.setValueAt(this.jComboBoxScadenza.getSelectedItem().toString(), jTable1.getSelectedRow(), 6);
        this.jTable1.setValueAt(this.jComboBoxRinnovo.getSelectedItem().toString(), jTable1.getSelectedRow(), 7);
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed

        this.saveQuotes.saveQuotes(listaPlayers);
        this.saveQuotes.saveCashes(cassaSquadre);

    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModActionPerformed

        this.buttonApply.setEnabled(true);
        this.jTextField1.setText(this.jTable1.getValueAt( this.jTable1.getSelectedRow(), 0).toString());
        this.jTextFieldQuot.setText(this.jTable1.getValueAt( this.jTable1.getSelectedRow(), 2).toString());
        this.jTextFieldPrice.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString());

    }//GEN-LAST:event_buttonModActionPerformed

    private void jTextFieldSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSystemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSystemActionPerformed

    public JTextField getjTextFieldSystem() {
        return jTextFieldSystem;
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuotazioniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuotazioniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuotazioniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuotazioniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new QuotazioniUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(QuotazioniUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

     public HashMap<String, Cash> getCassaSquadre() {
        return cassaSquadre;
    }

    
   
    public  ArrayList<ArrayList<Player>> getListaPlayers() {
        return listaPlayers;
    }

    public  void setListaPlayers(ArrayList<ArrayList<Player>> listaPlayers) {
        this.listaPlayers = listaPlayers;
    }
    
    private PlayerExtractor extractor = new PlayerExtractor();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonMod;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton jButtonExtract;
    private javax.swing.JButton jButtonLoad;
    private javax.swing.JButton jButtonLocal;
    private javax.swing.JButton jButtonSafeReconnect;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxRinnovo;
    private javax.swing.JComboBox jComboBoxScadenza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldCash1;
    private javax.swing.JTextField jTextFieldCash10;
    private javax.swing.JTextField jTextFieldCash11;
    private javax.swing.JTextField jTextFieldCash12;
    private javax.swing.JTextField jTextFieldCash2;
    private javax.swing.JTextField jTextFieldCash3;
    private javax.swing.JTextField jTextFieldCash4;
    private javax.swing.JTextField jTextFieldCash5;
    private javax.swing.JTextField jTextFieldCash6;
    private javax.swing.JTextField jTextFieldCash7;
    private javax.swing.JTextField jTextFieldCash8;
    private javax.swing.JTextField jTextFieldCash9;
    private javax.swing.JTextField jTextFieldCharge1;
    private javax.swing.JTextField jTextFieldCharge10;
    private javax.swing.JTextField jTextFieldCharge11;
    private javax.swing.JTextField jTextFieldCharge12;
    private javax.swing.JTextField jTextFieldCharge2;
    private javax.swing.JTextField jTextFieldCharge3;
    private javax.swing.JTextField jTextFieldCharge4;
    private javax.swing.JTextField jTextFieldCharge5;
    private javax.swing.JTextField jTextFieldCharge6;
    private javax.swing.JTextField jTextFieldCharge7;
    private javax.swing.JTextField jTextFieldCharge8;
    private javax.swing.JTextField jTextFieldCharge9;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldQuot;
    private javax.swing.JTextField jTextFieldSystem;
    private javax.swing.JTextField jTextFieldT1;
    private javax.swing.JTextField jTextFieldT10;
    private javax.swing.JTextField jTextFieldT11;
    private javax.swing.JTextField jTextFieldT12;
    private javax.swing.JTextField jTextFieldT2;
    private javax.swing.JTextField jTextFieldT3;
    private javax.swing.JTextField jTextFieldT4;
    private javax.swing.JTextField jTextFieldT5;
    private javax.swing.JTextField jTextFieldT6;
    private javax.swing.JTextField jTextFieldT7;
    private javax.swing.JTextField jTextFieldT8;
    private javax.swing.JTextField jTextFieldT9;
    private javax.swing.JToggleButton toggleAll;
    private javax.swing.JToggleButton toggleAttaccanti;
    private javax.swing.JToggleButton toggleCentro;
    private javax.swing.JToggleButton toggleDifensori;
    private javax.swing.JToggleButton togglePortieri;
    // End of variables declaration//GEN-END:variables

    public void setCassaSquadre(HashMap<String, Cash> cashes) {
        this.cassaSquadre = cashes; 
    }
}
