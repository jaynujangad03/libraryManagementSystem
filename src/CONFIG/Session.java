/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONFIG;

/**
 *
 * @author ADMIN
 */
public class Session {
    
    private static Session instance;
    private int uid;
    private String UN;
    private String EMAIL;
    private String CONTACT;
    private String PD;
    private String status;
    
    private Session(){
        //private cons.prevents instance
      
    }

    public static synchronized Session getInstance() {
        if(instance==null){
            instance = new Session();
        }
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUN() {
        return UN;
    }

    public void setUN(String UN) {
        this.UN = UN;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    public String getPD() {
        return PD;
    }

    public void setPD(String PD) {
        this.PD = PD;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
