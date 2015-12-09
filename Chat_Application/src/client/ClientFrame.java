package client;

import java.util.Calendar;
import java.util.LinkedList;





public class ClientFrame extends javax.swing.JFrame {
    
    Client client;
    Calendar last_update;

    public ClientFrame(Client client) {
        
        this.client = client;
        this.last_update=Calendar.getInstance();
        initComponents();
        refresh.start();
        
    }
           
             
          
           Thread refresh = new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(10000);
                        get_chat();
                        user_list();
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
    
    
    public void get_chat(){
        LinkedList<String> stories = client.get_chat(client.username, this.last_update);
        for(String story:stories){
            this.chat_window.append(story+"\n");
        }
        this.last_update=Calendar.getInstance();
    }

    public void user_list(){
        LinkedList<String> usernames = client.user_list(client.username, this.last_update);
        this.online_users.setText("");
        for(String user: usernames){
            this.online_users.append(user+"\n");
        }
        this.last_update=Calendar.getInstance();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        send = new javax.swing.JButton();
        scroll_panel = new javax.swing.JScrollPane();
        chat_window = new javax.swing.JTextArea();
        chat_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        online_users = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(client.username);
        setName(this.client.username);

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        chat_window.setColumns(20);
        chat_window.setRows(5);
        scroll_panel.setViewportView(chat_window);

        online_users.setColumns(20);
        online_users.setRows(5);
        jScrollPane1.setViewportView(online_users);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chat_txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(send)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send)
                    .addComponent(chat_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        String story=this.chat_txt.getText();
        Calendar date=Calendar.getInstance();
        String str_date=date.get(Calendar.MONTH) + 1 + "/"+date.get(Calendar.DATE)+"  "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
        this.chat_window.append(this.client.username+"("+str_date+"): "+story+"\n");
        this.client.send_story(this.client.username, date, story);
        this.chat_txt.setText("");
    }//GEN-LAST:event_sendActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chat_txt;
    private javax.swing.JTextArea chat_window;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea online_users;
    private javax.swing.JScrollPane scroll_panel;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}
