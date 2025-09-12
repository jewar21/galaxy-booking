package com.marsbooking.domain.passenger;

public class Passenger {
    private String name;
    private String document;
    private String phone;
    private int age;
    private String nationality;

    public Passenger() {
    }

    public Passenger(String name, String document, String phone, int age, String nationality) {
        setName(name);
        setDocument(document);
        setPhone(phone);
        setAge(age);
        setNationality(nationality);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío o nulo");
        }
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        if (document != null && !document.trim().isEmpty()) {
            this.document = document;
        } else {
            throw new IllegalArgumentException("El documento no puede estar vacío o nulo");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("El teléfono no puede estar vacío o nulo");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality != null && !nationality.trim().isEmpty()) {
            this.nationality = nationality;
        } else {
            throw new IllegalArgumentException("La nacionalidad no puede estar vacía o nula");
        }
    }

}
