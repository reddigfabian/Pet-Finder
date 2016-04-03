
package test.fabianreddig.flickertestproject.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("url_n")
    @Expose
    private String urlN;
    @SerializedName("height_n")
    @Expose
    private String heightN;
    @SerializedName("width_n")
    @Expose
    private String widthN;
    @SerializedName("url_h")
    @Expose
    private String urlH;
    @SerializedName("height_h")
    @Expose
    private String heightH;
    @SerializedName("width_h")
    @Expose
    private String widthH;

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
    public String getHeightN() {
        return heightN;
    }

    /**
     * 
     * @param heightN
     *     The height_n
     */
    public void setHeightN(String heightN) {
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
    public String getHeightH() {
        return heightH;
    }

    /**
     * 
     * @param heightH
     *     The height_h
     */
    public void setHeightH(String heightH) {
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

}
