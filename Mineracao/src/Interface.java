
import java.io.File;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author murilo
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
              
    }
    
    private String path = "";
    private String path_saida = "";
    private String textoFinal ="";
    private String atributos = "";
    Arquivo arq = new Arquivo();
    Algoritmo alg = new Algoritmo();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        painelEntrada = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        Status_arquivo = new javax.swing.JLabel();
        bExecutar = new javax.swing.JButton();
        aviso = new javax.swing.JLabel();
        cxClasse = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cxAt1 = new javax.swing.JComboBox();
        cxAt2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cxN = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        entradaTx = new javax.swing.JTextField();
        bClassificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSalvar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelEntrada.setEditable(false);
        jScrollPane2.setViewportView(painelEntrada);

        jLabel1.setText("Resultados:");

        bExecutar.setText("Exibir base de treino");
        bExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExecutarActionPerformed(evt);
            }
        });

        cxClasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Selecione o atributo a ser classificado:");

        jLabel3.setText("Selecione a caracteristica relevante 1 :");

        jLabel4.setText("Selecione a caracteristica relevante 2 :");

        cxAt1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxAt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxAt1ActionPerformed(evt);
            }
        });

        cxAt2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Valor do N:");

        cxN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "3" }));
        cxN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxNActionPerformed(evt);
            }
        });

        jLabel6.setText("Insiria um novo item a ser classificado:");

        entradaTx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaTxActionPerformed(evt);
            }
        });

        bClassificar.setText("Classificar item");
        bClassificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClassificarActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setText("Iportante: Insira os dados na mesma ordem em que os atributos estão dispostos na base de dados, separe cada atributo por virgula.\nExemplos de entrada: -,5.5,7.6 |  (branco), 4.6 , 6.8 - note que o campo a ser classificado pode ficar em branco ou qualquer coisa");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(aviso, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                    .addComponent(Status_arquivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bExecutar)
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(entradaTx, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bClassificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cxAt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cxClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cxAt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(cxN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Status_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bExecutar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cxClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cxN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cxAt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cxAt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bClassificar)
                    .addComponent(entradaTx, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Abrir arquivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuSalvar.setText("Salvar arquivo");
        menuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalvar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Metodo executado quando o item "abrir arquivo" do menu for acionado.
     * Executa JFileChooser e ler o arquivo selecionado e mostra no painel. 
     * @param evt 
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         /* pegar o caminho do arquivo para leitura*/
        
        JFileChooser file = new JFileChooser(); 
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //filtro apenas para arquivos txt e arff
        file.addChoosableFileFilter(new FileNameExtensionFilter( "Arquivo arff (*.arff)", "arff"));
        file.addChoosableFileFilter(new FileNameExtensionFilter( "Arquivo texto (*.txt)", "txt"));
        
        file.setAcceptAllFileFilterUsed(false);  
        // Impede seleções múltiplas.  
        file.setMultiSelectionEnabled(false);  
          int i= file.showSaveDialog(null);
       
        if (i==1){
           this.path="erro ao abrir arquivo";
           this.Status_arquivo.setText(path);
        } else {
            File arquivo = file.getSelectedFile();
            this.path=arquivo.getPath();
            System.out.println(arquivo.getPath());
            this.Status_arquivo.setText("Arquivo: "+path+" aberto, escolha as opções e execute.");
            
            //chamada do método de leitura de arquivo
            //Arquivo arq = new Arquivo();
            
            arq.read(path);
            
        }
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
      
    }//GEN-LAST:event_jMenu1ActionPerformed
    /**
     * Metodo executado quando o item "Salvar arquivo" do menu for acionado.
     * Executa JFileChooser pega o path da pasta selecionada e cria um arquivo Saida.txt. 
     * @param evt 
     */
    private void menuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarActionPerformed
        JFileChooser file = new JFileChooser(); 
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //filtro apenas para arquivos txt
        //file.addChoosableFileFilter(new FileNameExtensionFilter( "Arquivo texto (*.txt)", "txt"));  
        file.setAcceptAllFileFilterUsed(false);  
        // Impede seleções múltiplas.  
        file.setMultiSelectionEnabled(false);  
          int i= file.showSaveDialog(null);
       
        if (i==1){
           this.path_saida="Erro diretorio inválido";
           this.Status_arquivo.setText(path_saida);
        } else {
            File arquivo = file.getSelectedFile();
            this.path_saida=arquivo.getPath();
            //System.out.println(arquivo.getPath());
            this.Status_arquivo.setText("Arquivo salvo em: "+path_saida+"\\Saida.txt");
            
           // Arquivo arq = new Arquivo();
            String t = textoFinal.replaceAll("%", "%%"); //no metodo de salvar arquivo o % é um caracter de escape e precisa ter %% pra ler como %
            String fim = t.replaceAll("\n", "%n"); //quebra de linha no metodo de salvar arquivo é %n
            arq.writer(fim, this.path_saida);
            
            
          
        }
    }//GEN-LAST:event_menuSalvarActionPerformed

    private void bExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExecutarActionPerformed
        LinkedList<String> linha =  new LinkedList<>();
        linha = arq.getLinhas(); //pega as linhas do arquivo lid
        
        alg.lerLinhas(linha);
        textoFinal = " "; 
        
        cxAt1.removeAllItems();
        cxAt2.removeAllItems();
        cxClasse.removeAllItems();
        cxAt2.addItem("Nulo");
           System.out.println("Nome dos atributos na interface");
        for(String j:alg.atributos){
            this.atributos = this.atributos+j+" - ";
            cxClasse.addItem(j);
            cxAt1.addItem(j);
            cxAt2.addItem(j);
            System.out.println(j);
        }
       
        this.atualizarPainel();
        
        
        
        
        /*
        String text="";
        for (String linha1 : linha) {
            if(linha1!=null){// a ultima posição na lista é null 
                text= text+linha1+"\n";
            }    
        }
        */
        
    }//GEN-LAST:event_bExecutarActionPerformed
    
    public void atualizarPainel(){
        textoFinal = "";
        
      
        textoFinal = this.atributos+"\n";
        System.out.println("************************************************************************");
        System.out.println("****************** Valores dos atributos armazenados na lista *********************");
        for(int k=0; k<alg.dadosLinha.size(); k++){
            System.out.println(" ");
            
            System.out.println("Linha: "+k);
            //System.out.println(" qnt de elementos na linha"+alg.dadosLinha.get(k).size() );
            for(int z=0; z<alg.qntAtributos; z++){
                textoFinal = textoFinal + alg.dadosLinha.get(k).get(z)+" - ";
                System.out.print("Pos: "+z+" Valor: "+alg.dadosLinha.get(k).get(z)+" ");
                if(z+1==alg.qntAtributos){
                    textoFinal =textoFinal+"\n";
                }
                
            }
        }
        
        this.painelEntrada.setText(textoFinal);
    }
    
    
    private void cxAt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxAt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxAt1ActionPerformed

    private void entradaTxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaTxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaTxActionPerformed

    private void cxNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxNActionPerformed

    private void bClassificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClassificarActionPerformed
        String  n = cxN.getSelectedItem().toString();
        String classePrincipal = cxClasse.getSelectedItem().toString();
        String ele1 =  cxAt1.getSelectedItem().toString();
        String ele2 = cxAt2.getSelectedItem().toString();
        
        //teste
        System.out.println(n+classePrincipal+ele1+ele2);
        
        if(!classePrincipal.equals(ele1) && !classePrincipal.equals(ele2)){
            aviso.setText(" ");
            if(ele1.equals(ele2)){
                aviso.setText("As caracteristicas selecionadas são as mesmas, selecione outra");
            }else{
                aviso.setText(" ");
                alg.salvarIdAtributos(classePrincipal);//pegar os id de cada atributo
                //teste
                System.out.println(alg.idAtributoClasse);
                
                
                LinkedList<String> linhaEntrada =  new LinkedList<>();
                String temp[];
                temp=entradaTx.getText().split(",");
                 for(String p:temp){
                        linhaEntrada.add(p);
                        System.out.println(p);
                 }
                
                 String classe = alg.start(linhaEntrada, 1);
                 aviso.setText("Item classificado como: "+classe);
                 
                 Linha adicionar =  new Linha();
                 
                 for(int j=0; j<temp.length;j++){
                     if(j==alg.idAtributoClasse){
                         adicionar.add(classe);
                     }else{
                         adicionar.add(temp[j]);
                     }
                        
                 }
                 alg.dadosLinha.add(adicionar);
                 this.atualizarPainel();
                //roda algoritmo
                //double teste = alg.calcularDistancia(5, 5, 10, 10);
                //System.out.println(teste);
                
            }
        }else{
            aviso.setText("Certifique-se que o atributo a ser classificado é diferente das caracteristicas selecionadas.");
        }
                
    }//GEN-LAST:event_bClassificarActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Status_arquivo;
    private javax.swing.JLabel aviso;
    private javax.swing.JButton bClassificar;
    private javax.swing.JButton bExecutar;
    private javax.swing.JComboBox cxAt1;
    private javax.swing.JComboBox cxAt2;
    private javax.swing.JComboBox cxClasse;
    private javax.swing.JComboBox cxN;
    private javax.swing.JTextField entradaTx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenuItem menuSalvar;
    private javax.swing.JTextPane painelEntrada;
    // End of variables declaration//GEN-END:variables
}
