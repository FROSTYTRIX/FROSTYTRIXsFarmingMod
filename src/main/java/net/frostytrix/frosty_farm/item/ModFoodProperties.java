package net.frostytrix.frosty_farm.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(3).saturationModifier(0.35f).build();
    public static final FoodProperties COFFEE_BERRIES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build();
    public static final FoodProperties COFFEE_MUG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.15f)
            .alwaysEdible().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300), 1).build();
}
