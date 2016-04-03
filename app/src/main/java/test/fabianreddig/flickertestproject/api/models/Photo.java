
package test.fabianreddig.flickertestproject.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private int farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private int ispublic;
    @SerializedName("isfriend")
    @Expose
    private int isfriend;
    @SerializedName("isfamily")
    @Expose
    private int isfamily;
    @SerializedName("originalsecret")
    @Expose
    private String originalsecret;
    @SerializedName("originalformat")
    @Expose
    private String originalformat;
    @SerializedName("url_q")
    @Expose
    private String urlQ;
    @SerializedName("height_q")
    @Expose
    private String heightQ;
    @SerializedName("width_q")
    @Expose
    private String widthQ;
    @SerializedName("url_n")
    @Expose
    private String urlN;
    @SerializedName("height_n")
    @Expose
    private int heightN;
    @SerializedName("width_n")
    @Expose
    private String widthN;
    @SerializedName("url_c")
    @Expose
    private String urlC;
    @SerializedName("height_c")
    @Expose
    private int heightC;
    @SerializedName("width_c")
    @Expose
    private String widthC;
    @SerializedName("url_h")
    @Expose
    private String urlH;
    @SerializedName("height_h")
    @Expose
    private int heightH;
    @SerializedName("width_h")
    @Expose
    private String widthH;
    @SerializedName("url_o")
    @Expose
    private String urlO;
    @SerializedName("height_o")
    @Expose
    private String heightO;
    @SerializedName("width_o")
    @Expose
    private String widthO;
    @SerializedName("o_width")
    @Expose
    private String oWidth;
    @SerializedName("o_height")
    @Expose
    private String oHeight;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 
     * @return
     *     The secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * 
     * @param secret
     *     The secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * 
     * @return
     *     The server
     */
    public String getServer() {
        return server;
    }

    /**
     * 
     * @param server
     *     The server
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * 
     * @return
     *     The farm
     */
    public int getFarm() {
        return farm;
    }

    /**
     * 
     * @param farm
     *     The farm
     */
    public void setFarm(int farm) {
        this.farm = farm;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The ispublic
     */
    public int getIspublic() {
        return ispublic;
    }

    /**
     * 
     * @param ispublic
     *     The ispublic
     */
    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    /**
     * 
     * @return
     *     The isfriend
     */
    public int getIsfriend() {
        return isfriend;
    }

    /**
     * 
     * @param isfriend
     *     The isfriend
     */
    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    /**
     * 
     * @return
     *     The isfamily
     */
    public int getIsfamily() {
        return isfamily;
    }

    /**
     * 
     * @param isfamily
     *     The isfamily
     */
    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    /**
     * 
     * @return
     *     The originalsecret
     */
    public String getOriginalsecret() {
        return originalsecret;
    }

    /**
     * 
     * @param originalsecret
     *     The originalsecret
     */
    public void setOriginalsecret(String originalsecret) {
        this.originalsecret = originalsecret;
    }

    /**
     * 
     * @return
     *     The originalformat
     */
    public String getOriginalformat() {
        return originalformat;
    }

    /**
     * 
     * @param originalformat
     *     The originalformat
     */
    public void setOriginalformat(String originalformat) {
        this.originalformat = originalformat;
    }

    /**
     * 
     * @return
     *     The urlQ
     */
    public String getUrlQ() {
        return urlQ;
    }

    /**
     * 
     * @param urlQ
     *     The url_q
     */
    public void setUrlQ(String urlQ) {
        this.urlQ = urlQ;
    }

    /**
     * 
     * @return
     *     The heightQ
     */
    public String getHeightQ() {
        return heightQ;
    }

    /**
     * 
     * @param heightQ
     *     The height_q
     */
    public void setHeightQ(String heightQ) {
        this.heightQ = heightQ;
    }

    /**
     * 
     * @return
     *     The widthQ
     */
    public String getWidthQ() {
        return widthQ;
    }

    /**
     * 
     * @param widthQ
     *     The width_q
     */
    public void setWidthQ(String widthQ) {
        this.widthQ = widthQ;
    }

    /**
     * 
     * @return
     *     The urlN
     */
    public String getUrlN() {
        return urlN;
    }

    /**
     * 
     * @param urlN
     *     The url_n
     */
    public void setUrlN(String urlN) {
        this.urlN = urlN;
    }

    /**
     * 
     * @return
     *     The heightN
     */
    public int getHeightN() {
        return heightN;
    }

    /**
     * 
     * @param heightN
     *     The height_n
     */
    public void setHeightN(int heightN) {
        this.heightN = heightN;
    }

    /**
     * 
     * @return
     *     The widthN
     */
    public String getWidthN() {
        return widthN;
    }

    /**
     * 
     * @param widthN
     *     The width_n
     */
    public void setWidthN(String widthN) {
        this.widthN = widthN;
    }

    /**
     *
     * @return
     *     The urlC
     */
    public String getUrlC() {
        return urlC;
    }

    /**
     *
     * @param urlC
     *     The url_c
     */
    public void setUrlC(String urlC) {
        this.urlC = urlC;
    }

    /**
     *
     * @return
     *     The heightC
     */
    public int getHeightC() {
        return heightC;
    }

    /**
     *
     * @param heightC
     *     The height_c
     */
    public void setHeightC(int heightC) {
        this.heightC = heightC;
    }

    /**
     *
     * @return
     *     The widthC
     */
    public String getWidthC() {
        return widthC;
    }

    /**
     *
     * @param widthC
     *     The width_c
     */
    public void setWidthC(String widthC) {
        this.widthC = widthC;
    }

    /**
     * 
     * @return
     *     The urlH
     */
    public String getUrlH() {
        return urlH;
    }

    /**
     * 
     * @param urlH
     *     The url_h
     */
    public void setUrlH(String urlH) {
        this.urlH = urlH;
    }

    /**
     * 
     * @return
     *     The heightH
     */
    public int getHeightH() {
        return heightH;
    }

    /**
     * 
     * @param heightH
     *     The height_h
     */
    public void setHeightH(int heightH) {
        this.heightH = heightH;
    }

    /**
     * 
     * @return
     *     The widthH
     */
    public String getWidthH() {
        return widthH;
    }

    /**
     * 
     * @param widthH
     *     The width_h
     */
    public void setWidthH(String widthH) {
        this.widthH = widthH;
    }

    /**
     * 
     * @return
     *     The urlO
     */
    public String getUrlO() {
        return urlO;
    }

    /**
     * 
     * @param urlO
     *     The url_o
     */
    public void setUrlO(String urlO) {
        this.urlO = urlO;
    }

    /**
     * 
     * @return
     *     The heightO
     */
    public String getHeightO() {
        return heightO;
    }

    /**
     * 
     * @param heightO
     *     The height_o
     */
    public void setHeightO(String heightO) {
        this.heightO = heightO;
    }

    /**
     * 
     * @return
     *     The widthO
     */
    public String getWidthO() {
        return widthO;
    }

    /**
     * 
     * @param widthO
     *     The width_o
     */
    public void setWidthO(String widthO) {
        this.widthO = widthO;
    }

    /**
     * 
     * @return
     *     The oWidth
     */
    public String getOWidth() {
        return oWidth;
    }

    /**
     * 
     * @param oWidth
     *     The o_width
     */
    public void setOWidth(String oWidth) {
        this.oWidth = oWidth;
    }

    /**
     * 
     * @return
     *     The oHeight
     */
    public String getOHeight() {
        return oHeight;
    }

    /**
     * 
     * @param oHeight
     *     The o_height
     */
    public void setOHeight(String oHeight) {
        this.oHeight = oHeight;
    }

}
