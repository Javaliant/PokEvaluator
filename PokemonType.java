import java.util.HashMap;

/*
 * Created by Luigi on 9/8/2014.
 */

public class PokemonType {
    String name;
    HashMap<Element, Double> multipliers = new HashMap<Element, Double>();

    PokemonType(Builder p) {
        name = p.name; multipliers = p.multipliers;
    }

    static class Builder {
        final String name;
        HashMap<Element, Double> multipliers = new HashMap<Element, Double>();

        public Builder(Element element) {
        	this.name = element.name;
        	// Default values
            for (Element e : Element.values()) {
                multipliers.put(e, 1.0);
            }
        }

        public Builder vulnerableTo(Element... elements) {
            for (Element e : elements) { multipliers.put(e, 2.0); }
            return this;
        }
        public Builder immuneTo(Element... elements) {
            for (Element e : elements) { multipliers.put(e, 0.0); }
            return this;
        }
        public Builder resistantTo(Element... elements) {
            for (Element e : elements) { multipliers.put(e, 0.5); }
            return this;
        }
        public PokemonType generate() { return new PokemonType(this); }
    } // End of Builder

    public HashMap<Element, Double> getMultipliers() {
    	return this.multipliers;
    }
} // End of PokemonType
