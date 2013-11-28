package com.logs;

import cotizador.dao.CotizadorDao;
import java.util.logging.Logger;

public class CotizadorLog {
        private static volatile CotizadorLog instance = null;
 
        public static Logger logger;
        private CotizadorLog() {       }
 
        public static CotizadorLog getInstance() {
                if (instance == null) {
                        synchronized (CotizadorLog.class){
                                if (instance == null) {
                                        instance = new CotizadorLog ();
                                       
                                }
                      }
                }
                return instance;
        }
        
      
         public void log(String mensaje){
             
             CotizadorDao dao = new CotizadorDao("latam1");
             dao.ejecutar("insert into logger values('"+mensaje+"',null)");
             System.out.println(mensaje);
         }
}