package ml.kit.primitive.str;

public interface Translator<g,h> extends Reader<g> {

	h translate(g obj);

}
