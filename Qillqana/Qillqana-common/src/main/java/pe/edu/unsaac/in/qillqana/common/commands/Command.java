package pe.edu.unsaac.in.qillqana.common.commands;

import java.util.HashMap;
import java.util.Map;

public class Command {
	protected String name;
	protected Map<String, Object> parameters;
	
	public Command(){
		name="";
		parameters=new HashMap<>();
	}
	
	public Command(String name, Map<String, Object> parameters) {
		super();
		this.name = name;
		this.parameters = parameters;
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
		parameters.put(key, value);
	}
}
