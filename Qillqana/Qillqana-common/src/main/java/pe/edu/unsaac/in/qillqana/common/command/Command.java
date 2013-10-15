package pe.edu.unsaac.in.qillqana.common.command;

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
	
	public Object getParameter(String key) {
		return parameters.get(key);
	}
	
	public void addParameter(String key,Object value){
		parameters.put(key, value);
	}
}
