package kodlama.io.devs.core.enums;

public enum LanguageMesageEnum {

    NOTNULL(1,"Programming Language cannot be empty"),
    ALREADYEXIST(2,"Programming Language is already exist");

    private final int code;
    private final String message;

    LanguageMesageEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
