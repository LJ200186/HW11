package guitesting;

import java.text.DecimalFormat;
import java.util.concurrent.CompletableFuture;

public class TesterGUI extends javax.swing.JFrame {
    
    public static long CursorEnd = 0;
    public static long CursorOwned = 0;
    public static float CursorCost = 15;
    
    public static long GrandmaEnd = 0;
    public static long GrandmaOwned = 0;
    public static float GrandmaCost = 100;
    
    public float PTotal = 0;

    /**
     * Creates new form TesterGUI
     */
    public TesterGUI() {
        initComponents();
        
        CompletableFuture.runAsync(() -> {
            CursorChecker();
        });
        CompletableFuture.runAsync(() -> {
            GrandmaChecker();
        });
        CompletableFuture.runAsync(() -> {
            Rounder();
        });
    }
    
    public void Rounder(){
        while(true){
            
            DecimalFormat df2 = new DecimalFormat("0");
            CursorCost = Float.parseFloat(df2.format(CursorCost));
            GrandmaCost = Float.parseFloat(df2.format(GrandmaCost));
            System.out.print("");
            CursorPurchase.setText("Purchase ($"+CursorCost+")");
            GrandmaPurchase.setText("Purchase ($"+GrandmaCost+")");
            
            String StrPTotal = Float.toString(PTotal);
            int integerPlaces = StrPTotal.indexOf('.');
            int decimalPlaces = StrPTotal.length() - integerPlaces - 1;
            
            if(decimalPlaces > 1){
                System.out.println("Round");
                DecimalFormat df = new DecimalFormat("0.0");
                PTotal = Float.parseFloat(df.format(PTotal));
                Total.setText("Total: " + (PTotal));
            }
            
            
            
            
            
        }
    }
    
    public long ToMilli(long Nano){
        
            long Milli = Nano / 1000000;
        
        return Milli;
    }
    
    public void CursorChecker(){
        
        while(true){
            
            System.out.print("");
        
            if(CursorOwned != 0){

                CursorEnd = System.nanoTime() + 1000000000;

                while(CursorEnd > System.nanoTime()){

                    int Difference = (int) (ToMilli(CursorEnd) - ToMilli(System.nanoTime()));
                    float Difference2 = 100-(((float) Difference / 1000)*100);

                    CursorBar.setValue((int) Difference2);

                }

                CursorBar.setValue(0);
                PTotal = (float) (PTotal + (0.2 * CursorOwned));
                Total.setText("Total: " + (PTotal));

            }
        }
    }
    
    public void GrandmaChecker(){
        
        while(true){
            
            System.out.print("");
        
            if(GrandmaOwned != 0){

                GrandmaEnd = System.nanoTime() + 1000000000;

                while(GrandmaEnd > System.nanoTime()){

                    int Difference = (int) (ToMilli(GrandmaEnd) - ToMilli(System.nanoTime()));
                    float Difference2 = 100-(((float) Difference / 1000)*100);

                    GrandmaBar.setValue((int) Difference2);

                }

                GrandmaBar.setValue(0);
                PTotal = (float) (PTotal + (2 * GrandmaOwned));
                Total.setText("Total: " + (PTotal));

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jFrame2 = new javax.swing.JFrame();
        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        Total = new javax.swing.JLabel();
        CursorLabel = new javax.swing.JLabel();
        BasicClickerButton = new javax.swing.JButton();
        CursorBar = new javax.swing.JProgressBar();
        CursorPurchase = new javax.swing.JButton();
        GrandmaLabel = new javax.swing.JLabel();
        GrandmaBar = new javax.swing.JProgressBar();
        GrandmaPurchase = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Total.setText("Total:");

        CursorLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CursorLabel.setText("Cursor (+$0.2 CPS - 0 Owned)");

        BasicClickerButton.setText("Manual Click (+1 p/c)");
        BasicClickerButton.setBorder(null);
        BasicClickerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BasicClickerButtonActionPerformed(evt);
            }
        });

        CursorPurchase.setText("Purchase ($15)");
        CursorPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursorPurchaseActionPerformed(evt);
            }
        });

        GrandmaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GrandmaLabel.setText("Grandma (+$2 CPS - 0 Owned)");

        GrandmaPurchase.setText("Purchase ($100)");
        GrandmaPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrandmaPurchaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CursorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CursorPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GrandmaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GrandmaPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CursorBar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BasicClickerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GrandmaBar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CursorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(CursorBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CursorPurchase))
                    .addComponent(BasicClickerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GrandmaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GrandmaBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrandmaPurchase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BasicClickerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BasicClickerButtonActionPerformed

                PTotal = PTotal + 1;
                Total.setText("Total: " + (PTotal));

    }//GEN-LAST:event_BasicClickerButtonActionPerformed

    private void CursorPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursorPurchaseActionPerformed
        if(PTotal >= CursorCost){
            
            PTotal = PTotal - CursorCost;
            CursorCost = (float) (CursorCost * 1.15);
            System.out.println(CursorCost);
            CursorOwned++;
            
            Total.setText("Total: " + (PTotal));
            
            
            float NumCursorCPS = (float) (CursorOwned*0.2);
            double CursorCPS = (Math.floor(100 * NumCursorCPS) / 100);

            CursorLabel.setText("Cursor (+$"+CursorCPS+" CPS - "+ CursorOwned + " Owned)");
        }
    }//GEN-LAST:event_CursorPurchaseActionPerformed

    private void GrandmaPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrandmaPurchaseActionPerformed
        if(PTotal >= GrandmaCost){
            
            PTotal = PTotal - GrandmaCost;
            GrandmaCost = (float) (GrandmaCost * 1.15);
            System.out.println(GrandmaCost);
            GrandmaOwned++;
            
            Total.setText("Total: " + (PTotal));
            
            
            float NumGrandmaCPS = (float) (GrandmaOwned*2);
            double GrandmaCPS = (Math.floor(100 * NumGrandmaCPS) / 100);

            GrandmaLabel.setText("Grandma (+$"+GrandmaCPS+" CPS - "+ GrandmaOwned + " Owned)");
        }
    }//GEN-LAST:event_GrandmaPurchaseActionPerformed

    public void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(TesterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesterGUI().setVisible(true);
            }
        });
        
        System.out.println("got here");
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BasicClickerButton;
    private javax.swing.JProgressBar CursorBar;
    private javax.swing.JLabel CursorLabel;
    private javax.swing.JButton CursorPurchase;
    private javax.swing.JProgressBar GrandmaBar;
    private javax.swing.JLabel GrandmaLabel;
    private javax.swing.JButton GrandmaPurchase;
    private javax.swing.JLabel Total;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables

}
