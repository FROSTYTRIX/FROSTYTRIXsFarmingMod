package net.frostytrix.frosty_farm.datagen;

import net.frostytrix.frosty_farm.FrostyFarm;
import net.frostytrix.frosty_farm.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.COFFEE_MUG.get())
                .pattern(" C ")
                .pattern(" U ")
                .define('C', ModItems.ROASTED_COFFEE_BEANS.get())
                .define('U', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.COFFEE_MUG.get()), has(ModItems.COFFEE_MUG.get()))
                .save(pRecipeOutput);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COFFEE_BERRIES.get()),RecipeCategory.FOOD , ModItems.ROASTED_COFFEE_BEANS.get(), 0.15f, 200)
                .unlockedBy(getHasName(ModItems.COFFEE_BERRIES.get()), has(ModItems.COFFEE_BERRIES.get())).save(pRecipeOutput);
    }
}
