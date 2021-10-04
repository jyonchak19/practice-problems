package BASICLanguage;

public class Token {
    private String type; // "integer", "add", "subtract"
    private String value;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void print() {
        System.out.println(type + " : " + value);
    }
}
