// Kelas Plant
class Plant {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plant(String name) {
        this.name = name;
    }
}

class Farmer {
    private String name;
    private String favourite;

    public String getName() {
        return name;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public void setFavourite(String favourite) { 
        this.favourite = favourite;
    }

    public Farmer(String name, String favourite) {
        this.name = name;
        this.favourite = favourite;
    }
}

public class Mainn {
    public static void main(String[] args) {
        Plant padi = new Plant("Padi");
        Farmer andi = new Farmer("Andi", padi.getName());

        System.out.println("Nama Petani: " + andi.getName());
        System.out.println("Tanaman Favorit: " + andi.getFavourite());

        andi.setFavourite("Jagung");
        System.out.println("Tanaman Favorit Baru: " + andi.getFavourite());
    }
}
