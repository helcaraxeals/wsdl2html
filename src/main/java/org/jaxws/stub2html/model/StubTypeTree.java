package org.jaxws.stub2html.model;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p> A tree-like structure indicating the inheritance of java classes involved in
 * the stubs </p>
 * 
 * <p>  <b>Important</b>: B.class is considered the child type of A.class, if and
 * only if: </p>
 * 	<p>1. A.class is assignable from B.class in terms of Java language</p>
 * 	<p>2. and A.class is annotated as @XmlSeeAlso(B.class) </p>
 * 
 * 
 * @author chenjianjx
 * 
 */
public class StubTypeTree {

	private Class<?> type;

	private Set<StubTypeTree> children = new LinkedHashSet<StubTypeTree>();

	private StubTypeTree parent;

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public Set<StubTypeTree> getChildren() {
		return children;
	}

	public void addChild(StubTypeTree child) {
		children.add(child);
	}

	public StubTypeTree getParent() {
		return parent;
	}

	public void setParent(StubTypeTree parent) {
		this.parent = parent;
		parent.addChild(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StubTypeTree other = (StubTypeTree) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
