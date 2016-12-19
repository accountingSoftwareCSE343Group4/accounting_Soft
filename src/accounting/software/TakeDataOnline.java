package accounting.software;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Şahin Eğilmez
 *
 * This class take gasoline, diesel by Lukoil Petrol and LPG price by İpragaz
 * from internet and use them.
 *
 * Class Usage :
 *
 * if (TakeDataOnline.getInstance().getStateInternet()) { double gasoline =
 * TakeDataOnline.getInstance().getGasoline(); double diesel =
 * TakeDataOnline.getInstance().getDiesel(); double lpg
 * =TakeDataOnline.getInstance().getLpg(); } else { /* There is no internet
 * connection. So should show info for user. }
 *
 */
public class TakeDataOnline {

    private final String urlPetrol = "http://www.lukoil.com.tr/PompaFiyatlari";
    private final String urlLpg = "http://www.ipragaz.com.tr/otogaz-pompa-fiyatlari."
            + "asp?Sehir=%DDST./ANADOLU";
    private Double gasoline;  //gasoline price
    private Double diesel;    //diesel price
    private Double lpg;       // LPG price

    /**
     *
     * @param pierce of gasoline
     */
    private void setGasoline(double pierce) {
        gasoline = pierce;
    }

    /**
     *
     * @param pierce of diesel
     */
    private void setDiesel(double pierce) {
        diesel = pierce;
    }

    /**
     *
     * @param pierce of LPG
     */
    private void setLpg(double pierce) {
        lpg = pierce;
    }

    private static final TakeDataOnline INSTANCE = new TakeDataOnline();

    public TakeDataOnline() {
    }

    /**
     *
     */
    public void urlParser() {
        URL site2 = null;
        try {
            site2 = new URL(urlLpg);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TakeDataOnline.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(site2.openStream()))) {
            String inputLine;
            String[] blocks = null;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("<p><span  class=\"tl\">")) {
                    blocks = inputLine.split("<p><span  class=\"tl\">|</span> / Litre</p>");
                    break;
                }
            }
            blocks[1] = blocks[1].replace(",", ".");
            setLpg(Double.parseDouble(blocks[1]));
            site2.openStream().close();
            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        URL site = null;
        try {
            site = new URL(urlPetrol);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TakeDataOnline.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(site.openStream()))) {
            String inputLine;
            String[] blocks = null;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("<td>ISTANBUL_ANA</td>")) {
                    String block = null;
                    for (int k = 0; k < 5; k++) {
                        if ((inputLine = in.readLine()) != null) {
                            block = block + inputLine;
                        }
                    }
                    blocks = block.split("<td>|</td>");
                    break;
                }

            }
            setGasoline(Double.parseDouble(blocks[1]));;
            setDiesel(Double.parseDouble(blocks[5]));
            site.openStream().close();
            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     *
     * @return TakeDataOnline
     *
     * You should use instance method
     */
    public static TakeDataOnline getInstance() {
        INSTANCE.urlParser();
        return INSTANCE;
    }

    /**
     *
     * @return gasoline price
     */
    public Double getGasoline() {
        return gasoline;
    }

    /**
     *
     * @return diesel price
     */
    public Double getDiesel() {
        return diesel;
    }

    /**
     *
     * @return LPG price
     */
    public Double getLpg() {
        return lpg;
    }

    /**
     *
     * @return if internet connection acceptable ,return true. Else false
     */
    public boolean getStateInternet() {
        try {
            try {
                URL url = new URL("http://www.google.com");//Test by google
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                if (con.getResponseCode() == 200) {
                    return true;
                }
            } catch (Exception exception) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}