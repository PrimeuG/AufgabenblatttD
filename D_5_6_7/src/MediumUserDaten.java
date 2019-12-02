//Tom Cybart 17469

/**
 * The type Medium user daten.
 */
public class MediumUserDaten {

    private String username;                                                                                                        //Username und IP
    private String ip;

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets ip.
     *
     * @param ip the ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {                                                                                                       //Falls weder Username noch IP gesetzt gibt er Fehlermeldung zuürck, falls nur eins vorhanden, gibt er das jeweilige aus, falls beides vorhanden gibt er beides aus
        if (ip == null && username == null) {
            return "Fehler kein Benutzer vorhanden!";
        } else if (ip != null && username == null) {
            return ip + "IP";
        } else if (ip == null && username != null ) {
            return username;
        } else {
            return "IP: " + this.ip + "von Benutzer: " + this.username;
        }
    }
}