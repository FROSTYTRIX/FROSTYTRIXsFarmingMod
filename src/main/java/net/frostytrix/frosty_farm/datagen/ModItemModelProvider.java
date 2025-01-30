package net.frostytrix.frosty_farm.datagen;

import net.frostytrix.frosty_farm.FrostyFarm;
import net.frostytrix.frosty_farm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FrostyFarm.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.COFFEE_MUG.get());
        basicItem(ModItems.TOMATO_SEEDS.get());
        basicItem(ModItems.COFFEE_BERRIES.get());
        basicItem(ModItems.ROASTED_COFFEE_BEANS.get());
    }
}
