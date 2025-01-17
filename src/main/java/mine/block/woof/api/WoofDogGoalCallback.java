/*
 * Copyright (C) 2022 mineblock11 <https://github.com/mineblock11>
 *
 * All code in Wolves Of Other Furs is licensed under the Academic Free License version 3.0
 */

package mine.block.woof.api;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.passive.WolfEntity;

/**
 * An event callback that allows you to register custom goals to wolves.
 */
public interface WoofDogGoalCallback {
    Event<WoofDogGoalCallback> EVENT = EventFactory.createArrayBacked(WoofDogGoalCallback.class, (listeners) -> (goalSelector, wolfEntity) -> {
        for (WoofDogGoalCallback listener : listeners) {
            listener.registerGoal(goalSelector, wolfEntity);
        }
    });

    void registerGoal(GoalSelector goalSelector, WolfEntity wolfEntity);
}
