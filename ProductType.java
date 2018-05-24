public enum ProductType {
    SWEATER("Свитер"),
    JEANS("Джинты"),
    SCARF("Шарф"),
    BOOTS("Ботинки");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
