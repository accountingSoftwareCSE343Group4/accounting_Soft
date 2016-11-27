
package accounting.software;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;

/**
 *
 * @author Şahin Eğilmez
 *
 * This class take gasoline, diesel by Aytemiz Petrol and LPG price by İpragaz
 * from internet and use them.
 * 
 * Class Usage :
 *
 * if (TakeDataOnline.getInstance().getStateInternet()) {
 *      double gasoline = TakeDataOnline.getInstance().getGasoline();
 *      double diesel   = TakeDataOnline.getInstance().getDiesel();
 *      double lpg      =TakeDataOnline.getInstance().getLpg();
 * } 
 * else {
 *      /* There is no internet connection. So should show info for user.  
 * }
 *
 */
public class TakeDataOnline {

    private final String urlPetrol = "http://www.aytemiz.com.tr/faaliyet-alanlari-hizmetler/"
            + "istasyonlar-hakkinda/akaryakit-ve-pompa-fiyatlari/yakit-fiyatlari";
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

    private TakeDataOnline() {
    }

    /**
     *
     * @throws MalformedURLException
     * @throws IOException input otput
     * @throws SocketException No interenet connection
     *
     * This method parse urlPetrol and urlLpg website. And set gasoline,diesel,
     * LPG price.
     */
    private void urlParser() throws MalformedURLException, IOException, SocketException {
        URL site = new URL(urlPetrol);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(site.openStream()))) {
            String inputLine;
            String[] blocks = null;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("İstanbul / Anadolu")) {
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
            blocks[2] = blocks[2].replace(",", ".");
            setGasoline(Double.parseDouble(blocks[2]));
            blocks[6] = blocks[6].replace(",", ".");
            setDiesel(Double.parseDouble(blocks[6]));
            site.openStream().close();
            in.close();

        } catch (SocketException ex) {
            ex.printStackTrace();
        }

        URL site2 = new URL(urlLpg);

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

        } catch (SocketException ex) {
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
        try {
            INSTANCE.urlParser();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
     * @throws IOException
     *
     * This method must use before using instance, because if internet
     * connection not open, not taking data naturally.
     */
    public boolean getStateInternet() throws IOException {
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
