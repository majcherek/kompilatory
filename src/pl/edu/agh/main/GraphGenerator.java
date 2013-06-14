package pl.edu.agh.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import net.sourceforge.plantuml.SourceStringReader;
import pl.edu.agh.elements.Class;
import pl.edu.agh.elements.Field;
import pl.edu.agh.elements.Method;

public class GraphGenerator {

	private String source;
	private StringBuilder sourceB;
	private String fileName;
	private OutputStream png = null;

	public GraphGenerator(String fileName) {
		sourceB = new StringBuilder("@startuml\n");
		this.fileName = fileName;
	}

	public void generate(List<Class> classList) throws GraphException {
		// set up output
		try {
			png = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// generate graph code
		for (Class c : classList) {
			// extends
			String parentClass;
			if (c.isInterface)
				parentClass = ("Interface " + c.getParentClass());
			else
				parentClass = c.getParentClass();
			if (parentClass != null)
				sourceB.append(parentClass + "<|--" + c.getName() + "\n");
			// implements
			for (String interf : c.getInterfaces()) {
				sourceB.append("Interface " + interf);
				sourceB.append("<|.." + c.getName() + "\n");
			}
			// fields
			for (Field f : c.getFields()) {

				// sourceB.append(getModifiersString(f.getModifiers()));
				sourceB.append(c.getName() + ": "
						+ getModifiersString(f.getModifiers()) + f.getType()
						+ " " + f.getName() + "\n");
				if (isClassOnList(f.getType(), classList)) {
					sourceB.append(f.getType() + "--" + c.getName() + "\n");
				}
			}
			// methods
			for (Method m : c.getMethods()) {
				sourceB.append(c.getName() + ": "
						+ getModifiersString(m.getModifiers())
						+ m.getReturnType() + " " + m.getName() + "()\n");

			}
		}
		sourceB.append("@enduml\n");
		source = sourceB.toString();
		String desc = null;
		SourceStringReader reader = new SourceStringReader(source);
		try {
			desc = reader.generateImage(png);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(source);
		if (desc == null)
			throw new GraphException();

	}

	private String getModifiersString(List<String> modifiers) {
		StringBuilder modStr = new StringBuilder();
		if (modifiers.contains("public"))
			modStr.append("+");
		else if (modifiers.contains("private"))
			modStr.append("-");
		else if (modifiers.contains("protected"))
			modStr.append("#");
		else
			modStr.append("~");

		if (modifiers.contains("static"))
			modStr.append("{static}");
		if (modifiers.contains("abstract"))
			modStr.append("{abstract}");
		return modStr.toString();
	}

	private boolean isClassOnList(String type, List<Class> classList) {
		Iterator<Class> it = classList.iterator();
		while (it.hasNext()) {
			if (it.next().getName().equals(type))
				return true;
		}

		return false;
	}
}
