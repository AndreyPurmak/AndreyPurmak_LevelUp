package API;

import API.EndpointsObject.Users.PeopleBodyObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject {

    private long code;
    private Object meta;
    private PeopleBodyObject customData;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public PeopleBodyObject getCustomData() {
        return customData;
    }

    public void setCustomData(PeopleBodyObject customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", meta=" + meta +
                ", Data=" + customData +
                '}';
    }
}