package pe.edu.unsaac.in.qillqana.client.android.commands;

import java.util.Map;

public class Command {
    private String name;
    private Map<String,Object> parameters;

    public Command() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(String key,Object value){
        parameters.put(key,value);
    }
}
