public class Apartment {

    private int rooms;
    private double size;
    private double coldRental;
    private double serviceCharges;

    private boolean petsAllowed;
    private String description;

    // FLUENT INTERFACE

    public Apartment(int rooms, double size, double coldRental, double serviceCharges) {
        this.rooms = rooms;
        this.size = size;
        this.coldRental = coldRental;
        this.serviceCharges = serviceCharges;

        this.petsAllowed = true;
    }

    public Apartment petsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
        return this;
    }

    public Apartment description(String description) {
        this.description = description;
        return this;
    }

    public String toString() {
        return String.format("Apartment with %o rooms and a size of %f m2:\n" +
                "   Rental: %f (cold rental) + %f (service charges) = %f\n" +
                "   Description: %s\n" +
                "   petsAllowed: " + petsAllowed, rooms, size, coldRental, serviceCharges, coldRental + serviceCharges, description);
    }

    // EXPRESSION BUILDER
    static class ApartmentBuilder {
        private int rooms;
        private double size;
        private double coldRental;
        private double serviceCharges;
        private boolean petsAllowed;
        private String description;

        public ApartmentBuilder create(int rooms, double size, double coldRental, double serviceCharges) {
            this.rooms = rooms;
            this.size = size;
            this.coldRental = coldRental;
            this.serviceCharges = serviceCharges;

            this.petsAllowed = true;
            return this;
        }

        public ApartmentBuilder petsAllowed(boolean petsAllowed) {
            this.petsAllowed = petsAllowed;
            return this;
        }

        public ApartmentBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Apartment build() {
            return new Apartment(this);
        }
    }

    private Apartment(ApartmentBuilder builder) {
        this.rooms = builder.rooms;
        this.size = builder.size;
        this.coldRental = builder.coldRental;
        this.serviceCharges = builder.serviceCharges;

        this.petsAllowed = builder.petsAllowed;
        this.description = builder.description;
    }


}
