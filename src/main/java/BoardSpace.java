public class BoardSpace {

    private static final String[] valid_types = {"double_letter","double_word","triple_letter", "triple_word", "plain"};

    private String type = "plain";
    private String value = null;
    private boolean occupied = false;

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
        if (value != null){
            this.occupied = true;
        }
    }

    public String getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

}

