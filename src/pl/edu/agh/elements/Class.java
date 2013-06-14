package pl.edu.agh.elements;

import java.util.ArrayList;
import java.util.List;

public class Class {

	public boolean isInterface;

	private String name;
	private String modifier;
	private List<Field> fields;
	private List<Method> methods;
	private String parentClass;
	private List<String> interfaces;

	public Class() {
		fields = new ArrayList<Field>();
		methods = new ArrayList<Method>();
		interfaces = new ArrayList<String>();
		isInterface = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public String getParentClass() {
		return parentClass;
	}

	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

	public List<String> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<String> interfaces) {
		this.interfaces = interfaces;
	}

	public void addField(Field field) {
		fields.add(field);

	}

	public void addMethod(Method method) {
		methods.add(method);
	}

	public void addInterface(String interfaceName) {
		interfaces.add(interfaceName);

	}

}
