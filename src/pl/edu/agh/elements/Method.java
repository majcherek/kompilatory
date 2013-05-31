package pl.edu.agh.elements;
import java.util.ArrayList;
import java.util.List;


public class Method {
	
	private String name;
	private List<String> modifiers;
	private String returnType;
	
	public Method(){
		this.modifiers = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getModifiers() {
		return modifiers;
	}
	public void setModifier(List<String> modifiers) {
		this.modifiers = modifiers;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	public void addModifier(String modifier){
		modifiers.add(modifier);
	}
	
	

}
