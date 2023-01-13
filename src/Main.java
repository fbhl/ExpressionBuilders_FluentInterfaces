public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment(3, 68, 499, 100);
        System.out.println(apartment);
        apartment.description("Beautiful apartment in the country with balcony");
        System.out.println(apartment);
        apartment.petsAllowed(false);
        System.out.println(apartment);
    }
}