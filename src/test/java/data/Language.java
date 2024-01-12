package data;

public enum Language {
    ENGLISH("Welcome to Wikipedia"),
    DEUTSCH("Willkommen bei Wikipedia");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}
