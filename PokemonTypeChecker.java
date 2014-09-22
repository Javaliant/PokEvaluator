/* Author: Luigi Vincent
Created on 9/8/2014
 */

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PokemonTypeChecker {

    static PokemonType normal = new PokemonType.Builder(Element.NORMAL)
            .vulnerableTo(Element.FIGHTING).immuneTo(Element.GHOST).generate();

    static PokemonType fire = new PokemonType.Builder(Element.FIRE)
            .vulnerableTo(Element.WATER, Element.GROUND, Element.ROCK)
            .resistantTo(Element.FIRE, Element.GRASS, Element.ICE,
                    Element.BUG, Element.STEEL, Element.FAIRY)
            .generate();

    static PokemonType water = new PokemonType.Builder(Element.WATER)
            .vulnerableTo(Element.ELECTRIC, Element.GRASS)
            .resistantTo(Element.FIRE, Element.WATER, Element.ICE, Element.STEEL)
            .generate();

    static PokemonType electric = new PokemonType.Builder(Element.ELECTRIC)
            .resistantTo(Element.ELECTRIC, Element.STEEL, Element.FLYING)
            .vulnerableTo(Element.GROUND).generate();

    static PokemonType grass = new PokemonType.Builder(Element.GRASS)
            .resistantTo(Element.GRASS, Element.WATER, Element.GROUND, Element.ELECTRIC)
            .vulnerableTo(Element.FIRE, Element.ICE,
                    Element.POISON, Element.FLYING, Element.BUG)
            .generate();

    static PokemonType ice = new PokemonType.Builder(Element.ICE)
            .vulnerableTo(Element.FIRE, Element.STEEL, Element.ROCK, Element.FIGHTING)
            .resistantTo(Element.ICE).generate();

    static PokemonType fighting = new PokemonType.Builder(Element.FIGHTING)
            .vulnerableTo(Element.PSYCHIC, Element.FLYING, Element.FAIRY)
            .resistantTo(Element.BUG, Element.ROCK, Element.DARK)
            .generate();

    static PokemonType poison = new PokemonType.Builder(Element.POISON)
            .resistantTo(Element.GRASS, Element.FIGHTING, Element.POISON,
                    Element.BUG, Element.FAIRY)
            .vulnerableTo(Element.GROUND, Element.PSYCHIC).generate();

    static PokemonType ground = new PokemonType.Builder(Element.GROUND)
            .resistantTo(Element.POISON, Element.ROCK)
            .vulnerableTo(Element.WATER, Element.GRASS, Element.ICE)
            .immuneTo(Element.ELECTRIC).generate();

    static PokemonType flying = new PokemonType.Builder(Element.FLYING)
            .resistantTo(Element.GRASS, Element.FIGHTING, Element.BUG)
            .vulnerableTo(Element.ELECTRIC, Element.ICE, Element.ROCK)
            .immuneTo(Element.GROUND).generate();

    static PokemonType psychic = new PokemonType.Builder(Element.PSYCHIC)
            .vulnerableTo(Element.BUG, Element.DARK, Element.GHOST)
            .resistantTo(Element.FIGHTING, Element.PSYCHIC).generate();

    static PokemonType bug = new PokemonType.Builder(Element.BUG)
            .vulnerableTo(Element.FIRE, Element.FLYING, Element.ROCK)
            .resistantTo(Element.GRASS, Element.FIGHTING, Element.GROUND)
            .generate();

    static PokemonType rock = new PokemonType.Builder(Element.ROCK)
            .vulnerableTo(Element.WATER, Element.GRASS, Element.FIGHTING,
                    Element.GROUND, Element.STEEL)
            .resistantTo(Element.NORMAL, Element.FIRE, Element.POISON, Element.FLYING)
            .generate();

    static PokemonType ghost = new PokemonType.Builder(Element.GHOST)
            .vulnerableTo(Element.GHOST, Element.DARK)
            .resistantTo(Element.BUG, Element.POISON)
            .immuneTo(Element.NORMAL, Element.FIGHTING)
            .generate();

    static PokemonType dragon = new PokemonType.Builder(Element.DRAGON)
            .vulnerableTo(Element.ICE, Element.DRAGON, Element.FAIRY)
            .resistantTo(Element.WATER, Element.FIRE, Element.ELECTRIC, Element.GRASS)
            .generate();

    static PokemonType dark = new PokemonType.Builder(Element.DARK)
            .vulnerableTo(Element.FIGHTING, Element.BUG, Element.FAIRY)
            .resistantTo(Element.GHOST, Element.DARK)
            .immuneTo(Element.PSYCHIC).generate();

    static PokemonType steel = new PokemonType.Builder(Element.STEEL)
            .vulnerableTo(Element.FIRE, Element.FIGHTING, Element.GROUND)
            .resistantTo(Element.NORMAL, Element.GRASS, Element.ICE, Element.FLYING,
                    Element.PSYCHIC, Element.BUG, Element.ROCK, Element.DRAGON,
                    Element.STEEL, Element.FAIRY)
            .immuneTo(Element.POISON).generate();

    static PokemonType fairy = new PokemonType.Builder(Element.FAIRY)
            .vulnerableTo(Element.STEEL, Element.POISON)
            .resistantTo(Element.FIGHTING, Element.DARK, Element.BUG)
            .immuneTo(Element.DRAGON).generate();

    static PokemonType none = new PokemonType.Builder(Element.NONE).generate();

    static ArrayList<PokemonType> pokemonTypes = new ArrayList<>(Arrays.asList(normal,
            fighting, flying, fire, water, electric, grass, bug, poison, steel, ground,
            rock, ice, dragon, fairy, psychic, dark, ghost, none));

    static JPanel immunities = new JPanel(), resistances = new JPanel(),
            vulnerabilities = new JPanel(), majorVulnerabilities = new JPanel(),
            majorResistances = new JPanel();


    static JFrame frame = new JFrame("Pokevaluator");
    static JPanel selectionPanel = new JPanel(), result = new JPanel(), widener = new JPanel();

    static JLabel immunityLabel = new JLabel("Immunity to:"),
            resistanceLabel = new JLabel("Resistance to:"),
            vulnerabilityLabel = new JLabel("Vulnerability to:"),
            majorVulnLabel = new JLabel("Extreme Vulnerability to:"),
            majorResistLabel = new JLabel("Strong resistance to:");

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        widener.setPreferredSize(new Dimension(208, 0));
        result.setLayout(new GridLayout());

        immunityLabel.setToolTipText("No damage will be taken");
        resistanceLabel.setToolTipText("These will only inflict half damage");
        vulnerabilityLabel.setToolTipText("Damage will be doubled from these sources");
        majorResistLabel.setToolTipText("These will only do a fourth of the damage");
        majorVulnLabel.setToolTipText("These will inflict four times the damage!");

        JComboBox<ImageIcon> typeList = new JComboBox<ImageIcon>();
        JComboBox<ImageIcon> typeList2 = new JComboBox<ImageIcon>();

        JLabel helpMessage = new JLabel("To begin: set the pokemon's type below");
        result.add(helpMessage, SwingConstants.CENTER);

        for (Element e : Element.values()) {
            typeList.addItem(e.icon);
            typeList2.addItem(e.icon);
        }

        typeList.setSelectedItem(Element.NORMAL.icon);

        ItemListener typeListener = e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                displayAttributes(getPokemonType((ImageIcon)typeList.getSelectedItem()),
                        getPokemonType((ImageIcon)typeList2.getSelectedItem())
                );
            }
        };

        typeList.addItemListener(typeListener);
        typeList2.addItemListener(typeListener);

        selectionPanel.add(typeList);
        selectionPanel.add(typeList2);

        frame.add(widener, BorderLayout.NORTH);
        frame.add(result, BorderLayout.CENTER);
        frame.add(selectionPanel, BorderLayout.SOUTH);
        frame.setIconImage(new ImageIcon("Images/Icon.png").getImage());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void displayAttributes(PokemonType primary, PokemonType secondary) {
        if (primary == secondary) { secondary = none; }
        result.setLayout(new GridLayout(0, 2, 0, 2));
        result.removeAll();
        immunities.removeAll();
        vulnerabilities.removeAll();
        majorVulnerabilities.removeAll();
        majorResistances.removeAll();
        resistances.removeAll();

        for(Map.Entry<Element, Double> entry : primary.getMultipliers().entrySet()){
            for(Map.Entry<Element, Double> entry2 : secondary.getMultipliers().entrySet()) {
                if (entry.getKey() == entry2.getKey()) {
                    if (entry.getValue() * entry2.getValue() == 0.0) {
                        immunities.add(new JLabel(entry.getKey().icon));
                    }
                    else if (entry.getValue() * entry2.getValue()  == 0.5 ) {
                        resistances.add(new JLabel(entry.getKey().icon));
                    }
                    else if (entry.getValue() * entry2.getValue()  == 2.0) {
                        vulnerabilities.add(new JLabel(entry.getKey().icon));
                    }
                    else if (entry.getValue() * entry2.getValue()  == 4.0) {
                       majorVulnerabilities.add(new JLabel(entry.getKey().icon));
                    }
                    else if (entry.getValue() * entry2.getValue()  == 0.25) {
                        majorResistances.add(new JLabel(entry.getKey().icon));
                    }
                }
            }
        }

        if (immunities.getComponents().length > 0) {
            result.add(immunityLabel);
            result.add(immunities);
       }
        if (majorResistances.getComponents().length > 0) {
            result.add(majorResistLabel);
            result.add(majorResistances);
        }
        if (resistances.getComponents().length > 0) {
            result.add(resistanceLabel);
            result.add(resistances);
        }
        if (vulnerabilities.getComponents().length > 0) {
            result.add(vulnerabilityLabel);
            result.add(vulnerabilities);
        }
        if (majorVulnerabilities.getComponents().length > 0) {
            result.add(majorVulnLabel);
            result.add(majorVulnerabilities);
        }
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    public static PokemonType getPokemonType(ImageIcon icon) {
        for (PokemonType p : pokemonTypes) {
            if (p.element.icon == icon) {
                return p;
            }
        }
        return none; // should never be the case
    }
}
