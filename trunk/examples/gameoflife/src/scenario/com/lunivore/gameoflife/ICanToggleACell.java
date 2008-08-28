package com.lunivore.gameoflife;

import org.jbehave.scenario.PropertyBasedConfiguration;
import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.ScenarioFileLoader;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;

import com.lunivore.gameoflife.steps.GridSteps;

public class ICanToggleACell extends Scenario {

    public ICanToggleACell() {
        super(new GridSteps());
    }

    public ICanToggleACell(final ClassLoader classLoader) {
        super(new PropertyBasedConfiguration() {
            @Override
            public ScenarioFileLoader forDefiningScenarios() {
                return new ScenarioFileLoader(new UnderscoredCamelCaseResolver(), classLoader,
                        new PatternScenarioParser(this));
            }
        }, new GridSteps());
    }
}
