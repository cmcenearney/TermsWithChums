public class BoardSpace {

    private static final String[] valid_types = {"double_letter","double_word","triple_letter", "triple_word", "plain"};

    private String type = "normal";
    private String value = null;

    public BoardSpace(){
    }

    // question: does it make sense to enforce validity of the type here?
    // and if so, how - exception? invalid defaults to normal?
    public BoardSpace(String type){
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

}

