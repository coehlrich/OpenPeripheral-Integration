package openperipheral.integration.thaumcraft;

import openperipheral.api.adapter.Asynchronous;
import openperipheral.api.adapter.IPeripheralAdapter;
import openperipheral.api.adapter.method.ReturnType;
import openperipheral.api.adapter.method.ScriptCallable;
import thaumcraft.api.nodes.INode;
import thaumcraft.api.nodes.NodeModifier;
import thaumcraft.api.nodes.NodeType;

@Asynchronous
public class AdapterNode implements IPeripheralAdapter {
	private static final String NONE = "NONE";

	@Override
	public Class<?> getTargetClass() {
		return INode.class;
	}

	@Override
	public String getSourceId() {
		return "thaumcraft_node";
	}

	@ScriptCallable(returnTypes = ReturnType.STRING, description = "Get the type of the node")
	public String getNodeType(INode node) {
		NodeType nodeType = node.getNodeType();
		return (nodeType != null? nodeType.name() : NONE);
	}

	@ScriptCallable(returnTypes = ReturnType.STRING, description = "Get the modifier of the node")
	public String getNodeModifier(INode node) {
		NodeModifier nodeModifier = node.getNodeModifier();
		return (nodeModifier != null? nodeModifier.name() : NONE);
	}
}
