package com.aranibar.homeservice.viewcontrollers.models;

public class Customer {
    private int id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String imgURL;
    private String dni;
    private String description;
    private String numberPhone;
    private String address;
    private float latitude;
    private float longitude;
    private float rate;
    private Specialty specialty;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer(int id, String name, String lastName, String imgURL, String dni, String description,
                    String numberPhone, String address, float latitude, float longitude, float rate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.imgURL = imgURL;
        this.dni = dni;
        this.description = description;
        this.numberPhone = numberPhone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rate = rate;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getDni() {
        return dni;
    }

    public String getDescription() {
        return description;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getRate() {
        return rate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /*
    public static class Builder {
        Specialist specialist;
        List<Specialist> specialistList;

        public Builder() {
        }

        public Builder(Specialist specialist) {
            this.specialist = specialist;
        }

        public Builder(List<Specialist> specialistList) {
            this.specialistList = specialistList;
        }

        public Specialist build() {
            return specialist;
        }

        public List<Specialist> buildAll() {
            return specialistList;
        }

        public static Builder from(JSONObject jsonSpecialist) {
            try {
                return new Builder(new Specialist(
                        jsonSpecialist.getInt("specialistId"),
                        jsonSpecialist.getString("specialistLogin"),
                        jsonSpecialist.getString("specialistPassword"),
                        jsonSpecialist.getString("specialistNames"),
                        jsonSpecialist.getString("specialistLastnames"),
                        jsonSpecialist.getString("specialistCompanyName"),
                        jsonSpecialist.getString("specialistDescription"),
                        jsonSpecialist.getInt("specialistDocType"),
                        jsonSpecialist.getString("specialistDocNumber"),
                        jsonSpecialist.getString("specialistPhone"),
                        jsonSpecialist.getString("specialistFacebook"),
                        jsonSpecialist.getString("specialistWeb"),
                        jsonSpecialist.getString("specialistAddress"),
                        jsonSpecialist.getString("specialistReference"),
                        jsonSpecialist.getLong("specialistLatitude"),
                        jsonSpecialist.getLong("specialistLongitude"),
                        jsonSpecialist.getBoolean("specialistAcredited"),
                        jsonSpecialist.getBoolean("specialistMembership"),
                        jsonSpecialist.getLong("specialistRate"),
                        jsonSpecialist.getBoolean("specialistState"),
                        jsonSpecialist.getBoolean("specialistHidden")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonSpecialistList) {
            int length = jsonSpecialistList.length();
            List<Specialist> specialistList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    specialistList.add(Builder.from(jsonSpecialistList.getJSONObject(i)).build());
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(specialistList);
        }

        public static Builder from(Bundle bundle) {
            return new Builder(new Specialist(
                    bundle.getInt("specialistId"),
                    bundle.getString("specialistLogin"),
                    bundle.getString("specialistPassword"),
                    bundle.getString("specialistNames"),
                    bundle.getString("specialistLastnames"),
                    bundle.getString("specialistCompanyName"),
                    bundle.getString("specialistDescription"),
                    bundle.getInt("specialistDocType"),
                    bundle.getString("specialistDocNumber"),
                    bundle.getString("specialistPhone"),
                    bundle.getString("specialistFacebook"),
                    bundle.getString("specialistWeb"),
                    bundle.getString("specialistAddress"),
                    bundle.getString("specialistReference"),
                    bundle.getLong("specialistLatitude"),
                    bundle.getLong("specialistLongitude"),
                    bundle.getBoolean("specialistAcredited"),
                    bundle.getBoolean("specialistMembership"),
                    bundle.getLong("specialistRate"),
                    bundle.getBoolean("specialistState"),
                    bundle.getBoolean("specialistHidden")
            ));
        }
    }

     */
}

