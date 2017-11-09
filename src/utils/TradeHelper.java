package utils;

public class TradeHelper {
    String id;
    Object object;

    public TradeHelper(String id, Object object) {
        this.id = id;
        this.object = object;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
}
