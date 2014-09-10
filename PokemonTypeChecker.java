/* Author: Luigi Vincent
Created on 9/8/2014
 */

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pokemon Type Checker");
        JPanel selectionPanel = new JPanel(), result = new JPanel();
        result.setLayout(new GridLayout(3, 2, 0, 2));

        JTextField immunities = new JTextField(15), resistances = new JTextField(15),
        vulnerabilities = new JTextField(15);
        immunities.setEditable(false);
        resistances.setEditable(false);
        vulnerabilities.setEditable(false);

        result.add(new JLabel("Immune to:"));
        result.add(immunities);
        result.add(new JLabel("Resistant to:"));
        result.add(resistances);
        result.add(new JLabel("Vulnerable to:"));
        result.add(vulnerabilities);

        JComboBox<ImageIcon> typeList = new JComboBox<ImageIcon>();
        JComboBox<ImageIcon> typeList2 = new JComboBox<ImageIcon>();

        for (Element e : Element.values()) {
            typeList.addItem(e.icon);
            typeList2.addItem(e.icon);
        }

        ItemListener typeListener = e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (e.getSource() == typeList) {
                    displayAttributes(fire, none);
                }
                else if (e.getSource() == typeList2) {
                    System.out.println("Source 2: " + e.toString());
                }
            }
        };
        
        typeList.addItemListener(typeListener);
        typeList2.addItemListener(typeListener);

        selectionPanel.add(typeList);
        selectionPanel.add(typeList2);

        frame.add(result, BorderLayout.CENTER);
        frame.add(selectionPanel, BorderLayout.SOUTH);
        frame.setIconImage(new ImageIcon("Images/Icon.png").getImage());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void displayAttributes(PokemonType primary, PokemonType secondary) {
        for(Map.Entry<Element, Double> entry : primary.getMultipliers().entrySet()){
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }
    }
}
