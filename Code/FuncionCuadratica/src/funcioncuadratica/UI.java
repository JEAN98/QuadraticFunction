
package funcioncuadratica;

//  ²  Alt+253  with allow us to make the elevation 

import javax.swing.JOptionPane;

public class UI extends javax.swing.JFrame {
    float a = 0;
    float b = 0;
    float c = 0;
    String cFunction ="";
    String result = "";
    
    public UI() {
        initComponents();
        
    }
    
    private boolean findFunction(){
    try{
        result = "";
         //Get part A
        int lastPositionA =0;
        lastPositionA = cuadraticFunction(1,0);
        a = Float.valueOf(cFunction.substring(0,lastPositionA));
        result += "A= "+ String.valueOf(a);
       
        //Get part B
        //here we must to add in lastPosition plus 2, because of this way we can get start of "b"
        int lastPositionB = cuadraticFunction(2,lastPositionA+1);
        b = Float.valueOf(cFunction.substring(lastPositionA+2,lastPositionB));
        result += "  B= "+ String.valueOf(b);
        
        //Get part C
        String test = cFunction.substring(lastPositionB + 1,cFunction.length());
        c = Float.valueOf(test);
        result += "  C= "+ String.valueOf(c);
        return true;
    }           
       catch(Exception ex){
           JOptionPane.showMessageDialog(null, "You must to fill the space with cuadratic function!", "Problems", JOptionPane.ERROR_MESSAGE);
           return false;
       }
    
        
    }
    private int cuadraticFunction(int caseType,int startIn){
        //In this method we can finding the position of X²(part A) AND ONLY X (part B)
        //caseType 1 = a, caseType 2 = b
        String test="";
        cFunction = jTextFieldFunction.getText();
        int i = startIn;
        while (i < cFunction.length()) {
            if (caseType == 1) {
                if (i < cFunction.length() - 1) {
                    test = String.valueOf(cFunction.charAt(i)) + String.valueOf(cFunction.charAt(i + 1));
                    if (test.equals("X²")) {
                        System.out.println(i);
                        return i; //we FOUND X²
                    }
                }
            } else if (caseType == 2) {
                test = String.valueOf(cFunction.charAt(i));
                if (test.equals("X")) {
                    return i; //we FOUND X
                }
            }
            i++;
        }
        return 0;
    }
    private void showInformation(){
        jTextArea.setText("");
        jTextArea.setText(result);
    }
    
    private boolean verifyText(){
        if(jTextArea.getText() != "")
            return true;
        return false;
    } 
   
   private float getEjeSimetria(){
       float ejeSimetria = (float)-b/(2*a);
      result += "\n";result += "\n";
      result += "Eje de simetría en: (" +String.valueOf(ejeSimetria)+" ,0)";
              
      return ejeSimetria;
   }
    
   private void cutInX(){
       float dis =getDiscriminating();
       result += "\n";  result += "\n";
       result += "Corte en x: ";
       if(dis > 0){
           //Two solutions
           float x1 = (float)(-b + Math.sqrt(dis))/2*a;
           float x2 = (float)(-b - Math.sqrt(dis))/2*a;
           result += "("+String.valueOf(x1) +" , 0)"; 
           result += "   ("+String.valueOf(x2) +" , 0)"; 
           return;
       }
       else if( dis == 0){
           //One solution
             float x1 = (float)(-b + Math.sqrt(dis))/2*a;
             result += "("+String.valueOf(x1) +" , 0)"; 
             return;
       }
       else
         result += "Empty!";   //Soltion empty
    }
   private float getDiscriminating(){
        float dis = (float)(Math.pow(b, 2))-4*a*c;
        return dis;
    }
    
    private void cutInY(){
        String cutY = "Corte de y: (0 , " + String.valueOf(c) + ")";
        result += "\n" + "\n";
        result += cutY;
    }
    
    private void vertice(){
        float y = -(getDiscriminating())/4*a;
        float ejeSimetria = (float)-b/(2*a);
        String vertex = "Vertice: ("+ejeSimetria+", "+String.valueOf(y)+")";
        result +="\n"+"\n";
        result += vertex;
        
        
    }
    
    private void rank(){
        float y = -(getDiscriminating())/4*a;
        String rank = "El rango es: ("+y+", +∞)" ;
        result +="\n"+"\n";
        result += rank;
    }
    
    private void rise(){
        float y = -(getDiscriminating())/4*a;
        String rise = "Crece de: ("+y+", +∞)" ;
        result +="\n"+"\n";
        result += rise;
    
    }
    
    private void decreases(){
         float y = -(getDiscriminating())/4*a;
        String decreases = "Decrece de: (-∞, "+y+ ")" ;
        result +="\n"+"\n";
        result += decreases;
    
    }
    
    private void point(){
        if(a < 0){
            String max = "Punto máximo.";
            result +="\n"+"\n";
        result += max;
        }
        else{
            String min = "Punto minimo.";
            result +="\n"+"\n";
        result += min;
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextFieldFunction = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(77, 208, 225));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 152, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to Quadratic function JS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(498, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1432, 42);

        jPanel1.setBackground(new java.awt.Color(255, 243, 224));

        jButton1.setBackground(new java.awt.Color(255, 152, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Show function");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldFunction.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Quadratic function here");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rule.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(487, 487, 487)
                        .addComponent(jTextFieldFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(290, 290, 290))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(264, 264, 264)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(254, 254, 254))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 1590, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int proof = Integer.valueOf("-23");
      
        if(findFunction()){
            cutInY();
            cutInX();
            getEjeSimetria();
            vertice();
            rank();
            rise();
            decreases();
            point();
        }
        else
             result = "";
            
         showInformation();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTextFieldFunction;
    // End of variables declaration//GEN-END:variables
}
