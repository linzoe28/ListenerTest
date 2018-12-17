/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listenertest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author user
 */
@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            sce.getServletContext().log("test init");
            ComboPooledDataSource cp= new ComboPooledDataSource();
            cp.setDriverClass("com.mysql.jdbc.Driver");
            cp.setJdbcUrl("jdbc:mysql://localhost/test");
            cp.setUser("root");
            cp.setPassword("");
            cp.setMaxPoolSize(10);
            cp.setMinPoolSize(3); //確保同時連線資料庫數量
            cp.setMaxIdleTime(30); //連線時間，時間到自動斷掉連線
            sce.getServletContext().setAttribute("cp", cp);
            
        } catch (PropertyVetoException ex) {
            Logger.getLogger(StartupListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
