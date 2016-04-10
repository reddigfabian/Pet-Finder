package test.fabianreddig.petfinder.api.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Root(name = "petfinder")
public class Petfinder {

    public static final int SIZES_PER_IMG = 5;
    public static final String SIZE_PNT = "pnt"; //width = 60
    public static final String SIZE_FPM = "fpm"; //width = 95
    public static final String SIZE_X = "x"; //width = 500
    public static final String SIZE_PN = "pn"; //width = 300
    public static final String SIZE_T = "t"; //width = 50

    @Element(name="header", required = false)
    Header header;


    @Element(name="lastOffset", required = false)
    String lastOffset;


    @ElementList(name = "pets", required = false)
    List<Pet> pets;


    @Attribute(name="xsi", required = false)
    String xsi;


    @Attribute(name="noNamespaceSchemaLocation", required = false)
    String noNamespaceSchemaLocation;



    public Header getHeader() { return this.header; }
    public void setHeader(Header _value) { this.header = _value; }


    public String getLastOffset() { return this.lastOffset; }
    public void setLastOffset(String _value) { this.lastOffset = _value; }


    public List<Pet> getPets() { return this.pets; }
    public void setPets(List<Pet> _value) { this.pets = _value; }


    public String getXsi() { return this.xsi; }
    public void setXsi(String _value) { this.xsi = _value; }


    public String getNoNamespaceSchemaLocation() { return this.noNamespaceSchemaLocation; }
    public void setNoNamespaceSchemaLocation(String _value) { this.noNamespaceSchemaLocation = _value; }



    public static class Header {

        @Element(name="version", required = false)
        String version;


        @Element(name="timestamp", required = false)
        String timestamp;


        @Element(name="status", required = false)
        Status status;



        public String getVersion() { return this.version; }
        public void setVersion(String _value) { this.version = _value; }


        public String getTimestamp() { return this.timestamp; }
        public void setTimestamp(String _value) { this.timestamp = _value; }


        public Status getStatus() { return this.status; }
        public void setStatus(Status _value) { this.status = _value; }


    }

    public static class Status {

        @Element(name="code", required = false)
        String code;


        @Element(name="message", required = false)
        String message;



        public String getCode() { return this.code; }
        public void setCode(String _value) { this.code = _value; }


        public String getMessage() { return this.message; }
        public void setMessage(String _value) { this.message = _value; }


    }

    public static class Pet {

        @Element(name="id", required = false)
        String id;


        @Element(name="shelterId", required = false)
        String shelterId;


        @Element(name="shelterPetId", required = false)
        String shelterPetId;


        @Element(name="name", required = false)
        String name;


        @Element(name="animal", required = false)
        String animal;


        @ElementList(name = "breeds", required = false)
        List<Breeds> breeds;


        @Element(name="mix", required = false)
        String mix;


        @Element(name="age", required = false)
        String age;


        @Element(name="sex", required = false)
        String sex;


        @Element(name="size", required = false)
        String size;


        @ElementList(name = "options", required = false)
        List<String> options;


        @Element(name="description", required = false)
        String description;


        @Element(name="lastUpdate", required = false)
        String lastUpdate;


        @Element(name="status", required = false)
        String status;


        @Element(name="media", required = false)
        Media media;


        @Element(name="contact", required = false)
        Contact contact;

        List<HashMap<String, String>> images = new ArrayList<>();

        public String getId() { return this.id; }
        public void setId(String _value) { this.id = _value; }


        public String getShelterId() { return this.shelterId; }
        public void setShelterId(String _value) { this.shelterId = _value; }


        public String getShelterPetId() { return this.shelterPetId; }
        public void setShelterPetId(String _value) { this.shelterPetId = _value; }


        public String getName() { return this.name; }
        public void setName(String _value) { this.name = _value; }


        public String getAnimal() { return this.animal; }
        public void setAnimal(String _value) { this.animal = _value; }


        public List<Breeds> getBreeds() { return this.breeds; }
        public void setBreeds(List<Breeds> _value) { this.breeds = _value; }


        public String getMix() { return this.mix; }
        public void setMix(String _value) { this.mix = _value; }


        public String getAge() { return this.age; }
        public void setAge(String _value) { this.age = _value; }


        public String getSex() { return this.sex; }
        public void setSex(String _value) { this.sex = _value; }


        public String getSize() { return this.size; }
        public void setSize(String _value) { this.size = _value; }


        public List<String> getOptions() { return this.options; }
        public void setOptions(List<String> _value) { this.options = _value; }


        public String getDescription() { return this.description; }
        public void setDescription(String _value) { this.description = _value; }


        public String getLastUpdate() { return this.lastUpdate; }
        public void setLastUpdate(String _value) { this.lastUpdate = _value; }


        public String getStatus() { return this.status; }
        public void setStatus(String _value) { this.status = _value; }


        public Media getMedia() { return this.media; }
        public void setMedia(Media _value) { this.media = _value; }


        public Contact getContact() { return this.contact; }
        public void setContact(Contact _value) { this.contact = _value; }

        public List<HashMap<String, String>> getImages() {return images;}

        public void setImages(List<HashMap<String, String>> images) {this.images = images;}

        public String getContentDescription(){return getSex() + " " + getAnimal() + " named " + getName();}
    }

    public static class Media {

        @ElementList(name = "photos", entry = "photo", required = false)
        List<Photo> photos;

        public List<Photo> getPhotos() { return this.photos; }
        public void setPhotos(List<Photo> _value) { this.photos = _value; }


    }

    public static class Photo {

        @Text
        String url;

        @Attribute(name="id", required = false)
        String id;

        @Attribute(name="size", required = false)
        String size;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }

        public String getId() { return this.id; }
        public void setId(String _value) { this.id = _value; }


        public String getSize() { return this.size; }
        public void setSize(String _value) { this.size = _value; }


    }

    public static class Contact {

        @Element(name="address1", required = false)
        String address1;


        @Element(name="address2", required = false)
        String address2;


        @Element(name="city", required = false)
        String city;


        @Element(name="state", required = false)
        String state;


        @Element(name="zip", required = false)
        String zip;


        @Element(name="phone", required = false)
        String phone;


        @Element(name="fax", required = false)
        String fax;


        @Element(name="email", required = false)
        String email;



        public String getAddress1() { return this.address1; }
        public void setAddress1(String _value) { this.address1 = _value; }


        public String getAddress2() { return this.address2; }
        public void setAddress2(String _value) { this.address2 = _value; }


        public String getCity() { return this.city; }
        public void setCity(String _value) { this.city = _value; }


        public String getState() { return this.state; }
        public void setState(String _value) { this.state = _value; }


        public String getZip() { return this.zip; }
        public void setZip(String _value) { this.zip = _value; }


        public String getPhone() { return this.phone; }
        public void setPhone(String _value) { this.phone = _value; }


        public String getFax() { return this.fax; }
        public void setFax(String _value) { this.fax = _value; }


        public String getEmail() { return this.email; }
        public void setEmail(String _value) { this.email = _value; }


    }

    public static class Breeds {

        @Element(name="breed", required = false)
        String breed;



        public String getBreed() { return this.breed; }
        public void setBreed(String _value) { this.breed = _value; }


    }
}